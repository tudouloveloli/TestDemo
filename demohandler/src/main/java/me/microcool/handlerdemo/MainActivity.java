package me.microcool.handlerdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindAnim;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.progress)
    ProgressBar progress;
    private String imageUrl = "http://upload-images.jianshu.io/upload_images/1518705-bf3ff7b1514b2309.jpg?imageMogr2/auto-orient/strip";
    @BindView(R.id.textname)
    TextView textname;
    @BindView(R.id.change_text)
    Button changeText;
    @BindView(R.id.btn_thread1)
    Button btnThread1;
    @BindView(R.id.btn_thread2)
    Button btnThread2;
    @BindView(R.id.btn_download)
    Button btnDownload;
    @BindView(R.id.image)
    ImageView image;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    textname.setText("我变身了");
                    textname.setTextSize(25);
                    break;
                case 1:
                    Toast.makeText(getApplicationContext(), "UI线程收到了工作线程1的消息", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(getApplicationContext(), "UI线程收到了工作线程2的消息", Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    progress.setVisibility(View.VISIBLE);
                    Glide.with(MainActivity.this).load(imageUrl).into(image);
                    if (progress.getVisibility() == View.VISIBLE) {
                        progress.setVisibility(View.GONE);
                    }

                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progress.setVisibility(View.GONE);

        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // post方式中最好也设置到新线程中
//                1.post()
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        textname.setText("gaoshiwei");
//                    }
//                });

//                2.postDelayed()
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        textname.setText("gaoshiwei");
//                    }
//                }, 5000);

//                3. sendMessage()

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // 创建Message对象，这是最好的方式
                        Message message = Message.obtain();
                        message.what = 0;
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });
        // 线程1 发送消息
        btnThread1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 开启一个线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // ... 可以是其他的逻辑代码
                        //创建消息 这种方式不好
                        Message message = new Message();
                        message.what = 1;
                        message.obj = "这是线程1的消息";
                        // 发送到消息队列
                        handler.sendMessage(message);

                    }
                }).start();
            }
        });
        // 线程2 发送消息
        btnThread2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 开启一个线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // ... 可以是其他的逻辑代码
                        // 另外一种创建消息的方式,这种也不错
                        Message message = handler.obtainMessage();
                        message.what = 2;
                        message.obj = "这是线程2的消息";
                        message.sendToTarget();
                        //  也可以这样写 handler.sendMessage(message);
                    }
                }).start();
            }
        });

        //
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = handler.obtainMessage();
                        message.what = 4;
                        handler.sendMessage(message);

                    }
                }).start();
            }
        });


    }
}
