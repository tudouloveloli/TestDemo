# Android--自定义控件

1. 自定义属性
2. 自定义控件(写类)
3. 使用自定义控件

## 自定义属性 
如何自定义属性呢？
res/attrs.xml (没有的先创建一个attrs.xml)
![自定义属性.png](http://upload-images.jianshu.io/upload_images/2746547-43745ac4351178ba.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 自定义控件

### 1.创建一个java并继承已有的组件
>这种自定义控件的方式又叫组合控件，或者说是在原有控件的基础之上升级控件,还有一种方式是完全的自定义View

```java
public class TopBar extends RelativeLayout {}
```

### 2.声明属性并找到属性
#### 2.1声明属性

```java
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
    
    
```

#### 2.2 找到属性
这就需要构造函数,因为我继承的是RelativeLayout，所以用此演示。这里选择带有属性的构造函数。

![使用构造函数设置属性.png](http://upload-images.jianshu.io/upload_images/2746547-4a958c6a742606d8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

```java
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
    }
```

### 3.声明控件并为控件设置属性
**我们声明的属性干嘛的？ 我们把属性取出来又为了什么？玩？ 不可能！ 没错就是为控件所用的，
那么我们需要控件啊，所以我们要声明控件！**
就声明两个Button 和一个TextView吧

#### 3.1 声明控件

```java
 // 声明控件
    private Button leftButton;
    private Button rightButton;
    private TextView midTitleView;
```

#### 3.2为控件设置属性
```java
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
```

### 4.设置LayoutParams（布局参数）
什么？你不知道什么是LayoutParams，来来来，[请参考别人网友写的LayoutParams](https://my.oschina.net/zhangqingcai/blog/28772) 顺便看看LayoutParams的大家族

![LayoutParams的大家族.png](http://upload-images.jianshu.io/upload_images/2746547-abd5c237b2b53181.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
>解释 LayoutParams：
>
>
>LayoutParams 可以理解为layout的包信息(参数)，其中包含了各种数据（参数）。变量param 定义了宽， 高。
然后把这个作为Child View的参数了。这很好的体现了LayoutParams的作用。

#### 4.1声明LayoutParams

```java
 //LayoutParams
    private LayoutParams leftParams;
    private LayoutParams rightParams;
    private LayoutParams titleParams;
```

#### 4.2设置LayoutParams

```java
 // 使用LayoutParams
        // 定义宽高，我这里使用的是ViewGroup.LayoutParams
        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        // 定义放置规则，左对齐
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        // addView 是ViewGroup的方法
        // Adds a child view with the specified layout parameters.
        //把控件添加到我们的ViewGroup。
        addView(leftButton, leftParams);

        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(rightButton, rightParams);

        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(midTitleView, titleParams);
```

### 5. 设置监听事件

>这里需要用到接口回调的设计思想
>

```java
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

```


```java
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
                listener.rightClick();//接口引用+接口方法
            }
        });
```

### 6.扩展方法(添加想要的API)

我们可以为我们的控件添加我们任何想要的功能方法(就是所谓的API)，这样使用我们控件的人就可以调用方法了。

```java
 //添加暴露方法，相当于给TopBar创建很多的API方法，这样可以对控件进行各种想要的控制
 //这里添加一个隐藏左边button的方法
    public void setLeftButtonIsvisable(boolean flag) {
        if (flag) {
            leftButton.setVisibility(View.VISIBLE);
        } else {
            leftButton.setVisibility(View.GONE);
        }
    }
```

#### 6.1完整的TopBar控件代码

```java
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


```


### 7.使用自定义控件

#### 7.1引进xml布局文件中

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="me.microcool.customview.CustomHomeActivity">

    <me.microcool.customview.TopBar
        android:id="@+id/top_bar"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        app:leftBackground="@color/colorAccent"
        app:leftText="@string/nav_back"
        app:leftTextColor="@color/colorPrimary"
        app:rightBackground="@color/colorAccent"
        app:rightText="@string/more"
        app:rightTextColor="@color/colorPrimary"
        app:title="@string/title"
        app:titleTextColor="@color/colorPrimaryDark"
        app:titleTextSize="@dimen/title_text_size" />

</RelativeLayout>

```

#### 7.2在活动中使用自定义的控件

```java
package me.microcool.customview;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CustomHomeActivity extends AppCompatActivity {

    private TopBar mTopBar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_custom_home);
        initView();
    }

    private void initView() {
        mTopBar = (TopBar) findViewById(R.id.top_bar);
        mTopBar.setOnTopBarClickListener(new TopBar.TopBarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(CustomHomeActivity.this, "LeftButton", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(CustomHomeActivity.this, "RightButton", Toast.LENGTH_SHORT).show();
            }
        });

        mTopBar.setLeftButtonIsvisable(true);
    }
}

```

### 8.一点额外的知识

![关于命名空间的一点知识.png](http://upload-images.jianshu.io/upload_images/2746547-4bd25cd62618aa33.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

**请注意：**

1. xmlns:android="http://schemas.android.com/apk/res/android"
2. xmlns:app="http://schemas.android.com/apk/res-auto"

xmlns(xmlnamespace)

#### 我们之所以能用 android：XXXX

```xml
android:layout_width="match_parent"
android:layout_height="40dp"
``` 

是因为AS自动为我们添加xmlns:android="http://schemas.android.com/apk/res/android"

#### 当我们使用自定义的属性的时候，就需要使用自己的命名空间。

```xml
xmlns:app="http://schemas.android.com/apk/res-auto"

```

一般用app这个名字，当然我们也可以自定义,比如起个custom的名字。

```xml
xmlns:custom="http://schemas.android.com/apk/res-auto"
<!--但是后面一定要是 http://schemas.android.com/apk/res-auto -->
```




