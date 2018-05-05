package com.gsw.layoutdemo.gridview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.gsw.layoutdemo.R;

/**
 * Created by gaoshiwei on 2017/11/22.
 */

public class GridViewActivity extends AppCompatActivity {
    GridView gridView;
    ImageAdapter iamgeAdapter;
    // 图片源
    Integer[] images = {R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_gridview);
        gridView = (GridView) findViewById(R.id.gv_test);
        iamgeAdapter = new ImageAdapter(this);
        gridView.setAdapter(iamgeAdapter);
        // 点击事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "-->>" + position, Toast.LENGTH_SHORT).show();
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog alertDialog = new AlertDialog.Builder(GridViewActivity.this)
                        .setTitle("nihoa ")
                        .setMessage("我是长按的效果")
                        .create();
                alertDialog.show();
                return true;
            }
        });

    }

    /**
     * GridView的适配器类,一般单独成类--> ImageAdapter 。
     * 谈到适配器，那我们就需要数据源--> BeanClass
     * 一般还需要布局文件  --> item_xxx.xml
     */
    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context context) {
            mContext=context;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            /*
             * 1.手工创建对象
             * 2.加载xml文件 item_xxx.xml
             */
            ImageView imageView = null;
            if (convertView == null) {
                imageView = new ImageView(GridViewActivity.this);
            } else {
                imageView = (ImageView) convertView;
            }
            // 设置GridView的显示的个子的间距
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(30, 20, 20, 20);
            imageView.setImageResource(images[position]);
            return imageView;
        }
    }
}
