package lucas.client.service.caixa.adapters;
import android.content.*;
import android.widget.*;
import java.util.*;
import lucas.client.service.*;
import android.view.*;

import lucas.client.service.etc.*;

public class historyAd extends ArrayAdapter<util>
{
	Context c;
	List<util> lt;
	
	public historyAd(Context c2, List<util> lt2){
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
		im.setImageResource(R.drawable.sale);
		tv.setText(lt.get(position).getProd1());
		
		return r;
	}
	
}
