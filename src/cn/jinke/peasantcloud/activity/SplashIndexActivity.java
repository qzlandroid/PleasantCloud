package cn.jinke.peasantcloud.activity;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.id;
import cn.jinke.peasantcloud.R.layout;
import cn.jinke.peasantcloud.R.menu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.RelativeLayout;

public class SplashIndexActivity extends Activity {

	private RelativeLayout rl_splash_index;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_index);
		rl_splash_index=(RelativeLayout)findViewById(R.id.rl_splash_index);
		startAnim();
	}

	private void startAnim() {
		AnimationSet amset=new AnimationSet(false);
        AlphaAnimation alpha = new AlphaAnimation(1, 1);
        alpha.setDuration(2000);// 动画时间
        alpha.setFillAfter(true);// 保持动画状态
        amset.addAnimation(alpha);
        amset.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                jump_to_nextpage();
            	startActivity(new Intent(SplashIndexActivity.this,LoginActivity.class));
            	finish();

            }

           

			@Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        rl_splash_index.startAnimation(amset);
		
	}
}
