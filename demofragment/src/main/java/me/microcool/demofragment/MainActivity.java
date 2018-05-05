package me.microcool.demofragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

/**
 * @author gaoshiwei
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button mBtnLoad;
    private Button mBtnReload;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnLoad = (Button) findViewById(R.id.bt_loadfragmet);
        mBtnLoad.setOnClickListener(v -> loadFragment(new FrgLoading()));
        mBtnReload = (Button) findViewById(R.id.bt_reloadfragmet);
        mBtnReload.setOnClickListener(v -> reLoadFragment(new FrgReload()));


        getSupportFragmentManager().beginTransaction()
                .add(R.id.right_layout, Fragment1.newInstance("hello world"), "f1")
                //.addToBackStack("fname")
                .commit();
    }

    /**
     * 加载一个碎片
     *
     * @param fragment
     */
    private void reLoadFragment(Fragment fragment) {
        Log.d(TAG, "reLoadFragment: ");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.right_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    /**
     * 加载碎片
     *
     * @param fragment
     */
    private void loadFragment(Fragment fragment) {
        Log.d(TAG, "loadFragment: 1");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fTransaction = manager.beginTransaction();
        fTransaction.replace(R.id.right_layout, fragment);
        fTransaction.addToBackStack(null);
        fTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed: ");
        finish();
    }
}
