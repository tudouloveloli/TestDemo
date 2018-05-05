package com.gsw.spdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.function.ToLongBiFunction;

/**
 * 一个使用SP，记住密码的Demo
 * 主要的思想是使用SP，设置标志位。
 * @author gaoshiwei
 */
public class LoginActivity extends AppCompatActivity {
    SharedPreferences sp;
    Button mBtnLogin;
    EditText mName;
    EditText mPassword;
    CheckBox mCheckPassword;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mName = (EditText) findViewById(R.id.ex_name);
        mCheckPassword = (CheckBox) findViewById(R.id.cb_remember);
        mPassword = (EditText) findViewById(R.id.et_password);

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        // 获取标志位
        Boolean isRemeber = sp.getBoolean("isRemeber", false);
        if (isRemeber) {
            mName.setText(sp.getString("user_name", ""));
            mPassword.setText(sp.getString("user_password", ""));
            mCheckPassword.setChecked(true);
        }
        // login
        mBtnLogin.setOnClickListener(v -> {
            String name = mName.getText().toString();
            String password = mPassword.getText().toString();
            // Tudou 123 认为登录成功
            if (name.equals("Tudou") && password.equals("123")) {
                editor = sp.edit();
                if (mCheckPassword.isChecked()) {
                    editor.putString("user_name", name);
                    editor.putString("user_password", password);
                    // SP设置标致位。
                    editor.putBoolean("isRemeber", true);
                } else {
                    // 如果没有勾选，则会清掉数据。
                    editor.clear();
                }
                // 不管是否勾选总是会提交数据。就算是空的，也提交。
                editor.apply();
                startActivity(new Intent(LoginActivity.this, ToLoginActivity.class));
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "登录失败。", Toast.LENGTH_SHORT).show();
            }


        });
    }
}
