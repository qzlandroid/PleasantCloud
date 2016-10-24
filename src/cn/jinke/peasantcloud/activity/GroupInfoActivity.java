package cn.jinke.peasantcloud.activity;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.layout;
import cn.jinke.peasantcloud.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GroupInfoActivity extends Activity implements OnClickListener{

	private RelativeLayout back_btn_groupinfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_info_layout);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		back_btn_groupinfo=(RelativeLayout) findViewById(R.id.back_btn_groupinfo);
		back_btn_groupinfo.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.back_btn_groupinfo:
			finish();
			break;

		
		}
	}

	
}
