package com.ed.iu.saif.smartaquarium_20;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DBhelper extends SQLiteOpenHelper {

    int i=0;

    public static List<ListItem> listItems;
    public DBhelper(Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "FEED_TIME.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE FEED(ID INTEGER PRIMARY KEY AUTOINCREMENT,TIME TEXT,DAY INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS FEED_TIME;");
        onCreate(db);
    }

    public void insert(String time,int day){
        ContentValues contentValues = new ContentValues();
        contentValues.put("TIME",time);
        contentValues.put("DAY",day);
        this.getWritableDatabase().insertOrThrow("FEED","",contentValues);
    }

    public void delete(int id){
        this.getWritableDatabase().delete("FEED","ID='"+id+"'",null);
    }



    public void showValues(){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM FEED",null);
        listItems=new ArrayList<>();
        String time;
        int days;
        int id;
        while (cursor.moveToNext()) {
            time=cursor.getString(1);
            id=cursor.getInt(0);
            days=cursor.getInt(2);
            ListItem item = new ListItem(id,time,days);
            listItems.add(item);


        }
    }



}
