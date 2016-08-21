package com.zhj.news.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @项目名:ZhihuiBeijing
 * @包名:com.zhj.zhbj.utils
 * @类名:DimensUtils
 * @创建者:zhj
 * @描述:TODO:
 * @版本号:$Rev$
 * @更新者:$Author$
 * @更新时间:$Date$
 * @更新内容:TODO:
 */
public class DimensUtils
{

	public static int dp2px(Context context, int dp)
	{

		// 1px = 1dp * (dpi/160);
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		int dpi = metrics.densityDpi;
		return (int) (dp * (dpi / 160f) + 0.5f);
	}

	public static int px2dp(Context context, int px)
	{
		// 1dp = 1px * 160 /dpi;

		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		int dpi = metrics.densityDpi;
		return (int) (px * 160f / dpi + 0.5f);
	}

}
