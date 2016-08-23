package com.zhj.news.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hasee on 2016/8/23.
 * fragment 的基类
 */
public abstract class BaseFragment extends Fragment {

    protected Activity mActivity; //宿主

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity(); //获得宿主
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        return initView();
    }

    @Override
    //fragment加载数据，一般重写此方法。
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract View initView();

    protected void initData() {
        //加载数据的方法，如果子类有数据加载，就复写此方法。
    }
}
