package me.microcool.toppull.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 自定义的下拉控件。
 *
 * Created by gaoshiwei on 2017/9/29.
 */

public class TouchPullView extends View {
    private static final String TAG = "TouchPullView";
    // 圆形的画笔
    private Paint mCirclePaint;
    // 圆的半径
    private int mCirecleRadius = 100;
    // 圆心
    private float mCireclePointX;
    private float mCireclePointY;
    //  拉动的进度
    private float mProgress;
    //  可拖动的高度
    private int mDragHeight = 800;


    public TouchPullView(Context context) {
        super(context);
        init();
    }

    public TouchPullView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TouchPullView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TouchPullView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    /**
     * 初始化
     */
    private void init() {

        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        // 设置抗锯齿
        p.setAntiAlias(true);
        //设置防抖动
        p.setDither(true);
        // 设置填充方式
        p.setStyle(Paint.Style.FILL);
        // 设置颜色
        p.setColor(0xFF000000);
        mCirclePaint = p;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制
        canvas.drawCircle(
                mCireclePointX,
                mCireclePointY,
                mCirecleRadius,
                mCirclePaint);

    }

    /**
     * 当进行测量时触发
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // 宽度的意图，宽度的类型
        /**
         * Extracts the mode from the supplied measure specification.
         *
         * @param measureSpec the measure specification to extract the mode from
         * @return {@link android.view.View.MeasureSpec#UNSPECIFIED},
         *         {@link android.view.View.MeasureSpec#AT_MOST} or
         *         {@link android.view.View.MeasureSpec#EXACTLY}
         */

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        //
        int iWidth = 2 * mCirecleRadius + getPaddingLeft() + getPaddingRight();
        //
        int iHeight = (int) ((mDragHeight * mProgress + 0.5f)) + getPaddingTop() + getPaddingBottom();


        // 声明测量获得的宽高
        int measureWidth = 0;
        int measureHeight = 0;

        // 设置宽度
        if (widthMode == MeasureSpec.EXACTLY) {
            // 确实值模式
            measureWidth = width;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            // 最多的
            measureWidth = Math.min(iWidth, width);
        } else {
            measureWidth = width;
        }

        // 设置高度
        if (heightMode == MeasureSpec.EXACTLY) {
            measureHeight = height;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            measureHeight = Math.min(iHeight, height);
        } else {
            measureHeight = height;
        }

        // 把测量后的宽高设置进去
        setMeasuredDimension(measureWidth, measureHeight);

    }

    /**
     * 当大小改变时触发
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // 位运算符，右移一位， 取一半值
        mCireclePointX = getWidth() >> 1;
        mCireclePointY = getHeight() >> 1;

    }

    /**
     * 设置进度
     *
     * @param progress 进度
     */
    public void setProgress(float progress) {

        Log.d(TAG, "setProgress: " + progress);

        mProgress = progress;
        // 请求重新测量
        requestLayout();


    }
}
