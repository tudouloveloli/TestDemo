package com.gsw.recycleviewdemo;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * @author gaoshiwei
 */
public class MainActivity extends AppCompatActivity {

    private RecycleViewAdapter adapter;
    private RecyclerView mRecycleView;
    private ArrayList<String> mTitle;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initData();
        initView();


    }

    /**
     *
     */
    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mRecycleView = (RecyclerView) findViewById(R.id.rv_list);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycleView.setLayoutManager(manager);
        adapter = new RecycleViewAdapter(mContext, mTitle);

    }

    /**
     *
     */
    private void initData() {
        // 数据初始化
        mTitle = new ArrayList<String>();
        mTitle.add("java");
        mTitle.add("C");
        mTitle.add("Python");
        mTitle.add("C++");
        mTitle.add("C#");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_add:
                // 添加模拟数据到第一项
                mTitle.add(0, "www.lijizhou.com");
                // RecyclerView列表进行UI数据更新
                adapter.notifyItemInserted(0);
                // 如果在第一项添加模拟数据需要调用 scrollToPosition（0）把列表移动到顶端（可选）
                mRecycleView.scrollToPosition(0);
                break;

            case R.id.menu_del:
                // 删除模拟数据第一项
                mTitle.remove(0);
                // RecyclerView 列表进行UI数据更新
                adapter.notifyItemRemoved(0);
                break;

            case R.id.menu_move:
                // 列表中第二项移到第三项 进行UI数据更新
                adapter.notifyItemMoved(1, 2);
                break;

            case R.id.menu_addmore:
                // 模拟数据批量添加4条数据
                mTitle.add(0, "test");
                mTitle.add(0, "test1");
                mTitle.add(0, "test2");
                mTitle.add(0, "test3");
                // RecyclerView列表进行批量UI数据更新
                adapter.notifyItemRangeInserted(0, 4);
                // scrollToPosition（0）作用是把列表移动到顶端
                mRecycleView.scrollToPosition(0);
                break;
            default:
        }
        return true;
    }
}
