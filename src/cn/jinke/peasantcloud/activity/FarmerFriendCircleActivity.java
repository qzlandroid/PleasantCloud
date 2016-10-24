package cn.jinke.peasantcloud.activity;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.layout;
import cn.jinke.peasantcloud.R.menu;
import cn.jinke.peasantcloud.adapter.GroupListViewAdapter;
import cn.jinke.peasantcloud.adapter.GroupListtItemClickListenerAdpter;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class FarmerFriendCircleActivity extends Activity implements OnClickListener{

	private ListView lv_grouplist;
	private RelativeLayout back_btn_friendcircle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_farmer_friend_circle);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		lv_grouplist=(ListView) findViewById(R.id.lv_grouplist);
		back_btn_friendcircle=(RelativeLayout)findViewById(R.id.back_btn_friendcircle);
		
		View Header=View.inflate(FarmerFriendCircleActivity.this, R.layout.header_clickinto_friendcircle, null);
		View tail=View.inflate(FarmerFriendCircleActivity.this, R.layout.tail_clickinto_friendcircle, null);
		back_btn_friendcircle.setOnClickListener(this);
		lv_grouplist.addHeaderView(Header);
//		lv_grouplist.addFooterView(tail);
		lv_grouplist.setAdapter(new GroupListViewAdapter(FarmerFriendCircleActivity.this));
		lv_grouplist.setOnItemClickListener(new GroupListtItemClickListenerAdpter(FarmerFriendCircleActivity.this));
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.back_btn_friendcircle:
			finish();
			break;

		
		}
		
	}

	

}
