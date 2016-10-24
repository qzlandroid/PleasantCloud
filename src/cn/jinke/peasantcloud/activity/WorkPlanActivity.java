package cn.jinke.peasantcloud.activity;

import com.baidu.mapapi.SDKInitializer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import cn.jinke.peasantcloud.R;
import cn.jinke.peasantcloud.R.layout;
import cn.jinke.peasantcloud.adapter.ConsultLvAdapter;
import cn.jinke.peasantcloud.adapter.WorkplanDoneLvAdapter;
import cn.jinke.peasantcloud.adapter.WorkplanTodoLvAdapter;

public class WorkPlanActivity extends Activity implements OnItemClickListener, OnItemLongClickListener,OnClickListener{
	
	private View view;
	ListView todo_listview,done_listview;
	
	//声明一个AlertDialog构造器
    private AlertDialog.Builder builder;
	private ImageView back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SDKInitializer.initialize(getApplicationContext());  //baidu map
		setContentView(R.layout.activity_work_plan);
		
		todo_listview = (ListView) findViewById(R.id.workplan_todo);
		done_listview = (ListView) findViewById(R.id.workplan_done);
		back = (ImageView)findViewById(R.id.workplan_back);
		
		todo_listview.setAdapter(new WorkplanTodoLvAdapter(this,1));
		done_listview.setAdapter(new WorkplanDoneLvAdapter(this,2));
		
		initListener();
		
	}
	private void initListener() {
		todo_listview.setOnItemClickListener(this);
		todo_listview.setOnItemLongClickListener(this);
		back.setOnClickListener(this);
	
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		switch(position)
		{
			case 0:
//				Toast.makeText(this,"You selected : " ,Toast.LENGTH_SHORT).show(); 
				Intent intent = new Intent(this,MapRouteActivity.class);
				startActivity(intent);
				break;
			case 1:
				break;
			case 2:   
				break;
			default:
				break;
		}
	}
	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
		
		showSimpleDialog(view);
		return true;
	}
	
	private void showSimpleDialog(View view) {
        builder=new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_message);

        //监听下方button点击事件
        builder.setPositiveButton(R.string.postive_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            		
        		done_listview.setAdapter(new WorkplanDoneLvAdapter(WorkPlanActivity.this,3));
        		todo_listview.setAdapter(new WorkplanTodoLvAdapter(WorkPlanActivity.this,0));
            }
        });
        builder.setNegativeButton(R.string.negative_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                }
        });

        //设置对话框是可取消的
        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.workplan_back:
			finish();
			break;

		default:
			break;
		}
		
	}
	

}
