package me.microcool.testcode;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * RxJava2 interval实现验证码倒计时
 *
 * @author gaoshiwei
 */
public class SecurityCodeActivity extends AppCompatActivity {

    private Button mCodeBtn;
    private long count = 60;
    private Button mBtnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_code);
        mCodeBtn = (Button) findViewById(R.id.btn_code);

        mCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.interval(1, TimeUnit.SECONDS)
                        .take(count)
                        .map(new Function<Long, Long>() {
                            @Override
                            public Long apply(@NonNull Long aLong) throws Exception {
                                return count - aLong;
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                mCodeBtn.setEnabled(false);
                            }
                        }).subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        mCodeBtn.setText(aLong + "");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mCodeBtn.setEnabled(true);
                        mCodeBtn.setText("发送验证码");
                    }
                });
            }
        });
        mBtnToast = (Button) findViewById(R.id.btn_exit);
        RxView.clicks(mBtnToast).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                Toast.makeText(SecurityCodeActivity.this, "nihao", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
