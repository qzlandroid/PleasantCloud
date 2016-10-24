package cn.jinke.peasantcloud.activity;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.id;
import cn.jinke.peasantcloud.R.layout;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class LiveActivity extends Activity {

	private VideoView mVideoView;
	private ImageView live_back;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Vitamio.isInitialized(getApplicationContext());
		setContentView(R.layout.activity_live);
		playfunction();
		initView();
	}

	private void initView() {		
		live_back = (ImageView) findViewById(R.id.live_back);
		live_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
		

	}

	public void playfunction(){
		 String path = "http://live.0793.tv/srtv1.m3u8";
		 mVideoView = (VideoView) findViewById(R.id.surface_view);
		if (path == "") {
			// Tell the user to provide a media file URL/path.
			Toast.makeText(LiveActivity.this, "Please edit VideoViewDemo Activity, and set path" + " variable to your media file URL/path", Toast.LENGTH_LONG).show();
			return;
		} else {
			/*
			 * Alternatively,for streaming media you can use
			 * mVideoView.setVideoURI(Uri.parse(URLstring));
			 */
			mVideoView.setVideoPath(path);
			mVideoView.setMediaController(new MediaController(this));
			mVideoView.requestFocus();

			mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
				@Override
				public void onPrepared(MediaPlayer mediaPlayer) {
					// optional need Vitamio 4.0
					mediaPlayer.setPlaybackSpeed(1.0f);
				}
			});
		}
	}
}
