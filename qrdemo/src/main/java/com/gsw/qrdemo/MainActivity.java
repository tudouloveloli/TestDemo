package com.gsw.qrdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author gaoshiwei
 */
public class MainActivity extends BaseActivity {
    private Button btnMe;
    private Button btnQR;

    @Override
    public int layoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnMe = (Button) findViewById(R.id.btn_about);
        btnQR = (Button) findViewById(R.id.btn_qr);
        btnMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MeActivity.class));
            }
        });
        btnQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QRActivity.class));
            }
        });
    }
}
