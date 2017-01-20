package hemiy.qinghui.com.mytestdemo.liteorm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import hemiy.qinghui.com.mytestdemo.MyApplication;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * 一个数据库
 * https://github.com/litesuits/android-lite-orm
 * @author hemiy 2016-9-26上午9:47:40
 */
public class PersonActivity extends Activity implements OnClickListener {

	private Button btnAdd;
	private Button btnAdd1;
	private Button btnDel;
	private Button btnUpdate;
	private Button btnQuery;
	private Button btnRawQuery;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person);
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
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.btnAdd:
             Person p=new Person();
             p.setName("rinn");
             p.setGender("女");
             MyApplication.getDbUtils().save(p);
			 Toast.makeText(this, "添加成功1", Toast.LENGTH_LONG).show();
			break;
			
		case R.id.btnAdd1:
            Person p1=new Person();
            p1.setName("lily");
            p1.setGender("hahahhahah");
            p1.setPrice(12.023f);
			MyApplication.getDbUtils().save(p1);
			 Toast.makeText(this, "添加成功1", Toast.LENGTH_LONG).show();
			break;

		case R.id.btnQuery:
			queryList();
			break;
			
		case R.id.btnDel:
			
			//根据某个obj去删除
			Person p2  =  MyApplication.getDbUtils().query(Person.class).get(0);
			MyApplication.getDbUtils().delete(p2);
			 queryList();
			break;
			
		case R.id.btnUpdate:
			//如果是使用了dropTable删除表后，则不能再添加数据，因为表已经不在了
			//这里是删除整个表是数据，删除之后可以再次添加，比如原来有3个数据，删除后再添加则自增，id为4
			MyApplication.getDbUtils().deleteAll(Person.class);
			queryList();
			break;

		default:
			break;
		}
	}

	private void queryList() {
		List<Person> list2 =  MyApplication.getDbUtils().query(Person.class); //这个是查询全部
			Log.i("hemiy", "数组长度是----》"+list2.size());
			for (Person person : list2) {
				Log.i("hemiy", person.toString());
			}
	}
}
