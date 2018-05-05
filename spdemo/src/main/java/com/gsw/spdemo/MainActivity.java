package com.gsw.spdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.HashSet;
import java.util.Set;

/**
 * SP Demo
 * 值得注意的地方 ：
 * 存和取的操作都需要sp对象，且获得sp对象的方式保持一致(3中方式选1种) 其实一个sp对象想足够了。这里只是为了演示demo
 * <p>
 * 存 ： 使用SharedPreferences.Editor 对象来put数据。 sp.edit(); 来获取edit对象。 最后使用apply 或者commit
 * 取 ： 使用的是sp对象的getXXX方法。
 *
 * @author gaoshiwei
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    Button btnWrite;
    Button btnRead;
    Button btnLogin;

    SharedPreferences sp1;
    SharedPreferences sp2;
    SharedPreferences sp3;
    // set
    Set<String> hs = new HashSet<>();

    {
        hs.add("Tudou Learn");
        hs.add("Java");
        hs.add("C++");
        hs.add("C");
        hs.add("Python");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSP();
        btnWrite = (Button) findViewById(R.id.btn_writeData);
        btnRead = (Button) findViewById(R.id.btn_readData);
        btnLogin= (Button) findViewById(R.id.btn_login);
        btnWrite.setOnClickListener(v -> testWriteSP());
        btnRead.setOnClickListener(v -> testReadSP());
        btnLogin.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });

    }

    /**
     * getSP
     */
    public void getSP() {
        //SP文件在 data/data/<package name>/shared_prefs/ 目录下。是一个xml文件。

        //第一种获取SP对象的方式。
        sp1 = getSharedPreferences("test", MODE_PRIVATE);
        // 第二种获取SP对象的方式
        sp2 = getPreferences(MODE_PRIVATE);
        // 第三种获取SP对象的方式
        sp3 = PreferenceManager.getDefaultSharedPreferences(this);
    }

    /**
     * 写入数据到SP
     */
    private void testWriteSP() {
        // 写入数据演示只是为了记录学习笔记。
        // 就用sp2 这个对象了。
        SharedPreferences.Editor edit = sp2.edit();
        // puXXX(key,value);
        edit.putInt("intType", 1);
        edit.putFloat("floatType", 2.1F);
        edit.putLong("LongType", 111111111);
        edit.putBoolean("BooleanType", false);
        edit.putString("StringType", "Hello,Tudou");
        edit.putStringSet("StringSet", hs);

        Boolean isSuccess = edit.commit();
        if (isSuccess) {
            Log.d(TAG, "testWriteSP: Success");
        } else {
            Log.d(TAG, "testWriteSP: Fail");
        }
    }

    /**
     * 从SP读取数据
     */

    private void testReadSP() {
        // 获取到SharedPreferences 对象后.进行一系列的get方法了。
        // 注意，这里如果你使用getSharedPreferences("test", MODE_PRIVATE); ——>肯定是找不到的。
        // 存和取数据， 获取SP对象的方式保持一致。
        SharedPreferences readsp = getPreferences(MODE_PRIVATE);
        if (readsp == null) {
            return;
        }
        // getXXX(key,defValue);
        int intType = readsp.getInt("intType", 0);
        float floatType = readsp.getFloat("floatType", 0.0F);
        long longType = readsp.getLong("LongType", 0);
        Boolean BooleanType = readsp.getBoolean("BooleanType", false);
        String StringType = readsp.getString("StringType", "");
        Set StringSet = readsp.getStringSet("StringSet", new HashSet<String>());
        Log.d(TAG, "testReadSP: "
                + intType
                + "\n"
                + floatType
                + "\n"
                + longType
                + "\n"
                + BooleanType
                + "\n"
                + StringType
        );

        for (Object setItem : StringSet) {
            Log.d(TAG, "StringSetItem: "
                    + ","
                    + setItem
                    + ",");
        }

    }


}
