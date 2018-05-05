package com.gsw.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author gaoshiwei
 * @date 2017/11/23
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<String> mTitle;

    public RecycleViewAdapter(Context mContext, ArrayList<String> mTitle) {
        this.mContext = mContext;
        this.mTitle = mTitle;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewContent = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(viewContent);
        // 时间监听也是在onCreateViewHoler 编码的
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mTitle.get(position));
    }

    @Override
    public int getItemCount() {
        // 善用三元运算符
        return mTitle == null ? 0 : mTitle.size();
    }

    /**
     * ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        /**
         * 在ViewHolder的构造函数中初始化view
         *
         * @param itemView
         */
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }

    /**
     * add item
     *
     * @param position
     * @param text
     */
    public void add(int position, String text) {
        mTitle.add(position, text);
        notifyItemInserted(position);
    }

    /**
     * remove item
     *
     * @param position
     */
    public void remove(int position) {
        mTitle.remove(position);
        notifyItemRemoved(position);
    }
}
