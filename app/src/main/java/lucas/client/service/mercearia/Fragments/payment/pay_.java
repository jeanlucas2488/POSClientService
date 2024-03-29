package lucas.client.service.mercearia.Fragments.payment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import lucas.client.service.R;
import lucas.client.service.etc.util;
import lucas.client.service.mercearia.databases.*;


public class pay_ extends Activity {
    String result;
    AlertDialog root;
    TextView tvTotal, tvRestante, tvDinheiro, tvCarD, tvCarC, tvPix;
    EditText dinheiro, carD, carC, pix;
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
        tvRestante.setText(result.toString());

        dinLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dinLayout.setBackgroundColor(Color.parseColor("#0000ff"));
                dinheiro.setVisibility(View.VISIBLE);
                tvDinheiro.setTextColor(Color.WHITE);

            }
        });
        debLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                debLayout.setBackgroundColor(Color.parseColor("#0000ff"));
                carD.setVisibility(View.VISIBLE);
                tvCarD.setTextColor(Color.WHITE);

            }
        });
        credLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credLayout.setBackgroundColor(Color.parseColor("#0000ff"));
                carC.setVisibility(View.VISIBLE);
                tvCarC.setTextColor(Color.WHITE);

            }
        });
        pixLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pixLayout.setBackgroundColor(Color.parseColor("#0000ff"));
                pix.setVisibility(View.VISIBLE);
                tvPix.setTextColor(Color.BLACK);
            }
        });

        dinheiro.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Double v1 = new Double(tvRestante.getText().toString());
                    Double v2 = new Double(dinheiro.getText().toString());

                    double res = v2 - v1;

                    DecimalFormatSymbols df = new DecimalFormatSymbols();
                    df.setGroupingSeparator('.');
                    df.setDecimalSeparator('.');
                    DecimalFormat dform = new DecimalFormat("####.##", df);

                    tvRestante.setText(dform.format(res));
                    return true;
                }
                return false;
            }
        });
        carD.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Double v1 = new Double(tvRestante.getText().toString());
                    Double v2 = new Double(carD.getText().toString());

                    double res = v2 - v1;

                    DecimalFormatSymbols df = new DecimalFormatSymbols();
                    df.setGroupingSeparator('.');
                    df.setDecimalSeparator('.');
                    DecimalFormat dform = new DecimalFormat("####.##", df);

                    tvRestante.setText(dform.format(res));
                    return true;
                }
                return false;
            }
        });
        carC.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Double v1 = new Double(tvRestante.getText().toString());
                    Double v2 = new Double(carC.getText().toString());

                    double res = v2 - v1;

                    DecimalFormatSymbols df = new DecimalFormatSymbols();
                    df.setGroupingSeparator('.');
                    df.setDecimalSeparator('.');
                    DecimalFormat dform = new DecimalFormat("####.##", df);

                    tvRestante.setText(dform.format(res));
                    return true;
                }
                return false;
            }
        });
        pix.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Double v1 = new Double(tvRestante.getText().toString());
                    Double v2 = new Double(pix.getText().toString());

                    double res = v2 - v1;

                    DecimalFormatSymbols df = new DecimalFormatSymbols();
                    df.setGroupingSeparator('.');
                    df.setDecimalSeparator('.');
                    DecimalFormat dform = new DecimalFormat("####.##", df);

                    tvRestante.setText(dform.format(res));
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

                if(!tvRestante.getText().toString().equals("00.00")){
                    Toast.makeText(c, "Há valores pendentes para finalinar a compra.", Toast.LENGTH_LONG).show();
                } else {
                    if(!dinheiro.getText().toString().equals("")){
                        try{
                            SQLiteControl db  = new SQLiteControl(c);
                            List<util> rd;
                            rd = db.moFind();
                            if(!rd.get(0).getMoney().equals("")){
                                String re1 = rd.get(0).getMoney();
                                String re2 = dinheiro.getText().toString();
                                Double d0 = new Double(re1);
                                Double d1 = new Double(re2);
                                double res = d0 + d1;
                                DecimalFormatSymbols df = new DecimalFormatSymbols();
                                df.setGroupingSeparator('.');
                                df.setDecimalSeparator('.');
                                DecimalFormat dform = new DecimalFormat("####.##", df);
                                util us = new util();
                                us.setMoney(dform.format(res));
                                db.delMoney();
                                db.moneyIn(us);

                            } else {}
                        }catch(Exception e){
                            util us = new util();
                            us.setMoney(dinheiro.getText().toString());
                            SQLiteControl d1 = new SQLiteControl(c);
                            d1.moneyIn(us);

                        }
                    } else {
                        if(!carD.getText().toString().equals("")){
                            try{
                                SQLiteControl db  = new SQLiteControl(c);
                                List<util> rd;
                                rd = db.getCarD();
                                if(!rd.get(0).getCarD().equals("")){
                                    String re1 = rd.get(0).getCarD();
                                    String re2 = carD.getText().toString();
                                    Double d0 = new Double(re1);
                                    Double d1 = new Double(re2);
                                    double res = d0 + d1;
                                    DecimalFormatSymbols df = new DecimalFormatSymbols();
                                    df.setGroupingSeparator('.');
                                    df.setDecimalSeparator('.');
                                    DecimalFormat dform = new DecimalFormat("####.##", df);
                                    util us = new util();
                                    us.setCarD(dform.format(res));
                                    db.delCarD();
                                    db.carDIn(us);

                                } else {}
                            }catch(Exception e){
                                util us = new util();
                                us.setCarD(carD.getText().toString());
                                SQLiteControl d1 = new SQLiteControl(c);
                                d1.carDIn(us);

                            }
                        } else {
                            if(!carC.getText().toString().equals("")){
                                try{
                                    SQLiteControl db  = new SQLiteControl(c);
                                    List<util> rd;
                                    rd = db.getCarC();
                                    if(!rd.get(0).getCarC().equals("")){
                                        String re1 = rd.get(0).getCarC();
                                        String re2 = carC.getText().toString();
                                        Double d0 = new Double(re1);
                                        Double d1 = new Double(re2);
                                        double res = d0 + d1;
                                        DecimalFormatSymbols df = new DecimalFormatSymbols();
                                        df.setGroupingSeparator('.');
                                        df.setDecimalSeparator('.');
                                        DecimalFormat dform = new DecimalFormat("####.##", df);
                                        util us = new util();
                                        us.setCarC(dform.format(res));
                                        db.delCarC();
                                        db.carCIn(us);

                                    } else {}
                                }catch(Exception e){
                                    util us = new util();
                                    us.setCarC(carC.getText().toString());
                                    SQLiteControl d1 = new SQLiteControl(c);
                                    d1.carCIn(us);
                                }
                            } else {
                                if(!pix.getText().toString().equals("")){
                                    try{
                                        SQLiteControl db  = new SQLiteControl(c);
                                        List<util> rd;
                                        rd = db.getPix();
                                        if(!rd.get(0).getPix().equals("")){
                                            String re1 = rd.get(0).getPix();
                                            String re2 = pix.getText().toString();
                                            Double d0 = new Double(re1);
                                            Double d1 = new Double(re2);
                                            double res = d0 + d1;
                                            DecimalFormatSymbols df = new DecimalFormatSymbols();
                                            df.setGroupingSeparator('.');
                                            df.setDecimalSeparator('.');
                                            DecimalFormat dform = new DecimalFormat("####.##", df);
                                            util us = new util();
                                            us.setPix(dform.format(res));
                                            db.delPix();
                                            db.PixIn(us);

                                        } else {}
                                    }catch(Exception e){
                                        util us = new util();
                                        us.setPix(pix.getText().toString());
                                        SQLiteControl d1 = new SQLiteControl(c);
                                        d1.PixIn(us);
                                    }
                                } else {

                                }
                            }
                        }
                    }
                }
            }
        });
        bs.setNegativeButton("Cancelar", null);

        root = bs.create();
        root = bs.show();
    }
}
