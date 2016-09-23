package uva.pcbuilder.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import uva.pcbuilder.dominio.Motherboard;

/**
 * Created by peuso on 23/09/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PcParts.db";

    // Tabela Motherboard
    private static final String MOTHERBOARD_TABLE_NAME = "motherboards";
    private static final String MOTHERBOARD_COLUMN_ID = "id";
    private static final String MOTHERBOARD_COLUMN_BRAND = "brand";
    private static final String MOTHERBOARD_COLUMN_MODEL = "model";
    private static final String MOTHERBOARD_COLUMN_CPUSOCKET = "cpu_socket";
    private static final String MOTHERBOARD_COLUMN_RAMTYPE = "supported_ram_type";
    private static final String MOTHERBOARD_COLUMN_PRICE = "price";
    private static final String MOTHERBOARD_COLUMN_POWERCONSUMPTION = "power_consumption";
    private static final String CREATE_TABLE_MOTHERBOARD = "create table motherboards " +
            "(id integer primary key, brand text, model text, cpu_socket text, supported_ram_type text, " +
            "price decimal(19,4), power_consumption float)";
    private static final String DROP_TABLE_MOTHERBOARD = "drop table if exists motherboads";

    // Tabel Case

    // Tabela MainMemory

    // Tabela OpticalDiscDriver

    // TabelaProcessor

    // Tabela PSU

    // Tabela Storage

    // Tabela VideoGraphicsAdapter

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MOTHERBOARD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_MOTHERBOARD);
        onCreate(db);
    }

    public boolean insertMotherboard(String brand, String model, String cpuSocket, String supportedRamType, float price, float powerConsumption) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MOTHERBOARD_COLUMN_BRAND, brand);
        contentValues.put(MOTHERBOARD_COLUMN_MODEL, model);
        contentValues.put(MOTHERBOARD_COLUMN_CPUSOCKET, cpuSocket);
        contentValues.put(MOTHERBOARD_COLUMN_RAMTYPE, supportedRamType);
        contentValues.put(MOTHERBOARD_COLUMN_PRICE, price);
        contentValues.put(MOTHERBOARD_COLUMN_POWERCONSUMPTION, powerConsumption);
        db.insert(MOTHERBOARD_TABLE_NAME, null, contentValues);
        return true;
    }

    public List<Motherboard> getAllMotherboards() {
        List<Motherboard> mobos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + MOTHERBOARD_TABLE_NAME, null);
        res.moveToFirst();

        while(!res.isAfterLast()) {
            float consumoEletrico = res.getFloat(res.getColumnIndex(MOTHERBOARD_COLUMN_POWERCONSUMPTION));
            float preco = res.getFloat(res.getColumnIndex(MOTHERBOARD_COLUMN_PRICE));
            String marca = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_BRAND));
            String modelo = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_MODEL));
            String cpuSocket = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_CPUSOCKET));
            String ramType = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_RAMTYPE));
            Motherboard mobo = new Motherboard(consumoEletrico, preco, marca, modelo, cpuSocket, ramType);
            mobos.add(mobo);
            res.moveToNext();
        }
        return mobos;
    }
}
