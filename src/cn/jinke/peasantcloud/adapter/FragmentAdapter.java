package cn.jinke.peasantcloud.adapter;

import java.util.ArrayList;
import java.util.List;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * 适用于ViewPager与fragment相关联的适配器
 * 
 * @author QZ
 * 
 */
public class FragmentAdapter extends FragmentPagerAdapter {

	List<Fragment> fragmentList = new ArrayList<Fragment>();

	public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
		super(fm);
		this.fragmentList = fragmentList;
	}

	@Override
	public Fragment getItem(int position) {
		return fragmentList.get(position);
	}

	@Override
	public int getCount() {
		return fragmentList.size();
	}

}
