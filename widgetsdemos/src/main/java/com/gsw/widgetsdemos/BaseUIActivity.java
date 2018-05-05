package com.gsw.widgetsdemos;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.QuickContactBadge;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;

/**
 * @author gaoshiwei
 * @date 2017/11/23
 */

public class BaseUIActivity extends BaseActivity {
    // 定义价格的初始值
    int minPrice = 25;
    private static final String TAG = "BaseUIActivity";
    @BindView(R.id.chronmeter_time)
    Chronometer chronmeterTime;
    private Context mContext;

    @BindView(R.id.checkBox)
    CheckBox checkBox;
    @BindView(R.id.radiogroup)
    RadioGroup radiogroup;
    @BindView(R.id.cb_)
    CheckBox cb;
    @BindView(R.id.btn_man)
    RadioButton btnMan;
    @BindView(R.id.btn_women)
    RadioButton btnWomen;
    @BindView(R.id.list_CheckedTextView)
    ListView listCheckedTextView;
    @BindView(R.id.seekBar_system)
    SeekBar seekBarSystem;
    @BindView(R.id.tv_seekstatus)
    TextView seekText;
    @BindView(R.id.quick_contactBadge)
    QuickContactBadge quickContactBadge;
    @BindView(R.id.ratingbar)
    RatingBar ratingBar;
    @BindView(R.id.switch_system)
    Switch mSwitch;
    @BindView(R.id.numberpicker)
    NumberPicker numberPicker;

    @Override
    protected int layoutId() {
        return R.layout.layout_baseui;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        init();
    }

    private void init() {
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
        } else {

        }
        // 单选按钮的事件
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton button = (RadioButton) findViewById(checkedId);
                Toast toast = Toast.makeText(mContext, "按钮组值发生改变,你选了" + button.getText(), Toast.LENGTH_LONG);
//                ImageView imageView = new ImageView(mContext);
//                imageView.setImageResource(R.drawable.avatar);
//                toast.setView(imageView);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
            }
        });
        // seekBar的事件
        seekBarSystem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 当拖动条的滑块位置发生改变时触发该方法,在这里直接使用参数progress，即当前滑块代表的进度值
                seekText.setText(Integer.toString(progress) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStartTrackingTouch: ");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStopTrackingTouch: ");
            }
        });
        // QuickContactBadge的事件
        quickContactBadge.assignContactFromPhone("10010", false);
        //RatingBar
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser) {
                    Toast.makeText(mContext, "感谢你的：" + rating + "星评分", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // switch 事件
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(mContext, "open bluetooth", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "close bluetooth", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //
        chronmeterTime.setBase(1000000);
        chronmeterTime.start();// 计时器需要手动启动

        // numberPicker

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(100);
        numberPicker.setValue(minPrice);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                minPrice = newVal;
            }
        });

    }
}
