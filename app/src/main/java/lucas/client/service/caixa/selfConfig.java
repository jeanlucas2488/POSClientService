package lucas.client.service.caixa;
import android.Manifest;
import android.app.*;
import android.content.*;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class selfConfig extends AppCompatActivity {
	ProgressDialog progress;
	Context c = this;
	SQLiteDatabase d;
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


				sc.addView(root);

				Handler hd = new Handler();
				hd.postDelayed(new Runnable() {
					public void run() {
						LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
						pr1.setMargins(10, 0, 10, 0);

						LinearLayout l2 = new LinearLayout(c);
						l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
						final TextView tv = new TextView(c);
						tv.setText("Checando Permissões..." + "\n");

						tv.setBackgroundResource(R.drawable.border);
						tv.setLayoutParams(pr1);
						l2.addView(tv);
						root.addView(l2);

						Handler hd2 = new Handler();
						hd2.postDelayed(new Runnable() {
							public void run() {
								LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
								pr1.setMargins(10, 30, 10, 0);

								LinearLayout l2 = new LinearLayout(c);
								l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
								final TextView tv = new TextView(c);

								if (checkPermission()) {
									tv.setText("Permissão de SdCard Concedida!" + "\n");
									tv.setTextColor(Color.GREEN);
								} else {
									requestPermission();
									tv.setText("Permissão de SdCard Negada!" + "\n");
									tv.setTextColor(Color.RED);
								}
								tv.setBackgroundResource(R.drawable.border);
								tv.setLayoutParams(pr1);
								l2.addView(tv);
								root.addView(l2);

								Handler hd3 = new Handler();
								hd3.postDelayed(new Runnable() {
									public void run() {
										LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
										pr1.setMargins(10, 30, 10, 0);

										LinearLayout l2 = new LinearLayout(c);
										l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
										final TextView tv = new TextView(c);

										tv.setText("Criando diretórios do Sistema POS 1/4..." + "\n");

										File f = new File(Environment.getExternalStorageDirectory(), "pdvMain");
										f.exists();
										f.mkdir();

										if (f.canWrite()) {
											Handler ha = new Handler();
											ha.postDelayed(new Runnable() {
												public void run() {
													tv.setText("Criando diretórios do Sistema POS 2/4..." + "\n");
													File f = new File(Environment.getExternalStorageDirectory(), "pdvMain/.sqlite");
													f.exists();
													f.mkdir();
													if (f.canWrite()) {
														Handler hd4 = new Handler();
														hd4.postDelayed(new Runnable() {
															public void run() {
																Handler hd5 = new Handler();
																hd5.postDelayed(new Runnable() {
																	public void run() {
																		tv.setText("Criando diretórios do Sistema POS 3/4..." + "\n");

																		File f = new File(Environment.getExternalStorageDirectory(), "pdvMain/.Nfe");
																		f.exists();
																		f.mkdir();
																		if (f.canWrite()) {
																			Handler hd6 = new Handler();
																			hd6.postDelayed(new Runnable() {
																				public void run() {
																					tv.setText("Criando diretórios do Sistema POS 4/4..." + "\n");

																					File f = new File(Environment.getExternalStorageDirectory(), "pdvMain/.fechamentos");
																					f.exists();
																					f.mkdir();
																					if (f.canWrite()) {
																						Handler hd6 = new Handler();
																						hd6.postDelayed(new Runnable() {
																							public void run() {
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
																								hd6.postDelayed(new Runnable() {
																									public void run() {
																										LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
																										pr1.setMargins(10, 30, 10, 0);

																										LinearLayout l2 = new LinearLayout(c);
																										l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
																										final TextView tv = new TextView(c);

																										tv.setText("Importando Banco de Dados 1/2..." + "\n");
																										Handler hd7 = new Handler();
																										hd7.postDelayed(new Runnable() {
																											public void run() {
																												try {
																													File sd = Environment.getExternalStorageDirectory();
																													File data = Environment.getDataDirectory();

																													if (sd.canWrite()) {
																														tv.setText("Banco de dados 1/2 Importado!" + "\n");
																														tv.setTextColor(Color.GREEN);
																														String currentDBPath = "//data//" + c.getPackageName()
																																+ "//databases//" + "myDB.db";

																														String backupDBPath = "pdvMain/.sqlite/myDB.db";

																														File currentDB = new File(data, currentDBPath);
																														File backupDB = new File(sd, backupDBPath);


																														FileChannel src = new FileInputStream(backupDB).getChannel();
																														FileChannel dst = new FileOutputStream(currentDB).getChannel();
																														dst.transferFrom(src, 0, src.size());
																														src.close();
																														dst.close();
																													} else {
																													}
																												} catch (
																														Exception e2) {
																													tv.setText("Erro ao Importar Banco de dados 1/2!" + "\n");
																													tv.setTextColor(Color.RED);
																												}
																											}
																										}, 2000);

																										tv.setBackgroundResource(R.drawable.border);
																										tv.setLayoutParams(pr1);
																										l2.addView(tv);
																										root.addView(l2);

																										Handler as = new Handler();
																										as.postDelayed(new Runnable() {

																											@Override
																											public void run() {
																												// TODO: Implement this method
																												LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
																												pr1.setMargins(10, 30, 10, 0);

																												LinearLayout l2 = new LinearLayout(c);
																												l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
																												final TextView tv = new TextView(c);

																												tv.setText("Importando Banco de Dados 2/2..." + "\n");
																												Handler hd7 = new Handler();
																												hd7.postDelayed(new Runnable() {
																													public void run() {
																														try {
																															File sd = Environment.getExternalStorageDirectory();
																															File data = Environment.getDataDirectory();

																															if (sd.canWrite()) {
																																tv.setText("Banco de dados 2/2 Importado!" + "\n");
																																tv.setTextColor(Color.GREEN);
																																String currentDBPath = "//data//" + c.getPackageName()
																																		+ "//databases//" + "MCRDB.db";

																																String backupDBPath = "pdvMain/.sqlite/MCRDB.db";

																																File currentDB = new File(data, currentDBPath);
																																File backupDB = new File(sd, backupDBPath);


																																FileChannel src = new FileInputStream(backupDB).getChannel();
																																FileChannel dst = new FileOutputStream(currentDB).getChannel();
																																dst.transferFrom(src, 0, src.size());
																																src.close();
																																dst.close();
																															} else {
																															}
																														} catch (
																																Exception e2) {
																															tv.setText("Erro ao Importar Banco de dados 2/2!" + "\n");
																															tv.setTextColor(Color.RED);
																														}
																													}
																												}, 2000);

																												tv.setBackgroundResource(R.drawable.border);
																												tv.setLayoutParams(pr1);
																												l2.addView(tv);
																												root.addView(l2);
																											}

																										}, 2000);
																										Handler hd8 = new Handler();
																										hd8.postDelayed(new Runnable() {
																											public void run() {

																												LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
																												pr1.setMargins(10, 30, 10, 0);

																												LinearLayout l2 = new LinearLayout(c);
																												l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
																												final TextView tv = new TextView(c);

																												tv.setText("Verificando a Integridade do PDV 1/2..." + "\n");

																												Handler hde = new Handler();
																												hde.postDelayed(new Runnable() {
																													@Override
																													public void run() {
																														LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
																														pr1.setMargins(10, 30, 10, 0);

																														LinearLayout l2 = new LinearLayout(c);
																														l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
																														final TextView tv = new TextView(c);

																														tv.setText("Verificando Pagers..." + "\n");

																														Handler hde1 = new Handler();
																														hde1.postDelayed(new Runnable() {
																																			 @Override
																																			 public void run() {
																																				try {
																																					DB db = new DB(c);
																																					util us = db.getCategory(1);
																																					LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
																																					pr1.setMargins(10, 30, 10, 0);

																																					LinearLayout l2 = new LinearLayout(c);
																																					l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
																																					final TextView tv2 = new TextView(c);


																																					if(!us.getCategory().toString().equals("")){
																																						tv2.setText("Verificando Produtos..." + "\n");

																																						Handler hde2 = new Handler();
																																						hde2.postDelayed(new Runnable() {
																																							@Override
																																							public void run() {
																																								LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
																																								pr1.setMargins(10, 30, 10, 0);

																																								LinearLayout l2 = new LinearLayout(c);
																																								l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
																																								final TextView tv3 = new TextView(c);
																																								try{
																																									DB db2 = new DB(c);
																																									List<util> lt = db2.findP1();

																																									if (!lt.get(0).getProd1().toString().equals("")){
																																										tv3.setText("Verificando supervisor..." + "\n");

																																										Handler hde4 = new Handler();
																																										hde4.postDelayed(new Runnable() {
																																											@Override
																																											public void run() {

																																												try {
																																													DB db3 = new DB(c);
																																													util sup = db3.getSuperVisor(1);

																																													if (!sup.getSenhaSuperVisor().toString().equals("")){
																																														tv3.setText("Concluído! Abrindo tela de Login..." + "\n");

																																														Intent itt = new Intent(c, Login.class);
																																														startActivity(itt);
																																													} else {

																																													}
																																												}catch (Exception e){
																																													tv3.setText("Configure uma Senha de Supervisor!");
																																												}
																																											}
																																										}, 8000);
																																									} else {

																																									}
																																								} catch (Exception e){
																																									tv3.setText("Não há produtos cadastrados no PDV!" + "\n");
																																								}
																																								tv3.setBackgroundResource(R.drawable.border);
																																								tv3.setLayoutParams(pr1);
																																								l2.addView(tv3);
																																								root.addView(l2);
																																							}
																																						}, 6000);
																																					} else {

																																					}
																																					tv2.setBackgroundResource(R.drawable.border);
																																					tv2.setLayoutParams(pr1);
																																					l2.addView(tv2);
																																					root.addView(l2);

																																				}catch (Exception e) {
																																					tv.setText("Não há Páginas configuradas no PDV!");
																																				}
																																			 }
																																		 }, 4000);

																																tv.setBackgroundResource(R.drawable.border);
																														tv.setLayoutParams(pr1);
																														l2.addView(tv);
																														root.addView(l2);
																													}
																												}, 2000);
																												tv.setBackgroundResource(R.drawable.border);
																												tv.setLayoutParams(pr1);
																												l2.addView(tv);
																												root.addView(l2);
																											}

																										}, 6000);
																									}
																								}, 900);
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
									Toast.makeText(selfConfig.this, "Storage Permissions Denied", Toast.LENGTH_SHORT).show();
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
		if(requestCode == PERMISSION_REQUEST_CODE) {
			if (grantResults.length > 0) {
				boolean write = grantResults[0] == PackageManager.PERMISSION_GRANTED;
				boolean read = grantResults[1] == PackageManager.PERMISSION_GRANTED;

				if (read && write) {
					Toast.makeText(selfConfig.this, "Storage Permissions Granted", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(selfConfig.this, "Storage Permissions Denied", Toast.LENGTH_SHORT).show();
				}
			}
		}
			}
}