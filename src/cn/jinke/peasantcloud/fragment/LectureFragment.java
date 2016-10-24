package cn.jinke.peasantcloud.fragment;

import java.util.ArrayList;
import java.util.List;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.activity.HomeSearchActivity;
import cn.jinke.peasantcloud.activity.MainActivity;
import cn.jinke.peasantcloud.adapter.FragmentAdapter;
import cn.jinke.peasantcloud.view.NoScrollViewPager;
import cn.jinke.peasantcloud.view.SegmentView;
import cn.jinke.peasantcloud.view.SegmentView.onSegmentViewClickListener;
import cn.jinke.peasantcloud.view.SegmentView2;
import cn.jinke.peasantcloud.view.SegmentView2.onSegmentView2ClickListener;

/**
 * 专家栏目fragment,包含专题和讲座两个子fragment
 */

public class LectureFragment extends BaseFragment implements
		onSegmentViewClickListener, OnClickListener {

	private NoScrollViewPager viewPager;
	private SegmentView segmentView;
	private SlidingMenu slidingMenu;
	private ImageView lecture_left_user, lecture_img_search;

	private List<Fragment> fraglist = new ArrayList<Fragment>();
	private FragmentAdapter mFragmentAdapter;

	private LectureVpLeftFragment leftFragment;
	private LectureVpRightFragment rightFragment;

	private int page = 0;
	private View view;

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_lecture, null);
		return view;
	}

	@Override
	public void initData() {
		viewPager = (NoScrollViewPager) view.findViewById(R.id.lecture_vp);
		segmentView = (SegmentView) view.findViewById(R.id.lecture_seg);
		lecture_left_user = (ImageView) view
				.findViewById(R.id.lecture_img_user);
		lecture_img_search = (ImageView) view
				.findViewById(R.id.lecture_img_search);

		leftFragment = new LectureVpLeftFragment();
		rightFragment = new LectureVpRightFragment();
		fraglist.add(leftFragment);
		fraglist.add(rightFragment);
		mFragmentAdapter = new FragmentAdapter(getChildFragmentManager(),
				fraglist);

		viewPager.setAdapter(mFragmentAdapter);
		viewPager.setCurrentItem(0);

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
		segmentView.setOnSegmentViewClickListener(this);
		lecture_left_user.setOnClickListener(this);
		lecture_img_search.setOnClickListener(this);
	}

	@Override
	public void onSegmentViewClick(View v, int position) {
		if (position == 0) {
			viewPager.setCurrentItem(0, false);
		} else if (position == 1) {
			viewPager.setCurrentItem(1, false);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.lecture_img_user:
			slidingMenu.toggle();
			break;
		case R.id.lecture_img_search:
			Intent intent = new Intent(getActivity(), HomeSearchActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}

	}
}
