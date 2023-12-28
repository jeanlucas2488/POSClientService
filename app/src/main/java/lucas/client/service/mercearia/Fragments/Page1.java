package lucas.client.service.mercearia.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.DecimalFormat;
import android.icu.text.DecimalFormatSymbols;
import android.os.Bundle;
import android.os.Environment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.List;

import lucas.client.service.Fragments.adapter.productAdapter;
import lucas.client.service.R;
import lucas.client.service.caixa.adapters.gridAd;
import lucas.client.service.etc.util;
import lucas.client.service.mercearia.Fragments.adapters.prodAd;
import lucas.client.service.mercearia.Fragments.payment.pay_;
import lucas.client.service.mercearia.databases.SQLiteControl;
import lucas.client.service.sqlite.DB;

public class Page1 extends Fragment
{
    byte[] lm;
    prodAd ad;
    gridAd ad2;
    List<util> lt, car;
    String CarRw1, CarRw2, CarRw3, CarRw4, CarRw5, CarRw6, CarRw7, CarRw8, CarRw9, CarRw10, CarRw11;
    AlertDialog ale;

    public Page1(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //setHasOptionsMenu(true);
        View rootView=inflater.inflate(R.layout.fragment_view,null);
        SQLiteControl db = new SQLiteControl(getActivity());
        lt = db.findP1();
        List<util> op;
        op = db.opFind();
        TextView tv = rootView.findViewById(R.id.barOp);
        tv.setText("Operador(a): " + op.get(0).getOp());
        ImageButton cr = rootView.findViewById(R.id.finish);

        cr.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View p1)
            {
                // TODO: Implement this method
                runCarrinho();
            }
        });
        GridView gd = rootView.findViewById(R.id.grid);
        ad2 = new gridAd(getActivity(), lt);
        gd.setAdapter(ad2);
        gd.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> p1, View p2, final int p3, long p4)
            {
                // TODO: Implement this method
                lm = lt.get(p3).getImage();
                if(lt.get(p3).getProd1().startsWith("Pão")
                        || lt.get(p3).getProd1().startsWith("Bolo")
                        || lt.get(p3).getProd1().startsWith("Biscoitinho")
                        || lt.get(p3).getProd1().startsWith("Orelha de Gato")
                        || lt.get(p3).getProd1().endsWith("Mineirinho")
                        || lt.get(p3).getProd1().startsWith("Torta")
                        || lt.get(p3).getProd1().startsWith("Tomate")
                        || lt.get(p3).getProd1().startsWith("Cebola")
                        || lt.get(p3).getProd1().startsWith("Pepino")
                        || lt.get(p3).getProd1().startsWith("Coco")
                        || lt.get(p3).getProd1().startsWith("Coco Verde")
                        || lt.get(p3).getProd1().startsWith("Alho Solto")
                        || lt.get(p3).getProd1().startsWith("Alface")
                        || lt.get(p3).getProd1().startsWith("Pimentão")
                        || lt.get(p3).getProd1().startsWith("Laranja")
                        || lt.get(p3).getProd1().startsWith("Maçã")
                        || lt.get(p3).getProd1().startsWith("Rabanete")
                        || lt.get(p3).getProd1().startsWith("Chuchu")
                        || lt.get(p3).getProd1().startsWith("Abóbora")
                        || lt.get(p3).getProd1().startsWith("Brócolis")
                        || lt.get(p3).getProd1().startsWith("Cará")
                        || lt.get(p3).getProd1().startsWith("Abobrinha")
                        || lt.get(p3).getProd1().startsWith("Mandioca")
                        || lt.get(p3).getProd1().startsWith("Aipim")
                        || lt.get(p3).getProd1().startsWith("Nabo")
                        || lt.get(p3).getProd1().startsWith("Fava")
                        || lt.get(p3).getProd1().startsWith("Vagem")
                        || lt.get(p3).getProd1().startsWith("Inhame")
                        || lt.get(p3).getProd1().startsWith("Chicória")
                        || lt.get(p3).getProd1().startsWith("Escarola")
                        || lt.get(p3).getProd1().startsWith("Jiló")
                        || lt.get(p3).getProd1().startsWith("Batata-doce")
                        || lt.get(p3).getProd1().startsWith("Quiabo")
                        || lt.get(p3).getProd1().startsWith("Alho Poró")
                        || lt.get(p3).getProd1().startsWith("Acelga")
                        || lt.get(p3).getProd1().startsWith("Caju")
                        || lt.get(p3).getProd1().startsWith("Pêra")
                        || lt.get(p3).getProd1().startsWith("Manga")
                        || lt.get(p3).getProd1().startsWith("Framboesa")
                        || lt.get(p3).getProd1().startsWith("Limão")
                        || lt.get(p3).getProd1().startsWith("Beringela")
                        || lt.get(p3).getProd1().startsWith("Tangerina")
                        || lt.get(p3).getProd1().startsWith("Melância")
                        || lt.get(p3).getProd1().startsWith("Banana")
                        || lt.get(p3).getProd1().startsWith("Abacaxi")
                        || lt.get(p3).getProd1().startsWith("Kiwi")
                        || lt.get(p3).getProd1().startsWith("Tomate-Caqui")
                        || lt.get(p3).getProd1().startsWith("Abacate")
                        || lt.get(p3).getProd1().startsWith("Jambo")
                        || lt.get(p3).getProd1().startsWith("Jaca")
                        || lt.get(p3).getProd1().startsWith("Ameixa")
                        || lt.get(p3).getProd1().startsWith("Mamão")
                        || lt.get(p3).getProd1().startsWith("Melão")
                        || lt.get(p3).getProd1().startsWith("Beterraba")
                        || lt.get(p3).getProd1().startsWith("Cenoura")
                        || lt.get(p3).getProd1().startsWith("Repolho")
                        || lt.get(p3).getProd1().startsWith("Batata")
                        || lt.get(p3).getProd1().startsWith("Couve Flor")
                        || lt.get(p3).getProd1().startsWith("Goiaba")
                        || lt.get(p3).getProd1().startsWith("Uva")
                        || lt.get(p3).getProd1().startsWith("Carne")) {
                    View r = getActivity().getLayoutInflater().inflate(R.layout.add_product, null);
                    ImageView imp = r.findViewById(R.id.imP);
                    final EditText prod = r.findViewById(R.id.prod);
                    final EditText quan = r.findViewById(R.id.quant);
                    final TextView tvq = r.findViewById(R.id.tvQ);
                    final EditText valor = r.findViewById(R.id.valor);
                    final ImageButton bt_sub = r.findViewById(R.id.sub);
                    final ImageButton bt_add = r.findViewById(R.id.add);
                    bt_sub.setVisibility(View.GONE);
                    bt_add.setVisibility(View.GONE);
                    quan.setText("0");
                    quan.setEms(5);
                    quan.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                        @Override
                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                          if(actionId == EditorInfo.IME_ACTION_DONE){
                              Double v1 = new Double(lt.get(p3).getValor1());
                              Double v2 = new Double(quan.getText().toString());
                              double res = v1 * v2;
                              DecimalFormatSymbols df = new DecimalFormatSymbols();
                              df.setGroupingSeparator('.');
                              df.setDecimalSeparator('.');
                              DecimalFormat dform = new DecimalFormat("####.##", df);
                              valor.setText(dform.format(res));
                              return true;
                          }
                            return false;
                        }
                    });
                    byte[] im = lt.get(p3).getImage();
                    Bitmap bt = BitmapFactory.decodeByteArray(im, 0, im.length);
                    imp.setImageBitmap(bt);
                    prod.setText(lt.get(p3).getProd1());
                    valor.setText(lt.get(p3).getValor1());
                    AlertDialog.Builder adp = new AlertDialog.Builder(getActivity());
                    adp.setTitle("Adicionar ao Carrinho!");
                    adp.setView(r);
                    adp.setPositiveButton("Adicionar", new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface p1, int p2)
                        {
                            // TODO: Implement this method
                           if(lt.get(p3).getProd1().startsWith("Pão") || lt.get(p3).getProd1().startsWith("Bolo") || lt.get(p3).getProd1().startsWith("Mineirinho")){
                               util us = new util();
                               us.setProd2(lt.get(p3).getProd1());
                               us.setQuant2(quan.getText().toString() + " KG");
                               us.setValor2(valor.getText().toString());
                               us.setImage2(lm);
                               SQLiteControl d = new SQLiteControl(getActivity());
                               d.carIn(us);
                               try {
                                   File sd = Environment.getExternalStorageDirectory();
                                   File data = Environment.getDataDirectory();

                                   if (sd.canWrite()) {
                                       String  currentDBPath= "//data//" + getActivity().getOpPackageName()
                                               + "//databases//" + "MCRDB.db";
                                       String  currentDBPath2 = "//data//" + getActivity().getOpPackageName()
                                               + "//databases//" + "MCRDB.db-shm";
                                       String  currentDBPath3 = "//data//" + getActivity().getOpPackageName()
                                               + "//databases//" + "MCRDB.db-wal";

                                       String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db";
                                       String backupDBPath2  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-shm";
                                       String backupDBPath3  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-wal";

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
                           }else {
                               util us = new util();
                               us.setProd2(lt.get(p3).getProd1());
                               us.setQuant2(quan.getText().toString() + "x");
                               us.setValor2(valor.getText().toString());
                               us.setImage2(lm);
                               SQLiteControl d = new SQLiteControl(getActivity());
                               d.carIn(us);
                               try {
                                   File sd = Environment.getExternalStorageDirectory();
                                   File data = Environment.getDataDirectory();

                                   if (sd.canWrite()) {
                                       String  currentDBPath= "//data//" + getActivity().getOpPackageName()
                                               + "//databases//" + "MCRDB.db";
                                       String  currentDBPath2 = "//data//" + getActivity().getOpPackageName()
                                               + "//databases//" + "MCRDB.db-shm";
                                       String  currentDBPath3 = "//data//" + getActivity().getOpPackageName()
                                               + "//databases//" + "MCRDB.db-wal";

                                       String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db";
                                       String backupDBPath2  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-shm";
                                       String backupDBPath3  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-wal";

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
                        }
                    });
                    adp.setNegativeButton("Cancelar", null);
                    adp.create();
                    adp.show();
                }else {
                    View r = getActivity().getLayoutInflater().inflate(R.layout.add_product, null);
                    ImageView imp = r.findViewById(R.id.imP);
                    final TextView tvq = r.findViewById(R.id.tvQ);
                    final EditText prod = r.findViewById(R.id.prod);
                    final EditText quan = r.findViewById(R.id.quant);
                    final EditText valor = r.findViewById(R.id.valor);
                    final ImageButton bt_sub = r.findViewById(R.id.sub);
                    final ImageButton bt_add = r.findViewById(R.id.add);
                    tvq.setVisibility(View.GONE);
                    bt_sub.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View p1)
                        {
                            // TODO: Implement this method
                            if(quan.getText().toString().equals("1")){
                                bt_sub.setEnabled(false);
                            }else {
                                Double v1 = new Double(quan.getText().toString());
                                double res = v1 - 1;
                                DecimalFormatSymbols df2 = new DecimalFormatSymbols();

                                DecimalFormat dform2 = new DecimalFormat("##", df2);
                                quan.setText(dform2.format(res));
                                Double sub1 = new Double(valor.getText().toString());
                                Double sub2 = new Double(lt.get(p3).getValor1());
                                double res2 = sub1 - sub2;
                                DecimalFormatSymbols df = new DecimalFormatSymbols();
                                df.setGroupingSeparator('.');
                                df.setDecimalSeparator('.');
                                DecimalFormat dform = new DecimalFormat("####.00", df);
                                valor.getText().clear();
                                valor.setText(dform.format(res2));
                            }
                        }
                    });
                    bt_add.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View p1)
                        {
                            // TODO: Implement this method
                            bt_sub.setEnabled(true);
                            Double v1 = new Double(quan.getText().toString());
                            double res0 = v1  +1;
                            DecimalFormatSymbols df2 = new DecimalFormatSymbols();

                            DecimalFormat dform2 = new DecimalFormat("##", df2);
                            quan.setText(dform2.format(res0));
                            Double quant = new Double(quan.getText().toString());
                            Double val = new Double(lt.get(p3).getValor1());
                            double res = val * quant;
                            DecimalFormatSymbols df = new DecimalFormatSymbols();
                            df.setGroupingSeparator('.');
                            df.setDecimalSeparator('.');
                            DecimalFormat dform = new DecimalFormat("####.00", df);
                            valor.getText().clear();
                            valor.setText(dform.format(res));
                        }
                    });
                    byte[] im = lt.get(p3).getImage();
                    Bitmap bt = BitmapFactory.decodeByteArray(im, 0, im.length);
                    imp.setImageBitmap(bt);
                    prod.setText(lt.get(p3).getProd1());

                    quan.setText("1");
                    quan.setOnEditorActionListener(new TextView.OnEditorActionListener(){

                        @Override
                        public boolean onEditorAction(TextView p1, int p2, KeyEvent p3)
                        {
                            // TODO: Implement this method

                            return false;
                        }
                    });
                    valor.setText(lt.get(p3).getValor1());
                    AlertDialog.Builder adp = new AlertDialog.Builder(getActivity());
                    adp.setTitle("Adicionar ao Carrinho!");
                    adp.setView(r);
                    adp.setPositiveButton("Adicionar", new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface p1, int p2)
                        {
                            // TODO: Implement this method
                            util us = new util();
                            us.setProd2(lt.get(p3).getProd1());
                            us.setQuant2(quan.getText().toString() + "x");
                            us.setValor2(valor.getText().toString());
                            us.setImage2(lm);
                            DB d = new DB(getActivity());
                            d.carIn(us);
                            try {
                                File sd = Environment.getExternalStorageDirectory();
                                File data = Environment.getDataDirectory();

                                if (sd.canWrite()) {
                                    String  currentDBPath= "//data//" + getActivity().getOpPackageName()
                                            + "//databases//" + "MCRDB.db";
                                    String  currentDBPath2 = "//data//" + getActivity().getOpPackageName()
                                            + "//databases//" + "MCRDB.db-shm";
                                    String  currentDBPath3 = "//data//" + getActivity().getOpPackageName()
                                            + "//databases//" + "MCRDB.db-wal";

                                    String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db";
                                    String backupDBPath2  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-shm";
                                    String backupDBPath3  = "pdvMain/data/lucas.client.service/.sqlite/MCRDB.db-wal";

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
                    adp.setNegativeButton("Cancelar", null);
                    adp.create();
                    adp.show();
                }

            }
        });
        return rootView;
    }
    public void runCarrinho(){
        SQLiteControl srv = new SQLiteControl(getActivity());
        car = srv.carrinho();

        try{
            if(!car.get(0).getProd2().toString().equals("")){
                View r = getActivity().getLayoutInflater().inflate(R.layout.product_added, null);
                ad = new prodAd(getActivity(), car);
                ListView lp = r.findViewById(R.id.list);
                lp.setEmptyView(r.findViewById(android.R.id.empty));
                lp.setAdapter(ad);
                AlertDialog.Builder ap = new AlertDialog.Builder(getActivity());
                ap.setTitle("Carrinho de Compras!");
                ap.setView(r);
                ap.setPositiveButton("Cobrar", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface p1, int p2)
                    {
                        // TODO: Implement this method

                          try{
                            SQLiteControl d1 = new SQLiteControl(getActivity());
                            util carRw1 = d1.getCarRw(1);
                            if(!carRw1.getValor2().equals("")){
                                CarRw1 = carRw1.getValor2();
                            }
                        }catch(Exception e){
                            CarRw1 = "0";
                        }
                        try{
                            SQLiteControl d2 = new SQLiteControl(getActivity());
                            util carRw2 = d2.getCarRw(2);
                            if(!carRw2.getValor2().equals("")){
                                CarRw2 = carRw2.getValor2();
                            }
                        }catch(Exception e){
                            CarRw2 = "0";
                        }
                        try{
                            SQLiteControl d3 = new SQLiteControl(getActivity());
                            util carRw3 = d3.getCarRw(3);
                            if(!carRw3.getValor2().equals("")){
                                CarRw3 = carRw3.getValor2();
                            }
                        }catch(Exception e){
                            CarRw3 = "0";
                        }
                        try{
                            SQLiteControl d4 = new SQLiteControl(getActivity());
                            util carRw4 = d4.getCarRw(4);
                            if(!carRw4.getValor2().equals("")){
                                CarRw4 = carRw4.getValor2();
                            }
                        }catch(Exception e){
                            CarRw4 = "0";
                        }
                        try{
                            SQLiteControl d5 = new SQLiteControl(getActivity());
                            util carRw5 = d5.getCarRw(5);
                            if(!carRw5.getValor2().equals("")){
                                CarRw5 = carRw5.getValor2();
                            }
                        }catch(Exception e){
                            CarRw5 = "0";
                        }
                        try{
                            SQLiteControl d6 = new SQLiteControl(getActivity());
                            util carRw6 = d6.getCarRw(6);
                            if(!carRw6.getValor2().equals("")){
                                CarRw6 = carRw6.getValor2();
                            }
                        }catch(Exception e){
                            CarRw6 = "0";
                        }
                        try{
                            SQLiteControl d7 = new SQLiteControl(getActivity());
                            util carRw7 = d7.getCarRw(7);
                            if(!carRw7.getValor2().equals("")){
                                CarRw7 = carRw7.getValor2();
                            }
                        }catch(Exception e){
                            CarRw7 = "0";
                        }
                        try{
                            SQLiteControl d8 = new SQLiteControl(getActivity());
                            util carRw8 = d8.getCarRw(8);
                            if(!carRw8.getValor2().equals("")){
                                CarRw8 = carRw8.getValor2();
                            }
                        }catch(Exception e){
                            CarRw8 = "0";
                        }
                        try{
                            SQLiteControl d9 = new SQLiteControl(getActivity());
                            util carRw9 = d9.getCarRw(9);
                            if(!carRw9.getValor2().equals("")){
                                CarRw9 = carRw9.getValor2();
                            }
                        }catch(Exception e){
                            CarRw9 = "0";
                        }
                        try{
                            SQLiteControl d10 = new SQLiteControl(getActivity());
                            util carRw10 = d10.getCarRw(10);
                            if(!carRw10.getValor2().equals("")){
                                CarRw10 = carRw10.getValor2();
                            }
                        }catch(Exception e){
                            CarRw10 = "0";
                        }
                        try{
                            SQLiteControl d11 = new SQLiteControl(getActivity());
                            util carRw11 = d11.getCarRw(11);
                            if(!carRw11.getValor2().equals("")){
                                CarRw11 = carRw11.getValor2();
                            }
                        }catch(Exception e){
                            CarRw11 = "0";
                        }
                        Double som1 = new Double(CarRw1);
                        Double som2 = new Double(CarRw2);
                        Double som3 = new Double(CarRw3);
                        Double som4 = new Double(CarRw4);
                        Double som5 = new Double(CarRw5);
                        Double som6 = new Double(CarRw6);
                        Double som7 = new Double(CarRw7);
                        Double som8 = new Double(CarRw8);
                        Double som9 = new Double(CarRw9);
                        Double som10 = new Double(CarRw10);
                        Double som11 = new Double(CarRw11);
                        double res_ = som1 + som2 + som3 + som4 + som5 + som6 + som7 + som8 + som9 + som10 + som11;
                        DecimalFormatSymbols df = new DecimalFormatSymbols();
                        df.setGroupingSeparator('.');
                        df.setDecimalSeparator('.');
                        DecimalFormat dform = new DecimalFormat("####.##", df);
                        String result = dform.format(res_);
                        Intent it = new Intent(getActivity(), pay_.class);
                        Bundle b = new Bundle();
                        b.putString("valor", result);
                        it.putExtras(b);
                        startActivity(it);

                    }
                });
                ap.setNegativeButton("Cancelar!", null);
                ale = ap.create();
                ale = ap.show();
            }
        }catch(Exception e){
            Toast.makeText(getActivity(), "Você precisa adicionar produtos ao Carrinho!!", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.util_product, menu);
        MenuItem mSearchMenuItem = menu.findItem(R.id.search);
        SearchView sc = (SearchView) mSearchMenuItem.getActionView();
        sc.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                ad2.filter(s);

                return false;
            }
        });
        super.onCreateOptionsMenu(menu,inflater);
    }

}