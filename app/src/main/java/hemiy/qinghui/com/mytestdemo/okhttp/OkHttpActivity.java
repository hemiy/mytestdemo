package hemiy.qinghui.com.mytestdemo.okhttp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hemiy.qinghui.com.mytestdemo.R;
import hemiy.qinghui.com.mytestdemo.model.ResponseData;
import hemiy.qinghui.com.mytestdemo.util.CommonUtil;
import hemiy.qinghui.com.mytestdemo.util.OkHttpUtil;
import hemiy.qinghui.com.mytestdemo.util.RequestCallback;
import hemiy.qinghui.com.mytestdemo.util.URLConfig;
import okhttp3.Call;
import okhttp3.Response;

import static com.litesuits.android.async.AsyncExecutor.handler;

/**
 * okHttp的演示
 * http://blog.csdn.net/ghost_programmer/article/details/52253359 say hello to okth
 * Created by hemiy on 16/8/24 14:53.
 */
public class OkHttpActivity extends Activity {

    private int page = 1;
    private Context context;
    protected Dialog dialog;//加载框


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context=this;



        Map<String, String> params = new HashMap<String, String>();
        params.put("page", page + "");
        params.put("limit", "10");
        params.put("communityId", "3ff1949b-1f87-466f-a2c0-cb11d79d62af");
        params.put("avatarId", "8fd7e834-200e-44b0-b3c9-52b4047a31df");
        OkHttpUtil.doPost(context, URLConfig.ACTION_QUERY_ALL_POST, params, new RequestCallback() {
            @Override
            public void onStart(Call call) {
                super.onStart(call);
                dialog = CommonUtil.showLoadingDialog(context, R.string.loading);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                super.onResponse(call, response);
                final String body = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        CommonUtil.closeLoadingDialog(dialog);
                        try {
                            CommonUtil.log(body);
                            ResponseData responseData = CommonUtil.parseToObject(body, ResponseData.class);//转化为返回基类
                            if (responseData.check()) {


                            } else
                                CommonUtil.toast(context, responseData.getDesc());
                        } catch (Exception e) {
                            e.printStackTrace();
                            CommonUtil.toast(context, R.string.bad_request);
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                super.onFailure(call, e);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        CommonUtil.closeLoadingDialog(dialog);
                        CommonUtil.toast(context, R.string.bad_request);
                    }
                });
            }
        });

    }
}
