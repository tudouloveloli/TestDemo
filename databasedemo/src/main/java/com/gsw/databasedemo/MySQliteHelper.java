package com.gsw.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * @author gaoshiwei
 * @date 2017/12/7
 */

public class MySQliteHelper extends SQLiteOpenHelper {
    private static final String TAG = "MySQliteHelper";

    private Context mContext;
    // create table book
    private static final String TABLE_BOOK = "create table Book(" +
            "id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "pages integer" +
            "name text" +
            ")";

    private static final String TABLE_CATEGORY = "CREATE TABLE category (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "category_name TEXT," +
            "category_code INTEGER" +
            ")";


    public MySQliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_BOOK);
        db.execSQL(TABLE_CATEGORY);
        Toast.makeText(mContext, "onCreate table success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
}
