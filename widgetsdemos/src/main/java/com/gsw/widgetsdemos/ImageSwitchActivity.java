package com.gsw.widgetsdemos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ViewSwitcher;

import butterknife.BindView;

/**
 * @author gaoshiwei
 * @date 2017/11/27
 */

public class ImageSwitchActivity extends BaseActivity implements ViewSwitcher.ViewFactory, View.OnTouchListener {

    @BindView(R.id.imageswitch)
    ImageSwitcher imageswitch;

    @Override
    protected int layoutId() {
        return R.layout.layout_imageswitch;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {

    }

    @Override
    public View makeView() {
        return null;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
