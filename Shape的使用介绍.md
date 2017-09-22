# Shape

## 说明

在Android开发中，使用shape可以很方便的帮我们画出想要的背景，相对于png图片来说，使用shape可以减少安装包的大小，而且能够更好的适配不同的手机。

## Shape放在哪里？

请统一放在res/drawable下

## 如何编写自己的shape文件？

创建shape_xxx.xml文件 

**root element 为shape **

![如何创建shape文件.png](http://upload-images.jianshu.io/upload_images/2746547-21b733e2ded7e64e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

```xml
<!-- 官方的Demo -->
<?xml version="1.0" encoding="utf-8"?>
<shape 
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape=["rectangle" | "oval" | "line" | "ring"] >
    <corners
        android:radius="integer"
        android:topLeftRadius="integer"
        android:topRightRadius="integer"
        android:bottomLeftRadius="integer"
        android:bottomRightRadius="integer" />
    <gradient
        android:angle="integer"
        android:centerX="integer"
        android:centerY="integer"
        android:centerColor="integer"
        android:endColor="color"
        android:gradientRadius="integer"
        android:startColor="color"
        android:type=["linear" | "radial" | "sweep"]
        android:useLevel=["true" | "false"] />
    <padding
        android:left="integer"
        android:top="integer"
        android:right="integer"
        android:bottom="integer" />
    <size
        android:width="integer"
        android:height="integer" />
    <solid
        android:color="color" />
    <stroke
        android:width="integer"
        android:color="color"
        android:dashWidth="integer"
        android:dashGap="integer" />
</shape>
```

**谈谈标签**

- solid：填充颜色
- corners：圆角大小。
- padding：设置内边距。
- stroke: 不填充(其实就是线条)
- gradient 渐变

这里面已经列出了所有的shape属性。

## Shape 能做什么？

	android:shape=["rectangle" | "oval" | "line" | "ring"]
	android:shape="xxxx" xxxx就是我们可以绘制的图形

这里可以看出，shape可以画四种图形，分别是：矩形（rectangle）、椭圆（oval）、线（line）、圆环（ring）。

**Demo**

### 矩形（rectangle）
#### 直角矩形

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <!--填充颜色-->
    <solid android:color="@color/colorPrimary" />

</shape>
```

#### 圆角矩形

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
	<!--圆角大小-->
    <corners android:radius="10dp"></corners>
	<!--填充颜色-->
    <solid android:color="@color/colorPrimary"></solid>
	<!--设置内边距-->
    <padding android:bottom="12dp"
        android:left="12dp"
        android:right="12dp"
        android:top="12dp"></padding>

</shape>

```

*注意* 关于圆角的设置更多的说明。

```xml
android:radius="integer"
        android:topLeftRadius="integer"
        android:topRightRadius="integer"
        android:bottomLeftRadius="integer"
        android:bottomRightRadius="integer"
```

android:radius：表示4个角的圆角大小；

还可以分别设置四个角的，使用下面四个属性：

- android:topLeftRadius 左上
- android:topRightRadius 右上
- android:bottomLeftRadius 左下
- android:bottomRightRadius 右下

#### 无填充带边框矩形

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">

    <corners android:radius="10dp"></corners>


    <padding android:bottom="12dp"
        android:left="12dp"
        android:right="12dp"
        android:top="12dp"></padding>

    <stroke android:width="5dp"
         android:color="@color/colorAccent"></stroke>
		<!--stroke
		android:width：边框大小
		android:color：边框颜色-->

</shape>

```

#### 渐变矩形

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">

    <solid android:color="@color/colorPrimary"></solid>

    <padding android:bottom="12dp"
        android:left="12dp"
        android:right="12dp"
        android:top="12dp"></padding>
        
    <gradient android:startColor="@android:color/white"
        android:endColor="@android:color/black"
        android:angle="0"></gradient>
</shape>
```

gradient：

- android:startColor：渐变起始颜色
- android:endColor：渐变结束颜色
- android:angle：渐变角度：

1. 0:左到右;
2. 90:下到上;
3. 180:右到左;
4. 270:上到下;

**谈谈三种渐变的type**

- sweep 扫描渐变
- linear 线性渐变
- radial 辐射渐变


### 椭圆（oval）
画圆

#### 纯色的圆

```xml
<!--size的height和width设置为一样大小就是一个圆了-->
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="oval">
    <solid android:color="@color/colorPrimary" />
    <size
        android:width="50dp"
        android:height="50dp" />
</shape>
```

####  渐变的圆

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="oval">
    <size
        android:width="50dp"
        android:height="50dp" />
    <gradient
        android:centerX="0.5"
        android:centerY="0.5"
        android:endColor="@color/colorAccent"
        android:startColor="@color/colorPrimary"
        android:type="sweep" />
</shape>
```

android:centerX：表示渐变的X轴起始位置，范围0-1，0.5表示圆心。

android:centerY：表示渐变的Y轴起始位置，范围0-1，0.5表示圆心。

android:type：渐变类型，有三种

1. linear 线性渐变，默认的渐变类型 
2. radial 放射渐变，设置该项时，android:gradientRadius也必须设置
3. sweep 扫描性渐变

### 线（line）

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="line">

    <stroke
        android:width="1dp"
         android:color="@color/colorAccent"
         android:dashGap="3dp"
         android:dashWidth="4dp"></stroke>

    <size android:height="3dp"></size>//可以不用设置
</shape>
```

线是居中显示的。

- android:width：填充颜色的高度
- android:dashGap：虚线间距宽度
- android:dashWidth：虚线宽度

### 圆环（ring）
#### 普通圆环

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="ring"
    android:useLevel="false"
    android:thickness="10dp">
    <!--android:thickness：圆环宽度-->
    <!--useLevel需要设置为false-->
    <solid android:color="@color/colorAccent"></solid>
</shape>
```

#### 渐变圆环

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="ring"
    android:useLevel="false"
    android:thickness="10dp">
    <!--useLevel需要设置为false-->

    <solid android:color="@color/colorAccent"></solid>

    <gradient android:startColor="@color/colorAccent"
        android:endColor="@color/colorPrimary"
        android:type="sweep"></gradient>
</shape>
```

