//package hemiy.qinghui.com.mytestdemo.retrofitpractice.notuse;
//
//
//import com.do1.vop.model.common.BaseModel;
//import com.do1.vop.model.http.ProgressManager;
//import com.do1.vop.model.http.ProgressRequestBody;
//
//import java.io.File;
//import java.net.SocketTimeoutException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//import okhttp3.MediaType;
//import okhttp3.MultipartBody;
//import okhttp3.RequestBody;
//
//
///**
//   从东莞视频营业厅拷贝过来的数据
// * Created by Admin on 2016/7/5.
// */
//public final class RetrofitUtil {
//
//    static final String IMAGE_TYPE = "image/png";
//    static final String RESPONSE_CODE_OK = "1", RESPONSE_CODE_TIMEOUT = "110";
//
//    public static boolean isOK(BaseModel model) {
//        return RESPONSE_CODE_OK.equals(model.getCode());
//    }
//
//    public static boolean isTimeout(BaseModel model) {
//        return RESPONSE_CODE_TIMEOUT.equals(model.getCode());
//    }
//
//
//    /**
//     * @Multipart
//     * url
//     * mthod(@Part MultipartBody.Part part)
//     * @param paramKey
//     * @param files
//     * @return
//     */
//    public static List<MultipartBody.Part> filesToMultipartBodyPart(String paramKey, List<File> files) {
//        List<MultipartBody.Part> parts = new ArrayList<>(files.size());
//        for (File file: files) {
//            RequestBody requestBody = RequestBody.create(MediaType.parse(IMAGE_TYPE), file);
//            MultipartBody.Part part = MultipartBody.Part.createFormData(paramKey, file.getName(), requestBody);
//            parts.add(part);
//        }
//        return parts;
//    }
//
//    /**
//     * @Multipart
//     * url
//     * mthod(@Part MultipartBody.Part part)
//     * @param paramKey
//     * @param value
//     * @return
//     */
//    public static MultipartBody.Part stringToMultipartBodyPart(String paramKey, String value) {
//        return MultipartBody.Part.createFormData(paramKey, value);
//    }
//
//    /**
//     * url
//     * mthod(@Body MultipartBody body)
//     * @param requestJsonKey
//     * @param requestJson
//     * @param fileKey
//     * @param files
//     * @return
//     */
//    public static MultipartBody formBody(String requestJsonKey, String requestJson,
//                                         String fileKey, List<File> files, ProgressManager progressManager) {
//        MultipartBody.Builder builder = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart(requestJsonKey, requestJson);
//        if (files != null && !files.isEmpty()) {
//            for (File file: files) {
//                RequestBody requestBody = RequestBody.create(MediaType.parse(IMAGE_TYPE), file);
//                ProgressRequestBody progressRequestBody = new ProgressRequestBody(requestBody, progressManager.getProgressListener());
//                progressManager.addBodyLength(progressRequestBody.contentLength());
//                builder.addFormDataPart(fileKey, file.getName(), progressRequestBody);
//            }
//        }
//        return builder.build();
//    }
//
//
//    public static MultipartBody formBodyNew(String phone1, String phone2,
//                                         String fileKey, List<File> files, ProgressManager progressManager) {
//        MultipartBody.Builder builder = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("tkOrderPO.mobileNum", phone1)
//                .addFormDataPart("tkOrderPO.agencyMobileNum",phone2);
//        if (files != null && !files.isEmpty()) {
//            int i=0;
//            for (File file: files) {
//                RequestBody requestBody = RequestBody.create(MediaType.parse(IMAGE_TYPE), file);
//                ProgressRequestBody progressRequestBody = new ProgressRequestBody(requestBody, progressManager.getProgressListener());
//                progressManager.addBodyLength(progressRequestBody.contentLength());
//                builder.addFormDataPart(fileKey+"["+i+"].image", file.getName(), progressRequestBody);
//                i++;
//            }
//        }
//        return builder.build();
//    }
//
//    /**
//     * url
//     * mthod(@Body MultipartBody body)
//     * @param fileKey
//     * @param files
//     * @return
//     */
//    public static MultipartBody formBodyFile(String fileKey, List<File> files, ProgressManager progressManager) {
//        MultipartBody.Builder builder = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM);
//        if (files != null && !files.isEmpty()) {
//            for (File file: files) {
//                RequestBody requestBody = RequestBody.create(MediaType.parse(IMAGE_TYPE), file);
//                ProgressRequestBody progressRequestBody = new ProgressRequestBody(requestBody, progressManager.getProgressListener());
//                progressManager.addBodyLength(progressRequestBody.contentLength());
//                builder.addFormDataPart(fileKey, file.getName(), progressRequestBody);
//            }
//        }
//        return builder.build();
//    }
//
//    public static String throwableMsg(Throwable e) {
//        if(e == null) return "";
//        String msg = e.getMessage();
//        if (e instanceof SocketTimeoutException)
//            msg = "系统繁忙，请稍候重试！";
//        return msg;
//    }
//
//    public static Throwable newThrowable(String dsc) {
//        return new Throwable(dsc);
//    }
//
//    /**
//     * 创建一个UUID字符串
//     * @return
//     */
//    public static String newUUID() {
//        return UUID.randomUUID().toString();
//    }
//}
