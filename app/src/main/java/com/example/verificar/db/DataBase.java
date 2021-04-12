package com.example.verificar.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.verificar.models.CarModel;
import com.example.verificar.models.PersonModel;
import com.example.verificar.pages.SelectCarPage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    public static final String PERSON_ACCOUNT_TABLE = "PERSON_ACCOUNT_TABLE";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_NUME = "NUME";
    public static final String COLUMN_PRENUME = "PRENUME";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_CNP = "CNP";
    public static final String COLUMN_SERIE = "SERIE";
    public static final String COLUMN_NR_BULETIN = "NR_BULETIN";
    public static final String COLUMN_ADRESA = "ADRESA";
    public static final String COLUMN_TELEFON = "TELEFON";
    public static final String COLUMN_DATA_PERMIS = "DATA_PERMIS";
    public static final String CAR_TABLE = "CAR_TABLE";
    public static final String COLUMN_SERIE_SASIU = "SERIE_SASIU";
    public static final String COLUMN_NUME_PROPIETAR = "NUME_PROPIETAR";
    public static final String COLUMN_USER_FOR_CAR = "USER_NAME";
    public static final String COLUMN_PRENUME_PROPIETAR = "PRENUME_PROPIETAR";
    public static final String COLUMN_MODEL_AUTO = "MODEL_AUTO";
    public static final String COLUMN_CATEGORIE_AUTO = "CATEGORIE_AUTO";
    public static final String COLUMN_CM3 = "CM3";
    public static final String COLUMN_CAI_PUTERE = "CAI_PUTERE";
    public static final String COLUMN_MASA = "MASA";
    public static final String COLUMN_SERIE_CIV = "SERIE_CIV";
    public static final String COLUMN_TIP_COMBUSTIBIL = "TIP_COMBUSTIBIL";
    public static final String COLUMN_AN_FABRICATIE = "AN_FABRICATIE";
    public static final String COLUMN_HAS_RCA = "HAS_RCA";


    public DataBase(@Nullable Context context) {
        super(context, "verificar.db", null, 1);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        String createPersonTableStatement = "CREATE TABLE " + PERSON_ACCOUNT_TABLE + " (" + COLUMN_USER_NAME + " TEXT PRIMARY KEY, " + COLUMN_PASSWORD + " TEXT, " + COLUMN_NUME + " TEXT, " + COLUMN_PRENUME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " + COLUMN_CNP + " TEXT, " + COLUMN_SERIE + " TEXT, " + COLUMN_NR_BULETIN + " INTEGER, " + COLUMN_ADRESA + " TEXT, " + COLUMN_TELEFON + " INTEGER, " + COLUMN_DATA_PERMIS + " TEXT)";

        String createCarTableStatement = "CREATE TABLE " + CAR_TABLE + " (" + COLUMN_SERIE_SASIU + " TEXT PRIMARY KEY, " + COLUMN_USER_FOR_CAR + " TEXT, " + COLUMN_NUME_PROPIETAR + " TEXT, " + COLUMN_PRENUME_PROPIETAR + " TEXT, " + COLUMN_MODEL_AUTO + " TEXT, " +
                COLUMN_CATEGORIE_AUTO + " TEXT, " + COLUMN_CM3 + " INTEGER, " + COLUMN_CAI_PUTERE + " INTEGER, " + COLUMN_MASA + " FLOAT, " + COLUMN_SERIE_CIV + " TEXT, " + COLUMN_TIP_COMBUSTIBIL + " TEXT, " + COLUMN_AN_FABRICATIE + " INTEGER, " + COLUMN_HAS_RCA + " INTEGER)";
        db.execSQL(createPersonTableStatement);
        db.execSQL(createCarTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void deleteAllItemsFromTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM PERSON_ACCOUNT_TABLE");
    }

    public boolean addCar(CarModel car){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_SERIE_SASIU, car.getSeriseSasiu());
        cv.put(COLUMN_USER_FOR_CAR, car.getUsername());
        cv.put(COLUMN_NUME_PROPIETAR, car.getNumePropietar());
        cv.put(COLUMN_PRENUME_PROPIETAR, car.getPrenumePropietar());
        cv.put(COLUMN_MODEL_AUTO,car.getModelAuto());
        cv.put(COLUMN_CATEGORIE_AUTO,car.getCategorieAuto());
        cv.put(COLUMN_CM3, car.getCm3());
        cv.put(COLUMN_CAI_PUTERE, car.getCaiPutere());
        cv.put(COLUMN_MASA, car.getMasa());
        cv.put(COLUMN_SERIE_CIV,car.getSerieCiv());
        cv.put(COLUMN_TIP_COMBUSTIBIL, car.getTipCombustibil());
        cv.put(COLUMN_AN_FABRICATIE, car.getAnFabricatie());
        cv.put(COLUMN_HAS_RCA, car.hasRCA());

        long insert = db.insert(CAR_TABLE,null,cv);
        return insert != -1;
    }
    public boolean addPersonAccount(PersonModel personModel){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USER_NAME,personModel.getUserName());
        cv.put(COLUMN_PASSWORD,personModel.getPassword());
        cv.put(COLUMN_NUME,personModel.getNume());
        cv.put(COLUMN_PRENUME,personModel.getPrenume());
        cv.put(COLUMN_EMAIL,personModel.getEmail());
        cv.put(COLUMN_CNP,personModel.getCNP());
        cv.put(COLUMN_SERIE,personModel.getKZ());
        cv.put(COLUMN_NR_BULETIN,personModel.getNrBuletin());
        cv.put(COLUMN_ADRESA,personModel.getAdresa());
        cv.put(COLUMN_TELEFON,personModel.getTelefon());
        cv.put(COLUMN_DATA_PERMIS,personModel.getDataPermis().toString());

        long insert = db.insert(PERSON_ACCOUNT_TABLE, null, cv);

        return insert != -1;
    }

    public boolean checkUserName(String user){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + PERSON_ACCOUNT_TABLE + " where " + COLUMN_USER_NAME + " = ?",new String[] {user});
        //cursor.close();
        return cursor.getCount() != 0;
    }

    public boolean checkUserNamePassword(String user, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + PERSON_ACCOUNT_TABLE + " where " + COLUMN_USER_NAME + " = ? and " + COLUMN_PASSWORD + " = ?",new String[]{user,pass});
        //cursor.close();
        return cursor.getCount() > 0;
    }

    public List<CarModel> getAllCars(){
        List<CarModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + CAR_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor.moveToFirst()){
            do{
                String serieSasiu = cursor.getString(0);
                Log.i("CREATION",serieSasiu);
                String userName = cursor.getString(1);
                Log.i("CREATION2",userName);
                String numePropietar = cursor.getString(2);
                Log.i("CREATION3",numePropietar);
                String prenumePropietar = cursor.getString(3);
                Log.i("CREATION5",prenumePropietar);
                String modelAuto = cursor.getString(4);
                Log.i("CREATION6",modelAuto);
                String categorieAuto = cursor.getString(5);
                Log.i("CREATION7",categorieAuto);
                int cm3 = cursor.getInt(6);
                Log.i("CREATION8",String.valueOf(cm3));
                int caiPutere = cursor.getInt(7);
                Log.i("CREATION9",String.valueOf(caiPutere));
                float masa = cursor.getFloat(8);
                Log.i("CREATION10",String.valueOf(masa));
                String serieCIV = cursor.getString(9);
                Log.i("CREATION11",serieCIV);
                String tipCombustibil = cursor.getString(10);
                Log.i("CREATION12",tipCombustibil);
                int anFabricatie = cursor.getInt(11);
                CarModel car = new CarModel(userName,numePropietar,prenumePropietar,modelAuto,categorieAuto,serieSasiu,cm3,caiPutere,masa,serieCIV,tipCombustibil,anFabricatie);
                returnList.add(car);
                Log.i("CREATION13",String.valueOf(anFabricatie));
            } while(cursor.moveToNext());
        }
        //cursor.close();
        return returnList;
    }
}
