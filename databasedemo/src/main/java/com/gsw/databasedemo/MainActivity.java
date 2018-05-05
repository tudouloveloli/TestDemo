package com.gsw.databasedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author gaoshiwei
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    SQLiteDatabase sqLiteDatabase;
    Button mBtnCreateDB;
    MySQliteHelper dbHelper;
    Button mBtnAdd;
    Button mBtnUpdate;
    Button mBtnDelete;
    Button mBtnSelect;
    String bookInfo;
    TextView displayData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MySQliteHelper(MainActivity.this, "BookStore.db", null, 6);
        displayData = (TextView) findViewById(R.id.tv_display_data);
        mBtnCreateDB = (Button) findViewById(R.id.btn_create_db);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnUpdate = (Button) findViewById(R.id.btn_update);
        mBtnDelete = (Button) findViewById(R.id.btn_delete);
        mBtnSelect = (Button) findViewById(R.id.btn_select);
        // create db
        mBtnCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase = dbHelper.getWritableDatabase();
            }
        });
        // add data
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "Java");
                values.put("author", "Dan Brown");
                values.put("pages", 100);
                values.put("price", 16.96);
                sqLiteDatabase.insert("Book", null, values);
                Log.d(TAG, "插入数据成功：");

            }
        });
        // update data
        mBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 2200);
                sqLiteDatabase.update("Book", values, "name = ?", new String[]{"Java"});
            }
        });
        // delete data
        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase = dbHelper.getWritableDatabase();
                sqLiteDatabase.delete("Book", "pages > ?", new String[]{"200"});
            }
        });
        // select data
        mBtnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase = dbHelper.getWritableDatabase();
                Cursor cursor = sqLiteDatabase.query("Book", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getColumnIndex("price");
                        Log.d(TAG, "name: " + name);
                        Log.d(TAG, "author: " + author);
                        Log.d(TAG, "pages: " + pages);
                        Log.d(TAG, "price: " + price);
//                        bookInfo = "name+author+pages+price";
//                        displayData.setText(bookInfo);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });


    }
}
