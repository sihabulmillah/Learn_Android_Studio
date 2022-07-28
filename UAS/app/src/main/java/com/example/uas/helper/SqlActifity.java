package com.example.uas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqlActifity extends SQLiteOpenHelper {
//    Membuat table user
    public static final String TABLE_USER = "user";
    public static final String COLUMN_USER_ID = "id";
    public static final String COLUMN_USER_USERNAME = "username";
    public static final String COLUMN_USER_PASSWORD = "password";

//  Membari nama dan versi databases
    private static final String DATABASES_NAME = "Uas.db";
    private static final int DATABASES_VERSION = 1;

    public SqlActifity(Context context){ super(context, DATABASES_NAME, null, DATABASES_VERSION); }

    private static final String CREATE_TABLE_USER = " CREATE TABLE " + TABLE_USER + " ( " + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_USER_USERNAME + " TEXT NOT NULL, " + COLUMN_USER_PASSWORD + " TEXT NOT NULL " + " ) ";

    private static SqlActifity singletonInstance;

    public static synchronized SqlActifity getInstance(Context context){
        if(singletonInstance == null){
            singletonInstance = new SqlActifity(context.getApplicationContext());
        }
        return singletonInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_USER);
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);

        sqLiteDatabase.execSQL(
                " INSERT INTO " + TABLE_USER + "(" + COLUMN_USER_USERNAME + ", "
                        +COLUMN_USER_PASSWORD  + ")VALUES('Sihabul_Millah','al-ansor10')"
        );

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int ex, int baru) {
        Log.w(SqlActifity.class.getName(),
                "upgrading databases from version " + ex + " to " +  baru + " which will destroy all old data");
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(sqLiteDatabase);
    }
}
