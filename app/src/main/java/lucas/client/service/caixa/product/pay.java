package lucas.client.service.caixa.product;
import android.app.*;
import android.content.*;
import android.icu.text.*;
import android.os.*;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.io.*;
import java.nio.channels.*;
import java.util.*;
import lucas.client.service.*;
import lucas.client.service.caixa.*;
import lucas.client.service.etc.*;
import lucas.client.service.sqlite.*;
import android.widget.TextView.*;


public class pay extends AppCompatActivity
{
	DB db;
	Context c = this;
	AlertDialog dis;
	Object payT1, payT2, payT3, payT4, payT5;
	int opts1, opts2, opts3, opts4, opts5;
	Button fim, tipo;
	ImageView im1, im2, im3, im4, im5;
	LinearLayout lay1, lay2, lay3, lay4, lay5;
	LinearLayout spnlay2, spnlay3, spnlay4, spnlay5;
	TextInputEditText som1, som2, som3, som4, som5,
	         pagto1, pagto2, pagto3, pagto4, pagto5,
			 troco1, troco2, troco3, troco4, troco5;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		
		LayoutInflater li = getLayoutInflater();
		View r = li.inflate(R.layout.fecha_pedido, null);
		final String[] opts = {"Selecione a Forma de Pagto","Dinheiro", "Elo Débito","Elo Crédito","Visa Débito", "Visa Crédito", "Master Débito", "Master Crédito", "Hiper", "Hiper Card", "Cabal Débito", "Pix", "Verde Card", "Soro Cred", "Ouro Card", "Personal Card", "Banrisul", "Banri Compras", "Banes Card", "American Express"};
		final Spinner spn1 = r.findViewById(R.id.spn1);
		final Spinner spn2 = r.findViewById(R.id.spn2);
		final Spinner spn3 = r.findViewById(R.id.spn3);
		final Spinner spn4 = r.findViewById(R.id.spn4);
		final Spinner spn5 = r.findViewById(R.id.spn5);
		fim = r.findViewById(R.id.finish);
		tipo = r.findViewById(R.id.tipo);
		lay1 = r.findViewById(R.id.lay1);
		Button canc = r.findViewById(R.id.canc);
		lay2 = r.findViewById(R.id.lay2);
		lay3 = r.findViewById(R.id.lay3);
		lay4 = r.findViewById(R.id.lay4);
		lay5 = r.findViewById(R.id.lay5);
		spnlay2 = r.findViewById(R.id.spnlay2);
		spnlay3 = r.findViewById(R.id.spnlay3);
		spnlay4 = r.findViewById(R.id.spnlay4);
		spnlay5 = r.findViewById(R.id.spnlay5);
		som1 = r.findViewById(R.id.som1);
		som2 = r.findViewById(R.id.som2);
		som3 = r.findViewById(R.id.som3);
		som4 = r.findViewById(R.id.som4);
		som5 = r.findViewById(R.id.som5);
		im1 = r.findViewById(R.id.im1);
		im2 = r.findViewById(R.id.im2);
		im3 = r.findViewById(R.id.im3);
		im4 = r.findViewById(R.id.im4);
		im5 = r.findViewById(R.id.im5);
		pagto1 = r.findViewById(R.id.pagto1);
		pagto2 = r.findViewById(R.id.pagto2);
		pagto3 = r.findViewById(R.id.pagto3);
		pagto4 = r.findViewById(R.id.pagto4);
		pagto5 = r.findViewById(R.id.pagto5);
		troco1 = r.findViewById(R.id.troco1);
		troco2 = r.findViewById(R.id.troco2);
		troco3 = r.findViewById(R.id.troco3);
		troco4 = r.findViewById(R.id.troco4);
		troco5 = r.findViewById(R.id.troco5);
		spnlay2.setVisibility(View.GONE);
		spnlay3.setVisibility(View.GONE);
		spnlay4.setVisibility(View.GONE);
		spnlay5.setVisibility(View.GONE);
		lay2.setVisibility(View.GONE);
		lay3.setVisibility(View.GONE);
		lay4.setVisibility(View.GONE);
		lay5.setVisibility(View.GONE);
		
		canc.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					dis.dismiss();
					finish();
					
				}
		});
		Intent it = getIntent();
		Bundle b2 = it.getExtras();
		String val = b2.getString("valor");
		
		som1.setText(val.toString());
		spn1.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		spn2.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		spn3.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		spn4.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		spn5.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		pagto1.setOnEditorActionListener(new OnEditorActionListener(){

				@Override
				public boolean onEditorAction(TextView p1, int p2, KeyEvent p3)
				{
					// TODO: Implement this method
					Double pg1 = new Double(som1.getText().toString());
					Double sub1 = new Double(pagto1.getText().toString());
					double res = sub1 - pg1;
					DecimalFormatSymbols df = new DecimalFormatSymbols();
					df.setGroupingSeparator('.');
					df.setDecimalSeparator('.');
					DecimalFormat dform = new DecimalFormat("####.##", df);
					troco1.setText(dform.format(res));
					return false;
				}
		});
		pagto2.setOnEditorActionListener(new OnEditorActionListener(){

				@Override
				public boolean onEditorAction(TextView p1, int p2, KeyEvent p3)
				{
					// TODO: Implement this method
					Double pg1 = new Double(som2.getText().toString());
					Double sub1 = new Double(pagto2.getText().toString());
					double res = sub1 - pg1;
					DecimalFormatSymbols df = new DecimalFormatSymbols();
					df.setGroupingSeparator('.');
					df.setDecimalSeparator('.');
					DecimalFormat dform = new DecimalFormat("####.##", df);
					troco2.setText(dform.format(res));
					return false;
				}
			});
		pagto3.setOnEditorActionListener(new OnEditorActionListener(){

				@Override
				public boolean onEditorAction(TextView p1, int p2, KeyEvent p3)
				{
					// TODO: Implement this method
					Double pg1 = new Double(som3.getText().toString());
					Double sub1 = new Double(pagto3.getText().toString());
					double res = sub1 - pg1;
					DecimalFormatSymbols df = new DecimalFormatSymbols();
					df.setGroupingSeparator('.');
					df.setDecimalSeparator('.');
					DecimalFormat dform = new DecimalFormat("####.##", df);
					troco3.setText(dform.format(res));
					return false;
				}
			});
		pagto4.setOnEditorActionListener(new OnEditorActionListener(){

				@Override
				public boolean onEditorAction(TextView p1, int p2, KeyEvent p3)
				{
					
					// TODO: Implement this method
					Double pg1 = new Double(som4.getText().toString());
					Double sub1 = new Double(pagto4.getText().toString());
					double res = sub1 - pg1;
					DecimalFormatSymbols df = new DecimalFormatSymbols();
					df.setGroupingSeparator('.');
					df.setDecimalSeparator('.');
					DecimalFormat dform = new DecimalFormat("####.##", df);
					troco4.setText(dform.format(res));
					return false;
				}
			});
		pagto5.setOnEditorActionListener(new OnEditorActionListener(){

				@Override
				public boolean onEditorAction(TextView p1, int p2, KeyEvent p3)
				{
					// TODO: Implement this method
					Double pg1 = new Double(som5.getText().toString());
					Double sub1 = new Double(pagto5.getText().toString());
					double res = sub1 - pg1;
					DecimalFormatSymbols df = new DecimalFormatSymbols();
					df.setGroupingSeparator('.');
					df.setDecimalSeparator('.');
					DecimalFormat dform = new DecimalFormat("####.##", df);
					troco5.setText(dform.format(res));
					return false;
				}
			});
		fim.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					DB de = new DB(c);
					de.limpaCarrinho();
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
					Intent itt = new Intent(c, caixaMain.class);
					startActivity(itt);
					
				}
			});
		tipo.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					String[] op = new String[] {"2 Pagamentos", "3 Pagamentos", "4 Pagamentos", "5 Pagamentos"};
					AlertDialog.Builder sel = new AlertDialog.Builder(pay.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
					sel.setTitle("+1 Tipo Pagto");
					sel.setItems(op, new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface p1, int p2)
							{
								// TODO: Implement this method
								switch(p2){
									case 0:
										spnlay2.setVisibility(View.VISIBLE);
										Double so1 = new Double(som1.getText().toString());
										double res = so1 /2;
										DecimalFormatSymbols df = new DecimalFormatSymbols();
										df.setGroupingSeparator('.');
										df.setDecimalSeparator('.');
										DecimalFormat dform = new DecimalFormat("####.##", df);
										som1.getText().clear();
										som1.setText(dform.format(res));
										som2.setText(dform.format(res));
										break;
									case 1:
										spnlay2.setVisibility(View.VISIBLE);
										spnlay3.setVisibility(View.VISIBLE);
										Double so2 = new Double(som1.getText().toString());
										double res2 = so2 /3;
										DecimalFormatSymbols df2 = new DecimalFormatSymbols();
										df2.setGroupingSeparator('.');
										df2.setDecimalSeparator('.');
										DecimalFormat dform2 = new DecimalFormat("####.##", df2);
										som1.setText(dform2.format(res2));
										som2.setText(dform2.format(res2));
										som3.setText(dform2.format(res2));
										break;
									case 2:
										spnlay2.setVisibility(View.VISIBLE);
										spnlay3.setVisibility(View.VISIBLE);
										spnlay4.setVisibility(View.VISIBLE);
										Double so3 = new Double(som1.getText().toString());
										double res3 = so3 /4;
										DecimalFormatSymbols df3 = new DecimalFormatSymbols();
										df3.setGroupingSeparator('.');
										df3.setDecimalSeparator('.');
										DecimalFormat dform3 = new DecimalFormat("####.##", df3);
										som1.setText(dform3.format(res3));
										som2.setText(dform3.format(res3));
										som3.setText(dform3.format(res3));
										som4.setText(dform3.format(res3));
										break;
									case 3:
										Double so4 = new Double(som1.getText().toString());
										double res4 = so4 /5;
										DecimalFormatSymbols df4 = new DecimalFormatSymbols();
										df4.setGroupingSeparator('.');
										df4.setDecimalSeparator('.');
										DecimalFormat dform4 = new DecimalFormat("####.##", df4);
										som1.setText(dform4.format(res4));
										som2.setText(dform4.format(res4));
										som3.setText(dform4.format(res4));
										som4.setText(dform4.format(res4));
										som5.setText(dform4.format(res4));
										spnlay2.setVisibility(View.VISIBLE);
										spnlay3.setVisibility(View.VISIBLE);
										spnlay4.setVisibility(View.VISIBLE);
										spnlay5.setVisibility(View.VISIBLE);
										break;
								}
							}
						});
					sel.create();
					sel.show();
				}
			});
		spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					payT1 = opts[p3].toString();
					
					if(opts[p3].toString().startsWith("Dinheiro")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(90,85);
						pr.setMargins(+15,+15,+10,0);
						som1.setEms(5);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.money);
						lay1.setVisibility(View.VISIBLE);
							try{
								db = new DB(c);
								List<util> rd;
								rd = db.moFind();
								if(!rd.get(0).getMoney().equals("")){
									String re1 = rd.get(0).getMoney();
									String re2 = som1.getText().toString();
									Double d0 = new Double(re1);
									Double d1 = new Double(re2);
									double res = d0 + d1;
									DecimalFormatSymbols df = new DecimalFormatSymbols();
									df.setGroupingSeparator('.');
									df.setDecimalSeparator('.');
									DecimalFormat dform = new DecimalFormat("####.##", df);
									util us = new util();
									us.setMoney(dform.format(res));
									db.delMoney();
									db.moneyIn(us);	
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
								us.setMoney(som1.getText().toString());
								DB d1 = new DB(c);
								d1.moneyIn(us);
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
					} else {lay1.setVisibility(View.GONE);}
					if(opts[p3].toString().startsWith("Selecione")){
						im1.setVisibility(View.GONE);
						som1.setEms(7);
					}
					if(opts[p3].toString().startsWith("Elo Débito")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som1.setEms(4);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloDFind();
							if(!rd.get(0).getEloD().equals("")){
								String re1 = rd.get(0).getEloD();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setEloD(dform.format(res));
								db.delEloD();
								db.eloDIn(us);	
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
							us.setEloD(som1.getText().toString());
							DB d1 = new DB(c);
							d1.eloDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Elo Crédito")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som1.setEms(4);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloCFind();
							if(!rd.get(0).getEloC().equals("")){
								String re1 = rd.get(0).getEloC();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setEloC(dform.format(res));
								db.delEloC();
								db.eloCIn(us);	
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
							us.setEloC(som1.getText().toString());
							DB d1 = new DB(c);
							d1.eloCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Visa Débito")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som1.setEms(4);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaDFind();
							if(!rd.get(0).getVisaD().equals("")){
								String re1 = rd.get(0).getVisaD();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVisaD(dform.format(res));
								db.delVisaD();
								db.visaDIn(us);	
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
							us.setVisaD(som1.getText().toString());
							DB d1 = new DB(c);
							d1.visaDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Visa Crédito")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som1.setEms(4);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaCFind();
							if(!rd.get(0).getVisaC().equals("")){
								String re1 = rd.get(0).getVisaC();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVisaC(dform.format(res));
								db.delVisaC();
								db.visaCIn(us);	
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
							us.setVisaC(som1.getText().toString());
							DB d1 = new DB(c);
							d1.visaCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Master Débito")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som1.setEms(4);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterDFind();
							if(!rd.get(0).getMasterD().equals("")){
								String re1 = rd.get(0).getMasterD();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMasterD(dform.format(res));
								db.delMasterD();
								db.masterDIn(us);	
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
							us.setMasterD(som1.getText().toString());
							DB d1 = new DB(c);
							d1.masterDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Master Crédito")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som1.setEms(4);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterCFind();
							if(!rd.get(0).getMasterC().equals("")){
								String re1 = rd.get(0).getMasterC();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMasterC(dform.format(res));
								db.delMasterC();
								db.masterCIn(us);	
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
							us.setMasterC(som1.getText().toString());
							DB d1 = new DB(c);
							d1.masterCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Hiper")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(55,50);
						pr.setMargins(+15,+30,+5,0);
						som1.setEms(6);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.hiper);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperFind();
							if(!rd.get(0).getHiper().equals("")){
								String re1 = rd.get(0).getHiper();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setHiper(dform.format(res));
								db.delHiper();
								db.hiperIn(us);	
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
							us.setHiper(som1.getText().toString());
							DB d1 = new DB(c);
							d1.hiperIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Hiper Card")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(85,80);
						pr.setMargins(+15,+15,+5,0);
						som1.setEms(4);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.hiperc);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperCFind();
							if(!rd.get(0).getHiperC().equals("")){
								String re1 = rd.get(0).getHiperC();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setHiperC(dform.format(res));
								db.delHiperC();
								db.hiperCIn(us);	
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
							us.setHiperC(som1.getText().toString());
							DB d1 = new DB(c);
							d1.hiperCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Cabal")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+35,+5,0);
						som1.setEms(4);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.cabal);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.cabalFind();
							if(!rd.get(0).getCabal().equals("")){
								String re1 = rd.get(0).getCabal();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setCabal(dform.format(res));
								db.delCabal();
								db.cabalIn(us);	
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
							us.setCabal(som1.getText().toString());
							DB d1 = new DB(c);
							d1.cabalIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Pix")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+15,0,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.pix);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.pixFind();
							if(!rd.get(0).getPix().equals("")){
								String re1 = rd.get(0).getPix();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setPix(dform.format(res));
								db.delPix();
								db.pixIn(us);	
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
							us.setPix(som1.getText().toString());
							DB d1 = new DB(c);
							d1.pixIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Verde Card")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+20,+5,0);
						som1.setEms(5);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.verde);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.verdeFind();
							if(!rd.get(0).getVerde().equals("")){
								String re1 = rd.get(0).getVerde();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVerde(dform.format(res));
								db.delVerde();
								db.verdeIn(us);	
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
							us.setVerde(som1.getText().toString());
							DB d1 = new DB(c);
							d1.verdeIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Soro Cred")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+20,+5,0);
						som1.setEms(5);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.soro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.soroFind();
							if(!rd.get(0).getSoro().equals("")){
								String re1 = rd.get(0).getSoro();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setSoro(dform.format(res));
								db.delSoro();
								db.soroIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setSoro(som1.getText().toString());
							DB d1 = new DB(c);
							d1.soroIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Personal Card")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som1.setEms(4);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.person);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.personFind();
							if(!rd.get(0).getPerson().equals("")){
								String re1 = rd.get(0).getPerson();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setPerson(dform.format(res));
								db.delPerson();
								db.personIn(us);	
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
							us.setPerson(som1.getText().toString());
							DB d1 = new DB(c);
							d1.personIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Ouro Card")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(70,60);
						pr.setMargins(+15,+25,+5,0);
						som1.setEms(5);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.ouro_card);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ouroFind();
							if(!rd.get(0).getOuro().equals("")){
								String re1 = rd.get(0).getOuro();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setOuro(dform.format(res));
								db.delOuro();
								db.ouroIn(us);	
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
							us.setOuro(som1.getText().toString());
							DB d1 = new DB(c);
							d1.ouroIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banrisul")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,+5,0);
						som1.setEms(5);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.banric);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriFind();
							if(!rd.get(0).getbanric().equals("")){
								String re1 = rd.get(0).getbanric();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanric(dform.format(res));
								db.delBanric();
								db.banriIn(us);	
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
							us.setBanric(som1.getText().toString());
							DB d1 = new DB(c);
							d1.banriIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banri Compras")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+25,+5,0);
						som1.setEms(4);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.banrico);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriCFind();
							if(!rd.get(0).getBanriC().equals("")){
								String re1 = rd.get(0).getBanriC();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanriC(dform.format(res));
								db.delBanriC();
								db.banriCIn(us);	
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
							us.setBanriC(som1.getText().toString());
							DB d1 = new DB(c);
							d1.banriCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banes Card")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som1.setEms(4);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.banes);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banesFind();
							if(!rd.get(0).getBanes().equals("")){
								String re1 = rd.get(0).getBanes();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanes(dform.format(res));
								db.delBanes();
								db.banesIn(us);	
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
							us.setBanes(som1.getText().toString());
							DB d1 = new DB(c);
							d1.banesIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("American Express")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,0,0);
						som1.setEms(4);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.americ);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ameFind();
							if(!rd.get(0).getAmeric().equals("")){
								String re1 = rd.get(0).getAmeric();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setAmeric(dform.format(res));
								db.delAmeric();
								db.americIn(us);	
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
							us.setAmeric(som1.getText().toString());
							DB d1 = new DB(c);
							d1.americIn(us);
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
					} else {}
				}
				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
					
				}
		});
		spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					opts2 = p3;
					if(opts[p3].toString().startsWith("Dinheiro")){
						lay2.setVisibility(View.VISIBLE);
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(90,85);
						pr.setMargins(+15,+15,+10,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.money);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.moFind();
							if(!rd.get(0).getMoney().equals("")){
								String re1 = rd.get(0).getMoney();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMoney(dform.format(res));
								db.delMoney();
								db.moneyIn(us);	
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
							us.setMoney(som2.getText().toString());
							DB d1 = new DB(c);
							d1.moneyIn(us);
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
					} else {lay2.setVisibility(View.GONE);}
					if(opts[p3].toString().startsWith("Selecione")){
						im2.setVisibility(View.GONE);
						som2.setEms(7);
					}
					if(opts[p3].toString().startsWith("Elo Débito")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som2.setEms(4);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloDFind();
							if(!rd.get(0).getEloD().equals("")){
								String re1 = rd.get(0).getEloD();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setEloD(dform.format(res));
								db.delEloD();
								db.eloDIn(us);	
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
							us.setEloD(som2.getText().toString());
							DB d1 = new DB(c);
							d1.eloDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Elo Crédito")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som2.setEms(4);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloCFind();
							if(!rd.get(0).getEloC().equals("")){
								String re1 = rd.get(0).getEloC();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setEloC(dform.format(res));
								db.delEloC();
								db.eloCIn(us);	
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
							us.setEloC(som2.getText().toString());
							DB d1 = new DB(c);
							d1.eloCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Visa Débito")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som2.setEms(4);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaDFind();
							if(!rd.get(0).getVisaD().equals("")){
								String re1 = rd.get(0).getVisaD();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVisaD(dform.format(res));
								db.delVisaD();
								db.visaDIn(us);	
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
							us.setVisaD(som2.getText().toString());
							DB d1 = new DB(c);
							d1.visaDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Visa Crédito")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som2.setEms(4);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaCFind();
							if(!rd.get(0).getVisaC().equals("")){
								String re1 = rd.get(0).getVisaC();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVisaC(dform.format(res));
								db.delVisaC();
								db.visaCIn(us);	
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
							us.setVisaC(som2.getText().toString());
							DB d1 = new DB(c);
							d1.visaCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Master Débito")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som2.setEms(4);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterDFind();
							if(!rd.get(0).getMasterD().equals("")){
								String re1 = rd.get(0).getMasterD();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMasterD(dform.format(res));
								db.delMasterD();
								db.masterDIn(us);	
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
							us.setMasterD(som2.getText().toString());
							DB d1 = new DB(c);
							d1.masterDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Master Crédito")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som2.setEms(4);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterCFind();
							if(!rd.get(0).getMasterC().equals("")){
								String re1 = rd.get(0).getMasterC();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMasterC(dform.format(res));
								db.delMasterC();
								db.masterCIn(us);	
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
							us.setMasterC(som2.getText().toString());
							DB d1 = new DB(c);
							d1.masterCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Hiper")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(55,50);
						pr.setMargins(+15,+30,+5,0);
						som2.setEms(6);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.hiper);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperFind();
							if(!rd.get(0).getHiper().equals("")){
								String re1 = rd.get(0).getHiper();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setHiper(dform.format(res));
								db.delHiper();
								db.hiperIn(us);	
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
							us.setHiper(som2.getText().toString());
							DB d1 = new DB(c);
							d1.hiperIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Hiper Card")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(85,80);
						pr.setMargins(+15,+15,+5,0);
						som2.setEms(4);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.hiperc);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperCFind();
							if(!rd.get(0).getHiperC().equals("")){
								String re1 = rd.get(0).getHiperC();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setHiperC(dform.format(res));
								db.delHiperC();
								db.hiperCIn(us);
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
							us.setHiperC(som2.getText().toString());
							DB d1 = new DB(c);
							d1.hiperCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Cabal")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+35,+5,0);
						som2.setEms(4);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.cabal);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.cabalFind();
							if(!rd.get(0).getCabal().equals("")){
								String re1 = rd.get(0).getCabal();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setCabal(dform.format(res));
								db.delCabal();
								db.cabalIn(us);	
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
							us.setCabal(som2.getText().toString());
							DB d1 = new DB(c);
							d1.cabalIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Pix")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+15,0,0);
						som2.setEms(7);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.pix);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.pixFind();
							if(!rd.get(0).getPix().equals("")){
								String re1 = rd.get(0).getPix();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setPix(dform.format(res));
								db.delPix();
								db.pixIn(us);	
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
							us.setPix(som2.getText().toString());
							DB d1 = new DB(c);
							d1.pixIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Verde Card")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+20,+5,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.verde);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.verdeFind();
							if(!rd.get(0).getVerde().equals("")){
								String re1 = rd.get(0).getVerde();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVerde(dform.format(res));
								db.delVerde();
								db.verdeIn(us);	
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
							us.setVerde(som2.getText().toString());
							DB d1 = new DB(c);
							d1.verdeIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Soro Cred")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+20,+5,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.soro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.soroFind();
							if(!rd.get(0).getSoro().equals("")){
								String re1 = rd.get(0).getSoro();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setSoro(dform.format(res));
								db.delSoro();
								db.soroIn(us);
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
							us.setSoro(som2.getText().toString());
							DB d1 = new DB(c);
							d1.soroIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Personal Card")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som2.setEms(4);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.person);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.personFind();
							if(!rd.get(0).getPerson().equals("")){
								String re1 = rd.get(0).getPerson();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setPerson(dform.format(res));
								db.delPerson();
								db.personIn(us);	
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
							us.setPerson(som2.getText().toString());
							DB d1 = new DB(c);
							d1.personIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Ouro Card")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(70,60);
						pr.setMargins(+15,+25,+5,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.ouro_card);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ouroFind();
							if(!rd.get(0).getOuro().equals("")){
								String re1 = rd.get(0).getOuro();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setOuro(dform.format(res));
								db.delOuro();
								db.ouroIn(us);	
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
							us.setOuro(som2.getText().toString());
							DB d1 = new DB(c);
							d1.ouroIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banrisul")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,+5,0);
						som2.setEms(6);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.banric);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriFind();
							if(!rd.get(0).getbanric().equals("")){
								String re1 = rd.get(0).getbanric();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanric(dform.format(res));
								db.delBanric();
								db.banriIn(us);	
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
							us.setBanric(som2.getText().toString());
							DB d1 = new DB(c);
							d1.banriIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banri Compras")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+25,+5,0);
						som2.setEms(4);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.banrico);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriCFind();
							if(!rd.get(0).getBanriC().equals("")){
								String re1 = rd.get(0).getBanriC();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanriC(dform.format(res));
								db.delBanriC();
								db.banriCIn(us);	
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
							us.setBanriC(som2.getText().toString());
							DB d1 = new DB(c);
							d1.banriCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banes Card")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.banes);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banesFind();
							if(!rd.get(0).getBanes().equals("")){
								String re1 = rd.get(0).getBanes();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanes(dform.format(res));
								db.delBanes();
								db.banesIn(us);
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
							us.setBanes(som2.getText().toString());
							DB d1 = new DB(c);
							d1.banesIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("American Express")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,0,0);
						som2.setEms(4);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.americ);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ameFind();
							if(!rd.get(0).getAmeric().equals("")){
								String re1 = rd.get(0).getAmeric();
								String re2 = som2.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setAmeric(dform.format(res));
								db.delAmeric();
								db.americIn(us);	
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
							us.setAmeric(som2.getText().toString());
							DB d1 = new DB(c);
							d1.americIn(us);
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
					} else {}
				}

				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
					
				}
			});
		spn3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					opts3 = p3;
					if(opts[p3].toString().startsWith("Dinheiro")){
						lay3.setVisibility(View.VISIBLE);
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(90,85);
						pr.setMargins(+15,+15,+10,0);
						som3.setEms(6);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.money);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.moFind();
							if(!rd.get(0).getMoney().equals("")){
								String re1 = rd.get(0).getMoney();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMoney(dform.format(res));
								db.delMoney();
								db.moneyIn(us);	
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
							us.setMoney(som3.getText().toString());
							DB d1 = new DB(c);
							d1.moneyIn(us);
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
					} else {lay3.setVisibility(View.GONE);}
					if(opts[p3].toString().startsWith("Selecione")){
						im3.setVisibility(View.GONE);
						som3.setEms(7);
					}
					if(opts[p3].toString().startsWith("Elo Débito")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloDFind();
							if(!rd.get(0).getEloD().equals("")){
								String re1 = rd.get(0).getEloD();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setEloD(dform.format(res));
								db.delEloD();
								db.eloDIn(us);	
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
							us.setEloD(som3.getText().toString());
							DB d1 = new DB(c);
							d1.eloDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Elo Crédito")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloCFind();
							if(!rd.get(0).getEloC().equals("")){
								String re1 = rd.get(0).getEloC();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setEloC(dform.format(res));
								db.delEloC();
								db.eloCIn(us);	
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
							us.setEloC(som3.getText().toString());
							DB d1 = new DB(c);
							d1.eloCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Visa Débito")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaDFind();
							if(!rd.get(0).getVisaD().equals("")){
								String re1 = rd.get(0).getVisaD();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVisaD(dform.format(res));
								db.delVisaD();
								db.visaDIn(us);	
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
							us.setVisaD(som3.getText().toString());
							DB d1 = new DB(c);
							d1.visaDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Visa Crédito")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaCFind();
							if(!rd.get(0).getVisaC().equals("")){
								String re1 = rd.get(0).getVisaC();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVisaC(dform.format(res));
								db.delVisaC();
								db.visaCIn(us);	
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
							us.setVisaC(som3.getText().toString());
							DB d1 = new DB(c);
							d1.visaCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Master Débito")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterDFind();
							if(!rd.get(0).getMasterD().equals("")){
								String re1 = rd.get(0).getMasterD();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMasterD(dform.format(res));
								db.delMasterD();
								db.masterDIn(us);
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
							us.setMasterD(som3.getText().toString());
							DB d1 = new DB(c);
							d1.masterDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Master Crédito")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterCFind();
							if(!rd.get(0).getMasterC().equals("")){
								String re1 = rd.get(0).getMasterC();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMasterC(dform.format(res));
								db.delMasterC();
								db.masterCIn(us);	
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
							us.setMasterC(som3.getText().toString());
							DB d1 = new DB(c);
							d1.masterCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Hiper")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(55,50);
						pr.setMargins(+15,+30,+5,0);
						som3.setEms(8);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.hiper);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperFind();
							if(!rd.get(0).getHiper().equals("")){
								String re1 = rd.get(0).getHiper();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setHiper(dform.format(res));
								db.delHiper();
								db.hiperIn(us);	
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
							us.setHiper(som3.getText().toString());
							DB d1 = new DB(c);
							d1.hiperIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Hiper Card")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(85,80);
						pr.setMargins(+15,+15,+5,0);
						som3.setEms(6);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.hiperc);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperCFind();
							if(!rd.get(0).getHiperC().equals("")){
								String re1 = rd.get(0).getHiperC();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setHiperC(dform.format(res));
								db.delHiperC();
								db.hiperCIn(us);	
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
							us.setHiperC(som3.getText().toString());
							DB d1 = new DB(c);
							d1.hiperCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Cabal")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+35,+5,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.cabal);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.cabalFind();
							if(!rd.get(0).getCabal().equals("")){
								String re1 = rd.get(0).getCabal();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setCabal(dform.format(res));
								db.delCabal();
								db.cabalIn(us);	
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
							us.setCabal(som3.getText().toString());
							DB d1 = new DB(c);
							d1.cabalIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Pix")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+15,0,0);
						som3.setEms(8);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.pix);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.pixFind();
							if(!rd.get(0).getPix().equals("")){
								String re1 = rd.get(0).getPix();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setPix(dform.format(res));
								db.delPix();
								db.pixIn(us);
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
							us.setPix(som3.getText().toString());
							DB d1 = new DB(c);
							d1.pixIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Verde Card")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+20,+5,0);
						som3.setEms(6);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.verde);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.verdeFind();
							if(!rd.get(0).getVerde().equals("")){
								String re1 = rd.get(0).getVerde();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVerde(dform.format(res));
								db.delVerde();
								db.verdeIn(us);	
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
							us.setVerde(som3.getText().toString());
							DB d1 = new DB(c);
							d1.verdeIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Soro Cred")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+20,+5,0);
						som3.setEms(6);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.soro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.soroFind();
							if(!rd.get(0).getSoro().equals("")){
								String re1 = rd.get(0).getSoro();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setSoro(dform.format(res));
								db.delSoro();
								db.soroIn(us);	
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
							us.setSoro(som3.getText().toString());
							DB d1 = new DB(c);
							d1.soroIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Personal Card")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.person);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.personFind();
							if(!rd.get(0).getPerson().equals("")){
								String re1 = rd.get(0).getPerson();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setPerson(dform.format(res));
								db.delPerson();
								db.personIn(us);	
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
							us.setPerson(som3.getText().toString());
							DB d1 = new DB(c);
							d1.personIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Ouro Card")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(70,60);
						pr.setMargins(+15,+25,+5,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.ouro_card);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ouroFind();
							if(!rd.get(0).getOuro().equals("")){
								String re1 = rd.get(0).getOuro();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setOuro(dform.format(res));
								db.delOuro();
								db.ouroIn(us);	
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
							us.setOuro(som3.getText().toString());
							DB d1 = new DB(c);
							d1.ouroIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banrisul")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,+5,0);
						som3.setEms(6);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.banric);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriFind();
							if(!rd.get(0).getbanric().equals("")){
								String re1 = rd.get(0).getbanric();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanric(dform.format(res));
								db.delBanric();
								db.banriIn(us);	
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
							us.setBanric(som3.getText().toString());
							DB d1 = new DB(c);
							d1.banriIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banri Compras")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+25,+5,0);
						som3.setEms(6);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.banrico);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriCFind();
							if(!rd.get(0).getBanriC().equals("")){
								String re1 = rd.get(0).getBanriC();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanriC(dform.format(res));
								db.delBanriC();
								db.banriCIn(us);	
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
							us.setBanriC(som3.getText().toString());
							DB d1 = new DB(c);
							d1.banriCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banes Card")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som3.setEms(6);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.banes);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banesFind();
							if(!rd.get(0).getBanes().equals("")){
								String re1 = rd.get(0).getBanes();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanes(dform.format(res));
								db.delBanes();
								db.banesIn(us);	
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
							us.setBanes(som3.getText().toString());
							DB d1 = new DB(c);
							d1.banesIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("American Express")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,0,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.americ);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ameFind();
							if(!rd.get(0).getAmeric().equals("")){
								String re1 = rd.get(0).getAmeric();
								String re2 = som3.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setAmeric(dform.format(res));
								db.delAmeric();
								db.americIn(us);	
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
							us.setAmeric(som3.getText().toString());
							DB d1 = new DB(c);
							d1.americIn(us);
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
					} else {}
				}

				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
				}
			});
		spn4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					opts4 = p3;
					if(opts[p3].toString().startsWith("Dinheiro")){
						lay4.setVisibility(View.VISIBLE);
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(90,85);
						pr.setMargins(+15,+15,+10,0);
						som4.setEms(6);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.money);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.moFind();
							if(!rd.get(0).getMoney().equals("")){
								String re1 = rd.get(0).getMoney();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMoney(dform.format(res));
								db.delMoney();
								db.moneyIn(us);	
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
							us.setMoney(som4.getText().toString());
							DB d1 = new DB(c);
							d1.moneyIn(us);
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
					} else {lay4.setVisibility(View.GONE);}
					if(opts[p3].toString().startsWith("Selecione")){
						im4.setVisibility(View.GONE);
						som4.setEms(7);
					}
					if(opts[p3].toString().startsWith("Elo Débito")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloDFind();
							if(!rd.get(0).getEloD().equals("")){
								String re1 = rd.get(0).getEloD();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setEloD(dform.format(res));
								db.delEloD();
								db.eloDIn(us);	
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
							us.setEloD(som4.getText().toString());
							DB d1 = new DB(c);
							d1.eloDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Elo Crédito")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloCFind();
							if(!rd.get(0).getEloC().equals("")){
								String re1 = rd.get(0).getEloC();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setEloC(dform.format(res));
								db.delEloC();
								db.eloCIn(us);	
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
							us.setEloC(som4.getText().toString());
							DB d1 = new DB(c);
							d1.eloCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Visa Débito")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaDFind();
							if(!rd.get(0).getVisaD().equals("")){
								String re1 = rd.get(0).getVisaD();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVisaD(dform.format(res));
								db.delVisaD();
								db.visaDIn(us);	
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
							us.setVisaD(som4.getText().toString());
							DB d1 = new DB(c);
							d1.visaDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Visa Crédito")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaCFind();
							if(!rd.get(0).getVisaC().equals("")){
								String re1 = rd.get(0).getVisaC();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVisaC(dform.format(res));
								db.delVisaC();
								db.visaCIn(us);	
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
							us.setVisaC(som4.getText().toString());
							DB d1 = new DB(c);
							d1.visaCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Master Débito")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterDFind();
							if(!rd.get(0).getMasterD().equals("")){
								String re1 = rd.get(0).getMasterD();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMasterD(dform.format(res));
								db.delMasterD();
								db.masterDIn(us);	
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
							us.setMasterD(som4.getText().toString());
							DB d1 = new DB(c);
							d1.masterDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Master Crédito")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterCFind();
							if(!rd.get(0).getMasterC().equals("")){
								String re1 = rd.get(0).getMasterC();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMasterC(dform.format(res));
								db.delMasterC();
								db.masterCIn(us);	
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
							us.setMasterC(som4.getText().toString());
							DB d1 = new DB(c);
							d1.masterCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Hiper")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(55,50);
						pr.setMargins(+15,+30,+5,0);
						som4.setEms(8);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.hiper);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperFind();
							if(!rd.get(0).getHiper().equals("")){
								String re1 = rd.get(0).getHiper();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setHiper(dform.format(res));
								db.delHiper();
								db.hiperIn(us);	
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
							us.setHiper(som4.getText().toString());
							DB d1 = new DB(c);
							d1.hiperIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Hiper Card")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(85,80);
						pr.setMargins(+15,+15,+5,0);
						som4.setEms(6);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.hiperc);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperCFind();
							if(!rd.get(0).getHiperC().equals("")){
								String re1 = rd.get(0).getHiperC();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setHiperC(dform.format(res));
								db.delHiperC();
								db.hiperCIn(us);	
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
							us.setHiperC(som4.getText().toString());
							DB d1 = new DB(c);
							d1.hiperCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Cabal")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+35,+5,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.cabal);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.cabalFind();
							if(!rd.get(0).getCabal().equals("")){
								String re1 = rd.get(0).getCabal();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setCabal(dform.format(res));
								db.delCabal();
								db.cabalIn(us);	
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
							us.setCabal(som4.getText().toString());
							DB d1 = new DB(c);
							d1.cabalIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Pix")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+15,0,0);
						som4.setEms(8);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.pix);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.pixFind();
							if(!rd.get(0).getPix().equals("")){
								String re1 = rd.get(0).getPix();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setPix(dform.format(res));
								db.delPix();
								db.pixIn(us);	
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
							us.setPix(som4.getText().toString());
							DB d1 = new DB(c);
							d1.pixIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Verde Card")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+20,+5,0);
						som4.setEms(6);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.verde);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.verdeFind();
							if(!rd.get(0).getVerde().equals("")){
								String re1 = rd.get(0).getVerde();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVerde(dform.format(res));
								db.delVerde();
								db.verdeIn(us);	
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
							us.setVerde(som4.getText().toString());
							DB d1 = new DB(c);
							d1.verdeIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Soro Cred")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+20,+5,0);
						som4.setEms(6);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.soro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.soroFind();
							if(!rd.get(0).getSoro().equals("")){
								String re1 = rd.get(0).getSoro();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setSoro(dform.format(res));
								db.delSoro();
								db.soroIn(us);	
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
							us.setSoro(som4.getText().toString());
							DB d1 = new DB(c);
							d1.soroIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Personal Card")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.person);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.personFind();
							if(!rd.get(0).getPerson().equals("")){
								String re1 = rd.get(0).getPerson();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setPerson(dform.format(res));
								db.delPerson();
								db.personIn(us);	
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
							us.setPerson(som4.getText().toString());
							DB d1 = new DB(c);
							d1.personIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Ouro Card")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(70,60);
						pr.setMargins(+15,+25,+5,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.ouro_card);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ouroFind();
							if(!rd.get(0).getOuro().equals("")){
								String re1 = rd.get(0).getOuro();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setOuro(dform.format(res));
								db.delOuro();
								db.ouroIn(us);	
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
							us.setOuro(som4.getText().toString());
							DB d1 = new DB(c);
							d1.ouroIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banrisul")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,+5,0);
						som4.setEms(6);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.banric);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriFind();
							if(!rd.get(0).getbanric().equals("")){
								String re1 = rd.get(0).getbanric();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanric(dform.format(res));
								db.delBanric();
								db.banriIn(us);	
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
							us.setBanric(som4.getText().toString());
							DB d1 = new DB(c);
							d1.banriIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banri Compras")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+25,+5,0);
						som4.setEms(6);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.banrico);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriCFind();
							if(!rd.get(0).getBanriC().equals("")){
								String re1 = rd.get(0).getBanriC();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanriC(dform.format(res));
								db.delBanriC();
								db.banriCIn(us);	
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
							us.setBanriC(som4.getText().toString());
							DB d1 = new DB(c);
							d1.banriCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banes Card")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som4.setEms(6);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.banes);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banesFind();
							if(!rd.get(0).getBanes().equals("")){
								String re1 = rd.get(0).getBanes();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanes(dform.format(res));
								db.delBanes();
								db.banesIn(us);	
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
							us.setBanes(som4.getText().toString());
							DB d1 = new DB(c);
							d1.banesIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("American Express")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,0,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.americ);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ameFind();
							if(!rd.get(0).getAmeric().equals("")){
								String re1 = rd.get(0).getAmeric();
								String re2 = som4.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setAmeric(dform.format(res));
								db.delAmeric();
								db.americIn(us);	
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
							us.setAmeric(som4.getText().toString());
							DB d1 = new DB(c);
							d1.americIn(us);
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
					} else {}
				}

				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
				}
			});
		spn5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					opts5 = p3;
					if(opts[p3].toString().startsWith("Dinheiro")){
						lay5.setVisibility(View.VISIBLE);
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(90,85);
						pr.setMargins(+15,+15,+10,0);
						som5.setEms(6);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.money);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.moFind();
							if(!rd.get(0).getMoney().equals("")){
								String re1 = rd.get(0).getMoney();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMoney(dform.format(res));
								db.delMoney();
								db.moneyIn(us);	
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
							us.setMoney(som5.getText().toString());
							DB d1 = new DB(c);
							d1.moneyIn(us);
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
					} else {lay5.setVisibility(View.GONE);}
					if(opts[p3].toString().startsWith("Selecione")){
						im5.setVisibility(View.GONE);
						som5.setEms(7);
					}
					if(opts[p3].toString().startsWith("Elo Débito")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloDFind();
							if(!rd.get(0).getEloD().equals("")){
								String re1 = rd.get(0).getEloD();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setEloD(dform.format(res));
								db.delEloD();
								db.eloDIn(us);	
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
							us.setEloD(som5.getText().toString());
							DB d1 = new DB(c);
							d1.eloDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Elo Crédito")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloCFind();
							if(!rd.get(0).getEloC().equals("")){
								String re1 = rd.get(0).getEloC();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setEloC(dform.format(res));
								db.delEloC();
								db.eloCIn(us);	
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
							us.setEloC(som5.getText().toString());
							DB d1 = new DB(c);
							d1.eloCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Visa Débito")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaDFind();
							if(!rd.get(0).getVisaD().equals("")){
								String re1 = rd.get(0).getVisaD();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVisaD(dform.format(res));
								db.delVisaD();
								db.visaDIn(us);	
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
							us.setVisaD(som5.getText().toString());
							DB d1 = new DB(c);
							d1.visaDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Visa Crédito")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaCFind();
							if(!rd.get(0).getVisaC().equals("")){
								String re1 = rd.get(0).getVisaC();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVisaC(dform.format(res));
								db.delVisaC();
								db.visaCIn(us);	
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
							us.setVisaC(som5.getText().toString());
							DB d1 = new DB(c);
							d1.visaCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Master Débito")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterDFind();
							if(!rd.get(0).getMasterD().equals("")){
								String re1 = rd.get(0).getMasterD();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMasterD(dform.format(res));
								db.delMasterD();
								db.masterDIn(us);	
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
							us.setMasterD(som5.getText().toString());
							DB d1 = new DB(c);
							d1.masterDIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Master Crédito")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterCFind();
							if(!rd.get(0).getMasterC().equals("")){
								String re1 = rd.get(0).getMasterC();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMasterC(dform.format(res));
								db.delMasterC();
								db.masterCIn(us);	
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
							us.setMasterC(som5.getText().toString());
							DB d1 = new DB(c);
							d1.masterCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Hiper")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(55,50);
						pr.setMargins(+15,+30,+5,0);
						som5.setEms(8);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.hiper);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperFind();
							if(!rd.get(0).getHiper().equals("")){
								String re1 = rd.get(0).getHiper();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setHiper(dform.format(res));
								db.delHiper();
								db.hiperIn(us);	
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
							us.setHiper(som5.getText().toString());
							DB d1 = new DB(c);
							d1.hiperIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Hiper Card")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(85,80);
						pr.setMargins(+15,+15,+5,0);
						som5.setEms(6);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.hiperc);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperCFind();
							if(!rd.get(0).getHiperC().equals("")){
								String re1 = rd.get(0).getHiperC();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setHiperC(dform.format(res));
								db.delHiperC();
								db.hiperCIn(us);	
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
							us.setHiperC(som5.getText().toString());
							DB d1 = new DB(c);
							d1.hiperCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Cabal")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+35,+5,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.cabal);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.cabalFind();
							if(!rd.get(0).getCabal().equals("")){
								String re1 = rd.get(0).getCabal();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setCabal(dform.format(res));
								db.delCabal();
								db.cabalIn(us);	
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
							us.setCabal(som5.getText().toString());
							DB d1 = new DB(c);
							d1.cabalIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Pix")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+15,0,0);
						som5.setEms(8);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.pix);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.pixFind();
							if(!rd.get(0).getPix().equals("")){
								String re1 = rd.get(0).getPix();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setPix(dform.format(res));
								db.delPix();
								db.pixIn(us);	
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
							us.setPix(som5.getText().toString());
							DB d1 = new DB(c);
							d1.pixIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Verde Card")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+20,+5,0);
						som5.setEms(6);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.verde);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.verdeFind();
							if(!rd.get(0).getVerde().equals("")){
								String re1 = rd.get(0).getVerde();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVerde(dform.format(res));
								db.delVerde();
								db.verdeIn(us);	
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
							us.setVerde(som5.getText().toString());
							DB d1 = new DB(c);
							d1.verdeIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Soro Cred")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+20,+5,0);
						som5.setEms(6);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.soro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.soroFind();
							if(!rd.get(0).getSoro().equals("")){
								String re1 = rd.get(0).getSoro();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setSoro(dform.format(res));
								db.delSoro();
								db.soroIn(us);	
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
							us.setSoro(som5.getText().toString());
							DB d1 = new DB(c);
							d1.soroIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Personal Card")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.person);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.personFind();
							if(!rd.get(0).getPerson().equals("")){
								String re1 = rd.get(0).getPerson();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setPerson(dform.format(res));
								db.delPerson();
								db.personIn(us);	
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
							us.setPerson(som5.getText().toString());
							DB d1 = new DB(c);
							d1.personIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Ouro Card")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(70,60);
						pr.setMargins(+15,+25,+5,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.ouro_card);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ouroFind();
							if(!rd.get(0).getOuro().equals("")){
								String re1 = rd.get(0).getOuro();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setOuro(dform.format(res));
								db.delOuro();
								db.ouroIn(us);	
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
							us.setOuro(som5.getText().toString());
							DB d1 = new DB(c);
							d1.ouroIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banrisul")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,+5,0);
						som5.setEms(6);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.banric);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriFind();
							if(!rd.get(0).getbanric().equals("")){
								String re1 = rd.get(0).getbanric();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanric(dform.format(res));
								db.delBanric();
								db.banriIn(us);	
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
							us.setBanric(som5.getText().toString());
							DB d1 = new DB(c);
							d1.banriIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banri Compras")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+25,+5,0);
						som5.setEms(6);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.banrico);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriCFind();
							if(!rd.get(0).getBanriC().equals("")){
								String re1 = rd.get(0).getBanriC();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanriC(dform.format(res));
								db.delBanriC();
								db.banriCIn(us);	
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
							us.setBanriC(som5.getText().toString());
							DB d1 = new DB(c);
							d1.banriCIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("Banes Card")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som5.setEms(6);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.banes);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banesFind();
							if(!rd.get(0).getBanes().equals("")){
								String re1 = rd.get(0).getBanes();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanes(dform.format(res));
								db.delBanes();
								db.banesIn(us);	
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
							us.setBanes(som5.getText().toString());
							DB d1 = new DB(c);
							d1.banesIn(us);
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
					} else {}
					if(opts[p3].toString().startsWith("American Express")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,0,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.americ);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ameFind();
							if(!rd.get(0).getAmeric().equals("")){
								String re1 = rd.get(0).getAmeric();
								String re2 = som5.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setAmeric(dform.format(res));
								db.delAmeric();
								db.americIn(us);	
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
							us.setAmeric(som5.getText().toString());
							DB d1 = new DB(c);
							d1.americIn(us);
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
					} else {}
				}

				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
				}
			});
	
		AlertDialog.Builder b = new AlertDialog.Builder(c, R.style.dialog);
		b.setTitle("Fechar Conta");
		b.setView(r);
		b.setCancelable(false);
		dis = b.create();
		dis = b.show();
	}
}
