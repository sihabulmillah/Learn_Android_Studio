package com.example.sqlite.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.security.PrivateKey;


public class SqlActifity extends SQLiteOpenHelper {

    public static final String TABLE_PESERTA = "peserta";
    public static final String COLUMN_PESERTA_ID = "id";
    public static final String COLUMN_PESERTA_NIP = "nip";
    public static final String COLUMN_PESERTA_NAMA = "nama";
    public static final String COLUMN_PESERTA_EMAIL = "email";
    public static final String COLUMN_PESERTA_INSTANSI = "instansi";

    private static final String DATABASES_NAME = "My.db";
    private static final int DATABASES_VERSION = 1;

    public SqlActifity(Context context) {
        super(context, DATABASES_NAME, null, DATABASES_VERSION);
    }

    private static final String CREATE_TABLE_PESERTA = "CREATE TABLE " + TABLE_PESERTA + " ( "+ COLUMN_PESERTA_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PESERTA_NIP + " TEXT NOT NULL, "+ COLUMN_PESERTA_NAMA +
            " TEXT NOT NULL, "+COLUMN_PESERTA_EMAIL + " TEXT NOT NULL, "+ COLUMN_PESERTA_INSTANSI + " TEXT NOT NULL " + " ) ";
    private static SqlActifity singletonInstance;

    public static synchronized SqlActifity getInstance(Context context){
        if(singletonInstance == null){
            singletonInstance = new SqlActifity(context.getApplicationContext());
        }
        return singletonInstance;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_PESERTA);
        sqLiteDatabase.execSQL(CREATE_TABLE_PESERTA);

        sqLiteDatabase.execSQL(
                " INSERT INTO " + TABLE_PESERTA + "(" + COLUMN_PESERTA_NIP + ", "+COLUMN_PESERTA_NAMA + ", "+COLUMN_PESERTA_EMAIL+
                        ", " + COLUMN_PESERTA_INSTANSI + ")VALUES('142325','ujangin','ujang@gmail.com','Pesantren PeTIK')"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int lama, int baru) {
        Log.w(SqlActifity.class.getName(),
        "upgrading database from version " + lama + " to " + baru + " which will destroy all old data");
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_PESERTA);
        onCreate(sqLiteDatabase);
    }
}
