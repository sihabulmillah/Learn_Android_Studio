package com.example.uas.model;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.uas.helper.SqlActifity;

import java.util.ArrayList;
import java.util.List;

public class DAOUser {
    private SqlActifity dbhelper;
    private SQLiteDatabase databases;

    public DAOUser(Context context) {
        dbhelper = new SqlActifity(context);
    }

    public void open() throws SQLException {
        databases = dbhelper.getWritableDatabase();
    }

    public void closes() {
        dbhelper.close();
    }

    private String[] semua_colom = {
            SqlActifity.COLUMN_USER_ID,
            SqlActifity.COLUMN_USER_USERNAME,
            SqlActifity.COLUMN_USER_PASSWORD
    };

    private Login cursorToLogin(Cursor cursor) {
        Login user = new Login();
        user.setId(cursor.getLong(0));
        user.setUsername(cursor.getString(1));
        user.setPassword(cursor.getString(2));
        return user;
    }

    public List<Login> getAll() {
        List<Login> data = new ArrayList<Login>();
        Cursor cursor = databases.query(SqlActifity.TABLE_USER, semua_colom, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Login user = cursorToLogin(cursor);
            data.add(user);
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    //query select
    public Login findByUsername(String username) {
        Cursor cursor = databases.query(SqlActifity.TABLE_USER, semua_colom, SqlActifity.COLUMN_USER_USERNAME +
                " = " + username, null, null, null, null);

        cursor.moveToFirst();
        Login user = cursorToLogin(cursor);
        cursor.close();
        return user;

    }

    public Boolean checkUser(String user, String pass) {
        String[] colum = {SqlActifity.COLUMN_USER_ID};
        databases = dbhelper.getReadableDatabase();
        String  selection = SqlActifity.COLUMN_USER_USERNAME + "=?" + " and " + SqlActifity.COLUMN_USER_PASSWORD + " =? ";
        String[] selectionArg = {user,pass};
        Cursor cursor = databases.query(SqlActifity.TABLE_USER,colum, selection, selectionArg,null,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        databases.close();

        if(count>0){
            return true;
        }
        else
            return false;
    }


}


