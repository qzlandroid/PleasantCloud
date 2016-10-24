package cn.jinke.peasantcloud.fragment;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.activity.WorkPlanActivity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 侧边栏fragment
 * 
 * @author QZ
 * 
 */
public class LeftMenuFragment extends BaseFragment implements
		OnItemClickListener {

	private static final String[] LEFT_MENU_TEXT = new String[] { "农情提醒",
			"扫一扫", "消息中心", "待办事项", "系统设置" };
	private static final int[] LEFT_MENU_IMG = new int[] {
			R.drawable.home_left_menu_list1, R.drawable.home_left_menu_list2,
			R.drawable.home_left_menu_list3, R.drawable.home_left_menu_list4,
			R.drawable.home_left_menu_list5 };
	private View view;

	private ListView home_left_menu_lv;

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_left_menu, null);
		return view;
	}

	@Override
	public void initData() {
		home_left_menu_lv = (ListView) view
				.findViewById(R.id.home_left_menu_lv);
		home_left_menu_lv.setAdapter(new MenuAdapter());

		initListener();
	}

	private void initListener() {
		home_left_menu_lv.setOnItemClickListener(this);

	}

	class MenuAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 5;
		}

		@Override
		public Object getItem(int arg0) {
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
			View view = View.inflate(mActivity, R.layout.home_menu_lv_item,
					null);
			ImageView imageView = (ImageView) view
					.findViewById(R.id.home_left_menu_lv_img);
			TextView textView = (TextView) view
					.findViewById(R.id.home_left_menu_lv_text);
			imageView.setBackgroundResource(LEFT_MENU_IMG[position]);
			textView.setText(LEFT_MENU_TEXT[position]);
			return view;
		}

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		switch (position) {
		// 农情提醒
		case 0:
			break;
		// 扫一扫
		case 1:
			break;
		// 消息通知
		case 2:
			break;
		// 我的工作
		case 3:
			Intent intent = new Intent(mActivity, WorkPlanActivity.class);
			startActivity(intent);
			break;
		// 系统设置
		case 4:
			break;
		}
	}

}
