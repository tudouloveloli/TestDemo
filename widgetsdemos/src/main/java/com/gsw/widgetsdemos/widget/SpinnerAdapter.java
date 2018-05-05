package com.gsw.widgetsdemos.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gsw.widgetsdemos.R;

import java.util.List;

/**
 * @author gaoshiwei
 * @date 2017/11/22
 */

public class SpinnerAdapter extends BaseAdapter {
    private List<Person> mList;
    private Context mContext;

    public SpinnerAdapter(Context pContext, List<Person> pList) {
        this.mContext = pContext;
        this.mList = pList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 下面是重要代码
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater _LayoutInflater = LayoutInflater.from(mContext);
        convertView = _LayoutInflater.inflate(R.layout.ietm_custom, null);
        if (convertView != null) {
            ImageView imageView = (ImageView) convertView.findViewById(R.id.image_custom);
            TextView _TextView1 = (TextView) convertView.findViewById(R.id.tv_name);
            TextView _TextView2 = (TextView) convertView.findViewById(R.id.tv_address);

            imageView.setImageResource(mList.get(position).getImageId());
            _TextView1.setText(mList.get(position).getPersonName());
            _TextView2.setText(mList.get(position).getPersonAddress());
        }
        return convertView;
    }
}
