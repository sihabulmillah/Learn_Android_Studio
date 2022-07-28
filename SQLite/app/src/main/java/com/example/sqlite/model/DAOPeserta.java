package com.example.sqlite.model;

import static com.example.sqlite.helper.SqlActifity.COLUMN_PESERTA_ID;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

import com.example.sqlite.helper.SqlActifity;

import java.util.ArrayList;
import java.util.List;

public class DAOPeserta {
    private SQLiteDatabase database;
    private SqlActifity dbhelper;

    public DAOPeserta(Context context){
        dbhelper = new SqlActifity(context);
    }


    public void open() throws SQLException{
        database = dbhelper.getWritableDatabase();
    }
    public void closes(){
        dbhelper.close();
    }

    private String[] all_column = {
            SqlActifity.COLUMN_PESERTA_ID,
            SqlActifity.COLUMN_PESERTA_NIP,
            SqlActifity.COLUMN_PESERTA_NAMA,
            SqlActifity.COLUMN_PESERTA_EMAIL,
            SqlActifity.COLUMN_PESERTA_INSTANSI
    };

    private Peserta cursorToPeserta(Cursor cursor){
        Peserta obj = new Peserta();
        obj.setId(cursor.getLong(0));
        obj.setNIP(cursor.getString(1));
        obj.setNama(cursor.getString(2));
        obj.setEmail(cursor.getString(3));
        obj.setInstansi(cursor.getString(4));
        return obj;
    }

    public List<Peserta> getAll(){
        List<Peserta> list = new ArrayList<Peserta>();
        Cursor cursor = database.query(SqlActifity.TABLE_PESERTA, all_column,null,null,null,null,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Peserta obj = cursorToPeserta(cursor);
            list.add(obj);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    //query select
    public Peserta findByNIP(String nip){
        Cursor cursor = database.query(SqlActifity.TABLE_PESERTA,all_column,SqlActifity.COLUMN_PESERTA_NIP+
                " = " + nip,null,null,null,null);

        cursor.moveToFirst();
        Peserta obj = cursorToPeserta(cursor);
        cursor.close();
        return obj;
    }
    //query insert
    public void save(Peserta obj){
        database = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SqlActifity.COLUMN_PESERTA_NIP, obj.getNIP());
        values.put(SqlActifity.COLUMN_PESERTA_NAMA, obj.getNama());
        values.put(SqlActifity.COLUMN_PESERTA_EMAIL, obj.getEmail());
        values.put(SqlActifity.COLUMN_PESERTA_INSTANSI, obj.getInstansi());

        database.insert(SqlActifity.TABLE_PESERTA,null,values);
    }

    //query update
    public void update(Peserta obj){
        database = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SqlActifity.COLUMN_PESERTA_NIP, obj.getNIP());
        values.put(SqlActifity.COLUMN_PESERTA_NAMA, obj.getNama());
        values.put(SqlActifity.COLUMN_PESERTA_EMAIL, obj.getEmail());
        values.put(SqlActifity.COLUMN_PESERTA_INSTANSI, obj.getInstansi());

        database.update(SqlActifity.TABLE_PESERTA, values, COLUMN_PESERTA_ID + "=?" ,
                new String[]{String.valueOf(obj.getId())
        });

    }

    //query delete
    public void delete(Peserta obj){
        database = dbhelper.getWritableDatabase();

        database.delete(SqlActifity.TABLE_PESERTA, COLUMN_PESERTA_ID + "=?" , new String[]{
                String.valueOf(obj.getId())
        });
    }
}
