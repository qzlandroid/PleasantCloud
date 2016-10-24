package cn.jinke.peasantcloud.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 首页轮播图ViewPager
 * @author QZ
 *
 */
public class HomeTabViewPager extends ViewPager {

	int startX;
	int startY;

	public HomeTabViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public HomeTabViewPager(Context context) {
		super(context);
	}

	/**
	 * 事件分发, 请求父控件及祖宗控件是否拦截事件 1. 右划, 而且是第一个页面, 需要父控件拦截 2. 左划, 而且是最后一个页面, 需要父控件拦截
	 * 3. 上下滑动, 需要父控件拦截
	 */
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		getParent().requestDisallowInterceptTouchEvent(true);
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			// 不要拦截,
																	// 这样是为了保证ACTION_MOVE调用
			startX = (int) ev.getRawX();
			startY = (int) ev.getRawY();
			break;
		case MotionEvent.ACTION_MOVE:

			int endX = (int) ev.getRawX();
			int endY = (int) ev.getRawY();

			if (Math.abs(endX - startX) > Math.abs(endY - startY)) {// 左右滑动
				if (endX > startX) {// 右划
					if (getCurrentItem() == 0) {// 第一个页面, 需要父控件拦截
						getParent().requestDisallowInterceptTouchEvent(false);
					}
				} else {// 左划
					if (getCurrentItem() == getAdapter().getCount() - 1) {// 最后一个页面,
																			// 需要拦截
						getParent().requestDisallowInterceptTouchEvent(false);
					}
				}
			} else {// 上下滑动
				getParent().requestDisallowInterceptTouchEvent(false);
			}

			break;

		default:
			break;
		}

		return super.dispatchTouchEvent(ev);
	}

}
