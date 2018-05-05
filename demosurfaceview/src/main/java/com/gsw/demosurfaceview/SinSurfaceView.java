package com.gsw.demosurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @author gaoshiwei
 * @date 2017/11/28
 * 绘制正弦曲线
 */

public class SinSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private Canvas mCanvas;
    private SurfaceHolder mHolder;
    private boolean mIsDrawing;

    private Paint mPaint;
    private Path mPath;
    // x坐标
    private int x = 0;
    // y坐标
    private int y = 0;


    public SinSurfaceView(Context context) {
        super(context);
        init();
    }

    public SinSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SinSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        // 初始化SurfaceView所需
        mHolder = getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);

        //
        mPath = new Path();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GREEN);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        new Thread(this).start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;

    }

    @Override
    public void run() {
        while (mIsDrawing) {
            draw();
            // 不断的修改横纵坐标，满足正弦曲线函数
            x += 1;
            y = (int) (100 * Math.sin(x * 2 * Math.PI / 180) + 400);
            mPath.lineTo(x, y);
        }
    }

    private void draw() {
        try {
            // SurfaceHolder对象通过 lockCanvas()获得Canvas对象
            mCanvas = mHolder.lockCanvas();
            // do something

            //SurfaceView 背景
            mCanvas.drawColor(Color.WHITE);
            // drawPath
            mCanvas.drawPath(mPath, mPaint);

        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (mCanvas != null) {
                // SurfaceHolder对象通过 unlockCanvasAndPost()对画布的内容进行提交。
                mHolder.unlockCanvasAndPost(mCanvas);
            }
        }

    }
}
