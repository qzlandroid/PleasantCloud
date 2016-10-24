package cn.jinke.peasantcloud.utils;

import android.R.integer;
import android.content.Context;
import android.widget.LinearLayout.LayoutParams;
/**
 * 像素工具类
 * @author QZ
 *
 */
public class DensityUtils {

	/**
	 * dp转px
	 * @param context
	 * @param dp
	 * @return
	 */
	public static int dp2Px(Context context, float dp) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dp * scale + 0.5f);  
    }  
	
	/**
	 * px转dp
	 */
	public static float px2Dp(Context context, int px){
        final float scale = context.getResources().getDisplayMetrics().density;  
        return px /scale;
        
	}
	
	/**
	 * 代码设置控件的宽高
	 * @param context
	 * @param width 控件宽度,单位dp
	 * @param height 控件高度,单位dp
	 * @return
	 */
	public static LayoutParams setControlSize(Context context,float width, float height){
		//int width = getWindowManager().getDefaultDisplay().getWidth();获取屏幕宽高
		//int height = getWindowManager().getDefaultDisplay().getHeight();
		LayoutParams params = new LayoutParams(dp2Px(context, width), dp2Px(context, height));
		return params;
	}
	
	
}
