package cn.jinke.peasantcloud.activity;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.layout;
import cn.jinke.peasantcloud.adapter.RecommendListViewAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


/**
 * 添加农友activity
 * @author QZ
 *
 */
public class AddFarmerFriendActivity extends Activity implements
		OnClickListener {

	private RelativeLayout back_btn_addfriend;
	private RelativeLayout rl_scan;
	private ListView lv_recommended;
	private View header;
	/**
     * 扫描跳转Activity RequestCode
     */
    public static final int REQUEST_CODE = 111;
    /**
     * 选择系统图片Request Code
     */
    public static final int REQUEST_IMAGE = 112;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_farmer_friend);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		back_btn_addfriend = (RelativeLayout) findViewById(R.id.back_btn_addfriend);
		lv_recommended=(ListView)findViewById(R.id.lv_recommended);
//		rl_scan=(RelativeLayout)findViewById(R.id.rl_scan);
//		rl_scan.setOnClickListener(this);
		back_btn_addfriend.setOnClickListener(this);
		header=View.inflate(AddFarmerFriendActivity.this, R.layout.header_of_recommend, null);
		lv_recommended.addHeaderView(header);
		lv_recommended.setAdapter(new RecommendListViewAdapter(AddFarmerFriendActivity.this));
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		System.out.println("PPPPPPPPPPPP");
		switch (arg0.getId()) {
		case R.id.back_btn_addfriend:
			finish();
			break;
		case R.id.rl_scan:
//			Intent intent=new Intent();
			
//			intent.setClassName("com.uuzuche.lib_zxing.activity", "com.uuzuche.lib_zxing.activity.CaptureActivity");

//	 Intent intent = new Intent(AddFarmerFriendActivity.this, CaptureActivity.class);
//             startActivityForResult(intent, REQUEST_CODE);
			break;

		}
	}
}
