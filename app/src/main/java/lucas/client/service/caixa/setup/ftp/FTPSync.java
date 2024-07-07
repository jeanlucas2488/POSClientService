package lucas.client.service.caixa.setup.ftp;

import android.os.AsyncTask;

import org.apache.commons.net.ftp.FTPClient;

public class FTPSync extends AsyncTask<Void, Void, Boolean> {
    private String host, user, pass;
    private int port;

    FTPSync(String host, String user, String pass, int port){
        this.host = host;
        this.user = user;
        this.pass = pass;
        this.port = port;


    }

    @Override
    public Boolean doInBackground(Void... voids) {
        try{
            FTPClient ftp = new FTPClient();
            ftp.connect(host, port);
            boolean result = ftp.login(user, pass);
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();
            return result;
        }catch(Exception e){

        }
        return false;
    }
}
