package lucas.client.service.caixa;
import android.Manifest;
import android.app.*;
import android.content.*;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.*;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.*;
import androidx.core.content.ContextCompat;

import java.io.*;
import java.nio.channels.*;
import java.util.*;
import lucas.client.service.*;
import lucas.client.service.etc.*;
import lucas.client.service.mercearia.MerceariaMain;
import lucas.client.service.mercearia.databases.SQLiteControl;
import lucas.client.service.sqlite.*;

import static android.Manifest.permission.MANAGE_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class selfConfig extends AppCompatActivity
{
	ProgressDialog progress;
	Context c = this;
	private static final int PERMISSION_REQUEST_CODE = 200;
	private static final String TAG = "Permisssion";
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		progress = new ProgressDialog(c, R.style.dialog);
		progress.setTitle("Configuração do POS!");
		progress.setIcon(R.drawable.icon);
		progress.setCancelable(false);
		progress.setProgress(100);
		progress.setMessage("Iniciando Configuração do POS...");
		progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progress.show();
		new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						while (progress.getProgress() <= progress
							   .getMax()) {
							Thread.sleep(800);
							handle.sendMessage(handle.obtainMessage());
							if (progress.getProgress() == 10) {
								progress.setMessage("Checando Permissões...");
								if(checkPermission()){
									Thread.sleep(5000);
									progress.setMessage("Continuando Configuração do POS...");
								} else {
									requestPermission();
									progress.dismiss();
									finishAffinity();
									Thread.sleep(999999999);
								}
							}
							
							if(progress.getProgress() == 20){
								progress.setMessage("Importando dados do PDV");
								Thread.sleep(5000);
								try {
									File sd = Environment.getExternalStorageDirectory();
									File data = Environment.getDataDirectory();

									if (sd.canWrite()) {
										String  currentDBPath= "//data//" + c.getOpPackageName()
												+ "//databases//" + "myDB.db";
										String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db";

										String  currentDBPath2= "//data//" + c.getOpPackageName()
												+ "//databases//" + "MCRDB.db";
										String backupDBPath2  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db";

										File dbshm = new File(data, currentDBPath + "-shm");
										File dbwal = new File(data, currentDBPath + "-wal");
										if (dbshm.exists()) {
											dbshm.delete();
										}
										if (dbwal.exists()) {
											dbwal.delete();
										}
										File dbshm2 = new File(data, currentDBPath2 + "-shm");
										File dbwal2 = new File(data, currentDBPath2 + "-wal");
										if (dbshm2.exists()) {
											dbshm2.delete();
										}
										if (dbwal2.exists()) {
											dbwal2.delete();
										}
										File currentDB = new File(data, currentDBPath);
										File backupDB = new File(sd, backupDBPath);

										FileChannel src = new FileInputStream(backupDB).getChannel();
										FileChannel dst = new FileOutputStream(currentDB).getChannel();
										dst.transferFrom(src, 0, src.size());
										src.close();
										dst.close();

										File currentDB2 = new File(data, currentDBPath2);
										File backupDB2 = new File(sd, backupDBPath2);

										FileChannel src2 = new FileInputStream(backupDB2).getChannel();
										FileChannel dst2 = new FileOutputStream(currentDB2).getChannel();
										dst2.transferFrom(src2, 0, src2.size());
										src2.close();
										dst2.close();

										progress.setMessage("Banco de Dados Importado!");
									}
								} catch (Exception e) {
									progress.setMessage("Falha ao Importar SQLite!");
									Thread.sleep(2000);
									Intent launchIntent = getPackageManager().getLaunchIntentForPackage("lucas.client.service.pos.admin");
									if (launchIntent != null) {
										startActivity(launchIntent);//null pointer check in case package name was not found
									}
									progress.dismiss();
									Thread.sleep(99999999);
								}
							}
							if(progress.getProgress() == 30){
								progress.setMessage("Verificando a integridade do POS 1/2...");
								Thread.sleep(5000);

								try{
									DB db = new DB(c);
									util pag1 = db.getCategory(1);
									if(!pag1.getCategory().toString().equals("")){
										List<util> res = db.findP1();
										if(!res.get(0).getProd1().toString().equals("")){
											util user1 = db.getUserCM(1);
											util user2 = db.getUserMCR(1);
											util user3 = db.getSuperVisor(1);
											if(!user1.getUser().toString().equals("")){
												if(user2.getUser().toString().equals("")){
													if(user3.getSenhaSuperVisor().toString().equals("")){
														progress.setMessage("Verificação concluída!");
													} else {

													}
												} else {

												}
											} else {

											}
										} else {

										}
									} else {

									}
								} catch (Exception e){
									progress.setMessage("POS 1/2 Não configurado corretamente!");
									progress.cancel();
									progress.dismiss();
									Thread.sleep(999999999);
								}
							}
							if(progress.getProgress() == 40){
								progress.setMessage("Verificando a integridade do POS 2/2...");
								try{
									SQLiteControl db = new SQLiteControl(c);
									util pag1 = db.getCategory(1);
									if(!pag1.getCategory().toString().equals("")){
										List<util> res = db.findP1();
										if(!res.get(0).getProd1().toString().equals("")){
											util user2 = db.getUserMCR(1);
											if(!user2.getUser().toString().equals("")){
												progress.setMessage("Verificação Concluída!");
											} else {

											}
											} else {

											}
										} else {

										}
								} catch (Exception e){
									progress.setMessage("POS 1/2 Não configurado corretamente!");
									progress.cancel();
									progress.dismiss();
									Thread.sleep(999999999);
								}
							}
							if(progress.getProgress() == 50){
								progress.setMessage("Verificando se há vendas no POS 1/2");
								Thread.sleep(3000);
								DB db = new DB(c);
								try {
									List<util> res = db.moFind();
									if(!res.get(0).getMoney().toString().equals("")){
										progress.setMessage("Ops, há vendas em Aberto!");
										Thread.sleep(3000);
										startActivity(new Intent(c, caixaMain.class));
										Thread.sleep(9999999);
									} else {

									}
								} catch (Exception e){
									try{
										util venda = db.getVenda(1);
										if(!venda.getData().toString().equals("")){
											progress.setMessage("Ops! Tem venda Arquivada pra finalizar!");
											Intent it = new Intent(c, caixaMain.class);
											Bundle bun = new Bundle();
											String res = "1";
											bun.putString("chave2", res);
											it.putExtras(bun);
											startActivity(it);
											progress.cancel();
											Thread.sleep(999999999);
										}else {
										}
									} catch (Exception i){
										SQLiteControl d = new SQLiteControl(c);
										try {
											List<util> res = db.moFind();
											if(!res.get(0).getMoney().toString().equals("")){
												progress.setMessage("Ops, há vendas em Aberto!");
												Thread.sleep(3000);
												startActivity(new Intent(c, caixaMain.class));
												Thread.sleep(9999999);
											} else {

											}
										} catch(Exception e2){
											try{
												SQLiteControl sql = new SQLiteControl(c);
												util venda2 = sql.getVenda(1);
												if(!venda2.getData().toString().equals("")){
													progress.setMessage("Ops! Tem venda Arquivada pra finalizar!");
													Intent it = new Intent(c, MerceariaMain.class);
													Bundle bun = new Bundle();
													String res = "1";
													bun.putString("chave2", res);
													it.putExtras(bun);
													startActivity(it);
													progress.cancel();
													Thread.sleep(999999999);
												}else {
												}
											}catch (Exception i2){
												progress.setMessage("Não há vendas em Aberto!");
											}
										}
									}
							}
						}
							if(progress.getProgress() == 60){
								progress.setMessage("Executando Abertura do POS...");
								Thread.sleep(2000);
								progress.dismiss();
								progress.cancel();
								Intent itt = new Intent(c, Login.class);
								startActivity(itt);
								Thread.sleep(99999999);
							}
						}
					} catch (Exception e6) {
						e6.printStackTrace();
					}
				}
			}).start();
	}
	Handler handle = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			progress.incrementProgressBy(2);
		}
	};
	private void requestPermission(){
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
			try{

				Intent it = new Intent();
				it.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
				Uri uri = Uri.fromParts("package", this.getPackageName(), null);
				it.setData(uri);
				storageActivityResultLauncher.launch(it);
			}catch (Exception e){

				Intent it2 = new Intent();
				it2.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
				storageActivityResultLauncher.launch(it2);
			}
		} else {
			ActivityCompat.requestPermissions(selfConfig.this, new String[]{WRITE_EXTERNAL_STORAGE, MANAGE_EXTERNAL_STORAGE,  READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
		}
	}
	private ActivityResultLauncher<Intent> storageActivityResultLauncher =
			registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
					new ActivityResultCallback<ActivityResult>(){

						@Override
						public void onActivityResult(ActivityResult o) {
							if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
								//Android is 11 (R) or above
								if(Environment.isExternalStorageManager()){
									//Manage External Storage Permissions Granted

									Log.d(TAG, "onActivityResult: Manage External Storage Permissions Granted");
								}else{
									Toast.makeText(c, "Storage Permissions Denied", Toast.LENGTH_SHORT).show();
								}
							}else{
								//Below android 11

							}
						}
					});

	public boolean checkPermission(){
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
			return Environment.isExternalStorageManager();
		} else {
			int write = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
			int read = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

			return write == PackageManager.PERMISSION_GRANTED && read == PackageManager.PERMISSION_GRANTED;
		}

	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if(requestCode == PERMISSION_REQUEST_CODE){
			if(grantResults.length > 0){
				boolean write = grantResults[0] == PackageManager.PERMISSION_GRANTED;
				boolean read = grantResults[1] == PackageManager.PERMISSION_GRANTED;

				if(read && write){
					Toast.makeText(c, "Storage Permissions Granted", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(c, "Storage Permissions Denied", Toast.LENGTH_SHORT).show();
				}
			}
		}
	}
}
