package cn.jinke.peasantcloud.adapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import cn.jinke.peasantcloud.view.MyListView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RecommendListViewAdapter extends BaseAdapter{

	private List<String> recommend_typeList;
	private Context ctx;
	public RecommendListViewAdapter(Context ctx) {
		// TODO Auto-generated constructor stub
		this.ctx=ctx;
		recommend_typeList=new ArrayList<String>();
		recommend_typeList.add("推荐群组");
		recommend_typeList.add("推荐专家");
		recommend_typeList.add("推荐农技员");
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
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
//			convertView = View.inflate(ctx, R.layout.listview_item_recommended, null);
			convertView = LayoutInflater.from(ctx).inflate(
					R.layout.listview_item_recommended, parent, false);
		}
		TextView tView=BaseViewHolder.get(convertView, R.id.recommend_type);
		tView.setText(recommend_typeList.get(position));
		MyListView lv_sub_recommend=(MyListView)BaseViewHolder.get(convertView,R.id.lv_sub_recommend);
		lv_sub_recommend.setAdapter(new SubRecommendListViewAdapter(ctx,position));
		
		return convertView;
	}

}
