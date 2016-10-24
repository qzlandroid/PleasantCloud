package cn.jinke.peasantcloud.adapter;


import io.rong.imkit.RongIM;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
public class GroupListtItemClickListenerAdpter implements OnItemClickListener
{
	private Context ctx;

	public GroupListtItemClickListenerAdpter(Context ctx) {
		// TODO Auto-generated constructor stub
		
		this.ctx=ctx;
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		 if (RongIM.getInstance() != null) {
	            RongIM.getInstance().startGroupChat(ctx, "1", "花生虫病害交流群");
	        }
	}

}
