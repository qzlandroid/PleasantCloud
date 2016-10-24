package cn.jinke.peasantcloud.activity;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.id;
import cn.jinke.peasantcloud.R.layout;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class VideoContentActivity extends Activity implements OnClickListener{

	private ImageView back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_content);
		initView();
		initListener();
	}

	private void initListener() {
		back.setOnClickListener(this);
		
	}

	private void initView() {
		ListView lv = (ListView) findViewById(R.id.video_content_lv);
		back = (ImageView) findViewById(R.id.video_back);
		lv.setAdapter(new VideoConAdapter());
		
	}
	class VideoConAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
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
				convertView = LayoutInflater.from(VideoContentActivity.this).inflate(
						R.layout.video_content_lv_list, parent, false);
			}	
			
			/*TextView tv_content = BaseViewHolder.get(convertView, R.id.tv_home_content);
			TextView tv_comment = BaseViewHolder.get(convertView, R.id.tv_home_comment);
			tv_content.setText(img_text[position%5]);		
			tv_comment.setText(Integer.toString((int)(1+Math.random()*(100-1+1))));*/		
			return convertView;
		}
		
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.video_back:
			finish();
			break;
		default:
			break;
		}
		
	}
	

}
