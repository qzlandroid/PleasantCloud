package cn.jinke.peasantcloud.fragment;

import java.util.ArrayList;
import java.util.List;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.activity.HomeSearchActivity;
import cn.jinke.peasantcloud.activity.MainActivity;
import cn.jinke.peasantcloud.adapter.ConsultLvAdapter;
import cn.jinke.peasantcloud.adapter.FragmentAdapter;
import cn.jinke.peasantcloud.view.NoScrollViewPager;
import cn.jinke.peasantcloud.view.SegmentView;
import cn.jinke.peasantcloud.view.SegmentView2;
import cn.jinke.peasantcloud.view.SegmentView2.onSegmentView2ClickListener;

/**
 * 农技咨询fragment
 */

public class ConsultFragment extends BaseFragment implements OnClickListener,onSegmentView2ClickListener{

	private ImageView consult_left_user,consult_img_search;
	private SlidingMenu slidingMenu;
	private NoScrollViewPager viewPager;
	private SegmentView2 segmentView;
	private List<Fragment> fraglist = new ArrayList<Fragment>();
	private FragmentAdapter mFragmentAdapter;

	private ConsultVpLeftFragment leftFragment;
	private ConsultVpCenterFragment centerFragment;
	private ConsultVpRightFragment rightFragment;

	private int page = 1;
	private View view;
	

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_consult, null);
		return view;
	}
	
	@Override
	public void initData() {
		viewPager = (NoScrollViewPager) view.findViewById(R.id.consult_vp);
		segmentView = (SegmentView2) view.findViewById(R.id.consult_seg);
		consult_left_user = (ImageView)view.findViewById(R.id.consult_img_user);
		consult_img_search = (ImageView)view.findViewById(R.id.consult_img_search);

		leftFragment = new ConsultVpLeftFragment();
		centerFragment = new ConsultVpCenterFragment();
		rightFragment = new ConsultVpRightFragment();
		fraglist.add(leftFragment);
		fraglist.add(centerFragment);
		fraglist.add(rightFragment);
		mFragmentAdapter = new FragmentAdapter(getChildFragmentManager(),
				fraglist);

		viewPager.setAdapter(mFragmentAdapter);
		viewPager.setCurrentItem(1);

		MainActivity main = (MainActivity) mActivity;
		slidingMenu = main.getSlidingMenu();
		initListener();
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		page = viewPager.getCurrentItem();
	}

	@Override
	public void onStop() {
		super.onStop();
		page = viewPager.getCurrentItem();
	}

	@Override
	public void onResume() {

		super.onResume();
		segmentView.setSelected(page);

	}
	
	private void initListener() {
		segmentView.setOnSegmentView2ClickListener(this);
		consult_left_user.setOnClickListener(this);
		consult_img_search.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.consult_img_user:
			slidingMenu.toggle();
			break;
		case R.id.consult_img_search:
			Intent intent = new Intent(getActivity(),HomeSearchActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

	@Override
	public void onSegmentView2Click(View v, int position) {
		if (position == 0) {
			viewPager.setCurrentItem(0, false);
		} else if (position == 1) {
			viewPager.setCurrentItem(1, false);
		}else if (position == 2) {
			viewPager.setCurrentItem(2, false);
		}
		
	}
}
