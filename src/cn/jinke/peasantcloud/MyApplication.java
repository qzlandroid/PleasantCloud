package cn.jinke.peasantcloud;

import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.RongIM.GroupInfoProvider;
import io.rong.imkit.widget.provider.InputProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.UserInfo;

import com.baidu.mapapi.SDKInitializer;
import io.rong.push.RongPushClient;
import io.rong.push.common.RongException;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import cn.jinke.peasantcloud.provider.ContactsProvider;

public class MyApplication extends Application{
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext())) ||
                "io.rong.push".equals(getCurProcessName(getApplicationContext()))) {

            /**
             * IMKit SDK调用第一步 初始化
             */
            RongIM.init(this);
            
            String Token="c8puWxMi7dgn0nBjGuzZcs+jNUQ2Y6oq7L3J+tNH8hIFh00dHAsKvZnqPzy0Yem5bLyudbK7d2e/mwy7MGOmRg==";
//          String Token="qW3nbCCBOLm9UYKiEZieV0AyjF3YK/g/g0Tuv9xBL7v64qEj9tXpMs+RHrKQK4kWZUMy+BDGgFLdwObcF5b7dA==";
          RongIM.connect(Token, new RongIMClient.ConnectCallback(){
              @Override
              public void onSuccess(String s) {
            	  
            	  
           	 
              }

              @Override
              public void onError(RongIMClient.ErrorCode errorCode) {

              }

              @Override
              public void onTokenIncorrect() {

              }
          });
//          if(RongIM.getInstance()!=null){
//        	  RongIM.getInstance().setCurrentUserInfo(new UserInfo("123", "专家", Uri.parse("https://www.baidu.com/img/bd_logo1.png")));
////            RongIM.getInstance().refreshUserInfoCache(new UserInfo("123", "专家", Uri.parse("https://www.baidu.com/img/bd_logo1.png")));
//            RongIM.getInstance().setMessageAttachedUserInfo(true);
//          }
          RongIM.setGroupInfoProvider(new GroupInfoProvider() {
			
			@Override
			public Group getGroupInfo(String id) {
				// TODO Auto-generated method stub
				return new Group(id, "花生病虫害交流群", Uri.parse("http://i0.peopleurl.cn/nmsgimage/20150909/b_4304371_multi_1441763363839.jpg"));
			}
		},true);
          RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {

        	    @Override
        	    public UserInfo getUserInfo(String userId) {

        	        return findUserById(userId);//根据 userId 去你的用户系统里查询对应的用户信息返回给融云 SDK。
        	    }

				private UserInfo findUserById(String userId) {
					// TODO Auto-generated method stub
					if(userId.equals("1")){
						return new UserInfo(userId, "轩轩", Uri.parse("http://tse2.mm.bing.net/th?id=OIP.M7b7365ca26e3503d5764e6085e11c568o0&pid=15.1"));
					}else if(userId.equals("2")){
						return new UserInfo(userId, "小张专家", Uri.parse("http://pic27.nipic.com/20130321/12176292_164836158136_2.jpg"));
						
					}else if(userId.equals("3")){
						return new UserInfo(userId, "大闸蟹养殖户", Uri.parse("http://tse3.mm.bing.net/th?id=OIP.Mcd88bedfd2a36d0d88f4bdfcdfe6993ao1&pid=15.1"));
						
					}else if(userId.equals("4")){
						return new UserInfo(userId, "玉米种植员", Uri.parse("http://tse2.mm.bing.net/th?id=OIP.M14149da2603d22478e2d0fe96bc461dao0&pid=15.1"));
						
					}else if(userId.equals("100")){
						return new UserInfo(userId, "互动投票", Uri.parse("http://tse1.mm.bing.net/th?id=OIP.M77df2c9c405db4d96ceaa921ec21494cH0&pid=15.1"));
						
					}else if(userId.equals("101")){
						return new UserInfo(userId, "问卷调查", Uri.parse("http://tse4.mm.bing.net/th?id=OIP.M37663dc22359e50e401313af64518036o0&pid=15.1"));
						
					}else{
						return new UserInfo(userId, "轩轩", Uri.parse("http://tse2.mm.bing.net/th?id=OIP.M7b7365ca26e3503d5764e6085e11c568o0&pid=15.1"));
					}
					
				}

        	}, true);
         
          try {
			RongPushClient.checkManifest(getApplicationContext());
		} catch (RongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
		
	}
	
	 public static String getCurProcessName(Context context) {

	        int pid = android.os.Process.myPid();

	        ActivityManager activityManager = (ActivityManager) context
	                .getSystemService(Context.ACTIVITY_SERVICE);

	        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
	                .getRunningAppProcesses()) {

	            if (appProcess.pid == pid) {
	                return appProcess.processName;
	            }
	        }
	        return null;
	    }

}
