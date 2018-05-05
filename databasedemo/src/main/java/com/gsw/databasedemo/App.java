package com.gsw.databasedemo;

import android.app.Application;

import org.litepal.LitePal;

/**
 * @author gaoshiwei
 * @date 2017/12/8
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
