package hemiy.qinghui.com.mytestdemo.tablayout;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hemiy.qinghui.com.mytestdemo.R;


/**
 * 好友——粉丝碎片
 * 
 * @author shtl
 * @copyright 广州清汇信息科技有限公司
 */
@SuppressLint("ValidFragment")
public class FansFragment extends Fragment  {
	private Activity activity;
	private View view;
	private String str;
	private TextView tv;



   public FansFragment(String str){
	   this.str=str;
   }


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_fans,null);
		tv= (TextView) view.findViewById(R.id.tv_item);
		tv.setText(str);
		return view;
	}


}
