package cn.jinke.peasantcloud.adapter;

import io.rong.imkit.widget.AsyncImageView;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FriendListViewAdapter implements ExpandableListAdapter ,OnClickListener{

	int[][] header_img={{R.drawable.header},{R.drawable.header,R.drawable.test2},
			{R.drawable.test1,R.drawable.test2,R.drawable.test3}};
	String[][] name={{"李志"},{"郭里","孙样"},
			{"郭里","孙样","李志"}};
	private Context ctx;
	private String[] groups = new String[]{
            "专家", "农技员", "种植户"
    };
	public FriendListViewAdapter(Context ctx) {
		// TODO Auto-generated constructor stub
		this.ctx=ctx;
	}
	@Override
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getChildView(int groupPosition, int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
		
		if (convertView == null) {
			convertView = LayoutInflater.from(ctx).inflate(
					R.layout.listview_item_friendlist, parent, false);
		}
//		View view = View.inflate(ctx, R.layout.listview_item_friendlist, null);	
//		AsyncImageView img=BaseViewHolder.get(convertView, R.id.friend_list_headimg);
		TextView tView=BaseViewHolder.get(convertView, R.id.friend_list_name);
		
		tView.setText(name[groupPosition][childPosition]);
		AsyncImageView img=(AsyncImageView) convertView.findViewById(R.id.friend_list_headimg);
		img.setOnClickListener(this);

//		img.setImageResource(header_img[groupPosition][childPosition]);
//		Resources r=ctx.getResources();
		int id=header_img[groupPosition][childPosition];
//		Uri uri=Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE+"://"+r.getResourcePackageName(id)
//				+"/"+r.getResourceTypeName(id)+"/"+r.getResourceEntryName(id));
//		
//		img.setResource(uri);
//		img.setImageResource(id);
		img.setResource(Uri.parse("http://pic10.nipic.com/20101103/5063545_000227976000_2.jpg"));
		return convertView;
		
	}
	@Override
	public int getChildrenCount(int arg0) {
		// TODO Auto-generated method stub
		return name[arg0].length;
	}
	@Override
	public long getCombinedChildId(long arg0, long arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public long getCombinedGroupId(long arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return groups.length;
	}
	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
            View convertView, ViewGroup parent) {
		
		if (convertView == null) {
			convertView = LayoutInflater.from(ctx).inflate(
					R.layout.listview_item_friendlist_type, parent, false);
		}
//		View view = View.inflate(ctx, R.layout.listview_item_friendlist_type, null);	
		ImageView img=BaseViewHolder.get(convertView, R.id.img_indicator);
		
		TextView tv_type= BaseViewHolder.get(convertView, R.id.tv_friendtype);
		TextView tv_number=BaseViewHolder.get(convertView, R.id.tv_number_inthisgroup);
		tv_number.setText(getChildrenCount(groupPosition)+"");
		tv_type.setText(groups[groupPosition]);
		 if (isExpanded)
	            img.setImageResource(
	                    R.drawable.triangle_bottom);
	        else
	            img.setImageResource(
	                    R.drawable.triangle_right);
		return convertView;
	}
	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onGroupCollapsed(int arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onGroupExpanded(int arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void registerDataSetObserver(DataSetObserver arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void unregisterDataSetObserver(DataSetObserver arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(ctx, "您点击了头像", Toast.LENGTH_SHORT).show();
	}
	

}
