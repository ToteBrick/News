package com.zhj.news.controller;

import android.content.Context;
import android.view.View;

/**
 * Created by hasee on 2016/8/23.
 * 控制器基类
 */
public abstract class BaseController {
    protected Context mContext;

    //view ,model

    protected View mRootView;
    public BaseController(Context context) {
        //初始化view
        this.mContext = context;
//        mRootView = View.inflate();
        mRootView = initView(context);
    }
    //初始化controller显示的view
    protected abstract View initView(Context context);

         /**
         *提供显示的view
         */
    public View getRootView(){

        return mRootView;
    }

    /**
     * 提供加载数据的方法。
     */
    public void initData(){

    }
}
