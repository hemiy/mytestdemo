package hemiy.qinghui.com.mytestdemo.eventbus;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.greenrobot.event.EventBus;
import hemiy.qinghui.com.mytestdemo.R;

public class SecondActivity extends Activity {
    private Button btn_FirstEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus2);
        btn_FirstEvent = (Button) findViewById(R.id.btn_first_event);
        btn_FirstEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //	发送消息是使用EventBus中的Post方法来实现发送的，发送过去的是我们新建的类的实例！
                EventBus.getDefault().post(new FirstEvent("FirstEvent btn clicked"));
            }
        });


    }




    public void sendForOne(View view) {

        EventBus.getDefault().post(new FirstEvent("指定发送", "1"));
    }

    public void enterThird(View view) {
//        startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
    }

}
