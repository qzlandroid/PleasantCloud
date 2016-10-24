package cn.jinke.peasantcloud.view;

import org.xmlpull.v1.XmlPullParser;  

import android.R.integer;  
import android.content.Context;  
import android.content.res.ColorStateList;  
import android.util.AttributeSet;  
import android.util.TypedValue;  
import android.view.Gravity;  
import android.view.View;  
import android.widget.LinearLayout;  
import android.widget.TextView;  
import cn.jinke.peasantcloud.R;  
/**
 * 自定义控件 左右切换按钮  
 * @author QZ
 *
 */
public class SegmentView2 extends LinearLayout {  
    private TextView textView1;  
    private TextView textView2;  
    private TextView textView3;  
    private onSegmentView2ClickListener listener;  
    public SegmentView2(Context context, AttributeSet attrs) {  
        super(context, attrs);  
        init();  
    }  
      
    public SegmentView2(Context context) {  
        super(context);  
        init();  
    }  
  
    private void init() {  
//      this.setLayoutParams(new LinearLayout.LayoutParams(dp2Px(getContext(), 60), LinearLayout.LayoutParams.WRAP_CONTENT));  
        textView1 = new TextView(getContext());  
        textView2 = new TextView(getContext()); 
        textView3 = new TextView(getContext());
        textView1.setLayoutParams(new LayoutParams(0, dp2Px(getContext(),32), 1));  
        textView2.setLayoutParams(new LayoutParams(0, dp2Px(getContext(),32), 1)); 
        textView3.setLayoutParams(new LayoutParams(0, dp2Px(getContext(),32), 1));
        textView1.setText("专家");  
        textView2.setText("知识库");  
        textView3.setText("问答"); 
        XmlPullParser xrp = getResources().getXml(R.drawable.seg_text_color_selector);    
        try {    
            ColorStateList csl = ColorStateList.createFromXml(getResources(), xrp);    
            textView1.setTextColor(csl);  
            textView2.setTextColor(csl);  
            textView3.setTextColor(csl);
          } catch (Exception e) {    
        }   
        textView1.setGravity(Gravity.CENTER);  
        textView2.setGravity(Gravity.CENTER);  
        textView3.setGravity(Gravity.CENTER);
        textView1.setPadding(3, 6, 3, 6);  
        textView2.setPadding(3, 6, 3, 6);  
        textView3.setPadding(3, 6, 3, 6);
        setSegmentTextSize(16);  
        textView1.setBackgroundResource(R.drawable.seg_left);  
        textView2.setBackgroundResource(R.drawable.seg_center);
        textView3.setBackgroundResource(R.drawable.seg_right); 
        textView2.setSelected(true);  
        this.removeAllViews();  
        this.addView(textView1);  
        this.addView(textView2);  
        this.addView(textView3); 
        this.invalidate();  
          
        textView1.setOnClickListener(new OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
                if (textView1.isSelected()) {  
                    return;  
                }  
                textView1.setSelected(true);  
                textView2.setSelected(false);  
                textView3.setSelected(false);
                if (listener != null) {  
                    listener.onSegmentView2Click(textView1, 0);  
                }  
            }  
        });  
        textView2.setOnClickListener(new OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
                if (textView2.isSelected()) {  
                    return;  
                }  
                textView2.setSelected(true);  
                textView1.setSelected(false);  
                textView3.setSelected(false);
                if (listener != null) {  
                    listener.onSegmentView2Click(textView2, 1);  
                }  
            }  
        });  
        textView3.setOnClickListener(new OnClickListener() {  
            
            @Override  
            public void onClick(View v) {  
                if (textView3.isSelected()) {  
                    return;  
                }  
                textView3.setSelected(true); 
                textView2.setSelected(false);  
                textView1.setSelected(false);  
                if (listener != null) {  
                    listener.onSegmentView2Click(textView3, 2);  
                }  
            }  
        });  
    }  
    /** 
     * 设置字体大小 单位dip 
     * <p>2014年7月18日</p> 
     * @param dp 
     * @author RANDY.ZHANG 
     */  
    public void setSegmentTextSize(int dp) {  
        textView1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, dp);  
        textView2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, dp);  
        textView3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, dp);  
    }  
      
    private static int dp2Px(Context context, float dp) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dp * scale + 0.5f);  
    }  
      
    public void setOnSegmentView2ClickListener(onSegmentView2ClickListener listener) {  
        this.listener = listener;  
    }  
    public void setSelected(int position){
    	if (position==0) {
    		textView1.setSelected(true); 
    		textView2.setSelected(false);
    		textView3.setSelected(false);
		}else if (position == 1) {
			textView2.setSelected(true); 
			textView1.setSelected(false);
			textView3.setSelected(false);
		}else {
			textView2.setSelected(false); 
			textView1.setSelected(false);
			textView3.setSelected(true);
		}
    }  
      
    /** 
     * 设置文字 
     * <p>2014年7月18日</p> 
     * @param text 
     * @param position 
     * @author RANDY.ZHANG 
     */  
    public void setSegmentText(CharSequence text,int position) {  
        if (position == 0) {  
            textView1.setText(text);  
        }  
        if (position == 1) {  
            textView2.setText(text);  
        }  
        if (position == 2) {  
            textView3.setText(text);  
        }  
    }  
      
    public static interface onSegmentView2ClickListener{  
        /** 
         *  
         * <p>2014年7月18日</p> 
         * @param v 
         * @param position 0-左边 1-右边 
         * @author RANDY.ZHANG 
         */  
        public void onSegmentView2Click(View v,int position);  
    }  
}  