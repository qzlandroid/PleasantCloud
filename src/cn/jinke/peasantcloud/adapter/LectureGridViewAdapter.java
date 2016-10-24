package cn.jinke.peasantcloud.adapter;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import cn.jinke.peasantcloud.view.MyGridView;
import android.R.integer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LectureGridViewAdapter extends BaseAdapter{

	
	private int[][] imgplant_ID = new int[][]{{R.drawable.plant1,R.drawable.plant2,R.drawable.plant3,
			R.drawable.plant4,R.drawable.plant5,R.drawable.plant6},{R.drawable.animal1,R.drawable.animal2,R.drawable.animal3},
			{R.drawable.medicine1,R.drawable.medicine2,R.drawable.medicine3}};
	public String[][] plant_name = { {"玉米", "草莓", "香蕉", 
	"山竹","葡萄","火龙果"},{ "猪","牛","兔子"},{ "农药","化肥","收割机"}};
	private Context context;
	private int num;
	public LectureGridViewAdapter(Context context, int num) {
		this.context = context;
		this.num = num;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imgplant_ID[num].length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {		
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.lecture_knowledge_gv_item, parent, false);
		}
		ImageView img_name = BaseViewHolder.get(convertView, R.id.lecture_gv_img);
		TextView tv_name = BaseViewHolder.get(convertView, R.id.lecture_gv_tv);

		img_name.setBackgroundResource(imgplant_ID[num][position]);	
		tv_name.setText(plant_name[num][position]);
		return convertView;
	}

}
