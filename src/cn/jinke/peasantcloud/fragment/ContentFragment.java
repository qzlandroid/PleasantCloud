package cn.jinke.peasantcloud.fragment;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.view.TabIndicatorView;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

/**
 * 主页面的fragment,内部包含四个fragment
 * 
 * @author QZ
 * 
 */
public class ContentFragment extends BaseFragment implements
		OnTabChangeListener {

	private static final String TAB_HOME = "home"; // 首页
	private static final String TAB_FRIEND = "friend"; // 农友圈
	private static final String TAB_LECTURE = "lecture"; // 农技讲堂
	private static final String TAB_CONSULT = "consult"; // 农技咨询
	private static final String TAB_STORE = "store"; //农资商城

	private TabIndicatorView IndicatorHome;
	private TabIndicatorView IndicatorFriend;
	private TabIndicatorView IndicatorLecture;
	private TabIndicatorView IndicatorConsult;
	private TabIndicatorView IndicatorStore;

	private FragmentTabHost tabHost;
	private View view;

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_content, null);
		return view;
	}

	private void initListener() {
		tabHost.setOnTabChangedListener(this);
	}

	@Override
	public void initData() {
		// 初始化TabHost
		tabHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
		tabHost.setup(mActivity, getFragmentManager(), android.R.id.tabcontent);
		// 新建TabSpec
		TabHost.TabSpec spec = tabHost.newTabSpec(TAB_HOME);
		// 新建Indicator，并设置Indicator属性
		IndicatorHome = new TabIndicatorView(mActivity);
		IndicatorHome.setTabTitle("农业资讯");
		IndicatorHome.setTabIcon(R.drawable.tab_home_normal,
				R.drawable.tab_home_focus);
		spec.setIndicator(IndicatorHome);
		// 添加TabSpec
		tabHost.addTab(spec, HomeFragment.class, null);

		spec = tabHost.newTabSpec(TAB_FRIEND);
		IndicatorFriend = new TabIndicatorView(mActivity);
		IndicatorFriend.setTabTitle("农友圈");
		IndicatorFriend.setTabIcon(R.drawable.tab_friend_normal,
				R.drawable.tab_friend_focus);
		spec.setIndicator(IndicatorFriend);
		tabHost.addTab(spec, FriendFragment.class, null);

		spec = tabHost.newTabSpec(TAB_LECTURE);
		IndicatorLecture = new TabIndicatorView(mActivity);
		IndicatorLecture.setTabTitle("专家栏目");
		IndicatorLecture.setTabIcon(R.drawable.tab_lecture_normal,
				R.drawable.tab_lecture_focus);
		spec.setIndicator(IndicatorLecture);
		tabHost.addTab(spec, LectureFragment.class, null);

		spec = tabHost.newTabSpec(TAB_CONSULT);
		IndicatorConsult = new TabIndicatorView(mActivity);
		IndicatorConsult.setTabTitle("农技咨询");
		IndicatorConsult.setTabIcon(R.drawable.tab_consult_normal,
				R.drawable.tab_consult_focus);
		spec.setIndicator(IndicatorConsult);
		tabHost.addTab(spec, ConsultFragment.class, null);
		
		spec = tabHost.newTabSpec(TAB_STORE);
		IndicatorStore = new TabIndicatorView(mActivity);
		IndicatorStore.setTabTitle("农资商城");
		IndicatorStore.setTabIcon(R.drawable.tabbar_shop_normal,
				R.drawable.tabbar_shop_on);
		spec.setIndicator(IndicatorStore);
		tabHost.addTab(spec, StoreFragment.class, null);

		// 去掉Indicator之间的分割线
		tabHost.getTabWidget().setDividerDrawable(android.R.color.white);
		// 初始化tab选中
		tabHost.setCurrentTabByTag(TAB_HOME);
		IndicatorHome.setTabSelected(true);
		initListener();
	}

	@Override
	public void onTabChanged(String tag) {
		IndicatorHome.setTabSelected(false);
		IndicatorFriend.setTabSelected(false);
		IndicatorLecture.setTabSelected(false);
		IndicatorConsult.setTabSelected(false);
		IndicatorStore.setTabSelected(false);

		// 通过tag判断哪个标签被选中，设置选中状态为true，并切换对应的Fragment
		if (TAB_HOME.equals(tag)) {
			tabHost.setCurrentTabByTag(TAB_HOME);
			IndicatorHome.setTabSelected(true);
		} else if (TAB_FRIEND.equals(tag)) {
			tabHost.setCurrentTabByTag(TAB_FRIEND);
			IndicatorFriend.setTabSelected(true);
		} else if (TAB_LECTURE.equals(tag)) {
			tabHost.setCurrentTabByTag(TAB_LECTURE);
			IndicatorLecture.setTabSelected(true);
		} else if (TAB_CONSULT.equals(tag)) {
			tabHost.setCurrentTabByTag(TAB_CONSULT);
			IndicatorConsult.setTabSelected(true);
		}else if (TAB_STORE.equals(tag)) {
			tabHost.setCurrentTabByTag(TAB_STORE);
			IndicatorStore.setTabSelected(true);
		}
	}

}
