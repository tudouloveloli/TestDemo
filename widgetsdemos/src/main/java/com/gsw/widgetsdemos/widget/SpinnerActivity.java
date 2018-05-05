package com.gsw.widgetsdemos.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.gsw.widgetsdemos.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoshiwei
 * @date 2017/11/22
 */

public class SpinnerActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_spinner);

        //spinner1, 使用系统的适配器ArrayAdapter
        spinner = (Spinner) findViewById(R.id.spinner);
        // 使用 ArrayAdapter
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears 设置弹出的样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setPrompt("选择语言");
        spinner.setPopupBackgroundResource(R.color.colorPrimary);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] resource = getResources().getStringArray(R.array.languages);
                Toast.makeText(SpinnerActivity.this, "" + resource[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // spinner2,使用自定义的适配器SpinnerAdapter
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        // 建立数据源
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(R.drawable.avatar, "张三", "上海 "));
        persons.add(new Person(R.drawable.ic_launcher, "李四", "上海 "));
        persons.add(new Person(R.drawable.avatar, "王五", "北京"));
        persons.add(new Person(R.drawable.avatar, "赵六", "广州 "));
        // 建立Adapter绑定数据源
        SpinnerAdapter _MyAdapter = new SpinnerAdapter(this, persons);
        // 绑定Adapter
        spinner2.setAdapter(_MyAdapter);

    }

}
