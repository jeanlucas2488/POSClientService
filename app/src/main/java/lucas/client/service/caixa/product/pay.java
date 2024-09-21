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

                    if(tvRestante.getText().toString().equals("0.00")){
                        DecimalFormatSymbols df = new DecimalFormatSymbols();
                        df.setGroupingSeparator('.');
                        df.setDecimalSeparator('.');
                        DecimalFormat dform = new DecimalFormat("####.##", df);

                        Double v1 = new Double(tvTotal.getText().toString());
                        Double v2 = new Double(dinheiro.getText().toString());

                        double res = v1 - v2;

                        tvRestante.setText(String.valueOf(res));
                        try{
                            DB db = new DB(c);
                            util us = db.getDinheiro(1);

                            if(!us.getMoney().toString().equals("")){
                                Double re1 = new Double(us.getMoney());
                                Double re2 = new Double(dinheiro.getText().toString());

                                double result = re1 + re2;

                                util us2 = new util();
                                us2.setMoneyID(us.getMoneyID());
                                us2.setMoney(dform.format(result));

                                DB db2 = new DB(c);
                                db2.moneyUp(us2);
                            } else {

                            }
                        } catch (Exception e){
                            util us2 = new util();
                            us2.setMoney(dform.format(dinheiro.getText().toString()));

                            DB db2 = new DB(c);
                            db2.moneyIn(us2);

                        }
                    } else {
                        Double v1 = new Double(tvRestante.getText().toString());
                        Double v2 = new Double(dinheiro.getText().toString());
                        double res = v1 - v2;
                        DecimalFormatSymbols df = new DecimalFormatSymbols();
                        df.setGroupingSeparator('.');
                        df.setDecimalSeparator('.');
                        DecimalFormat dform = new DecimalFormat("####.##", df);

                        tvRestante.setText(dform.format(res));
                        try{
                            DB db = new DB(c);
                            util us = db.getDinheiro(1);

                            if(!us.getMoney().toString().equals("")){
                                Double re1 = new Double(us.getMoney());
                                Double re2 = new Double(dinheiro.getText().toString());

                                double result = re1 + re2;

                                util us2 = new util();
                                us2.setMoneyID(us.getMoneyID());
                                us2.setMoney(dform.format(result));

                                DB db2 = new DB(c);
                                db2.moneyUp(us2);
                            } else {

                            }
                        } catch (Exception e){
                            util us2 = new util();
                            us2.setMoney(dform.format(dinheiro.getText().toString()));

                            DB db2 = new DB(c);
                            db2.moneyIn(us2);
                        }

                    }
                    return true;
                }
                return false;
            }
        });


        AlertDialog.Builder bs = new AlertDialog.Builder(c);
        bs.setTitle("Fechar Pedido:");
        bs.setView(r);
        bs.setPositiveButton("  Finalizar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(!tvRestante.getText().toString().equals("")){
                    msg("Compra finalizada com sucesso!");
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
                } else {
                    msg("Existem valores pendentes, finalize o pagamento!");
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
