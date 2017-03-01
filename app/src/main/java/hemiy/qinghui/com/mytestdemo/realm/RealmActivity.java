package hemiy.qinghui.com.mytestdemo.realm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * 一个流行的数据库 建表的过程比较简单,但是操作尤其是添加新表的时候略微繁琐
 * http://www.jianshu.com/p/50e0efb66bdf
 * http://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650238381&idx=1&sn=a0fc72220763166ca2e34519ff2055b3&chksm=88639cc2bf1415d40d466e76945338bc88efae957d63e3ea026c801f05883b485d185ffe0b73&mpshare=1&scene=23&srcid=0119Z3jYSu8dDHJDA9RGwT7F#rd
 * Created by hemiy on 17/1/19 16:34.
 */
//https://realm.io/docs/java/latest/#installation 官网

public class RealmActivity extends Activity implements View.OnClickListener {

    @BindView(R.id.btnInsert)
    Button btnInsert;
    @BindView(R.id.btnDelete)
    Button btnDelete;
    @BindView(R.id.btnQuery)
    Button btnQuery;
    @BindView(R.id.tvResult)
    TextView tvResult;
    @BindView(R.id.btnInsert2)
    Button btnInsert2;
    @BindView(R.id.ll_report)
    LinearLayout llReport;
    @BindView(R.id.btnUpdate)
    Button btnUpdate;

    private Realm mRealm; //一个开源的数据库

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);
        ButterKnife.bind(this);
        btnInsert.setOnClickListener(this);
        btnInsert2.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnQuery.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);

        //http://www.jianshu.com/p/37af717761cc
        mRealm = Realm.getDefaultInstance();

        //使用构造器来创建数据库
//        RealmConfiguration config = new RealmConfiguration.Builder()
//                .name("myrealm.realm") //文件名
//                .schemaVersion(0) //版本号
//                .build();
//        Realm realm = Realm.getInstance(config);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            //写入操作需要在事务中进行,Realm强制所有的写操作（添加、修改和删除对象）都在一个事务中执行从而确保数据的一致性。而查询不用开启事务

            case R.id.btnInsert:
//                当Model中存在主键的时候，推荐使用copyToRealmOrUpdate方法插入数据

                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Dog dog = new Dog();
                        dog.setName("hemiy");
                        dog.setAge(12);
                        dog.setId(1);
                        realm.copyToRealmOrUpdate(dog); //完成后会自动关闭事务
                    }
                });
                Toast.makeText(this, "第一次插入成功", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnInsert2:
                mRealm.beginTransaction();
                Dog dog = new Dog();
                dog.setName("jim");
                dog.setAge(2100);
                dog.setId(3);
                mRealm.copyToRealmOrUpdate(dog);
                mRealm.commitTransaction();
                Toast.makeText(this, "第2次插入成功", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnDelete:
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                       realm.deleteAll();
                    }
                });
                Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnQuery:
                StringBuilder sb = new StringBuilder();
                RealmResults<Dog> userList = mRealm.where(Dog.class).findAll();
//                RealmResults<Dog> userList = mRealm.where(Dog.class).equalTo("id",1).findAll();
//                RealmResults<Dog> userList = mRealm.where(Dog.class).equalTo("name", "jim").findAll();
                if (userList.isLoaded()) {
                    for (Dog d : userList) {
                        sb.append(d.toString());
                    }
                    tvResult.setText(sb.toString());
                }
                Logger.d(userList.toString());
                break;

            case R.id.btnUpdate:
                //更新
                //先找到对应的数据 通过名字去查询
                final Dog dd = mRealm.where(Dog.class).equalTo("name","hemiy").findFirst();

              if(dd!=null){//表示查询的结果存在
                  Toast.makeText(this, "存在", Toast.LENGTH_SHORT).show();
                  //直接修改即可
                  mRealm.executeTransaction(new Realm.Transaction() {
                      @Override
                      public void execute(Realm realm) {
                          dd.setName("super-hemiy");
                      }
                  });
              }else{//表示没有找到对应的查询结果
                  Toast.makeText(this, "不存在", Toast.LENGTH_SHORT).show();
                  return;
              }
                break;

            default:
                //默认的东西
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the Realm instance.
        if (mRealm != null) {
            mRealm.close();
        }
    }
}

