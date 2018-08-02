package com.example.lenovo2.ornekveritabani;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Veritabani extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="ornek_veritabani";
    private static final String TABLE_NAME="ornek_tablosu";
    private static final int DATABASE_VERSION=1;

    private static final String AD="ad";
    private static final String SOYAD="soyad";
    private static final String ID="id";

    public Veritabani(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String tablo_olustur;

        tablo_olustur="CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+AD+" TEXT,"+ SOYAD+" TEXT);";

        db.execSQL(tablo_olustur);

    }

    public long KayitEkle(String ad,String soyad){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(AD,ad);
        cv.put(SOYAD,soyad);
        long id=db.insert(TABLE_NAME, null,cv);

        db.close();

        return id;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public List<String> KayitListele() {

        SQLiteDatabase db=this.getReadableDatabase();

        String [] sutunlar=new String[]{AD,SOYAD};

        Cursor c=db.query(TABLE_NAME,sutunlar,null,null,null,null,null);

        int adsirano=c.getColumnIndex(AD);
        int soysirano=c.getColumnIndex(SOYAD);


        List<String> kayit_list=new ArrayList<String>();

        for (c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            String s=c.getString(adsirano)+" "+c.getString(soysirano)+"\n";
            kayit_list.add(s);
        }

        db.close();


        return kayit_list;
    }
}
