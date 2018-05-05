package me.microcool.testdemo;

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
import me.microcool.testdemo.Fruit;

/**
 * 编写高性能的ListView
 * Fruit实体类的Adapter
 * <p>
 * 简单的视图使用ArrayAdapter
 * <p>
 * 复杂的视图使用BaseAdapter (逻辑更加清晰一点)
 *
 * @author gaoshiwei
 * @date 2017/9/20
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    @LayoutRes
    private int resource;
    // resource 表示资源id

    public FruitAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 获取当前项的Fruit实例
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            // 将ViewHolder 存在View中
            view.setTag(viewHolder);
        } else {
            view = convertView;
            // 重新获取ViewHolder
            viewHolder = (ViewHolder) view.getTag();
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
