package cn.jinke.peasantcloud.listener;

import io.rong.imkit.RongIM.ConversationBehaviorListener;
import io.rong.imkit.widget.AlterDialogFragment;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.location.RealTimeLocationConstant;
import io.rong.imlib.location.message.RealTimeLocationStartMessage;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Conversation.ConversationType;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.UserInfo;
import io.rong.message.ImageMessage;
import io.rong.message.LocationMessage;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;


public class MyConversationBehaviorListener implements ConversationBehaviorListener{

	@Override
	public boolean onMessageClick(Context arg0, View arg1, Message arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onMessageLinkClick(Context arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onMessageLongClick(Context context, View view, Message message) {
	
//        if (message.getContent() instanceof LocationMessage) {
//            Intent intent = new Intent(context, AMAPLocationActivity.class);
//            intent.putExtra("location", message.getContent());
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(intent);
//        } else if (message.getContent() instanceof ImageMessage) {
////            Intent intent = new Intent(context, PhotoActivity.class);
////            intent.putExtra("message", message);
////            context.startActivity(intent);
//        }

        return false;
	}

	@Override
	public boolean onUserPortraitClick(Context arg0, ConversationType arg1,
			UserInfo arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onUserPortraitLongClick(Context arg0, ConversationType arg1,
			UserInfo arg2) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
