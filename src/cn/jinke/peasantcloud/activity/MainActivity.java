package cn.jinke.peasantcloud.activity;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.drawable;
import cn.jinke.peasantcloud.R.id;
import cn.jinke.peasantcloud.R.layout;
import cn.jinke.peasantcloud.fragment.ConsultFragment;
import cn.jinke.peasantcloud.fragment.ContentFragment;
import cn.jinke.peasantcloud.fragment.FriendFragment;
import cn.jinke.peasantcloud.fragment.HomeFragment;
import cn.jinke.peasantcloud.fragment.LectureFragment;
import cn.jinke.peasantcloud.fragment.LeftMenuFragment;
import cn.jinke.peasantcloud.utils.DensityUtils;
import cn.jinke.peasantcloud.utils.ImmersedStatusbarUtils;
import cn.jinke.peasantcloud.view.TabIndicatorView;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

public class MainActivity extends SlidingFragmentActivity {

	private static final String FRAGMENT_LEFT_MENU = "fragment_left_menu";
	private static final String FRAGMENT_CONTENT = "fragment_content";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		setContentView(R.layout.activity_main);
		// 设置左侧边栏布局
		setBehindContentView(R.layout.home_menu);
		SlidingMenu slidingMenu = getSlidingMenu();
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		// slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setBehindOffset(DensityUtils.dp2Px(this, 100));// 设置预留宽度

		initFragment();
	}

	private void initFragment() {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.replace(R.id.fl_left, new LeftMenuFragment(),
				FRAGMENT_LEFT_MENU);
		transaction.replace(R.id.fl_content, new ContentFragment(),
				FRAGMENT_CONTENT);
		transaction.commit();
	}

	// 获取侧边栏fragment
	public LeftMenuFragment getLeftMenuFragment() {
		FragmentManager fm = getSupportFragmentManager();
		LeftMenuFragment fragment = (LeftMenuFragment) fm
				.findFragmentByTag(FRAGMENT_LEFT_MENU);

		return fragment;
	}

	// 获取主页面fragment
	public ContentFragment getContentFragment() {
		FragmentManager fm = getSupportFragmentManager();
		ContentFragment fragment = (ContentFragment) fm
				.findFragmentByTag(FRAGMENT_CONTENT);

		return fragment;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		// 过滤按键动作
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {

			moveTaskToBack(true);

		}

		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onBackPressed() {

		moveTaskToBack(true);
		super.onBackPressed();
	}
}
