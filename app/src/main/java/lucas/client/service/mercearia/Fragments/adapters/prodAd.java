package lucas.client.service.mercearia.Fragments.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.List;

import lucas.client.service.R;
import lucas.client.service.etc.util;
import lucas.client.service.mercearia.databases.SQLiteControl;
import lucas.client.service.sqlite.DB;

public class prodAd extends ArrayAdapter<util> {
    Context c;
    List<util> lt;

    public prodAd(Context c2, List<util> lt2) {
        super(c2, R.layout.product_list, lt2);
        this.lt = lt2;
        this.c = c2;
    }

    public List<util> getData() {
        return lt;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO: Implement this method
        LayoutInflater li = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
        View r = li.inflate(R.layout.product_list, parent, false);
        TextView tv = r.findViewById(R.id.tv);
        TextView tvQ = r.findViewById(R.id.tvQuant);
        ImageView im = r.findViewById(R.id.im);
        ImageView cancel = r.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View p1) {
                LayoutInflater li = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
                View r = li.inflate(R.layout.supervisor_view, null);
                TextInputEditText sup = r.findViewById(R.id.supervisor);
                AlertDialog.Builder b = new AlertDialog.Builder(c);
                b.setTitle("Cancelar Item:");
                b.setView(r);
                b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DB db = new DB(c);
                        util us = db.getSuperVisor(1);
                        if (!sup.getText().toString().equals("")) {
                            if (sup.getText().toString().equals(us.getSenhaSuperVisor())) {
                                SQLiteControl d = new SQLiteControl(c);
                                d.delItem(lt.get(position).getIdP2());
                                lt.clear();
                                lt.addAll(d.carrinho());
                                notifyDataSetChanged();
                                try {
                                    File sd = Environment.getExternalStorageDirectory();
                                    File data = Environment.getDataDirectory();

                                    if (sd.canWrite()) {
                                        String currentDBPath = "//data//" + c.getOpPackageName()
                                                + "//databases//" + "MCRDB.db";
                                        String currentDBPath2 = "//data//" + c.getOpPackageName()
                                                + "//databases//" + "MCRDB.db-shm";
                                        String currentDBPath3 = "//data//" + c.getOpPackageName()
                                                + "//databases//" + "MCRDB.db-wal";

                                        String backupDBPath = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db";
                                        String backupDBPath2 = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-shm";
                                        String backupDBPath3 = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-wal";

                                        File currentDB = new File(data, currentDBPath);
                                        File currentDB2 = new File(data, currentDBPath2);
                                        File currentDB3 = new File(data, currentDBPath3);
                                        File backupDB = new File(sd, backupDBPath);
                                        File backupDB2 = new File(sd, backupDBPath2);
                                        File backupDB3 = new File(sd, backupDBPath3);

                                        if (currentDB2.exists()) {
                                            FileChannel src = new FileInputStream(currentDB2).getChannel();
                                            FileChannel dst = new FileOutputStream(backupDB2).getChannel();
                                            dst.transferFrom(src, 0, src.size());
                                            src.close();
                                            dst.close();
                                        }
                                        if (currentDB3.exists()) {
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

                            } else {
                                Toast.makeText(c, "Senha Incorreta!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(c, "Insira a senha do Supervisor!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                b.setNegativeButton("Cancelar", null);
                b.setCancelable(false);
                b.create();
                b.show();
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
