package cn.jinke.peasantcloud.fragment;

import com.viewpagerindicator.CirclePageIndicator;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.activity.VideoContentActivity;
import cn.jinke.peasantcloud.adapter.HomeTabLvAdapter;
import cn.jinke.peasantcloud.adapter.HomeTabVpAdapter;
import cn.jinke.peasantcloud.adapter.LectureGridViewAdapter;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import cn.jinke.peasantcloud.view.HomeTabViewPager;
import cn.jinke.peasantcloud.view.MyGridView;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
/**
 * 农业资讯Fragment
 * @author QZ
 *
 */
public class HomeVpFragment{


	public View mview;
	private ListView lv;
	private HomeTabViewPager tab_vp;
	private CirclePageIndicator mIndicator;
	private Activity mActivity;
	private Handler mHandler;
	
	public HomeVpFragment(Activity activity) {
		mActivity = activity;
		initView();
	}
	public View initView() {
		mview = View.inflate(mActivity, R.layout.home_vp_item, null);
		initData();
		return mview;
		
	}


	public void initData() {
		View headerView = View.inflate(mActivity, R.layout.home_tab_lv_header, null);
		tab_vp = (HomeTabViewPager) headerView.findViewById(R.id.vp_news);
		mIndicator = (CirclePageIndicator) headerView.findViewById(R.id.mindicator);
		lv = (ListView) mview.findViewById(R.id.home_tab_lv);
		lv.addHeaderView(headerView);
		tab_vp.setAdapter(new HomeTabVpAdapter(mActivity));
		mIndicator.setViewPager(tab_vp);
		mIndicator.setSnap(true);// 支持快照显示
		mIndicator.onPageSelected(0);// 让指示器重新定位到第一个点			
		lv.setAdapter(new HomeTabLvAdapter(mActivity));
		autoPlay();
	}	
	//首页自动轮播图
	private void autoPlay() {
		if (mHandler == null) {
			mHandler = new Handler() {
				public void handleMessage(android.os.Message msg) {
					
					int currentItem = tab_vp.getCurrentItem();
					if (currentItem < 3) {
						currentItem++;
					} else {
						currentItem = 0;
					}
					System.out.println("hahahha"+currentItem);
					tab_vp.setCurrentItem(currentItem);// 切换到下一个页面
					mHandler.sendEmptyMessageDelayed(0, 3000);// 继续延时3秒发消息,
																// 形成循环
				};
			};
	
			mHandler.sendEmptyMessageDelayed(0, 3000);// 延时3秒后发消息
		}
	}
}
