package lucas.client.service.Fragments.adapter;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.io.*;
import java.nio.channels.*;
import java.util.*;
import lucas.client.service.*;
import lucas.client.service.caixa.*;
import lucas.client.service.etc.*;
import lucas.client.service.sqlite.*;

public class productAdapter extends ArrayAdapter<util>
{
	Context c;
	List<util> lt;
	public productAdapter(Context c2, List<util> lt2){
		super(c2, R.layout.product_list, lt2);
		this.lt = lt2;
		this.c = c2;
	}
	public List<util> getData(){
		return lt;
	}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent)
	{
		// TODO: Implement this method
		LayoutInflater li = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
		View r = li.inflate(R.layout.product_list, parent, false);
		TextView tv = r.findViewById(R.id.tv);
		TextView tvQ = r.findViewById(R.id.tvQuant);
		ImageView im = r.findViewById(R.id.im);
		ImageView cancel = r.findViewById(R.id.cancel);
		cancel.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					
					DB db = new DB(c);
					db.delItem(lt.get(position).getIdP2());
					lt.clear();
					lt.addAll(db.carrinho());
					notifyDataSetChanged();
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

							String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db";
							String backupDBPath2  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db-shm";
							String backupDBPath3  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db-wal";

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
				}
			}); 
		tv.setText(lt.get(position).getProd2());
		tvQ.setText(lt.get(position).getQuant2());
		byte[] res = lt.get(position).getImage2();
		Bitmap bt = BitmapFactory.decodeByteArray(res, 0, res.length);
		im.setImageBitmap(bt);
		return r;
	}

}
