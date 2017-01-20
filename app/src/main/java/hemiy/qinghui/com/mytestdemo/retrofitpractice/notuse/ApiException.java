package hemiy.qinghui.com.mytestdemo.retrofitpractice.notuse;

/**
 * 自定义异常
 * Created by hemiy on 16/11/19 16:16.
 */
public class ApiException extends RuntimeException {
    public static final int USER_NOT_EXIST = 100;
    public static final int WRONG_PASSWORD = 101;
    private String detailMessage;

    public ApiException(String detailMessage) {
        getApiExceptionMessage(detailMessage);
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(String code){
        String message = "";
        int m=Integer.valueOf(code);
        switch (m) {
            case USER_NOT_EXIST:
                message = "该用户不存在";
                break;
            case WRONG_PASSWORD:
                message = "密码错误";
                break;
            default:
                message = "未知错误";

        }
        return message;
    }
}
