package com.gsw.widgetsdemos;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.TextureView;

import butterknife.BindView;

/**
 * @author gaoshiwei
 * @date 2017/11/27
 */

public class TextureViewActivity extends BaseActivity implements TextureView.SurfaceTextureListener {

    @BindView(R.id.texture)
    TextureView texture;

    @Override
    protected int layoutId() {
        return R.layout.lauout_textureview;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        texture.setSurfaceTextureListener(this);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }
}
