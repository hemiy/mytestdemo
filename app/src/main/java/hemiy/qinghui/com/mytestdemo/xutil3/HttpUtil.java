package hemiy.qinghui.com.mytestdemo.xutil3;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

import hemiy.qinghui.com.mytestdemo.util.JsonUtil;

/**
 * Created by hemiy on 16/6/25.
 */
public class HttpUtil {
    /**
     * 发送get请求
     * @param <T>
     */
    public static <T> Callback.Cancelable Get(String url, Map<String,String> map, Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(url);
        if(null!=map){
            for(Map.Entry<String, String> entry : map.entrySet()){
                params.addQueryStringParameter(entry.getKey(), entry.getValue());
            }
        }
        Callback.Cancelable cancelable = x.http().get(params, callback);
        return cancelable;
    }

    /**
     * 发送post请求
     * @param <T>
     */
    public static <T> Callback.Cancelable Post(String url, Map<String,Object> map, Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(url);
        if(null!=map){
            for(Map.Entry<String, Object> entry : map.entrySet()){
//               params.set
                params.addParameter(entry.getKey(), entry.getValue());
            }
        }
        Callback.Cancelable cancelable = x.http().post(params, callback);
        return cancelable;
    }


    /**
     * http://blog.csdn.net/u011907407/article/details/50888169
     * 发送post请求  发送内容为Json字符串
     * @param <T>
     */
    public static <T> Callback.Cancelable PostJson(String url, Map<String,Object> map, Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(url);

        params.setAsJsonContent(true);
        params.setBodyContent(JsonUtil.parseToJsonStr(map));//吧map转为json字符串，用于数据发送

        Callback.Cancelable cancelable = x.http().post(params, callback);
        return cancelable;
    }



    /**
     * 上传文件
     * @param <T>
     */
    public static <T> Callback.Cancelable UpLoadFile(String url, Map<String,Object> map, Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(url);
        if(null!=map){
            for(Map.Entry<String, Object> entry : map.entrySet()){
                params.addParameter(entry.getKey(), entry.getValue());
            }
        }
        params.setMultipart(true);
        Callback.Cancelable cancelable = x.http().post(params, callback);
        return cancelable;
    }

    /**
     * 下载文件
     * @param <T>
     */
    public static <T> Callback.Cancelable DownLoadFile(String url, String filepath, Callback.CommonCallback<String> callback){
        RequestParams params=new RequestParams(url);

        //设置断点续传
        params.setAutoResume(true);
        params.setSaveFilePath(filepath);
        Callback.Cancelable cancelable = x.http().get(params, callback);
        return cancelable;
    }
}
