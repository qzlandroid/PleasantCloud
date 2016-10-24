package cn.jinke.peasantcloud.fragment;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.activity.ExpertActivity;
import cn.jinke.peasantcloud.activity.ExpertInfoActivity;
import cn.jinke.peasantcloud.activity.VideoContentActivity;
import cn.jinke.peasantcloud.adapter.LectureGridViewAdapter;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import cn.jinke.peasantcloud.view.CircularImage;
import cn.jinke.peasantcloud.view.MyGridView;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 农技讲堂 专题fragment
 * 
 * @author QZ
 * 
 */
public class LectureVpLeftFragment extends BaseFragment {

	private static final int[] header_imgs = { R.drawable.header1,
			R.drawable.header2, R.drawable.header3, R.drawable.header4,
			R.drawable.header5, R.drawable.header5, R.drawable.header7,
			R.drawable.header8, R.drawable.header9, R.drawable.header10,
			R.drawable.header10 };
	
	private static final int[] imgLv_ID = { R.drawable.storelv1,
		R.drawable.storelv2, R.drawable.storelv3, R.drawable.storelv4,
		R.drawable.storelv5, R.drawable.storelv6, R.drawable.storelv7,
		R.drawable.storelv8, R.drawable.storelv9, R.drawable.storelv10};

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

	private View view;

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.lecture_vp_special, null);
		return view;
	}

	@Override
	public void initData() {
		ListView lv = (ListView) view.findViewById(R.id.lecture_special_lv);
		lv.setAdapter(new LectureSpecialAdapter());
	}

	class LectureSpecialAdapter extends BaseAdapter {

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
						R.layout.lecture_special_lv_item, parent, false);
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
			
//			img.setOnClickListener(new OnClickListener() {
//				
//				@Override
//				public void onClick(View arg0) {
//					Intent intent = new Intent(LectureVpLeftFragment.this,
//							ExpertInfoActivity.class);
//					startActivity(intent);
//					
//				}
//			});

			header.setImageResource(header_imgs[position]);
			return convertView;
		}

	}
}
