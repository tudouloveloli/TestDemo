package me.microcool.testdemo.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.microcool.testdemo.R;
import me.microcool.testdemo.bean.Fruit;

/**
 * 编写高性能的ListView
 * Fruit实体类的Adapter
 * Created by gaoshiwei on 2017/9/20.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resource;//LayoutRes ID

    public FruitAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);// 获取当前项的Fruit实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//将ViewHolder 存在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }

        viewHolder.fruitImage.setImageResource(fruit.getImageID());
        viewHolder.fruitName.setText(fruit.getImagename());
        return view;
    }

    /**
     * 内部类ViewHolder
     */
    static class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }


}
