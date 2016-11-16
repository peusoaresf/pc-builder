package uva.pcbuilder.database;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by peuso on 02/11/2016.
 */

public class DbInflater extends AppCompatActivity {
    private Context c;
    public DbInflater(Context c) {
        this.c = c;
    }
    public void inflate() {
        DbHelper db = new DbHelper(c);
        // Aqui vai o script para inflar o banco de dados em sua criacao

        // Ja Adicionados daqui pra baixo
//        db.insertVga(30160, "GTX 1080", "NVIDIA", 180f, 2799.99f);
    }
}
