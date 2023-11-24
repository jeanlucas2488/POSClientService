package lucas.client.service.caixa;
import android.app.*;
import android.content.*;
import android.os.*;
import android.support.v4.app.*;
import java.io.*;
import java.nio.channels.*;
import java.util.*;
import lucas.client.service.*;
import lucas.client.service.etc.*;
import lucas.client.service.sqlite.*;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class selfConfig extends Activity
{
	ProgressDialog progress;
	Context c = this;
	private static final int PERMISSION_REQUEST_CODE = 200;
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
								ActivityCompat.requestPermissions(selfConfig.this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
								Thread.sleep(5000);
								progress.setMessage("Continuando configuração do POS...");
							}
							
							if(progress.getProgress() == 20){
								progress.setMessage("Fechando Apps em Segundo Plano...");
								Runtime.getRuntime().exec("am kill");
								Runtime.getRuntime().exec("am kill-all");
								Thread.sleep(1000);
								progress.setMessage("Concluído!!");
								Thread.sleep(1000);
								progress.setMessage("Verificando algumas coisas 😊...");
								Thread.sleep(7000);
							}
							if(progress.getProgress() == 60){
								progress.setMessage("Verificando se há vendas no POS...");
								Thread.sleep(2000);
								try{
									DB db = new DB(c);
									
									List<util> check = db.moFind();
									if(!check.get(0).getMoney().equals("")){
										progress.setMessage("Ops! Há vendas em aberto 🧐!!");
										Thread.sleep(1000);
										progress.setMessage("Carregando POS...");
										progress.dismiss();
										
										Intent itt = new Intent(c, caixaMain.class);
										startActivity(itt);
										Thread.sleep(99999999);
										
									} else{}
								}catch(Exception e){
									try{
										DB db = new DB(c);
										List<util> carrinho = db.carrinho();
										if(!carrinho.get(0).getProd2().equals("")){
											progress.setMessage("Ops! Não Terminaste a Venda!");
											Thread.sleep(2000);
											
											Intent it = new Intent(c, caixaMain.class);
											Bundle b = new Bundle();
											String val = "1";
											b.putString("key", val);
											it.putExtras(b);
											startActivity(it);
											Thread.sleep(99999999);
										} 
									}catch(Exception e2){
										progress.setMessage("Nenhuma venda Realizada!!");
									}
								}
							}
							if(progress.getProgress() == 40){
								progress.setMessage("Importando Banco de dados....");
								Thread.sleep(3000);
								try {
									File sd = Environment.getExternalStorageDirectory();
									File data = Environment.getDataDirectory();

									if (sd.canWrite()) {
										String  currentDBPath= "//data//" + c.getOpPackageName()
											+ "//databases//" + "myDB.db";
										String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db";
										File dbshm = new File(data, currentDBPath + "-shm");
										File dbwal = new File(data, currentDBPath + "-wal");
										if (dbshm.exists()) {
											dbshm.delete();
										}
										if (dbwal.exists()) {
											dbwal.delete();
										}
										File currentDB = new File(data, currentDBPath);
										File backupDB = new File(sd, backupDBPath);
										FileChannel src = new FileInputStream(backupDB).getChannel();
										FileChannel dst = new FileOutputStream(currentDB).getChannel();
										dst.transferFrom(src, 0, src.size());
										src.close();
										dst.close();
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
							
							if(progress.getProgress() == 70){
								progress.setMessage("Executando Abertura do POS...");
								Thread.sleep(2000);
								progress.dismiss();
								Intent itt = new Intent(c, Login.class);
								startActivity(itt);
								
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
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
	
}
