package me.microcool.popupwindowdemo;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * 参考  http://www.cnblogs.com/mengdd/p/3569127.html
 * PopupWindow的Demo
 */
public class PopupWindowActivity extends AppCompatActivity {
    private Context mContext;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        mContext = this;
        initView();
    }

    private void initView() {
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow(view);
            }
        });
    }

    /**
     * PopupWindow
     *
     * @param view
     */

    private void showPopupWindow(View view) {
        // 1.一个自定义布局，用来显示内容. 也是作为放入到popupwindow的参数
        View viewContent = LayoutInflater.from(mContext).inflate(R.layout.content_popup_window, null);
        Button popouWindowsButton = (Button) viewContent.findViewById(R.id.popup_window_button);

        popouWindowsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "button is pressed",
                        Toast.LENGTH_SHORT).show();
            }
        });
        // 2.创建popupwidow，并配置popupwindow
        PopupWindow mPopupWindow = new PopupWindow(viewContent, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("PopupWindowActivity", "onTouch : ");
                return false;

                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));//设置透明的背景，一定要设置背景，不然会有很多麻烦的事
        mPopupWindow.setAnimationStyle(R.style.anim_menu_bottombar);//设置动画，style是新添加的。

        // 设置好一系列参数之后再show，显示在一个参照物View的周围，有三个重载方法
        mPopupWindow.showAsDropDown(view,10,10, Gravity.CENTER);


    }
}
