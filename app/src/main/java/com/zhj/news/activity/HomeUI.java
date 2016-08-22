package com.zhj.news.activity;

import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.zhj.news.R;

/**
 * Created by hasee on 2016/8/21.
 */
public class HomeUI extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_home);

        SlidingMenu slidingMenu = getSlidingMenu();


    }
}
