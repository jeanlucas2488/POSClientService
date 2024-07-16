package lucas.client.service.caixa;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import lucas.client.service.R;
import lucas.client.service.caixa.setup.ftp.FTPHelper;
import lucas.client.service.etc.util;
import lucas.client.service.sqlite.DB;

public class checkFTPServer extends Activity {

    Context c = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DB db = new DB(c);

        try{
            util us = db.getFtpServer(1);
            if(!us.getFtpHost().equals("")){
                Intent itt = new Intent(c, selfConfig.class);
                startActivity(itt);
            } else {

            }
        } catch(Exception e){
            LayoutInflater li = getLayoutInflater();
            View r = li.inflate(c, R.layout.checkFtp, null);
            final EditText ftpHost = r.findViewById(R.id.ftpHost);
            final EditText ftpUser = r.findViewById(R.id.ftpUser);
            final EditText ftpPass = r.findViewById(R.id.ftpPass);
            final EditText ftpPort = r.findViewById(R.id.ftpPort);

            if(!ftpHost.getText().toString().equals("")){
                if(!ftpUser.getText().toString().equals("")){
                    if(!ftpPass.getText().toString().equals("")){
                        if(!ftpPort.getText().toString().equals("")){

                            DB db2 = new DB(c);
                            util us = new util();

                            us.setFtpHost(ftpHost.getText().toString());
                            us.setFtpUser(ftpUser.getText().toString());
                            us.setFtpPass(ftpPass.getText().toString());
                            us.setFtpPort(Integer.parseInt(ftpPort.getText().toString()));

                            db2.ftpIn(us);

                            FTPHelper ftp = new FTPHelper();
                            ftp.connect(ftpHost.getText().toString(), ftpUser.getText().toString(), ftpPass.getText().toString(), Integer.parseInt(ftpPort.getText().toString()));

                        } else {
                            //port
                            msg("Insira uma porta válida!");
                        }
                    } else {
                        msg("Insira uma senha válida!");
                        //pass
                    }
                } else {
                    //user
                    msg("Insira um usuário válido!");
                }
            } else {
                //host
                msg("Insira um servidor válido!");
            }
            AlertDialog.Builder bs = new AlertDialog.Builder(c);
            bs.setTitle("Cadastrar Servidor:");
            bs.setView(r);
            bs.create();
            bs.show();
        }

    }
    public void msg(String ms){
        Toast.makeText(c, ms, Toast.LENGTH_LONG).show();
    }

}
