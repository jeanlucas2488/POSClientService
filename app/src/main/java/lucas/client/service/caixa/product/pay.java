package lucas.client.service.caixa.product;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import lucas.client.service.R;


public class pay extends Activity {
    TextView tvTotal, tvRestante;
    EditText dinheiro, carD, carC, pix;
    Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater li = getLayoutInflater();
        View r = li.inflate(R.layout.fecha_pedido, null);
        tvTotal = r.findViewById(R.id.valTotal);
        tvRestante = r.findViewById(R.id.valRestante);
        dinheiro = r.findViewById(R.id.money);
        carD = r.findViewById(R.id.carD);
        carC = r.findViewById(R.id.carC);
        pix = r.findViewById(R.id.pix);


    }
}
