package lucas.client.service.caixa.product;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import java.util.List;

import lucas.client.service.R;
import lucas.client.service.etc.util;
import lucas.client.service.sqlite.DB;


public class pay extends Activity {
    String result, dinres, tvres;
    AlertDialog root;
    TextView tvDinheiro, tvCarD, tvCarC, tvPix;
    EditText dinheiro,  tvTotal, tvRestante,  carD, carC, pix;
    RelativeLayout dinLayout, debLayout, credLayout, pixLayout;

    Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent it = getIntent();
        Bundle b = it.getExtras();
        result = b.getString("valor");

        LayoutInflater li = getLayoutInflater();
        View r = li.inflate(R.layout.fecha_pedido, null);
        tvTotal = r.findViewById(R.id.valTotal);
        tvRestante = r.findViewById(R.id.valRestante);
        tvDinheiro = r.findViewById(R.id.tvDinheiro);
        tvCarD = r.findViewById(R.id.tvCarD);
        tvCarC = r.findViewById(R.id.tvCarC);
        tvPix = r.findViewById(R.id.tvPix);

        dinheiro = r.findViewById(R.id.money);
        carD = r.findViewById(R.id.carD);
        carC = r.findViewById(R.id.carC);
        pix = r.findViewById(R.id.pix);

        dinLayout = r.findViewById(R.id.dinLayout);
        debLayout = r.findViewById(R.id.debLayout);
        credLayout = r.findViewById(R.id.credLayout);
        pixLayout = r.findViewById(R.id.pixLayout);

        dinheiro.setVisibility(View.GONE);
        carD.setVisibility(View.GONE);
        carC.setVisibility(View.GONE);
        pix.setVisibility(View.GONE);

        tvTotal.setText(result.toString());
        tvRestante.setText("0.00");

        dinLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dinLayout.setBackgroundColor(Color.parseColor("#495550"));
               dinheiro.setVisibility(View.VISIBLE);
               tvDinheiro.setTextColor(Color.WHITE);

            }
        });
        debLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                debLayout.setBackgroundColor(Color.parseColor("#495550"));
                carD.setVisibility(View.VISIBLE);
                tvCarD.setTextColor(Color.WHITE);
            }
        });
        credLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credLayout.setBackgroundColor(Color.parseColor("#495550"));
                carC.setVisibility(View.VISIBLE);
                tvCarC.setTextColor(Color.WHITE);

            }
        });
        pixLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pixLayout.setBackgroundColor(Color.parseColor("#495550"));
                pix.setVisibility(View.VISIBLE);
                tvPix.setTextColor(Color.WHITE);
            }
        });
        dinres = dinheiro.getText().toString();
        tvres = tvTotal.getText().toString();

        dinheiro.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_NULL){

                    try {
                        DB db = new DB(c);
                        util us = db.getValTemp(1);

                        if (!us.getValTemp().toString().equals("")){
                            Double v1 = new Double(us.getValTemp());
                            Double v2 = new Double(dinheiro.getText().toString());

                            double res = v1 - v2;

                            DecimalFormatSymbols df = new DecimalFormatSymbols();
                            df.setDecimalSeparator('.');
                            df.setGroupingSeparator('.');

                            DecimalFormat dform = new DecimalFormat("###0.00", df);

                            tvRestante.setText(dform.format(res));

                            util us2 = new util();
                            us2.setValTempId(us.getValTempId());
                            us2.setValTemp(dform.format(res));

                            DB db2 = new DB(c);
                            db2.upValTemp(us2);

                            try {
                                DB db3 = new DB(c);
                                util root = db3.getDinheiro(1);

                                if(!root.getMoney().toString().equals("")){
                                    Double r1 = new Double(root.getMoney());
                                    Double r2 = new Double(dinheiro.getText().toString());

                                    double result = r1 + r2;

                                    util post = new util();
                                    post.setMoneyID(root.getMoneyID());
                                    post.setMoney(dform.format(result));
                                    DB dbpost = new DB(c);
                                    dbpost.moneyUp(post);
                                } else {

                                }
                            } catch (Exception e){
                                util post = new util();
                                post.setMoney(dform.format(result));
                                DB dbpost = new DB(c);
                                dbpost.moneyIn(post);
                            }
                        } else {

                        }
                    } catch (Exception e){

                        Double val1 = new Double(tvTotal.getText().toString());
                        Double val2 = new Double(dinheiro.getText().toString());

                        double res = val1 - val2;

                        DecimalFormatSymbols df = new DecimalFormatSymbols();
                        df.setGroupingSeparator('.');
                        df.setDecimalSeparator('.');

                        DecimalFormat dform = new DecimalFormat("###0.00", df);

                        tvRestante.setText(dform.format(res));

                        util us = new util();
                        us.setValTemp(dform.format(res));
                        DB d1 = new DB(c);
                        d1.setValTemp(us);

                        try {
                            DB db = new DB(c);
                            util root = db.getDinheiro(1);

                            if(!root.getMoney().toString().equals("")){
                                Double r1 = new Double(root.getMoney());
                                Double r2 = new Double(dinheiro.getText().toString());

                                double result = r1 + r2;

                                util post = new util();
                                post.setMoneyID(root.getMoneyID());
                                post.setMoney(dform.format(result));
                                DB dbpost2 = new DB(c);
                                dbpost2.moneyUp(post);
                            } else {

                            }
                        } catch (Exception e2){
                            util post = new util();
                            post.setMoney(dinheiro.getText().toString());
                            DB dbpost2 = new DB(c);
                            dbpost2.moneyIn(post);
                        }
                    }
                    return false;
                }
                return true;
            }
        });


        AlertDialog.Builder bs = new AlertDialog.Builder(c);
        bs.setTitle("Fechar Pedido:");
        bs.setView(r);
        bs.setPositiveButton("  Finalizar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                try {
                    DB get = new DB(c);
                    util root = get.getValTemp(1);

                    if(root.getValTemp().toString().equals("0.00")){
                        get.delValTemp();
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

                                String backupDBPath  = "pdvMain/.sqlite/myDB.db";
                                String backupDBPath2  = "pdvMain/.sqlite/myDB.db-shm";
                                String backupDBPath3  = "pdvMain/.sqlite/myDB.db-wal";

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
                        msg("Compra finalizada com sucesso!");
                    } else {
                        msg("Existem valores pendentes!");
                    }
                } catch (Exception e){

                }
            }
        });
        bs.setNegativeButton("Cancelar", null);

       root = bs.create();
       root = bs.show();
    }
    public void msg(String ms){
        Toast.makeText(c, ms, Toast.LENGTH_SHORT).show();
    }
}
