package lucas.client.service.caixa.product;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import lucas.client.service.R;


public class pay extends Activity {
    TextView tvTotal, tvRestante, tvDinheiro, tvCarD, tvCarC, tvPix;
    EditText dinheiro, carD, carC, pix;
    RelativeLayout dinLayout, debLayout, credLayout, pixLayout;

    Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        dinheiro.setEnabled(false);
        carD.setEnabled(false);
        carC.setEnabled(false);
        pix.setEnabled(false);

        dinLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dinLayout.setBackgroundColor(Color.parseColor("#0000ff"));
               dinheiro.setEnabled(true);
               tvDinheiro.setTextColor(Color.WHITE);
            }
        });
        debLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                debLayout.setBackgroundColor(Color.parseColor("#0000ff"));
                carD.setEnabled(true);
                tvCarD.setTextColor(Color.WHITE);
            }
        });
        credLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credLayout.setBackgroundColor(Color.parseColor("#0000ff"));
                carC.setEnabled(true);
                tvCarC.setTextColor(Color.WHITE);
            }
        });
        pixLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pixLayout.setBackgroundColor(Color.parseColor("#0000ff"));
                pix.setEnabled(true);
                tvPix.setTextColor(Color.WHITE);
            }
        });

        AlertDialog.Builder bs = new AlertDialog.Builder(c);
        bs.setTitle("Fechar Pedido:");
        bs.setView(r);
        bs.setPositiveButton("Finalizar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(!dinheiro.getText().toString().equals("")){

                } else {
                    if(!carD.getText().toString().equals("")){

                    } else {
                        if(!carC.getText().toString().equals("")){

                        } else {
                            if(!pix.getText().toString().equals("")){

                            } else {

                            }
                        }
                    }
                }
            }
        });
        bs.setNegativeButton("Cancelar", null);
        bs.setNeutralButton("+1 Tipo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        bs.create();
        bs.show();
    }
}
