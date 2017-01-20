package hemiy.qinghui.com.mytestdemo.retorfit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hemiy.qinghui.com.mytestdemo.R;
import hemiy.qinghui.com.mytestdemo.model.ResponseData;
import hemiy.qinghui.com.mytestdemo.util.CommonUtil;
import hemiy.qinghui.com.mytestdemo.util.LoadingDialog;
import hemiy.qinghui.com.mytestdemo.util.Md5Util;
import hemiy.qinghui.com.mytestdemo.util.OkHttpUtil;
import hemiy.qinghui.com.mytestdemo.util.RequestCallback;
import hemiy.qinghui.com.mytestdemo.util.URLConfig;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * https://github.com/square/retrofit  官网
 * http://www.jianshu.com/p/0f97f94b171f 急速开发介绍
 * http://www.tuicool.com/articles/AveimyQ 用法详解------这个要重点看
 * http://blog.csdn.net/ghost_programmer/article/details/52372065 郭林推荐文章
 * <p>
 * <p>
 * Created by hemiy on 16/10/12 11:37.
 */

public class RetrofitActivity extends Activity {
    @BindView(R.id.btnGet)
    Button btnGet;
    @BindView(R.id.tvPhone)
    TextView tvPhone;
    @BindView(R.id.tvNickname)
    TextView tvNickname;
    @BindView(R.id.tvGender)
    TextView tvGender;
    @BindView(R.id.btnOkHttp)
    Button btnOkHttp;

    private LoadingDialog dialog;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        context=this;

    }

    @OnClick({R.id.btnGet, R.id.btnOkHttp})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGet:
                retrofit();
                break;
            case R.id.btnOkHttp:
                okhttp();
//                uploadFile();
                break;
        }
    }


    /**
     * 常规的http请求
     */
    private void okhttp() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("phone", "15989009055");
        params.put("password", Md5Util.md5("123456"));
        OkHttpUtil.doPost(context, URLConfig.ACTION_LOGIN_POST,params,new RequestCallback(){
            @Override
            public void onStart(okhttp3.Call call) {
                super.onStart(call);
                dialog = CommonUtil.showLoadingDialog(context, R.string.loading);
            }
            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                super.onResponse(call, response);
                final String body = response.body().string();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                });

                        CommonUtil.closeLoadingDialog(dialog);
                        try {
                            CommonUtil.log(body);
                            ResponseData responseData = CommonUtil.parseToObject(body, ResponseData.class);//转化为返回基类
                            if (responseData != null && responseData.getCode().equals("1")) {
                                CommonUtil.toast(RetrofitActivity.this, "登录成功");
                                JsonObject ob = responseData.getResult().getAsJsonObject();
                                if (ob != null) {
//                                    tvPhone.setText(ob.get("phone").getAsString());
                                    tvNickname.setText(ob.get("nickName").getAsString());
//                                    tvGender.setText(ob.get("gender").getAsString());
                                }

                            } else {
                                CommonUtil.toast(RetrofitActivity.this, "登录fail");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            CommonUtil.toast(context, R.string.bad_request);
                        }



            }

            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                super.onFailure(call, e);

                        CommonUtil.closeLoadingDialog(dialog);
                        CommonUtil.toast(context, R.string.bad_request);

            }
        });
    }

    /**
     * 封装了一个http的请求
     */
    private void retrofit() {
         dialog = CommonUtil.showLoadingDialog(this);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("phone", "15989009055");
        params.put("password", Md5Util.md5("123456"));
        Call<ResponseData> call = RetrofitApi.getApi().postLogin(params);
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {

                CommonUtil.closeLoadingDialog(dialog);

                //处理请求成功
                ResponseData responseData = response.body();//这里就已经解析成我们自己定义的javaBean实体了
                if (responseData != null && responseData.getCode().equals("1")) {
                    CommonUtil.toast(RetrofitActivity.this, "登录成功");
                    JsonObject ob = responseData.getResult().getAsJsonObject();
                    if (ob != null) {
                        tvPhone.setText(ob.get("phone").getAsString());
                        tvNickname.setText(ob.get("nickName").getAsString());
                        tvGender.setText(ob.get("gender").getAsString());
                    }

                } else {
                    CommonUtil.toast(context, "登录fail");
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                 CommonUtil.closeLoadingDialog(dialog);
                CommonUtil.toast(context,"retrofit请求失败");
                Log.i("tag", "fail");
            }
        });
    }

    /**
     * 上传单个文件
     */
    private void uploadFile() {
        File file = new File("");
        //构建requestbody
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        //将resquestbody封装为MultipartBody.Part对象
        //这里的第一个参数file 要和服务端沟通讲清楚
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        RetrofitApi.getApi().uploadFile(body);
    }


    /**
     * 上传文件
     */
    private void downLoadFile(){
//        RetrofitApi.getApi().downloadFile("11");
//        InputStream is = responseBody.byteStream();
//        String[] urlArr = url.split("/");
//        File filesDir = Environment.getExternalStorageDirectory();
//        File file = new File(filesDir, urlArr[urlArr.length - 1]);
//        if (file.exists()) file.delete();
    }

}
