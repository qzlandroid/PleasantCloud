package cn.jinke.peasantcloud.activity;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.id;
import cn.jinke.peasantcloud.R.layout;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import cn.jinke.peasantcloud.view.MyListView;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 专家页面
 * 
 * @author QZ
 * 
 */
public class ExpertActivity extends Activity implements OnClickListener {

	private ListView lv;
	private ImageView back;
	private static final String[] expert_texts = { "省级专家", "地方专家", "本地专家" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expert);
		lv = (ListView) findViewById(R.id.expert_lv);
		back = (ImageView) findViewById(R.id.expert_back);
		initData();
		initListener();
	}

	private void initListener() {
		back.setOnClickListener(this);

	}

	private void initData() {
		lv.setAdapter(new ExpertLvAdapter());

	}

	class ExpertLvAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
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
				convertView = LayoutInflater.from(ExpertActivity.this).inflate(
						R.layout.expert_lv_item, parent, false);
			}
			TextView tv_content = BaseViewHolder.get(convertView,
					R.id.tv_expert_category);
			tv_content.setText(expert_texts[position]);
			MyListView lv2 = BaseViewHolder.get(convertView, R.id.expert_lv2);

			lv2.setAdapter(new ExpertLv2Adapter());
			lv2.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					Intent intent = new Intent(ExpertActivity.this,
							ExpertInfoActivity.class);
					startActivity(intent);

				}
			});
			return convertView;
		}

	}

	class ExpertLv2Adapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
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
				convertView = LayoutInflater.from(ExpertActivity.this).inflate(
						R.layout.expert_lv2_item, parent, false);
			}
			return convertView;
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.expert_back:
			finish();
			break;
		default:
			break;
		}

	}

}
