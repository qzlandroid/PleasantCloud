package cn.jinke.peasantcloud.fragment;

import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.adapter.ConsultLvAdapter;
import cn.jinke.peasantcloud.adapter.LectureGridViewAdapter;
import cn.jinke.peasantcloud.utils.BaseViewHolder;
import cn.jinke.peasantcloud.view.MyGridView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
/**
 * 农技咨询问答fragment
 * @author QZ
 *
 */
public class ConsultVpRightFragment extends BaseFragment {

	
	private View view;
	

	@Override
	public View initView() {
		view = View.inflate(mActivity, R.layout.fragment_consult_right, null);
		return view;
	}

	@Override
	public void initData() {
		ListView listView = (ListView) view.findViewById(R.id.consult_lv);
		listView.setAdapter(new ConsultLvAdapter(mActivity));
	}
}
