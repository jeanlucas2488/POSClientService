package lucas.client.service.Fragments;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.icu.text.*;
import android.os.*;
import androidx.annotation.*;

import android.view.*;

import androidx.appcompat.widget.SearchView;
import android.widget.AdapterView.*;
import android.widget.TextView.*;
import java.io.*;
import java.nio.channels.*;
import java.util.*;
import lucas.client.service.*;
import lucas.client.service.Fragments.adapter.productAdapter;
import lucas.client.service.caixa.adapters.*;
import lucas.client.service.caixa.product.*;
import lucas.client.service.etc.*;
import lucas.client.service.mercearia.databases.SQLiteControl;
import lucas.client.service.sqlite.*;

import androidx.fragment.app.Fragment;
import android.view.View.OnClickListener;
import android.widget.*;


public class Page1 extends Fragment
{
	byte[] lm;
	productAdapter ad;
	gridAd ad2;
	List<util>  lt, car;
	String CarRw1, CarRw2, CarRw3, CarRw4, CarRw5, CarRw6, CarRw7, CarRw8, CarRw9, CarRw10, CarRw11;
	AlertDialog ale;
	
	public Page1(){
		
	}
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//setHasOptionsMenu(true);
        View rootView=inflater.inflate(R.layout.fragment_view,null);
		DB db = new DB(getActivity());
		lt = db.findP1();
		List<util> op;
		op = db.opFind();
		TextView tv = rootView.findViewById(R.id.barOp);
		tv.setText("Operador(a): " + op.get(0).getOp());
		ImageButton cr = rootView.findViewById(R.id.finish);

		cr.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					runCarrinho();
				}
			});
		GridView gd = rootView.findViewById(R.id.grid);
		ad2 = new gridAd(getActivity(), lt);
		gd.setAdapter(ad2);
		gd.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> p1, View p2, final int p3, long p4)
				{
					// TODO: Implement this method
					lm = lt.get(p3).getImage();
					
					View r = getActivity().getLayoutInflater().inflate(R.layout.add_product, null);
					ImageView imp = r.findViewById(R.id.imP);
					final EditText prod = r.findViewById(R.id.prod);
					final EditText quan = r.findViewById(R.id.quant);
					final EditText valor = r.findViewById(R.id.valor);
					final ImageButton bt_sub = r.findViewById(R.id.sub);
					final ImageButton bt_add = r.findViewById(R.id.add);
					final TextView tvq = r.findViewById(R.id.tvQ);
					tvq.setVisibility(View.GONE);
					bt_sub.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View p1)
							{
								// TODO: Implement this method
								if(quan.getText().toString().equals("1")){
									bt_sub.setEnabled(false);
							}else {
								Double v1 = new Double(quan.getText().toString());
								double res = v1 - 1;
								DecimalFormatSymbols df2 = new DecimalFormatSymbols();

								DecimalFormat dform2 = new DecimalFormat("##", df2);
								quan.setText(dform2.format(res));
								Double sub1 = new Double(valor.getText().toString());
								Double sub2 = new Double(lt.get(p3).getValor1());
								double res2 = sub1 - sub2;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.00", df);
								valor.getText().clear();
								valor.setText(dform.format(res2));
							}
							}
					});
					bt_add.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View p1)
							{
								// TODO: Implement this method
								bt_sub.setEnabled(true);
								Double v1 = new Double(quan.getText().toString());
								double res0 = v1  +1;
								DecimalFormatSymbols df2 = new DecimalFormatSymbols();

								DecimalFormat dform2 = new DecimalFormat("##", df2);
								quan.setText(dform2.format(res0));
								Double quant = new Double(quan.getText().toString());
								Double val = new Double(lt.get(p3).getValor1());
								double res = val * quant;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.00", df);
								valor.getText().clear();
								valor.setText(dform.format(res));
							}
					});
					byte[] im = lt.get(p3).getImage();
					Bitmap bt = BitmapFactory.decodeByteArray(im, 0, im.length);
					imp.setImageBitmap(bt);
					prod.setText(lt.get(p3).getProd1());

					quan.setText("1");
					quan.setOnEditorActionListener(new OnEditorActionListener(){

							@Override
							public boolean onEditorAction(TextView p1, int p2, KeyEvent p3)
							{
								// TODO: Implement this method
								
								return false;
							}
						});
					valor.setText(lt.get(p3).getValor1());
					AlertDialog.Builder adp = new AlertDialog.Builder(getActivity());
					adp.setTitle("Adicionar ao Carrinho!");
					adp.setView(r);
					adp.setPositiveButton("Adicionar", new DialogInterface.OnClickListener(){

							@Override
							public void onClick(DialogInterface p1, int p2)
							{
								// TODO: Implement this method
								util us = new util();
								us.setProd2(lt.get(p3).getProd1());
								us.setQuant2(quan.getText().toString() + "x");
								us.setValor2(valor.getText().toString());
								us.setImage2(lm);
								DB d = new DB(getActivity());
								d.carIn(us);
								try {
									File sd = Environment.getExternalStorageDirectory();
									File data = Environment.getDataDirectory();

									if (sd.canWrite()) {
										String  currentDBPath= "//data//" + getActivity().getOpPackageName()
											+ "//databases//" + "myDB.db";
										String  currentDBPath2 = "//data//" + getActivity().getOpPackageName()
											+ "//databases//" + "myDB.db-shm";
										String  currentDBPath3 = "//data//" + getActivity().getOpPackageName()
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
						});
					adp.setNegativeButton("Cancelar", null);
					adp.create();
					adp.show();
				}
			});
        return rootView;
    }
	public void runCarrinho(){
		DB srv = new DB(getActivity());
		car = srv.carrinho();
		
		try{
			if(!car.get(0).getProd2().toString().equals("")){
				View r = getActivity().getLayoutInflater().inflate(R.layout.product_added, null);
				ad = new productAdapter(getActivity(), car);
				ListView lp = r.findViewById(R.id.list);
				lp.setEmptyView(r.findViewById(android.R.id.empty));
				lp.setAdapter(ad);
				AlertDialog.Builder ap = new AlertDialog.Builder(getActivity());
				ap.setTitle("Carrinho de Compras!");
				ap.setView(r);
				ap.setPositiveButton("Cobrar", new DialogInterface.OnClickListener(){

						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							// TODO: Implement this method

							try{
								DB d1 = new DB(getActivity());
								util carRw1 = d1.getCarRw(1);
								if(!carRw1.getValor2().equals("")){
									CarRw1 = carRw1.getValor2();
								}
							}catch(Exception e){
								CarRw1 = "0";
							}
							try{
								DB d2 = new DB(getActivity());
								util carRw2 = d2.getCarRw(2);
								if(!carRw2.getValor2().equals("")){
									CarRw2 = carRw2.getValor2();
								}
							}catch(Exception e){
								CarRw2 = "0";
							}
							try{
								DB d3 = new DB(getActivity());
								util carRw3 = d3.getCarRw(3);
								if(!carRw3.getValor2().equals("")){
									CarRw3 = carRw3.getValor2();
								}
							}catch(Exception e){
								CarRw3 = "0";
							}
							try{
								DB d4 = new DB(getActivity());
								util carRw4 = d4.getCarRw(4);
								if(!carRw4.getValor2().equals("")){
									CarRw4 = carRw4.getValor2();
								}
							}catch(Exception e){
								CarRw4 = "0";
							}
							try{
								DB d5 = new DB(getActivity());
								util carRw5 = d5.getCarRw(5);
								if(!carRw5.getValor2().equals("")){
									CarRw5 = carRw5.getValor2();
								}
							}catch(Exception e){
								CarRw5 = "0";
							}
							try{
								DB d6 = new DB(getActivity());
								util carRw6 = d6.getCarRw(6);
								if(!carRw6.getValor2().equals("")){
									CarRw6 = carRw6.getValor2();
								}
							}catch(Exception e){
								CarRw6 = "0";
							}
							try{
								DB d7 = new DB(getActivity());
								util carRw7 = d7.getCarRw(7);
								if(!carRw7.getValor2().equals("")){
									CarRw7 = carRw7.getValor2();
								}
							}catch(Exception e){
								CarRw7 = "0";
							}
							try{
								DB d8 = new DB(getActivity());
								util carRw8 = d8.getCarRw(8);
								if(!carRw8.getValor2().equals("")){
									CarRw8 = carRw8.getValor2();
								}
							}catch(Exception e){
								CarRw8 = "0";
							}
							try{
								DB d9 = new DB(getActivity());
								util carRw9 = d9.getCarRw(9);
								if(!carRw9.getValor2().equals("")){
									CarRw9 = carRw9.getValor2();
								}
							}catch(Exception e){
								CarRw9 = "0";
							}
							try{
								DB d10 = new DB(getActivity());
								util carRw10 = d10.getCarRw(10);
								if(!carRw10.getValor2().equals("")){
									CarRw10 = carRw10.getValor2();
								}
							}catch(Exception e){
								CarRw10 = "0";
							}
							try{
								DB d11 = new DB(getActivity());
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
							Intent it = new Intent(getActivity(), pay.class);
							Bundle b = new Bundle();
							b.putString("valor", result);
							it.putExtras(b);
							startActivity(it);

						}
					});
				ap.setNeutralButton("Arquivar", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						try{
							DB d1 = new DB(getActivity());
							util carRw1 = d1.getCarRw(1);
							if(!carRw1.getValor2().equals("")){
								CarRw1 = carRw1.getValor2();
							}
						}catch(Exception e){
							CarRw1 = "0";
						}
						try{
							DB d2 = new DB(getActivity());
							util carRw2 = d2.getCarRw(2);
							if(!carRw2.getValor2().equals("")){
								CarRw2 = carRw2.getValor2();
							}
						}catch(Exception e){
							CarRw2 = "0";
						}
						try{
							DB d3 = new DB(getActivity());
							util carRw3 = d3.getCarRw(3);
							if(!carRw3.getValor2().equals("")){
								CarRw3 = carRw3.getValor2();
							}
						}catch(Exception e){
							CarRw3 = "0";
						}
						try{
							DB d4 = new DB(getActivity());
							util carRw4 = d4.getCarRw(4);
							if(!carRw4.getValor2().equals("")){
								CarRw4 = carRw4.getValor2();
							}
						}catch(Exception e){
							CarRw4 = "0";
						}
						try{
							DB d5 = new DB(getActivity());
							util carRw5 = d5.getCarRw(5);
							if(!carRw5.getValor2().equals("")){
								CarRw5 = carRw5.getValor2();
							}
						}catch(Exception e){
							CarRw5 = "0";
						}
						try{
							DB d6 = new DB(getActivity());
							util carRw6 = d6.getCarRw(6);
							if(!carRw6.getValor2().equals("")){
								CarRw6 = carRw6.getValor2();
							}
						}catch(Exception e){
							CarRw6 = "0";
						}
						try{
							DB d7 = new DB(getActivity());
							util carRw7 = d7.getCarRw(7);
							if(!carRw7.getValor2().equals("")){
								CarRw7 = carRw7.getValor2();
							}
						}catch(Exception e){
							CarRw7 = "0";
						}
						try{
							DB d8 = new DB(getActivity());
							util carRw8 = d8.getCarRw(8);
							if(!carRw8.getValor2().equals("")){
								CarRw8 = carRw8.getValor2();
							}
						}catch(Exception e){
							CarRw8 = "0";
						}
						try{
							DB d9 = new DB(getActivity());
							util carRw9 = d9.getCarRw(9);
							if(!carRw9.getValor2().equals("")){
								CarRw9 = carRw9.getValor2();
							}
						}catch(Exception e){
							CarRw9 = "0";
						}
						try{
							DB d10 = new DB(getActivity());
							util carRw10 = d10.getCarRw(10);
							if(!carRw10.getValor2().equals("")){
								CarRw10 = carRw10.getValor2();
							}
						}catch(Exception e){
							CarRw10 = "0";
						}
						try{
							DB d11 = new DB(getActivity());
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
						final String result = dform.format(res_);

						try{
							DB db = new DB(getActivity());
							util res = db.getVenda(1);
							if(!res.getData().toString().equals("")){
								try{
									DB db2 = new DB(getActivity());
									util res2 = db2.getVenda(2);
									if(!res2.getData().toString().equals("")){
										try{
											DB db3 = new DB(getActivity());
											util res3 = db.getVenda(3);
											if(!res3.getData().toString().equals("")){
												try{
													DB db4 = new DB(getActivity());
													util res4 = db.getVenda(4);
													if(!res4.getData().toString().equals("")){

													} else {
													}
												} catch (Exception e){
													try{
														DB dd2 = new DB(getActivity());
														util carWh1 = dd2.getCarR(1);
														if(!carWh1.getValor2().toString().equals("")){
															String dateTime;
															Calendar calendar = Calendar.getInstance();
															SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
															dateTime = simpleDateFormat.format(calendar.getTime()).toString();
															util post = new util();
															post.setProd1(carWh1.getProd2());
															post.setQuant1(carWh1.getQuant2());
															post.setValor1(carWh1.getValor2());
															post.setImage(carWh1.getImage2());

															util post2 = new util();
															post2.setData(dateTime);
															post2.setProd1(carWh1.getProd2());
															post2.setValor1(result);
															db2.vendasIn(post2);
															db2.vendasDIn(post);
														}else{
														}
													}catch (Exception e2){
													}
													try{
														DB d2 = new DB(getActivity());
														util carWh1 = d2.getCarR(2);
														if(!carWh1.getValor2().toString().equals("")){
															util post = new util();
															post.setProd1(carWh1.getProd2());
															post.setQuant1(carWh1.getQuant2());
															post.setValor1(carWh1.getValor2());
															post.setImage(carWh1.getImage2());
															db.vendasDIn(post);
														}else{
														}
													}catch (Exception e2){
													}
													try{
														DB d2 = new DB(getActivity());
														util carWh1 = d2.getCarR(3);
														if(!carWh1.getValor2().toString().equals("")){
															util post = new util();
															post.setProd1(carWh1.getProd2());
															post.setQuant1(carWh1.getQuant2());
															post.setValor1(carWh1.getValor2());
															post.setImage(carWh1.getImage2());
															db.vendasDIn(post);
														}else{
														}
													}catch (Exception e2){
													}
													try{
														DB d2 = new DB(getActivity());
														util carWh1 = d2.getCarR(4);
														if(!carWh1.getValor2().toString().equals("")){
															util post = new util();
															post.setProd1(carWh1.getProd2());
															post.setQuant1(carWh1.getQuant2());
															post.setValor1(carWh1.getValor2());
															post.setImage(carWh1.getImage2());
															db.vendasDIn(post);
														}else{
														}
													}catch (Exception e2){
													}
													try{
														DB d2 = new DB(getActivity());
														util carWh1 = d2.getCarR(5);
														if(!carWh1.getValor2().toString().equals("")){
															util post = new util();
															post.setProd1(carWh1.getProd2());
															post.setQuant1(carWh1.getQuant2());
															post.setValor1(carWh1.getValor2());
															post.setImage(carWh1.getImage2());
															db.vendasDIn(post);
														}else{
														}
													}catch (Exception e2){
													}
													try{
														DB d2 = new DB(getActivity());
														util carWh1 = d2.getCarR(6);
														if(!carWh1.getValor2().toString().equals("")){
															util post = new util();
															post.setProd1(carWh1.getProd2());
															post.setQuant1(carWh1.getQuant2());
															post.setValor1(carWh1.getValor2());
															post.setImage(carWh1.getImage2());
															db.vendasDIn(post);
														}else{
														}
													}catch (Exception e2){
													}
													try{
														DB d2 = new DB(getActivity());
														util carWh1 = d2.getCarR(7);
														if(!carWh1.getValor2().toString().equals("")){
															util post = new util();
															post.setProd1(carWh1.getProd2());
															post.setQuant1(carWh1.getQuant2());
															post.setValor1(carWh1.getValor2());
															post.setImage(carWh1.getImage2());
															db.vendasDIn(post);
														}else{
														}
													}catch (Exception e2){
													}
													try{
														DB d2 = new DB(getActivity());
														util carWh1 = d2.getCarR(8);
														if(!carWh1.getValor2().toString().equals("")){
															util post = new util();
															post.setProd1(carWh1.getProd2());
															post.setQuant1(carWh1.getQuant2());
															post.setValor1(carWh1.getValor2());
															post.setImage(carWh1.getImage2());
															db.vendasDIn(post);
														}else{
														}
													}catch (Exception e2){
													}
													try{
														DB d2 = new DB(getActivity());
														util carWh1 = d2.getCarR(9);
														if(!carWh1.getValor2().toString().equals("")){
															util post = new util();
															post.setProd1(carWh1.getProd2());
															post.setQuant1(carWh1.getQuant2());
															post.setValor1(carWh1.getValor2());
															post.setImage(carWh1.getImage2());
															db.vendasDIn(post);
														}else{
														}
													}catch (Exception e2){
													}
													try{
														DB d2 = new DB(getActivity());
														util carWh1 = d2.getCarR(10);
														if(!carWh1.getValor2().toString().equals("")){
															util post = new util();
															post.setProd1(carWh1.getProd2());
															post.setQuant1(carWh1.getQuant2());
															post.setValor1(carWh1.getValor2());
															post.setImage(carWh1.getImage2());
															db.vendasDIn(post);
														}else{
														}
													}catch (Exception e2){
													}
													try{
														DB d2 = new DB(getActivity());
														util carWh1 = d2.getCarR(11);
														if(!carWh1.getValor2().toString().equals("")){
															util post = new util();
															post.setProd1(carWh1.getProd2());
															post.setQuant1(carWh1.getQuant2());
															post.setValor1(carWh1.getValor2());
															post.setImage(carWh1.getImage2());
															db.vendasDIn(post);
														}else{
														}
													}catch (Exception e2){
													}
													try {
														File sd = Environment.getExternalStorageDirectory();
														File data = Environment.getDataDirectory();

														if (sd.canWrite()) {
															String  currentDBPath= "//data//" + getActivity().getOpPackageName()
																	+ "//databases//" + "myDB.db";
															String  currentDBPath2 = "//data//" + getActivity().getOpPackageName()
																	+ "//databases//" + "myDB.db-shm";
															String  currentDBPath3 = "//data//" + getActivity().getOpPackageName()
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
											} else {
											}
										}catch (Exception e){
											try{
												DB d1 = new DB(getActivity());
												util carWh1 = d1.getCarR(1);
												if(!carWh1.getValor2().toString().equals("")){
													String dateTime;
													Calendar calendar = Calendar.getInstance();
													SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
													dateTime = simpleDateFormat.format(calendar.getTime()).toString();
													util post = new util();
													post.setProd1(carWh1.getProd2());
													post.setQuant1(carWh1.getQuant2());
													post.setValor1(carWh1.getValor2());
													post.setImage(carWh1.getImage2());

													util post2 = new util();
													post2.setData(dateTime);
													post2.setProd1(carWh1.getProd2());
													post2.setValor1(result);
													db2.vendasIn(post2);
													db2.vendasCIn(post);
												}else{
												}
											}catch (Exception e2){
											}
											try{
												DB d2 = new DB(getActivity());
												util carWh1 = d2.getCarR(2);
												if(!carWh1.getValor2().toString().equals("")){
													util post = new util();
													post.setProd1(carWh1.getProd2());
													post.setQuant1(carWh1.getQuant2());
													post.setValor1(carWh1.getValor2());
													post.setImage(carWh1.getImage2());
													db.vendasCIn(post);
												}else{
												}
											}catch (Exception e2){
											}
											try{
												DB d3 = new DB(getActivity());
												util carWh1 = d3.getCarR(3);
												if(!carWh1.getValor2().toString().equals("")){
													util post = new util();
													post.setProd1(carWh1.getProd2());
													post.setQuant1(carWh1.getQuant2());
													post.setValor1(carWh1.getValor2());
													post.setImage(carWh1.getImage2());
													db.vendasCIn(post);
												}else{
												}
											}catch (Exception e2){
											}
											try{
												DB d4 = new DB(getActivity());
												util carWh1 = d4.getCarR(4);
												if(!carWh1.getValor2().toString().equals("")){
													util post = new util();
													post.setProd1(carWh1.getProd2());
													post.setQuant1(carWh1.getQuant2());
													post.setValor1(carWh1.getValor2());
													post.setImage(carWh1.getImage2());
													db.vendasCIn(post);
												}else{
												}
											}catch (Exception e2){
											}
											try{
												DB d5 = new DB(getActivity());
												util carWh1 = d5.getCarR(5);
												if(!carWh1.getValor2().toString().equals("")){
													util post = new util();
													post.setProd1(carWh1.getProd2());
													post.setQuant1(carWh1.getQuant2());
													post.setValor1(carWh1.getValor2());
													post.setImage(carWh1.getImage2());
													db.vendasCIn(post);
												}else{
												}
											}catch (Exception e2){
											}
											try{
												DB d6 = new DB(getActivity());
												util carWh1 = d6.getCarR(6);
												if(!carWh1.getValor2().toString().equals("")){
													util post = new util();
													post.setProd1(carWh1.getProd2());
													post.setQuant1(carWh1.getQuant2());
													post.setValor1(carWh1.getValor2());
													post.setImage(carWh1.getImage2());
													db.vendasCIn(post);
												}else{
												}
											}catch (Exception e2){
											}
											try{
												DB d7 = new DB(getActivity());
												util carWh1 = d7.getCarR(7);
												if(!carWh1.getValor2().toString().equals("")){
													util post = new util();
													post.setProd1(carWh1.getProd2());
													post.setQuant1(carWh1.getQuant2());
													post.setValor1(carWh1.getValor2());
													post.setImage(carWh1.getImage2());
													db.vendasCIn(post);
												}else{
												}
											}catch (Exception e2){
											}
											try{
												DB d8 = new DB(getActivity());
												util carWh1 = d8.getCarR(8);
												if(!carWh1.getValor2().toString().equals("")){
													util post = new util();
													post.setProd1(carWh1.getProd2());
													post.setQuant1(carWh1.getQuant2());
													post.setValor1(carWh1.getValor2());
													post.setImage(carWh1.getImage2());
													db.vendasCIn(post);
												}else{
												}
											}catch (Exception e2){
											}
											try{
												DB d9 = new DB(getActivity());
												util carWh1 = d9.getCarR(9);
												if(!carWh1.getValor2().toString().equals("")){
													util post = new util();
													post.setProd1(carWh1.getProd2());
													post.setQuant1(carWh1.getQuant2());
													post.setValor1(carWh1.getValor2());
													post.setImage(carWh1.getImage2());
													db.vendasCIn(post);
												}else{
												}
											}catch (Exception e2){
											}
											try{
												DB d10 = new DB(getActivity());
												util carWh1 = d10.getCarR(10);
												if(!carWh1.getValor2().toString().equals("")){
													util post = new util();
													post.setProd1(carWh1.getProd2());
													post.setQuant1(carWh1.getQuant2());
													post.setValor1(carWh1.getValor2());
													post.setImage(carWh1.getImage2());
													db.vendasCIn(post);
												}else{
												}
											}catch (Exception e2){
											}
											try{
												DB d11 = new DB(getActivity());
												util carWh1 = d11.getCarR(11);
												if(!carWh1.getValor2().toString().equals("")){
													util post = new util();
													post.setProd1(carWh1.getProd2());
													post.setQuant1(carWh1.getQuant2());
													post.setValor1(carWh1.getValor2());
													post.setImage(carWh1.getImage2());
													db.vendasCIn(post);
												}else{
												}
											}catch (Exception e2){
											}
											try {
												File sd = Environment.getExternalStorageDirectory();
												File data = Environment.getDataDirectory();

												if (sd.canWrite()) {
													String  currentDBPath= "//data//" + getActivity().getOpPackageName()
															+ "//databases//" + "myDB.db";
													String  currentDBPath2 = "//data//" + getActivity().getOpPackageName()
															+ "//databases//" + "myDB.db-shm";
													String  currentDBPath3 = "//data//" + getActivity().getOpPackageName()
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
								} catch (Exception e){
									try{
										DB db2 = new DB(getActivity());
										util carWh1 = db.getCarR(1);
										if(!carWh1.getValor2().toString().equals("")){
											String dateTime;
											Calendar calendar = Calendar.getInstance();
											SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
											dateTime = simpleDateFormat.format(calendar.getTime()).toString();
											util post = new util();
											post.setProd1(carWh1.getProd2());
											post.setQuant1(carWh1.getQuant2());
											post.setValor1(carWh1.getValor2());
											post.setImage(carWh1.getImage2());

											util post2 = new util();
											post2.setData(dateTime);
											post2.setProd1(carWh1.getProd2());
											post2.setValor1(result);
											db2.vendasIn(post2);
											db2.vendasBIn(post);
										}else{
										}
									}catch (Exception e2){
									}
									try{
										DB db3 = new DB(getActivity());
										util carWh1 = db3.getCarR(2);
										if(!carWh1.getValor2().toString().equals("")){
											util post = new util();
											post.setProd1(carWh1.getProd2());
											post.setQuant1(carWh1.getQuant2());
											post.setValor1(carWh1.getValor2());
											post.setImage(carWh1.getImage2());
											db.vendasBIn(post);
										}else{
										}
									}catch (Exception e2){
									}
									try{
										DB db4 = new DB(getActivity());
										util carWh1 = db4.getCarR(3);
										if(!carWh1.getValor2().toString().equals("")){
											util post = new util();
											post.setProd1(carWh1.getProd2());
											post.setQuant1(carWh1.getQuant2());
											post.setValor1(carWh1.getValor2());
											post.setImage(carWh1.getImage2());
											db.vendasBIn(post);
										}else{
										}
									}catch (Exception e2){
									}
									try{
										DB db5 = new DB(getActivity());
										util carWh1 = db5.getCarR(4);
										if(!carWh1.getValor2().toString().equals("")){
											util post = new util();
											post.setProd1(carWh1.getProd2());
											post.setQuant1(carWh1.getQuant2());
											post.setValor1(carWh1.getValor2());
											post.setImage(carWh1.getImage2());
											db.vendasBIn(post);
										}else{
										}
									}catch (Exception e2){
									}
									try{
										DB db6 = new DB(getActivity());
										util carWh1 = db6.getCarR(5);
										if(!carWh1.getValor2().toString().equals("")){
											util post = new util();
											post.setProd1(carWh1.getProd2());
											post.setQuant1(carWh1.getQuant2());
											post.setValor1(carWh1.getValor2());
											post.setImage(carWh1.getImage2());
											db.vendasBIn(post);
										}else{
										}
									}catch (Exception e2){
									}
									try{
										DB db7 = new DB(getActivity());
										util carWh1 = db7.getCarR(6);
										if(!carWh1.getValor2().toString().equals("")){
											util post = new util();
											post.setProd1(carWh1.getProd2());
											post.setQuant1(carWh1.getQuant2());
											post.setValor1(carWh1.getValor2());
											post.setImage(carWh1.getImage2());
											db.vendasBIn(post);
										}else{
										}
									}catch (Exception e2){
									}
									try{
										DB db8 = new DB(getActivity());
										util carWh1 = db8.getCarR(7);
										if(!carWh1.getValor2().toString().equals("")){
											util post = new util();
											post.setProd1(carWh1.getProd2());
											post.setQuant1(carWh1.getQuant2());
											post.setValor1(carWh1.getValor2());
											post.setImage(carWh1.getImage2());
											db.vendasBIn(post);
										}else{
										}
									}catch (Exception e2){
									}
									try{
										DB db9 = new DB(getActivity());
										util carWh1 = db9.getCarR(8);
										if(!carWh1.getValor2().toString().equals("")){
											util post = new util();
											post.setProd1(carWh1.getProd2());
											post.setQuant1(carWh1.getQuant2());
											post.setValor1(carWh1.getValor2());
											post.setImage(carWh1.getImage2());
											db.vendasBIn(post);
										}else{
										}
									}catch (Exception e2){
									}
									try{
										DB db10 = new DB(getActivity());
										util carWh1 = db10.getCarR(9);
										if(!carWh1.getValor2().toString().equals("")){
											util post = new util();
											post.setProd1(carWh1.getProd2());
											post.setQuant1(carWh1.getQuant2());
											post.setValor1(carWh1.getValor2());
											post.setImage(carWh1.getImage2());
											db.vendasBIn(post);
										}else{
										}
									}catch (Exception e2){
									}
									try{
										DB db11 = new DB(getActivity());
										util carWh1 = db11.getCarR(10);
										if(!carWh1.getValor2().toString().equals("")){
											util post = new util();
											post.setProd1(carWh1.getProd2());
											post.setQuant1(carWh1.getQuant2());
											post.setValor1(carWh1.getValor2());
											post.setImage(carWh1.getImage2());
											db.vendasBIn(post);
										}else{
										}
									}catch (Exception e2){
									}
									try{
										DB db12 = new DB(getActivity());
										util carWh1 = db12.getCarR(11);
										if(!carWh1.getValor2().toString().equals("")){
											util post = new util();
											post.setProd1(carWh1.getProd2());
											post.setQuant1(carWh1.getQuant2());
											post.setValor1(carWh1.getValor2());
											post.setImage(carWh1.getImage2());
											db.vendasBIn(post);
										}else{
										}
									}catch (Exception e2){
									}
									try {
										File sd = Environment.getExternalStorageDirectory();
										File data = Environment.getDataDirectory();

										if (sd.canWrite()) {
											String  currentDBPath= "//data//" + getActivity().getOpPackageName()
													+ "//databases//" + "myDB.db";
											String  currentDBPath2 = "//data//" + getActivity().getOpPackageName()
													+ "//databases//" + "myDB.db-shm";
											String  currentDBPath3 = "//data//" + getActivity().getOpPackageName()
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
							}else {
							}
						}catch (Exception e){
							try{
								DB db = new DB(getActivity());
								util carWh1 = db.getCarR(1);
								if(!carWh1.getValor2().toString().equals("")){
									String dateTime;
									Calendar calendar = Calendar.getInstance();
									SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
									dateTime = simpleDateFormat.format(calendar.getTime()).toString();

									util post = new util();
									post.setProd1(carWh1.getProd2());
									post.setQuant1(carWh1.getQuant2());
									post.setValor1(carWh1.getValor2());
									post.setImage(carWh1.getImage2());

									util post2 = new util();
									post2.setData(dateTime);
									post2.setProd1(carWh1.getProd2());
									post2.setValor1(result);
									db.vendasIn(post2);

									db.vendasAIn(post);
								}else{
								}
							}catch (Exception e2){
							}
							try{
								DB db = new DB(getActivity());
								util carWh1 = db.getCarR(2);
								if(!carWh1.getValor2().toString().equals("")){
									util post = new util();
									post.setProd1(carWh1.getProd2());
									post.setQuant1(carWh1.getQuant2());
									post.setValor1(carWh1.getValor2());
									post.setImage(carWh1.getImage2());
									db.vendasAIn(post);
								}else{
								}
							}catch (Exception e2){
							}
							try{
								DB db = new DB(getActivity());
								util carWh1 = db.getCarR(3);
								if(!carWh1.getValor2().toString().equals("")){
									util post = new util();
									post.setProd1(carWh1.getProd2());
									post.setQuant1(carWh1.getQuant2());
									post.setValor1(carWh1.getValor2());
									post.setImage(carWh1.getImage2());
									db.vendasAIn(post);
								}else{
								}
							}catch (Exception e2){
							}
							try{
								DB db = new DB(getActivity());
								util carWh1 = db.getCarR(4);
								if(!carWh1.getValor2().toString().equals("")){
									util post = new util();
									post.setProd1(carWh1.getProd2());
									post.setQuant1(carWh1.getQuant2());
									post.setValor1(carWh1.getValor2());
									post.setImage(carWh1.getImage2());
									db.vendasAIn(post);
								}else{
								}
							}catch (Exception e2){
							}
							try{
								DB db = new DB(getActivity());
								util carWh1 = db.getCarR(5);
								if(!carWh1.getValor2().toString().equals("")){
									util post = new util();
									post.setProd1(carWh1.getProd2());
									post.setQuant1(carWh1.getQuant2());
									post.setValor1(carWh1.getValor2());
									post.setImage(carWh1.getImage2());
									db.vendasAIn(post);
								}else{
								}
							}catch (Exception e2){
							}
							try{
								DB db = new DB(getActivity());
								util carWh1 = db.getCarR(6);
								if(!carWh1.getValor2().toString().equals("")){
									util post = new util();
									post.setProd1(carWh1.getProd2());
									post.setQuant1(carWh1.getQuant2());
									post.setValor1(carWh1.getValor2());
									post.setImage(carWh1.getImage2());
									db.vendasAIn(post);
								}else{
								}
							}catch (Exception e2){
							}
							try{
								DB db = new DB(getActivity());
								util carWh1 = db.getCarR(7);
								if(!carWh1.getValor2().toString().equals("")){
									util post = new util();
									post.setProd1(carWh1.getProd2());
									post.setQuant1(carWh1.getQuant2());
									post.setValor1(carWh1.getValor2());
									post.setImage(carWh1.getImage2());
									db.vendasAIn(post);
								}else{
								}
							}catch (Exception e2){
							}
							try{
								DB db = new DB(getActivity());
								util carWh1 = db.getCarR(8);
								if(!carWh1.getValor2().toString().equals("")){
									util post = new util();
									post.setProd1(carWh1.getProd2());
									post.setQuant1(carWh1.getQuant2());
									post.setValor1(carWh1.getValor2());
									post.setImage(carWh1.getImage2());
									db.vendasAIn(post);
								}else{
								}
							}catch (Exception e2){
							}
							try{
								DB db = new DB(getActivity());
								util carWh1 = db.getCarR(9);
								if(!carWh1.getValor2().toString().equals("")){
									util post = new util();
									post.setProd1(carWh1.getProd2());
									post.setQuant1(carWh1.getQuant2());
									post.setValor1(carWh1.getValor2());
									post.setImage(carWh1.getImage2());
									db.vendasAIn(post);
								}else{
								}
							}catch (Exception e2){
							}
							try{
								DB db = new DB(getActivity());
								util carWh1 = db.getCarR(10);
								if(!carWh1.getValor2().toString().equals("")){
									util post = new util();
									post.setProd1(carWh1.getProd2());
									post.setQuant1(carWh1.getQuant2());
									post.setValor1(carWh1.getValor2());
									post.setImage(carWh1.getImage2());
									db.vendasAIn(post);
								}else{
								}
							}catch (Exception e2){
							}
							try{
								DB db = new DB(getActivity());
								util carWh1 = db.getCarR(11);
								if(!carWh1.getValor2().toString().equals("")){
									util post = new util();
									post.setProd1(carWh1.getProd2());
									post.setQuant1(carWh1.getQuant2());
									post.setValor1(carWh1.getValor2());
									post.setImage(carWh1.getImage2());
									db.vendasAIn(post);
								}else{
								}
							}catch (Exception e2){
							}
							try {
								File sd = Environment.getExternalStorageDirectory();
								File data = Environment.getDataDirectory();

								if (sd.canWrite()) {
									String  currentDBPath= "//data//" + getActivity().getOpPackageName()
											+ "//databases//" + "myDB.db";
									String  currentDBPath2 = "//data//" + getActivity().getOpPackageName()
											+ "//databases//" + "myDB.db-shm";
									String  currentDBPath3 = "//data//" + getActivity().getOpPackageName()
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
						DB db = new DB(getActivity());
						db.limpaCarrinho();
						try {
							File sd = Environment.getExternalStorageDirectory();
							File data = Environment.getDataDirectory();

							if (sd.canWrite()) {
								String  currentDBPath= "//data//" + getActivity().getOpPackageName()
										+ "//databases//" + "myDB.db";
								String  currentDBPath2 = "//data//" + getActivity().getOpPackageName()
										+ "//databases//" + "myDB.db-shm";
								String  currentDBPath3 = "//data//" + getActivity().getOpPackageName()
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
				});
				ap.setNegativeButton("Cancelar!", null);
				ale = ap.create();
				ale = ap.show();
			}
		}catch(Exception e){
			Toast.makeText(getActivity(), "Você precisa adicionar produtos ao Carrinho!!", Toast.LENGTH_LONG).show();
		}
	}
	@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.util_product, menu);
		MenuItem mSearchMenuItem = menu.findItem(R.id.search);
		MenuItem mSearchMenuItem2 = menu.findItem(R.id.logout);
		mSearchMenuItem2.getActionView();
		mSearchMenuItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(@NonNull MenuItem item) {
				getActivity().finishAffinity();
				startActivity(new Intent(getActivity(), Login.class));
				return false;
			}
		});
		SearchView sc = (SearchView) mSearchMenuItem.getActionView();
		sc.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
				@Override
				public boolean onQueryTextSubmit(String s) {
					return false;
				}

				@Override
				public boolean onQueryTextChange(String s) {

					ad2.filter(s);

					return false;
				}
			});
		super.onCreateOptionsMenu(menu,inflater);
	}
	
}
