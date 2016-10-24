package cn.jinke.peasantcloud.activity;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.layout;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FriendInfoActivity extends Activity implements OnClickListener{

	private RelativeLayout back_info_friendinfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friend_info);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		back_info_friendinfo=(RelativeLayout) findViewById(R.id.back_btn_friendinfo);
		back_info_friendinfo.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.back_btn_friendinfo:
			finish();
			break;

		
		}
	}

	

}
