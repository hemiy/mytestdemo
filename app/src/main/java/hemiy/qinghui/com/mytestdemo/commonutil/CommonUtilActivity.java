package hemiy.qinghui.com.mytestdemo.commonutil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.litesuits.common.assist.FlashLight;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * 通用的工具类
 * https://github.com/litesuits/android-common
 * Created by hemiy on 16/10/10 13:40.
 */

public class CommonUtilActivity extends Activity {

    @BindView(R.id.btnOpen)
    Button btnOpen;
    @BindView(R.id.btnClose)
    Button btnClose;

    //私有控件
    private  FlashLight fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_util);
        ButterKnife.bind(this);
        fl=new FlashLight();
    }

    @OnClick({R.id.btnOpen, R.id.btnClose})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOpen:
                fl.turnOnFlashLight();
                break;
            case R.id.btnClose:
                fl.turnOffFlashLight();
                break;
        }
    }
}

