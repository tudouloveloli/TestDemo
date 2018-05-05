package me.microcool.broadcastdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import me.microcool.broadcastdemo.util.ActivityControl;

/**
 * @author gaoshiwei
 * @date 2018/1/3
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract int layoutID();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutID());
        ActivityControl.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityControl.removeActivity(this);
    }
}
