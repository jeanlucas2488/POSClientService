package lucas.client.service.caixa;
import android.Manifest;
import android.app.*;
import android.content.*;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.*;
import android.provider.Settings;
import android.util.Log;
import android.view.*;
import android.widget.*;
import android.widget.Toolbar.*;
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
	protected void onCreate(Bundle savedInstanceState) {
		// TODO: Implement this method
		super.onCreate(savedInstanceState);

		Handler handler2 = new Handler();
		handler2.postDelayed(new Runnable() {
			public void run() {

				ScrollView sc = new ScrollView(c);
				LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
				pr.setMargins(10, 60, 10, 0);
				final LinearLayout root = new LinearLayout(c);
				sc.setLayoutParams(pr);
				root.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
				root.setOrientation(LinearLayout.VERTICAL);
				LinearLayout l1 = new LinearLayout(c);
				l1.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

				l1.setBackgroundColor(Color.BLUE);
				TextView tv1 = new TextView(c);
				LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
				pr1.setMargins(10, 40, 10, 0);
				tv1.setGravity(Gravity.CENTER_HORIZONTAL);
				tv1.setText("Configuração do POS" + "\n");
				tv1.setTextSize(20);
				tv1.setTextColor(Color.WHITE);
				//tv.setBackgroundResource(R.drawable.border);
				tv1.setLayoutParams(pr1);
				l1.addView(tv1);
				root.addView(l1);
				sc.addView(root);

				Handler hd = new Handler();
				hd.postDelayed(new Runnable(){
					public void run(){
						LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
						pr1.setMargins(10, 40, 10, 0);

						LinearLayout l2 = new LinearLayout(c);
						l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
						final TextView tv = new TextView(c);
						tv.setText("Checando Permissões..." + "\n");

						tv.setBackgroundResource(R.drawable.border);
						tv.setLayoutParams(pr1);
						l2.addView(tv);
						root.addView(l2);

						Handler hd2 = new Handler();
						hd2.postDelayed(new Runnable(){
							public void run(){
								LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
								pr1.setMargins(10, 30, 10, 0);

								LinearLayout l2 = new LinearLayout(c);
								l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
								final TextView tv = new TextView(c);

								if(checkPermission()){
									tv.setText("Permissão de SdCard Concedida!" + "\n");
									tv.setTextColor(Color.GREEN);
								}else {
									requestPermission();
									tv.setText("Permissão de SdCard Negada!" + "\n");
									tv.setTextColor(Color.RED);
								}
								tv.setBackgroundResource(R.drawable.border);
								tv.setLayoutParams(pr1);
								l2.addView(tv);
								root.addView(l2);

								Handler hd3 = new Handler();
								hd3.postDelayed(new Runnable(){
									public void run(){
										LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
										pr1.setMargins(10, 30, 10, 0);

										LinearLayout l2 = new LinearLayout(c);
										l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
										final TextView tv = new TextView(c);

										tv.setText("Criando diretórios do Sistema POS 1/4..." + "\n");

										File f = new File(Environment.getExternalStorageDirectory(), "pdvMain");
										f.exists();
										f.mkdir();

										if(f.canWrite()){
											Handler ha = new Handler();
											ha.postDelayed(new Runnable(){
												public void run(){
													tv.setText("Criando diretórios do Sistema POS 2/4..." + "\n");
													File f = new File(Environment.getExternalStorageDirectory(), "pdvMain/.sqlite");
													f.exists();
													f.mkdir();
													if(f.canWrite()){
														Handler hd4 = new Handler();
														hd4.postDelayed(new Runnable(){
															public void run(){
																Handler hd5 = new Handler();
																hd5.postDelayed(new Runnable(){
																	public void run(){
																		tv.setText("Criando diretórios do Sistema POS 3/4..." + "\n");

																		File f = new File(Environment.getExternalStorageDirectory(), "pdvMain/.Nfe");
																		f.exists();
																		f.mkdir();
																		if(f.canWrite()){
																			Handler hd6 = new Handler();
																			hd6.postDelayed(new Runnable(){
																				public void run(){
																					tv.setText("Criando diretórios do Sistema POS 4/4..." + "\n");

																					File f = new File(Environment.getExternalStorageDirectory(), "pdvMain/.fechamentos");
																					f.exists();
																					f.mkdir();
																					if(f.canWrite()){
																						Handler hd6 = new Handler();
																						hd6.postDelayed(new Runnable(){
																							public void run(){
																								LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
																								pr1.setMargins(10, 30, 10, 0);

																								LinearLayout l2 = new LinearLayout(c);
																								l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
																								final TextView tv = new TextView(c);

																								tv.setText("Concluído!" + "\n");

																								tv.setBackgroundResource(R.drawable.border);
																								tv.setLayoutParams(pr1);
																								l2.addView(tv);
																								root.addView(l2);

																								Handler hd6 = new Handler();
																								hd6.postDelayed(new Runnable(){
																									public void run(){
																										LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
																										pr1.setMargins(10, 30, 10, 0);

																										LinearLayout l2 = new LinearLayout(c);
																										l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
																										final TextView tv = new TextView(c);

																										tv.setText("Importando Banco de Dados 1/2..." + "\n");
																										Handler hd7 = new Handler();
																										hd7.postDelayed(new Runnable(){
																											public void run(){
																												try {
																													File sd = Environment.getExternalStorageDirectory();
																													File data = Environment.getDataDirectory();

																													if (sd.canWrite()) {
																														tv.setText("Banco de dados 1/2 Importado!" + "\n");
																														tv.setTextColor(Color.GREEN);
																														String  currentDBPath= "//data//" + c.getPackageName()
																																+ "//databases//" + "myDB.db";

																														String backupDBPath  = "pdvMain/.sqlite/myDB.db";

																														File currentDB = new File(data, currentDBPath);
																														File backupDB = new File(sd, backupDBPath);


																														FileChannel src = new FileInputStream(backupDB).getChannel();
																														FileChannel dst = new FileOutputStream(currentDB).getChannel();
																														dst.transferFrom(src, 0, src.size());
																														src.close();
																														dst.close();
																													} else {
																													}
																												} catch (Exception e2) {
																													tv.setText("Erro ao Importar Banco de dados 1/2!" + "\n");
																													tv.setTextColor(Color.RED);
																												}
																											}
																										}, 2000);
																										tv.setBackgroundResource(R.drawable.border);
																										tv.setLayoutParams(pr1);
																										l2.addView(tv);
																										root.addView(l2);
																										
																										Handler hd8 = new Handler();
																										hd8.postDelayed(new Runnable(){
																											public void run(){

																												LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
																												pr1.setMargins(10, 30, 10, 0);

																												LinearLayout l2 = new LinearLayout(c);
																												l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
																												final TextView tv = new TextView(c);

																												tv.setText("Verificando a Integridade do POS 1/2..." + "\n");

																												try{
																													DB db = new DB(c);

																													util root = db.getCategory(1);
																													if(!root.getCategory().equals("")){
																														Handler nb = new Hanler();
																														nb.postDelayed(new Runnable() {
																															@Override
																															public void run() {
																																tv.setText("Verificando se há produtos cadastrados no PDV 1/2...");
																																Handler nb2 = new Handler();
																																nb2.postDelayed(new Runnable() {
																																	@Override
																																	public void run() {
																																		try{
																																			DB b = new DB(c);
																																			List<util> result = b.findP1();

																																			if(!result.get(0).getP1().toString().equals("")){
																																				tv.setText("Verificando outros requisitos, aguarde...");
																																				Handler hd = new Handler();
																																				hd.postDelayed(new Runnable() {
																																					@Override
																																					public void run() {

																																					}
																																				}, 1000);
																																			} else {
																																			}
																																		} catch(Exception e){
																																			tv.setText("Não Há produtos cadastrados no PDV 1/2!");
																																			tv.setTextColor(Color.RED);
																																		}
																																	}
																																}, 1000);
																															}
																														}, 900);
																													} else{}
																												} catch(Exception e){
																													Handler nb = new Handler();
																													nb.postDelayed(new Runnable() {
																														@Override
																														public void run() {
																															tv.setText("Não foram adicionadas as Páginas do PDV 1/2!");
																															tv.setTextColor(Color.RED);
																														}
																													}, 900);
																												}
																												tv.setBackgroundResource(R.drawable.border);
																												tv.setLayoutParams(pr1);
																												l2.addView(tv);
																												root.addView(l2);
																											}
																										}, 2000);
																									}
																								}, 900);
																							}
																						}, 10000);
																					} else {
																						tv.setText("Erro ao Criar diretórios!" + "\n");
																						tv.setTextColor(Color.RED);
																					}
																				}
																			}, 1000);
																		} else {
																			tv.setText("Erro ao Criar diretórios!" + "\n");
																			tv.setTextColor(Color.RED);
																		}
																	}
																}, 1000);
															}
														}, 1000);
													} else {
														tv.setText("Erro ao Criar diretórios!" + "\n");
														tv.setTextColor(Color.RED);
													}
												}
											}, 1000);
										} else {
											tv.setText("Erro ao Criar diretórios!" + "\n");
											tv.setTextColor(Color.RED);
										}
										tv.setBackgroundResource(R.drawable.border);
										tv.setLayoutParams(pr1);
										l2.addView(tv);
										root.addView(l2);
									}
								}, 900);
							}
						}, 5000);
					}
				}, 1000);
				setContentView(sc);

			}
		}, 2000);

	}
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
