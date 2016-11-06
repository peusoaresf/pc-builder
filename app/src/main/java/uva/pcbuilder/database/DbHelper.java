package uva.pcbuilder.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

import uva.pcbuilder.dominio.Case;
import uva.pcbuilder.dominio.Computer;
import uva.pcbuilder.dominio.FavoriteBuild;
import uva.pcbuilder.dominio.MainMemory;
import uva.pcbuilder.dominio.Motherboard;
import uva.pcbuilder.dominio.OpticalDiskDriver;
import uva.pcbuilder.dominio.Processor;
import uva.pcbuilder.dominio.Psu;
import uva.pcbuilder.dominio.Storage;
import uva.pcbuilder.dominio.VideoGraphicsAdapter;

/**
 * Created by peuso on 23/09/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PcParts.db";

    // Select de peca com preco ate "valor"
    private static final String SELECT_PART_WITH_PRICE = "select * from TABLE " +
                                                         "where COLUMN <= PRICE " +
                                                         "EXTRA_CONDITIONS";

    // Tabela Motherboard
    private static final String MOTHERBOARD_TABLE_NAME = "motherboards";
    private static final String MOTHERBOARD_COLUMN_ID = "id";
    private static final String MOTHERBOARD_COLUMN_BRAND = "brand";
    private static final String MOTHERBOARD_COLUMN_MODEL = "model";
    private static final String MOTHERBOARD_COLUMN_CPUSOCKET = "cpu_socket";
    private static final String MOTHERBOARD_COLUMN_RAMTYPE = "supported_ram_type";
    private static final String MOTHERBOARD_COLUMN_PRICE = "price";
    private static final String MOTHERBOARD_COLUMN_POWERCONSUMPTION = "power_consumption";
    private static final String CREATE_TABLE_MOTHERBOARD = "create table if not exists motherboards " +
            "(id integer primary key, brand text, model text, cpu_socket text, supported_ram_type text, " +
            "price decimal(19,4), power_consumption float)";
    private static final String DROP_TABLE_MOTHERBOARD = "drop table if exists motherboads";

    // Tabela Case
    private static final String CASE_TABLE_NAME = "pcCase";
    private static final String CASE_COLUMN_ID = "id";
    private static final String CASE_COLUMN_BRAND = "brand";
    private static final String CASE_COLUMN_MODEL = "model";
    private static final String CASE_COLUMN_PRICE = "price";
    private static final String CREATE_TABLE_CASE = "create table if not exists pcCase " +
            "(id integer primary key, brand text, model text, price decimal(19,4))";
    private static final String DROP_TABLE_CASE = "drop table if exists case";

    // Tabela MainMemory
    private static final String MAINMEMORY_TABLE_NAME = "main_memory";
    private static final String MAINMEMORY_COLUMN_ID = "id";
    private static final String MAINMEMORY_COLUMN_BRAND = "brand";
    private static final String MAINMEMORY_COLUMN_MODEL = "model";
    private static final String MAINMEMORY_COLUMN_TYPE = "type";
    private static final String MAINMEMORY_COLUMN_CAPACITY = "capacity";
    private static final String MAINMEMORY_COLUMN_SCORE = "score";
    private static final String MAINMEMORY_COLUMN_POWERCONSUMPTION = "power_consumption";
    private static final String MAINMEMORY_COLUMN_PRICE = "price";
    private static final String CREATE_TABLE_MAINMEMORY = "create table if not exists main_memory " +
            "(id integer primary key, brand text, model text, type text, capacity text, score integer, " +
            "power_consumption float, price decimal(19,4))";
    private static final String DROP_TABLE_MAINMEMORY = "drop table if exists main_memory";

    // Tabela OpticalDiskDriver
    private static final String OPTICALDISKDRIVER_TABLE_NAME = "optical_disk_driver";
    private static final String OPTICALDISKDRIVER_COLUMN_ID = "id";
    private static final String OPTICALDISKDRIVER_COLUMN_BRAND = "brand";
    private static final String OPTICALDISKDRIVER_COLUMN_MODEL = "model";
    private static final String OPTICALDISKDRIVER_COLUMN_PRICE = "price";
    private static final String OPTICALDISKDRIVER_COLUMN_POWERCONSUMPTION = "power_consumption";
    private static final String OPTICALDISKDRIVER_COLUMN_SUPPORTEDDISK = "supported_disk";
    private static final String CREATE_TABLE_OPTICALDISKDRIVER = "create table if not exists optical_disk_driver " +
            "(id integer primary key, brand text, model text, price decimal(19,4), power_consumption float, " +
            "supported_disk text)";
    private static final String DROP_TABLE_OPTICALDISKDRIVER = "drop table if exists optical_disk_driver";

    // Tabela Processor
    private static final String PROCESSOR_TABLE_NAME = "processors";
    private static final String PROCESSOR_COLUMN_ID = "id";
    private static final String PROCESSOR_COLUMN_BRAND = "brand";
    private static final String PROCESSOR_COLUMN_MODEL = "model";
    private static final String PROCESSOR_COLUMN_SOCKET = "socket";
    private static final String PROCESSOR_COLUMN_POWERCONSUMPTION = "power_consumption";
    private static final String PROCESSOR_COLUMN_PRICE = "price";
    private static final String PROCESSOR_COLUMN_SCORE = "score";
    private static final String CREATE_TABLE_PROCESSOR = "create table if not exists processors " +
            "(id integer primary key, brand text, model text, socket text, power_consumption float, " +
            "price decimal(19,4), score integer)";
    private static final String DROP_TABLE_PROCESSOR = "drop table if exists processors";

    // Tabela PSU
    private static final String PSU_TABLE_NAME = "psu";
    private static final String PSU_COLUMN_ID = "id";
    private static final String PSU_COLUMN_BRAND = "brand";
    private static final String PSU_COLUMN_MODEL = "model";
    private static final String PSU_COLUMN_CAPACITY = "capacity";
    private static final String PSU_COLUMN_PRICE = "price";
    private static final String PSU_COLUMN_SCORE = "score";
    private static final String CREATE_TABLE_PSU = "create table if not exists psu " +
            "(id integer primary key, brand text, model text, price decimal(19,4), score integer, capacity int)";
    private static final String DROP_TABLE_PSU = "drop table if exists psu";

    // Tabela Storage
    private static final String STORAGE_TABLE_NAME = "storage";
    private static final String STORAGE_COLUMN_ID = "id";
    private static final String STORAGE_COLUMN_BRAND = "brand";
    private static final String STORAGE_COLUMN_MODEL = "model";
    private static final String STORAGE_COLUMN_CAPACITY = "capacity";
    private static final String STORAGE_COLUMN_POWERCONSUMPTION = "power_consumption";
    private static final String STORAGE_COLUMN_PRICE = "price";
    private static final String CREATE_TABLE_STORAGE = "create table if not exists storage " +
            "(id integer primary key, brand text, model text, capacity text, " +
            "power_consumption float, price decimal(19,4))";
    private static final String DROP_TABLE_STORAGE = "drop table if exists storage";

    // Tabela VideoGraphicsAdapter
    private static final String VGA_TABLE_NAME = "vga";
    private static final String VGA_COLUMN_ID = "id";
    private static final String VGA_COLUMN_BRAND = "brand";
    private static final String VGA_COLUMN_MODEL = "model";
    private static final String VGA_COLUMN_POWERCONSUMPTION = "power_consumption";
    private static final String VGA_COLUMN_PRICE = "price";
    private static final String VGA_COLUMN_SCORE = "score";
    private static final String CREATE_TABLE_VGA = "create table if not exists vga " +
            "(id integer primary key, brand text, model text, power_consumption float, " +
            "price decimal(19,4), score integer)";
    private static final String DROP_TABLE_VGA = "drop table if exists vga";

    // Tabela de builds favoritas do usuario
    private static final String FAVORITE_TABLE_NAME = "favorite_builds";
    private static final String FAVORITE_COLUMN_ID = "id";
    private static final String FAVORITE_COLUMN_NAME = "name";
    private static final String FAVORITE_COLUMN_DATE = "date";
    private static final String FAVORITE_COLUMN_MOTHERBOARD_ID = "motherboard_id";
    private static final String FAVORITE_COLUMN_PROCESSOR_ID = "processor_id";
    private static final String FAVORITE_COLUMN_OPTICALDISKDRIVER_ID = "opticaldiskdriver_id";
    private static final String FAVORITE_COLUMN_CASE_ID = "case_id";
    private static final String FAVORITE_COLUMN_PSU_ID = "psu_id";
    private static final String FAVORITE_COLUMN_MAINMEMORY_ID = "mainmemory_id";
    private static final String FAVORITE_COLUMN_MAINMEMORY_COUNT = "mainmemory_count";
    private static final String FAVORITE_COLUMN_VGA_ID = "vga_id";
    private static final String FAVORITE_COLUMN_VGA_COUNT = "vga_count";
    private static final String FAVORITE_COLUMN_STORAGE_ID = "storage_id";
    private static final String FAVORITE_COLUMN_STORAGE_COUNT = "storage_count";
    private static final String CREATE_TABLE_FAVORITE = "create table if not exists favorite_builds " +
            "(id integer primary key, name text, date text, motherboard_id integer, processor_id integer, " +
            "opticaldiskdriver_id integer, case_id integer, psu_id integer, mainmemory_id integer, " +
            "mainmemory_count integer, vga_id integer, vga_count integer, storage_id integer, storage_count integer)";
    private static final String DROP_TABLE_FAVORITE = "drop table if exists favorite_builds";
 	/*
	 * colunas
	 * create
	 * drop
	 */


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MOTHERBOARD);
        db.execSQL(CREATE_TABLE_CASE);
        db.execSQL(CREATE_TABLE_MAINMEMORY);
        db.execSQL(CREATE_TABLE_OPTICALDISKDRIVER);
        db.execSQL(CREATE_TABLE_PROCESSOR);
        db.execSQL(CREATE_TABLE_PSU);
        db.execSQL(CREATE_TABLE_STORAGE);
        db.execSQL(CREATE_TABLE_VGA);
        db.execSQL(CREATE_TABLE_FAVORITE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_MOTHERBOARD);
        db.execSQL(DROP_TABLE_CASE);
        db.execSQL(DROP_TABLE_MAINMEMORY);
        db.execSQL(DROP_TABLE_OPTICALDISKDRIVER);
        db.execSQL(DROP_TABLE_PROCESSOR);
        db.execSQL(DROP_TABLE_PSU);
        db.execSQL(DROP_TABLE_STORAGE);
        db.execSQL(DROP_TABLE_VGA);
        db.execSQL(DROP_TABLE_FAVORITE);
        onCreate(db);
    }

    // Metodos sobre a tabela de Placas-mae

    public void insertMotherboard(String brand, String model, String cpuSocket, String supportedRamType, float price, float powerConsumption) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MOTHERBOARD_COLUMN_BRAND, brand);
            contentValues.put(MOTHERBOARD_COLUMN_MODEL, model);
            contentValues.put(MOTHERBOARD_COLUMN_CPUSOCKET, cpuSocket);
            contentValues.put(MOTHERBOARD_COLUMN_RAMTYPE, supportedRamType);
            contentValues.put(MOTHERBOARD_COLUMN_PRICE, price);
            contentValues.put(MOTHERBOARD_COLUMN_POWERCONSUMPTION, powerConsumption);
            db.insert(MOTHERBOARD_TABLE_NAME, null, contentValues);
        }
        finally {
            db.close();
        }
    }

    public List<Motherboard> getAllMotherboards() {
        List<Motherboard> mobos = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + MOTHERBOARD_TABLE_NAME, null);
            res.moveToFirst();

            while (!res.isAfterLast()) {
                float consumoEletrico = res.getFloat(res.getColumnIndex(MOTHERBOARD_COLUMN_POWERCONSUMPTION));
                float preco = res.getFloat(res.getColumnIndex(MOTHERBOARD_COLUMN_PRICE));
                String marca = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_BRAND));
                String modelo = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_MODEL));
                String cpuSocket = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_CPUSOCKET));
                String ramType = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_RAMTYPE));
                Motherboard mobo = new Motherboard(consumoEletrico, preco, marca, modelo, cpuSocket, ramType);
                mobo.setIdBanco(res.getInt(res.getColumnIndex(MOTHERBOARD_COLUMN_ID)));
                mobos.add(mobo);
                res.moveToNext();
            }

            res.close();
        }
        finally {
            db.close();
        }

        return mobos;
    }

    public Motherboard getMotherboard(int id) {
        Motherboard m = null;
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + MOTHERBOARD_TABLE_NAME + " where " + MOTHERBOARD_COLUMN_ID + " = " + id, null);

            if (res.moveToFirst()) {
                float consumoEletrico = res.getFloat(res.getColumnIndex(MOTHERBOARD_COLUMN_POWERCONSUMPTION));
                float preco = res.getFloat(res.getColumnIndex(MOTHERBOARD_COLUMN_PRICE));
                String marca = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_BRAND));
                String modelo = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_MODEL));
                String cpuSocket = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_CPUSOCKET));
                String ramType = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_RAMTYPE));
                m = new Motherboard(consumoEletrico, preco, marca, modelo, cpuSocket, ramType);
                m.setIdBanco(res.getInt(res.getColumnIndex(MOTHERBOARD_COLUMN_ID)));
            }

            res.close();
        }
        finally {
            db.close();
        }

        return m;
    }

    public Motherboard getMotherboard(float price) {
        Motherboard m = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String stm = SELECT_PART_WITH_PRICE.replace("TABELA", MOTHERBOARD_TABLE_NAME)
                                            .replace("COLUNA", MOTHERBOARD_COLUMN_PRICE)
                                             .replace("PRICE", Float.toString(price))
                                              .replace("EXTRA_CONDITIONS", "");

        try {
            Cursor res = db.rawQuery(stm, null);

            if (res.moveToFirst()) {
                float consumoEletrico = res.getFloat(res.getColumnIndex(MOTHERBOARD_COLUMN_POWERCONSUMPTION));
                float preco = res.getFloat(res.getColumnIndex(MOTHERBOARD_COLUMN_PRICE));
                String marca = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_BRAND));
                String modelo = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_MODEL));
                String cpuSocket = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_CPUSOCKET));
                String ramType = res.getString(res.getColumnIndex(MOTHERBOARD_COLUMN_RAMTYPE));
                m = new Motherboard(consumoEletrico, preco, marca, modelo, cpuSocket, ramType);
                m.setIdBanco(res.getInt(res.getColumnIndex(MOTHERBOARD_COLUMN_ID)));
            }

            res.close();
        } finally {
            db.close();
        }

        return m;
    }

    // Metodos sobre a tabela de gabinetes

    public void insertCase(String brand, String model, float price) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(CASE_COLUMN_BRAND, brand);
            contentValues.put(CASE_COLUMN_MODEL, model);
            contentValues.put(CASE_COLUMN_PRICE, price);
            db.insert(CASE_TABLE_NAME, null, contentValues);
        }
        finally {
            db.close();
        }
    }

    public List<Case> getAllCases() {
        List<Case> cases = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + CASE_TABLE_NAME, null);
            res.moveToFirst();

            while (!res.isAfterLast()) {
                String brand = res.getString(res.getColumnIndex(CASE_COLUMN_BRAND));
                float price = res.getFloat(res.getColumnIndex(CASE_COLUMN_PRICE));
                String model = res.getString(res.getColumnIndex(CASE_COLUMN_MODEL));
                Case c = new Case(price, model, brand);
                c.setIdBanco(res.getInt(res.getColumnIndex(CASE_COLUMN_ID)));
                cases.add(c);
                res.moveToNext();
            }

            res.close();
        }
        finally {
            db.close();
        }

        return cases;
    }

    public Case getCase(int id) {
        Case c = null;
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + CASE_TABLE_NAME + " where " + CASE_COLUMN_ID + " = " + id, null);

            if (res.moveToFirst()) {
                String brand = res.getString(res.getColumnIndex(CASE_COLUMN_BRAND));
                float pce = res.getFloat(res.getColumnIndex(CASE_COLUMN_PRICE));
                String model = res.getString(res.getColumnIndex(CASE_COLUMN_MODEL));
                c = new Case(pce, model, brand);
                c.setIdBanco(res.getInt(res.getColumnIndex(CASE_COLUMN_ID)));
            }

            res.close();
        }
        finally {
            db.close();
        }

        return c;
    }

    public Case getCase(float price) {
        Case c = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String stm = SELECT_PART_WITH_PRICE.replace("TABELA", CASE_TABLE_NAME)
                                                .replace("COLUNA", CASE_COLUMN_PRICE)
                                                .replace("PRICE", Float.toString(price))
                                                .replace("EXTRA_CONDITIONS", "");

        try {
            Cursor res = db.rawQuery(stm, null);

            if (res.moveToFirst()) {
                String brand = res.getString(res.getColumnIndex(CASE_COLUMN_BRAND));
                float pce = res.getFloat(res.getColumnIndex(CASE_COLUMN_PRICE));
                String model = res.getString(res.getColumnIndex(CASE_COLUMN_MODEL));
                c = new Case(pce, model, brand);
                c.setIdBanco(res.getInt(res.getColumnIndex(CASE_COLUMN_ID)));
            }

            res.close();
        } finally {
            db.close();
        }

        return c;
    }

    // Metodos sobre a tabela de memoria ram

    public void insertMainMemory(String brand, String model, String type,
                                 String capacity, int score, float powerConsumption, float price) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MAINMEMORY_COLUMN_BRAND, brand);
            contentValues.put(MAINMEMORY_COLUMN_MODEL, model);
            contentValues.put(MAINMEMORY_COLUMN_TYPE, type);
            contentValues.put(MAINMEMORY_COLUMN_CAPACITY, capacity);
            contentValues.put(MAINMEMORY_COLUMN_SCORE, score);
            contentValues.put(MAINMEMORY_COLUMN_POWERCONSUMPTION, powerConsumption);
            contentValues.put(MAINMEMORY_COLUMN_PRICE, price);
            db.insert(MAINMEMORY_TABLE_NAME, null, contentValues);
        }
        finally {
            db.close();
        }
    }

    public List<MainMemory> getAllMainMemories() {
        List<MainMemory> mainMemories = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + MAINMEMORY_TABLE_NAME, null);
            res.moveToFirst();

            while (!res.isAfterLast()) {
                String brand = res.getString(res.getColumnIndex(MAINMEMORY_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(MAINMEMORY_COLUMN_MODEL));
                String type = res.getString(res.getColumnIndex(MAINMEMORY_COLUMN_TYPE));
                String capacity = res.getString(res.getColumnIndex(MAINMEMORY_COLUMN_CAPACITY));
                int score = res.getInt(res.getColumnIndex(MAINMEMORY_COLUMN_SCORE));
                float powerConsumption = res.getFloat(res.getColumnIndex(MAINMEMORY_COLUMN_POWERCONSUMPTION));
                float price = res.getFloat(res.getColumnIndex(MAINMEMORY_COLUMN_PRICE));
                MainMemory mainMemory = new MainMemory(price, powerConsumption, score, brand, model, capacity, type);
                mainMemory.setIdBanco(res.getInt(res.getColumnIndex(MAINMEMORY_COLUMN_ID)));
                mainMemories.add(mainMemory);
                res.moveToNext();
            }

            res.close();
        }
        finally {
            db.close();
        }

        return mainMemories;
    }

    public MainMemory getMainMemory(int id) {
        MainMemory m = null;
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + MAINMEMORY_TABLE_NAME + " where " + MAINMEMORY_COLUMN_ID + " = " + id, null);

            if (res.moveToFirst()) {
                String brand = res.getString(res.getColumnIndex(MAINMEMORY_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(MAINMEMORY_COLUMN_MODEL));
                String type = res.getString(res.getColumnIndex(MAINMEMORY_COLUMN_TYPE));
                String capacity = res.getString(res.getColumnIndex(MAINMEMORY_COLUMN_CAPACITY));
                int score = res.getInt(res.getColumnIndex(MAINMEMORY_COLUMN_SCORE));
                float powerConsumption = res.getFloat(res.getColumnIndex(MAINMEMORY_COLUMN_POWERCONSUMPTION));
                float pce = res.getFloat(res.getColumnIndex(MAINMEMORY_COLUMN_PRICE));
                m = new MainMemory(pce, powerConsumption, score, brand, model, capacity, type);
                m.setIdBanco(res.getInt(res.getColumnIndex(MAINMEMORY_COLUMN_ID)));
            }

            res.close();
        }
        finally {
            db.close();
        }

        return m;
    }

    public MainMemory getMainMemory(float price, String ramType) {
        MainMemory m = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String stm = SELECT_PART_WITH_PRICE.replace("TABELA", MAINMEMORY_TABLE_NAME)
                                            .replace("COLUNA", MAINMEMORY_COLUMN_PRICE)
                                            .replace("PRICE", Float.toString(price))
                                            .replace("EXTRA_CONDITIONS", " AND " + MAINMEMORY_COLUMN_TYPE + " = " + ramType);

        try {
            Cursor res = db.rawQuery(stm, null);

            if (res.moveToFirst()) {
                String brand = res.getString(res.getColumnIndex(MAINMEMORY_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(MAINMEMORY_COLUMN_MODEL));
                String type = res.getString(res.getColumnIndex(MAINMEMORY_COLUMN_TYPE));
                String capacity = res.getString(res.getColumnIndex(MAINMEMORY_COLUMN_CAPACITY));
                int score = res.getInt(res.getColumnIndex(MAINMEMORY_COLUMN_SCORE));
                float powerConsumption = res.getFloat(res.getColumnIndex(MAINMEMORY_COLUMN_POWERCONSUMPTION));
                float pce = res.getFloat(res.getColumnIndex(MAINMEMORY_COLUMN_PRICE));
                m = new MainMemory(pce, powerConsumption, score, brand, model, capacity, type);
                m.setIdBanco(res.getInt(res.getColumnIndex(MAINMEMORY_COLUMN_ID)));
            }

            res.close();
        } finally {
            db.close();
        }

        return m;
    }

    // Metodos sobre a tabela de leitor de disco optico

    public void insertOpticalDiskDriver(String brand, String model, float price, float powerConsumption, String supportedDisk) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(OPTICALDISKDRIVER_COLUMN_BRAND, brand);
            contentValues.put(OPTICALDISKDRIVER_COLUMN_MODEL, model);
            contentValues.put(OPTICALDISKDRIVER_COLUMN_POWERCONSUMPTION, powerConsumption);
            contentValues.put(OPTICALDISKDRIVER_COLUMN_PRICE, price);
            contentValues.put(OPTICALDISKDRIVER_COLUMN_SUPPORTEDDISK, supportedDisk);
            db.insert(OPTICALDISKDRIVER_TABLE_NAME, null, contentValues);
        }
        finally {
            db.close();
        }
    }

    public List<OpticalDiskDriver> getAllOpticalDiskDrivers() {
        List<OpticalDiskDriver> opticalDiskDrivers = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + OPTICALDISKDRIVER_TABLE_NAME, null);
            res.moveToFirst();

            while (!res.isAfterLast()) {
                String brand = res.getString(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_MODEL));
                String supportedDisk = res.getString(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_SUPPORTEDDISK));
                float powerConsumption = res.getFloat(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_POWERCONSUMPTION));
                float price = res.getFloat(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_PRICE));
                OpticalDiskDriver opticalDiskDriver = new OpticalDiskDriver(powerConsumption, price, brand, model, supportedDisk);
                opticalDiskDriver.setIdBanco(res.getInt(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_ID)));
                opticalDiskDrivers.add(opticalDiskDriver);
                res.moveToNext();
            }

            res.close();
        }
        finally {
            db.close();
        }

        return opticalDiskDrivers;
    }

    public OpticalDiskDriver getOpticalDiskDriver(int id) {
        OpticalDiskDriver odd = null;
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + OPTICALDISKDRIVER_TABLE_NAME + " where " + OPTICALDISKDRIVER_COLUMN_ID + " = " + id, null);

            if (res.moveToFirst()) {
                String brand = res.getString(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_MODEL));
                String supportedDisk = res.getString(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_SUPPORTEDDISK));
                float powerConsumption = res.getFloat(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_POWERCONSUMPTION));
                float pce = res.getFloat(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_PRICE));
                odd = new OpticalDiskDriver(powerConsumption, pce, brand, model, supportedDisk);
                odd.setIdBanco(res.getInt(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_ID)));
            }

            res.close();
        }
        finally {
            db.close();
        }

        return odd;
    }

    public OpticalDiskDriver getOpticalDiskDriver(float price) {
        OpticalDiskDriver odd = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String stm = SELECT_PART_WITH_PRICE.replace("TABELA", OPTICALDISKDRIVER_TABLE_NAME)
                                                    .replace("COLUNA", OPTICALDISKDRIVER_COLUMN_PRICE)
                                                    .replace("PRICE", Float.toString(price))
                                                    .replace("EXTRA_CONDITIONS", "");

        try {
            Cursor res = db.rawQuery(stm, null);

            if (res.moveToFirst()) {
                String brand = res.getString(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_MODEL));
                String supportedDisk = res.getString(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_SUPPORTEDDISK));
                float powerConsumption = res.getFloat(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_POWERCONSUMPTION));
                float pce = res.getFloat(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_PRICE));
                odd = new OpticalDiskDriver(powerConsumption, pce, brand, model, supportedDisk);
                odd.setIdBanco(res.getInt(res.getColumnIndex(OPTICALDISKDRIVER_COLUMN_ID)));
            }

            res.close();
        } finally {
            db.close();
        }

        return odd;
    }

    // Metodos sobre a tabela de processadores

    public void insertProcessor(String brand, String model, String socket, float powerConsumption, float price, int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(PROCESSOR_COLUMN_BRAND, brand);
            contentValues.put(PROCESSOR_COLUMN_MODEL, model);
            contentValues.put(PROCESSOR_COLUMN_POWERCONSUMPTION, powerConsumption);
            contentValues.put(PROCESSOR_COLUMN_PRICE, price);
            contentValues.put(PROCESSOR_COLUMN_SOCKET, socket);
            contentValues.put(PROCESSOR_COLUMN_SCORE, score);
            db.insert(PROCESSOR_TABLE_NAME, null, contentValues);
        }
        finally {
            db.close();
        }
    }

    public List<Processor> getAllProcessors() {
        List<Processor> processors = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + PROCESSOR_TABLE_NAME, null);
            res.moveToFirst();

            while (!res.isAfterLast()) {
                String brand = res.getString(res.getColumnIndex(PROCESSOR_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(PROCESSOR_COLUMN_MODEL));
                String socket = res.getString(res.getColumnIndex(PROCESSOR_COLUMN_SOCKET));
                float powerConsumption = res.getFloat(res.getColumnIndex(PROCESSOR_COLUMN_POWERCONSUMPTION));
                float price = res.getFloat(res.getColumnIndex(PROCESSOR_COLUMN_PRICE));
                int score = res.getInt(res.getColumnIndex(PROCESSOR_COLUMN_SCORE));
                Processor processor = new Processor(score, price, powerConsumption, socket, model, brand);
                processor.setIdBanco(res.getInt(res.getColumnIndex(PROCESSOR_COLUMN_ID)));
                processors.add(processor);
                res.moveToNext();
            }

            res.close();
        }
        finally {
            db.close();
        }

        return processors;
    }

    public Processor getProcessor(int id) {
        Processor p = null;
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + PROCESSOR_TABLE_NAME + " where " + PROCESSOR_COLUMN_ID + " = " + id, null);

            if (res.moveToFirst()) {
                String brand = res.getString(res.getColumnIndex(PROCESSOR_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(PROCESSOR_COLUMN_MODEL));
                String sckt = res.getString(res.getColumnIndex(PROCESSOR_COLUMN_SOCKET));
                float powerConsumption = res.getFloat(res.getColumnIndex(PROCESSOR_COLUMN_POWERCONSUMPTION));
                float pce = res.getFloat(res.getColumnIndex(PROCESSOR_COLUMN_PRICE));
                int score = res.getInt(res.getColumnIndex(PROCESSOR_COLUMN_SCORE));
                p = new Processor(score, pce, powerConsumption, sckt, model, brand);
                p.setIdBanco(res.getInt(res.getColumnIndex(PROCESSOR_COLUMN_ID)));
            }

            res.close();
        }
        finally {
            db.close();
        }

        return p;
    }

    public Processor getProcessor(float price, String socket) {
        Processor p = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String stm = SELECT_PART_WITH_PRICE.replace("TABELA", PROCESSOR_TABLE_NAME)
                                                .replace("COLUNA", PROCESSOR_COLUMN_PRICE)
                                                .replace("PRICE", Float.toString(price))
                                                .replace("EXTRA_CONDITIONS", " AND " + PROCESSOR_COLUMN_SOCKET + " = " + socket);

        try {
            Cursor res = db.rawQuery(stm, null);

            if (res.moveToFirst()) {
                String brand = res.getString(res.getColumnIndex(PROCESSOR_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(PROCESSOR_COLUMN_MODEL));
                String sckt = res.getString(res.getColumnIndex(PROCESSOR_COLUMN_SOCKET));
                float powerConsumption = res.getFloat(res.getColumnIndex(PROCESSOR_COLUMN_POWERCONSUMPTION));
                float pce = res.getFloat(res.getColumnIndex(PROCESSOR_COLUMN_PRICE));
                int score = res.getInt(res.getColumnIndex(PROCESSOR_COLUMN_SCORE));
                p = new Processor(score, pce, powerConsumption, sckt, model, brand);
                p.setIdBanco(res.getInt(res.getColumnIndex(PROCESSOR_COLUMN_ID)));
            }

            res.close();
        } finally {
            db.close();
        }

        return p;
    }

    // Metodos sobre a tabela de fontes

    public void insertPSU(String brand, String model, float price, int score, float capacity) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(PSU_COLUMN_BRAND, brand);
            contentValues.put(PSU_COLUMN_MODEL, model);
            contentValues.put(PSU_COLUMN_CAPACITY, capacity);
            contentValues.put(PSU_COLUMN_PRICE, price);
            contentValues.put(PSU_COLUMN_SCORE, score);
            db.insert(PSU_TABLE_NAME, null, contentValues);
        }
        finally {
            db.close();
        }
    }

    public List<Psu> getAllPSUs() {
        List<Psu> psus = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + PSU_TABLE_NAME, null);
            res.moveToFirst();

            while (!res.isAfterLast()) {
                String brand = res.getString(res.getColumnIndex(PSU_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(PSU_COLUMN_MODEL));
                int capacity = res.getInt(res.getColumnIndex(PSU_COLUMN_CAPACITY));
                float price = res.getFloat(res.getColumnIndex(PSU_COLUMN_PRICE));
                int score = res.getInt(res.getColumnIndex(PSU_COLUMN_SCORE));
                Psu psu = new Psu(capacity, score, price, model, brand);
                psu.setIdBanco(res.getInt(res.getColumnIndex(PSU_COLUMN_ID)));
                psus.add(psu);
                res.moveToNext();
            }
            res.close();
        }
        finally {
            db.close();
        }

        return psus;
    }

    public Psu getPsu(int id) {
        Psu psu = null;
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + PSU_TABLE_NAME + " where " + PSU_COLUMN_ID + " = " + id, null);

            if (res.moveToFirst()) {
                String brand = res.getString(res.getColumnIndex(PSU_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(PSU_COLUMN_MODEL));
                int capacity = res.getInt(res.getColumnIndex(PSU_COLUMN_CAPACITY));
                float pce = res.getFloat(res.getColumnIndex(PSU_COLUMN_PRICE));
                int score = res.getInt(res.getColumnIndex(PSU_COLUMN_SCORE));
                psu = new Psu(capacity, score, pce, model, brand);
                psu.setIdBanco(res.getInt(res.getColumnIndex(PSU_COLUMN_ID)));
            }

            res.close();
        }
        finally {
            db.close();
        }

        return psu;
    }

    public Psu getPSU(float price) {
        Psu psu = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String stm = SELECT_PART_WITH_PRICE.replace("TABELA", PSU_TABLE_NAME)
                                            .replace("COLUNA", PSU_COLUMN_PRICE)
                                            .replace("PRICE", Float.toString(price))
                                            .replace("EXTRA_CONDITIONS", "");

        try {
            Cursor res = db.rawQuery(stm, null);

            if (res.moveToFirst()) {
                String brand = res.getString(res.getColumnIndex(PSU_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(PSU_COLUMN_MODEL));
                int capacity = res.getInt(res.getColumnIndex(PSU_COLUMN_CAPACITY));
                float pce = res.getFloat(res.getColumnIndex(PSU_COLUMN_PRICE));
                int score = res.getInt(res.getColumnIndex(PSU_COLUMN_SCORE));
                psu = new Psu(capacity, score, pce, model, brand);
                psu.setIdBanco(res.getInt(res.getColumnIndex(PSU_COLUMN_ID)));
            }

            res.close();
        } finally {
            db.close();
        }

        return psu;
    }

    // Metodos sobre a tabela de midias de armazenamento

    public void insertStorage(float price, float powerConsumption, String capacity, String brand, String model) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(STORAGE_COLUMN_BRAND, brand);
            contentValues.put(STORAGE_COLUMN_MODEL, model);
            contentValues.put(STORAGE_COLUMN_CAPACITY, capacity);
            contentValues.put(STORAGE_COLUMN_PRICE, price);
            contentValues.put(STORAGE_COLUMN_POWERCONSUMPTION, powerConsumption);
            db.insert(STORAGE_TABLE_NAME, null, contentValues);
        }
        finally {
            db.close();
        }
    }

    public List<Storage> getAllStorageUnits() {
        List<Storage> units = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + STORAGE_TABLE_NAME, null);
            res.moveToFirst();

            while (!res.isAfterLast()) {
                String brand = res.getString(res.getColumnIndex(STORAGE_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(STORAGE_COLUMN_MODEL));
                String capacity = res.getString(res.getColumnIndex(STORAGE_COLUMN_CAPACITY));
                float price = res.getFloat(res.getColumnIndex(STORAGE_COLUMN_PRICE));
                float powerConsumption = res.getFloat(res.getColumnIndex(STORAGE_COLUMN_POWERCONSUMPTION));
                Storage unit = new Storage(price, powerConsumption, capacity, brand, model);
                unit.setIdBanco(res.getInt(res.getColumnIndex(STORAGE_COLUMN_ID)));
                units.add(unit);
                res.moveToNext();
            }

            res.close();
        }
        finally {
            db.close();
        }

        return units;
    }

    public Storage getStorage(int id) {
        Storage s = null;
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + STORAGE_TABLE_NAME + " where " + STORAGE_COLUMN_ID + " = " + id, null);

            if (res.moveToFirst()) {
                String brand = res.getString(res.getColumnIndex(STORAGE_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(STORAGE_COLUMN_MODEL));
                String capacity = res.getString(res.getColumnIndex(STORAGE_COLUMN_CAPACITY));
                float pce = res.getFloat(res.getColumnIndex(STORAGE_COLUMN_PRICE));
                float powerConsumption = res.getFloat(res.getColumnIndex(STORAGE_COLUMN_POWERCONSUMPTION));
                s = new Storage(pce, powerConsumption, capacity, brand, model);
                s.setIdBanco(res.getInt(res.getColumnIndex(STORAGE_COLUMN_ID)));
            }

            res.close();
        }
        finally {
            db.close();
        }

        return s;
    }

    public Storage getStorage(float price) {
        Storage s = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String stm = SELECT_PART_WITH_PRICE.replace("TABELA", STORAGE_TABLE_NAME)
                                            .replace("COLUNA", STORAGE_COLUMN_PRICE)
                                            .replace("PRICE", Float.toString(price))
                                            .replace("EXTRA_CONDITIONS", "");

        try {
            Cursor res = db.rawQuery(stm, null);

            if (res.moveToFirst()) {
                String brand = res.getString(res.getColumnIndex(STORAGE_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(STORAGE_COLUMN_MODEL));
                String capacity = res.getString(res.getColumnIndex(STORAGE_COLUMN_CAPACITY));
                float pce = res.getFloat(res.getColumnIndex(STORAGE_COLUMN_PRICE));
                float powerConsumption = res.getFloat(res.getColumnIndex(STORAGE_COLUMN_POWERCONSUMPTION));
                s = new Storage(pce, powerConsumption, capacity, brand, model);
                s.setIdBanco(res.getInt(res.getColumnIndex(STORAGE_COLUMN_ID)));
            }

            res.close();
        } finally {
            db.close();
        }

        return s;
    }

    // Metodos sobre a tabela de placas de video

    public void insertVga(int score, String model, String brand, float powerConsumption, float price) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(VGA_COLUMN_BRAND, brand);
            contentValues.put(VGA_COLUMN_MODEL, model);
            contentValues.put(VGA_COLUMN_SCORE, score);
            contentValues.put(VGA_COLUMN_PRICE, price);
            contentValues.put(VGA_COLUMN_POWERCONSUMPTION, powerConsumption);
            db.insert(VGA_TABLE_NAME, null, contentValues);
        }
        finally {
            db.close();
        }
    }

    public List<VideoGraphicsAdapter> getAllVgas() {
        List<VideoGraphicsAdapter> units = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + VGA_TABLE_NAME, null);
            res.moveToFirst();

            while (!res.isAfterLast()) {
                String brand = res.getString(res.getColumnIndex(VGA_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(VGA_COLUMN_MODEL));
                int score = res.getInt(res.getColumnIndex(VGA_COLUMN_SCORE));
                float price = res.getFloat(res.getColumnIndex(VGA_COLUMN_PRICE));
                float powerConsumption = res.getFloat(res.getColumnIndex(VGA_COLUMN_POWERCONSUMPTION));
                VideoGraphicsAdapter unit = new VideoGraphicsAdapter(score, model, brand, powerConsumption, price);
                unit.setIdBanco(res.getInt(res.getColumnIndex(VGA_COLUMN_ID)));
                units.add(unit);
                res.moveToNext();
            }

            res.close();
        } finally {
            db.close();
        }

        return units;
    }

    public VideoGraphicsAdapter getVga(int id) {
        VideoGraphicsAdapter vga = null;
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + VGA_TABLE_NAME + " where " + VGA_COLUMN_ID + " = " + id, null);

            if (res.moveToFirst()) {
                String brand = res.getString(res.getColumnIndex(VGA_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(VGA_COLUMN_MODEL));
                int score = res.getInt(res.getColumnIndex(VGA_COLUMN_SCORE));
                float pce = res.getFloat(res.getColumnIndex(VGA_COLUMN_PRICE));
                float powerConsumption = res.getFloat(res.getColumnIndex(VGA_COLUMN_POWERCONSUMPTION));
                vga = new VideoGraphicsAdapter(score, model, brand, powerConsumption, pce);
                vga.setIdBanco(res.getInt(res.getColumnIndex(VGA_COLUMN_ID)));
            }

            res.close();
        }
        finally {
            db.close();
        }

        return vga;
    }

    public VideoGraphicsAdapter getVga(float price) {
        VideoGraphicsAdapter vga = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String stm = SELECT_PART_WITH_PRICE.replace("TABELA", VGA_TABLE_NAME)
                                            .replace("COLUNA", VGA_COLUMN_PRICE)
                                            .replace("PRICE", Float.toString(price))
                                            .replace("EXTRA_CONDITIONS", "");

        try {
            Cursor res = db.rawQuery(stm, null);

            if (res.moveToFirst()) {
                String brand = res.getString(res.getColumnIndex(VGA_COLUMN_BRAND));
                String model = res.getString(res.getColumnIndex(VGA_COLUMN_MODEL));
                int score = res.getInt(res.getColumnIndex(VGA_COLUMN_SCORE));
                float pce = res.getFloat(res.getColumnIndex(VGA_COLUMN_PRICE));
                float powerConsumption = res.getFloat(res.getColumnIndex(VGA_COLUMN_POWERCONSUMPTION));
                vga = new VideoGraphicsAdapter(score, model, brand, powerConsumption, pce);
                vga.setIdBanco(res.getInt(res.getColumnIndex(VGA_COLUMN_ID)));
            }

            res.close();
        } finally {
            db.close();
        }

        return vga;
    }

    // Metodos sobre a tabela de builds favoritas

    public void insertFavoriteBuild(String name, String date, int moboID, int cpuID, int opDiskDriverID,
                                    int caseID, int psuID, int ramID, int ramCount, int vgaID, int vgaCount,
                                    int storageID, int storageCount) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(FAVORITE_COLUMN_NAME, name);
            contentValues.put(FAVORITE_COLUMN_DATE, date);
            contentValues.put(FAVORITE_COLUMN_MOTHERBOARD_ID, moboID);
            contentValues.put(FAVORITE_COLUMN_PROCESSOR_ID, cpuID);
            contentValues.put(FAVORITE_COLUMN_OPTICALDISKDRIVER_ID, opDiskDriverID);
            contentValues.put(FAVORITE_COLUMN_CASE_ID, caseID);
            contentValues.put(FAVORITE_COLUMN_PSU_ID, psuID);
            contentValues.put(FAVORITE_COLUMN_MAINMEMORY_ID, ramID);
            contentValues.put(FAVORITE_COLUMN_MAINMEMORY_COUNT, ramCount);
            contentValues.put(FAVORITE_COLUMN_VGA_ID, vgaID);
            contentValues.put(FAVORITE_COLUMN_VGA_COUNT, vgaCount);
            contentValues.put(FAVORITE_COLUMN_STORAGE_ID, storageID);
            contentValues.put(FAVORITE_COLUMN_STORAGE_COUNT, storageCount);
            db.insert(FAVORITE_TABLE_NAME, null, contentValues);
        }
        finally {
            db.close();
        }
    }

    public List<FavoriteBuild> getAllFavoriteBuilds() {

        List<FavoriteBuild> favs = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor res = db.rawQuery("select * from " + FAVORITE_TABLE_NAME, null);
            res.moveToFirst();

            while (!res.isAfterLast()) {
                int favId = res.getInt(res.getColumnIndex(FAVORITE_COLUMN_ID));
                String favName = res.getString(res.getColumnIndex(FAVORITE_COLUMN_NAME));
                String date = res.getString(res.getColumnIndex(FAVORITE_COLUMN_DATE));

                // Recupera os ids que referenciam as pecas na base de dados
                int moboId = res.getInt(res.getColumnIndex(FAVORITE_COLUMN_MOTHERBOARD_ID));
                int cpuId = res.getInt(res.getColumnIndex(FAVORITE_COLUMN_PROCESSOR_ID));
                int opDiskDriverID = res.getInt(res.getColumnIndex(FAVORITE_COLUMN_OPTICALDISKDRIVER_ID));
                int caseID = res.getInt(res.getColumnIndex(FAVORITE_COLUMN_CASE_ID));
                int psuID = res.getInt(res.getColumnIndex(FAVORITE_COLUMN_PSU_ID));
                int ramID = res.getInt(res.getColumnIndex(FAVORITE_COLUMN_MAINMEMORY_ID));
                int ramCount = res.getInt(res.getColumnIndex(FAVORITE_COLUMN_MAINMEMORY_COUNT));
                int vgaID = res.getInt(res.getColumnIndex(FAVORITE_COLUMN_VGA_ID));
                int vgaCount = res.getInt(res.getColumnIndex(FAVORITE_COLUMN_VGA_COUNT));
                int storageID = res.getInt(res.getColumnIndex(FAVORITE_COLUMN_STORAGE_ID));
                int storageCount = res.getInt(res.getColumnIndex(FAVORITE_COLUMN_STORAGE_COUNT));

                // Monta a build favorita consultando o banco e recuperando a partir dos IDS
                Computer build = new Computer();

                build.setMotherboard(this.getMotherboard(moboId));
                build.setProcessor(this.getProcessor(cpuId));
                build.setOpticalDiscDriver(this.getOpticalDiskDriver(opDiskDriverID));
                build.setCase(this.getCase(caseID));
                build.setPsu(this.getPsu(psuID));

                // Adiciona o numero de memorias que consta na tabela de favorito
                List<MainMemory> ramSticks = new ArrayList<>();
                for (int i = 0; i < ramCount; i++)
                    ramSticks.add(this.getMainMemory(ramID));
                build.setRamSticks(ramSticks);

                // Adiciona o numero de gpus que consta na tabela de favorito
                List<VideoGraphicsAdapter> gpus = new ArrayList<>();
                for (int i = 0; i < vgaCount; i++)
                    gpus.add(this.getVga(vgaID));
                build.setGpus(gpus);

                // Adiciona o numero de unidades de armazenamento que consta na tabela de favorito
                List<Storage> storageUnits = new ArrayList<>();
                for (int i = 0; i < storageCount; i++)
                    storageUnits.add(this.getStorage(storageID));
                build.setStorageUnits(storageUnits);

                FavoriteBuild fav = new FavoriteBuild(favId, favName, date, build);
            }

            res.close();
        } finally {
            db.close();
        }

        return favs;
    }
}
