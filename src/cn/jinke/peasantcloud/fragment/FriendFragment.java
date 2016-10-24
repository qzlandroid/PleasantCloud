package cn.jinke.peasantcloud.fragment;

import java.util.ArrayList;
import java.util.List;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import io.rong.imkit.RongContext;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imkit.model.UIConversation;
import io.rong.imkit.widget.adapter.ConversationListAdapter;
import io.rong.imlib.model.Conversation;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.activity.AddFarmerFriendActivity;
import cn.jinke.peasantcloud.activity.FarmerFriendCircleActivity;
import cn.jinke.peasantcloud.activity.MainActivity;
import cn.jinke.peasantcloud.view.NoScrollViewPager;
import cn.jinke.peasantcloud.view.SegmentViewFriendCircle.onSegmentViewClickListener;
import cn.jinke.peasantcloud.view.SegmentViewFriendCircle;

/**
 * 农友圈fragment
 */
public class FriendFragment extends BaseFragment implements OnClickListener,
		onSegmentViewClickListener {

	private ImageView add_farmer_friend, friend_left_user;
	private NoScrollViewPager friend_vp;
	private SegmentViewFriendCircle friend_seg;
	private Fragment mConversationListFra = null;
	private List<Fragment> fralist;
	private FragmentPagerAdapter mFragmentPagerAdapter;
	private int page = 0;
	private View view;
	private SlidingMenu slidingMenu;

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_friend, null);
		return view;
	}

	@Override
	public void initData() {

		fralist = new ArrayList<Fragment>();
//		mConversationListFra = initConversationList();
		fralist.add(FriendLeftFragment.getInstance());
		fralist.add(FriendRightFragment.getInstance());
		add_farmer_friend = (ImageView) view
				.findViewById(R.id.add_farmer_friend);
		friend_left_user = (ImageView) view.findViewById(R.id.friend_img_user);

		friend_seg = (SegmentViewFriendCircle) view
				.findViewById(R.id.friend_seg);

		friend_vp = (NoScrollViewPager) view.findViewById(R.id.friend_vp);
		initAdapter();
		friend_vp.setAdapter(mFragmentPagerAdapter);
		friend_vp.setCurrentItem(0);

		MainActivity main = (MainActivity) mActivity;
		slidingMenu = main.getSlidingMenu();
		initListener();
	}

	private void initListener() {
		friend_seg.setOnSegmentViewClickListener(this);
		add_farmer_friend.setOnClickListener(this);
		friend_left_user.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.add_farmer_friend:
			Intent intent = new Intent(getActivity(),
					AddFarmerFriendActivity.class);
			startActivity(intent);
			break;
		case R.id.rl_farmer_friend_circle:
			Intent intent1 = new Intent(getActivity(),
					FarmerFriendCircleActivity.class);
			startActivity(intent1);
			break;
		case R.id.friend_img_user:
			slidingMenu.toggle();
			break;
		default:
			break;
		}
	}

	@Override
	public void onSegmentViewClick(View v, int position) {
		if (position == 0) {
			friend_vp.setCurrentItem(0, false);
		} else {
			friend_vp.setCurrentItem(1, false);
		}
	}

	private Fragment initConversationList() {
		if (mConversationListFra == null) {
			
//			 View view = View.inflate(mActivity, R.layout.conversationlist, null);

//		    ConversationListFragment fragment = (ConversationListFragment) getChildFragmentManager().findFragmentById(R.id.conversationlist_myself);
//			ConversationListFragment fragment = new ConversationListFragment();
			
			ConversationListFragment listFragment = ConversationListFragment.getInstance();
			listFragment.setAdapter(new ConversationListAdapterEx(RongContext.getInstance()));
			Uri uri = Uri
					.parse("rong://"
							+ getActivity().getApplicationInfo().packageName)
					.buildUpon()
					.appendPath("conversationlist")
					.appendQueryParameter(
							Conversation.ConversationType.PRIVATE.getName(),
							"false") // 设置私聊会话非聚合显示
					.appendQueryParameter(
							Conversation.ConversationType.GROUP.getName(),
							"false")// 设置群组会话聚合显示
					.appendQueryParameter(
							Conversation.ConversationType.DISCUSSION.getName(),
							"false")// 设置讨论组会话非聚合显示
					.appendQueryParameter(
							Conversation.ConversationType.SYSTEM.getName(),
							"false")// 设置系统会话非聚合显示
					.build();
			listFragment.setUri(uri);
			return listFragment;
		} else {
			return mConversationListFra;
		}
	}

	private void initAdapter() {
		mFragmentPagerAdapter = new FragmentPagerAdapter(
				getChildFragmentManager()) {

			@Override
			public int getCount() {
				return fralist.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				return fralist.get(arg0);
			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView((View) object);
			}

			@Override
			public boolean isViewFromObject(View view, Object object) {
				return view == ((Fragment) object).getView();
			}

		};
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		page = friend_vp.getCurrentItem();
	}

	@Override
	public void onStop() {
		super.onStop();
		page = friend_vp.getCurrentItem();
	}

	@Override
	public void onResume() {
		super.onResume();
		friend_seg.setSelected(page);

	}
	public class ConversationListAdapterEx extends ConversationListAdapter {
	    public ConversationListAdapterEx(Context context) {
	        super(context);
	    }

	    @Override
	    protected View newView(Context context, int position, ViewGroup group) {
	        return super.newView(context, position, group);
	    }

	    @Override
	    protected void bindView(View v, int position, UIConversation data) {
	    if(data.getConversationType().equals(Conversation.ConversationType.DISCUSSION))
	        data.setUnreadType(UIConversation.UnreadRemindType.REMIND_ONLY);
	        super.bindView(v, position, data);
	    }
	}
}
