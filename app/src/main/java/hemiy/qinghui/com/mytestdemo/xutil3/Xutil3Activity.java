package hemiy.qinghui.com.mytestdemo.xutil3;

import android.app.Activity;
import android.os.Bundle;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;

import java.util.HashMap;

/**
 * Created by hemiy on 16/6/25.
 */
public class Xutil3Activity  extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView();

        HttpUtil.Get("", new HashMap<String, String>(), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                System.out.println(ex.toString());
//                Toast.makeText(Wode_wenti.this,ex.toString(),Toast.LENGTH_LONG).show();
                if (ex instanceof HttpException) { // 网络错误
                    HttpException httpEx = (HttpException) ex;
                    int responseCode = httpEx.getCode();
                    String responseMsg = httpEx.getMessage();
                    String errorResult = httpEx.getResult();
                    System.out.println("responseCode==" + responseCode);
                    System.out.println("responseMsg==" + responseMsg);
                    System.out.println("errorResult==" + errorResult);
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
