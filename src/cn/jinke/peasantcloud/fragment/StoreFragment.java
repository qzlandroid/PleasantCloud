package cn.jinke.peasantcloud.fragment;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.viewpagerindicator.CirclePageIndicator;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.activity.HomeSearchActivity;
import cn.jinke.peasantcloud.activity.MainActivity;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import cn.jinke.peasantcloud.view.HomeTabViewPager;
import android.R.string;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class StoreFragment extends BaseFragment implements OnClickListener {

	private View view;
	private SlidingMenu slidingMenu;
	private ImageView store_left_user, store_img_search;
	private HomeTabViewPager vp;
	private CirclePageIndicator sIndicator;
	private Handler mHandler;

	private static final int[] imgVp_ID = { R.drawable.store1,
			R.drawable.store2, R.drawable.store3, R.drawable.store4 };

	private static final int[] imgLv_ID = { R.drawable.storelv1,
			R.drawable.storelv2, R.drawable.storelv3, R.drawable.storelv4,
			R.drawable.storelv5, R.drawable.storelv6, R.drawable.storelv7,
			R.drawable.storelv8, R.drawable.storelv9, R.drawable.storelv10};

	private static final String[] names = { "京西密云农家西红柿500g不催熟自然熟大番茄新鲜蔬菜",
			"南汇农家现摘西瓜 1只装7-10斤 新鲜水果 西瓜8424", "新鲜黄粒嫩玉米棒笨玉米棒老式有机玉米棒现掰现发好吃",
			"马陆葡萄新鲜奶油巨峰夏黑玫瑰香葡萄水果胜新疆云南无籽", "王小二 新鲜苹果水果山东烟台栖霞红富士5斤",
			"果园现摘梨子新鲜翠玉梨水果梨青梨砀山酥梨雪梨皇冠梨5斤装贡梨", "新鲜水果红心火龙果云南西双版纳红肉火龙果热带水果 5斤送1斤",
			"精品黄瓜1斤约2根 新鲜蔬菜 秒杀菜市场生鲜超市沃鲜汇 ", "满188减100澳大利亚蜜柑6个约110g/个",
			"果宝广西百色田东大桂七大青芒果 新鲜水果 现货特价包邮5斤装 " };
	private static final String[] sells = { "120人已购买", "259人已购买", "526人已购买",
			"45人已购买", "277人已购买", "86人已购买", "120人已购买", "88人已购买", "159人已购买",
			"64人已购买" };
	private static final String[] prices = { "¥ 6.00", "¥ 49.00", "¥ 32.00",
			"¥ 99.00", "¥ 29.80", "¥ 25.80", "¥ 38.80", "¥ 5.90", "¥ 39.00",
			"¥ 59.90" };

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_store, null);
		return view;
	}

	@Override
	public void initData() {
		store_left_user = (ImageView) view.findViewById(R.id.store_img_user);
		store_img_search = (ImageView) view.findViewById(R.id.store_img_search);
		ListView lv = (ListView) view.findViewById(R.id.store_lv);
		View headerView = View.inflate(mActivity, R.layout.store_lv_header,
				null);
		lv.addHeaderView(headerView);
		vp = (HomeTabViewPager) headerView.findViewById(R.id.store_header_vp);
		sIndicator = (CirclePageIndicator) headerView
				.findViewById(R.id.sindicator);
		vp.setAdapter(new StoreVpAdapter());
		sIndicator.setViewPager(vp);
		sIndicator.setSnap(true);// 支持快照显示
		sIndicator.onPageSelected(0);// 让指示器重新定位到第一个点
		lv.setAdapter(new StoreLvAdapter());
		MainActivity main = (MainActivity) mActivity;
		slidingMenu = main.getSlidingMenu();
		initListener();
		autoPlay();
	}

	// 首页自动轮播图
	private void autoPlay() {
		if (mHandler == null) {
			mHandler = new Handler() {
				public void handleMessage(android.os.Message msg) {

					int currentItem = vp.getCurrentItem();
					if (currentItem < 3) {
						currentItem++;
					} else {
						currentItem = 0;
					}
					System.out.println("hahahha" + currentItem);
					vp.setCurrentItem(currentItem);// 切换到下一个页面
					mHandler.sendEmptyMessageDelayed(0, 3000);// 继续延时3秒发消息,
																// 形成循环
				};
			};

			mHandler.sendEmptyMessageDelayed(0, 3000);// 延时3秒后发消息
		}
	}

	class StoreVpAdapter extends PagerAdapter {
		@Override
		public int getCount() {
			return 4;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		public Object instantiateItem(ViewGroup container, int position) {
			View view = View
					.inflate(mActivity, R.layout.home_tab_vp_item, null);
			ImageView img = (ImageView) view.findViewById(R.id.home_tab_vp_img);
			img.setImageResource(imgVp_ID[position]);
			container.addView(view);
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}

	class StoreLvAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 10;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(mActivity).inflate(
						R.layout.store_lv_item, parent, false);
			}
			ImageView img = BaseViewHolder.get(convertView, R.id.lv_img);
			TextView name = BaseViewHolder.get(convertView, R.id.goods_name);
			TextView sell = BaseViewHolder.get(convertView, R.id.goods_sell);
			TextView price = BaseViewHolder.get(convertView, R.id.goods_price);
			img.setImageResource(imgLv_ID[position]);
			name.setText(names[position]);
			sell.setText(sells[position]);
			price.setText(prices[position]);
			return convertView;
		}

	}

	private void initListener() {
		store_left_user.setOnClickListener(this);
		store_img_search.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.store_img_user:
			slidingMenu.toggle();
			break;
		case R.id.store_img_search:
			Intent intent = new Intent(mActivity, HomeSearchActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}

	}

}
