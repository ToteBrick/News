package com.zhj.news.controller;

import android.view.View;

/**
 * Created by hasee on 2016/8/23.
 * 控制器基类
 */
public abstract class BaseController {

    //view ,model

    protected View mRootView;
    public BaseController() {
        //初始化view
//        mRootView = View.inflate();
        mRootView = initView();
    }
    //初始化controller显示的view
    protected abstract View initView();

    /*
        *提供显示的view
         */
    public View getRootView(){

        return mRootView;
    }
}
