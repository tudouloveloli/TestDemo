package me.microcool.baseadapterdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaoshiwei on 2017/9/27.
 *
 * Adapter是model和View的桥梁
 */

public class BeanAdapter extends BaseAdapter {

    //映射数据
    List<ItemBean> mList;

    private Context mContext;

    public BeanAdapter(Context context, List<ItemBean> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    /**
     * 获取数据量
     *
     * @return
     */
    @Override
    public int getCount() {
        return mList.size();
    }

    /**
     * 获取对应ID项对应的Item
     *
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    /**
     * 获取对应项ID
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemBean bean = mList.get(position);// 获取bean对象
        View view;
        ViewHolder viewHolder = null;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            //由于我们只需要将XML转化为View，并不涉及到具体的布局，所以第二个参数通常设置为null
            view = LayoutInflater.from(mContext).inflate(R.layout.item_bean, parent, false);
            viewHolder.itemImage = (ImageView) view.findViewById(R.id.news_image);
            viewHolder.itemTitle = (TextView) view.findViewById(R.id.news_title);
            viewHolder.itemContent = (TextView) view.findViewById(R.id._news_content);
            view.setTag(viewHolder);    // 将ViewHolder存放在View中
        } else {
            view = convertView; //如果convertView已有。
            viewHolder = (ViewHolder) view.getTag();    // 获取ViewHolder
        }

        viewHolder.itemImage.setImageResource(bean.getImageResourceID());
        viewHolder.itemTitle.setText(bean.getTitle());
        viewHolder.itemContent.setText(bean.getContent());

        return view;
    }

    /**
     * ViewHolder 是一种设计模式。
     * ViewHolder用于缓存控件，减少findViewById
     */
    class ViewHolder {
        ImageView itemImage;
        TextView itemTitle;
        TextView itemContent;

    }
}
