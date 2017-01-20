package hemiy.qinghui.com.mytestdemo.countdownview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * 一个圆环形状的倒计时
 * http://www.jianshu.com/p/3db73ba78882
 * Created by hemiy on 16/10/19 16:50.
 */

public class CounterDownActivity extends Activity {
    @BindView(R.id.countDownView)
    CountdownView countDownView;
    @BindView(R.id.btn_action)
    Button btnAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown_view);
        ButterKnife.bind(this);
        countDownView.setCountDownTimerListener(new CountdownView.CountDownTimerListener() {
            @Override
            public void onStartCount() {
                Toast.makeText(CounterDownActivity.this, "start", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinishCount() {
                Toast.makeText(CounterDownActivity.this, "finish", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.btn_action)
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_action:
                countDownView.start();
                break;
        }
    }
}
