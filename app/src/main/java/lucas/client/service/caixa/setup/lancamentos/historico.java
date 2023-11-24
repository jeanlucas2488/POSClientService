package lucas.client.service.caixa.setup.lancamentos;
import android.app.*;
import android.os.*;
import lucas.client.service.*;
import android.widget.*;
import lucas.client.service.caixa.adapters.*;
import java.util.*;
import android.widget.AdapterView.*;
import android.view.*;
import lucas.client.service.sqlite.*;
import android.content.*;
import lucas.client.service.etc.*;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class historico extends AppCompatActivity
{

	Context c = this;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history_);
		
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		DB db = new DB(c);
		final List<util> lis;
		lis = db.proFind();
		ListView lt = (ListView) findViewById(R.id.list);
		lt.setAdapter(new historyAd(this, lis));
		lt.setEmptyView(findViewById(android.R.id.empty));
		lt.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					Intent itt = new Intent(c, vendas.class);
					Bundle b = new Bundle();
					b.putLong("id", lis.get(p3).getProId());
					b.putString("loc", lis.get(p3).getLoc());
					b.putString("prod", lis.get(p3).getProd1());
					b.putString("quant", lis.get(p3).getQuant1());
					b.putString("valor", lis.get(p3).getValor1());
					b.putString("payType", lis.get(p3).getPay1());
					b.putString("pagto", lis.get(p3).getP1());
					b.putString("troco", lis.get(p3).getT1());
					itt.putExtras(b);
					startActivity(itt);
				}
		});
		
	}
}
