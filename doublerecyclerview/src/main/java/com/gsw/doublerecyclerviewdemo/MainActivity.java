package com.gsw.doublerecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gsw.doublerecyclerviewdemo.R;
import com.gsw.doublerecyclerviewdemo.adapter.ParentInfoAdapter;
import com.gsw.doublerecyclerviewdemo.bean.ChildInfo;
import com.gsw.doublerecyclerviewdemo.bean.ParentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoshiwei
 */
public class MainActivity extends AppCompatActivity {

    private List<ParentInfo> dataInfoList = new ArrayList<>();
    private ParentInfoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAdapter();
    }

    /**
     * 初始化是适配器数据
     */
    private void initAdapter() {
        for (int i = 0; i < 6; i++) {
            ParentInfo parentInfo = new ParentInfo();
            List<ChildInfo> childInfoList = new ArrayList<>();
            parentInfo.setTitle("社区资讯");
            parentInfo.setMenuList(childInfoList);
            dataInfoList.add(parentInfo);
            for (int j = 0; j < 5; j++) {
                ChildInfo childInfo = new ChildInfo();
                childInfo.setMenuName(i + "-" + j);
                childInfo.setIconImgID(R.mipmap.ic_launcher);
                childInfoList.add(childInfo);
            }
        }
    }

    /**
     * 初始化view
     */
    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recylerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new ParentInfoAdapter(this, dataInfoList);
        recyclerView.setAdapter(adapter);

    }
}
