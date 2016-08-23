package com.zhj.news.controller.tab;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.zhj.news.controller.BaseController;

/**
 * Created by hasee on 2016/8/23.
 */
public class SmartServiceTabController extends BaseController {
    public SmartServiceTabController(Context context) {
        super(context);
    }

    protected View initView(Context context) {

        //模拟数据
        TextView tv = new TextView(context);
        tv.setText("smart");
        return tv;
    }
}
