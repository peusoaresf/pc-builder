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

        // cpus -----------------------------------------------------
        // brand, model, socket, power draw, price, score
//        db.insertProcessor("Intel", "celeron g1820", "lga 1150", 53f, 144.90f, 2520);
//        db.insertProcessor("AMD", "athlon x4 870k", "fm2+", 95f, 359.90f, 3520);
//        db.insertProcessor("AMD", "fx 8320e", "am3+", 95f, 455.00f, 5810);
//        db.insertProcessor("Intel", "i5 6400", "lga 1151", 65f, 744.99f, 5780);
//        db.insertProcessor("Intel", "i5 6600", "lga 1151", 65f, 899.90f, 6790);
//        db.insertProcessor("Intel", "i7 6700", "lga 1511", 65f, 1263.90f, 9130);


        // vgas -----------------------------------------------------
        // score, model, brand, power draw, price
//        db.insertVga(340, "HD 5450", "AMD", 19f, 124.90f);
//        db.insertVga(2730, "R7 350", "AMD", 75f, 319f);
//        db.insertVga(16660, "RX 470", "AMD", 120f, 947.43f);
//        db.insertVga(17430, "GTX 1060", "NVIDIA", 120f, 1248.90f);
//        db.insertVga(24700, "GTX 1070", "NVIDIA", 150f, 1800.89f);
//        db.insertVga(30160, "GTX 1080", "NVIDIA", 180f, 2799.99f);
        System.out.println("Chegou ao fim do script.");
    }
}
