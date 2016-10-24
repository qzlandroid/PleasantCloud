package cn.jinke.peasantcloud.receiver;

import cn.jinke.peasantcloud.activity.PushDealActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import io.rong.push.notification.PushMessageReceiver;
import io.rong.push.notification.PushNotificationMessage;

public class MessageReceiver extends PushMessageReceiver{

	@Override
	public boolean onNotificationMessageArrived(Context arg0,
			PushNotificationMessage arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onNotificationMessageClicked(Context arg0,
			PushNotificationMessage arg1) {
		Intent intent = new Intent(arg0,PushDealActivity.class);
		intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);

		Uri.Builder uriBuilder = Uri.parse("rong://" + arg0.getPackageName()).buildUpon();
		uriBuilder.appendPath("push_message")
		        .appendQueryParameter("targetId", arg1.getTargetId())
		        .appendQueryParameter("pushData", arg1.getPushData())
		        .appendQueryParameter("pushId", arg1.getPushId())
		        .appendQueryParameter("extra", arg1.getExtra());

		arg0.startActivity(intent);
		return true;
	}

}
