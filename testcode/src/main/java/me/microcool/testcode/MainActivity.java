package me.microcool.testcode;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * @author gaoshiwei
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SharedPreferences sp;

    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreated");
        mBtn = (Button) findViewById(R.id.btn_press);
        // 点击事件
        mBtn.setOnClickListener(v -> {
            Log.d(TAG, "btn onClick ");
            Toast.makeText(MainActivity.this, "点击事件", Toast.LENGTH_SHORT).show();
        });
        testSP();

    }

    private void testSP() {
        // 会在/data/data/<package name>/shared_prefs/目录下的创建一个tudou_test.xml
        sp=getSharedPreferences("tudou_test",MODE_PRIVATE);
    }
}
