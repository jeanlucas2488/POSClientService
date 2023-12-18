package lucas.client.service.mercearia.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static String name = "MCRDB.db";

    public SQLiteHelper(Context c){
        super(c, name, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE supervisor" +
                "(id integer primary key, superV text);");

        db.execSQL("CREATE TABLE ContasReceber" +
                "(id integer primary key, docto text, cliente text, dataCadastro text, valRecebido text, valDoc text, desconto text, acrescimo text, saldo text, status text);");
        db.execSQL("CREATE TABLE BaixaBoletos" +
                "(id integer primary key, data text, vencimento text, valor text, tipo text, status text, descricao text, imagem blob);");

        // TODO: Implement this method
        db.execSQL("CREATE TABLE Boletos" +
                "(id integer primary key, data text, vencimento text, valor text, tipo text, status text, descricao text, imagem blob);");
        db.execSQL("CREATE TABLE ContasPagar" +
                "(id integer primary key, codigo text, classificacao text, valor_pagar text, data_vencimento text, empresa text, " +
                "conta_bancaria text, valor_pagar_ag text, data_ag text, pessoa text, data_comp text, desc_ag text, " +
                "comentarios text, status text, valor_pago text, saldo_pagar text);");

        // TODO: Implement this method
        db.execSQL("CREATE TABLE ContasPagar" +
                "(id integer primary key, codigo text, classificacao text, valor_pagar text, data_vencimento text, empresa text, " +
                "conta_bancaria text, valor_pagar_ag text, data_ag text, pessoa text, data_comp text, desc_ag text, " +
                "comentarios text, status text, valor_pago text, saldo_pagar text);");

        db.execSQL("CREATE TABLE supervisor" +
                "(id integer primary key, superV text);");
        db.execSQL("CREATE TABLE retPass" +
                "(id integer primary key, usuario text, senha text);");
        db.execSQL("CREATE TABLE senhaCM" +
                "(userId integer primary key, usuario text, senha text);");
        db.execSQL("CREATE TABLE senhaMCR" +
                "(userId integer primary key, usuario text, senha text);");


        db.execSQL("CREATE TABLE Sangrias" +
                "(id integer primary key, sangria_val text, sangria_mot text);");

        db.execSQL("CREATE TABLE Suprimentos" +
                "(id integer primary key, suprimento_val text, suprimento_mot text);");

        db.execSQL("CREATE TABLE Fechamento" +
                "(id integer primary key, data text, NfeHtml text);");
        db.execSQL("CREATE TABLE carrinho" +
                "(id integer primary key, produto text, quantd text, valores text, imagem blob);");

        db.execSQL("CREATE TABLE Paginas" +
                "(id integer primary key, paginas text);");
        db.execSQL("CREATE TABLE paginaOne" +
                "(id integer primary key, prod text, quant text, valor text, image blob, forn text, dataIn text, dataOut text, etotal text, tipo text);");
        db.execSQL("CREATE TABLE paginaTwo" +
                "(id integer primary key, prod text, quant text, valor text, image blob, forn text, dataIn text, dataOut text, etotal text, tipo text);");
        db.execSQL("CREATE TABLE paginaThree" +
                "(id integer primary key, prod text, quant text, valor text, image blob, forn text, dataIn text, dataOut text, etotal text, tipo text);");
        db.execSQL("CREATE TABLE paginaFour" +
                "(id integer primary key, prod text, quant text, valor text, image blob, forn text, dataIn text, dataOut text, etotal text, tipo text);");
        db.execSQL("CREATE TABLE paginaFive" +
                "(id integer primary key, prod text, quant text, valor text, image blob, forn text, dataIn text, dataOut text, etotal text, tipo text);");
        db.execSQL("CREATE TABLE paginaSix" +
                "(id integer primary key, prod text, quant text, valor text, image blob, forn text, dataIn text, dataOut text, etotal text, tipo text);");
        db.execSQL("CREATE TABLE paginaSeven" +
                "(id integer primary key, prod text, quant text, valor text, image blob, forn text, dataIn text, dataOut text, etotal text, tipo text);");
        db.execSQL("CREATE TABLE paginaEight" +
                "(id integer primary key, prod text, quant text, valor text, image blob, forn text, dataIn text, dataOut text, etotal text, tipo text);");
        db.execSQL("CREATE TABLE paginaNine" +
                "(id integer primary key, prod text, quant text, valor text, image blob, forn text, dataIn text, dataOut text, etotal text, tipo text);");
        db.execSQL("CREATE TABLE paginaTen" +
                "(id integer primary key, prod text, quant text, valor text, image blob, forn text, dataIn text, dataOut text, etotal text, tipo text);");

        db.execSQL("CREATE TABLE produtos " +
                "(id integer primary key autoincrement, loc TEXT, prod TEXT, quant TEXT, valor TEXT, payType TEXT, pagto TEXT, troco TEXT);");
        db.execSQL("CREATE TABLE dinheiro (id integer primary key autoincrement, money TEXT);");
        db.execSQL("CREATE TABLE operador (id integer primary key autoincrement, operador TEXT);");
        db.execSQL("CREATE TABLE fundo (id integer primary key autoincrement, fundo TEXT);");
        db.execSQL("CREATE TABLE saldo (id integer primary key autoincrement, sangria TEXT);");
        db.execSQL("CREATE TABLE suprimento(id integer primary key, supVal text, supDesc text);");
        db.execSQL("CREATE TABLE supSom(id integer primary key, sup text);");
        db.execSQL("CREATE TABLE sangria (id integer primary key, valor TEXT, motivo TEXT);");
        db.execSQL("CREATE TABLE eloD (id integer primary key autoincrement, eloD TEXT);");
        db.execSQL("CREATE TABLE eloC (id integer primary key autoincrement, eloC TEXT);");
        db.execSQL("CREATE TABLE visaD (id integer primary key autoincrement, visaD TEXT);");
        db.execSQL("CREATE TABLE visaC (id integer primary key autoincrement, visaC TEXT);");
        db.execSQL("CREATE TABLE masterD (id integer primary key autoincrement, masterD TEXT);");
        db.execSQL("CREATE TABLE masterC (id integer primary key autoincrement, masterC TEXT);");
        db.execSQL("CREATE TABLE hiper (id integer primary key autoincrement, hiper TEXT);");
        db.execSQL("CREATE TABLE hiperC (id integer primary key autoincrement, hiperC TEXT);");
        db.execSQL("CREATE TABLE cabal (id integer primary key autoincrement, cabal TEXT);");
        db.execSQL("CREATE TABLE pix (id integer primary key autoincrement, pix TEXT);");
        db.execSQL("CREATE TABLE verde (id integer primary key autoincrement, verde TEXT);");
        db.execSQL("CREATE TABLE person (id integer primary key autoincrement, person TEXT);");
        db.execSQL("CREATE TABLE soro (id integer primary key autoincrement, soro TEXT);");
        db.execSQL("CREATE TABLE ouro (id integer primary key autoincrement, ouro TEXT);");
        db.execSQL("CREATE TABLE banrisul (id integer primary key autoincrement, banrisul TEXT);");
        db.execSQL("CREATE TABLE banriC (id integer primary key autoincrement, banriC TEXT);");
        db.execSQL("CREATE TABLE banes (id integer primary key autoincrement, banes TEXT);");
        db.execSQL("CREATE TABLE americ (id integer primary key autoincrement, americ TEXT);");
    }

    @Override
    public void onConfigure(SQLiteDatabase db)
    {
        // TODO: Implement this method
        super.onConfigure(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase p1, int p2, int p3)
    {
        // TODO: Implement this method
        p1.execSQL("DROP TABLE IF EXISTS");
    }
}