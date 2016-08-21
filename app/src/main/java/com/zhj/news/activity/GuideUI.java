package com.zhj.news.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zhj.news.R;
import com.zhj.news.utils.DimensUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2016/8/21.
 */
public class GuideUI extends Activity {
    private ViewPager mViewPager;
    private List<ImageView> mDatas;
    private int[] icons = new int[]{R.mipmap.guide_1,R.mipmap.guide_2,R.mipmap.guide_3};
    private LinearLayout mPiontContainer;
    private int mPonitSpace; //两点的距离
    private View mSelectedPoint;
    private Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_guide);
        initView();
        initData();
    }



    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.guide_viewpager);
        mPiontContainer = (LinearLayout) findViewById(R.id.guide_point_container);
        mSelectedPoint = findViewById(R.id.guide_selected);
        mBtn = (Button) findViewById(R.id.guide_btn);
//        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener())过时

        mPonitSpace = DimensUtils.dp2px(this,20);//获得两点间距离
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //滑动时回调
                //position 滑动的页面
                //positionOffset 滑动的比例
                // positionOffsetPixels 滑动的像素
                int marginLeft = (int) (mPonitSpace*positionOffset +mPonitSpace*position+ 0.5f );
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mSelectedPoint.getLayoutParams();
                params.leftMargin = marginLeft;
                mSelectedPoint.setLayoutParams(params);

            }

            @Override
            public void onPageSelected(int position) {
                if (position == mDatas.size()-1){
                    mBtn.setVisibility(View.VISIBLE);
                }else {
                    mBtn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        mSelectedPoint.getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
//            @Override
//            public void onGlobalFocusChanged(View oldFocus, View newFocus) {
//              mPonitSpace =  mPiontContainer.getChildAt(1).getLeft()- mPiontContainer.getChildAt(0).getLeft();
//                //移除布局监听
//                mSelectedPoint.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//            }
//        });
    }

    private void initData() {

        mDatas = new ArrayList<>();
        for (int i = 0; i < icons.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(icons[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            mDatas.add(iv);

            //将点添加到集合
            View point = new View(this);
            point.setBackgroundResource(R.drawable.point_normal);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DimensUtils.dp2px(this,10),DimensUtils.dp2px(this,10));
            if(i!=0){
                params.leftMargin = DimensUtils.dp2px(this,10);
            }
            mPiontContainer.addView(point,params);
        }
        mViewPager.setAdapter(new GuideViewPager());
    }

    private class GuideViewPager extends PagerAdapter{

        @Override
        public int getCount() {
            if (mDatas!=null){
                return mDatas.size();
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view ==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //初始化

            ImageView iv = mDatas.get(position);
            //add to container
            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
