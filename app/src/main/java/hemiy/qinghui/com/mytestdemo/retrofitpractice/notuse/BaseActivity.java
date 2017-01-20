package hemiy.qinghui.com.mytestdemo.retrofitpractice.notuse;

import android.app.Activity;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 这个是用于订阅和取消observable的基础类,暂时不用
 * Created by hemiy on 16/11/19 20:21.
 */

public class BaseActivity extends Activity {
    CompositeSubscription mCompositeSubscription;

    public void addSubscribe(Observable observable, Subscriber subscriber) {
        if(mCompositeSubscription == null)
            mCompositeSubscription = new CompositeSubscription();
        mCompositeSubscription.add(
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(subscriber));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mCompositeSubscription != null)
            mCompositeSubscription.clear();
    }
}
