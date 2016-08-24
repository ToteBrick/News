package com.zhj.news.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @项目名:ZhihuiBeijing
 * @包名:com.zhj.zhbj.view
 * @类名:NoScrollViewPager
 * @创建者:zhj
 * @描述:不可以滑动的viewpager
 * @版本号:$Rev$
 * @更新者:$Author$
 * @更新时间:$Date$
 * @更新内容:
 */
public class NoScrollViewPager extends LazyViewPager
{

	public NoScrollViewPager(Context context) {
		this(context,null);

	}

	public NoScrollViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev)
	{
		//不消费
		return false;
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev)
	{
		//不拦截
		return false;
	}

}
