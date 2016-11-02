package uva.pcbuilder.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
import uva.pcbuilder.util.DateHelper;

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
    private static final String CASE_TABLE_NAME = "case";
    private static final String CASE_COLUMN_ID = "id";
    private static final String CASE_COLUMN_BRAND = "brand";
    private static final String CASE_COLUMN_NAME = "name";
    private static final String CASE_COLUMN_PRICE = "price";
    private static final String CREATE_TABLE_CASE = "create table if not exists case " +
            "(id integer primary key, brand text, name text, price decimal(19,4))";
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
    private static final String CREATE_TABLE_OPTICALDISKDRIVER = "create disk if not exists optical_disk_driver " +
            "(id integer primary key, brand text, model text, price decimal(19,4), power_consumption float, " +
            "supported_disk text)";
    private static final String DROP_TABLE_OPTICALDISKDRIVER = "drop table if exists optical_disk_driver";

    // Tabela Processor
    private static final String PROCESSOR_TABLE_NAME = "processors";
    private static final String PROCESSOR_COLUMN_ID = "id";
    private static final String PROCESSOR_COLUMN_BRAND = "brand";
    private static final String PROCESSOR_COLUMN_NAME = "name";
    private static final String PROCESSOR_COLUMN_SOCKET = "socket";
    private static final String PROCESSOR_COLUMN_POWERCONSUMPTION = "power_consumption";
    private static final String PROCESSOR_COLUMN_PRICE = "price";
    private static final String PROCESSOR_COLUMN_SCORE = "score";
    private static final String CREATE_TABLE_PROCESSOR = "create table if not exists processors " +
            "(id integer primary key, brand text, name text, socket text, power_consumption float, " +
            "price decimal(19,4), score integer)";
    private static final String DROP_TABLE_PROCESSOR = "drop table if exists processors";

    // Tabela PSU
    private static final String PSU_TABLE_NAME = "psu";
    private static final String PSU_COLUMN_ID = "id";
    private static final String PSU_COLUMN_BRAND = "brand";
    private static final String PSU_COLUMN_NAME = "name";
    private static final String PSU_COLUMN_CAPACITY = "capacity";
    private static final String PSU_COLUMN_PRICE = "price";
    private static final String PSU_COLUMN_SCORE = "score";
    private static final String CREATE_TABLE_PSU = "create table if not exists psu " +
            "(id integer primary key, brand text, name text, price decimal(19,4), score integer, capacity int)";
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
    private static final String VGA_COLUMN_NAME = "name";
    private static final String VGA_COLUMN_POWERCONSUMPTION = "power_consumption";
    private static final String VGA_COLUMN_PRICE = "price";
    private static final String VGA_COLUMN_SCORE = "score";
    private static final String CREATE_TABLE_VGA = "create table if not exists vga " +
            "(id integer primary key, brand text, name text, power_consumption float, " +
            "price decimal(19,4), score integer)";
    private static final String DROP_TABLE_VGA = "drop table if exists vga";

    // Tabela de builds favoritas do usuario
    private static final String FAVORITE_BUILDS = "favorite_builds";
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
            }

            res.close();
        } finally {
            db.close();
        }

        return m;
    }

    // Metodos sobre a tabela de gabinetes

    public void insertCase(String brand, String name, float price) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(CASE_COLUMN_BRAND, brand);
            contentValues.put(CASE_COLUMN_NAME, name);
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
                String name = res.getString(res.getColumnIndex(CASE_COLUMN_NAME));
                Case c = new Case(price, name, brand);
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

    public Case getCase(float price) {
        Case c = null;
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

    public MainMemory getMainMemory(float price) {
        MainMemory mm = null;
        return mm;
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

    public OpticalDiskDriver getOpticalDiskDriver(float price) {
        OpticalDiskDriver opticalDiskDriver = null;
        return opticalDiskDriver;
    }

    // Metodos sobre a tabela de processadores

    public void insertProcessor(String brand, String name, String socket, float powerConsumption, float price, int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(PROCESSOR_COLUMN_BRAND, brand);
            contentValues.put(PROCESSOR_COLUMN_NAME, name);
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
                String name = res.getString(res.getColumnIndex(PROCESSOR_COLUMN_NAME));
                String socket = res.getString(res.getColumnIndex(PROCESSOR_COLUMN_SOCKET));
                float powerConsumption = res.getFloat(res.getColumnIndex(PROCESSOR_COLUMN_POWERCONSUMPTION));
                float price = res.getFloat(res.getColumnIndex(PROCESSOR_COLUMN_PRICE));
                int score = res.getInt(res.getColumnIndex(PROCESSOR_COLUMN_SCORE));
                Processor processor = new Processor(score, price, powerConsumption, socket, name, brand);
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

    public Processor getProcessor(float price) {
        Processor processor = null;
        return processor;
    }

    // Metodos sobre a tabela de fontes

    public void insertPSU(String brand, String name, float price, int score, float capacity) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(PSU_COLUMN_BRAND, brand);
            contentValues.put(PSU_COLUMN_NAME, name);
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
                String name = res.getString(res.getColumnIndex(PSU_COLUMN_NAME));
                int capacity = res.getInt(res.getColumnIndex(PSU_COLUMN_CAPACITY));
                float price = res.getFloat(res.getColumnIndex(PSU_COLUMN_PRICE));
                int score = res.getInt(res.getColumnIndex(PSU_COLUMN_SCORE));
                Psu psu = new Psu(capacity, score, price, name, brand);
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

    public Psu getPSU(float price) {
        Psu psu = null;
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

    public Storage getStorage(float price) {
        Storage s = null;
        return s;
    }

    // Metodos sobre a tabela de placas de video

    public void insertVga(int score, String name, String brand, float powerConsumption, float price) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(VGA_COLUMN_BRAND, brand);
            contentValues.put(VGA_COLUMN_NAME, name);
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
                String name = res.getString(res.getColumnIndex(VGA_COLUMN_NAME));
                int score = res.getInt(res.getColumnIndex(VGA_COLUMN_SCORE));
                float price = res.getFloat(res.getColumnIndex(VGA_COLUMN_PRICE));
                float powerConsumption = res.getFloat(res.getColumnIndex(VGA_COLUMN_POWERCONSUMPTION));
                VideoGraphicsAdapter unit = new VideoGraphicsAdapter(score, name, brand, powerConsumption, price);
                units.add(unit);
                res.moveToNext();
            }

            res.close();
        } finally {
            db.close();
        }

        return units;
    }

    public VideoGraphicsAdapter getVga(float price) {
        VideoGraphicsAdapter vga = null;
        return vga;
    }

    // Metodos sobre a tabela de builds favoritas

    public void insertFavoriteBuild(/*parameters*/) {

    }

    public List<FavoriteBuild> getAllFavoriteBuilds() {
        List<FavoriteBuild> builds = new ArrayList<>();
        if (builds.isEmpty()) {
            Computer c1 = new Computer();
            FavoriteBuild f1 = new FavoriteBuild(123, "Exemplo 1", "05/03/1995", c1);

            Computer c2 = new Computer();
            FavoriteBuild f2 = new FavoriteBuild(456, "Exemplo 2", DateHelper.nowString(), c2);

            builds.add(f1);
            builds.add(f2);
        }
        return builds;
    }
}
