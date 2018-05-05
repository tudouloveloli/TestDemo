package me.microcool.animationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author gaoshiwei
 * @date
 */
public class LayoutAnimActivity extends AppCompatActivity {
    private String[] data = {
            "Apple",
            "Banana",
            "Orange",
            "Watermelon",
            "Pear",
            "Grape",
            "Pineapple",
            "Strawberry",
            "Cherry",
            "Mango",
            "Apple",
            "Banana",
            "Orange",
            "Watermelon",
            "Pear",
            "Grape",
            "Pineapple",
            "Strawberry",
            "Cherry",
            "Mango"};
    @BindView(R.id.listview)
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_anim);
        ButterKnife.bind(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(LayoutAnimActivity.this,
                android.R.layout.simple_list_item_1,
                data);
        listview.setAdapter(adapter);

    }
}
