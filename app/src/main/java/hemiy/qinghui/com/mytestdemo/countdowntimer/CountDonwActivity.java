package hemiy.qinghui.com.mytestdemo.countdowntimer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * 一个倒计时的控件
 * Created by hemiy on 16/6/23.
 */
public class CountDonwActivity extends Activity {

    @BindView(R.id.tvCountDown)
    TextView tvCode;

    //倒计时控件 这里的1000-3 是为了准确计算时间 否则会出现倒计时的跳跃造成不准确
    private CountDownTimer timer = new CountDownTimer(9000, 1000-3) {

        @Override
        // millisUntilFinished 倒计时剩余时间
        public void onTick(long millisUntilFinished) {
           // Log.i("hemiy", millisUntilFinished+"");
            tvCode.setText("重新获取" + "(" + millisUntilFinished / 1000 + "s"	+ ")");
            tvCode.setTextColor(Color.parseColor("#000000"));
            tvCode.setEnabled(false); // 设为不可点击
            tvCode.setBackgroundColor(Color.parseColor("#ff0045"));
        }

        @Override
        public void onFinish() {
            tvCode.setTextColor(Color.parseColor("#ffffff"));
            tvCode.setText("获取验证码");
            tvCode.setEnabled(true);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        ButterKnife.bind(this);
        //设置监听
        tvCode.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                timer.start();
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();//退出时候要取消
        }

    }
}
