package com.gsw.qrdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author gaoshiwei
 * @date 2017/12/11
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract int layoutID();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutID());
    }
}
