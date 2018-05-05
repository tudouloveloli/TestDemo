package com.gsw.leakcanarydemo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * @author gaoshiwei
 * @date 2017/12/4
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
    }
}
