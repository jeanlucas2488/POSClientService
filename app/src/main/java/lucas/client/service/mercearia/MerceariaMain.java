package lucas.client.service.mercearia;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

import lucas.client.service.Fragments.adapter.FragmentAd;
import lucas.client.service.Fragments.adapter.productAdapter;
import lucas.client.service.mercearia.Fragments.Page1;
import lucas.client.service.mercearia.Fragments.Page2;
import lucas.client.service.mercearia.Fragments.Page3;
import lucas.client.service.mercearia.Fragments.Page4;
import lucas.client.service.mercearia.Fragments.Page5;
import lucas.client.service.mercearia.Fragments.Page6;
import lucas.client.service.mercearia.Fragments.Page7;
import lucas.client.service.mercearia.Fragments.Page8;
import lucas.client.service.mercearia.Fragments.Page9;
import lucas.client.service.mercearia.Fragments.Page10;

import lucas.client.service.R;
import lucas.client.service.caixa.adapters.gridAd;
import lucas.client.service.caixa.adapters.mainAd;
import lucas.client.service.caixa.product.pay;
import lucas.client.service.caixa.setup.fechamentos.fechaCaixa;
import lucas.client.service.caixa.setup.lancamentos.historico;
import lucas.client.service.etc.util;
import lucas.client.service.mercearia.databases.SQLiteControl;
import lucas.client.service.mercearia.setup.fechamento;
import lucas.client.service.mercearia.system.RecuperarVenda;
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
                        ad.adicionar(new Page3(), us.getCategory());
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
                        ad.adicionar(new Page4(), us.getCategory());
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
                        ad.adicionar(new Page5(), us.getCategory());
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
                        ad.adicionar(new Page6(), us.getCategory());
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
                        ad.adicionar(new Page7(), us.getCategory());
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
                        ad.adicionar(new Page8(), us.getCategory());
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
                        ad.adicionar(new Page9(), us.getCategory());
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
                        ad.adicionar(new Page10(), us.getCategory());
                    }
                }catch(Exception e){}
            }
        }catch(Exception e){}
        try{
            Intent it = getIntent();
            Bundle b = it.getExtras();
            String res = b.getString("chave");
            if(!res.toString().equals("")){
                runCarrinho();
            } else {

            }
        } catch(Exception e){}

        try{
            Intent it = getIntent();
            Bundle b = it.getExtras();
            String res = b.getString("chave2");
            if(!res.toString().equals("")){
                runVendas();
            } else {

            }
        } catch(Exception e){}
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
                    {"Fechamento de Caixa", "Sangria", "Suprimento de Caixa", "Recuperar Venda"};

            LayoutInflater li = getLayoutInflater();
            View r = li.inflate(R.layout.list_ad, null);
            ListView lis = r.findViewById(R.id.list);
            lis.setAdapter(new mainAd(c, lc));
            lis.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
                {
                    // TODO: Implement this method
                    if(lc[p3].toString().startsWith("R")){
                        Intent itr = new Intent(c, RecuperarVenda.class);
                        startActivity(itr);
                    }
                    if(lc[p3].toString().startsWith("F")){
                        try{
                            SQLiteControl db = new SQLiteControl(c);
                            List<util> test = db.getVedaS();
                            if(!test.get(0).getData().toString().equals("")){
                                Toast.makeText(c, "Você precisa finalizar a venda que está arquivada pra fechar o POS!", Toast.LENGTH_SHORT).show();
                            } else {
                            }
                        } catch (Exception e){
                            Intent itr = new Intent(c, fechaCaixa.class);
                            startActivity(itr);
                            finish();
                        }
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
        ap.setNeutralButton("Arquivar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
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
                final String result = dform.format(res_);

                try{
                    SQLiteControl db = new SQLiteControl(c);
                    util res = db.getVenda(1);
                    if(!res.getData().toString().equals("")){
                        try{
                            SQLiteControl db2 = new SQLiteControl(c);
                            util res2 = db2.getVenda(2);
                            if(!res2.getData().toString().equals("")){
                                try{
                                    SQLiteControl db3 = new SQLiteControl(c);
                                    util res3 = db.getVenda(3);
                                    if(!res3.getData().toString().equals("")){
                                        try{
                                            SQLiteControl db4 = new SQLiteControl(c);
                                            util res4 = db.getVenda(4);
                                            if(!res4.getData().toString().equals("")){

                                            } else {
                                            }
                                        } catch (Exception e){
                                            try{
                                                SQLiteControl dd2 = new SQLiteControl(c);
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
                                                SQLiteControl d2 = new SQLiteControl(c);
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
                                                SQLiteControl d2 = new SQLiteControl(c);
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
                                                SQLiteControl d2 = new SQLiteControl(c);
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
                                                SQLiteControl d2 = new SQLiteControl(c);
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
                                                SQLiteControl d2 = new SQLiteControl(c);
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
                                                SQLiteControl d2 = new SQLiteControl(c);
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
                                                SQLiteControl d2 = new SQLiteControl(c);
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
                                                SQLiteControl d2 = new SQLiteControl(c);
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
                                                SQLiteControl d2 = new SQLiteControl(c);
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
                                                SQLiteControl d2 = new SQLiteControl(c);
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
                                    } else {
                                    }
                                }catch (Exception e){
                                    try{
                                        SQLiteControl d1 = new SQLiteControl(c);
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
                                        SQLiteControl d2 = new SQLiteControl(c);
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
                                        SQLiteControl d3 = new SQLiteControl(c);
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
                                        SQLiteControl d4 = new SQLiteControl(c);
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
                                        SQLiteControl d5 = new SQLiteControl(c);
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
                                        SQLiteControl d6 = new SQLiteControl(c);
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
                                        SQLiteControl d7 = new SQLiteControl(c);
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
                                        SQLiteControl d8 = new SQLiteControl(c);
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
                                        SQLiteControl d9 = new SQLiteControl(c);
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
                                        SQLiteControl d10 = new SQLiteControl(c);
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
                                        SQLiteControl d11 = new SQLiteControl(c);
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
                        } catch (Exception e){
                            try{
                                SQLiteControl db2 = new SQLiteControl(c);
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
                                SQLiteControl db3 = new SQLiteControl(c);
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
                                SQLiteControl db4 = new SQLiteControl(c);
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
                                SQLiteControl db5 = new SQLiteControl(c);
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
                                SQLiteControl db6 = new SQLiteControl(c);
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
                                SQLiteControl db7 = new SQLiteControl(c);
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
                                SQLiteControl db8 = new SQLiteControl(c);
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
                                SQLiteControl db9 = new SQLiteControl(c);
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
                                SQLiteControl db10 = new SQLiteControl(c);
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
                                SQLiteControl db11 = new SQLiteControl(c);
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
                                SQLiteControl db12 = new SQLiteControl(c);
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
                    }else {
                    }
                }catch (Exception e){
                    try{
                        SQLiteControl db = new SQLiteControl(c);
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
                        SQLiteControl db = new SQLiteControl(c);
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
                        SQLiteControl db = new SQLiteControl(c);
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
                        SQLiteControl db = new SQLiteControl(c);
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
                        SQLiteControl db = new SQLiteControl(c);
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
                        SQLiteControl db = new SQLiteControl(c);
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
                        SQLiteControl db = new SQLiteControl(c);
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
                        SQLiteControl db = new SQLiteControl(c);
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
                        SQLiteControl db = new SQLiteControl(c);
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
                        SQLiteControl db = new SQLiteControl(c);
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
                        SQLiteControl db = new SQLiteControl(c);
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
                SQLiteControl db = new SQLiteControl(c);
                db.limpaCarrinho();
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
        });
        ap.setNegativeButton("Cancelar!", null);
        ale = ap.create();
        ale = ap.show();
    }
    public void runVendas(){
        Intent it = new Intent(c, RecuperarVenda.class);
        startActivity(it);
    }
}
