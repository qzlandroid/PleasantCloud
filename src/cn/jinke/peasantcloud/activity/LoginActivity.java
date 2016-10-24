package cn.jinke.peasantcloud.activity;

import java.util.HashMap;

import cn.jinke.peasantcloud.R;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class LoginActivity extends Activity implements PlatformActionListener, Callback {
	private static final int MSG_SMSSDK_CALLBACK = 1;
	private static final int MSG_AUTH_CANCEL = 2;
	private static final int MSG_AUTH_ERROR= 3;
	private static final int MSG_AUTH_COMPLETE = 4;
	
	private Handler handler;
	
	private EditText userEditText;
	private EditText pwdEditText;
	private Button loginButton;
	private ImageView ivQQlogin;
	private ImageView ivWechatlogin;
	private ImageView ivSinalogin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		ShareSDK.initSDK(this);
		handler = new Handler(this);
		userEditText = (EditText)findViewById(R.id.et_user);
		pwdEditText = (EditText)findViewById(R.id.et_pwd);
		loginButton = (Button)findViewById(R.id.btn_login);
		ivQQlogin = (ImageView) findViewById(R.id.iv_qqlogin);
		ivWechatlogin = (ImageView) findViewById(R.id.iv_wechatlogin);
		ivSinalogin = (ImageView) findViewById(R.id.iv_sinalogin);
		loginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				String userName = userEditText.getText().toString();
				String pwd = pwdEditText.getText().toString();
				if (userName.equals("123") && pwd.equals("123")) {//用户名密码正确，跳转到首页
					startActivity(new Intent(LoginActivity.this,MainActivity.class));
					finish();
				}else {//错误提示
					Toast toast=Toast.makeText(getApplicationContext(), "用户名或密码错误", Toast.LENGTH_SHORT);  
					//显示toast信息  
					toast.show(); 
				}
				
				
			}
		});
		
		ivQQlogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				System.out.println("qq第三方");
				//QQ空间
				Platform qzone = ShareSDK.getPlatform(QZone.NAME);
				authorize(qzone);
				
			}
		});
		
		ivWechatlogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				System.out.println("微信第三方");
				Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
				authorize(wechat);
				
			}
		});
		
		ivSinalogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				System.out.println("微博第三方");
				//新浪微博
				Platform sina = ShareSDK.getPlatform(SinaWeibo.NAME);
				authorize(sina);
				
			}
		});
	}

	protected void authorize(Platform plat) {
		if (plat == null) {
			System.out.println("平台为空");
			return;
		}
		System.out.println("平台不为空");
		plat.setPlatformActionListener(this);
		//关闭SSO授权
		plat.SSOSetting(true);
		plat.showUser(null);
		
	}

	@Override
	public void onCancel(Platform platform, int action) {
        if (action == Platform.ACTION_USER_INFOR) {  
            handler.sendEmptyMessage(MSG_AUTH_CANCEL);  
        }  

		
	}

	@Override
	public void onComplete(Platform platform, int action, HashMap<String, Object> res) {
		if (action == Platform.ACTION_USER_INFOR) {
			Message msg = new Message();
			msg.what = MSG_AUTH_COMPLETE;
			msg.obj = new Object[] {platform.getName(), res};
			handler.sendMessage(msg);
		}
		
	}

	@Override
	public void onError(Platform platform, int action, Throwable t) {
		if (action == Platform.ACTION_USER_INFOR) {
			handler.sendEmptyMessage(MSG_AUTH_ERROR);
		}
		t.printStackTrace();
		
	}

	@Override
	public boolean handleMessage(Message msg) {
		switch(msg.what) {
		case MSG_AUTH_CANCEL: {
			//取消授权
			Toast.makeText(LoginActivity.this, "取消授权", Toast.LENGTH_SHORT).show();
		} break;
		case MSG_AUTH_ERROR: {
			//授权失败
			Toast.makeText(LoginActivity.this, "授权失败", Toast.LENGTH_SHORT).show();
		} break;
		case MSG_AUTH_COMPLETE: {
			//授权成功
			Toast.makeText(this, "完成授权", Toast.LENGTH_SHORT).show();
			Object[] objs = (Object[]) msg.obj;
			String platform = (String) objs[0];
			HashMap<String, Object> res = (HashMap<String, Object>) objs[1];
			
			
			
			startActivity(new Intent(LoginActivity.this,MainActivity.class));
			finish();
//			if (signupListener != null && signupListener.onSignin(platform, res)) {
//				SignupPage signupPage = new SignupPage();
//				signupPage.setOnLoginListener(signupListener);
//				signupPage.setPlatform(platform);
//				signupPage.show(activity, null);
//			}
			
		} break;
		case MSG_SMSSDK_CALLBACK: {
//			if (msg.arg2 == SMSSDK.RESULT_ERROR) {
//				Toast.makeText(activity, "操作失败", Toast.LENGTH_SHORT).show();
//			} else {
//				switch (msg.arg1) {
//					case SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE: {
//						if(msgLoginDlg != null && msgLoginDlg.isShowing()){
//							msgLoginDlg.dismiss();
//						}
//						Toast.makeText(activity, "提交验证码成功", Toast.LENGTH_SHORT).show();
//						Message m = new Message();
//						m.what = MSG_AUTH_COMPLETE;
//						m.obj = new Object[] {"SMSSDK", (HashMap<String, Object>) msg.obj};
//						handler.sendMessage(m);
//					} break;
//					case SMSSDK.EVENT_GET_VERIFICATION_CODE:{
//						Toast.makeText(activity, "验证码已经发送", Toast.LENGTH_SHORT).show();
//					} break;
//				}
//			}
		} break;
	}
		return false;
	}
}
