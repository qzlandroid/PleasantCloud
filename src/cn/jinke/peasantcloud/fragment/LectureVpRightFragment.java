package cn.jinke.peasantcloud.fragment;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.activity.LiveActivity;
import cn.jinke.peasantcloud.adapter.LectureGridViewAdapter;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import cn.jinke.peasantcloud.view.MyGridView;
import android.R.integer;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 农技咨询直播fragment
 * 
 * @author QZ
 * 
 */
public class LectureVpRightFragment extends BaseFragment {

	private static final String[] AgricultureText = new String[] { "农业机械",
			"农技推广", "夷陵农业", "信息农业", "农业养殖", "农业执法", "中国农业", "农业种植", "农业科技" };
	private static final int[] AgriculturImg = { R.drawable.agriculture1,
			R.drawable.agriculture2, R.drawable.agriculture3,
			R.drawable.agriculture4, R.drawable.agriculture5,
			R.drawable.agriculture6, R.drawable.agriculture7,
			R.drawable.agriculture8, R.drawable.agriculture1 };
	private String[] img_text = { "正在直播", "直播预告", "往期精彩" };
	private int[] num = new int[] { 0, 1, 2 };
	private ListView lv_live;
	private View view;

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.lecture_vp_live, null);
		return view;
	}

	@Override
	public void initData() {
		lv_live = (ListView) view.findViewById(R.id.lecture_live_lv);
		lv_live.setAdapter(new LiveLvAdapter());
		//gv.setAdapter(new LiveGvAdapter());
	}
	class LiveLvAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(mActivity).inflate(
						R.layout.lecture_live_lv_item, parent, false);
			}
			MyGridView gv = BaseViewHolder.get(convertView,
					R.id.lecture_live_gv);
			gv.setAdapter(new LiveGvAdapter(num[position]));
			gv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {

					Intent intent = new Intent(mActivity, LiveActivity.class);
					startActivity(intent);

				}

			});
			TextView tv_category = BaseViewHolder.get(convertView,
					R.id.lecture_tv_category);
			View view = BaseViewHolder.get(convertView, R.id.lecture_view);
			if (position == 0) {
				view.setVisibility(View.GONE);
			}
			tv_category.setText(img_text[position]);
			return convertView;
		}
	}

	class LiveGvAdapter extends BaseAdapter {
		private int num;
		private int[] pager = new int[] { 6, 3, 5 };
		public LiveGvAdapter(int num) {
			this.num = num;
		}
		public int getCount() {
			// TODO Auto-generated method stub
			return pager[num];
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
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
						R.layout.lecture_live_gv_list, parent, false);
			}
			ImageView img_name = BaseViewHolder.get(convertView,
					R.id.live_gv_img);
			TextView tv_name = BaseViewHolder.get(convertView, R.id.live_gv_tv_title);

			img_name.setBackgroundResource(AgriculturImg[position]);
			tv_name.setText(AgricultureText[position]);
			return convertView;
		}
	}

}
