package lucas.client.service.caixa.setup.ftp;

public class FTPHelper {
    public boolean connect(String host, String user, String pass, int port){
        try{
           return new FTPSync(host, user, pass, port).execute().get();
        }catch(Exception e){

        }
        return false;
    }
}
