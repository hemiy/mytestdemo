package hemiy.qinghui.com.mytestdemo.util;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import hemiy.qinghui.com.mytestdemo.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 网络请求工具类
 */
public class OkHttpUtil {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final OkHttpClient mOkHttpClient = new OkHttpClient().newBuilder().connectTimeout(15, TimeUnit.SECONDS).build();
    private static Handler mDelivery=new Handler(); //用这个是为了切换到主线程执行


    /**
     * post请求
     *
     * @param context  上下文对象
     * @param action   请求动作
     * @param params   请求的参数,如果没有可为空
     * @param callback 回调函数
     */
    public static void doPost(Context context, String action, Map<String, String> params, final RequestCallback callback) {
        if (context == null) return;
        if (!CommonUtil.isNetworkConnected(context)) {
            CommonUtil.toast(context, "网络连接不可用,请稍后在试！");
            return;
        }
        RequestBody body = RequestBody.create(JSON, CommonUtil.parseToJsonStr(params));
        Request request = new Request.Builder()
                .url(URLConfig.SERVER_HOST + action)
                .post(body)
                .build();
        Call call = mOkHttpClient.newCall(request);
        if (callback != null) callback.onStart(call);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {

                //切换到主线程  默认是在子线程,需要切换到主线程
                //同时这里不是activity,所以不能使用runOnUIThrea来切换,只能使用handler来切换了
//                http://blog.csdn.net/lmj623565791/article/details/47911083
                mDelivery.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback != null) callback.onFailure(call, e);
                        e.printStackTrace();
                    }
                });

//                if (callback != null) callback.onFailure(call, e);
            }

            @Override
            public void onResponse(final Call call, final Response response) throws IOException {


                mDelivery.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback != null){
                            try {
                                callback.onResponse(call, response);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

//                if (callback != null) callback.onResponse(call, response); //这个是原来的天林写的,在子线程里面执行
            }
        });
    }


    /**
     * 这里使用了HttpClinet的API。只是为了方便
     *
     * @param params 请求参数
     */
    private static String formatParams(Map<String, String> params) {
        if (params == null || params.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            if (sb.length() > 0) sb.append("&");
            sb.append(key);
            sb.append("=");
            sb.append(params.get(key));
        }
        return sb.toString();
    }

    /**
     * 为HttpGet 的 url 方便的添加多个name value 参数。
     *
     * @param url    接口路径
     * @param params 请求参数
     */
    private static String attachHttpGetParams(String url, Map<String, String> params) {
        return url + "?" + formatParams(params);
    }

    /**
     * get请求
     *
     * @param context  上下文对象
     * @param action   请求动作
     * @param params   请求的参数,如果没有可为空
     * @param callback 回调函数
     */
    public static void doGet(Context context, String action, Map<String, String> params, final RequestCallback callback) throws IOException {
        if (context == null) return;
        if (!CommonUtil.isNetworkConnected(context)) {
            CommonUtil.toast(context, "网络连接不可用,请稍后再试！");
            return;
        }
        Request request = new Request.Builder().url(attachHttpGetParams(URLConfig.SERVER_HOST + action, params)).get().build();
        Call call = mOkHttpClient.newCall(request);
        if (callback != null) callback.onStart(call);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                if (callback != null) callback.onFailure(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (callback != null) callback.onResponse(call, response);
            }
        });
    }

    /**
     * 根据文件名称猜测文件MediaType
     *
     * @param fileName 文件名称
     */
    private static MediaType guessMimeType(String fileName) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String contentType = fileNameMap.getContentTypeFor(fileName);
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return MediaType.parse(contentType);
    }

    /**
     * 上传单个图片
     *
     * @param context  上下文对象
     * @param file     上传文件
     * @param action   上传路径后缀
     * @param callback 回调函数
     */
    public static void uploadFile(Context context, File file, String action, final RequestCallback callback) {
        if (context == null || file == null) return;
        if (!CommonUtil.isNetworkConnected(context)) {
            CommonUtil.toast(context, "网络连接不可用,请稍后再试！");
            return;
        }
        MultipartBody.Builder multipartBodybuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        String fileName = file.getName();
        RequestBody fileBody = RequestBody.create(guessMimeType(fileName), file);
        multipartBodybuilder.addFormDataPart("fileImg", fileName, fileBody);
        RequestBody requestBody = multipartBodybuilder.build();
        Request request = new Request.Builder().post(requestBody).url(URLConfig.SERVER_HOST + action).build();
        Call call = mOkHttpClient.newCall(request);
        if (callback != null) callback.onStart(call);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                if (callback != null) callback.onFailure(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (callback != null) callback.onResponse(call, response);
            }
        });
    }

    /**
     * 上传单个图片
     *
     * @param context  上下文对象
     * @param files    多个上传文件
     * @param action   上传路径后缀
     * @param callback 回调函数
     */
    public static void uploadFiles(Context context, List<File> files, String action,
                                   final RequestCallback callback) {
        if (context == null || files == null || files.isEmpty()) return;
        if (!CommonUtil.isNetworkConnected(context)) {
            CommonUtil.toast(context, "网络连接不可用,请稍后再试！");
            return;
        }
        MultipartBody.Builder multipartBodybuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        RequestBody fileBody;
        String fileName;
        for (File file : files) {
            fileName = file.getName();
            fileBody = RequestBody.create(guessMimeType(fileName), file);
            multipartBodybuilder.addFormDataPart("fileImg", fileName, fileBody);
        }
        RequestBody requestBody = multipartBodybuilder.build();
        Request request = new Request.Builder().post(requestBody).url(URLConfig.SERVER_HOST + action).build();
        Call call = mOkHttpClient.newCall(request);
        if (callback != null) callback.onStart(call);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                if (callback != null) callback.onFailure(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (callback != null) callback.onResponse(call, response);
            }
        });
    }

    /**
     * 文件下载事件监听
     */
    public interface OnDownloadFileListener {
        /**
         * 开始下载
         */
        public void onStart();

        /**
         * 下载完成
         */
        public void onCompleted(String message);
    }

    /**
     * 下载文件
     *
     * @param context  上下文对象
     * @param url      文件url
     * @param listener 文件下载事件监听
     */
    public static void downloadFile(Context context, String url, final OnDownloadFileListener listener) {
        if (context == null || TextUtils.isEmpty(url) || !CommonUtil.isExistSdcard()) return;
        final String fileName = url.substring(url.lastIndexOf("/") + 1);
        if (TextUtils.isEmpty(fileName)) return;
        if (!CommonUtil.isNetworkConnected(context)) {
            CommonUtil.toast(context, context.getString(R.string.net_not_ok));
            return;
        }
        Request request = new Request.Builder().url(url).build();
        if (listener != null) listener.onStart();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is = null;
                FileOutputStream fos = null;
                try {
                    File file = new File(ConstantUtil.PICTURE_PATH);
                    if (!file.exists()) file.mkdirs();
                    String path = ConstantUtil.PICTURE_PATH + fileName;
                    file = new File(path);
                    byte[] buf = new byte[2048];
                    int len = 0;
                    is = response.body().byteStream();
                    fos = new FileOutputStream(file);
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    fos.flush();
                    if (listener != null) listener.onCompleted("文件保存在" + path);
                } catch (Exception e) {
                    if (listener != null) listener.onCompleted("文件保存失败");
                } finally {
                    try {
                        if (is != null)
                            is.close();
                    } catch (IOException e) {
                    }
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException e) {
                    }
                }
            }

            @Override
            public void onFailure(Call call, final IOException e) {
                if (listener != null) listener.onCompleted("文件保存失败");
            }
        });

    }
}
