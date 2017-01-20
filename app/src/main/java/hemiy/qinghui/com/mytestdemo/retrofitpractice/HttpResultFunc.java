package hemiy.qinghui.com.mytestdemo.retrofitpractice;

/**
 * http://gank.io/post/56e80c2c677659311bed9841
 * Created by hemiy on 16/11/19 16:14.
 */

import rx.functions.Func1;

/**
 * http://blog.csdn.net/soslinken/article/details/51149625
 * 这个类的作用就是把T泛型里面的数据抽取出来
 *
 * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
 * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
 */
public class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

    //注意  Fun1的第一参数就是输入的参数,第二个参数就是返回的参数

    @Override
    public T call(HttpResult<T> httpResult) {
        if (!httpResult.getCode().equals("1") ) {
            //1表示数据成功,其他都是失败,会抛出异常,suscribe的onError方法会执行,弹出错误原因
            throw new IllegalStateException(httpResult.getDesc());
        }
        return httpResult.getResult();//这个就是把HttpResult 再剥离一层,而且是成功的结果,这里的result就是返回的数据
    }
}
