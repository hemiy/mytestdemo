package hemiy.qinghui.com.mytestdemo.util;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 网络接口回调，没有用接口，是因为类中的方法不是必须实现的
 */
public class RequestCallback {

    /**
     * 请求开始时调用（在主线程）
     */
    public void onStart(Call call) {
    }

    /**
     * 调用失败时调用（在非主线程）
     */
    public void onFailure(Call call, final IOException e) {
    }

    /**
     * 调用成功时调用（在非主线程）
     */
    public void onResponse(Call call, Response response) throws IOException {
    }
}
