package hemiy.qinghui.com.mytestdemo.listviewtype;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * Created by hemiy on 16/10/19 10:01.
 */

public class ListViewTypeActivity extends Activity {
    @BindView(R.id.lv)
    ListView lv;
    private List<Person> list=new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_type);
        ButterKnife.bind(this);

        //根据不同的type设置不同的标题头省人大那里用到
       Person p1=new Person("hemiy",1);
       Person p2=new Person("tom",1);
       Person p3=new Person("jack",1);
       Person p4=new Person("lily",2);
       Person p5=new Person("rinn",2);
       Person p6=new Person("wanghong",3);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        PersonAdapter adapter=new PersonAdapter(ListViewTypeActivity.this,list);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
