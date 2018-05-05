package com.gsw.contentproviderdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gsw.contentprovierdemo.R;

import java.util.List;

/**
 * @author gaoshiwei
 * @date 2017/12/5
 */

public class PeopleAdapter extends BaseAdapter {

    private Context mContext;
    List<PeopleBO> mList;

    public PeopleAdapter(Context mContext, List<PeopleBO> mList) {
        this.mContext = mContext;
        this.mList = mList;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_people, null);
            viewHolder = new ViewHolder();
            viewHolder.userName = (TextView) convertView.findViewById(R.id.tv_username);
            viewHolder.phoneNumber = (TextView) convertView.findViewById(R.id.tv_phonenumber);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //初始化position位置的item
        PeopleBO bo = mList.get(position);
        viewHolder.userName.setText(bo.getUserName());
        viewHolder.phoneNumber.setText(bo.getPhoneNumber());
        return convertView;
    }

    class ViewHolder {
        TextView userName;
        TextView phoneNumber;

    }
}
