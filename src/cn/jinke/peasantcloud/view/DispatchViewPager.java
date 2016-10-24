package cn.jinke.peasantcloud.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class DispatchViewPager extends ViewPager {

	public DispatchViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public DispatchViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 事件分发,请求父控件是否拦截
	 */
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// 当当前页为第0页时,侧边栏可以拉出
		if (getCurrentItem() != 0) {
			getParent().requestDisallowInterceptTouchEvent(true); // 请求父控件不要拦截,这样viewpager就可以滑动了
		} else {
			getParent().requestDisallowInterceptTouchEvent(false); // 拦截,侧边栏可以拉出
		}
		return super.dispatchTouchEvent(ev);
	}
}
