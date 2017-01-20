package hemiy.qinghui.com.mytestdemo.floatbutton;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * 悬浮按钮
 * https://github.com/makovkastar/FloatingActionButton/issues
 * Created by hemiy on 16/6/8.
 */
public class FloatButtonAcvitity extends Activity {


    @BindView(android.R.id.list)
    ListView listView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private Context context;

    private List<String> datas = new ArrayList<>();
    private ArrayAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_button);
        ButterKnife.bind(this);
        context=this;
        intiDatas();

    }

    private void intiDatas() {
        datas.add("广州1");
        datas.add("深圳2");
        datas.add("韶关3");
        datas.add("红山4");
        datas.add("北京5");

        datas.add("广州6");
        datas.add("深圳7");
        datas.add("韶关8");
        datas.add("红山9");
        datas.add("北京10");

        datas.add("广州11");
        datas.add("深圳12");
        datas.add("韶关13");
        datas.add("红山14");
        datas.add("北京15");

        datas.add("广州16");
        datas.add("深圳17");
        datas.add("韶关18");
        datas.add("红山19");
        datas.add("北京20");
        adapter = new ArrayAdapter(FloatButtonAcvitity.this, R.layout.item_for_list, datas);
        listView.setAdapter(adapter);
        //悬浮按钮的设置监听
        fab.attachToListView(listView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FloatButtonAcvitity.this,"点击了",Toast.LENGTH_LONG).show();
            }
        });
    }

}
