package com.gsw.layoutdemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gsw.layoutdemo.gridview.GridViewActivity;

/**
 * @author gaoshiwei
 */
public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, GridViewActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}
