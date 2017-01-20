package hemiy.qinghui.com.mytestdemo.retrofitpractice.progress;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;

import hemiy.qinghui.com.mytestdemo.R;
import hemiy.qinghui.com.mytestdemo.util.CommonUtil;
import rx.Subscriber;

/**
 * http://gank.io/post/56e80c2c677659311bed9841
 * 我们希望有一个Subscriber在我们每次发送请求的时候能够弹出一个ProgressDialog，
 * 带加载框的观察者 对象
 *
 * 注意 这个类的名字带一个Fun,说明处理的是剥离出来的泛型数据;同时错误处理放在的HttpResultFun中
 *
 * Created by hemiy on 16/11/19 17:52.
 */

public abstract class ProgressFunSubscriber<T> extends Subscriber<T> {

    private Dialog dialog;//加载框
    private Context context;

    public ProgressFunSubscriber(Context context) {
        this.context = context;
    }

    @Override
    public void onNext(T t) {
        responseSuccess(t);
    }

    @Override
    public void onStart() {
        dialog = CommonUtil.showLoadingDialog(context, R.string.loading);
    }


    @Override
    public void onCompleted() {
        CommonUtil.closeLoadingDialog(dialog);
    }

    @Override
    public void onError(Throwable e) {
        CommonUtil.closeLoadingDialog(dialog);
        Toast.makeText(context, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
    }


    public abstract void responseSuccess(T t);

}