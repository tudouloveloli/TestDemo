package com.gsw.widgetsdemos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * @author gaoshiwei
 * @date 2017/11/23
 * <a href="http://www.jianshu.com/p/3e3bcadf90ea">cankao</a>
 */

public class ProgressActivity extends BaseActivity {

    @Override
    protected int layoutId() {
        return R.layout.layout_progress;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ProgressBar bar = (ProgressBar) findViewById(R.id.progress_horizontal);
        final TextView textView = (TextView) findViewById(R.id.tvProgress);
        new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (i < 100) {
                    i++;
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final int j = i;
                    bar.setProgress(i);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(j + "%");
                        }
                    });
                }
            }
        }.start();


    }
}
