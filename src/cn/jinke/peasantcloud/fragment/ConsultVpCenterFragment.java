package cn.jinke.peasantcloud.fragment;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.activity.VideoContentActivity;
import cn.jinke.peasantcloud.adapter.LectureGridViewAdapter;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import cn.jinke.peasantcloud.view.MyGridView;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
/**
 * 农技咨询知识库fragment
 * @author QZ
 *
 */
public class ConsultVpCenterFragment extends BaseFragment {

	private String[] img_text = { "作物", "家禽", "肥料" };
	private int[] num = new int[] { 0, 1, 2 };
	private View view;
	private ListView lv;

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.lecture_vp_knowledge, null);
		return view;
	}

	@Override
	public void initData() {
		lv = (ListView) view.findViewById(R.id.lecture_knowledge_lv);
		lv.setAdapter(new KnowledgeLvAdapter());
	}

	class KnowledgeLvAdapter extends BaseAdapter {

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
						R.layout.lecture_knowledge_lv_item, parent, false);
			}
			MyGridView gv = BaseViewHolder.get(convertView,
					R.id.lecture_knowledge_gv);
			gv.setAdapter(new LectureGridViewAdapter(mActivity, num[position]));
			gv.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {

					Intent intent = new Intent(mActivity,
							VideoContentActivity.class);
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
}
