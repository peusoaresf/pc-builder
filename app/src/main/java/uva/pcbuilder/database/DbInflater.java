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

        // mobos ----------------------------------------------------
        // brand, model, socket, ramtype, price, power draw
//        db.insertMotherboard("MSI", "h81m-e33", "lga 1150", "ddr3", 239.90f, 30f);
//        db.insertMotherboard("ASROCK", "fm2a55m-hd+", "fm2+", "ddr3", 275.90f, 40f);
//        db.insertMotherboard("Gigabyte", "ga-781mt-usb3", "am3+", "ddr3", 303.63f, 45f);
//        db.insertMotherboard("Gigabyte", "ga-b15m-d3h", "lga 1151", "ddr3", 452.01f, 50f);
//        db.insertMotherboard("ASUS", "b150m-c/br", "lga 1151", "ddr4", 499.00f, 60f);
//        db.insertMotherboard("Gigabyte", "ga-h17-gaming", "lga 1151", "ddr4", 659.46f, 80f);

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

        // main memory ----------------------------------------------
//        db.insertMainMemory("kingston", "kvr13n9s6/2", "ddr3", "2gb", 3f, 69.90f);
//        db.insertMainMemory("kingston", "kvr16n11s8/4", "ddr3", "4gb", 3f, 111.90f);
//        db.insertMainMemory("kingston", "hyperX fury", "ddr3", "8gb", 3f, 229.90f);
//        db.insertMainMemory("kingston", "hyperX fury", "ddr3", "8gb", 3f, 242.73f);
//        db.insertMainMemory("kingston", "hyperX fury", "ddr4", "16gb", 2f, 451.53f);

        // storage units --------------------------------------------
        // price, power draw, size, brand, model
//        db.insertStorage(169.99f, 9f, "500gb", "seagate", "pipeline");
//        db.insertStorage(259.00f, 9f, "500gb", "western digital", "wd10exex caviar blue");
//        db.insertStorage(279.99f, 9f, "1tb", "seagate", "st1000dm003");
//        db.insertStorage(394.99f, 9f, "2tb", "seagate", "barracuda");

        // disk drives ----------------------------------------------
        // brand, model, price, power draw, disc type
//        db.insertOpticalDiskDriver("ASUS", "drw-24f1mt", 59.90f, 20f, "dvd/cd");
//        db.insertOpticalDiskDriver("Hitachi", "Dh12esh02b", 149.90f, 30f, "bluray/dvd");
//        db.insertOpticalDiskDriver("LG", "wh14ns40", 294.00f, 30f, "bluray/dvd");

        // psus -----------------------------------------------------
        // brand, model, price, capacity
//        db.insertPSU("huntkey", "hk350-11a", 77.50f, 250f);
//        db.insertPSU("EVGA", "100-n1-0400-lo", 152.92f, 400f);
//        db.insertPSU("CORSAIR", "cx430w", 235.60f, 430f);
//        db.insertPSU("CORSAIR", "cx500w", 289.90f, 500f);
//        db.insertPSU("CORSAIR", "cx600w", 319.90f, 600f);
//        db.insertPSU("CORSAIR", "cx750w", 444.90f, 750f);

        // cases ----------------------------------------------------
        // brand, model, price
//        db.insertCase("EBOLT", "eb032", 77.50f);
//        db.insertCase("C3-TECH", "mt-g50 bk", 116.90f);
//        db.insertCase("Aerocool", "AERO 500 White", 198.99f);
//        db.insertCase("Aerocool", "xpredator x1", 356.40f);
//        db.insertCase("PCYES", "pegasus 3b", 491.69f);
//        db.insertCase("Optimus", "gs-6000i", 568.90f);

//        System.out.println("Chegou ao fim do script.");
    }
}
