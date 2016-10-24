package cn.jinke.peasantcloud.adapter;

import io.rong.imkit.widget.AsyncImageView;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import cn.jinke.peasantcloud.view.MyListView;
import android.R.integer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class SubRecommendListViewAdapter extends BaseAdapter{

	private Context ctx;
	private int which;
	public SubRecommendListViewAdapter(Context ctx,int which) {
		// TODO Auto-generated constructor stub
		this.ctx=ctx;
		this.which=which;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		if(convertView==null){
//			convertView = View.inflate(ctx, R.layout.listview_item_subrecommend, null);	
			convertView = LayoutInflater.from(ctx).inflate(
					R.layout.listview_item_subrecommend, parent, false);
		}
//		TextView tView=BaseViewHolder.get(convertView, R.id.recommend_type);
//		MyListView lv_sub_recommend=(MyListView)BaseViewHolder.get(convertView,R.id.lv_sub_recommend);
//		lv_sub_recommend.setAdapter(new SubRecommendListViewAdapter(ctx));
		Button btnButton=BaseViewHolder.get(convertView, R.id.add_or_apply);
		AsyncImageView  recommend_list_headimg=BaseViewHolder.get(convertView, R.id.recommend_list_headimg);
		TextView recommend_list_name=BaseViewHolder.get(convertView, R.id.recommend_list_name);
		TextView recommend_list_intro=BaseViewHolder.get(convertView, R.id.recommend_list_intro);
//		String introString=recommend_list_intro.getText();
//		if(){
//			
//		}
		
		
		if(which==1 || which==2){
			btnButton.setText("添加好友");
		}
		return convertView;
	}

}
