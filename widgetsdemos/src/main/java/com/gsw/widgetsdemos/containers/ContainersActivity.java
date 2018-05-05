package com.gsw.widgetsdemos.containers;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.gsw.widgetsdemos.BaseActivity;
import com.gsw.widgetsdemos.R;

import butterknife.BindView;

/**
 * @author gaoshiwei
 * @date 2017/11/27
 */

public class ContainersActivity extends BaseActivity {

    private Context mContext;


    private ExPandableAdapter exPandableAdapter;

    @BindView(R.id.list_expandable)
    ExpandableListView listExpandable;

    @Override
    protected int layoutId() {
        return R.layout.layout_containers;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
        init();

    }

    private void init() {
        exPandableAdapter = new ExPandableAdapter(mContext);
        listExpandable.setAdapter(exPandableAdapter);
//        设置分组项的点击监听事件
        listExpandable.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(mContext, "......", Toast.LENGTH_SHORT).show();
                // 请务必返回 false，否则分组不会展开
                return false;
            }
        });

        listExpandable.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(mContext, "......", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

}
