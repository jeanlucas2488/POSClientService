package lucas.client.service.caixa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import lucas.client.service.etc.util;
import lucas.client.service.mercearia.databases.SQLiteControl;
import lucas.client.service.sqlite.DB;

public class DBGen extends Activity {
    Context c = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       try{ util tes1 = new util();
           tes1.setOp("teste");
           DB db = new DB(c);
           db.opIn(tes1);

           util tes2 = new util();
           tes2.setOp("teste");
           SQLiteControl db2 = new SQLiteControl(c);
           db2.opIn(tes2);
} catch (Exception e){
       }
        Intent it = new Intent(c, selfConfig.class);
        startActivity(it);

}
}