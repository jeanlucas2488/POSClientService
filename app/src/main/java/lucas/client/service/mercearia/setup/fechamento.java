package lucas.client.service.mercearia.setup;
import android.app.*;
import android.content.*;
import android.icu.text.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.io.*;
import java.nio.channels.*;
import java.util.*;
import lucas.client.service.*;
import lucas.client.service.caixa.*;
import lucas.client.service.caixa.setup.fechamentos.NFeWebServiceView;
import lucas.client.service.etc.*;
import lucas.client.service.mercearia.databases.SQLiteControl;
import lucas.client.service.sqlite.*;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class fechamento extends AppCompatActivity
{
    Button canc, fecha;
    List<util> opf, fpf;
    Context c = this;
    String sanResult,SupResult, supRes,  moneyRes, carDRes, carCRes, pixResul,
            cdRes, ccRes, pRes;
    ProgressDialog progress;
    String sangRes, supR1, supR2, supR3, supR4, supR5, supR6, sanR1, sanR2, sanR3, sanR4, sanR5, sanR6;
    LinearLayout moneyid, carDID, carCID, pixID;

    TextInputEditText sangria_, suprimento_, operador_, data, fundo_, money_, carD_, carC_, pix_;

    List<util> operador, sangria, supS, sup,  fundo, money, carD, carC, Pix;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO: Implement this method
        super.onCreate(savedInstanceState);

        LayoutInflater li = getLayoutInflater();
        View r = li.inflate(R.layout.fecha_caixa, null);
        data = r.findViewById(R.id.data);
        moneyid = r.findViewById(R.id.money_ID);
        carDID = r.findViewById(R.id.carD_ID);
        carCID = r.findViewById(R.id.carC_ID);
        pixID = r.findViewById(R.id.pix_ID);

        fundo_ = r.findViewById(R.id.fundo);
        sangria_ = r.findViewById(R.id.sangria);
        suprimento_ = r.findViewById(R.id.suprimento);
        operador_ = r.findViewById(R.id.operador);

        money_ = r.findViewById(R.id.money);
        carD_ = r.findViewById(R.id.carD);
        carC_ = r.findViewById(R.id.carC);
        pix_ = r.findViewById(R.id.pix);

        canc = r.findViewById(R.id.canc);
        fecha = r.findViewById(R.id.fecha);
        SQLiteControl db1 = new SQLiteControl(c);
        opf = db1.opFind();

        operador_.setText(opf.get(0).getOp());

        String dateTime2;
        Calendar calendar2 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd.MM.yyyy");
        dateTime2 = simpleDateFormat2.format(calendar2.getTime()).toString();
        data.setText(dateTime2.toString());

        try{
            SQLiteControl db = new SQLiteControl(c);
            supS = db.suFind();
            if(!supS.get(0).getSupVal().equals("")){
                SQLiteControl db2 = new SQLiteControl(c);
                fpf = db2.funFind();
                Double v1 = new Double(fpf.get(0).getFundo());
                Double v2 = new Double(supS.get(0).getSupVal());
                double res = v1 + v2;
                fundo_.setText(String.valueOf(res));
                supRes = supS.get(0).getSupVal();
                suprimento_.setVisibility(View.VISIBLE);
            }
        }catch(Exception e){
            suprimento_.setVisibility(View.GONE);
            SQLiteControl db2 = new SQLiteControl(c);
            fpf = db2.funFind();
            fundo_.setText(fpf.get(0).getFundo());
            supRes = "0";

        }
        try{
            SQLiteControl db = new SQLiteControl(c);
            sangria = db.saFind();
            if(!sangria.get(0).getSangria().equals("")){
                sangRes = sangria.get(0).getSangria();
                sangria_.setVisibility(View.VISIBLE);
            }
        }catch(Exception e){
            sangRes = "0";
            sangria_.setVisibility(View.GONE);
        }

        try{
            SQLiteControl db = new SQLiteControl(c);
            money = db.moFind();
            if(!money.get(0).getMoney().equals("")){
                moneyRes = money.get(0).getMoney();
                money_.setVisibility(View.VISIBLE);
            }
        }catch(Exception e){
            moneyRes = "0";
            money_.setVisibility(View.GONE);
        }
        try{
            SQLiteControl db = new SQLiteControl(c);
            carD = db.getCarD();
            if(!carD.get(0).getCarD().equals("")){
                carDRes = carD.get(0).getCarD();
                carD_.setVisibility(View.VISIBLE);
            }
        }catch(Exception e){
            carDRes = "0";
            carD_.setVisibility(View.GONE);
        }
        try{
            SQLiteControl db = new SQLiteControl(c);
            carC = db.getCarC();
            if(!carC.get(0).getCarC().equals("")){
                carCRes = carC.get(0).getCarC();
                carC_.setVisibility(View.VISIBLE);
            }
        }catch(Exception e){
            carCRes = "0";
            carC_.setVisibility(View.GONE);
        }
        try{
            SQLiteControl db = new SQLiteControl(c);
            Pix = db.getPix();
            if(!Pix.get(0).getPix().equals("")){
                pixResul = Pix.get(0).getPix();
                pix_.setVisibility(View.VISIBLE);
            }
        }catch(Exception e){
            pixResul = "0";
            pix_.setVisibility(View.GONE);
        }

        fecha.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View p1)
            {
                // TODO: Implement this method
                progress = new ProgressDialog(c);
                progress.setMax(100);
                progress.setMessage("Iniciando Fechamento...");
                progress.setTitle("Fechamento de Caixa");
                progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progress.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (progress.getProgress() <= progress
                                    .getMax()) {
                                Thread.sleep(900);
                                handle.sendMessage(handle.obtainMessage());
                                if (progress.getProgress() == 20) {
                                    progress.setMessage("Gerando NFe da Redução Z...");
                                    try{
                                        SQLiteControl db = new SQLiteControl(c);
                                        List<util> ls;
                                        ls = db.suFind();
                                        if(!ls.get(0).getSupVal().equals("")){
                                            SQLiteControl db2 = new SQLiteControl(c);
                                            util sanRes1 = db2.supFind(1);
                                            SQLiteControl db3 = new SQLiteControl(c);
                                            util sanRes2 = db3.supFind(2);
                                            SQLiteControl db4 = new SQLiteControl(c);
                                            util sanRes3 = db4.supFind(3);
                                            SQLiteControl db5 = new SQLiteControl(c);
                                            util sanRes4 = db5.supFind(4);
                                            SQLiteControl db6 = new SQLiteControl(c);
                                            util sanRes5 = db6.supFind(5);
                                            SQLiteControl db7 = new SQLiteControl(c);
                                            util sanRes6 = db7.supFind(6);
                                            try{
                                                if(!db2.supFind(1).toString().equals("")){
                                                    supR1 = "<tr>"+
                                                            "<td id='clM'>" + sanRes1.getSupDesc() + "</td> <td id='clVal'>" + sanRes1.getSupVal() + "</td>"+
                                                            "</tr>";
                                                }else {}
                                            }catch(Exception e){
                                                supR1 = "";
                                            }
                                            try{
                                                if(!sanRes2.getSupVal().equals("")){
                                                    supR2 = "<tr>"+
                                                            "<td id='clM'>" + sanRes2.getSupDesc() + "</td> <td id='clVal'>" + sanRes2.getSupVal() + "</td>"+
                                                            "</tr>";
                                                }
                                            }catch(Exception e){
                                                supR2 = "";
                                            }
                                            try{
                                                if(!sanRes3.getSupVal().equals("")){
                                                    supR3 = "<tr>"+
                                                            "<td id='clM'>" + sanRes3.getSupDesc() + "</td> <td id='clVal'>" + sanRes3.getSupVal() + "</td>"+
                                                            "</tr>";
                                                }
                                            }catch(Exception e){
                                                supR3 = "";
                                            }
                                            try{
                                                if(!sanRes4.getSupVal().equals("")){
                                                    supR4 = "<tr>"+
                                                            "<td id='clM'>" + sanRes4.getSupDesc() + "</td> <td id='clVal'>" + sanRes4.getSupVal() + "</td>"+
                                                            "</tr>";
                                                }
                                            }catch(Exception e){
                                                supR4 = "";
                                            }
                                            try{
                                                if(!sanRes5.getSupVal().equals("")){
                                                    supR5 = "<tr>"+
                                                            "<td id='clM'>" + sanRes5.getSupDesc() + "</td> <td id='clVal'>" + sanRes5.getSupVal() + "</td>"+
                                                            "</tr>";
                                                }
                                            }catch(Exception e){
                                                supR5 = "";
                                            }
                                            try{
                                                if(!sanRes6.getSupVal().equals("")){
                                                    supR6 = "<tr>"+
                                                            "<td id='clM'>" + sanRes6.getSupDesc() + "</td> <td id='clVal'>" + sanRes6.getSupVal() + "</td>"+
                                                            "</tr>";
                                                }
                                            }catch(Exception e){
                                                supR6 = "";
                                            }

                                            SupResult = "<div>"+
                                                    "<center>"+
                                                    "<div class='san'><b>Suprimento de Caixa:</b></div>"+
                                                    "<table>"+
                                                    "<tr>"+
                                                    "<th id='mot'>Descrição</th><th id='val'>Valor</th>"+
                                                    supR1.toString() +
                                                    supR2.toString() +
                                                    supR3.toString() +
                                                    supR4.toString() +
                                                    supR5.toString() +
                                                    supR6.toString() +
                                                    "<tr>"+
                                                    "<td id='clVal'>Total:</td>" +
                                                    "<td id='clu'>R$" + supRes.toString() + "</td>" +
                                                    "</tr>"+
                                                    "</tr>"+
                                                    "</table>"+
                                                    "</center>"+
                                                    "</div>";
                                        }
                                    }catch(Exception e){
                                        SupResult = "";
                                    }

                                    try{
                                        SQLiteControl db = new SQLiteControl(c);
                                        List<util> ls;
                                        ls = db.saFind();
                                        if(!ls.get(0).getSangria().equals("")){
                                            SQLiteControl db2 = new SQLiteControl(c);
                                            util sanRes1 = db2.sanFind(1);
                                            SQLiteControl db3 = new SQLiteControl(c);
                                            util sanRes2 = db3.sanFind(2);
                                            SQLiteControl db4 = new SQLiteControl(c);
                                            util sanRes3 = db4.sanFind(3);
                                            SQLiteControl db5 = new SQLiteControl(c);
                                            util sanRes4 = db5.sanFind(4);
                                            SQLiteControl db6 = new SQLiteControl(c);
                                            util sanRes5 = db6.sanFind(5);
                                            SQLiteControl db7 = new SQLiteControl(c);
                                            util sanRes6 = db7.sanFind(6);
                                            try{
                                                if(!db2.sanFind(1).toString().equals("")){
                                                    sanR1 = "<tr>"+
                                                            "<td id='clM'>" + sanRes1.getSanMot() + "</td> <td id='clVal'>" + sanRes1.getSanVal() + "</td>"+
                                                            "</tr>";
                                                }else {}
                                            }catch(Exception e){
                                                sanR1 = "";
                                            }
                                            try{
                                                if(!sanRes2.getSanVal().equals("")){
                                                    sanR2 = "<tr>"+
                                                            "<td id='clM'>" + sanRes2.getSanMot() + "</td> <td id='clVal'>" + sanRes2.getSanVal() + "</td>"+
                                                            "</tr>";
                                                }
                                            }catch(Exception e){
                                                sanR2 = "";
                                            }
                                            try{
                                                if(!sanRes3.getSanVal().equals("")){
                                                    sanR3 = "<tr>"+
                                                            "<td id='clM'>" + sanRes3.getSanMot() + "</td> <td id='clVal'>" + sanRes3.getSanVal() + "</td>"+
                                                            "</tr>";
                                                }
                                            }catch(Exception e){
                                                sanR3 = "";
                                            }
                                            try{
                                                if(!sanRes4.getSanVal().equals("")){
                                                    sanR4 = "<tr>"+
                                                            "<td id='clM'>" + sanRes4.getSanMot() + "</td> <td id='clVal'>" + sanRes4.getSanVal() + "</td>"+
                                                            "</tr>";
                                                }
                                            }catch(Exception e){
                                                sanR4 = "";
                                            }
                                            try{
                                                if(!sanRes5.getSanVal().equals("")){
                                                    sanR5 = "<tr>"+
                                                            "<td id='clM'>" + sanRes5.getSanMot() + "</td> <td id='clVal'>" + sanRes5.getSanVal() + "</td>"+
                                                            "</tr>";
                                                }
                                            }catch(Exception e){
                                                sanR5 = "";
                                            }
                                            try{
                                                if(!sanRes6.getSanVal().equals("")){
                                                    sanR6 = "<tr>"+
                                                            "<td id='clM'>" + sanRes6.getSanMot() + "</td> <td id='clVal'>" + sanRes6.getSanVal() + "</td>"+
                                                            "</tr>";
                                                }
                                            }catch(Exception e){
                                                sanR6 = "";
                                            }
                                            Double somaSan = new Double(sangRes);
                                            Double compRes = new Double(sangria_.getText().toString());
                                            double res = somaSan - compRes;
                                            DecimalFormatSymbols df4 = new DecimalFormatSymbols();
                                            df4.setGroupingSeparator('.');
                                            df4.setDecimalSeparator('.');
                                            DecimalFormat dform4 = new DecimalFormat("####.##", df4);
                                            sanResult = "<div>"+
                                                    "<center>"+
                                                    "<div class='san'><b>Sangria de Caixa:</b></div>"+
                                                    "<table>"+
                                                    "<tr>"+
                                                    "<th id='mot'>Motivo</th><th id='val'>Valor</th>"+
                                                    sanR1.toString() +
                                                    sanR2.toString() +
                                                    sanR3.toString() +
                                                    sanR4.toString() +
                                                    sanR5.toString() +
                                                    sanR6.toString() +
                                                    "<tr>"+
                                                    "<td id='clS'>Soma:</td> <td id='clL'>Lançado:</td>"+
                                                    "</tr>"+
                                                    "<tr>"+
                                                    "<td id='clso'>R$" + sangRes.toString() + "</td> <td id='clu'>R$" + sangria_.getText().toString() + "</td>"+
                                                    "</tr>"+
                                                    "<tr>"+
                                                    "<td></td><td id='clVal'>Diferença:</td>"+
                                                    "</tr>"+
                                                    "<tr>"+
                                                    "<td></td><td id='clVal'>R$" + dform4.format(res) + "</td>"+
                                                    "</tr>"+
                                                    "</tr>"+
                                                    "</table>"+
                                                    "</center>"+
                                                    "</div>";
                                        }
                                    }catch(Exception e){
                                        sanResult = "";
                                    }
                                    try{
                                        if(!moneyRes.toString().equals("")){
                                            Double somaMoney = new Double(moneyRes);
                                            Double compRes = new Double(money_.getText().toString());
                                            Double compSan = new Double(sangRes);
                                            double borderoRes = somaMoney - compSan;
                                            double res = compRes - borderoRes;
                                            DecimalFormatSymbols df4 = new DecimalFormatSymbols();
                                            df4.setGroupingSeparator('.');
                                            df4.setDecimalSeparator('.');
                                            DecimalFormat dform4 = new DecimalFormat("####.##", df4);

                                            moneyRes = "<div class='bo'><h4 id='bor'>BORDERO:</h4><h4 id='cx'>CAIXA:</h4>" +
                                                    "<h5 id='ln'>------------</h5> <h5 id='ln2'>------------</h5>" + "</div>" +
                                                    "<div class='bo'><h4 id='bor_'>R$" + dform4.format(borderoRes) + "</h4> <h4 id='cx'>R$" + money_.getText().toString() + "</h4></div>" +
                                                    "<div class='bo'><h4 id='cx2'>Dif: R$" + dform4.format(res) + "</h4></div><br/>";
                                        } else {
                                        }
                                    }catch(Exception e){
                                        moneyRes = "";
                                    }
                                    try{
                                        List<util> lt;
                                        SQLiteControl db = new SQLiteControl(c);
                                        lt = db.getCarD();
                                        if(!lt.get(0).getCarD().equals("")){
                                            Double somaEloD = new Double(carDRes);
                                            Double compRes = new Double(carD_.getText().toString());
                                            double res = somaEloD - compRes;
                                            DecimalFormatSymbols df4 = new DecimalFormatSymbols();
                                            df4.setGroupingSeparator('.');
                                            df4.setDecimalSeparator('.');
                                            DecimalFormat dform4 = new DecimalFormat("####.##", df4);
                                            cdRes = "<div><p style='text-align:left;'>"+
                                                    "<b style='text-align:left;'>Cartão Débito: R$" + carDRes.toString() + "</b>"+
                                                    "<b style='float:right;'>R$" + carD_.getText().toString() + "</b><br/>"+
                                                    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
                                                    "</p></div>";
                                        } else {}
                                    }catch(Exception e){
                                        cdRes = "";
                                    }
                                    if(!carCRes.toString().equals("")){
                                        Double somaEloC = new Double(carCRes);
                                        Double compRes = new Double(carC_.getText().toString());
                                        double res = somaEloC - compRes;
                                        DecimalFormatSymbols df4 = new DecimalFormatSymbols();
                                        df4.setGroupingSeparator('.');
                                        df4.setDecimalSeparator('.');
                                        DecimalFormat dform4 = new DecimalFormat("####.##", df4);
                                        ccRes = "<br/><div><p style='text-align:left;'>"+
                                                "<b style='text-align:left;'>Cartão Crédito: R$" + carCRes.toString() + "</b>"+
                                                "<b style='float:right;'>R$" + carC_.getText().toString() + "</b><br/>"+
                                                "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
                                                "</p></div>";
                                    } else {
                                        ccRes = "";
                                    }
                                    if(!pixResul.toString().equals("")){
                                        Double somaVisaD = new Double(pixResul);
                                        Double compRes = new Double(pix_.getText().toString());
                                        double res = somaVisaD - compRes;
                                        DecimalFormatSymbols df4 = new DecimalFormatSymbols();
                                        df4.setGroupingSeparator('.');
                                        df4.setDecimalSeparator('.');
                                        DecimalFormat dform4 = new DecimalFormat("####.##", df4);
                                        pRes = "<br/><div><p style='text-align:left;'>"+
                                                "<b style='text-align:left;'>Pix: R$" + pixResul.toString() + "</b>"+
                                                "<b style='float:right;'>R$" + pix_.getText().toString() + "</b><br/>"+
                                                "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
                                                "</p></div>";
                                    } else {
                                        pRes = "";
                                    }
                                    try{
                                        String dateTime2;
                                        Calendar calendar2 = Calendar.getInstance();
                                        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd.MM.yyyy");
                                        dateTime2 = simpleDateFormat2.format(calendar2.getTime()).toString();
                                        String dateTime;
                                        Calendar calendar = Calendar.getInstance();
                                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
                                        File root = new File(Environment.getExternalStorageDirectory(), "pdvMain/data/lucas.client.service/.fechamentos/fechamento_" + dateTime2.toString() +".html");
                                        FileWriter fw = new FileWriter(root);
                                        fw.write(
                                                "<html>"+
                                                        "<head>"+
                                                        "<body>"+
                                                        "<style>"+
                                                        "body{"+
                                                        "height:auto;"+
                                                        "margin:5px;"+
                                                        "}"+
                                                        ".nav2 {"+
                                                        "margin-top:5px;"+
                                                        "height:auto;"+
                                                        "text-align:center;"+
                                                        "padding:20px 20px 20px;"+
                                                        "background:#eeff1566;"+
                                                        "}"+
                                                        ".nav {"+
                                                        "margin-top:10px;"+
                                                        "margin:auto;"+
                                                        "height:auto;"+
                                                        "text-align:center;"+
                                                        "padding:20px 20px 20px;"+
                                                        "background:#eeff1566;"+
                                                        "}"+
                                                        "#bor{"+
                                                        "text-align:left;"+
                                                        "}"+
                                                        "#bor_{"+
                                                        "margin-top:-20px;"+
                                                        "text-align:left;"+
                                                        "}"+
                                                        "#dat{"+
                                                        "margin-left:20px;"+
                                                        "}"+
                                                        "#cx{"+
                                                        "margin-top:-36px;"+
                                                        "text-align:right;"+
                                                        "}"+
                                                        "#cx2{"+
                                                        "margin-top:20px;"+
                                                        "margin-right:5px;"+
                                                        "text-align:right;"+
                                                        "}"+
                                                        "#ln {"+
                                                        "text-align:left;"+
                                                        "margin-top:-20px;"+
                                                        "}"+
                                                        "#ln2 {"+
                                                        "text-align:right;"+
                                                        "margin-top:-35px;"+
                                                        "}"+
                                                        ".bo {"+
                                                        "margin:10px;"+
                                                        "}"+
                                                        "#mot{"+
                                                        "color:#fff;"+
                                                        "padding:15px 50px 15px;"+
                                                        "background:#7015ff;"+
                                                        "}"+
                                                        "#val{"+
                                                        "color:#fff;"+
                                                        "padding:15px 50px 15px;"+
                                                        "background:#ff3400;"+
                                                        "}"+
                                                        "#clM{"+
                                                        "background:#f4aaff;"+
                                                        "padding:10px;"+
                                                        "}"+
                                                        "#clS{"+
                                                        "background:#00cc46;"+
                                                        "padding:10px;"+
                                                        "}"+
                                                        "#clL{"+
                                                        "color:#fff;"+
                                                        "background:#ff1f00;"+
                                                        "padding:10px;"+
                                                        "}"+
                                                        "#clso{"+
                                                        "background:#86ff6a68;"+
                                                        "padding:10px;"+
                                                        "}"+
                                                        "#clu{"+
                                                        "color:#fff;"+
                                                        "background:#ff340089;"+
                                                        "padding:10px;"+
                                                        "}"+
                                                        "#clVal{"+
                                                        "background:#90ff2b;"+
                                                        "padding:10px;"+
                                                        "}"+
                                                        ".san{"+
                                                        "padding:15px;"+
                                                        "margin:10px;"+
                                                        "color:#fff;"+
                                                        "margin-bottom:0;"+
                                                        "background:#e32bff;"+
                                                        "}"+
                                                        "</style>"+
                                                        "</head>"+
                                                        "<div class='nav'>Cupom Fiscal NFe</div>"+
                                                        "<div class='nav2'><p id='bor'>Lucas Informática <br/><br/>Rua Colombo, 504 - Petrópolis <br/>CEP: 89208-890 - Joinville SC<br/><u>Data: " + dateTime.toString() + "</u></p><h4>+------------------------------------+</h4>REDUÇÃO Z:<h4>+------------------------------------+</h4>"+
                                                        "<br/>" +
                                                        "<br/>"+
                                                        "<b style='float:left;margin-left:10px;'>Operador:</b> <b style='float:right;margin-right:10px;'>" + operador_.getText().toString() + "</b>"+
                                                        "<br/>"+
                                                        "<br/>"+
                                                        "<b style='float:left;margin-left:10px;'>Fundo:</b> <b style='float:right;margin-right:10px;'>R$" + fundo_.getText().toString()+ "</b>"+
                                                        "<br/>"+
                                                        "<br/>"+
                                                        "<br/>"+
                                                        moneyRes.toString() +
                                                        SupResult.toString() +
                                                        sanResult.toString() +
                                                        carDRes.toString() +
                                                        carCRes.toString() +
                                                        pixResul.toString() +
                                                        "</div></body></html>");
                                        fw.flush();
                                        fw.close();
                                    }catch(IOException e){

                                    }
                                }
                                if(progress.getProgress() == 30){
                                    progress.setMessage("Salvando NF-e da Redução Z...");
                                    String dateTime2;
                                    Calendar calendar2 = Calendar.getInstance();
                                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd.MM.yyyy");
                                    dateTime2 = simpleDateFormat2.format(calendar2.getTime()).toString();
                                    String dateTime;
                                    Calendar calendar = Calendar.getInstance();
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                    dateTime = simpleDateFormat.format(calendar.getTime()).toString();
                                    util us = new util();
                                    us.setData(data.getText().toString());
                                    us.setNfe("<html>"+
                                            "<head>"+
                                            "<body>"+
                                            "<style>"+
                                            "body{"+
                                            "height:auto;"+
                                            "margin:5px;"+
                                            "}"+
                                            ".nav2 {"+
                                            "margin-top:5px;"+
                                            "height:auto;"+
                                            "text-align:center;"+
                                            "padding:20px 20px 20px;"+
                                            "background:#eeff1566;"+
                                            "}"+
                                            ".nav {"+
                                            "margin-top:10px;"+
                                            "margin:auto;"+
                                            "height:auto;"+
                                            "text-align:center;"+
                                            "padding:20px 20px 20px;"+
                                            "background:#eeff1566;"+
                                            "}"+
                                            "#bor{"+
                                            "text-align:left;"+
                                            "}"+
                                            "#bor_{"+
                                            "margin-top:-20px;"+
                                            "text-align:left;"+
                                            "}"+
                                            "#dat{"+
                                            "margin-left:20px;"+
                                            "}"+
                                            "#cx{"+
                                            "margin-top:-36px;"+
                                            "text-align:right;"+
                                            "}"+
                                            "#cx2{"+
                                            "margin-top:20px;"+
                                            "margin-right:5px;"+
                                            "text-align:right;"+
                                            "}"+
                                            "#ln {"+
                                            "text-align:left;"+
                                            "margin-top:-20px;"+
                                            "}"+
                                            "#ln2 {"+
                                            "text-align:right;"+
                                            "margin-top:-35px;"+
                                            "}"+
                                            ".bo {"+
                                            "margin:10px;"+
                                            "}"+
                                            "#mot{"+
                                            "color:#fff;"+
                                            "padding:15px 50px 15px;"+
                                            "background:#7015ff;"+
                                            "}"+
                                            "#val{"+
                                            "color:#fff;"+
                                            "padding:15px 50px 15px;"+
                                            "background:#ff3400;"+
                                            "}"+
                                            "#clM{"+
                                            "background:#f4aaff;"+
                                            "padding:10px;"+
                                            "}"+
                                            "#clS{"+
                                            "background:#00cc46;"+
                                            "padding:10px;"+
                                            "}"+
                                            "#clL{"+
                                            "color:#fff;"+
                                            "background:#ff1f00;"+
                                            "padding:10px;"+
                                            "}"+
                                            "#clso{"+
                                            "background:#86ff6a68;"+
                                            "padding:10px;"+
                                            "}"+
                                            "#clu{"+
                                            "color:#fff;"+
                                            "background:#ff340089;"+
                                            "padding:10px;"+
                                            "}"+
                                            "#clVal{"+
                                            "background:#90ff2b;"+
                                            "padding:10px;"+
                                            "}"+
                                            ".san{"+
                                            "padding:15px;"+
                                            "margin:10px;"+
                                            "color:#fff;"+
                                            "margin-bottom:0;"+
                                            "background:#e32bff;"+
                                            "}"+
                                            "</style>"+
                                            "</head>"+
                                            "<div class='nav'>Cupom Fiscal NFe</div>"+
                                            "<div class='nav2'><p id='bor'>Lucas Informática <br/><br/>Rua Colombo, 504 - Petrópolis <br/>CEP: 89208-890 - Joinville SC<br/><u>Data: " + dateTime.toString() + "</u></p><h4>+------------------------------------+</h4>REDUÇÃO Z:<h4>+------------------------------------+</h4>"+
                                            "<br/>" +
                                            "<br/>"+
                                            "<b style='float:left;margin-left:10px;'>Operador:</b> <b style='float:right;margin-right:10px;'>" + operador_.getText().toString() + "</b>"+
                                            "<br/>"+
                                            "<br/>"+
                                            "<b style='float:left;margin-left:10px;'>Fundo:</b> <b style='float:right;margin-right:10px;'>R$" + fundo_.getText().toString()+ "</b>"+
                                            "<br/>"+
                                            "<br/>"+
                                            "<br/>"+
                                            moneyRes.toString() +
                                            SupResult.toString() +
                                            sanResult.toString() +
                                            carDRes.toString() +
                                            carCRes.toString() +
                                            pixResul.toString() +

                                            "</div></body></html>");
                                    SQLiteControl post = new SQLiteControl(c);
                                    post.insertFecha(us);
                                }
                                if (progress.getProgress() == 40) {
                                    SQLiteControl db = new SQLiteControl(c);
                                    progress.setMessage("Zerando Transações...");
                                    try{db.delSup();}catch(Exception e){}
                                    try{db.delSupSom();}catch(Exception e){}
                                    try{db.delMoney();}catch(Exception e){}
                                    try{db.delOp();}catch(Exception e){}
                                    try{db.delSaldo();}catch(Exception e){}
                                    try{db.delSangSaldo();}catch(Exception e){}
                                    try{db.delSang();}catch(Exception e){}
                                    try{db.delCarD();}catch(Exception e){}
                                    try{db.delCarC();}catch(Exception e){}
                                    try{db.delPix();}catch(Exception e){}

                                }
                                if(progress.getProgress() == 50) {
                                    progress.setMessage("Zerando Lançamentos...");
                                    SQLiteControl db = new SQLiteControl(c);
                                    try{db.delHis();}catch(Exception e){}
                                }
                                if (progress.getProgress() == 70) {
                                    progress.setMessage("Zerando Cupons...");
                                }
                                if (progress.getProgress() == 80) {
                                    progress.setMessage("Fazendo LogOff de Operador...");
                                }
                                if (progress.getProgress() == 90) {
                                    progress.setMessage("Salvando Banco de Dados...");
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
                                if (progress.getProgress() == 100) {
                                    progress.setMessage("Fechamento Concluído!");
                                    progress.cancel();
                                    progress.dismiss();
                                    Intent itt = new Intent(c, NFeWebServiceView.class);
                                    startActivity(itt);
                                    finishAffinity();
                                    Thread.sleep(200000);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
            Handler handle = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    progress.incrementProgressBy(2);
                }
            };
        });
        canc.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View p1)
            {
                // TODO: Implement this method
                Intent itt = new Intent(c, caixaMain.class);
                startActivity(itt);
                finish();
            }
        });
        AlertDialog.Builder br = new AlertDialog.Builder(c, R.style.dialog);
        br.setTitle("Fechamento de Caixa");
        br.setIcon(R.drawable.icon);
        br.setView(r);
        br.create();
        br.show();
    }
}
