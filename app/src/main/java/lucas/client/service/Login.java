package lucas.client.service;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.io.*;
import java.nio.channels.*;
import lucas.client.service.caixa.*;
import lucas.client.service.etc.*;
import lucas.client.service.sqlite.*;
import android.support.design.widget.*;
import android.support.v7.app.AppCompatActivity;

public class Login extends AppCompatActivity
{
	Context c = this;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LayoutInflater li = getLayoutInflater();
		View r = li.inflate(R.layout.login, null);
		
		final TextInputEditText user = r.findViewById(R.id.usuario);
		final TextInputEditText senha = r.findViewById(R.id.senha);
		final TextInputEditText operador = r.findViewById(R.id.operador);
		final TextInputEditText fundo = r.findViewById(R.id.fundo);
		Bundle bundle = getIntent().getExtras();
		
		try{
			String op = bundle.getString("op");
			if(!op.toString().equals("")){
				operador.setText(op.toString());
				operador.setEnabled(false);
			}
		}catch(Exception e){
			
		}
		try{
			String op = bundle.getString("fundo");
			if(!op.toString().equals("")){
				fundo.setText(op.toString());
				fundo.setEnabled(false);
			}
		}catch(Exception e){

		}
		Button can = r.findViewById(R.id.cancel);
		Button login = r.findViewById(R.id.login);
		can.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					finishAffinity();
				}
		});
		login.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					DB db_ = new DB(c);
					util use = db_.getUser(1);
					
					if(!user.getText().toString().equals("")){
						if(user.getText().toString().equals(use.getUser())){
							user.setTextColor(Color.GREEN);
							if(!senha.getText().toString().equals("")){
								if(senha.getText().toString().equals(use.getSenha())){
									senha.setTextColor(Color.GREEN);
									if(!operador.getText().toString().equals("")){
										operador.setTextColor(Color.GREEN);
										if(!fundo.getText().toString().equals("")){
											fundo.setTextColor(Color.GREEN);
											util us = new util();
											us.setOp(operador.getText().toString());
											util us2 = new util();
											us2.setFundo(fundo.getText().toString());

											DB db = new DB(c);
											db.opIn(us);
											db.funIn(us2);

											Intent itt = new Intent(c, caixaMain.class);
											startActivity(itt);
											finish();
										} else {
											//fundo vazio
											fundo.setTextColor(Color.RED);
										}
									} else {
										//operador vazio
										operador.setTextColor(Color.RED);
									}
								} else {
									//senha errada
									senha.getText().clear();
									senha.setTextColor(Color.RED);
								}
							} else {
								//senha vazia
								senha.setTextColor(Color.RED);
							}
						} else {
							//user errado
							user.getText().clear();
							user.setTextColor(Color.RED);
						}
					} else {
						//user vazio
						user.setTextColor(Color.RED);
					}
				}
			});
		AlertDialog.Builder b = new AlertDialog.Builder(this, R.style.dialog);
		b.setTitle("POS Client Service");
		b.setIcon(R.drawable.icon);
		b.setView(r);
		b.setCancelable(false);
		b.create();
		b.show();
		
    } 
}
