package com.zhj.news.controller;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.zhj.news.R;
import com.zhj.news.fragment.HomeUI;

/**
 * tab对应的controller基类.
 */
public abstract class TabController extends BaseController
{

    protected TextView mTvTitle;
    protected ImageView mIvMenu;
    protected FrameLayout mContentLayout;
    public TabController(Context context) {
        super(context);

    }

    @Override
    protected View initView(Context context)
    {
        //title相同
        View view = View.inflate(context, R.layout.tab_layout, null);
        mTvTitle = (TextView) view.findViewById(R.id.tab_tv_title);
        mIvMenu = (ImageView) view.findViewById(R.id.tab_iv_menu);
        mContentLayout = (FrameLayout) view.findViewById(R.id.tab_content);
        //内容不同,交给子类去实现具体内容部分显示
        mContentLayout.addView(initContentView(context));

        mIvMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                //打开菜单
                HomeUI ui = (HomeUI) mContext;
                SlidingMenu slidingMenu = ui.getSlidingMenu();
                slidingMenu.toggle();
            }
        });
        return view;
    }

    //初始化内容部分的view
    protected abstract View initContentView(Context context);

    //切换菜单,如果子类有切换菜单的功能，复写此方法。
    public void switchMenu(int position)
    {

    }

}
