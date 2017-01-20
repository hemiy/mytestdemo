package hemiy.qinghui.com.mytestdemo.retorfit;

import hemiy.qinghui.com.mytestdemo.util.URLConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 获取retrofit的接口,用这个来启动网络请求
 * Created by hemiy on 16/10/12 16:48.
 */

public class RetrofitApi {

    private static   Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URLConfig.SERVER_HOST) //基础网址,所有的接口都要以这个开头,同时网址最后添加一个/作为结束标记!!!!!否则会报错
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ApiService getApi() {
        return retrofit.create(ApiService.class);
    }

}
