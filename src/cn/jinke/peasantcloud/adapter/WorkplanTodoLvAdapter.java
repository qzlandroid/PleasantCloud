package cn.jinke.peasantcloud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.jinke.peasantcloud.R;

/**
 * 未做工作列表Listview适配器
 * @author li
 *
 */
public class WorkplanTodoLvAdapter extends BaseAdapter{

	private Context context;
	private int num;
	private static final String[] names ={"给老王家虾池检测","农技员考核要求撰写"};
	private static final int[] icons ={R.drawable.work_location,R.drawable.document};
	
	public WorkplanTodoLvAdapter(Context context,int num){
		this.context = context;
		this.num = num;
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
		convertView = LayoutInflater.from(context).inflate(
				R.layout.workplan_todo_item, parent, false);
		TextView name = (TextView) convertView.findViewById(R.id.todo_name);
		ImageView icon = (ImageView) convertView.findViewById(R.id.location_icon);
		name.setText(names[position]);
		icon.setImageResource(icons[position]);
		return convertView;
	}

}
