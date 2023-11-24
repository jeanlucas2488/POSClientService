package lucas.client.service.caixa.adapters;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.util.*;
import lucas.client.service.*;
import lucas.client.service.etc.*;
import android.graphics.*;

 public class gridAd extends ArrayAdapter<util>
{
	Context c;
	//ValueFilter valueFilter;
	List<util> lt;
	List<util> mStringFilterList = new ArrayList<util>();
	public gridAd(Context c2, List<util> lt2){
		super(c2, R.layout.main_ad, lt2);
		lt = lt2;
		mStringFilterList.addAll(lt);
		c = c2;
	}

	@Override
	public int getCount()
	{
		// TODO: Implement this method
		return lt.size();

	}

	@Override
	public util getItem(int position)
	{
		// TODO: Implement this method
		return lt.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		// TODO: Implement this method
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// TODO: Implement this method
		LayoutInflater li = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
		View r = li.inflate(R.layout.adapter_main, parent, false);
		TextView tv = r.findViewById(R.id.tv);
		ImageView im = r.findViewById(R.id.im);
		byte[] res = lt.get(position).getImage();
		Bitmap bt = BitmapFactory.decodeByteArray(res, 0, res.length);
		im.setImageBitmap(bt);
		tv.setText(lt.get(position).getProd1());
		return r;
	}
	public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        lt.clear();
        if (charText.length() == 0) {
            lt.addAll(mStringFilterList);
        } else {
            for (util wp : mStringFilterList) {
                if (wp.getProd1().toLowerCase(Locale.getDefault()).contains(charText)) {
                    lt.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
