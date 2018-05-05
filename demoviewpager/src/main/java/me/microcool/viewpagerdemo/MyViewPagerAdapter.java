package me.microcool.viewpagerdemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考链接 http://blog.csdn.net/dmk877/article/details/50060745
 * 使用PagerAdapter就必须要重写他的四个方法
 * Created by gaoshiwei on 2017/9/21.
 */

public class MyViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<ImageView> mViewList;

    public MyViewPagerAdapter(Context mContext, ArrayList<ImageView> mViewList) {
        this.mContext = mContext;
        this.mViewList = mViewList;
    }

    /**
     * 获取ViewPager实际绘制的列表项的数量
     * <p>
     * Google:
     * 即将存放View的一个集合的大小返回，这里的大小也就是视图的个数
     *
     * @return
     */
    @Override
    public int getCount() {
        return mViewList.size();
    }

    /**
     * 获取当前列表项，也就是正在显示的当前页，当前ViewPager所在的位置；
     * <p>
     * Google:
     * 将mViewList中的一个View取出来，添加到视图中,然后将这个视图返回.
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = mViewList.get(position);
        container.addView(imageView);
        return imageView;

    }

    /**
     * 当前项离开屏幕时回调本方法，在本方法中需要将当前想从ViewPager中移除；
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        ImageView imageView = (ImageView) object;
//        container.removeView(imageView);
        container.removeView(mViewList.get(position));

    }

    /**
     * 判断view和obj是否为同一个view
     * Google:
     * 这个方法的作用就是用来判断 instantiateItem(ViewGroup, int)方法返回的Key是否和界面的View相关联，
     * 如果关联则返回true，否则返回false。
     * <p>
     * 当返回为true时就将根据当前的position得到的view展示出来，否则就不展示。
     *
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        //当返回为true的时候，就将根据当前的position得到的view展示出来
        return view == object;// 可以直接这样写写，Google也是这样建议的。
    }
}
