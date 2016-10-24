package cn.jinke.peasantcloud.adapter;


import cn.jinke.peasantcloud.R;
import io.rong.imkit.RongIM;
import io.rong.imkit.widget.AsyncImageView;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
public class FriendFragmentItemClickListenerAdpter implements OnItemClickListener,OnClickListener
{
	private Context ctx;

	public FriendFragmentItemClickListenerAdpter(Context ctx) {
		// TODO Auto-generated constructor stub
		
		this.ctx=ctx;
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
//		AsyncImageView headerimg=(AsyncImageView) arg1.findViewById(R.id.friend_list_headimg);
//		headerimg.setOnClickListener(this);
		 if (RongIM.getInstance() != null) {
	            RongIM.getInstance().startPrivateChat(ctx,"1","轩轩");
	        }
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(ctx, "您点击了头像", Toast.LENGTH_SHORT).show();
		
	}

}
