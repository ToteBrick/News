package com.zhj.news.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

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

    private ViewPager mViewPager ;
//    private List<TextView> mPagerDatas; //临时数据
//    private List<View> mPagerDatas; //临时数据
    private List<BaseController> mPagerDatas; //此时的controll相当数据
    @Override
    protected View initView() {
//        TextView tv =new TextView(getActivity());
//        tv.setText("内容页面");
//        return tv;
        View view = View.inflate(mActivity, R.layout.content, null);

        mViewPager = (ViewPager) view.findViewById(R.id.content_viewpager);
        return view;
    }

    @Override
    protected void initData() {
//        mPagerDatas = new ArrayList<TextView>();
//        for (int i = 0; i <5 ; i++) {
//            TextView tv = new TextView(mActivity);
//            tv.setText("页面:"+i);
//            tv.setTextColor(Color.RED);
//            tv.setTextSize(24);
//            tv.setGravity(Gravity.CENTER);
////            View.inflate(mActivity,layout,null);
//            mPagerDatas.add(tv);
//        }
//            Log.d("ContentFragment", "mPagerDatas:"+mPagerDatas);



        mPagerDatas = new ArrayList<BaseController>() ;
        //加载具体数据

        mPagerDatas.add(new HomeTabController(mActivity)); //首页
        mPagerDatas.add(new NewsCenterTabController(mActivity));//新闻中心
        mPagerDatas.add(new SmartServiceTabController(mActivity));//智慧服务
        mPagerDatas.add(new GovTabController(mActivity));//政务
        mPagerDatas.add(new SettingTabController(mActivity));//设置
        Log.d("ContentFragment", "mPagerDatas:"+mPagerDatas);
        //给viewpager加载数据
        mViewPager.setAdapter(new ContentPagerAdapter());
    }

    private class ContentPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            if (mPagerDatas == null) {
                return mPagerDatas.size();
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view ==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BaseController controller = mPagerDatas.get(position);
            //基类提供显示view方法由子类来实现
            View rootView = controller.getRootView();
            container.addView(rootView);
            return rootView; //标记
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
