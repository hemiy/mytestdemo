package hemiy.qinghui.com.mytestdemo.retrofitpractice;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import hemiy.qinghui.com.mytestdemo.retorfit.ApiService;
import hemiy.qinghui.com.mytestdemo.util.URLConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 单例
 * http://www.jianshu.com/p/811ba49d0748 参考文章
 * Created by hemiy on 16/11/19 14:49.
 */

public class RetrofitServiceManager {

    private static final int DEFAULT_CONNECT_TIME_OUT = 5;//设置连接时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 10; //设置读取时间

    private  Retrofit mRetrofit;
    private static  RetrofitServiceManager retrofitManager; //静态私有的实体变量,就是这个类的本身
    private  OkHttpClient mClient;


    //获取ApiManager的单例 静态公有的获取方法
    public static RetrofitServiceManager getInstance() {
        if (retrofitManager == null) {
            synchronized (RetrofitServiceManager.class) {
                if (retrofitManager == null) {
                    retrofitManager = new RetrofitServiceManager();
                }
            }
        }
        return retrofitManager;
    }

    //私有化构造函数
    private RetrofitServiceManager(){

        // 创建Retrofit
        mRetrofit = new Retrofit.Builder()
                .client(createClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //这个根据需要看是否要添加 否则可以注释掉
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URLConfig.SERVER_HOST)
                .build();
    }




    private OkHttpClient createClient() {

//        http://blog.csdn.net/picasso_l/article/details/53200926
        // 打印数据,包括上传和返回的数据 注意gradle里面要添加一个包
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.i("RetrofitLog", "response---->" + message);
                    }
                });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor) //根据要求添加过滤器
//                .addNetworkInterceptor(headerInterceptor)
//                .followRedirects(false)
                .retryOnConnectionFailure(true)
                .connectTimeout(DEFAULT_CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);

        return builder.build();
    }


    /**
     * 获取api统一的接口
     * @return
     */
    public ApiService getApi(){
        return mRetrofit.create(ApiService.class);
    }

    /**
     * 获取对应的Service
     * @param service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T createApi(Class<T> service){
        return mRetrofit.create(service);
    }


}
