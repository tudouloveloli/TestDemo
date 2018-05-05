package com.gsw.widgetsdemos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author gaoshiwei
 * @date 2017/11/24.
 */

public class BaseUITextActivity extends BaseActivity {
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.editText3)
    EditText editText3;
    @BindView(R.id.editText4)
    EditText editText4;
    @BindView(R.id.editText5)
    EditText editText5;
    @BindView(R.id.editText6)
    EditText editText6;
    @BindView(R.id.editText7)
    EditText editText7;
    @BindView(R.id.editText8)
    EditText editText8;
    @BindView(R.id.editText9)
    EditText editText9;
    @BindView(R.id.editText10)
    EditText editText10;
    @BindView(R.id.editText11)
    EditText editText11;
    @BindView(R.id.editText12)
    EditText editText12;
    @BindView(R.id.editText13)
    EditText editText13;
    @BindView(R.id.autoCompleteTextView)
    AutoCompleteTextView autoCompleteTextView;
    @BindView(R.id.multiAutoCompleteTextView)
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    @BindView(R.id.btn_get_value)
    Button btnGetValue;
    @BindView(R.id.btn_all)
    Button btnAll;
    @BindView(R.id.btn_select)
    Button btnSelect;
    @BindView(R.id.btn_get_select)
    Button btnGetSelect;

    @Override
    protected int layoutId() {
        return R.layout.layout_text;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 交换两个索引
     *
     * @param start 开始索引
     * @param end   结束索引
     */
    protected void switchIndex(int start, int end) {
        int temp = start;
        start = end;
        end = temp;
    }

    @OnClick({R.id.btn_get_value, R.id.btn_all, R.id.btn_select, R.id.btn_get_select})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_value:
                Toast.makeText(BaseUITextActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_all:
                editText.selectAll();
                break;
            case R.id.btn_select:
                // 从第二个字符开始取词
                editText.setSelection(1, editText.length());
                break;
            case R.id.btn_get_select:
                // 全选
                int start = editText.getSelectionStart();
                int end = editText.getSelectionEnd();
                CharSequence selectText = editText.getText().subSequence(start, end);
                Toast.makeText(BaseUITextActivity.this, selectText, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
