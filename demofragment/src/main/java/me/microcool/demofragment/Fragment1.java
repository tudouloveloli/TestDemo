package me.microcool.demofragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 *
 * @author gaoshiwei
 */

public class Fragment1 extends Fragment {
    private static String ARG_PARAM = "param_key";
    private String mParam;
    private Context mContext;
    private Activity mActivity;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mParam = getArguments().getString(ARG_PARAM);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //需要注意的是inflate()的第三个参数是false，因为在Fragment内部实现中，会把该布局添加到container中，
        // 如果设为true，那么就会重复做两次添加，则会抛异常
        View view = inflater.inflate(R.layout.frg_loading, container, false);
        TextView t = (TextView) view.findViewById(R.id.tx_frg001);
        t.setText("aaaaaaaaaaaaaaaaaaaaaaa");
        return view;
    }

    public static Fragment1 newInstance(String str) {
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, str);
        Fragment1 fragment = new Fragment1();
        // 设置参数
        fragment.setArguments(args);
        return fragment;
    }

}
