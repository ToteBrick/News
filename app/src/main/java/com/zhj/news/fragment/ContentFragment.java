package com.zhj.news.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.zhj.news.R;
import com.zhj.news.controller.BaseController;
import com.zhj.news.controller.tab.GovTabController;
import com.zhj.news.controller.tab.HomeTabController;
import com.zhj.news.controller.tab.NewsCenterTabController;
import com.zhj.news.controller.tab.SettingTabController;
import com.zhj.news.controller.tab.SmartServiceTabController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2016/8/23.
 */
public class ContentFragment extends BaseFragment {

    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    // private List<TextView> mPagerDatas; // 临时显示数据

    private List<BaseController> mPagerDatas;

    private int CurrentTab;

    @Override
    protected View initView() {
        //
        // TextView tv = new TextView(getActivity());
        // tv.setText("内容页面");
        // return tv;
        View view = View.inflate(mActivity, R.layout.content, null);

        mViewPager = (ViewPager) view.findViewById(R.id.content_viewpager);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.content_rg);
        return view;
    }

    @Override
    protected void initData() {
        // // 模拟加载数据
        // mPagerDatas = new ArrayList<TextView>();
        // for (int i = 0; i < 5; i++)
        // {
        // TextView tv = new TextView(mActivity);
        // tv.setText("页面:" + i);
        // tv.setTextSize(20);
        // tv.setGravity(Gravity.CENTER);
        // tv.setTextColor(Color.RED);
        // mPagerDatas.add(tv);
        // //布局的加载，view.inflate(mActivity,layout,null); findviewbyid,
        // view对象的声明，数据加载
        // }
        // 新建页面对应数据
        mPagerDatas = new ArrayList<BaseController>();
        // 新建页面对应的数据
        mPagerDatas.add(new HomeTabController(mActivity)); // 首页部分
        mPagerDatas.add(new NewsCenterTabController(mActivity)); // 新闻中心
        mPagerDatas.add(new SmartServiceTabController(mActivity)); // 智慧服务
        mPagerDatas.add(new GovTabController(mActivity)); // 政务
        mPagerDatas.add(new SettingTabController(mActivity)); // 设置界面
        // 给viewpager加载数据
        mViewPager.setAdapter(new ContentPagerAdapter()); // list数据

        // 设置radiogroup选中监听
//        mRadioGroup.setOnCheckedChangeListener(this);

        // 设置默认选中项
//        mRadioGroup.check(R.id.content_rb_home);

    }

//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId)
//    {
//
//        switch (checkedId)
//        {
//            case R.id.content_rb_home:
//                CurrentTab = 0;
//                // 不可打开菜单
//                enableSlidingMenu(false);
//                break;
//            case R.id.content_rb_news:
//                CurrentTab = 1;
//                // 可打开菜单
//                enableSlidingMenu(true);
//                break;
//            case R.id.content_rb_smart:
//                CurrentTab = 2;
//                // 可打开菜单
//                enableSlidingMenu(true);
//                break;
//            case R.id.content_rb_gov:
//                CurrentTab = 3;
//                // 可打开菜单
//                enableSlidingMenu(true);
//                break;
//            case R.id.content_rb_setting:
//                CurrentTab = 4;
//                // 不可打开菜单
//                enableSlidingMenu(false);
//                break;
//
//            default:
//                break;
//        }
//
//        // viewpager需要切换到对应的页面
//        mViewPager.setCurrentItem(CurrentTab);
//
//    }

//    private void enableSlidingMenu(Boolean enable) {
//        HomeUI ui = (HomeUI) mActivity;
//        SlidingMenu slidingMenu = ui.getSlidingMenu();
//        slidingMenu.setTouchModeAbove(enable ? SlidingMenu.TOUCHMODE_FULLSCREEN : SlidingMenu.TOUCHMODE_NONE);
//    }

    private class ContentPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            if (mPagerDatas != null) {
                return mPagerDatas.size();
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TextView tv = mPagerDatas.get(position);
            // // 添加到container
            // container.addView(tv);
            // // 返回标记
            // return tv;

            BaseController controller = mPagerDatas.get(position);
            // 添加到container显示
            View rootView = controller.getRootView();
            container.addView(rootView);

            // 给controller加载数据
            controller.initData();
            // 返回标记
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

//    public void switchMenu(int position)
//    {
//        // 找到当前选中的controller
//        TabController controller = mPagerDatas.get(CurrentTab);
//
//        // 通知controller去切换菜单
//        controller.switchMenu(position);
//    }

}