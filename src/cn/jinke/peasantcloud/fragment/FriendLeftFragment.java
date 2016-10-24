package cn.jinke.peasantcloud.fragment;

import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imkit.model.UIConversation;
import io.rong.imkit.widget.adapter.ConversationListAdapter;
import io.rong.imlib.model.Conversation;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.activity.AddFarmerFriendActivity;
import cn.jinke.peasantcloud.activity.FarmerFriendCircleActivity;
import cn.jinke.peasantcloud.adapter.FriendFragmentItemClickListenerAdpter;
import cn.jinke.peasantcloud.adapter.FriendListViewAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 农友圈右侧fragment
 * @author QZ
 *
 */
public class FriendLeftFragment  extends BaseFragment implements OnClickListener{

	public static FriendLeftFragment instance = null;
	private View view;
	

	public static FriendLeftFragment getInstance() {
		if (instance == null) {
			instance = new FriendLeftFragment();

		}
		return instance;
	}

	private RelativeLayout friend_circle_inmessagelist;


//	@Override
//	@Nullable
//	public View onCreateView(LayoutInflater inflater,
//			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//		 View view = inflater.inflate(R.layout.conversationlist,container,false);
//		 friend_circle_inmessagelist=(RelativeLayout) view.findViewById(R.id.friend_circle_inmessagelist);
//		 friend_circle_inmessagelist.setOnClickListener(this);
//
//        ConversationListFragment fragment = (ConversationListFragment) getChildFragmentManager().findFragmentById(R.id.conversationlist_myself);
//		 	
//	        Uri uri = Uri.parse("rong://" + getActivity().getApplicationInfo().packageName).buildUpon()
//	                .appendPath("conversationlist")
//	                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话非聚合显示
//	                .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false")//设置群组会话聚合显示
//	                .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false")//设置讨论组会话非聚合显示
//	                .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "false")//设置系统会话非聚合显示
//	                .build();
//
//	        fragment.setUri(uri);
//	        return  view;
//	}


	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		ConversationListFragment fragment = (ConversationListFragment) getChildFragmentManager().findFragmentById(R.id.conversationlist_myself);
		if (fragment != null) 
			getChildFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
		super.onDestroyView();
	}
	
//	public class ConversationListAdapterEx extends ConversationListAdapter {
//	    public ConversationListAdapterEx(Context context) {
//	        super(context);
//	    }
//
//	    @Override
//	    protected View newView(Context context, int position, ViewGroup group) {
//	        return View.inflate(context, R.layout.conversationlist, null);
//	    }
//
//	    @Override
//	    protected void bindView(View v, int position, UIConversation data) {
//	    if(data.getConversationType().equals(Conversation.ConversationType.DISCUSSION))
//	        data.setUnreadType(UIConversation.UnreadRemindType.REMIND_ONLY);
//	        super.bindView(v, position, data);
//	    }
//	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.friend_circle_inmessagelist){
			Toast.makeText(getActivity(), "您点击了朋友圈", Toast.LENGTH_LONG).show();
		}
	}


	@Override
	public View initView() {
		  view = minflater.inflate(R.layout.conversationlist,mcontainer,false);
		 

        ConversationListFragment fragment = (ConversationListFragment) getChildFragmentManager().findFragmentById(R.id.conversationlist_myself);
		 	
	        Uri uri = Uri.parse("rong://" + getActivity().getApplicationInfo().packageName).buildUpon()
	                .appendPath("conversationlist")
	                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话非聚合显示
	                .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false")//设置群组会话聚合显示
	                .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false")//设置讨论组会话非聚合显示
	                .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "false")//设置系统会话非聚合显示
	                .build();

	        fragment.setUri(uri);
	        return  view;
		
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		super.initData();
		
		friend_circle_inmessagelist=(RelativeLayout) view.findViewById(R.id.friend_circle_inmessagelist);
		 friend_circle_inmessagelist.setOnClickListener(this);
	}
	
	



}
