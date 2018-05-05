package com.gsw.evenbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // register EventBus
        EventBus.getDefault().register(this);

        button = (Button) findViewById(R.id.bt_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // post event
                EventBus.getDefault().post(new EventText("Button文字变换"));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregister
        EventBus.getDefault().unregister(this);
    }

    /**
     * 处理
     * （也就是订阅者）
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(EventText event) {
        button.setText(event.getText());
    }

    /**
     * Define events
     */
    public static class EventText {
        private String text;

        public EventText(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }


    }


}





