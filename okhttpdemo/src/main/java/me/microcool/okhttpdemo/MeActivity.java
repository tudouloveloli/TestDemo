package me.microcool.okhttpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;

import okhttp3.OkHttpClient;

public class MeActivity extends BaseActivity {

    private static final String TAG = "ShiweiGao";
    OkHttpClient client;

    @Override
    public int layoutID() {
        return R.layout.layout_me;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {

    }
}