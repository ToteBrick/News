package com.zhj.news.fragment;

import android.view.View;
import android.widget.TextView;

/**
 * Created by hasee on 2016/8/23.
 */
public class ContentFragment extends BaseFragment {


    @Override
    protected View initView() {
        TextView tv =new TextView(getActivity());
        tv.setText("内容页面");
        return tv;
    }
}
