package com.zhj.news.activity;

import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.zhj.news.R;
import com.zhj.news.utils.DimensUtils;

/**
 * Created by hasee on 2016/8/21.
 */
public class HomeUI extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_home_content);
        setBehindContentView(R.layout.ui_home_menu);

        SlidingMenu slidingMenu = getSlidingMenu();
        //设置拖拽模式
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN); //内容全屏拖拽
        slidingMenu.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);//菜单全屏拖拽，菜单默认不能拖拽
        //设置菜单宽度
//        slidingMenu.setBehindOffset(DimensUtils.dp2px(this,200));//指内容部分宽度
        slidingMenu.setBehindWidth(DimensUtils.dp2px(this,140));//指菜单部分宽度
        //设置scroll scale
        slidingMenu.setBehindScrollScale(0.5f);
        //设置shadow
        slidingMenu.setShadowWidth(DimensUtils.dp2px(this,80));
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        //set mode
        slidingMenu.setMode(SlidingMenu.LEFT); //如果指定模式为leftright,需要设置setSecondaryMenu指定第二个菜单布局。
        

    }
}
