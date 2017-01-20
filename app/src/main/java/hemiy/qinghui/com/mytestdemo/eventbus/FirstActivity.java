package hemiy.qinghui.com.mytestdemo.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;
import hemiy.qinghui.com.mytestdemo.R;

public class FirstActivity extends Activity {

    Button btn;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EventBus.getDefault().register(this);
        btn = (Button) findViewById(R.id.btn_try);

        tv = (TextView) findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }


    /**
     * 用这个函数来接收消息
     *凡是参数相同的函数都会触发这个函数
     * @param event 自己定义的类
     */

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void receiveMsg(FirstEvent event) {
        String tag = event.getTag();//得到消息的类型
        if (TextUtils.isEmpty(tag)) {
            Log.i("hemiy", "没有类型");
            tv.setText("没有收到类型");
        } else {
            String msg = "BACKGROUND收到了消息" + " " + event.getMsg();
            tv.setText(msg);
            Log.i("hemiy", "收到了类型");
            Log.i("hemiy", "收到了类型111");
        }
    }


}
