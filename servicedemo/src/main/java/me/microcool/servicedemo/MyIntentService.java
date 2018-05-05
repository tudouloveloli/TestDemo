package me.microcool.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by gaoshiwei on 2017/11/8.
 */

public class MyIntentService extends IntentService {

    private static final String TAG = "MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.d(TAG, "onHandleIntent: " + Thread.currentThread().getName());

    }

    /**
     * 这个服务在运行结束后应该是会自动结束的。(IntentService 的特性)
     * 之所以重写onDestory()方法是为了以证实服务是不是真的停掉了。
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
