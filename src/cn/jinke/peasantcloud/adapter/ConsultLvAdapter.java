package cn.jinke.peasantcloud.adapter;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import cn.jinke.peasantcloud.view.CircularImage;
import cn.jinke.peasantcloud.view.MyGridView;
import android.R.integer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 农技咨询界面ListView适配器
 * 
 * @author QZ
 * 
 */
public class ConsultLvAdapter extends BaseAdapter {

	private String[] consult_content = new String[] { "中央财政加大对新型职业农民培育工作支持力度",
			"洪涝灾害动物疫病防控技术指南", "聚焦绿色高产高效 引领农业转型升级", "高淳区武家嘴科技园葡萄采摘引游人 农旅结合显成效",
			"秋粮抗洪补救和防灾减灾技术意见", "全面启动实施农业基础性长期性科技工作", "六合区组织基层渔技推广人员参加市培训",
			"上半年全国农机深松整地工作开局良好", "牢记使命和责任担当攻坚克难真抓实干扎实做好农业农村改革发展稳定各项工作",
			"农民工返乡创业为三农发展注入新动力", "请问春茶采摘结束后，茶叶怎样管理有利于秋季茶叶的收成？",
			"求购淡水虾种苗及养殖基地位置所在。并求租鱼塘", "专家您好，桂花树移栽一年后树叶全部干了怎么办?",
			"南京浦口有180头散养的黑猪，能请章老师帮忙提供销售渠道的信息", "请问磨豆腐的下脚料豆渣可直接喂鹅吗？",
			"蔬菜叶子上出现很多白色的虫子，请问怎么防治？", "螃蟹池里的青苔因怎样除去?是不是气温高的时候青苔会自死掉?",
			"六合区冶山镇丘陵地带能够种植哪些经济作物?技术方法是什么?", "请问进行大规模土豆种植有什么技术规范？",
			"某些鸡掉毛现象比较严重，请问是何原因？" };

	private String[] consult_category = new String[] { "作物-玉米", "家禽-猪",
			"作物-香蕉", "肥料-农药", "家禽-兔子", "作物-山竹", "家禽-牛", "作物-小麦", "作物-草莓",
			"作物-西瓜", "作物-西瓜" };
	private static final int[] header_imgs = { R.drawable.header1,
			R.drawable.header2, R.drawable.header3, R.drawable.header4,
			R.drawable.header5, R.drawable.header5, R.drawable.header7,
			R.drawable.header8, R.drawable.header9, R.drawable.header10,
			R.drawable.header10 };
	private static final String[] likes = { "17", "19", "25", "34", "36", "28",
			"14", "58", "64", "42", "75" };
	private static final String[] commons = { "42", "46", "85", "26", "17",
			"59", "34", "38", "28", "29", "34" };
	private static final String[] collections = { "20", "42", "61", "58", "33",
			"23", "29", "78", "50", "30", "29" };
	private static final String[] zhuanfas = { "60", "37", "84", "22", "24",
			"86", "88", "17", "83", "62", "44" };

	private static final String[] names = { "农民老张", "小李子", "瓜熟蒂落", "快乐的种植户",
			"农民养殖户", "今年又丰收啦", "农民小赵", "种田小能手", "轩轩的一个梦想", "设计师" };
	private static final String[] times = { "4分钟前", "20分钟前", "36分钟前", "54分钟前",
			"1小时前", "2小时前", "4小时前", "5小时前", "7小时前", "1天前" };
	private static final String[] areas = { "江苏省.徐州市", "江苏省.南京市", "江苏省.宿迁市",
			"江苏省.南通市", "江苏省.常州市", "江苏省.连云港市", "江苏省.徐州市", "江苏省.扬州市", "江苏省.常州市",
			"江苏省.南京市" };
	private Context context;

	public ConsultLvAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
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
					R.layout.consult_lv_list, parent, false);
		}
		LinearLayout pro_common = BaseViewHolder.get(convertView,
				R.id.ll_commons);
		// TextView pro_advice = BaseViewHolder.get(convertView,
		// R.id.pro_advice);
		if (position % 4 == 2) {
			pro_common.setVisibility(View.VISIBLE);
		}
		CircularImage con_header = BaseViewHolder.get(convertView,
				R.id.consult_lv_header);
		TextView tv_name = BaseViewHolder.get(convertView, R.id.tv_name);
		TextView tv_time = BaseViewHolder.get(convertView, R.id.tv_time);
		TextView tv_area = BaseViewHolder.get(convertView, R.id.tv_area);
		tv_name.setText(names[position]);
		tv_time.setText(times[position]);
		tv_area.setText(areas[position]);

		TextView tv_category = BaseViewHolder.get(convertView,
				R.id.tv_consult_category);
		TextView tv_comment = BaseViewHolder.get(convertView,
				R.id.tv_consult_comment);
		TextView tv_content = BaseViewHolder.get(convertView,
				R.id.tv_consult_content);
		con_header.setImageResource(header_imgs[position]);
		TextView tv_zan = BaseViewHolder.get(convertView, R.id.tv_consult_zan);
		TextView tv_zf = BaseViewHolder.get(convertView, R.id.tv_consult_zf);
		TextView tv_fav = BaseViewHolder.get(convertView, R.id.tv_consult_fav);
		tv_content.setText(consult_content[position]);
		tv_category.setText(consult_category[position]);
		tv_comment.setText(commons[position]);
		tv_zan.setText(likes[position]);
		tv_zf.setText(zhuanfas[position]);
		tv_fav.setText(collections[position]);
		return convertView;
	}

}
