package cn.jinke.peasantcloud.adapter;

import io.rong.imkit.widget.AsyncImageView;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GroupListViewAdapter extends BaseAdapter{

	private String[] header={"http://img1.3lian.com/2015/w7/90/d/1.jpg",
			"http://img.taopic.com/uploads/allimg/120906/219077-120Z616330677.jpg",
			"http://img3.3lian.com/2013/s2/14/d/71.jpg",
			"http://pic.58pic.com/58pic/13/71/03/83p58PICkfP_1024.jpg",
			"http://img2.3lian.com/2014/f2/79/d/95.jpg"};
	private String[] name={"花生病害交流群","玉米种植群","农业百科知识","番薯种植群","稻田病害"};
	private Context ctx;
	public GroupListViewAdapter(Context ctx) {
		// TODO Auto-generated constructor stub
		this.ctx=ctx;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return name.length;
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
		if (convertView == null) {
			convertView = LayoutInflater.from(ctx).inflate(
					R.layout.listview_item_grouplist, parent, false);
		}
		AsyncImageView group_list_headimg= BaseViewHolder.get(convertView, R.id.group_list_headimg);
		TextView group_list_name= BaseViewHolder.get(convertView, R.id.group_list_name);
		group_list_name.setText(name[position]);
		group_list_headimg.setResource(Uri.parse(header[position]));
		return convertView;
	}

}
