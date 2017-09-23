package me.microcool.testdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.microcool.testdemo.adapter.FruitAdapter;
import me.microcool.testdemo.bean.Fruit;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    /**
     * 监听事件
     */
    private void initEvent() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getImagename(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 初始化水果数据
     */
    private void initData() {
        for (int i = 0; i < 2; i++) {
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

    private void initView() {
        mListView = (ListView) findViewById(R.id.listview_demo);
        FruitAdapter adapter = new FruitAdapter(this, R.layout.item_list_fruit, fruitList);
        mListView.setAdapter(adapter);
    }

}
