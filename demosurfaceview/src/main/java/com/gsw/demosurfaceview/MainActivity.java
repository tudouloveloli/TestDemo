package com.gsw.demosurfaceview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @author gaoshiwei
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SimpleDraw(this));
    }
}
