package me.microcool.baseadapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gaoshiwei
 * @date 2017/9/27
 */

public class MainActivity extends AppCompatActivity {

    private List<ItemBean> beanList = new ArrayList<>();
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        for (int i = 0; i < 20; i++) {
            beanList.add(new ItemBean(R.mipmap.ic_launcher, "News " + i, "This is Content"));
        }
        // findView
        ListView listView = (ListView) findViewById(R.id.listview);
        adapter = new BeanAdapter(this, beanList);
        listView.setAdapter(adapter);
    }
}
