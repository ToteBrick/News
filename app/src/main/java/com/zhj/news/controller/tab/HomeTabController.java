package com.zhj.news.controller.tab;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.zhj.news.controller.TabController;

/**
 * Created by hasee on 2016/8/23.
 */
public class HomeTabController extends TabController {
    public HomeTabController(Context context) {
        super(context);
    }


    @Override
    protected View initContentView(Context context) {
        //模拟数据
        TextView tv = new TextView(context);
        tv.setText("首页");
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(20);
        tv.setTextColor(Color.RED);
        return tv;
    }

    @Override
    public void initData() {
        mTvTitle.setText("首页");
        mIvMenu.setVisibility(View.GONE);
    }
}
