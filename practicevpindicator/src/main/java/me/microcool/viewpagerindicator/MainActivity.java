package me.microcool.viewpagerindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private TopNavigation topNavigation;
    private ViewPager mViewPager;

    private String[] mTitle = new String[]{"短信", "收藏", "喜欢"}; // 导航栏。

    private List<VpSimpleFragment> mContent = new ArrayList<>(); //Fragment List

    private FragmentPagerAdapter mAdapter; // Adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
        initDatas();
        mViewPager.setAdapter(mAdapter);
    }

    /**
     * 初始化View
     */
    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        topNavigation = (TopNavigation) findViewById(R.id.top_navigation);

    }

    /**
     * 初始化数据
     */
    private void initDatas() {

        for (String title : mTitle) {
            VpSimpleFragment fragment = VpSimpleFragment.newInstance(title);
            mContent.add(fragment);
        }
        // Adapter适配器
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mContent.get(position);
            }

            @Override
            public int getCount() {
                return mContent.size();
            }
        };

    }
}
