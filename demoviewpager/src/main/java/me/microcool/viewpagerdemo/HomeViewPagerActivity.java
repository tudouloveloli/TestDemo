package me.microcool.viewpagerdemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class HomeViewPagerActivity extends AppCompatActivity {

    MyViewPagerAdapter adapter;
    ViewPager viewpager;
    ArrayList<Integer> imageResIds; //图片资源id 集合
    ArrayList<ImageView> imagesList; // 图片资源集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view_pager);
        // 注意数据的初始化和View的初始化顺序，对程序有一定的影响哦。
        // 不信把initData，initVie换下顺序，一定会报空指针的。
        initData();
        initView();
    }

    private void initView() {

        adapter = new MyViewPagerAdapter(this, imagesList);
        viewpager = (ViewPager) findViewById(R.id.view_pager);
        viewpager.setAdapter(adapter);

    }

    private void initData() {
        //准备数据源
        imageResIds = new ArrayList<>();
        imageResIds.add(R.drawable.a);
        imageResIds.add(R.drawable.b);
        imageResIds.add(R.drawable.c);
        imageResIds.add(R.drawable.d);
        imageResIds.add(R.drawable.e);
        //  把数据源设置进去
        imagesList = new ArrayList<>();
        for (int i = 0; i < imageResIds.size(); i++) {
            ImageView image = new ImageView(this);
            image.setImageResource(imageResIds.get(i));
            imagesList.add(image);
        }

    }

}
