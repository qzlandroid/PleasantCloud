package cn.jinke.peasantcloud.activity;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.id;
import cn.jinke.peasantcloud.R.layout;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class HomeSearchActivity extends Activity implements OnClickListener{

	private ImageView search_back;
	private ListView home_search_lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_search);
		initView();
		initListener();
	}

	private void initListener() {
		search_back.setOnClickListener(this);
		
	}

	private void initView() {
		search_back = (ImageView) findViewById(R.id.home_search_back);
		home_search_lv = (ListView)findViewById(R.id.home_search_lv);
		home_search_lv.setAdapter(new HomeSearchLvAdapter());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.home_search_back:
			 finish();
			 break;
		default:
			break;
		}
		
	}
	class HomeSearchLvAdapter extends BaseAdapter{
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
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
			View view = View.inflate(HomeSearchActivity.this, R.layout.home_search_lv_item, null);		
			return view;
		}
	}

}
