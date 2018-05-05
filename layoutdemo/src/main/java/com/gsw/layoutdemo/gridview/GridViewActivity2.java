package com.gsw.layoutdemo.gridview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.gsw.layoutdemo.R;

/**
 * Created by gaoshiwei on 2017/11/22.
 */

public class GridViewActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_gridview);

        GridView gridview = (GridView) findViewById(R.id.gv_test);
        gridview.setAdapter(new GridAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(GridViewActivity2.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
