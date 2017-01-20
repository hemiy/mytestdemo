package hemiy.qinghui.com.mytestdemo.retrofitpractice.progress;

import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;

import hemiy.qinghui.com.mytestdemo.R;
import hemiy.qinghui.com.mytestdemo.retrofitpractice.HttpResult;
import hemiy.qinghui.com.mytestdemo.util.CommonUtil;
import rx.Subscriber;

/**
 * http://gank.io/post/56e80c2c677659311bed9841
 * 我们希望有一个Subscriber在我们每次发送请求的时候能够弹出一个ProgressDialog，
 * 带加载框的观察者 对象
 *
 *
 * 注意,这里处理的是数据是原始的HttpResult数据。数据错误处理放在了onNext方法中
 *
 * Created by hemiy on 16/11/19 17:52.
 */

public abstract class ProgressSubscriber<T> extends Subscriber<HttpResult<T>> {

    private Dialog dialog;//加载框
    private Context context;

    public ProgressSubscriber(Context context) {
        this.context = context;
    }

    @Override
    public void onNext(HttpResult<T> t) {
        if(!t.getCode().equals("1")){
            onError(new Throwable(t.getDesc())); //处理数据传输错误
        }else{
            responseSuccess(t);
        }

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
        Toast.makeText(context, ""+e.getMessage(), Toast.LENGTH_SHORT).show();//失败的话会打印失败原因,数据由服务器返回
    }


    public abstract void responseSuccess(HttpResult<T> t);

}