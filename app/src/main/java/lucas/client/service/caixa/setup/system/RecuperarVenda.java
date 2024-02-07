package lucas.client.service.caixa.setup.system;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import lucas.client.service.R;
import lucas.client.service.caixa.caixaMain;
import lucas.client.service.etc.util;
import lucas.client.service.sqlite.DB;


public class RecuperarVenda extends Activity {
    Context c = this;
    AlertDialog root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater li = getLayoutInflater();
        View r = li.inflate(R.layout.recuperar_vendas_layout, null);
        final Button canc = r.findViewById(R.id.canc);
        final Button rec = r.findViewById(R.id.rec);
        final LinearLayout l1 = r.findViewById(R.id.l1);
        final LinearLayout l2 = r.findViewById(R.id.l2);
        final LinearLayout l3 = r.findViewById(R.id.l3);
        final LinearLayout l4 = r.findViewById(R.id.l4);

        final RadioButton ch1 = r.findViewById(R.id.ch1);
        final TextView tvProd = r.findViewById(R.id.tvProd);
        final TextView tvData = r.findViewById(R.id.tvData);
        final TextView tvValor = r.findViewById(R.id.tvValor);

        final RadioButton ch2 = r.findViewById(R.id.ch2);
        final TextView tvProd2 = r.findViewById(R.id.tvProd2);
        final TextView tvData2 = r.findViewById(R.id.tvData2);
        final TextView tvValor2 = r.findViewById(R.id.tvValor2);

        final RadioButton ch3 = r.findViewById(R.id.ch3);
        final TextView tvProd3 = r.findViewById(R.id.tvProd3);
        final TextView tvData3 = r.findViewById(R.id.tvData3);
        final TextView tvValor3 = r.findViewById(R.id.tvValor3);

        final RadioButton ch4 = r.findViewById(R.id.ch4);
        final TextView tvProd4 = r.findViewById(R.id.tvProd4);
        final TextView tvData4 = r.findViewById(R.id.tvData4);
        final TextView tvValor4 = r.findViewById(R.id.tvValor4);

        try{
            DB db = new DB(c);
            util us = db.getVenda(1);
            if(!us.getData().toString().equals("")){
                l1.setVisibility(View.VISIBLE);
                tvData.setText(us.getData());
                tvProd.setText(us.getProd1());
                tvValor.setText("R$ " + us.getValor1());

            } else {
            }
        }catch (Exception e){
            l1.setVisibility(View.GONE);
        }
        try{
            DB db = new DB(c);
            util us = db.getVenda(2);
            if(!us.getData().toString().equals("")){
                l2.setVisibility(View.VISIBLE);
                tvData2.setText(us.getData());
                tvProd2.setText(us.getProd1());
                tvValor2.setText("R$ " + us.getValor1());

            } else {
            }
        }catch (Exception e){
            l2.setVisibility(View.GONE);
        }
        try{
            DB db = new DB(c);
            util us = db.getVenda(3);
            if(!us.getData().toString().equals("")){
                l3.setVisibility(View.VISIBLE);
                tvData3.setText(us.getData());
                tvProd3.setText(us.getProd1());
                tvValor3.setText("R$ " + us.getValor1());

            } else {
            }
        }catch (Exception e){
            l3.setVisibility(View.GONE);
        }
        try{
            DB db = new DB(c);
            util us = db.getVenda(4);
            if(!us.getData().toString().equals("")){
                l4.setVisibility(View.VISIBLE);
                tvData4.setText(us.getData());
                tvProd4.setText(us.getProd1());
                tvValor4.setText("R$ " + us.getValor1());

            } else {
            }
        }catch (Exception e){
            l4.setVisibility(View.GONE);
        }
        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ch1.isChecked()){
                    if(ch2.isChecked()){
                        ch2.clearComposingText();
                    }
                    LayoutInflater li = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
                    View r = li.inflate(R.layout.supervisor_view, null);
                    TextInputEditText sup = r.findViewById(R.id.supervisor);
                    AlertDialog.Builder b = new AlertDialog.Builder(c);
                    b.setTitle("Recuperar Venda:");
                    b.setView(r);
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DB db2 = new DB(c);
                            util us2 = db2.getSuperVisor(1);
                            if(!sup.getText().toString().equals("")){
                                if(sup.getText().toString().equals(us2.getSenhaSuperVisor())){
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaA(1);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaA(2);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaA(3);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaA(4);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaA(5);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaA(6);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaA(7);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaA(8);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaA(9);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaA(10);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaA(11);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){
                                    }
                                    DB db = new DB(c);
                                    db.delVenda(1);
                                    db.limpaVendasA();
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
                                    Intent it = new Intent(c, caixaMain.class);
                                    Bundle bun = new Bundle();
                                    String key = "1";
                                    bun.putString("chave", key);
                                    it.putExtras(bun);
                                    startActivity(it);
                                } else {
                                    Toast.makeText(c, "Senha Incorreta!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(c, "Insira a senha do Supervisor!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    b.setNegativeButton("Cancelar", null);
                    b.setCancelable(false);
                    b.create();
                    b.show();
                }
                if(ch2.isChecked()){
                    LayoutInflater li = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
                    View r = li.inflate(R.layout.supervisor_view, null);
                    TextInputEditText sup = r.findViewById(R.id.supervisor);
                    AlertDialog.Builder b = new AlertDialog.Builder(c);
                    b.setTitle("Recuperar Venda:");
                    b.setView(r);
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DB db2 = new DB(c);
                            util us2 = db2.getSuperVisor(1);
                            if(!sup.getText().toString().equals("")){
                                if(sup.getText().toString().equals(us2.getSenhaSuperVisor())){
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaB(1);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaB(2);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaB(3);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaB(4);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaB(5);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaB(6);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaB(7);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaB(8);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaB(9);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaB(10);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaB(11);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){
                                    }
                                    DB db = new DB(c);
                                    db.delVenda(1);
                                    db.limpaVendasA();
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
                                    Intent it = new Intent(c, caixaMain.class);
                                    Bundle bun = new Bundle();
                                    String key = "1";
                                    bun.putString("chave", key);
                                    it.putExtras(bun);
                                    startActivity(it);
                                } else {
                                    Toast.makeText(c, "Senha Incorreta!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(c, "Insira a senha do Supervisor!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    b.setNegativeButton("Cancelar", null);
                    b.setCancelable(false);
                    b.create();
                    b.show();
                }
                if(ch3.isChecked()){
                    LayoutInflater li = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
                    View r = li.inflate(R.layout.supervisor_view, null);
                    TextInputEditText sup = r.findViewById(R.id.supervisor);
                    AlertDialog.Builder b = new AlertDialog.Builder(c);
                    b.setTitle("Recuperar Venda:");
                    b.setView(r);
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DB db2 = new DB(c);
                            util us2 = db2.getSuperVisor(1);
                            if(!sup.getText().toString().equals("")){
                                if(sup.getText().toString().equals(us2.getSenhaSuperVisor())){
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaC(1);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaC(2);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaC(3);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaC(4);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaC(5);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaC(6);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaC(7);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaC(8);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaC(9);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaC(10);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaC(11);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){
                                    }
                                    DB db = new DB(c);
                                    db.delVenda(1);
                                    db.limpaVendasA();
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
                                    Intent it = new Intent(c, caixaMain.class);
                                    Bundle bun = new Bundle();
                                    String key = "1";
                                    bun.putString("chave", key);
                                    it.putExtras(bun);
                                    startActivity(it);
                                } else {
                                    Toast.makeText(c, "Senha Incorreta!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(c, "Insira a senha do Supervisor!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    b.setNegativeButton("Cancelar", null);
                    b.setCancelable(false);
                    b.create();
                    b.show();
                }
                if(ch4.isChecked()){
                    LayoutInflater li = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
                    View r = li.inflate(R.layout.supervisor_view, null);
                    TextInputEditText sup = r.findViewById(R.id.supervisor);
                    AlertDialog.Builder b = new AlertDialog.Builder(c);
                    b.setTitle("Recuperar Venda:");
                    b.setView(r);
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DB db2 = new DB(c);
                            util us2 = db2.getSuperVisor(1);
                            if(!sup.getText().toString().equals("")){
                                if(sup.getText().toString().equals(us2.getSenhaSuperVisor())){
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaD(1);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaD(2);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaD(3);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaD(4);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaD(5);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaD(6);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaD(7);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaD(8);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaD(9);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaD(10);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){

                                    }
                                    try{
                                        DB db = new DB(c);
                                        util us = db.getVendaD(11);
                                        if(!us.getProd1().toString().equals("")){
                                            util post = new util();
                                            post.setProd2(us.getProd1());
                                            post.setQuant2(us.getQuant1());
                                            post.setValor2(us.getValor1());
                                            post.setImage2(us.getImage());
                                            db.carIn(post);
                                        } else {
                                        }
                                    }catch (Exception e){
                                    }
                                    DB db = new DB(c);
                                    db.delVenda(1);
                                    db.limpaVendasA();
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
                                    Intent it = new Intent(c, caixaMain.class);
                                    Bundle bun = new Bundle();
                                    String key = "1";
                                    bun.putString("chave", key);
                                    it.putExtras(bun);
                                    startActivity(it);
                                } else {
                                    Toast.makeText(c, "Senha Incorreta!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(c, "Insira a senha do Supervisor!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    b.setNegativeButton("Cancelar", null);
                    b.setCancelable(false);
                    b.create();
                    b.show();
                }
            }
        });
        canc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root.dismiss();
            }
        });
        AlertDialog.Builder al = new AlertDialog.Builder(c);
        al.setTitle("Recuperar Venda:");
        al.setView(r);

         root = al.create();
         root = al.show();
    }
}
