package lucas.client.service.etc;
import javax.security.auth.callback.*;

public class util {

	public String carD, carC, pix, temp;
	public String eCod, eProd, eQuant, eForn, eDataIn, eDataOut, eValor, eTotal, eTipo, nfe;
	public long eId, supId;
	public String sangria_val, cat, sangria_mot, op, sangria, fundo;
	public String loc;
	public String money, data, table, user, pass;
	public String prod;
	public byte[] image, image2;
    public long carD_ID, carC_ID, pix_ID;

	public String quant;
	public String valor, pagto, pagto2, pagto3, pagto4, pagto5;
	public String payType;
	public String troco, supVal, supDesc;

	public String loc2;
	public String prod2;
	public String quant2;
	public String valor2;
	public String payType2;
	public String troco2;

	public String loc3;
	public String prod3;
	public String quant3;
	public String valor3;
	public String payType3;
	public String troco3;

	public String loc4;
	public String prod4;
	public String quant4;
	public String valor4;
	public String payType4;
	public String troco4;

	public long id, idP2, id2, idPro, userId;
	public String loc5;
	public String prod5;
	public String quant5;
	public String valor5;
	public String payType5;
	public String troco5;
	public long tempId;

	public long getTempId(){
		return tempId;
	}
	public void setTempId(long id){
		this.tempId = id;
	}
public String getTemp(){
	return temp;
}
public void setTemp(String tm){
	this.temp = tm;
}
	public String senha_supervisor;
	public long vendaId;
	public long supervisor_id;

	public long getCarD_ID(){
		return carD_ID;
	}
	public void setCarD_ID(long cd){
		this.carD_ID = cd;
	}
	public long getCarC_ID(){
		return carC_ID;
	}
	public void setCarC_ID(long cd){
		this.carC_ID = cd;
	}
	public long getPix_ID(){
		return pix_ID;
	}
	public void setPix_ID(long cd){
		this.pix_ID = cd;
	}
	public long getVendaId() {
		return vendaId;
	}

	public void setVendaId(long id) {
		this.vendaId = id;
	}

	public long getSupervisor_id() {
		return supervisor_id;
	}

	public void setSupervisor_id(long id) {
		this.supervisor_id = id;
	}

	public String getSenhaSuperVisor() {
		return senha_supervisor;
	}

	public void setSenhaSuperVisor(String sup) {
		this.senha_supervisor = sup;
	}

	public String getNfe() {
		return nfe;
	}

	public void setNfe(String nf) {
		this.nfe = nf;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long id) {
		this.userId = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String tb) {
		this.user = tb;
	}

	public String getSenha() {
		return pass;
	}

	public void setSenha(String tb) {
		this.pass = tb;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String tb) {
		this.table = tb;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCategory() {
		return cat;
	}

	public void setCategory(String cat) {
		this.cat = cat;
	}

	public long getIdP2() {
		return idP2;
	}

	public void setIdP2(long id) {
		this.idP2 = id;
	}

	public byte[] getImage2() {
		return image2;
	}

	public void setImage2(byte[] im) {
		this.image2 = im;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] im) {
		this.image = im;
	}

	public long getIdP() {
		return id2;
	}

	public void setIdP(long id) {
		this.id2 = id;
	}

	public long getSupId() {
		return supId;
	}

	public void setSupId(long id) {
		this.supId = id;
	}

	public long getEId() {
		return eId;
	}

	public void setEId(long id) {
		this.eId = id;
	}

	public String getSupDesc() {
		return supDesc;
	}

	public void setSupDesc(String in) {
		this.supDesc = in;
	}

	public String getSupVal() {
		return supVal;
	}

	public void setSupVal(String in) {
		this.supVal = in;
	}

	public String getETipo() {
		return eTipo;
	}

	public void setETipo(String in) {
		this.eTipo = in;
	}

	public String getETotal() {
		return eTotal;
	}

	public void setETotal(String in) {
		this.eTotal = in;
	}

	public String getEVal() {
		return eValor;
	}

	public void setEVal(String val) {
		this.eValor = val;
	}

	public String getDataOut() {
		return eDataOut;
	}

	public void setDataOut(String out) {
		this.eDataOut = out;
	}

	public String getDataIn() {
		return eDataIn;
	}

	public void setDataIn(String in) {
		this.eDataIn = in;
	}

	public String getEForn() {
		return eForn;
	}

	public void setEForn(String forn) {
		this.eForn = forn;
	}

	public String getEQuant() {
		return eQuant;
	}

	public void setEQuant(String quant) {
		this.eQuant = quant;
	}

	public String getEProd() {
		return eProd;
	}

	public void setEProd(String prod) {
		this.eProd = prod;
	}

	public String getECod() {
		return eCod;
	}

	public void setECod(String cod) {
		this.eCod = cod;
	}

	public String getFundo() {
		return fundo;
	}

	public void setFundo(String fun) {
		this.fundo = fun;
	}

	public String getSangria() {
		return sangria;
	}

	public void setSangria(String san) {
		this.sangria = san;
	}

	public long getProId() {
		return idPro;
	}

	public void setProId(long id) {
		this.idPro = id;
	}

	public long id() {
		return id;
	}

	public void setSanId(long id) {
		this.id = id;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getSanMot() {
		return sangria_mot;
	}

	public void setSanMot(String mot) {
		this.sangria_mot = mot;
	}

	public String getSanVal() {
		return sangria_val;
	}

	public void setSanVal(String val) {
		this.sangria_val = val;
	}

	public String getP5() {
		return pagto5;
	}

	public void setP5(String p5) {
		this.pagto5 = p5;
	}

	public String getP4() {
		return pagto4;
	}

	public void setP4(String p4) {
		this.pagto4 = p4;
	}

	public String getP3() {
		return pagto3;
	}

	public void setP3(String p3) {
		this.pagto3 = p3;
	}

	public String getP2() {
		return pagto2;
	}

	public void setP2(String p2) {
		this.pagto2 = p2;
	}

	public String getP1() {
		return pagto;
	}

	public void setP1(String p1) {
		this.pagto = p1;
	}

	public String getT5() {
		return troco5;
	}

	public void setT5(String t5) {
		this.troco5 = t5;
	}

	public String getT4() {
		return troco4;
	}

	public void setT4(String t4) {
		this.troco4 = t4;
	}

	public String getT3() {
		return troco3;
	}

	public void setT3(String t3) {
		this.troco3 = t3;
	}

	public String getT2() {
		return troco2;
	}

	public void setT2(String t2) {
		this.troco2 = t2;
	}

	public String getT1() {
		return troco;
	}

	public void setT1(String t1) {
		this.troco = t1;
	}

	public String getPay5() {
		return payType5;
	}

	public void setPay5(String p5) {
		this.payType5 = p5;
	}

	public String getPay4() {
		return payType4;
	}

	public void setPay4(String p4) {
		this.payType4 = p4;
	}

	public String getPay3() {
		return payType3;
	}

	public void setPay3(String p3) {
		this.payType3 = p3;
	}

	public String getPay2() {
		return payType2;
	}

	public void setPay2(String p2) {
		this.payType2 = p2;
	}

	public String getPay1() {
		return payType;
	}

	public void setPay1(String p1) {
		this.payType = p1;
	}

	public String getValor5() {
		return valor5;
	}

	public void setValor5(String v5) {
		this.valor5 = v5;
	}

	public String getValor4() {
		return valor4;
	}

	public void setValor4(String v4) {
		this.valor4 = v4;
	}

	public String getValor3() {
		return valor3;
	}

	public void setValor3(String v3) {
		this.valor3 = v3;
	}

	public String getValor2() {
		return valor2;
	}

	public void setValor2(String v2) {
		this.valor2 = v2;
	}

	public String getValor1() {
		return valor;
	}

	public void setValor1(String v1) {
		this.valor = v1;
	}

	public String getQuant5() {
		return quant5;
	}

	public void setQuant5(String qn5) {
		this.quant5 = qn5;
	}

	public String getQuant4() {
		return quant4;
	}

	public void setQuant4(String qn4) {
		this.quant4 = qn4;
	}

	public String getQuant3() {
		return quant3;
	}

	public void setQuant3(String qn3) {
		this.quant3 = qn3;
	}

	public String getQuant2() {
		return quant2;
	}

	public void setQuant2(String qn2) {
		this.quant2 = qn2;
	}

	public String getQuant1() {
		return quant;
	}

	public void setQuant1(String qn1) {
		this.quant = qn1;
	}

	public String getProd5() {
		return prod5;
	}

	public void setProd5(String pro5) {
		this.prod5 = pro5;
	}

	public String getProd4() {
		return prod4;
	}

	public void setProd4(String pro4) {
		this.prod4 = pro4;
	}

	public String getProd3() {
		return prod3;
	}

	public void setProd3(String pro3) {
		this.prod3 = pro3;
	}

	public String getProd2() {
		return prod2;
	}

	public void setProd2(String pro2) {
		this.prod2 = pro2;
	}

	public String getProd1() {
		return prod;
	}

	public void setProd1(String pro1) {
		this.prod = pro1;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String mo) {
		this.money = mo;
	}
	public String getCarD() {
		return carD;
	}

	public void setCarD(String mo) {
		this.carD = mo;
	}
	public String getCarC() {
		return carC;
	}

	public void setCarC(String mo) {
		this.carC = mo;
	}
	public String getPix() {
		return pix;
	}

	public void setPix(String mo) {
		this.pix = mo;
	}
	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getLoc2() {
		return loc2;
	}

	public void setLoc2(String loc2) {
		this.loc2 = loc2;
	}

	public String getLoc3() {
		return loc3;
	}

	public void setLoc3(String loc3) {
		this.loc3 = loc3;
	}

	public String getLoc4() {
		return loc4;
	}

	public void setLoc4(String loc4) {
		this.loc4 = loc4;
	}

	public String getLoc5() {
		return loc5;
	}

	public void setLoc5(String loc5) {
		this.loc5 = loc5;
	}
}

