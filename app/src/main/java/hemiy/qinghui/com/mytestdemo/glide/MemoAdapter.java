package hemiy.qinghui.com.mytestdemo.glide;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import org.xutils.x;

import java.util.List;

import hemiy.qinghui.com.mytestdemo.R;

/**
 * @author hemiy
 * 2016-8-26上午11:24:35
 */
public class MemoAdapter extends BaseAdapter {
	
	private Context context;
	private  List<String > memoList;
	

	


	public MemoAdapter(Context context, List<String> memoList) {
	 this.context=context;	
	 this.memoList=memoList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return memoList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return memoList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		  final String str = memoList.get(position);
          Holder holder;
          if (convertView == null) {
              convertView = LayoutInflater.from(context).inflate(R.layout.activity_cells, null);
              holder = new Holder();
              holder.imageView= (ImageView) convertView.findViewById(R.id.imageView1);
              convertView.setTag(holder);
          } else {
              holder = (Holder) convertView.getTag();
          }

		Log.i("tag",str);

		x.image().bind(holder.imageView,str); //使用的时xutil3,str直接使用文件的路径

          return convertView;
      }

	private class Holder {

		ImageView imageView;

    }

//	public void setList(List<Memo> memoList2) {
//		this.memoList=memoList2;
//	}

	public void clear() {
       if(memoList!=null){
    	   memoList.clear();
       }
		
	}

	
	
}
