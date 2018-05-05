package me.microcool.animationdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author gaoshiwei
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.anim_activity)
    Button animActivity;
    @BindView(R.id.anim_drawable)
    Button animDrawable;
    @BindView(R.id.anim_layout)
    Button animLayout;
    @BindView(R.id.anim_view)
    Button animView;

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = MainActivity.this;

        animActivity.setOnClickListener(this);
        animDrawable.setOnClickListener(this);
        animLayout.setOnClickListener(this);
        animView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.anim_activity:
                Intent intent = new Intent(mContext, SwitchoverActivity.class);
                startActivity(intent);
                //一定要在startActivity或者finishd的后面调用
                overridePendingTransition(R.anim.enter_anim, R.anim.out_anim);
                break;
            case R.id.anim_drawable:
                Intent intent1 = new Intent(mContext, FrameAnimActivity.class);
                startActivity(intent1);
                break;
            case R.id.anim_layout:
                Intent intent2 = new Intent(mContext, LayoutAnimActivity.class);
                startActivity(intent2);
                break;
            case R.id.anim_view:
                Intent intent3 = new Intent(mContext, ViewAnimActivity.class);
                startActivity(intent3);
                break;
            default:
        }

    }

}
