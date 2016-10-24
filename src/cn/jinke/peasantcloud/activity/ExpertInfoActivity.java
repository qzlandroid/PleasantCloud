package cn.jinke.peasantcloud.activity;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.layout;
import cn.jinke.peasantcloud.R.menu;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import cn.jinke.peasantcloud.view.CircularImage;
import cn.jinke.peasantcloud.view.MyListView;
import cn.jinke.peasantcloud.view.NoScrollViewPager;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ExpertInfoActivity extends Activity implements OnClickListener {

	private static final int[] header_imgs = { R.drawable.header1,
			R.drawable.header2, R.drawable.header3, R.drawable.header4,
			R.drawable.header5, R.drawable.header5, R.drawable.header7,
			R.drawable.header8, R.drawable.header9, R.drawable.header10,
			R.drawable.header10 };

	private static final int[] imgLv_ID = { R.drawable.storelv1,
			R.drawable.storelv2, R.drawable.storelv3, R.drawable.storelv4,
			R.drawable.storelv5, R.drawable.storelv6, R.drawable.storelv7,
			R.drawable.storelv8, R.drawable.storelv9, R.drawable.storelv10 };

	private static final String[] names = { "农民老张", "小李子", "瓜熟蒂落", "快乐的种植户",
			"农民养殖户", "今年又丰收啦", "农民小赵", "种田小能手", "轩轩的一个梦想", "设计师" };

	public static final String[] commons = { "12", "18", "69", "42", "36",
			"25", "19", "42", "74", "36", "45", "69" };
	public static final String[] times = { "2016-07-03", "2016-07-16",
			"2016-07-24", "2016-07-28", "2016-08-05", "2016-08-18",
			"2016-08-14", "2016-08-12", "2016-08-10", "2016-07-29",
			"2016-07-16", "2016-08-08" };

	public static final String[] contents = { "克东县马铃薯大垄高产栽培技术", "番茄蒂腐病怎么治",
			"小麦生长中后期病虫防治尤为关键", "番茄落花落果的原因及防治方法", "春播玉米栽培技术及病虫害防治",
			"杭晚蜜柚优质高产栽培技术", "渭北苹果整形修剪存在的问题及对策", "春茬韭菜怎么管理才能获得高收成 ",
			"大豆45厘米双条密植栽培技术 ", "苦瓜进入开花坐果期应该注意什么" };

	private RelativeLayout rl_answer;
	private RelativeLayout rl_article;
	private View view_answer;
	private View view_article;
	private ImageView back;
	private NoScrollViewPager vp;

	private MyListView lv;

	private ScrollView sl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expert_info);
		initView();
		initListener();
	}

	private void initView() {
		back = (ImageView) findViewById(R.id.expert_info_back);
		rl_answer = (RelativeLayout) findViewById(R.id.rl_answer);
		rl_article = (RelativeLayout) findViewById(R.id.rl_article);
		sl = (ScrollView) findViewById(R.id.ep_info_sl);
		view_answer = findViewById(R.id.view_answer);
		view_article = findViewById(R.id.view_article);
		lv = (MyListView)findViewById(R.id.ep_info_lv);
		lv.setAdapter(new ExpertInfoLvAdapter());
		sl.smoothScrollTo(0,20);
	}

	private void initListener() {
		back.setOnClickListener(this);
		rl_answer.setOnClickListener(this);
		rl_article.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.expert_info_back:
			finish();
			break;
		case R.id.rl_answer:
			lv.setAdapter(new ExpertInfoLvAdapter());
			view_answer.setBackgroundColor(getResources().getColor(
					R.color.colorMain));
			view_article.setBackgroundColor(getResources().getColor(
					R.color.view_normal));
			break;
		case R.id.rl_article:
			lv.setAdapter(new ExpertInfoLvAdapter());
			view_answer.setBackgroundColor(getResources().getColor(
					R.color.view_normal));
			view_article.setBackgroundColor(getResources().getColor(
					R.color.colorMain));
			break;
		default:
			break;
		}

	}

	/*class EpInfoAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View view = View.inflate(ExpertInfoActivity.this,
					R.layout.expert_info_vp_item, null);
			MyListView lv = (MyListView) view.findViewById(R.id.ep_info_lv);
			lv.setAdapter(new ExpertInfoLvAdapter());
			container.addView(view);
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

	}*/

	class ExpertInfoLvAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 5;
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
				convertView = LayoutInflater.from(ExpertInfoActivity.this)
						.inflate(R.layout.lecture_special_lv_item, parent,
								false);
			}

			CircularImage header = BaseViewHolder.get(convertView,
					R.id.lecture_lv_header);
			TextView name = BaseViewHolder.get(convertView,
					R.id.lecture_lv_name);
			TextView content = BaseViewHolder.get(convertView,
					R.id.lecture_left_tv_content);
			TextView common = BaseViewHolder.get(convertView,
					R.id.tv_lecture_comment);
			TextView date = BaseViewHolder.get(convertView,
					R.id.tv_lecture_date);
			ImageView img = BaseViewHolder.get(convertView,
					R.id.lecture_left_img);

			name.setText(names[position]);
			content.setText(contents[position]);
			common.setText(commons[position]);
			date.setText(times[position]);
			img.setImageResource(imgLv_ID[position]);

			header.setImageResource(header_imgs[position]);
			return convertView;
		}

	}

}
