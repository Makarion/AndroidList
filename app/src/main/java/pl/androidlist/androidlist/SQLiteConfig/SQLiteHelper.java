package pl.androidlist.androidlist.SQLiteConfig;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Makarion on 2018-11-21.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String departureDate, String returnDate, String price, String location,  byte[] image){
        SQLiteDatabase database = getWritableDatabase();

        String sql = "INSERT INTO TRIPS VALUES (NULL,?,?,?,?,?)";
        SQLiteStatement statement= database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, departureDate);
        statement.bindString(2,returnDate);
        statement.bindString(3, price);
        statement.bindString(4, location);
        statement.bindBlob(5, image);
        statement.executeInsert();
    }

    public void updateData(String departureDate, String returnDate, String price, String location, byte[] image, int id){
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE TRIPS SET departureDate=?, returnDate=?, price=?, location=?, image=? WHERE id=? ";
        SQLiteStatement statement= database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, departureDate);
        statement.bindString(2,returnDate);
        statement.bindString(3, price);
        statement.bindString(4, location);
        statement.bindBlob(5, image);
        statement.bindDouble(6,(double)id);

        statement.executeInsert();
        database.close();
    }

    public void daleteData(int id){
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM TRIPS WHERE id=? ";
        SQLiteStatement statement= database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
