package me.microcool.testdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoshiwei
 */
public class MainActivity extends AppCompatActivity {

    ListView mListView;
    ListView listViewBase;
    DemoBaseAdapter listViewBaseAdapter;
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initData();
    }

    /**
     * 初始化水果数据
     */
    private void initData() {
        int count = 3;
        for (int i = 0; i < count; i++) {
            Fruit apple = new Fruit(R.drawable.apple_pic, "Apple");
            fruitList.add(apple);
            Fruit banana = new Fruit(R.drawable.banana_pic, "Banana");
            fruitList.add(banana);
            Fruit orange = new Fruit(R.drawable.orange_pic, "Orange");
            fruitList.add(orange);
            Fruit watermelon = new Fruit(R.drawable.watermelon_pic, "Watermelon");
            fruitList.add(watermelon);
            Fruit pear = new Fruit(R.drawable.pear_pic, "Pear");
            fruitList.add(pear);
            Fruit grape = new Fruit(R.drawable.grape_pic, "Grape");
            fruitList.add(grape);
            Fruit pineapple = new Fruit(R.drawable.pineapple_pic, "Pineapple");
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(R.drawable.strawberry_pic, "Strawberry");
            fruitList.add(strawberry);
            Fruit cherry = new Fruit(R.drawable.cherry_pic, "Cherry");
            fruitList.add(cherry);
            Fruit mango = new Fruit(R.drawable.mango_pic, "Mango");
            fruitList.add(mango);
        }

    }

    private void init() {
        // listView
        mListView = (ListView) findViewById(R.id.listview_demo);
        // 空数据下默认的图片显示，其实就是Item布局中设置一下src，在这里findViewById,找到就行
//        mListView.setEmptyView(findViewById(R.id.image_list_empty));
        final FruitAdapter adapter = new FruitAdapter(this, R.layout.item_list_fruit, fruitList);
        mListView.setAdapter(adapter);

        // 设置监听事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getImagename(), Toast.LENGTH_LONG).show();
            }
        });

        // 遍历ListView中所有的Item
        for (int i = 0; i < mListView.getChildCount(); i++) {
            View view = mListView.getChildAt(i);
        }

        // 使用BaseAdapter的ListView
        listViewBase = (ListView) findViewById(R.id.list_baseadapter);
        listViewBaseAdapter = new DemoBaseAdapter(this, fruitList);
        listViewBase.setAdapter(listViewBaseAdapter);
        // 设置显示第10个item，只是为了了解此API
        listViewBase.setSelection(10);

        // btn 这里建议写为local 型的，不建议写为全局的。
        Button addBtn = (Button) findViewById(R.id.btn_addData);
        Button removeBtn = (Button) findViewById(R.id.btn_removeData);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fruitList.add(new Fruit(R.drawable.avatar, "刘楚恬"));
                adapter.notifyDataSetChanged();
                // 显示最后一项，也就是我们刚刚add上的Item
                mListView.setSelection(fruitList.size() - 1);
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // remove all
                fruitList.removeAll(fruitList);
                adapter.notifyDataSetChanged();

//                remove Item
//                fruitList.remove(fruitList.size() - 1);
//                adapter.notifyDataSetChanged();
//                // 显示最后一项，也就是我们刚刚add上的Item
//                mListView.setSelection(fruitList.size() - 1);
            }
        });


    }

}
