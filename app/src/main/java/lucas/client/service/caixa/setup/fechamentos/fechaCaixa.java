package lucas.client.service.caixa.setup.fechamentos;
import android.app.*;
import android.content.*;
import android.icu.text.*;
import android.os.*;
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

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class fechaCaixa extends AppCompatActivity
{
	Button canc, fecha;
	List<util> opf, fpf;
	Context c = this;
	String sanResult,SupResult, supRes,  moneyRes, eloDRes, eloCRes, visaDRes, visaCRes, masterDRes, masterCRes, hiperRes, hiperCRes, cabalRes, pixRes,
	verdeRes, soroRes, personRes, ouroRes, banriRes, banricRes, banesRes, americRes;
	ProgressDialog progress;
	String supR1, supR2, supR3, supR4, supR5, supR6, sanR1, sanR2, sanR3, sanR4, sanR5, sanR6;
	LinearLayout trancard, moneyid,sanid, elodid, elocid, visadid, visacid, masterdid, mastercid, hiperid, hipercid, cabalid, pixid, verdeid,
	             soroid, personid, ouroid, banricid, banricoid, banesid, americid;
	String moneyResult,sangRes, eloDResult, eloCResult, visaDResult, visaCResult, masterDResult, masterCResult, hiperResult, HiperCResult,
	       cabalResult, pixResult, verdeResult, personResult, soroResult, ouroResult, banriResult, banricoResult, banesResult, americResult;
  TextInputEditText sangria_,operador_, data, fundo_, money_, eloD_, eloC_, visaD_, visaC_, masterD_, masterC_,
	hiper_, hiperC_, cabal_, pix_, verde_, soro_, person_, ouro_, banric_, banrico_, banes_, americ_;
    List<util> operador, sangria, supS, sup,  fundo, money, eloD, eloC, visaD, visaC, masterD, masterC,
    hiper, hiperC, cabal, pix, verde, soro, person, ouro, banric, banrico, banes, americ;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		
		LayoutInflater li = getLayoutInflater();
		View r = li.inflate(R.layout.fecha_caixa, null);
		data = r.findViewById(R.id.data);
		moneyid = r.findViewById(R.id.money_ID);
		trancard = r.findViewById(R.id.trancard);
		trancard.setVisibility(View.GONE);
		elodid = r.findViewById(R.id.eloD_ID);
		elocid = r.findViewById(R.id.eloC_ID);
		visadid = r.findViewById(R.id.visaD_ID);
		visacid = r.findViewById(R.id.visaC_ID);
		masterdid = r.findViewById(R.id.masterD_ID);
		mastercid = r.findViewById(R.id.masterC_ID);
		hiperid = r.findViewById(R.id.hiper_ID);
		hipercid = r.findViewById(R.id.hiperC_ID);
		cabalid = r.findViewById(R.id.cabal_ID);
		pixid = r.findViewById(R.id.pix_ID);
		verdeid = r.findViewById(R.id.verde_ID);
		soroid = r.findViewById(R.id.soro_ID);
		personid = r.findViewById(R.id.person_ID);
		ouroid = r.findViewById(R.id.ouro_ID);
		banricid = r.findViewById(R.id.banric_ID);
		banricoid = r.findViewById(R.id.banrico_ID);
		banesid = r.findViewById(R.id.banes_ID);
		americid = r.findViewById(R.id.americ_ID);
		fundo_ = r.findViewById(R.id.fundo);
		sangria_ = r.findViewById(R.id.sangria);
		operador_ = r.findViewById(R.id.operador);
		money_ = r.findViewById(R.id.dinheiro);
		eloD_ = r.findViewById(R.id.eloD);
		eloC_ = r.findViewById(R.id.eloC);
		visaD_ = r.findViewById(R.id.visaD);
		visaC_ = r.findViewById(R.id.visaC);
		masterD_ = r.findViewById(R.id.masterD);
		masterC_ = r.findViewById(R.id.masterC);
		hiper_ = r.findViewById(R.id.hiper);
		hiperC_ = r.findViewById(R.id.hiperc);
		cabal_ = r.findViewById(R.id.cabal);
		pix_ = r.findViewById(R.id.pix);
		verde_ = r.findViewById(R.id.verde);
		soro_ = r.findViewById(R.id.soro);
		person_ = r.findViewById(R.id.person);
		ouro_ = r.findViewById(R.id.ouro);
		banric_ = r.findViewById(R.id.banrisul);
		banrico_ = r.findViewById(R.id.banrico);
		banes_ = r.findViewById(R.id.banes);
		americ_ = r.findViewById(R.id.americ);
		canc = r.findViewById(R.id.canc);
		fecha = r.findViewById(R.id.fecha);
		DB db1 = new DB(c);
	    opf = db1.opFind();
		
		operador_.setText(opf.get(0).getOp());
		
		String dateTime2;
		Calendar calendar2 = Calendar.getInstance(); 
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd.MM.yyyy"); 
		dateTime2 = simpleDateFormat2.format(calendar2.getTime()).toString(); 
		data.setText(dateTime2.toString());
		try{
			DB db = new DB(c);
			supS = db.suFind();
			if(!supS.get(0).getSupVal().equals("")){
				DB db2 = new DB(c);
				fpf = db2.funFind();
				Double v1 = new Double(fpf.get(0).getFundo());
				Double v2 = new Double(supS.get(0).getSupVal());
				double res = v1 + v2;
				fundo_.setText(String.valueOf(res));
				supRes = supS.get(0).getSupVal();
				
			} 
		}catch(Exception e){
			DB db2 = new DB(c);
			fpf = db2.funFind();
			fundo_.setText(fpf.get(0).getFundo());
			supRes = "0";
			
		}
		try{
			DB db = new DB(c);
			sangria = db.saFind();
			if(!sangria.get(0).getSangria().equals("")){
				sangRes = sangria.get(0).getSangria();
				sangria_.setVisibility(View.VISIBLE);
			} 
		}catch(Exception e){
			sangRes = "0";
			sangria_.setVisibility(View.GONE);
		}
		try{
			DB db = new DB(c);
			americ = db.ameFind();
			if(!americ.get(0).getAmeric().equals("")){
				americid.setVisibility(View.VISIBLE);
				trancard.setVisibility(View.VISIBLE);
			    americResult = americ.get(0).getAmeric();
			} 
		}catch(Exception e){
			americid.setVisibility(View.GONE);
			americResult = "";
		}
		try{
			DB db = new DB(c);
			banes = db.banesFind();
			if(!banes.get(0).getBanes().equals("")){
				trancard.setVisibility(View.VISIBLE);
				banesid.setVisibility(View.VISIBLE);
			    banesResult = banes.get(0).getBanes();
			} 
		}catch(Exception e){
			banesid.setVisibility(View.GONE);
			banesResult = "";
		}
		try{
			DB db = new DB(c);
			banrico = db.banriCFind();
			if(!banrico.get(0).getBanriC().equals("")){
				trancard.setVisibility(View.VISIBLE);
				banricoid.setVisibility(View.VISIBLE);
			    banricoResult = banrico.get(0).getBanriC();
			} 
		}catch(Exception e){
			banricoid.setVisibility(View.GONE);
			banricoResult = "";
		}
		try{
			DB db = new DB(c);
			banric = db.banriFind();
			if(!banric.get(0).getbanric().equals("")){
				trancard.setVisibility(View.VISIBLE);
				banricid.setVisibility(View.VISIBLE);
			    banriResult = banric.get(0).getbanric();
			} 
		}catch(Exception e){
			banricid.setVisibility(View.GONE);
			banriResult = "";
		}
		try{
			DB db = new DB(c);
			ouro = db.ouroFind();
			if(!ouro.get(0).getOuro().equals("")){
				trancard.setVisibility(View.VISIBLE);
				ouroid.setVisibility(View.VISIBLE);
			    ouroResult = ouro.get(0).getOuro();
			} 
		}catch(Exception e){
			ouroid.setVisibility(View.GONE);
			ouroResult = "";
		}
		try{
			DB db = new DB(c);
			person = db.personFind();
			if(!person.get(0).getPerson().equals("")){
				trancard.setVisibility(View.VISIBLE);
				personid.setVisibility(View.VISIBLE);
			    personResult = person.get(0).getPerson();
			} 
		}catch(Exception e){
			personid.setVisibility(View.GONE);
			personResult = "";
		}
		try{
			DB db = new DB(c);
			soro = db.soroFind();
			if(!soro.get(0).getSoro().equals("")){
				trancard.setVisibility(View.VISIBLE);
				soroid.setVisibility(View.VISIBLE);
			    soroResult = soro.get(0).getSoro();
			} 
		}catch(Exception e){
			soroid.setVisibility(View.GONE);
			soroResult = "";
		}
		try{
			DB db = new DB(c);
			verde = db.verdeFind();
			if(!verde.get(0).getVerde().equals("")){
				trancard.setVisibility(View.VISIBLE);
				verdeid.setVisibility(View.VISIBLE);
			    verdeResult = verde.get(0).getVerde();
			} 
		}catch(Exception e){
			verdeid.setVisibility(View.GONE);
			verdeResult = "";
		}
		try{
			DB db = new DB(c);
			pix = db.pixFind();
			if(!pix.get(0).getPix().equals("")){
				trancard.setVisibility(View.VISIBLE);
				pixid.setVisibility(View.VISIBLE);
			    pixResult = pix.get(0).getPix();
			} 
		}catch(Exception e){
			pixid.setVisibility(View.GONE);
			pixResult = "";
		}
		try{
			DB db = new DB(c);
			cabal = db.cabalFind();
			if(!cabal.get(0).getCabal().equals("")){
				trancard.setVisibility(View.VISIBLE);
				cabalid.setVisibility(View.VISIBLE);
			    cabalResult = cabal.get(0).getCabal();
			} 
		}catch(Exception e){
			cabalid.setVisibility(View.GONE);
			cabalResult = "";
		}
		try{
			DB db = new DB(c);
			hiperC = db.hiperCFind();
			if(!hiperC.get(0).getHiperC().equals("")){
				trancard.setVisibility(View.VISIBLE);
				hipercid.setVisibility(View.VISIBLE);
			    HiperCResult = hiperC.get(0).getHiperC();
			} 
		}catch(Exception e){
			hipercid.setVisibility(View.GONE);
			HiperCResult = "";
		}
		try{
			DB db = new DB(c);
			hiper = db.hiperFind();
			if(!hiper.get(0).getHiper().equals("")){
				trancard.setVisibility(View.VISIBLE);
				hiperid.setVisibility(View.VISIBLE);
			    hiperResult = hiper.get(0).getHiper();
			} 
		}catch(Exception e){
			hiperid.setVisibility(View.GONE);
			hiperResult = "";
		}
		try{
			DB db = new DB(c);
			masterC = db.masterCFind();
			if(!masterC.get(0).getMasterC().equals("")){
				trancard.setVisibility(View.VISIBLE);
				mastercid.setVisibility(View.VISIBLE);
			    masterCResult = masterC.get(0).getMasterC();
			} 
		}catch(Exception e){
			mastercid.setVisibility(View.GONE);
			masterCResult = "";
		}
		try{
			DB db = new DB(c);
			masterD = db.masterDFind();
			if(!masterD.get(0).getMasterD().equals("")){
				trancard.setVisibility(View.VISIBLE);
				masterdid.setVisibility(View.VISIBLE);
			    masterDResult = masterD.get(0).getMasterD();
			} 
		}catch(Exception e){
			masterdid.setVisibility(View.GONE);
			masterDResult = "";
		}
		try{
			DB db = new DB(c);
			visaC = db.visaCFind();
			if(!visaC.get(0).getVisaC().equals("")){
				trancard.setVisibility(View.VISIBLE);
				visacid.setVisibility(View.VISIBLE);
			    visaCResult = visaC.get(0).getVisaC();
			} 
		}catch(Exception e){
			visacid.setVisibility(View.GONE);
			visaCResult = "";
		}
		try{
			DB db = new DB(c);
			visaD = db.visaDFind();
			if(!visaD.get(0).getVisaD().equals("")){
				trancard.setVisibility(View.VISIBLE);
				visadid.setVisibility(View.VISIBLE);
			    visaDResult = visaD.get(0).getVisaD();
			} 
		}catch(Exception e){
			visadid.setVisibility(View.GONE);
			visaDResult = "";
		}
		try{
			DB db = new DB(c);
			eloC = db.eloCFind();
			if(!eloC.get(0).getEloC().equals("")){
				trancard.setVisibility(View.VISIBLE);
				elocid.setVisibility(View.VISIBLE);
				eloCResult = eloC.get(0).getEloC();
			} 
		}catch(Exception e){
			elocid.setVisibility(View.GONE);
			eloCResult = "";
		}
		try{
			DB db = new DB(c);
			eloD = db.eloDFind();
			if(!eloD.get(0).getEloD().equals("")){
				trancard.setVisibility(View.VISIBLE);
				elodid.setVisibility(View.VISIBLE);
				eloDResult = eloD.get(0).getEloD();
			} 
		}catch(Exception e){
			elodid.setVisibility(View.GONE);
			eloDResult = "";
			
		}
		try{
			DB db = new DB(c);
			money = db.moFind();
			if(!money.get(0).getMoney().equals("")){
				moneyid.setVisibility(View.VISIBLE);
				moneyResult = money.get(0).getMoney();
			} 
		}catch(Exception e){
			moneyid.setVisibility(View.GONE);
			moneyResult = "";
		}
		fecha.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					progress = new ProgressDialog(c);
					progress.setMax(100);
					progress.setMessage("Iniciando Fechamento...");
					progress.setTitle("Fechamento de Caixa");
					progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					progress.show();
					new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									while (progress.getProgress() <= progress
										   .getMax()) {
										Thread.sleep(900);
										handle.sendMessage(handle.obtainMessage());
										if (progress.getProgress() == 20) {
											progress.setMessage("Gerando NFe da Redução Z...");
											try{
												DB db = new DB(c);
												List<util> ls;
												ls = db.suFind();
												if(!ls.get(0).getSupVal().equals("")){
													DB db2 = new DB(c);
													util sanRes1 = db2.supFind(1);
													DB db3 = new DB(c);
													util sanRes2 = db3.supFind(2);
													DB db4 = new DB(c);
													util sanRes3 = db4.supFind(3);
													DB db5 = new DB(c);
													util sanRes4 = db5.supFind(4);
													DB db6 = new DB(c);
													util sanRes5 = db6.supFind(5);
													DB db7 = new DB(c);
													util sanRes6 = db7.supFind(6);
													try{
														if(!db2.supFind(1).toString().equals("")){
															supR1 = "<tr>"+
																"<td id='clM'>" + sanRes1.getSupDesc() + "</td> <td id='clVal'>" + sanRes1.getSupVal() + "</td>"+
																"</tr>";
														}else {}
													}catch(Exception e){
														supR1 = "";
													}
													try{
														if(!sanRes2.getSupVal().equals("")){
															supR2 = "<tr>"+
																"<td id='clM'>" + sanRes2.getSupDesc() + "</td> <td id='clVal'>" + sanRes2.getSupVal() + "</td>"+
																"</tr>";
														}
													}catch(Exception e){
														supR2 = "";
													}
													try{
														if(!sanRes3.getSupVal().equals("")){
															supR3 = "<tr>"+
																"<td id='clM'>" + sanRes3.getSupDesc() + "</td> <td id='clVal'>" + sanRes3.getSupVal() + "</td>"+
																"</tr>";
														}
													}catch(Exception e){
														supR3 = "";
													}
													try{
														if(!sanRes4.getSupVal().equals("")){
															supR4 = "<tr>"+
																"<td id='clM'>" + sanRes4.getSupDesc() + "</td> <td id='clVal'>" + sanRes4.getSupVal() + "</td>"+
																"</tr>";
														}
													}catch(Exception e){
														supR4 = "";
													}
													try{
														if(!sanRes5.getSupVal().equals("")){
															supR5 = "<tr>"+
																"<td id='clM'>" + sanRes5.getSupDesc() + "</td> <td id='clVal'>" + sanRes5.getSupVal() + "</td>"+
																"</tr>";
														}
													}catch(Exception e){
														supR5 = "";
													}
													try{
														if(!sanRes6.getSupVal().equals("")){
															supR6 = "<tr>"+
																"<td id='clM'>" + sanRes6.getSupDesc() + "</td> <td id='clVal'>" + sanRes6.getSupVal() + "</td>"+
																"</tr>";
														}
													}catch(Exception e){
														supR6 = "";
													}
													
													SupResult = "<div>"+
														"<center>"+
														"<div class='san'><b>Suprimento de Caixa:</b></div>"+
														"<table>"+
														"<tr>"+
														"<th id='mot'>Descrição</th><th id='val'>Valor</th>"+
														supR1.toString() +
														supR2.toString() +
														supR3.toString() +
														supR4.toString() + 
														supR5.toString() +
														supR6.toString() +
														"<tr>"+
														"<td id='clVal'>Total:</td>" +
														"<td id='clu'>R$" + supRes.toString() + "</td>" +
														"</tr>"+
														"</tr>"+
														"</table>"+
														"</center>"+
														"</div>";
												} 
											}catch(Exception e){
												SupResult = "";
											}
											
											try{
												DB db = new DB(c);
												List<util> ls;
												ls = db.saFind();
									        if(!ls.get(0).getSangria().equals("")){
												DB db2 = new DB(c);
												util sanRes1 = db2.sanFind(1);
												DB db3 = new DB(c);
												util sanRes2 = db3.sanFind(2);
												DB db4 = new DB(c);
												util sanRes3 = db4.sanFind(3);
												DB db5 = new DB(c);
												util sanRes4 = db5.sanFind(4);
												DB db6 = new DB(c);
												util sanRes5 = db6.sanFind(5);
												DB db7 = new DB(c);
												util sanRes6 = db7.sanFind(6);
												try{
													if(!db2.sanFind(1).toString().equals("")){
														sanR1 = "<tr>"+
															"<td id='clM'>" + sanRes1.getSanMot() + "</td> <td id='clVal'>" + sanRes1.getSanVal() + "</td>"+
															"</tr>";
													}else {}
												}catch(Exception e){
													sanR1 = "";
												}
												try{
													if(!sanRes2.getSanVal().equals("")){
														sanR2 = "<tr>"+
															"<td id='clM'>" + sanRes2.getSanMot() + "</td> <td id='clVal'>" + sanRes2.getSanVal() + "</td>"+
															"</tr>";
													}
												}catch(Exception e){
													sanR2 = "";
												}
												try{
													if(!sanRes3.getSanVal().equals("")){
														sanR3 = "<tr>"+
															"<td id='clM'>" + sanRes3.getSanMot() + "</td> <td id='clVal'>" + sanRes3.getSanVal() + "</td>"+
															"</tr>";
													}
												}catch(Exception e){
													sanR3 = "";
												}
												try{
													if(!sanRes4.getSanVal().equals("")){
														sanR4 = "<tr>"+
															"<td id='clM'>" + sanRes4.getSanMot() + "</td> <td id='clVal'>" + sanRes4.getSanVal() + "</td>"+
															"</tr>";
													}
												}catch(Exception e){
													sanR4 = "";
												}
												try{
													if(!sanRes5.getSanVal().equals("")){
														sanR5 = "<tr>"+
															"<td id='clM'>" + sanRes5.getSanMot() + "</td> <td id='clVal'>" + sanRes5.getSanVal() + "</td>"+
															"</tr>";
													}
												}catch(Exception e){
													sanR5 = "";
												}
												try{
													if(!sanRes6.getSanVal().equals("")){
														sanR6 = "<tr>"+
															"<td id='clM'>" + sanRes6.getSanMot() + "</td> <td id='clVal'>" + sanRes6.getSanVal() + "</td>"+
															"</tr>";
													}
												}catch(Exception e){
													sanR6 = "";
												}
												Double somaSan = new Double(sangRes);
												Double compRes = new Double(sangria_.getText().toString());
												double res = somaSan - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
												sanResult = "<div>"+
													"<center>"+
													"<div class='san'><b>Sangria de Caixa:</b></div>"+
													"<table>"+
													"<tr>"+
													"<th id='mot'>Motivo</th><th id='val'>Valor</th>"+
													sanR1.toString() +
													sanR2.toString() +
													sanR3.toString() +
													sanR4.toString() + 
													sanR5.toString() +
													sanR6.toString() +
													"<tr>"+
													"<td id='clS'>Soma:</td> <td id='clL'>Lançado:</td>"+
													"</tr>"+
													"<tr>"+
													"<td id='clso'>R$" + sangRes.toString() + "</td> <td id='clu'>R$" + sangria_.getText().toString() + "</td>"+
													"</tr>"+
													"<tr>"+
													"<td></td><td id='clVal'>Diferença:</td>"+
													"</tr>"+
													"<tr>"+
													"<td></td><td id='clVal'>R$" + dform4.format(res) + "</td>"+
													"</tr>"+
													"</tr>"+
													"</table>"+
													"</center>"+
													"</div>";
											} 
											}catch(Exception e){
												sanResult = "";
											}
											try{
											if(!moneyResult.toString().equals("")){
												Double somaMoney = new Double(moneyResult);
												Double compRes = new Double(money_.getText().toString());
												Double compSan = new Double(sangRes);
												double borderoRes = somaMoney - compSan;
												double res = compRes - borderoRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
												
											    moneyRes = "<div class='bo'><h4 id='bor'>BORDERO:</h4><h4 id='cx'>CAIXA:</h4>" +
													       "<h5 id='ln'>------------</h5> <h5 id='ln2'>------------</h5>" + "</div>" + 
												"<div class='bo'><h4 id='bor_'>R$" + dform4.format(borderoRes) + "</h4> <h4 id='cx'>R$" + money_.getText().toString() + "</h4></div>" +
												"<div class='bo'><h4 id='cx2'>Dif: R$" + dform4.format(res) + "</h4></div><br/>";
											} else {
											}
											}catch(Exception e){
												moneyRes = "";
											}
											try{
												List<util> lt;
												DB db = new DB(c);
												lt = db.eloDFind();
											if(!lt.get(0).getEloD().equals("")){
												Double somaEloD = new Double(eloDResult);
												Double compRes = new Double(eloD_.getText().toString());
												double res = somaEloD - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    eloDRes = "<div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Elo Débito: R$" + eloDResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + eloD_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {}
											}catch(Exception e){
												eloDRes = "";
											}
											if(!eloCResult.toString().equals("")){
												Double somaEloC = new Double(eloCResult);
												Double compRes = new Double(eloC_.getText().toString());
												double res = somaEloC - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    eloCRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Elo Crédito: R$" + eloCResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + eloC_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												eloCRes = "";
											}
											if(!visaDResult.toString().equals("")){
												Double somaVisaD = new Double(visaDResult);
												Double compRes = new Double(visaD_.getText().toString());
												double res = somaVisaD - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    visaDRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Visa Débito: R$" + visaDResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + visaD_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												visaDRes = "";
											}
											if(!visaCResult.toString().equals("")){
												Double somaVisaC = new Double(visaCResult);
												Double compRes = new Double(visaC_.getText().toString());
												double res = somaVisaC - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    visaCRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Visa Crédito: R$" + visaCResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + visaC_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												visaCRes = "";
											}
											if(!masterDResult.toString().equals("")){
												Double somaMasterD = new Double(masterDResult);
												Double compRes = new Double(masterD_.getText().toString());
												double res = somaMasterD - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    masterDRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Master Débito: R$" + masterDResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + masterD_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												masterDRes = "";
											}
											if(!masterCResult.toString().equals("")){
												Double somaMasterC = new Double(masterCResult);
												Double compRes = new Double(masterC_.getText().toString());
												double res = somaMasterC - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    masterCRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Master Crédito: R$" + masterCResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + masterC_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												masterCRes = "";
											}
											if(!hiperResult.toString().equals("")){
												Double somaHiper = new Double(hiperResult);
												Double compRes = new Double(hiper_.getText().toString());
												double res = somaHiper - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    hiperRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Hiper: R$" + hiperResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + hiper_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												hiperRes = "";
											}
											if(!HiperCResult.toString().equals("")){
												Double somaHiperC = new Double(HiperCResult);
												Double compRes = new Double(hiperC_.getText().toString());
												double res = somaHiperC - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    hiperCRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>HiperCard: R$" + HiperCResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + hiperC_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												hiperCRes = "";
											}
											if(!cabalResult.toString().equals("")){
												Double somaCabal = new Double(cabalResult);
												Double compRes = new Double(cabal_.getText().toString());
												double res = somaCabal - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    cabalRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Cabal Débito: R$" + cabalResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + cabal_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												cabalRes = "";
											}
											if(!pixResult.toString().equals("")){
												Double somaPix = new Double(pixResult);
												Double compRes = new Double(pix_.getText().toString());
												double res = somaPix - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    pixRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Pix: R$" + pixResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + pix_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												pixRes = "";
											}
											if(!verdeResult.toString().equals("")){
												Double somaVerde = new Double(verdeResult);
												Double compRes = new Double(verde_.getText().toString());
												double res = somaVerde - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    verdeRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>VerdeCard: R$" + verdeResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + verde_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												verdeRes = "";
											}
											if(!soroResult.toString().equals("")){
												Double somaSoro = new Double(soroResult);
												Double compRes = new Double(soro_.getText().toString());
												double res = somaSoro - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    soroRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>SoroCred: R$" + soroResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + soro_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												soroRes = "";
											}
											if(!personResult.toString().equals("")){
												Double somaPerson = new Double(personResult);
												Double compRes = new Double(person_.getText().toString());
												double res = somaPerson - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    personRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Personal Card: R$" + personResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + person_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												personRes = "";
											}
											if(!ouroResult.toString().equals("")){
												Double somaOuro = new Double(ouroResult);
												Double compRes = new Double(ouro_.getText().toString());
												double res = somaOuro - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    ouroRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>OuroCard: R$" + ouroResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + ouro_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												ouroRes = "";
											}
											if(!banriResult.toString().equals("")){
												Double somaBanri = new Double(banriResult);
												Double compRes = new Double(banric_.getText().toString());
												double res = somaBanri - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    banriRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>BanriSul: R$" + banriResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + banric_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												banriRes = "";
											}
											if(!banricoResult.toString().equals("")){
												Double somaBanric = new Double(banricoResult);
												Double compRes = new Double(banrico_.getText().toString());
												double res = somaBanric - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    banricRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>BanriCompras: R$" + banricoResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + banrico_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												banricRes = "";
											}
											if(!banesResult.toString().equals("")){
												Double somaBanes = new Double(banesResult);
												Double compRes = new Double(banes_.getText().toString());
												double res = somaBanes - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    banesRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>BanesCard: R$" + banesResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + banes_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												banesRes = "";
											}
											if(!americResult.toString().equals("")){
												Double somaAmeric = new Double(americResult);
												Double compRes = new Double(americ_.getText().toString());
												double res = somaAmeric - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    americRes = "<br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>American Express: R$" + americResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + americ_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div>";
											} else {
												americRes = "";
											}
											try{
												String dateTime2;
												Calendar calendar2 = Calendar.getInstance(); 
												SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd.MM.yyyy"); 
												dateTime2 = simpleDateFormat2.format(calendar2.getTime()).toString();
												String dateTime;
												Calendar calendar = Calendar.getInstance(); 
												SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
												dateTime = simpleDateFormat.format(calendar.getTime()).toString(); 
											  File root = new File(Environment.getExternalStorageDirectory(), "pdvMain/data/lucas.client.service/.fechamentos/fechamento_" + dateTime2.toString() +".html");
											  FileWriter fw = new FileWriter(root);
												fw.write(
												    "<html>"+
													"<head>"+
													"<body>"+
													"<style>"+
													"body{"+
													"height:auto;"+
													"margin:5px;"+
												"}"+
												".nav2 {"+
													"margin-top:5px;"+
													"height:auto;"+
													"text-align:center;"+
													"padding:20px 20px 20px;"+
													"background:#eeff1566;"+
												"}"+
												".nav {"+
													"margin-top:10px;"+
													"margin:auto;"+
													"height:auto;"+
													"text-align:center;"+
													"padding:20px 20px 20px;"+
													"background:#eeff1566;"+
												"}"+
												"#bor{"+
													"text-align:left;"+
												"}"+
												"#bor_{"+
													"margin-top:-20px;"+
													"text-align:left;"+
												"}"+
												"#dat{"+
													"margin-left:20px;"+
												"}"+
												"#cx{"+
													"margin-top:-36px;"+
													"text-align:right;"+
												"}"+
												"#cx2{"+
													"margin-top:20px;"+
													"margin-right:5px;"+
													"text-align:right;"+
												"}"+
												"#ln {"+
													"text-align:left;"+
													"margin-top:-20px;"+
												"}"+
												"#ln2 {"+
													"text-align:right;"+
													"margin-top:-35px;"+
												"}"+
												".bo {"+
													"margin:10px;"+
												"}"+
													"#mot{"+
													"color:#fff;"+
													"padding:15px 50px 15px;"+
													"background:#7015ff;"+
												"}"+
												"#val{"+
													"color:#fff;"+
													"padding:15px 50px 15px;"+
													"background:#ff3400;"+
												"}"+
												"#clM{"+
													"background:#f4aaff;"+
													"padding:10px;"+
												"}"+
												"#clS{"+
													"background:#00cc46;"+
													"padding:10px;"+
												"}"+
												"#clL{"+
													"color:#fff;"+
													"background:#ff1f00;"+
													"padding:10px;"+
												"}"+
												"#clso{"+
													"background:#86ff6a68;"+
													"padding:10px;"+
												"}"+
												"#clu{"+
													"color:#fff;"+
													"background:#ff340089;"+
													"padding:10px;"+
												"}"+
												"#clVal{"+
													"background:#90ff2b;"+
													"padding:10px;"+
												"}"+
												".san{"+
													"padding:15px;"+
													"margin:10px;"+
													"color:#fff;"+
													"margin-bottom:0;"+
													"background:#e32bff;"+
												"}"+
												"</style>"+
												"</head>"+
												"<div class='nav'>Cupom Fiscal NFe</div>"+
												"<div class='nav2'><p id='bor'>Lucas Informática <br/><br/>Rua Colombo, 504 - Petrópolis <br/>CEP: 89208-890 - Joinville SC<br/><u>Data: " + dateTime.toString() + "</u></p><h4>+------------------------------------+</h4>REDUÇÃO Z:<h4>+------------------------------------+</h4>"+
												"<br/>" +
												"<br/>"+
												"<b style='float:left;margin-left:10px;'>Operador:</b> <b style='float:right;margin-right:10px;'>" + operador_.getText().toString() + "</b>"+
												"<br/>"+
												"<br/>"+
												"<b style='float:left;margin-left:10px;'>Fundo:</b> <b style='float:right;margin-right:10px;'>R$" + fundo_.getText().toString()+ "</b>"+
												"<br/>"+
												"<br/>"+
												"<br/>"+
												moneyRes.toString() +
												SupResult.toString() + 
												sanResult.toString() +
												eloDRes.toString() +
												eloCRes.toString() +
												visaDRes.toString() +
												visaCRes.toString() +
												masterDRes.toString() +
												masterCRes.toString() + 
												hiperRes.toString() +
												hiperCRes.toString() + 
												cabalRes.toString() +
												pixRes.toString() +
												verdeRes.toString() +
												soroRes.toString() +
												personRes.toString() + 
												ouroRes.toString() +
												banriRes.toString() +
												banricRes.toString() +
												banesRes.toString() +
												americRes.toString() +
												"</div></body></html>");
												fw.flush();
												fw.close();
											}catch(IOException e){
												
											}
										}
										if(progress.getProgress() == 30){
											progress.setMessage("Salvando NF-e da Redução Z...");
											
											util us = new util();
											us.setData(data.getText().toString());
											us.setOp(operador_.getText().toString());
											us.setFundo(fundo_.getText().toString());
											us.setMoney(money_.getText().toString());
											us.setEloD(eloD_.getText().toString());
											us.setEloC(eloC_.getText().toString());
											us.setVisaD(visaD_.getText().toString());
											us.setVisaC(visaC_.getText().toString());
											us.setMasterD(masterD_.getText().toString());
											us.setMasterC(masterC_.getText().toString());
											us.setHiper(hiper_.getText().toString());
											us.setHiperC(hiperC_.getText().toString());
											us.setCabal(cabal_.getText().toString());
											us.setPix(pix_.getText().toString());
											us.setVerde(verde_.getText().toString());
											us.setSoro(soro_.getText().toString());
											us.setPerson(person_.getText().toString());
											us.setOuro(ouro_.getText().toString());
											us.setBanric(banric_.getText().toString());
											us.setBanriC(banrico_.getText().toString());
											us.setBanes(banes_.getText().toString());
											us.setAmeric(americ_.getText().toString());
											DB post = new DB(c);
											post.insertFecha(us);
										}
										if (progress.getProgress() == 40) {
											DB db = new DB(c);
											progress.setMessage("Zerando Transações...");
											try{db.delSup();}catch(Exception e){}
											try{db.delSupSom();}catch(Exception e){}
											try{db.delMoney();}catch(Exception e){}
											try{db.delOp();}catch(Exception e){}
											try{db.delSaldo();}catch(Exception e){}
											try{db.delSangSaldo();}catch(Exception e){}
											try{db.delSang();}catch(Exception e){}
											try{db.delEloD();}catch(Exception e){}
											try{db.delEloC();}catch(Exception e){}
											try{db.delVisaD();}catch(Exception e){}
											try{db.delVisaC();}catch(Exception e){}
											try{db.delMasterD();}catch(Exception e){}
											try{db.delMasterC();}catch(Exception e){}
											try{db.delHiper();}catch(Exception e){}
											try{db.delHiperC();}catch(Exception e){}
											try{db.delCabal();}catch(Exception e){}
											try{db.delPix();}catch(Exception e){}
											try{db.delVerde();}catch(Exception e){}
											try{db.delSoro();}catch(Exception e){}
											try{db.delPerson();}catch(Exception e){}
											try{db.delOuro();}catch(Exception e){}
											try{db.delBanric();}catch(Exception e){}
											try{db.delBanriC();}catch(Exception e){}
											try{db.delBanes();}catch(Exception e){}
											try{db.delAmeric();}catch(Exception e){}
										}
										if (progress.getProgress() == 50) {
											progress.setMessage("Zerando Lançamentos...");
											DB db = new DB(c);
											try{db.delHis();}catch(Exception e){}
										}
										if (progress.getProgress() == 70) {
											progress.setMessage("Zerando Cupons...");
										}
										if (progress.getProgress() == 80) {
											progress.setMessage("Fazendo LogOff de Operador...");
										}
										if (progress.getProgress() == 90) {
											progress.setMessage("Salvando Banco de Dados...");
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
										if (progress.getProgress() == 100) {
											progress.setMessage("Fechamento Concluído!");
											progress.cancel();
											progress.dismiss();
											Intent itt = new Intent(c, NFeWebServiceView.class);
											startActivity(itt);
											finishAffinity();
											Thread.sleep(200000);
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
			});
		canc.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					Intent itt = new Intent(c, caixaMain.class);
					startActivity(itt);
					finish();
				}
			});
			AlertDialog.Builder br = new AlertDialog.Builder(c, R.style.dialog);
			br.setTitle("Fechamento de Caixa");
			br.setIcon(R.drawable.icon);
			br.setView(r);
			br.create();
			br.show();
	}
}
