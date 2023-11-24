package lucas.client.service.caixa.adapters;
import android.widget.*;
import android.view.*;
import android.content.*;
import lucas.client.service.*;

public class mainAd extends ArrayAdapter<String>
{
	Context c;
	String[] lt;
	
	public mainAd(Context c2, String[] lt2){
		super(c2, R.layout.main_ad, lt2);
		this.c = c2;
		this.lt = lt2;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// TODO: Implement this method
		LayoutInflater li = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
		View r = li.inflate(R.layout.main_ad, parent, false);
		ImageView im = r.findViewById(R.id.im);
		TextView tv = r.findViewById(R.id.tv);
		tv.setText(lt[position]);
		if(lt[position].startsWith("H")){
			im.setImageResource(R.drawable.sales);
		}
		if(lt[position].startsWith("C")){
			im.setImageResource(R.drawable.estoque);
		}
		if(lt[position].startsWith("Suprimento")){
			im.setImageResource(R.drawable.sup);
		}
		if(lt[position].startsWith("Sangria")){
			im.setImageResource(R.drawable.sangria);
		}
		if(lt[position].startsWith("F")){
			
			im.setImageResource(R.drawable.fecha);
		}
		return r;
	}
	
}
