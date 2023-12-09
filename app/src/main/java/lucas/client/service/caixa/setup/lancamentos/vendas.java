package lucas.client.service.caixa.setup.lancamentos;

import android.os.*;
import lucas.client.service.*;
import android.widget.*;
import android.content.*;

import lucas.client.service.etc.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class vendas extends AppCompatActivity
{
EditText loc, prod, quant, valor, payT, pagto, troco;
Context c = this;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lancamentos_);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		loc = (EditText) findViewById(R.id.pcod);
		prod = (EditText)findViewById(R.id.prod);
		quant = (EditText)findViewById(R.id.quant);
		valor = (EditText)findViewById(R.id.valor);
		payT = (EditText)findViewById(R.id.payT);
		pagto = (EditText)findViewById(R.id.pagto);
		troco = (EditText)findViewById(R.id.troco);
		util us = new util();
		Intent it = getIntent();
		if(it != null){
			Bundle b = it.getExtras();
			if(b != null){
				us.setProId(b.getLong("id"));
				us.setLoc(b.getString("loc"));
				us.setProd1(b.getString("prod"));
				us.setQuant1(b.getString("quant"));
				us.setValor1(b.getString("valor"));
				us.setPay1(b.getString("payType"));
				us.setP1(b.getString("pagto"));
				us.setT1(b.getString("troco"));
			}
		}
		loc.setText(us.getLoc());
		prod.setText(us.getProd1());
		quant.setText(us.getQuant1());
		valor.setText(us.getValor1());
		payT.setText(us.getPay1());
		pagto.setText(us.getP1());
		troco.setText(us.getT1());
	}
	
}
