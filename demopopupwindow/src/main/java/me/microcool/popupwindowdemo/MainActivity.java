package me.microcool.popupwindowdemo;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * @author gaoshiwei
 */
public class MainActivity extends AppCompatActivity {
    private Button button;
    private Context mContext;
    private PopupWindow pw;
    private Button mButton;
    private Button mBtnMore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        // 底部PopupWindow
        button = (Button) findViewById(R.id.btn_bottom);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomPop(v);
            }
        });
        // view旁边的PopupWindow
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow(view);
            }
        });
        //
        mBtnMore = (Button) findViewById(R.id.btn_more);
        mBtnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMorePopupWindow(v);
            }

        });

    }

    /**
     * @param v
     */
    private void showMorePopupWindow(View v) {
        String[] titleList = {"item1", "item2", "item3", "item4"};
        View viewContent = LayoutInflater.from(mContext).inflate(R.layout.item_list_title, null);
        ListView listView = (ListView) viewContent.findViewById(R.id.list_title);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, titleList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "位置" + position, Toast.LENGTH_SHORT).show();
            }
        });

        listView.setAdapter(adapter);

        PopupWindow popupWindow = new PopupWindow(viewContent,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.showAsDropDown(v);


    }

    /**
     * 周围 PopupWindow
     *
     * @param view
     */

    private void showPopupWindow(View view) {
        // 1.一个自定义布局，用来显示内容. 也是作为放入到popupwindow的参数
        View viewContent = LayoutInflater.from(mContext).inflate(R.layout.content_popup_window, null);
        Button popouWindowsButton = (Button) viewContent.findViewById(R.id.popup_window_button);
        // 内部控件的事件
        popouWindowsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "button is pressed",
                        Toast.LENGTH_SHORT).show();
            }
        });
        // 2.创建popupwidow，并配置popupwindow
        PopupWindow mPopupWindow = new PopupWindow(viewContent, 400, ViewGroup.LayoutParams.WRAP_CONTENT, true);
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
        mPopupWindow.setAnimationStyle(R.style.anim_bottom);//设置动画，style是新添加的。

        // 设置好一系列参数之后再show，显示在一个参照物View的周围，有三个重载方法
        mPopupWindow.showAsDropDown(view, 10, 10, Gravity.CENTER);

    }

    /**
     * 底部PopupWindow
     *
     * @param v
     */
    private void showBottomPop(View v) {

        View viewContent = LayoutInflater.from(mContext).inflate(R.layout.bottom_pop, null);
        final Button one = (Button) viewContent.findViewById(R.id.jizihan);
        final Button two = (Button) viewContent.findViewById(R.id.liuchutian);
        final Button three = (Button) viewContent.findViewById(R.id.zhangyujie);
        // 内部事件的监听
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, one.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, two.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, three.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        // popupwindows
        pw = new PopupWindow(viewContent, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        pw.setTouchable(true);
        pw.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        pw.setAnimationStyle(R.style.anim_bottom);
        pw.setBackgroundDrawable(new ColorDrawable(0x00000000));
        // 要明白什么是父布局
        pw.showAtLocation(v, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }

}
