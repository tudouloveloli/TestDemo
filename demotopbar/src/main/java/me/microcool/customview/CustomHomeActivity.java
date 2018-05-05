package me.microcool.customview;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CustomHomeActivity extends AppCompatActivity {

    private TopBar mTopBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_custom_home);
        initView();
    }

    private void initView() {
        mTopBar = (TopBar) findViewById(R.id.top_bar);
        mTopBar.setOnTopBarClickListener(new TopBar.TopBarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(CustomHomeActivity.this, "LeftButton", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(CustomHomeActivity.this, "RightButton", Toast.LENGTH_SHORT).show();
            }
        });

        mTopBar.setLeftButtonIsvisable(true);
    }
}
