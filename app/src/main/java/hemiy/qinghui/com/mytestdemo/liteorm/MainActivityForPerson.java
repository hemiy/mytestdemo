package hemiy.qinghui.com.mytestdemo.liteorm;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import hemiy.qinghui.com.mytestdemo.MyApplication;
import hemiy.qinghui.com.mytestdemo.R;


public class MainActivityForPerson extends Activity implements OnClickListener {
	private Button btnAdd;
	private Button btnAdd1;
	private Button btnDel;
	private Button btnUpdate;
	private Button btnQuery;
	private Button btnRawQuery;
	private List<Memo> list;
	private float x1 = 0;
    private float x2 = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd1 = (Button) findViewById(R.id.btnAdd1);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnQuery = (Button) findViewById(R.id.btnQuery);
        btnRawQuery = (Button) findViewById(R.id.btnRawQuery);
        
        btnAdd.setOnClickListener(this);
        btnAdd1.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnQuery.setOnClickListener(this);
        btnRawQuery.setOnClickListener(this);
        
//        list=new ArrayList<Memo>();
    }
	@SuppressWarnings("unused")
	@Override
	public void onClick(View v) {
		int id =v.getId();
		switch (id) {
		case R.id.btnAdd:
			  Memo mo=new Memo();
			  mo.setName("rinn");
			  mo.setContent("去美国读书");
			  mo.setIsLogin(true);
			  mo.setAge(21);
			  mo.setGender("女");
			  mo.setCreatetime(System.currentTimeMillis());
			  MyApplication.getDbUtils().save(mo);
			  Toast.makeText(this, "添加成功1", Toast.LENGTH_LONG).show();
			  break;
			  
		case R.id.btnAdd1:
			 Memo mo1=new Memo();
			  mo1.setName("hemiy");
			  mo1.setContent("中国");
			  mo1.setAge(28);
			  mo1.setIsLogin(true);
			  mo1.setGender("男");
			  mo1.setCreatetime(System.currentTimeMillis());
			MyApplication.getDbUtils().save(mo1);
//			  DataApplication.getDbUtils().save(list); 也可以一次添加多个
			  Toast.makeText(this, "添加成功2", Toast.LENGTH_LONG).show();
			break;
			
		case R.id.btnDel:
			//这个是把表也一同删除，执行后就不能再插入新数据，因为表也没有了
			boolean flag= MyApplication.getDbUtils().dropTable(Memo.class);
			Log.i("hemiy", flag?"删除成功":"删除失败");
			break;
			
		case R.id.btnUpdate:
			//id是子增长，从1开始计算
			Memo mo2=MyApplication.getDbUtils().queryById(2, Memo.class);    //根据id查询某个实体
			mo2.setContent("我在人民广场吃着炸鸡");
			MyApplication.getDbUtils().update(mo2);//更新实体
			break;
			
		case R.id.btnQuery:
			//如果删除了表，则查询该表的长度是0；  删除了表后再插入表，则插入不成功，数组长度一直为0 ，出现no such table: Memo

			//注意，如果一开始就没有建立表，则查询数组长度也为0
			List<Memo> list =  MyApplication.getDbUtils().query(Memo.class); //这个是查询全部
			Log.i("hemiy", "数组长度是----》"+list.size());
			for (Memo memo : list) {
				Log.i("hemiy", memo.toString());
			}
			
			//使用where查询特定条件
//			List<Memo> date =  DataApplication.getDbUtils().query(new QueryBuilder<Memo>(Memo.class).where("name = ?", new String[]{"hemiy"}));
//			List<Memo> date =  DataApplication.getDbUtils().query(new QueryBuilder<Memo>(Memo.class).where("id = ?", new String[]{"3"}));
//			   for (Memo memo : date) {
//				   Log.i("hemiy", memo.toString());
//			}    
			
			
			break;
			
		case R.id.btnRawQuery:
			
			//传统的查询方法
//		Cursor c=	DataApplication.getDbUtils().getWritableDatabase().rawQuery("select * from Memo where id=?",new String[]{"3"});//传统的执行sql语句
		Cursor c=	MyApplication.getDbUtils().getWritableDatabase().rawQuery("select * from Memo where name=?",new String[]{"hemiy"});//传统的执行sql语句
		if(c.getCount()>0){
			Log.i("hemiy", "查询的数量是"+c.getCount());
		}
		
		while(c.moveToNext()){
//			String name=c.getString(c.getColumnIndex("name"));
//			Log.i("hemiy", "查询的名字是"+name);
			int idNumber =c.getInt(c.getColumnIndex("id"));
			Log.i("hemiy", "查询的id是"+idNumber);
		}
		
		break;

		default:
			break;
		}
	}

//	 @Override
//	    public boolean onTouchEvent(MotionEvent event) {
//	        //继承了Activity的onTouchEvent方法，直接监听点击事件
//	        if(event.getAction() == MotionEvent.ACTION_DOWN) {
//	            //当手指按下的时候
//	            x1 = event.getX();
//	            Log.i("hemiy",""+x1);
//	        }
//	        if(event.getAction() == MotionEvent.ACTION_UP) {
//	            //当手指离开的时候
//	            x2 = event.getX();
//	            Log.i("hemiy",""+x2);
//	           if(x1 - x2 > 50) {
//	                Toast.makeText(MainActivity.this, "向左滑", Toast.LENGTH_SHORT).show();
//	            } else if(x2 - x1 > 50) {
//	                Toast.makeText(MainActivity.this, "向右滑", Toast.LENGTH_SHORT).show();
//	            }
//	        }
//	        return super.onTouchEvent(event);
//	    }
  
}
