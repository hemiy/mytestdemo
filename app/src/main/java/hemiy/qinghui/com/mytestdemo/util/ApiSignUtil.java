package hemiy.qinghui.com.mytestdemo.util;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * User: zjt
 * DateTime: 2016/10/27 14:52
 * <p>
 * 生成接口签名工具类
 */
public class ApiSignUtil {

    public static final String API_SECRET_KEY = "17e88074f56841a4";                    //密钥

    /**
     * 根据请求参数构建签名
     *
     * @param params
     * @return
     */
    public static String buildSignByMap(Map<String, Object> params) throws Exception {

        StringBuilder formatParams = new StringBuilder("");

        params.remove("sign");           //去除sign参数

        //1,对请求参数key按ASCII排序,并拼接成“参数=参数值&”的方式
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Object value = params.get(key);
            if (value == null || TextUtils.isEmpty(value.toString()))
                continue;

            if (formatParams.toString().trim().length() > 0) {
                formatParams.append("&");
            }

            formatParams.append(key + "=" + value);
        }

//        System.out.println(" formatParams ---> " + formatParams);

        //2,进行aes加密
        byte[] bytes = AESEncryptUtil.encrypt(formatParams.toString().getBytes("utf-8"), API_SECRET_KEY);

        //3,进行base64编码,生成最终签名
        String sign = Base64.encode(bytes);
//        System.out.println(" sign ---> " + sign);
        return sign;
    }

}