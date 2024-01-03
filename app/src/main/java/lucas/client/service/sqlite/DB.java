package lucas.client.service.sqlite;
import android.content.*;
import android.database.*;
import android.database.sqlite.*;

import java.lang.reflect.Array;
import java.util.*;

import lucas.client.service.etc.*;

public class DB
{
	SQLiteDatabase db;
	public DB(Context c){
		Core cor = new Core(c);
		db = cor.getWritableDatabase();
	}
	public void insertFecha(util us){
		ContentValues cv = new ContentValues();
		cv.put("data", us.getData());
		cv.put("NfeHtml", us.getNfe());
		db.insert("Fechamento", null, cv);
	}
	public void sanInsert(util us){
		ContentValues cv = new ContentValues();
		cv.put("sangria_val", us.getSanVal());
		cv.put("sangria_mot", us.getSanMot());
		db.insert("Sangrias", null, cv);
	}
	public void supInsert(util us){
		ContentValues cv = new ContentValues();
		cv.put("suprimento_val", us.getSupVal());
		cv.put("suprimento_mot", us.getSupDesc());
		db.insert("Suprimentos", null, cv);
	}
	public void delSupSom(){
		db.execSQL("delete from supSom");
	}
	public void delSup(){
		db.execSQL("delete from suprimento");
	}
	public void delHis(){
		db.execSQL("delete from produtos");
	}
	public void delSaldo(){
		db.execSQL("delete from fundo");
	}
	public void delOp(){
		db.execSQL("delete from operador");
	}
	public void delSangSaldo(){
		db.execSQL("delete from saldo");
	}
	public void delSang(){
		db.execSQL("delete from sangria");
	}
	public void delEloD(){
		db.execSQL("delete from eloD");
	}
	public void delEloC(){
		db.execSQL("delete from eloC");
	}
	public void delVisaD(){
		db.execSQL("delete from visaD");
	}
	public void delVisaC(){
		db.execSQL("delete from visaC");
	}
	public void delMasterD(){
		db.execSQL("delete from masterD");
	}
	public void delMasterC(){
		db.execSQL("delete from masterC");
	}
	public void delHiper(){
		db.execSQL("delete from hiper");
	}
	public void delHiperC(){
		db.execSQL("delete from hiperC");
	}
	public void delCabal(){
		db.execSQL("delete from cabal");
	}
	public void delPix(){
		db.execSQL("delete from pix");
	}
	public void delVerde(){
		db.execSQL("delete from verde");
	}
	public void delSoro(){
		db.execSQL("delete from soro");
	}
	public void delPerson(){
		db.execSQL("delete from person");
	}
	public void delOuro(){
		db.execSQL("delete from ouro");
	}
	public void delBanric(){
		db.execSQL("delete from banrisul");
	}
	public void delBanriC(){
		db.execSQL("delete from banriC");
	}
	public void delBanes(){
		db.execSQL("delete from banes");
	}
	public void delMoney(){
		db.execSQL("delete from dinheiro");
	}
	public void delAmeric(){
		db.execSQL("delete from americ");
	}

	public void delVenda(long id){
		db.delete("Vendas", "id = ?", new String[]{String.valueOf(id)});
	}
	public util getSuperVisor(long id){
		util us2 = new util();
		Cursor cs = db.rawQuery("select * from supervisor WHERE id ="+id+"", null);
		if(cs.moveToFirst()){
			do {
				us2.setSupervisor_id(cs.getLong(cs.getColumnIndex("id")));
				us2.setSenhaSuperVisor(cs.getString(cs.getColumnIndex("superV")));
			} while(cs.moveToNext());
		}
		return us2;
	}
	public util getUserCM(long id){
		util us = new util();
		Cursor cs = db.rawQuery("select * from senhaCM WHERE userId="+id+"", null);
		if(cs.moveToFirst()){
			do{
				us.setUserId(cs.getLong(cs.getColumnIndex("userId")));
				us.setUser(cs.getString(cs.getColumnIndex("usuario")));
				us.setSenha(cs.getString(cs.getColumnIndex("senha")));
				
			}while(cs.moveToNext());
		}
		return us;
	}
	public util getUserMCR(long id){
		util us = new util();
		Cursor cs = db.rawQuery("select * from senhaMCR WHERE userId="+id+"", null);
		if(cs.moveToFirst()){
			do{
				us.setUserId(cs.getLong(cs.getColumnIndex("userId")));
				us.setUser(cs.getString(cs.getColumnIndex("usuario")));
				us.setSenha(cs.getString(cs.getColumnIndex("senha")));

			}while(cs.moveToNext());
		}
		return us;
	}
	public util getCategory(long id){
		util us = new util();
		Cursor cs = db.rawQuery("select paginas from Paginas WHERE id ="+id+"", null);
		if(cs.moveToFirst()){
			do{
				us.setCategory(cs.getString(cs.getColumnIndex("paginas")));
			}while(cs.moveToNext());
		}
		return us;
	}
	public util getVenda(long id){
		util us = new util();
		Cursor cs = db.rawQuery("select * from Vendas WHERE id ="+id+"", null);
		if(cs.moveToFirst()){
			do{
				us.setData(cs.getString(cs.getColumnIndex("data")));
				us.setProd1(cs.getString(cs.getColumnIndex("prod")));
				us.setValor1(cs.getString(cs.getColumnIndex("total")));
			}while(cs.moveToNext());
		}
		return us;
	}
	public List<util> findP10(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "prod", "quant", "valor", "image", "forn", "dataIn", "dataOut", "etotal", "tipo"};
		Cursor cs = db.query("paginaTen", cl, null, null, null, null, "prod ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setIdP(Integer.parseInt(cs.getString(0)));
				us.setProd1(cs.getString(1));
				us.setQuant1(cs.getString(2));
				us.setValor1(cs.getString(3));
				us.setImage(cs.getBlob(4));
				us.setEForn(cs.getString(5));
				us.setDataIn(cs.getString(6));
				us.setDataOut(cs.getString(7));
				us.setETotal(cs.getString(8));
				us.setETipo(cs.getString(9));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> findP9(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "prod", "quant", "valor", "image", "forn", "dataIn", "dataOut", "etotal", "tipo"};
		Cursor cs = db.query("paginaNine", cl, null, null, null, null, "prod ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setIdP(Integer.parseInt(cs.getString(0)));
				us.setProd1(cs.getString(1));
				us.setQuant1(cs.getString(2));
				us.setValor1(cs.getString(3));
				us.setImage(cs.getBlob(4));
				us.setEForn(cs.getString(5));
				us.setDataIn(cs.getString(6));
				us.setDataOut(cs.getString(7));
				us.setETotal(cs.getString(8));
				us.setETipo(cs.getString(9));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> findP8(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "prod", "quant", "valor", "image", "forn", "dataIn", "dataOut", "etotal", "tipo"};
		Cursor cs = db.query("paginaEight", cl, null, null, null, null, "prod ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setIdP(Integer.parseInt(cs.getString(0)));
				us.setProd1(cs.getString(1));
				us.setQuant1(cs.getString(2));
				us.setValor1(cs.getString(3));
				us.setImage(cs.getBlob(4));
				us.setEForn(cs.getString(5));
				us.setDataIn(cs.getString(6));
				us.setDataOut(cs.getString(7));
				us.setETotal(cs.getString(8));
				us.setETipo(cs.getString(9));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> findP7(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "prod", "quant", "valor", "image", "forn", "dataIn", "dataOut", "etotal", "tipo"};
		Cursor cs = db.query("paginaSeven", cl, null, null, null, null, "prod ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setIdP(Integer.parseInt(cs.getString(0)));
				us.setProd1(cs.getString(1));
				us.setQuant1(cs.getString(2));
				us.setValor1(cs.getString(3));
				us.setImage(cs.getBlob(4));
				us.setEForn(cs.getString(5));
				us.setDataIn(cs.getString(6));
				us.setDataOut(cs.getString(7));
				us.setETotal(cs.getString(8));
				us.setETipo(cs.getString(9));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> findP6(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "prod", "quant", "valor", "image", "forn", "dataIn", "dataOut", "etotal", "tipo"};
		Cursor cs = db.query("paginaSix", cl, null, null, null, null, "prod ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setIdP(Integer.parseInt(cs.getString(0)));
				us.setProd1(cs.getString(1));
				us.setQuant1(cs.getString(2));
				us.setValor1(cs.getString(3));
				us.setImage(cs.getBlob(4));
				us.setEForn(cs.getString(5));
				us.setDataIn(cs.getString(6));
				us.setDataOut(cs.getString(7));
				us.setETotal(cs.getString(8));
				us.setETipo(cs.getString(9));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> findP5(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "prod", "quant", "valor", "image", "forn", "dataIn", "dataOut", "etotal", "tipo"};
		Cursor cs = db.query("paginaFive", cl, null, null, null, null, "prod ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setIdP(Integer.parseInt(cs.getString(0)));
				us.setProd1(cs.getString(1));
				us.setQuant1(cs.getString(2));
				us.setValor1(cs.getString(3));
				us.setImage(cs.getBlob(4));
				us.setEForn(cs.getString(5));
				us.setDataIn(cs.getString(6));
				us.setDataOut(cs.getString(7));
				us.setETotal(cs.getString(8));
				us.setETipo(cs.getString(9));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> findP4(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "prod", "quant", "valor", "image", "forn", "dataIn", "dataOut", "etotal", "tipo"};
		Cursor cs = db.query("paginaFour", cl, null, null, null, null, "prod ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setIdP(Integer.parseInt(cs.getString(0)));
				us.setProd1(cs.getString(1));
				us.setQuant1(cs.getString(2));
				us.setValor1(cs.getString(3));
				us.setImage(cs.getBlob(4));
				us.setEForn(cs.getString(5));
				us.setDataIn(cs.getString(6));
				us.setDataOut(cs.getString(7));
				us.setETotal(cs.getString(8));
				us.setETipo(cs.getString(9));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> findP3(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "prod", "quant", "valor", "image", "forn", "dataIn", "dataOut", "etotal", "tipo"};
		Cursor cs = db.query("paginaThree", cl, null, null, null, null, "prod ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setIdP(Integer.parseInt(cs.getString(0)));
				us.setProd1(cs.getString(1));
				us.setQuant1(cs.getString(2));
				us.setValor1(cs.getString(3));
				us.setImage(cs.getBlob(4));
				us.setEForn(cs.getString(5));
				us.setDataIn(cs.getString(6));
				us.setDataOut(cs.getString(7));
				us.setETotal(cs.getString(8));
				us.setETipo(cs.getString(9));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}

	public List<util> findP2(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "prod", "quant", "valor", "image", "forn", "dataIn", "dataOut", "etotal", "tipo"};
		Cursor cs = db.query("paginaTwo", cl, null, null, null, null, "prod ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setIdP(Integer.parseInt(cs.getString(0)));
				us.setProd1(cs.getString(1));
				us.setQuant1(cs.getString(2));
				us.setValor1(cs.getString(3));
				us.setImage(cs.getBlob(4));
				us.setEForn(cs.getString(5));
				us.setDataIn(cs.getString(6));
				us.setDataOut(cs.getString(7));
				us.setETotal(cs.getString(8));
				us.setETipo(cs.getString(9));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> findP1(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "prod", "quant", "valor", "image", "forn", "dataIn", "dataOut", "etotal", "tipo"};
		Cursor cs = db.query("paginaOne", cl, null, null, null, null, "prod ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setIdP(Integer.parseInt(cs.getString(0)));
				us.setProd1(cs.getString(1));
				us.setQuant1(cs.getString(2));
				us.setValor1(cs.getString(3));
				us.setImage(cs.getBlob(4));
				us.setEForn(cs.getString(5));
				us.setDataIn(cs.getString(6));
				us.setDataOut(cs.getString(7));
				us.setETotal(cs.getString(8));
				us.setETipo(cs.getString(9));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public util getVendaA(long id){
		util us = new util();
		Cursor cs = db.rawQuery("select * from VendasA WHERE id ="+id+"", null);
		if(cs.moveToFirst()){
			do{
				us.setProd1(cs.getString(cs.getColumnIndex("prod")));
				us.setQuant1(cs.getString(cs.getColumnIndex("quant")));
				us.setValor1(cs.getString(cs.getColumnIndex("valor")));
				us.setImage(cs.getBlob(cs.getColumnIndex("imagem")));
			}while(cs.moveToNext());
		}
		return us;
	}
	public util getVendaB(long id){
		util us = new util();
		Cursor cs = db.rawQuery("select * from VendasB WHERE id ="+id+"", null);
		if(cs.moveToFirst()){
			do{
				us.setProd1(cs.getString(cs.getColumnIndex("prod")));
				us.setQuant1(cs.getString(cs.getColumnIndex("quant")));
				us.setValor1(cs.getString(cs.getColumnIndex("valor")));
				us.setImage(cs.getBlob(cs.getColumnIndex("imagem")));
			}while(cs.moveToNext());
		}
		return us;
	}
	public util getVendaC(long id){
		util us = new util();
		Cursor cs = db.rawQuery("select * from VendasC WHERE id ="+id+"", null);
		if(cs.moveToFirst()){
			do{
				us.setProd1(cs.getString(cs.getColumnIndex("prod")));
				us.setQuant1(cs.getString(cs.getColumnIndex("quant")));
				us.setValor1(cs.getString(cs.getColumnIndex("valor")));
				us.setImage(cs.getBlob(cs.getColumnIndex("imagem")));
			}while(cs.moveToNext());
		}
		return us;
	}
	public util getVendaD(long id){
		util us = new util();
		Cursor cs = db.rawQuery("select * from VendasD WHERE id ="+id+"", null);
		if(cs.moveToFirst()){
			do{
				us.setProd1(cs.getString(cs.getColumnIndex("prod")));
				us.setQuant1(cs.getString(cs.getColumnIndex("quant")));
				us.setValor1(cs.getString(cs.getColumnIndex("valor")));
				us.setImage(cs.getBlob(cs.getColumnIndex("imagem")));
			}while(cs.moveToNext());
		}
		return us;
	}
	public void SupSomIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("sup", us.getSupVal());
		db.insert("supSom", null, ct);
	}
	public void limpaCarrinho(){
		db.execSQL("delete from carrinho");
	}
	public void delItem(long id){
		db.delete("carrinho", "id = ?", new String[]{String.valueOf(id)});
	}

	public void limpaVendasA(){
		db.execSQL("delete from VendasA");
	}
	public void limpaVendasB(){
		db.execSQL("delete from VendasB");
	}
	public void limpaVendasC(){
		db.execSQL("delete from VendasC");
	}
	public void limpaVendasD(){
		db.execSQL("delete from VendasD");
	}
	public void carIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("produto", us.getProd2());
		ct.put("quantd", us.getQuant2());
		ct.put("valores", us.getValor2());
		ct.put("imagem", us.getImage2());
		db.insert("carrinho", null, ct);
	}
	public void SupIn(util us){
		ContentValues ct = new ContentValues();
		
		ct.put("supVal", us.getSupVal());
		ct.put("supDesc", us.getSupDesc());
		
		db.insert("suprimento", null, ct);
	}
	public void vendasIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("data", us.getData());
		ct.put("prod", us.getProd1());
		ct.put("total", us.getValor1());
		db.insert("Vendas", null, ct);
	}
	public void vendasAIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("prod", us.getProd1());
		ct.put("quant", us.getQuant1());
		ct.put("valor", us.getValor1());
		ct.put("imagem", us.getImage());
		db.insert("VendasA", null, ct);
	}
	public void vendasBIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("prod", us.getProd1());
		ct.put("quant", us.getQuant1());
		ct.put("valor", us.getValor1());
		ct.put("imagem", us.getImage());
		db.insert("VendasB", null, ct);
	}
	public void vendasCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("prod", us.getProd1());
		ct.put("quant", us.getQuant1());
		ct.put("valor", us.getValor1());
		ct.put("imagem", us.getImage());
		db.insert("VendasC", null, ct);
	}
	public void vendasDIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("prod", us.getProd1());
		ct.put("quant", us.getQuant1());
		ct.put("valor", us.getValor1());
		ct.put("imagem", us.getImage());
		db.insert("VendasD", null, ct);
	}
	public void saIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("sangria", us.getSangria());
		db.insert("saldo", null, ct);
	}
	public void opIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("operador", us.getOp());
		db.insert("operador", null, ct);
	}
	public void funIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("fundo", us.getFundo());
		db.insert("fundo", null, ct);
	}
	public void sangIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("valor", us.getSanVal());
		ct.put("motivo", us.getSanMot());
		db.insert("sangria", null, ct);
	}
	public void moneyIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("money", us.getMoney());
		db.insert("dinheiro", null, ct);
	}
	public void eloDIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("eloD", us.getEloD());
		db.insert("eloD", null, ct);
	}
	public void eloCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("eloC", us.getEloC());
		db.insert("eloC", null, ct);
	}
	public void visaDIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("visaD", us.getVisaD());
		db.insert("visaD", null, ct);
	}
	public void visaCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("visaC", us.getVisaC());
		db.insert("visaC", null, ct);
	}
	public void masterDIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("masterD", us.getMasterD());
		db.insert("masterD", null, ct);
	}
	public void masterCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("masterC", us.getMasterC());
		db.insert("masterC", null, ct);
	}
	public void hiperIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("hiper", us.getHiper());
		db.insert("hiper", null, ct);
	}
	public void hiperCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("hiperC", us.getHiperC());
		db.insert("hiperC", null, ct);
	}
	public void cabalIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("cabal", us.getCabal());
		db.insert("cabal", null, ct);
	}
	public void pixIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("pix", us.getPix());
		db.insert("pix", null, ct);
	}
	public void verdeIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("verde", us.getVerde());
		db.insert("verde", null, ct);
	}
	public void soroIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("soro", us.getSoro());
		db.insert("soro", null, ct);
	}
	public void personIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("person", us.getPerson());
		db.insert("person", null, ct);
	}
	public void ouroIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("ouro", us.getOuro());
		db.insert("ouro", null, ct);
	}
	public void banriIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("banrisul", us.getbanric());
		db.insert("banrisul", null, ct);
	}
	public void banriCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("banriC", us.getBanriC());
		db.insert("banriC", null, ct);
	}
	public void banesIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("banes", us.getBanes());
		db.insert("banes", null, ct);
	}
	public void americIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("americ", us.getAmeric());
		db.insert("americ", null, ct);
	}
	
	public List<util> eFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "eCod", "eProd", "eQuant", "eForn", "eDataIn", "eDataOut", "eVal", "eTotal", "eTipo"};
		Cursor cs = db.query("estoque", cl, null, null, null, null, "eCod ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setEId(Integer.parseInt(cs.getString(0)));
				us.setECod(cs.getString(1));
				us.setEProd(cs.getString(2));
				us.setEQuant(cs.getString(3));
				us.setEForn(cs.getString(4));
				us.setDataIn(cs.getString(5));
				us.setDataOut(cs.getString(6));
				us.setEVal(cs.getString(7));
				us.setETotal(cs.getString(8));
				us.setETipo(cs.getString(9));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}

	public util getCarRw(long id){
		util us = new util();
		Cursor cs = db.rawQuery("select valores from carrinho WHERE id ="+id+"", null);
		if(cs.moveToFirst()){
			do{
				us.setValor2(cs.getString(cs.getColumnIndex("valores")));
			}while(cs.moveToNext());
		}
		return us;
	}
	public List<util> getVedaS(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] colunm = {"id", "data", "prod", "total"};
		Cursor cs = db.query("Vendas", colunm, null, null, null, null, "data ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do {
				util us = new util();
				us.setVendaId(Integer.parseInt(cs.getString(0)));
				us.setData(cs.getString(1));
				us.setProd1(cs.getString(2));
				us.setValor1(cs.getString(3));
				arr.add(us);
			}  while (cs.moveToNext());
		}
		return arr;
	}
	public util getCarR(long id){
		util us = new util();
		Cursor cs = db.rawQuery("select * from carrinho WHERE id ="+id+"", null);
		if(cs.moveToFirst()){
			do{
				us.setProd2(cs.getString(cs.getColumnIndex("produto")));
				us.setQuant2(cs.getString(cs.getColumnIndex("quantd")));
				us.setValor2(cs.getString(cs.getColumnIndex("valores")));
				us.setImage2(cs.getBlob(cs.getColumnIndex("imagem")));
			}while(cs.moveToNext());
		}
		return us;
	}
	public List<util> carrinho(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "produto", "quantd", "valores", "imagem"};
		Cursor cs = db.query("carrinho", cl, null, null, null, null, "produto ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setIdP2(Integer.parseInt(cs.getString(0)));
				us.setProd2(cs.getString(1));
				us.setQuant2(cs.getString(2));
				us.setValor2(cs.getString(3));
				us.setImage2(cs.getBlob(4));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> Pfind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "prod", "quant", "valor", "image"};
		Cursor cs = db.query("caixaP", cl, null, null, null, null, "prod ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setIdP(Integer.parseInt(cs.getString(0)));
				us.setProd1(cs.getString(1));
				us.setQuant1(cs.getString(2));
				us.setValor1(cs.getString(3));
				us.setImage(cs.getBlob(4));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> proFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "loc", "prod", "quant", "valor", "payType", "pagto", "troco"};
		Cursor cs = db.query("produtos", cl, null, null, null, null, "loc ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setProId(cs.getLong(0));
				us.setLoc(cs.getString(1));
				us.setProd1(cs.getString(2));
				us.setQuant1(cs.getString(3));
				us.setValor1(cs.getString(4));
				us.setPay1(cs.getString(5));
				us.setP1(cs.getString(6));
				us.setT1(cs.getString(7));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> funFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "fundo"};
		Cursor cs = db.query("fundo", cl, null, null, null, null, "fundo ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setFundo(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> suFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "sup"};
		Cursor cs = db.query("supSom", cl, null, null, null, null, "sup ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setSupVal(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
	return arr;
	}
	public List<util> saFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "sangria"};
		Cursor cs = db.query("saldo", cl, null, null, null, null, "sangria ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setSangria(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public util supFind(long id){
		util us = new util();
		Cursor cs = db.rawQuery("select * from suprimento WHERE id="+id+"", null);
		if(cs.moveToFirst()){

			do{
				us.setSupId(cs.getLong(cs.getColumnIndex("id")));
				us.setSupVal(cs.getString(cs.getColumnIndex("supVal")));
				us.setSupDesc(cs.getString(cs.getColumnIndex("supDesc")));
			}while(cs.moveToNext());
		}
		return us;
	}
	public util sanFind(long id){
		util us = new util();
		Cursor cs = db.rawQuery("select * from sangria WHERE id="+id+"", null);
		if(cs.moveToFirst()){
			
			do{
				us.setSanId(cs.getLong(cs.getColumnIndex("id")));
				us.setSanVal(cs.getString(cs.getColumnIndex("valor")));
				us.setSanMot(cs.getString(cs.getColumnIndex("motivo")));
			}while(cs.moveToNext());
		}
		return us;
	}
	public List<util> opFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "operador"};
		Cursor cs = db.query("operador", cl, null, null, null, null, "operador ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setOp(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> ameFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "americ"};
		Cursor cs = db.query("americ", cl, null, null, null, null, "americ ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setAmeric(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> banesFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "banes"};
		Cursor cs = db.query("banes", cl, null, null, null, null, "banes ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setBanes(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> banriCFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "banriC"};
		Cursor cs = db.query("banriC", cl, null, null, null, null, "banriC ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setBanriC(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> banriFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "banrisul"};
		Cursor cs = db.query("banrisul", cl, null, null, null, null, "banrisul ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setBanric(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> ouroFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "ouro"};
		Cursor cs = db.query("ouro", cl, null, null, null, null, "ouro ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setOuro(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> personFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "person"};
		Cursor cs = db.query("person", cl, null, null, null, null, "person ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setPerson(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> soroFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "soro"};
		Cursor cs = db.query("soro", cl, null, null, null, null, "soro ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setSoro(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> verdeFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "verde"};
		Cursor cs = db.query("verde", cl, null, null, null, null, "verde ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setVerde(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> pixFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "pix"};
		Cursor cs = db.query("pix", cl, null, null, null, null, "pix ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setPix(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> cabalFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "cabal"};
		Cursor cs = db.query("cabal", cl, null, null, null, null, "cabal ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setCabal(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> hiperCFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "hiperC"};
		Cursor cs = db.query("hiperC", cl, null, null, null, null, "hiperC ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setHiperC(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> hiperFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "hiper"};
		Cursor cs = db.query("hiper", cl, null, null, null, null, "hiper ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setHiper(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> masterCFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "masterC"};
		Cursor cs = db.query("masterC", cl, null, null, null, null, "masterC ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setMasterC(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> masterDFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "masterD"};
		Cursor cs = db.query("masterD", cl, null, null, null, null, "masterD ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setMasterD(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> visaCFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "visaC"};
		Cursor cs = db.query("visaC", cl, null, null, null, null, "visaC ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setVisaC(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> visaDFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "visaD"};
		Cursor cs = db.query("visaD", cl, null, null, null, null, "visaD ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setVisaD(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> eloCFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "eloC"};
		Cursor cs = db.query("eloC", cl, null, null, null, null, "eloC ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setEloC(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> eloDFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "eloD"};
		Cursor cs = db.query("eloD", cl, null, null, null, null, "eloD ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setEloD(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> moFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "money"};
		Cursor cs = db.query("dinheiro", cl, null, null, null, null, "money ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
		do{
			util us = new util();
			us.setMoney(cs.getString(1));
			arr.add(us);	
		}while(cs.moveToNext());
		}
		return arr;
	}
}
