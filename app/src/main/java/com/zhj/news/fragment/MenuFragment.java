package com.zhj.news.fragment;

import android.view.View;
import android.widget.TextView;

/**
 * Created by hasee on 2016/8/23.
 */
public class MenuFragment extends BaseFragment {


    @Override
    protected View initView() {
        TextView tv = new TextView(getActivity());
        tv.setText("菜单页面");
        return tv;
    }
}
