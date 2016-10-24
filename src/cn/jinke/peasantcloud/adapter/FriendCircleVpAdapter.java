package cn.jinke.peasantcloud.adapter;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.activity.FarmerFriendCircleActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
/**
 * 朋友圈页面ViewPager适配器 
 * @author QZ
 *
 */
public class FriendCircleVpAdapter extends PagerAdapter implements OnClickListener{

	private Context context;
	private ListView lv_in_fragment_friend;
	private RelativeLayout rl_farmer_friend_circle;
	public FriendCircleVpAdapter(Context context) {
		this.context = context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view==object;
	}
	
	public Object instantiateItem(ViewGroup container, int position) {
		View vpView = null;
		if (position==0){
			vpView = View.inflate(context, R.layout.friend_left_view, null);		
		}
		if (position==1){
			vpView = View.inflate(context, R.layout.friend_right_view, null);
		}
		container.addView(vpView);
		return vpView;
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {		
		container.removeView((View) object);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId()==R.id.rl_farmer_friend_circle){
			Intent intent=new Intent(context,FarmerFriendCircleActivity.class);
			context.startActivity(intent);
		}
		
	}
	
}
