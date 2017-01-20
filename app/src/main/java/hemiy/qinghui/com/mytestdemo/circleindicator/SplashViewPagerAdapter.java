package hemiy.qinghui.com.mytestdemo.circleindicator;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 引导页的数据适配器
 * @author zjt
 * @copyright 广州清汇信息科技有限公司
 *
 */
public class SplashViewPagerAdapter extends PagerAdapter{

	private List<View> views;		//显示内容列表
	
	public SplashViewPagerAdapter(List<View> views){
		this.views = views;
	}
	
	@Override
	public int getCount() {
		return views.size();			//个数
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return (arg0 == arg1);			//判断
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		((ViewPager) container).addView(views.get(position));	//添加到容器
		return views.get(position);
	}
	
	@Override
	public void destroyItem(View container, int position, Object object) {
		  ((ViewPager) container).removeView(views.get(position));       	//销毁
	}
	
}
