package hemiy.qinghui.com.mytestdemo.retorfit;

import java.util.List;
import java.util.Map;

import hemiy.qinghui.com.mytestdemo.model.ResponseData;
import hemiy.qinghui.com.mytestdemo.retrofitpractice.HttpResult;
import hemiy.qinghui.com.mytestdemo.retrofitpractice.progress.Order;
import hemiy.qinghui.com.mytestdemo.retrofitpractice.progress.User;
import hemiy.qinghui.com.mytestdemo.util.URLConfig;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 这个就是retrofit的接口,所有的请求都要放到这里去
 * Created by hemiy on 16/10/12 14:53.
 */

public interface ApiService {


    //上述Post请求有4个请求参数，假如说有更多的请求参数，
//  那么通过一个一个的参数传递就显得很麻烦而且容易出错，这个时候就可以用FieldMap
//  @FormUrlEncoded //也就是说，其实使用该注解过后，正是通过表单形式来上传参数的。这时服务器就可以通过request.getParameter直接读取参数了：


   /* 总结
     如果要上传json字符串 需要添加header注释,同时需要添加body,同时body里面可以是map,不一定是实体,2者不可以或缺*/

    @Headers({"Content-type: application/json"})    //这个是上传json字符串 测试过可以用
    @POST(URLConfig.ACTION_LOGIN_POST)
    Call<ResponseData> postLogin(@Body Map<String, Object> map);//ResponseDatas类是这个请求所返回的json转化的java类



    @Headers({"Content-type: application/json"})    //这个是上传json字符串 测试过可以用
    @POST(URLConfig.ACTION_LOGIN_POST)
    Observable<HttpResult<User>> postLogin2(@Body Map<String, Object> map);//ResponseDatas类是这个请求所返回的json转化的j




    @Headers({"Content-type: application/json"})    //这个是上传json字符串 测试过可以用
    @POST(URLConfig.ACTION_ORDER_LIST)
    Observable<HttpResult<List<Order>>> getOrderList(@Body Map<String, Object> map);//ResponseDatas类是这个请求所返回的json转化的j


//    需要借助@Multipart注解、@Part和MultipartBody实现。 上传单个图片
//   参考文章 http://www.jianshu.com/p/0f97f94b171f
    @Multipart
    @POST("mobile/upload")
    Call<ResponseBody> uploadFile(@Part MultipartBody.Part file);


   //上传多个图片
    @Multipart
    @POST("upload/upload")
    Call<ResponseBody> uploadFiles(@PartMap List<MultipartBody.Part> list);


    //@Streaming     //这里需要注意的是如果下载的文件较大，比如在10m以上，那么强烈建议你使用@Streaming进行注解，否则将会出现IO异常.
    @GET
    Call<ResponseBody> downloadFile(@Url String fileUrl);






    //---------课外学习-----------

    //和rxjava一起结合使用
//http://www.tuicool.com/articles/jIzAraF 重点看
//    http://www.jianshu.com/p/6acb4d9ae519
//    http://blog.csdn.net/efan006/article/details/50543990

//    我们今天着重来介绍下 RxJavaCallAdapterFactory 这个类。用过的朋友们都知道，它是用来把 Retrofit 转成 RxJava 可用的适配类。
//    retrofit 本身是无法识别 Observable<ResponseBody> 然后去工作的，如果没有这个适配器就根本无法工作，因此我们的适配器的作用，就是生成我们想要的 Observable 。
//    addCallAdapterFactory(RxJavaCallAdapterFactory.create())，这样我们才可以优雅的使用 Retrofit + RxJava 。
//
    @GET("/aaa")
    Observable<ResponseBody> getQuestionNewestList();


    //
    /**
     * 登录接口  使用表单的形式
     * @return
     */
    @Headers("Content-Type: application/x-www-form-urlencoded;charset=UTF-8") //避免中文编码问题
    @FormUrlEncoded
    @POST("taoKaAction!login.action")
    Observable<ResponseBody> login(@Field("channelCode") String channelCode, @Field("authCode") String authCode);

    /**查询版本更新
     * @param url
     * @return*/
    @GET
    Observable<ResponseBody> queryNewVersionInfo(@Url String url); //注意使用url注解后,传递的是完整的uri路径,baseuri路径会被忽略

}
