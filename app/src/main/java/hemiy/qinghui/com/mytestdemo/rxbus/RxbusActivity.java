package hemiy.qinghui.com.mytestdemo.rxbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hemiy.qinghui.com.mytestdemo.R;
import hemiy.qinghui.com.mytestdemo.rxjava.RxjavaActivity;
import hemiy.qinghui.com.mytestdemo.util.LogUtil;
import rx.Subscription;
import rx.functions.Action1;

/**
 * http://www.jianshu.com/p/ca090f6e2fe2
 * Created by hemiy on 16/9/30 15:31.
 */

public class RxbusActivity extends Activity {

    @BindView(R.id.btn_action)
    Button btnAction;
    @BindView(R.id.btnNextAc)
    Button btnNextAc;
    private Subscription rxSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxbus);
        ButterKnife.bind(this);


//        再看接收事件的代码(也就是订阅事件),  只有事件发送后下面的代码才会执行


        //当调用Observable.subscribe()，会返回一个Subscription对象。这个对象代表了被观察者和订阅者之间的联系。
        rxSubscription = RxBus.getDefault().toObservable(UserEvent.class)
                .subscribe(new Action1<UserEvent>() {
                               @Override
                               public void call(UserEvent userEvent) {
                                   long id = userEvent.getId();
                                   String name = userEvent.getName();
                                   LogUtil.i("id是" + id + "   名字是" + name);
                                   Toast.makeText(RxbusActivity.this, "id是" + id + " 名字是" + name, Toast.LENGTH_SHORT).show();
                               }
                           }
                );

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!rxSubscription.isUnsubscribed()) {
            //你可以在后面使用这个Subscription对象来操作被观察者和订阅者之间的联系.
            rxSubscription.unsubscribe();
        }
    }


    @OnClick({R.id.btn_action,R.id.btnNextAc})
    public void onClick(View v) {
        if (v == btnAction) {
            //发送事件
            RxBus.getDefault().post(new UserEvent(1, "yoyo"));
            Toast.makeText(this, "事件发送了", Toast.LENGTH_SHORT).show();
        } else {
          startActivity(new Intent(RxbusActivity.this, RxjavaActivity.class));
        }
    }
}
