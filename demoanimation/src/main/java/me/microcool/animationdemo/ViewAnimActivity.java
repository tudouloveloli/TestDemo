package me.microcool.animationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewAnimActivity extends AppCompatActivity {

    @BindView(R.id.anim_translation)
    Button animTranslation;
    @BindView(R.id.anim_scale)
    Button animScale;
    @BindView(R.id.anim_rotate)
    Button animRotate;
    @BindView(R.id.anim_alpha)
    Button animAlpha;
    @BindView(R.id.view_iamge)
    ImageView viewIamge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_anim);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.anim_translation, R.id.anim_scale, R.id.anim_rotate, R.id.anim_alpha, R.id.view_iamge})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.anim_translation:
                TranslateAnimation translateAnimation = new TranslateAnimation(100,0,100,0);
                translateAnimation.setDuration(1000);
                viewIamge.setAnimation(translateAnimation);
                break;
            case R.id.anim_scale:
                break;
            case R.id.anim_rotate:
                break;
            case R.id.anim_alpha:
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(2000);
                viewIamge.setAnimation(alphaAnimation);
                break;
            case R.id.view_iamge:
                break;
        }
    }
}
