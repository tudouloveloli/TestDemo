package me.microcool.viewpagerindicator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by gaoshiwei on 2017/9/27.
 */

public class VpSimpleFragment extends Fragment {

    private String mTitle;

    private static final String BUNDLE_TITLE = "title";

    public static VpSimpleFragment newInstance(String title) {
//
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);

        VpSimpleFragment simpleFragment = new VpSimpleFragment();
        simpleFragment.setArguments(bundle);

        return simpleFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
        Bundle bundle = getArguments();

        if (bundle != null) {

            mTitle = bundle.getString(BUNDLE_TITLE);
        }
        TextView textView = new TextView(getContext());
        textView.setText("Hello");
        textView.setGravity(Gravity.CENTER);

        return textView;

    }
}
