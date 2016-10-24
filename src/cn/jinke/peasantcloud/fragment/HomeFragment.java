package cn.jinke.peasantcloud.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.view.HomeTabViewPager;
import cn.jinke.peasantcloud.view.NoScrollViewPager;
import cn.jinke.peasantcloud.view.SegmentView;
import cn.jinke.peasantcloud.view.SegmentView.onSegmentViewClickListener;

import cn.jinke.peasantcloud.activity.HomeSearchActivity;
import cn.jinke.peasantcloud.activity.MainActivity;
import cn.jinke.peasantcloud.adapter.FragmentAdapter;
import cn.jinke.peasantcloud.adapter.HomeTabLvAdapter;
import cn.jinke.peasantcloud.adapter.HomeTabVpAdapter;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.TabPageIndicator;

/**
 * 主页面fragment,包含农业资讯和专家栏目两个fragment
 */

public class HomeFragment extends BaseFragment implements OnClickListener,
		OnPageChangeListener {

	private ViewPager viewPager;
	private SlidingMenu slidingMenu;
	private ImageView home_left_user, home_img_search;
	private HomeTabViewPager tab_vp;
	private View view;

	private TabPageIndicator indicator;
	private static final String[] category = new String[] { "应时农业", "农业科技",
			"品牌农资", "农业政策", "市场行情", "供求信息","质量监督" };
	private Handler mHandler;
	private HomeVpFragment hVpFragment;
	
	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_home, null);
		return view;
	}

	@Override
	public void initData() {
		viewPager = (ViewPager) view.findViewById(R.id.home_vp);
		indicator = (TabPageIndicator) view.findViewById(R.id.indicator);
		home_left_user = (ImageView) view.findViewById(R.id.home_img_user);
		home_img_search = (ImageView) view.findViewById(R.id.home_img_search);
		viewPager.setAdapter(new HomeVpAdapter());
		indicator.setViewPager(viewPager);
		MainActivity main = (MainActivity) mActivity;
		slidingMenu = main.getSlidingMenu();
		initListener();
	}

	private void initListener() {
		indicator.setOnPageChangeListener(this);
		home_left_user.setOnClickListener(this);
		home_img_search.setOnClickListener(this);		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.home_img_user:
			slidingMenu.toggle();
			break;
		case R.id.home_img_search:
			Intent intent = new Intent(mActivity, HomeSearchActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}
	
	class HomeVpAdapter extends PagerAdapter {
		
		@Override
		public CharSequence getPageTitle(int position) {
			return category[position];
		}

		@Override
		public int getCount() {
			return category.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		public Object instantiateItem(ViewGroup container, int position) {
			hVpFragment = new HomeVpFragment(mActivity);
			container.addView(hVpFragment.mview);			
			return hVpFragment.mview;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}

	
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		if (arg0 == 0) {//只有在第一个页面, 侧边栏才允许出来
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		} else {
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		}
	}
	
	

}
