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

public class RxbusActivity2 extends Activity {

    @BindView(R.id.btn_action)
    Button btnAction;
    @BindView(R.id.btnNextAc)
    Button btnNextAc;
    private Subscription rxSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxbus2);
        ButterKnife.bind(this);


//        再看接收事件的代码(也就是订阅事件),  只有事件发送后下面的代码才会执行
        rxSubscription = RxBusSticky.getDefault().toObservableSticky(UserEvent.class)
                .subscribe(new Action1<UserEvent>() {
                               @Override
                               public void call(UserEvent userEvent) {
                                   try {
                                       // 处理接收的事件
                                       // 捕捉异常：在任何操作符内的ActionX,FuncX方法以及onNext(T t)内使用try,catch处理
                                        // 不让异常被RxJava捕获



//                                       所以我们的RxBus的订阅者在处理订阅事件时，一旦发生了异常，而又没Catch，那么最终都会调用到onError()，
//                                       而一旦走到onError()，就意味着这个订阅者和该Subject解除了订阅关系，因此再也收不到后续发出的事件了
//

                                   long id = userEvent.getId();
                                   String name = userEvent.getName();
                                   LogUtil.i("id是" + id + "   名字是" + name);
                                   Toast.makeText(RxbusActivity2.this, "id是" + id + " 名字是" + name, Toast.LENGTH_SHORT).show();

                                   } catch (Exception e) {
                                       e.printStackTrace();
                                   }
                               }
                           }
                );

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!rxSubscription.isUnsubscribed()) {
            rxSubscription.unsubscribe();
        }

        //主activity里删除
        RxBusSticky.getDefault().removeAllStickyEvents();

    }


    @OnClick({R.id.btn_action,R.id.btnNextAc})
    public void onClick(View v) {
        if (v == btnAction) {
            //发送事件
//            RxBus.getDefault().post(new UserEvent(1, "yoyo"));
//            Toast.makeText(this, "事件发送了", Toast.LENGTH_SHORT).show();
        } else {
          startActivity(new Intent(RxbusActivity2.this, RxjavaActivity.class));
        }
    }
}
