# Android样式开发 --selector
>参考 ：
>
>[重点看Google的文档](https://developer.android.com/guide/topics/resources/color-list-resource.html)

>[https://keeganlee.me/post/android/20150905](https://keeganlee.me/post/android/20150905)

## 什么是selector？

>Google: Color State List Resource

我就认为他是颜色选择器（Color-Selector）。

## 为什么要使用selector？
> shape只能定义单一的形状，而实际应用中，很多地方比如按钮、Tab、ListItem等都是不同状态有不同的展示形状。举个例子，一个按钮的背景，默认时是一个形状，按下时是一个形状，不可操作时又是另一个形状。有时候，不同状态下改变的不只是背景、图片等，文字颜色也会相应改变。而要处理这些不同状态下展示什么的问题，就要用selector来实现了。 --引用Keegan小钢的介绍

## 如何创建？创建在哪里？

**看这里**

![selector的官方说明.png](http://upload-images.jianshu.io/upload_images/2746547-0d1d8e086be41167.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

res/color/filename.xml(没有color文件夹的先在res下新建个color文件夹) 【这里说的是主要使用方式】

下面是Google文档中给的demo

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android" >
    <item
        android:color="hex_color"
        android:state_pressed=["true" | "false"]
        android:state_focused=["true" | "false"]
        android:state_selected=["true" | "false"]
        android:state_checkable=["true" | "false"]
        android:state_checked=["true" | "false"]
        android:state_enabled=["true" | "false"]
        android:state_window_focused=["true" | "false"] />
</selector>
```

## selector标签
selector标签，**可以添加一个或多个item子标签，**而相应的状态是在item标签中定义的。

定义的xml文件可以作为两种资源使用：drawable和color。

- 作为drawable资源使用时，一般和shape一样放于drawable目录下，**item必须指定android:drawable属性**；
- 作为color资源使用时，则放于color目录下，item必须指定android:color属性。

## item标签

看看都有哪些状态可以设置呢：

- android:state_enabled: 设置触摸或点击事件是否可用状态，一般只在false时设置该属性，表示不可用状态
- android:state_pressed: 设置是否按压状态，一般在true时设置该属性，表示已按压状态，默认为false
- android:state_selected: 设置是否选中状态，true表示已选中，false表示未选中
- android:state_checked: 设置是否勾选状态，主要用于CheckBox和RadioButton，true表示已被勾选，false表示未被勾选
- android:state_checkable: 设置勾选是否可用状态，类似state_enabled，只是state_enabled会影响触摸或点击事件，而state_checkable影响勾选事件
- android:state_focused: 设置是否获得焦点状态，true表示获得焦点，默认为false，表示未获得焦点
- android:state_window_focused: 设置当前窗口是否获得焦点状态，true表示获得焦点，false表示未获得焦点，例如拉下通知栏或弹出对话框时，当前界面就会失去焦点；另外，ListView的ListItem获得焦点时也会触发true状态，可以理解为当前窗口就是ListItem本身

有二个文档中没写的(参考自上面的链接)：

- android:state_activated: 设置是否被激活状态，true表示被激活，false表示未激活，API Level 11及以上才支持，可通过代码调用控件的setActivated(boolean)方法设置是否激活该控件
- android:state_hovered: 设置是否鼠标在上面滑动的状态，true表示鼠标在上面滑动，默认为false，API Level 14及以上才支持


Google Demo 

![Google selector Demo.png](http://upload-images.jianshu.io/upload_images/2746547-621476c866f9c56d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
