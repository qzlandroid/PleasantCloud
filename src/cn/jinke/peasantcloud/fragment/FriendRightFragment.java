package cn.jinke.peasantcloud.fragment;

import io.rong.imkit.RongIM;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.RelativeLayout;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.activity.FarmerFriendCircleActivity;
import cn.jinke.peasantcloud.adapter.FriendListViewAdapter;
/**
 * 农友圈右侧fragment
 * @author QZ
 *
 */
public class FriendRightFragment extends BaseFragment implements
		OnClickListener {

	public static FriendRightFragment instance = null;
	private ExpandableListView lv_in_fragment_friend;
	private View rl_farmer_friend_circle;
	private View view;

	public static FriendRightFragment getInstance() {
		if (instance == null) {
			instance = new FriendRightFragment();

		}
		return instance;
	}

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.friend_right_view, null);
		return view;
	}

	@Override
	public void initData() {
		lv_in_fragment_friend = (ExpandableListView) view
				.findViewById(R.id.lv_in_fragment_friend_right);
		View header = View.inflate(getActivity(),
				R.layout.header_of_fragment_friend, null);
		rl_farmer_friend_circle = (RelativeLayout) header
				.findViewById(R.id.rl_farmer_friend_circle);

		lv_in_fragment_friend.addHeaderView(header);
		lv_in_fragment_friend.setAdapter(new FriendListViewAdapter(mActivity));
		
		initListener();
	}

	private void initListener() {
		rl_farmer_friend_circle.setOnClickListener(this);
		lv_in_fragment_friend.setOnChildClickListener(new MyChildClickListener());
//		lv_in_fragment_friend
//				.setOnItemClickListener(new FriendFragmentItemClickListenerAdpter(
//						mActivity));

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rl_farmer_friend_circle:
			Intent intent = new Intent(getActivity(),
					FarmerFriendCircleActivity.class);
			startActivity(intent);
			break;
		default:
			break;

		}
	}
	public class MyChildClickListener implements OnChildClickListener{

		@Override
		public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
			 if (RongIM.getInstance() != null) {
		            RongIM.getInstance().startPrivateChat(mActivity,"1","轩轩");
		        }
			return true;
		}
		
	}

}
