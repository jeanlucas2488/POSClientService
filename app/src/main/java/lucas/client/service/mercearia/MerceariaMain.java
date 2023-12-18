package lucas.client.service.mercearia;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.List;

import lucas.client.service.Fragments.Page1;
import lucas.client.service.Fragments.Page2;
import lucas.client.service.Fragments.adapter.FragmentAd;
import lucas.client.service.Fragments.adapter.productAdapter;
import lucas.client.service.Fragments.page10;
import lucas.client.service.Fragments.page3;
import lucas.client.service.Fragments.page4;
import lucas.client.service.Fragments.page5;
import lucas.client.service.Fragments.page6;
import lucas.client.service.Fragments.page7;
import lucas.client.service.Fragments.page8;
import lucas.client.service.Fragments.page9;
import lucas.client.service.Login;
import lucas.client.service.R;
import lucas.client.service.caixa.adapters.gridAd;
import lucas.client.service.caixa.adapters.mainAd;
import lucas.client.service.caixa.product.pay;
import lucas.client.service.caixa.setup.fechamentos.fechaCaixa;
import lucas.client.service.caixa.setup.lancamentos.historico;
import lucas.client.service.etc.util;
import lucas.client.service.mercearia.databases.SQLiteControl;
import lucas.client.service.sqlite.DB;

public class MerceariaMain extends AppCompatActivity {
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
        androidx.appcompat.widget.Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        vp = (ViewPager) findViewById(R.id.viewpager);
        FragmentAd ad = new FragmentAd(getSupportFragmentManager());
        try{
            SQLiteControl db = new SQLiteControl(c);
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
            SQLiteControl db = new SQLiteControl(c);
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
            SQLiteControl db = new SQLiteControl(c);
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
            SQLiteControl db = new SQLiteControl(c);
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
            SQLiteControl db = new SQLiteControl(c);
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
            SQLiteControl db = new SQLiteControl(c);
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
            SQLiteControl db = new SQLiteControl(c);
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
            SQLiteControl db = new SQLiteControl(c);
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
            SQLiteControl db = new SQLiteControl(c);
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
            SQLiteControl db = new SQLiteControl(c);
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
            lis.setOnItemClickListener(new AdapterView.OnItemClickListener(){

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
                                    SQLiteControl p = new SQLiteControl(c);
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
                                        SQLiteControl de = new SQLiteControl(c);
                                        de.delSangSaldo();
                                        de.saIn(us2);

                                        util us = new util();
                                        us.setSanVal(val.getText().toString());
                                        us.setSanMot(mot.getText().toString());
                                        SQLiteControl da = new SQLiteControl(c);
                                        da.sangIn(us);
                                        da.sanInsert(us);

                                        try {
                                            File sd = Environment.getExternalStorageDirectory();
                                            File data = Environment.getDataDirectory();

                                            if (sd.canWrite()) {
                                                String  currentDBPath= "//data//" + c.getOpPackageName()
                                                        + "//databases//" + "MCRDB.db";
                                                String  currentDBPath2 = "//data//" + c.getOpPackageName()
                                                        + "//databases//" + "MCRDB.db-shm";
                                                String  currentDBPath3 = "//data//" + c.getOpPackageName()
                                                        + "//databases//" + "MCRDB.db-wal";

                                                String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db";
                                                String backupDBPath2  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-shm";
                                                String backupDBPath3  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-wal";

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
                                    SQLiteControl da = new SQLiteControl(c);
                                    da.sangIn(us);
                                    da.sanInsert(us);
                                    util us2 = new util();
                                    us2.setSangria(val.getText().toString());
                                    SQLiteControl de = new SQLiteControl(c);
                                    de.saIn(us2);


                                    try {
                                        File sd = Environment.getExternalStorageDirectory();
                                        File data = Environment.getDataDirectory();

                                        if (sd.canWrite()) {
                                            String  currentDBPath= "//data//" + c.getOpPackageName()
                                                    + "//databases//" + "MCRDB.db";
                                            String  currentDBPath2 = "//data//" + c.getOpPackageName()
                                                    + "//databases//" + "MCRDB.db-shm";
                                            String  currentDBPath3 = "//data//" + c.getOpPackageName()
                                                    + "//databases//" + "MCRDB.db-wal";

                                            String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db";
                                            String backupDBPath2  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-shm";
                                            String backupDBPath3  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-wal";

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
                                    SQLiteControl p = new SQLiteControl(c);
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
                                        SQLiteControl de = new SQLiteControl(c);
                                        de.delSupSom();
                                        de.SupSomIn(us2);

                                        util us = new util();
                                        us.setSupVal(val.getText().toString());
                                        us.setSupDesc(mot.getText().toString());
                                        SQLiteControl da = new SQLiteControl(c);
                                        da.SupIn(us);
                                        da.supInsert(us);

                                        try {
                                            File sd = Environment.getExternalStorageDirectory();
                                            File data = Environment.getDataDirectory();

                                            if (sd.canWrite()) {
                                                String  currentDBPath= "//data//" + c.getOpPackageName()
                                                        + "//databases//" + "MCRDB.db";
                                                String  currentDBPath2 = "//data//" + c.getOpPackageName()
                                                        + "//databases//" + "MCRDB.db-shm";
                                                String  currentDBPath3 = "//data//" + c.getOpPackageName()
                                                        + "//databases//" + "MCRDB.db-wal";

                                                String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db";
                                                String backupDBPath2  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-shm";
                                                String backupDBPath3  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-wal";

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
                                    SQLiteControl da = new SQLiteControl(c);
                                    da.SupIn(us);
                                    da.supInsert(us);
                                    util us2 = new util();
                                    us2.setSupVal(val.getText().toString());
                                    SQLiteControl de = new SQLiteControl(c);
                                    de.delSupSom();
                                    de.SupSomIn(us2);


                                    try {
                                        File sd = Environment.getExternalStorageDirectory();
                                        File data = Environment.getDataDirectory();

                                        if (sd.canWrite()) {
                                            String  currentDBPath= "//data//" + c.getOpPackageName()
                                                    + "//databases//" + "MCRDB.db";
                                            String  currentDBPath2 = "//data//" + c.getOpPackageName()
                                                    + "//databases//" + "MCRDB.db-shm";
                                            String  currentDBPath3 = "//data//" + c.getOpPackageName()
                                                    + "//databases//" + "MCRDB.db-wal";

                                            String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db";
                                            String backupDBPath2  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-shm";
                                            String backupDBPath3  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-wal";

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
                            + "//databases//" + "MCRDB.db";
                    String  currentDBPath2 = "//data//" + c.getOpPackageName()
                            + "//databases//" + "MCRDB.db-shm";
                    String  currentDBPath3 = "//data//" + c.getOpPackageName()
                            + "//databases//" + "MCRDB.db-wal";

                    String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db";
                    String backupDBPath2  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-shm";
                    String backupDBPath3  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-wal";

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
        return super.onKeyUp(keyCode, event);
    }
    @Override
    public void onBackPressed()
    {
        // TODO: Implement this method

    }
    public void runCarrinho(){
        SQLiteControl srv = new SQLiteControl(c);
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
                    SQLiteControl d1 = new SQLiteControl(c);
                    util carRw1 = d1.getCarRw(1);
                    if(!carRw1.getValor2().equals("")){
                        CarRw1 = carRw1.getValor2();
                    }
                }catch(Exception e){
                    CarRw1 = "0";
                }
                try{
                    SQLiteControl d2 = new SQLiteControl(c);
                    util carRw2 = d2.getCarRw(2);
                    if(!carRw2.getValor2().equals("")){
                        CarRw2 = carRw2.getValor2();
                    }
                }catch(Exception e){
                    CarRw2 = "0";
                }
                try{
                    SQLiteControl d3 = new SQLiteControl(c);
                    util carRw3 = d3.getCarRw(3);
                    if(!carRw3.getValor2().equals("")){
                        CarRw3 = carRw3.getValor2();
                    }
                }catch(Exception e){
                    CarRw3 = "0";
                }
                try{
                    SQLiteControl d4 = new SQLiteControl(c);
                    util carRw4 = d4.getCarRw(4);
                    if(!carRw4.getValor2().equals("")){
                        CarRw4 = carRw4.getValor2();
                    }
                }catch(Exception e){
                    CarRw4 = "0";
                }
                try{
                    SQLiteControl d5 = new SQLiteControl(c);
                    util carRw5 = d5.getCarRw(5);
                    if(!carRw5.getValor2().equals("")){
                        CarRw5 = carRw5.getValor2();
                    }
                }catch(Exception e){
                    CarRw5 = "0";
                }
                try{
                    SQLiteControl d6 = new SQLiteControl(c);
                    util carRw6 = d6.getCarRw(6);
                    if(!carRw6.getValor2().equals("")){
                        CarRw6 = carRw6.getValor2();
                    }
                }catch(Exception e){
                    CarRw6 = "0";
                }
                try{
                    SQLiteControl d7 = new SQLiteControl(c);
                    util carRw7 = d7.getCarRw(7);
                    if(!carRw7.getValor2().equals("")){
                        CarRw7 = carRw7.getValor2();
                    }
                }catch(Exception e){
                    CarRw7 = "0";
                }
                try{
                    SQLiteControl d8 = new SQLiteControl(c);
                    util carRw8 = d8.getCarRw(8);
                    if(!carRw8.getValor2().equals("")){
                        CarRw8 = carRw8.getValor2();
                    }
                }catch(Exception e){
                    CarRw8 = "0";
                }
                try{
                    SQLiteControl d9 = new SQLiteControl(c);
                    util carRw9 = d9.getCarRw(9);
                    if(!carRw9.getValor2().equals("")){
                        CarRw9 = carRw9.getValor2();
                    }
                }catch(Exception e){
                    CarRw9 = "0";
                }
                try{
                    SQLiteControl d10 = new SQLiteControl(c);
                    util carRw10 = d10.getCarRw(10);
                    if(!carRw10.getValor2().equals("")){
                        CarRw10 = carRw10.getValor2();
                    }
                }catch(Exception e){
                    CarRw10 = "0";
                }
                try{
                    SQLiteControl d11 = new SQLiteControl(c);
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
