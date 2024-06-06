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

	public void delMoney(){
		db.execSQL("delete from dinheiro");
	}
	public void delCarD(){
		db.execSQL("delete from cartaoD");
	}
	public void delCarC(){
		db.execSQL("delete from cartaoC");
	}
	public void delPix(){
		db.execSQL("delete from Pix");
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
	public void moneyUp(util us){
		ContentValues ct = new ContentValues();
		ct.put("money", us.getMoney());
		db.update("dinheiro", ct, "id = ?", new String[]{String.valueOf(us.getMoneyID())});
	}
	public void carDIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("carD", us.getCarD());
		db.insert("cartaoD", null, ct);
	}
	public void carDUp(util us){
		ContentValues ct = new ContentValues();
		ct.put("carD", us.getCarD());
		db.update("cartaoD", ct, "id = ?", new String[]{String.valueOf(us.getCarD_ID())});
	}
	public void carCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("carC", us.getCarC());
		db.insert("cartaoC", null, ct);
	}
	public void carCUp(util us){
		ContentValues ct = new ContentValues();
		ct.put("carC", us.getCarC());
		db.update("cartaoC", ct, "id = ?", new String[]{String.valueOf(us.getCarC_ID())});
	}
	public void PixIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("pix", us.getPix());
		db.insert("Pix", null, ct);
	}
	public void PixUp(util us){
		ContentValues ct = new ContentValues();
		ct.put("pix", us.getPix());
		db.update("Pix", ct, "id = ?", new String[]{String.valueOf(us.getPix_ID())});
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
	public List<util> getCarD(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] colunm = {"id", "carD"};
		Cursor cs = db.query("cartaoD", colunm, null, null, null, null, "carD ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do {
				util us = new util();
				us.setCarD_ID(Integer.parseInt(cs.getString(0)));
				us.setCarD(cs.getString(1));
				arr.add(us);
			}  while (cs.moveToNext());
		}
		return arr;
	}
	public List<util> getCarC(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] colunm = {"id", "carC"};
		Cursor cs = db.query("cartaoC", colunm, null, null, null, null, "carC ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do {
				util us = new util();
				us.setCarC_ID(Integer.parseInt(cs.getString(0)));
				us.setCarC(cs.getString(1));
				arr.add(us);
			}  while (cs.moveToNext());
		}
		return arr;
	}
	public List<util> getPix(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] colunm = {"id", "pix"};
		Cursor cs = db.query("Pix", colunm, null, null, null, null, "pix ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do {
				util us = new util();
				us.setPix_ID(Integer.parseInt(cs.getString(0)));
				us.setPix(cs.getString(1));
				arr.add(us);
			}  while (cs.moveToNext());
		}
		return arr;
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

	public List<util> moFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "money"};
		Cursor cs = db.query("dinheiro", cl, null, null, null, null, "money ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
		do{
			util us = new util();
			us.setMoneyID(Integer.parseInt(cs.getString(0)));
			us.setMoney(cs.getString(1));
			arr.add(us);	
		}while(cs.moveToNext());
		}
		return arr;
	}
}
