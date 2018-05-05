package me.microcool.testdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @author gaoshiwei
 * 个人更加喜欢这种方式。
 * 使用BaseAdapter方式
 * @date 2017/11/27
 */

public class DemoBaseAdapter extends BaseAdapter {

    private Context mContext;

    //映射数据

    List<Fruit> mList;

    public DemoBaseAdapter(Context mContext, List<Fruit> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    // 获取数据量

    @Override
    public int getCount() {
        return mList.size();
    }

    // 获取对应ID项对应的Item

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    // 获取对应项ID

    @Override
    public long getItemId(int position) {
        return position;
    }

    // getView

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TestViewHolder testViewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_fruit, parent, false);
            testViewHolder = new TestViewHolder();
            testViewHolder.fruitImage = (ImageView) convertView.findViewById(R.id.fruit_image);
            testViewHolder.fruitName = (TextView) convertView.findViewById(R.id.fruit_name);
            convertView.setTag(testViewHolder);
        } else {
            testViewHolder = (TestViewHolder) convertView.getTag();
        }

        //初始化position位置的item
        Fruit fruit = mList.get(position);
        testViewHolder.fruitImage.setImageResource(fruit.getImageID());
        testViewHolder.fruitName.setText(fruit.getImagename());

        return convertView;
    }

    /**
     * ViewHolder用于缓存控件
     */
    static class TestViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
