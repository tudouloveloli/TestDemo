package com.gsw.databasedemo;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gsw.databasedemo.bo.Book;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

/**
 * @author gaoshiwei
 * @date 2017/12/8
 */

public class LitepalActivity extends AppCompatActivity {
    private static final String TAG = "LitepalActivity";
    Button mBtnDB;
    Button mBtnADD;
    Button mBtnQuery;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_litepal);
        mBtnDB = (Button) findViewById(R.id.btn_create_db);
        mBtnADD = (Button) findViewById(R.id.add_data);
        mBtnQuery = (Button) findViewById(R.id.query_data);
        mBtnDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = LitePal.getDatabase();
                Log.d(TAG, "create database: ");
            }
        });

        mBtnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPage(454);
                book.setPrice(16.96);
                book.save();
                Log.d(TAG, "add data: ");

            }
        });
        mBtnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
}
