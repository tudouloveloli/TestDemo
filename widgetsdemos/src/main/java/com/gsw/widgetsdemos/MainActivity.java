package com.gsw.widgetsdemos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.gsw.widgetsdemos.containers.ContainersActivity;
import com.gsw.widgetsdemos.layout.GridLayoutActivity;
import com.gsw.widgetsdemos.widget.SpinnerActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author gaoshiwei
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.btn_spinner)
    Button btnSpinner;
    @BindView(R.id.btn_checkbox)
    Button btnCheckbox;
    @BindView(R.id.progress_default)
    ProgressBar progress_default;
    @BindView(R.id.btn_progress)
    Button btnProgress;
    @BindView(R.id.btn_text)
    Button btnText;
    @BindView(R.id.btn_layout)
    Button btnLayout;
    @BindView(R.id.btn_contianer)
    Button btnContianer;

    private Handler handler = new Handler();

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.btn_spinner, R.id.btn_checkbox, R.id.btn_progress, R.id.btn_text, R.id.btn_layout, R.id.btn_contianer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_spinner:
                //显示默认进度条
                progress_default.setVisibility(View.VISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                        startActivity(intent);
                        //隐藏默认的进度条
                        progress_default.setVisibility(View.GONE);
                    }
                }, 1000);
                break;
            case R.id.btn_checkbox:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, BaseUIActivity.class);
                        startActivity(intent);
                    }
                }, 100);
                break;
            case R.id.btn_progress:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, ProgressActivity.class);
                        startActivity(intent);
                    }
                });
                break;
            case R.id.btn_text:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, BaseUITextActivity.class);
                        startActivity(intent);
                    }
                });
                break;
            case R.id.btn_layout:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, GridLayoutActivity.class);
                        startActivity(intent);
                    }
                });
                break;
            case R.id.btn_contianer:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, ContainersActivity.class);
                        startActivity(intent);
                    }
                });
                break;

            default:
        }
    }

}
