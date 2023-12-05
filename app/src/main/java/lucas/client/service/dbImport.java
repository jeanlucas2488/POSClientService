package lucas.client.service;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class dbImport extends Activity {
    Context c = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String  currentDBPath= "//data//" + c.getOpPackageName()
                        + "//databases//" + "myDB.db";
                String backupDBPath  = "pdvMain/data/lucas.client.service/.sqlite/myDB.db";
                File dbshm = new File(data, currentDBPath + "-shm");
                File dbwal = new File(data, currentDBPath + "-wal");
                if (dbshm.exists()) {
                    dbshm.delete();
                }
                if (dbwal.exists()) {
                    dbwal.delete();
                }
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);
                FileChannel src = new FileInputStream(backupDB).getChannel();
                FileChannel dst = new FileOutputStream(currentDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                Toast.makeText(c, "Sucesso", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(c, "Falha", Toast.LENGTH_LONG).show();
        }
    }
}
