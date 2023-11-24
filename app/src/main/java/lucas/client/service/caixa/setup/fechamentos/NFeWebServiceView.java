package lucas.client.service.caixa.setup.fechamentos;
import android.app.*;
import android.icu.text.*;
import android.icu.util.*;
import android.os.*;
import android.webkit.*;
import java.io.*;
import lucas.client.service.*;
import android.net.*;

public class NFeWebServiceView extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web);
		WebView wb = findViewById(R.id.web);
		wb.setWebViewClient(new WebViewClient());
		String dateTime2;
		Calendar calendar2 = Calendar.getInstance(); 
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd.MM.yyyy"); 
		dateTime2 = simpleDateFormat2.format(calendar2.getTime()).toString();
		File root = new File(Environment.getExternalStorageDirectory(), "pdvMain/data/lucas.client.service/.fechamentos/fechamento_" + dateTime2 + ".html");
		Uri url = Uri.fromFile(root);
		wb.loadUrl(url.toString());
	}
	
}
