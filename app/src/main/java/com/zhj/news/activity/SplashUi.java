package com.zhj.news.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

import com.zhj.news.R;
import com.zhj.news.utils.PreferenceUtils;

public class SplashUi extends Activity {

    public static final java.lang.String KEY_FIRST_ENTER = "key_first_enter";
    private View mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_splash);

        initView();
    }

    private void initView() {
        mRootView = findViewById(R.id.splash_root);

        RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_PARENT, 0.5f,
                Animation.RELATIVE_TO_PARENT, 0.5f);

        ScaleAnimation scale = new ScaleAnimation(0f, 1f, Animation.RELATIVE_TO_PARENT, 0.5f,
                Animation.RELATIVE_TO_PARENT, 0.5f);

        AlphaAnimation alpha = new AlphaAnimation(0, 1);

        AnimationSet set = new AnimationSet(false);
        set.addAnimation(rotate);
        set.addAnimation(scale);
        set.addAnimation(alpha);
        set.setDuration(1000);
        set.setAnimationListener(new SplashAnimationListner());
        mRootView.startAnimation(set);
    }

    private class SplashAnimationListner implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            //动画完成第一次进入向导，否则进主页

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            boolean flag = PreferenceUtils.getBoolean(getApplicationContext(), KEY_FIRST_ENTER, true);

            if (flag) {
                Log.d("SplashUi", "guide");

                Intent intent = new Intent(SplashUi.this, GuideUI.class);
                startActivity(intent);
                finish();
            } else {
                Log.d("SplashUi", "home");
                Intent intent = new Intent(SplashUi.this,HomeUI.class);
                startActivity(intent);
                finish();
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
