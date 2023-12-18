package lucas.client.service.caixa;

import android.content.*;
import android.graphics.*;
import android.icu.text.*;
import android.os.*;

import androidx.appcompat.app.*;

import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;

import java.io.*;
import java.nio.channels.*;
import java.util.*;
import lucas.client.service.*;
import lucas.client.service.Fragments.*;
import lucas.client.service.Fragments.adapter.FragmentAd;
import lucas.client.service.Fragments.adapter.productAdapter;
import lucas.client.service.caixa.adapters.gridAd;
import lucas.client.service.caixa.adapters.mainAd;
import lucas.client.service.caixa.product.*;
import lucas.client.service.caixa.setup.fechamentos.*;
import lucas.client.service.caixa.setup.lancamentos.*;
import lucas.client.service.etc.*;
import lucas.client.service.sqlite.*;

import android.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import android.view.View.OnClickListener;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;


public class caixaMain extends AppCompatActivity
{
	AlertDialog aler, ale;
	Object sub;
	double res;
	productAdapter ad;
	gridAd ad2;
    List<util> lt, car;
	private TabLayout tab;
    private ViewPager vp;
	int currentPos=0;
String CarRw1, CarRw2, CarRw3, CarRw4, CarRw5, CarRw6, CarRw7, CarRw8, CarRw9, CarRw10, CarRw11;
byte[] lm;
Context c = this;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		vp = (ViewPager) findViewById(R.id.viewpager);
        FragmentAd ad = new FragmentAd(getSupportFragmentManager());
		try{
			DB db = new DB(c);
			List<util> prd = db.findP1();
			util us = db.getCategory(1);
			if(!us.getCategory().toString().equals("")){
				try{
					if(!prd.get(0).getProd1().toString().equals("")){
						ad.adicionar(new Page1(), us.getCategory());
					}
				}catch(Exception e){}
			}
		}catch(Exception e){}
		try{
			DB db = new DB(c);
			List<util> prd = db.findP2();
			util us = db.getCategory(2);
			if(!us.getCategory().toString().equals("")){
				try{
					if(!prd.get(0).getProd1().toString().equals("")){
						ad.adicionar(new Page2(), us.getCategory());
					}
				}catch(Exception e){}
			}
		}catch(Exception e){}
		try{
			DB db = new DB(c);
			List<util> prd = db.findP3();
			util us = db.getCategory(3);
			if(!us.getCategory().toString().equals("")){
				try{
					if(!prd.get(0).getProd1().toString().equals("")){
						ad.adicionar(new page3(), us.getCategory());
					}
				}catch(Exception e){}
			}
		}catch(Exception e){}
		try{
			DB db = new DB(c);
			List<util> prd = db.findP4();
			util us = db.getCategory(4);
			if(!us.getCategory().toString().equals("")){
				try{
					if(!prd.get(0).getProd1().toString().equals("")){
						ad.adicionar(new page4(), us.getCategory());
					}
				}catch(Exception e){}
			}
		}catch(Exception e){}
		try{
			DB db = new DB(c);
			List<util> prd = db.findP5();
			util us = db.getCategory(5);
			if(!us.getCategory().toString().equals("")){
				try{
					if(!prd.get(0).getProd1().toString().equals("")){
						ad.adicionar(new page5(), us.getCategory());
					}
				}catch(Exception e){}
			}
		}catch(Exception e){}
		try{
			DB db = new DB(c);
			List<util> prd = db.findP6();
			util us = db.getCategory(6);
			if(!us.getCategory().toString().equals("")){
				try{
					if(!prd.get(0).getProd1().toString().equals("")){
						ad.adicionar(new page6(), us.getCategory());
					}
				}catch(Exception e){}
			}
		}catch(Exception e){}
		try{
			DB db = new DB(c);
			List<util> prd = db.findP7();
			util us = db.getCategory(7);
			if(!us.getCategory().toString().equals("")){
				try{
					if(!prd.get(0).getProd1().toString().equals("")){
						ad.adicionar(new page7(), us.getCategory());
					}
				}catch(Exception e){}
			}
		}catch(Exception e){}
		try{
			DB db = new DB(c);
			List<util> prd = db.findP8();
			util us = db.getCategory(8);
			if(!us.getCategory().toString().equals("")){
				try{
					if(!prd.get(0).getProd1().toString().equals("")){
						ad.adicionar(new page8(), us.getCategory());
					}
				}catch(Exception e){}
			}
		}catch(Exception e){}
		try{
			DB db = new DB(c);
			List<util> prd = db.findP9();
			util us = db.getCategory(9);
			if(!us.getCategory().toString().equals("")){
				try{
					if(!prd.get(0).getProd1().toString().equals("")){
						ad.adicionar(new page9(), us.getCategory());
					}
				}catch(Exception e){}
			}
		}catch(Exception e){}
		try{
			DB db = new DB(c);
			List<util> prd = db.findP10();
			util us = db.getCategory(10);
			if(!us.getCategory().toString().equals("")){
				try{
					if(!prd.get(0).getProd1().toString().equals("")){
						ad.adicionar(new page10(), us.getCategory());
					}
				}catch(Exception e){}
			}
		}catch(Exception e){}
		vp.setAdapter(ad);
        
        tab = (TabLayout) findViewById(R.id.tabs);
        tab.setTabGravity(TabLayout.GRAVITY_FILL);
        tab.setupWithViewPager(vp);
		tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

				@Override
				public void onTabSelected(TabLayout.Tab p1)
				{
					// TODO: Implement this method
					vp.setCurrentItem(currentPos=p1.getPosition());
				}

				@Override
				public void onTabUnselected(TabLayout.Tab p1)
				{
					// TODO: Implement this method
				}

				@Override
				public void onTabReselected(TabLayout.Tab p1)
				{
					// TODO: Implement this method
				}
			});
		try{
			Intent it = getIntent();
			Bundle b = it.getExtras();
			String res = b.getString("key");
			if(!res.toString().equals("")){
				runCarrinho();
			} else {

			}
		} catch(Exception e){}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		// TODO: Implement this method
		if(keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){
			final String[] lc = new String[]
					{"Fechamento de Caixa", "Sangria", "Suprimento de Caixa"};

			LayoutInflater li = getLayoutInflater();
			View r = li.inflate(R.layout.list_ad, null);
			ListView lis = r.findViewById(R.id.list);
			lis.setAdapter(new mainAd(c, lc));
			lis.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method

					if(lc[p3].toString().startsWith("F")){

						Intent itr = new Intent(c, fechaCaixa.class);
						startActivity(itr);
						finish();
					}
					if(lc[p3].toString().startsWith("H")){
						Intent itr = new Intent(c, historico.class);
						startActivity(itr);
					}
					if(lc[p3].toString().startsWith("Sangria")){
						LayoutInflater li = getLayoutInflater();
						View r = li.inflate(R.layout.sangria, null);
						final TextInputEditText val = r.findViewById(R.id.valor);
						final TextInputEditText mot = r.findViewById(R.id.motivo);

						AlertDialog.Builder alert = new AlertDialog.Builder(c);
						alert.setTitle("Sangria de Caixa!");
						alert.setPositiveButton("Ok", new DialogInterface.OnClickListener(){

							@Override
							public void onClick(DialogInterface p1, int p2)
							{
								// TODO: Implement this method
								try{
									DB p = new DB(c);
									List<util> ls;
									ls = p.saFind();
									if(!ls.get(0).getSangria().equals("")){
										Double curSan = new Double(ls.get(0).getSangria());
										Double comSan = new Double(val.getText().toString());
										double res = curSan + comSan;
										DecimalFormatSymbols df4 = new DecimalFormatSymbols();
										df4.setGroupingSeparator('.');
										df4.setDecimalSeparator('.');
										DecimalFormat dform4 = new DecimalFormat("####.##", df4);
										util us2 = new util();
										us2.setSangria(dform4.format(res));
										DB de = new DB(c);
										de.delSangSaldo();
										de.saIn(us2);

										util us = new util();
										us.setSanVal(val.getText().toString());
										us.setSanMot(mot.getText().toString());
										DB da = new DB(c);
										da.sangIn(us);
										da.sanInsert(us);

										try {
											File sd = Environment.getExternalStorageDirectory();
											File data = Environment.getDataDirectory();

											if (sd.canWrite()) {
												String  currentDBPath= "//data//" + c.getOpPackageName()
														+ "//databases//" + "myDB.db";
												String  currentDBPath2 = "//data//" + c.getOpPackageName()
														+ "//databases//" + "myDB.db-shm";
												String  currentDBPath3 = "//data//" + c.getOpPackageName()
														+ "//databases//" + "myDB.db-wal";

												String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db";
												String backupDBPath2  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db-shm";
												String backupDBPath3  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db-wal";

												File currentDB = new File(data, currentDBPath);
												File currentDB2 = new File(data, currentDBPath2);
												File currentDB3 = new File(data, currentDBPath3);
												File backupDB = new File(sd, backupDBPath);
												File backupDB2 = new File(sd, backupDBPath2);
												File backupDB3 = new File(sd, backupDBPath3);

												if(currentDB2.exists()){
													FileChannel src = new FileInputStream(currentDB2).getChannel();
													FileChannel dst = new FileOutputStream(backupDB2).getChannel();
													dst.transferFrom(src, 0, src.size());
													src.close();
													dst.close();
												}
												if(currentDB3.exists()){
													FileChannel src = new FileInputStream(currentDB3).getChannel();
													FileChannel dst = new FileOutputStream(backupDB3).getChannel();
													dst.transferFrom(src, 0, src.size());
													src.close();
													dst.close();
												}
												FileChannel src = new FileInputStream(currentDB).getChannel();
												FileChannel dst = new FileOutputStream(backupDB).getChannel();
												dst.transferFrom(src, 0, src.size());
												src.close();
												dst.close();
											}
										} catch (Exception e2) {

										}

									} else {}
								}catch(Exception e){
									util us = new util();
									us.setSanVal(val.getText().toString());
									us.setSanMot(mot.getText().toString());
									DB da = new DB(c);
									da.sangIn(us);
									da.sanInsert(us);
									util us2 = new util();
									us2.setSangria(val.getText().toString());
									DB de = new DB(c);
									de.saIn(us2);


									try {
										File sd = Environment.getExternalStorageDirectory();
										File data = Environment.getDataDirectory();

										if (sd.canWrite()) {
											String  currentDBPath= "//data//" + c.getOpPackageName()
													+ "//databases//" + "myDB.db";
											String  currentDBPath2 = "//data//" + c.getOpPackageName()
													+ "//databases//" + "myDB.db-shm";
											String  currentDBPath3 = "//data//" + c.getOpPackageName()
													+ "//databases//" + "myDB.db-wal";

											String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db";
											String backupDBPath2  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db-shm";
											String backupDBPath3  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db-wal";

											File currentDB = new File(data, currentDBPath);
											File currentDB2 = new File(data, currentDBPath2);
											File currentDB3 = new File(data, currentDBPath3);
											File backupDB = new File(sd, backupDBPath);
											File backupDB2 = new File(sd, backupDBPath2);
											File backupDB3 = new File(sd, backupDBPath3);

											if(currentDB2.exists()){
												FileChannel src = new FileInputStream(currentDB2).getChannel();
												FileChannel dst = new FileOutputStream(backupDB2).getChannel();
												dst.transferFrom(src, 0, src.size());
												src.close();
												dst.close();
											}
											if(currentDB3.exists()){
												FileChannel src = new FileInputStream(currentDB3).getChannel();
												FileChannel dst = new FileOutputStream(backupDB3).getChannel();
												dst.transferFrom(src, 0, src.size());
												src.close();
												dst.close();
											}
											FileChannel src = new FileInputStream(currentDB).getChannel();
											FileChannel dst = new FileOutputStream(backupDB).getChannel();
											dst.transferFrom(src, 0, src.size());
											src.close();
											dst.close();
										}
									} catch (Exception e2) {

									}

								}
							}
						});
						alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){

							@Override
							public void onClick(DialogInterface p1, int p2)
							{
								// TODO: Implement this method
								aler.dismiss();
							}
						});
						alert.setView(r);
						aler = alert.create();
						aler = alert.show();
					}

					if(lc[p3].toString().startsWith("Suprimento")){
						LayoutInflater li = getLayoutInflater();
						View r = li.inflate(R.layout.suprimento, null);
						final TextInputEditText val = r.findViewById(R.id.supVal);
						final TextInputEditText mot = r.findViewById(R.id.supDesc);

						AlertDialog.Builder alert = new AlertDialog.Builder(c);
						alert.setTitle("Suprimento de Caixa!");
						alert.setPositiveButton("Ok", new DialogInterface.OnClickListener(){

							@Override
							public void onClick(DialogInterface p1, int p2)
							{
								// TODO: Implement this method
								try{
									DB p = new DB(c);
									List<util> ls;
									ls = p.suFind();
									if(!ls.get(0).getSupVal().equals("")){
										Double curSan = new Double(ls.get(0).getSupVal());
										Double comSan = new Double(val.getText().toString());
										double res = curSan + comSan;
										DecimalFormatSymbols df4 = new DecimalFormatSymbols();
										df4.setGroupingSeparator('.');
										df4.setDecimalSeparator('.');
										DecimalFormat dform4 = new DecimalFormat("####.##", df4);
										util us2 = new util();
										us2.setSupVal(dform4.format(res));
										DB de = new DB(c);
										de.delSupSom();
										de.SupSomIn(us2);

										util us = new util();
										us.setSupVal(val.getText().toString());
										us.setSupDesc(mot.getText().toString());
										DB da = new DB(c);
										da.SupIn(us);
										da.supInsert(us);

										try {
											File sd = Environment.getExternalStorageDirectory();
											File data = Environment.getDataDirectory();

											if (sd.canWrite()) {
												String  currentDBPath= "//data//" + c.getOpPackageName()
														+ "//databases//" + "myDB.db";
												String  currentDBPath2 = "//data//" + c.getOpPackageName()
														+ "//databases//" + "myDB.db-shm";
												String  currentDBPath3 = "//data//" + c.getOpPackageName()
														+ "//databases//" + "myDB.db-wal";

												String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db";
												String backupDBPath2  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db-shm";
												String backupDBPath3  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db-wal";

												File currentDB = new File(data, currentDBPath);
												File currentDB2 = new File(data, currentDBPath2);
												File currentDB3 = new File(data, currentDBPath3);
												File backupDB = new File(sd, backupDBPath);
												File backupDB2 = new File(sd, backupDBPath2);
												File backupDB3 = new File(sd, backupDBPath3);

												if(currentDB2.exists()){
													FileChannel src = new FileInputStream(currentDB2).getChannel();
													FileChannel dst = new FileOutputStream(backupDB2).getChannel();
													dst.transferFrom(src, 0, src.size());
													src.close();
													dst.close();
												}
												if(currentDB3.exists()){
													FileChannel src = new FileInputStream(currentDB3).getChannel();
													FileChannel dst = new FileOutputStream(backupDB3).getChannel();
													dst.transferFrom(src, 0, src.size());
													src.close();
													dst.close();
												}
												FileChannel src = new FileInputStream(currentDB).getChannel();
												FileChannel dst = new FileOutputStream(backupDB).getChannel();
												dst.transferFrom(src, 0, src.size());
												src.close();
												dst.close();
											}
										} catch (Exception e2) {

										}

									} else {}
								}catch(Exception e){
									util us = new util();
									us.setSupVal(val.getText().toString());
									us.setSupDesc(mot.getText().toString());
									DB da = new DB(c);
									da.SupIn(us);
									da.supInsert(us);
									util us2 = new util();
									us2.setSupVal(val.getText().toString());
									DB de = new DB(c);
									de.delSupSom();
									de.SupSomIn(us2);


									try {
										File sd = Environment.getExternalStorageDirectory();
										File data = Environment.getDataDirectory();

										if (sd.canWrite()) {
											String  currentDBPath= "//data//" + c.getOpPackageName()
													+ "//databases//" + "myDB.db";
											String  currentDBPath2 = "//data//" + c.getOpPackageName()
													+ "//databases//" + "myDB.db-shm";
											String  currentDBPath3 = "//data//" + c.getOpPackageName()
													+ "//databases//" + "myDB.db-wal";

											String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db";
											String backupDBPath2  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db-shm";
											String backupDBPath3  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db-wal";

											File currentDB = new File(data, currentDBPath);
											File currentDB2 = new File(data, currentDBPath2);
											File currentDB3 = new File(data, currentDBPath3);
											File backupDB = new File(sd, backupDBPath);
											File backupDB2 = new File(sd, backupDBPath2);
											File backupDB3 = new File(sd, backupDBPath3);

											if(currentDB2.exists()){
												FileChannel src = new FileInputStream(currentDB2).getChannel();
												FileChannel dst = new FileOutputStream(backupDB2).getChannel();
												dst.transferFrom(src, 0, src.size());
												src.close();
												dst.close();
											}
											if(currentDB3.exists()){
												FileChannel src = new FileInputStream(currentDB3).getChannel();
												FileChannel dst = new FileOutputStream(backupDB3).getChannel();
												dst.transferFrom(src, 0, src.size());
												src.close();
												dst.close();
											}
											FileChannel src = new FileInputStream(currentDB).getChannel();
											FileChannel dst = new FileOutputStream(backupDB).getChannel();
											dst.transferFrom(src, 0, src.size());
											src.close();
											dst.close();
										}
									} catch (Exception e2) {

									}
								}
							}
						});
						alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){

							@Override
							public void onClick(DialogInterface p1, int p2)
							{
								// TODO: Implement this method
								aler.dismiss();
							}
						});
						alert.setView(r);
						aler = alert.create();
						aler = alert.show();
					}

				}
			});
			AlertDialog.Builder selc = new AlertDialog.Builder(c);
			selc.setTitle("Selecione uma Opção:");
			selc.setView(r);
			selc.create();
			selc.show();
		}

		return super.onKeyDown(keyCode, event);
	}
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event)
	{
		// TODO: Implement this method
		if(keyCode == KeyEvent.KEYCODE_VOLUME_UP){
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
					DB db = new DB(c);
					List<util> Op = db.opFind();
					List<util> fun = db.funFind();
					Intent it = new Intent(c, Login.class);
					Bundle bundle = new Bundle();
					bundle.putString("op", Op.get(0).getOp());
					bundle.putString("fundo", fun.get(0).getFundo());
					it.putExtras(bundle);
					startActivity(it);
					finish();
				}
			} catch (Exception e) {
				
			}
		}
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public void onBackPressed()
	{
		// TODO: Implement this method
		
	}
	public void runCarrinho(){
		DB srv = new DB(c);
		car = srv.carrinho();
		LayoutInflater li = getLayoutInflater();
		View r = li.inflate(R.layout.product_added, null);
		ad = new productAdapter(c, car);
		ListView lp = r.findViewById(R.id.list);
		lp.setEmptyView(r.findViewById(android.R.id.empty));
		lp.setAdapter(ad);
		AlertDialog.Builder ap = new AlertDialog.Builder(c);
		ap.setTitle("Carrinho de Compras!");
		ap.setView(r);
		ap.setPositiveButton("Cobrar", new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface p1, int p2)
				{
					// TODO: Implement this method
					try{
						DB d1 = new DB(c);
						util carRw1 = d1.getCarRw(1);
						if(!carRw1.getValor2().equals("")){
							CarRw1 = carRw1.getValor2();
						}
					}catch(Exception e){
						CarRw1 = "0";
					}
					try{
						DB d2 = new DB(c);
						util carRw2 = d2.getCarRw(2);
						if(!carRw2.getValor2().equals("")){
							CarRw2 = carRw2.getValor2();
						}
					}catch(Exception e){
						CarRw2 = "0";
					}
					try{
						DB d3 = new DB(c);
						util carRw3 = d3.getCarRw(3);
						if(!carRw3.getValor2().equals("")){
							CarRw3 = carRw3.getValor2();
						}
					}catch(Exception e){
						CarRw3 = "0";
					}
					try{
						DB d4 = new DB(c);
						util carRw4 = d4.getCarRw(4);
						if(!carRw4.getValor2().equals("")){
							CarRw4 = carRw4.getValor2();
						}
					}catch(Exception e){
						CarRw4 = "0";
					}
					try{
						DB d5 = new DB(c);
						util carRw5 = d5.getCarRw(5);
						if(!carRw5.getValor2().equals("")){
							CarRw5 = carRw5.getValor2();
						}
					}catch(Exception e){
						CarRw5 = "0";
					}
					try{
						DB d6 = new DB(c);
						util carRw6 = d6.getCarRw(6);
						if(!carRw6.getValor2().equals("")){
							CarRw6 = carRw6.getValor2();
						}
					}catch(Exception e){
						CarRw6 = "0";
					}
					try{
						DB d7 = new DB(c);
						util carRw7 = d7.getCarRw(7);
						if(!carRw7.getValor2().equals("")){
							CarRw7 = carRw7.getValor2();
						}
					}catch(Exception e){
						CarRw7 = "0";
					}
					try{
						DB d8 = new DB(c);
						util carRw8 = d8.getCarRw(8);
						if(!carRw8.getValor2().equals("")){
							CarRw8 = carRw8.getValor2();
						}
					}catch(Exception e){
						CarRw8 = "0";
					}
					try{
						DB d9 = new DB(c);
						util carRw9 = d9.getCarRw(9);
						if(!carRw9.getValor2().equals("")){
							CarRw9 = carRw9.getValor2();
						}
					}catch(Exception e){
						CarRw9 = "0";
					}
					try{
						DB d10 = new DB(c);
						util carRw10 = d10.getCarRw(10);
						if(!carRw10.getValor2().equals("")){
							CarRw10 = carRw10.getValor2();
						}
					}catch(Exception e){
						CarRw10 = "0";
					}
					try{
						DB d11 = new DB(c);
						util carRw11 = d11.getCarRw(11);
						if(!carRw11.getValor2().equals("")){
							CarRw11 = carRw11.getValor2();
						}
					}catch(Exception e){
						CarRw11 = "0";
					}
					Double som1 = new Double(CarRw1);
					Double som2 = new Double(CarRw2);
					Double som3 = new Double(CarRw3);
					Double som4 = new Double(CarRw4);
					Double som5 = new Double(CarRw5);
					Double som6 = new Double(CarRw6);
					Double som7 = new Double(CarRw7);
					Double som8 = new Double(CarRw8);
					Double som9 = new Double(CarRw9);
					Double som10 = new Double(CarRw10);
					Double som11 = new Double(CarRw11);
					double res_ = som1 + som2 + som3 + som4 + som5 + som6 + som7 + som8 + som9 + som10 + som11;
					DecimalFormatSymbols df = new DecimalFormatSymbols();
					df.setGroupingSeparator('.');
					df.setDecimalSeparator('.');
					DecimalFormat dform = new DecimalFormat("####.##", df);
					String result = dform.format(res_);

						Intent it = new Intent(c, pay.class);
						Bundle b = new Bundle();
						b.putString("valor", result);
						it.putExtras(b);
						startActivity(it);
				}
			});
		ap.setNegativeButton("Cancelar!", null);
		ale = ap.create();
		ale = ap.show();
	}
}
