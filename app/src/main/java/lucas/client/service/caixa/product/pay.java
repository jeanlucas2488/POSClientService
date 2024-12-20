package lucas.client.service.caixa.product;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
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

import lucas.client.service.R;
import lucas.client.service.etc.util;
import lucas.client.service.sqlite.DB;


public class pay extends Activity {
    String result, dinres, tvres;
    AlertDialog root;
    TextView tvDinheiro, tvCarD, tvCarC, tvPix;
    EditText dinheiro,  tvTotal, tvPago, tvRestante, troco,  carD, carC, pix;
    Button canc, fim;
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
        tvPago = r.findViewById(R.id.valPago);
        tvRestante = r.findViewById(R.id.valRestante);
        troco = r.findViewById(R.id.troco);
        tvDinheiro = r.findViewById(R.id.tvDinheiro);
        tvCarD = r.findViewById(R.id.tvCarD);
        tvCarC = r.findViewById(R.id.tvCarC);
        tvPix = r.findViewById(R.id.tvPix);
        canc = r.findViewById(R.id.cancel);
        fim = r.findViewById(R.id.fim);
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
        tvPago.setText("0.00");
        tvRestante.setText("0.00");

        try{
            DB get = new DB(c);
            util src = get.getValPago(1);

            if(src.getValTemp().toString().equals("")){
                tvPago.setText(src.getValTemp());
            } else {

            }
        }catch(Exception e){

        }
        dinLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               dinheiro.setVisibility(View.VISIBLE);
               tvDinheiro.setTextColor(Color.WHITE);

            }
        });
        debLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                carD.setVisibility(View.VISIBLE);
                tvCarD.setTextColor(Color.WHITE);
            }
        });
        credLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                carC.setVisibility(View.VISIBLE);
                tvCarC.setTextColor(Color.WHITE);

            }
        });
        pixLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pix.setVisibility(View.VISIBLE);
                tvPix.setTextColor(Color.WHITE);
            }
        });
        dinres = dinheiro.getText().toString();
        tvres = tvTotal.getText().toString();

        dinheiro.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_NULL) {

                    if(tvRestante.getText().toString().equals("0.00")){

                        Double src1 = new Double(tvTotal.getText().toString());
                        Double src2 = new Double(dinheiro.getText().toString());

                        double result = src2 - src1;

                        DecimalFormatSymbols df = new DecimalFormatSymbols();
                        df.setDecimalSeparator('.');
                        DecimalFormat dform = new DecimalFormat("###0.00", df);

                        if(src2 > src1){
                            troco.setText(dform.format(result));
                        } else {
                            tvRestante.setText(dform.format(result));
                        }

                        try{

                            DB db = new DB(c);
                            util root = db.getValPago(1);

                            if(root.getValTemp().toString().equals("")){
                                Double val1 = new Double(root.getValTemp());
                                Double val2 = new Double(dinheiro.getText().toString());
                                Double val3 = new Double(tvTotal.getText().toString());

                                double result1 = val1 + val3;

                                double result2 = val1 + val2;

                                if(val2 > val3){
                                    util post = new util();
                                    post.setValTempId(root.getValTempId());
                                    post.setValTemp(dform.format(result1));

                                    DB pull = new DB(c);
                                    pull.upValPago(post);
                                } else {
                                    util post2 = new util();
                                    post2.setValTempId(root.getValTempId());
                                    post2.setValTemp(dform.format(result2));

                                    DB pull2 = new DB(c);
                                    pull2.upValPago(post2);
                                }
                            } else{

                            }
                        } catch(Exception e) {
                            // while is a new pull

                            Double val1 = new Double(dinheiro.getText().toString());
                            Double val2 = new Double(tvTotal.getText().toString());

                            if (val1 > val2) {
                                util post = new util();

                                post.setValTemp(tvTotal.getText().toString());

                                DB pull = new DB(c);
                                pull.setValPago(post);
                            } else {
                                util post2 = new util();
                                post2.setValTemp(dinheiro.getText().toString());

                                DB pull2 = new DB(c);
                                pull2.setValPago(post2);
                            }
                        }
                    } else {
// if tvRest is not a null

                            Double src1 = new Double(tvRestante.getText().toString());
                            Double src2 = new Double(dinheiro.getText().toString());

                            double result = src1 - src2;

                            DecimalFormatSymbols df = new DecimalFormatSymbols();
                            df.setDecimalSeparator('.');
                            DecimalFormat dform = new DecimalFormat("###0.00", df);

                            if(src2 > src1){
                                troco.setText(dform.format(result));
                            } else {
                                tvRestante.setText(dform.format(result));
                            }

                            try{

                                DB db = new DB(c);
                                util root = db.getValPago(1);

                                if(root.getValTemp().toString().equals("")){
                                    Double val1 = new Double(root.getValTemp());
                                    Double val2 = new Double(dinheiro.getText().toString());
                                    Double val3 = new Double(tvRestante.getText().toString());

                                    double result1 = val1 + val3;

                                    double result2 = val1 + val2;

                                    if(val2 > val3){
                                        util post = new util();
                                        post.setValTempId(root.getValTempId());
                                        post.setValTemp(dform.format(result1));

                                        DB pull = new DB(c);
                                        pull.upValPago(post);
                                    } else {
                                        util post2 = new util();
                                        post2.setValTempId(root.getValTempId());
                                        post2.setValTemp(dform.format(result2));

                                        DB pull2 = new DB(c);
                                        pull2.upValPago(post2);
                                    }
                                } else{

                                }
                            } catch(Exception e) {
                                // while is a new pull

                                Double val1 = new Double(dinheiro.getText().toString());
                                Double val2 = new Double(tvRestante.getText().toString());

                                if (val1 > val2) {
                                    util post = new util();

                                    post.setValTemp(tvRestante.getText().toString());

                                    DB pull = new DB(c);
                                    pull.setValPago(post);
                                } else {
                                    util post2 = new util();
                                    post2.setValTemp(dinheiro.getText().toString());

                                    DB pull2 = new DB(c);
                                    pull2.setValPago(post2);
                                }
                            }

                    }
                    return false;
                }
                return true;
            }
        });
        carD.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_NULL) {

                    if(tvRestante.getText().toString().equals("0.00")){

                        Double v1 = new Double(tvTotal.getText().toString());
                        Double v2 = new Double(carD.getText().toString());

                        double res = v1 - v2;

                        DecimalFormatSymbols df = new DecimalFormatSymbols();
                        df.setDecimalSeparator('.');
                        df.setGroupingSeparator('.');

                        DecimalFormat dform = new DecimalFormat("###0.00", df);

                        tvRestante.setText(dform.format(res));

                        try {

                            DB db = new DB(c);
                            util root = db.getCarD(1);

                            if(!root.getCarD().toString().equals("")){
                                Double r1 = new Double(root.getCarD());
                                Double r2 = new Double(carD.getText().toString());

                                double result = r1 + r2;

                                util us = new util();
                                us.setCarD_ID(root.getCarD_ID());
                                us.setCarD(dform.format(result));
                                db.carDUp(us);

                            } else {

                            }
                        } catch (Exception e){
                            util us = new util();
                            us.setCarD(carD.getText().toString());
                            DB db = new DB(c);
                            db.carDIn(us);
                        }
                    } else {
                        Double v1 = new Double(tvRestante.getText().toString());
                        Double v2 = new Double(dinheiro.getText().toString());

                        double res = v1 - v2;

                        DecimalFormatSymbols df = new DecimalFormatSymbols();
                        df.setDecimalSeparator('.');
                        df.setGroupingSeparator('.');

                        DecimalFormat dform = new DecimalFormat("###0.00", df);

                        tvRestante.setText(dform.format(res));

                        try {

                            DB db = new DB(c);
                            util root = db.getDinheiro(1);

                            if(!root.getCarD().toString().equals("")){
                                Double r1 = new Double(root.getCarD());
                                Double r2 = new Double(carD.getText().toString());

                                double result = r1 + r2;

                                util us = new util();
                                us.setCarD_ID(root.getCarD_ID());
                                us.setCarD(dform.format(result));
                                db.carDUp(us);

                            } else {

                            }
                        } catch (Exception e){
                            util us = new util();
                            us.setCarD(carD.getText().toString());
                            DB db = new DB(c);
                            db.carDIn(us);
                        }
                    }
                    return false;
                }
                return true;
            }
        });
        canc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.dismiss();
                DB db = new DB(c);
            }
        });
        fim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    if(tvRestante.getText().toString().equals("0.00")){

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
                        DB db = new DB(c);
                        db.limpaCarrinho();
                    } else {
                        msg("Existem valores pendentes!");
                    }

            }
        });
        AlertDialog.Builder bs = new AlertDialog.Builder(c);

        bs.setView(r);

       root = bs.create();
       root = bs.show();
    }
    public void msg(String ms){
        Toast.makeText(c, ms, Toast.LENGTH_SHORT).show();
    }
}
