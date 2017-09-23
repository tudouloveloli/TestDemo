package me.microcool.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by gaoshiwei on 2017/9/23.
 */

public class TopBar extends RelativeLayout {
    //    左边需要的属性
    private String leftTitle;
    private int leftColor;
    private Drawable leftBackground;

    //    中间需要的属性
    private String midTitle;
    private int midColor;
    private float midTitleSize;

    //    右边需要的属性
    private String rightTitle;
    private int rightColor;
    private Drawable rightBackground;

    // 声明控件
    private Button leftButton;
    private Button rightButton;
    private TextView midTitleView;

    //LayoutParams
    private LayoutParams leftParams;
    private LayoutParams rightParams;
    private LayoutParams titleParams;

    // 声明一个TopBarClickListener 接口的实例
    private TopBarClickListener listener;

    // 定义回调接口
    public interface TopBarClickListener {

        void leftClick();

        void rightClick();
    }

    // 暴露一个设置监听的方法给用户
    // 这里传入的参数是接口参数，由于接口不能直接创建对象，我们想要使用接口，那么就需要实现它的方法，也就是匿名内部类的方式。
    public void setOnTopBarClickListener(TopBarClickListener listener) {
        // 神奇的地方就是在于我们的参数是接口参数
        this.listener = listener;
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 把自定义属性放到TypeArray的数据结构中
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        // 从TypedArray 数据结构中获取我们的xml自定义的属性，格式为 TopBar_XXX  TopBar为declare-styleable的name值 XXX使我们自定义的属性名称
        leftTitle = typedArray.getString(R.styleable.TopBar_leftText);
        leftColor = typedArray.getColor(R.styleable.TopBar_leftTextColor, 0);
        leftBackground = typedArray.getDrawable(R.styleable.TopBar_leftBackground);

        rightTitle = typedArray.getString(R.styleable.TopBar_rightText);
        rightColor = typedArray.getColor(R.styleable.TopBar_rightTextColor, 0);
        rightBackground = typedArray.getDrawable(R.styleable.TopBar_rightBackground);

        midTitle = typedArray.getString(R.styleable.TopBar_title);
        midColor = typedArray.getColor(R.styleable.TopBar_titleTextColor, 0);
        midTitleSize = typedArray.getDimension(R.styleable.TopBar_titleTextSize, 0);

        // 不要忘记recycle
        typedArray.recycle();

        // 创建 控件
        leftButton = new Button(context);
        rightButton = new Button(context);
        midTitleView = new TextView(context);

        // 为控件添加我们的自定义的属性
        leftButton.setTextColor(leftColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftTitle);

        rightButton.setTextColor(rightColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightTitle);

        midTitleView.setText(midTitle);
        midTitleView.setTextColor(midColor);
        midTitleView.setTextSize(midTitleSize);
        midTitleView.setGravity(Gravity.CENTER);
        // 这是View的方法。只要是View都会生效的，写这句话的作用是仅仅为了设置背景。
        setBackgroundColor(Color.parseColor("#8D6E63"));

        // 使用LayoutParams
        // 定义宽高
        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        // 定义放置规则，左对齐
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        // addView 是ViewGroup的方法 Adds a child view with the specified layout parameters.
        //把控件添加到我们的ViewGroup。
        addView(leftButton, leftParams);

        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(rightButton, rightParams);

        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(midTitleView, titleParams);

        //定义View点击事件

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.leftClick();//接口引用+接口方法
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightClick();
            }
        });

    }

    //添加暴露方法，相当于给TopBar创建很多的API方法，这样可以对控件进行各种想要的控制
    public void setLeftButtonIsvisable(boolean flag) {
        if (flag) {
            leftButton.setVisibility(View.VISIBLE);
        } else {
            leftButton.setVisibility(View.GONE);
        }
    }
}
