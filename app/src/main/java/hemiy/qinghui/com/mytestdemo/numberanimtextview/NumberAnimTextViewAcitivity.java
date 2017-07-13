package hemiy.qinghui.com.mytestdemo.numberanimtextview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hemiy.qinghui.com.mytestdemo.R;
import info.hoang8f.widget.FButton;

/**
 * 一个数字滚动的textview
 * https://github.com/Bakumon/NumberAnimTextView
 * Created by hemiy on 17/1/22 15:58.
 */

public class NumberAnimTextViewAcitivity extends Activity {

    @BindView(R.id.btnDemo1)
    FButton btnDemo1;
    @BindView(R.id.btnDemo2)
    FButton btnDemo2;
    @BindView(R.id.btnDemo3)
    FButton btnDemo3;
    @BindView(R.id.ll_report)
    LinearLayout llReport;
    @BindView(R.id.tv1)
    NumberAnimTextView tv1;
    @BindView(R.id.tv2)
    NumberAnimTextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_anim_textview);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnDemo1, R.id.btnDemo2, R.id.btnDemo3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDemo1:
                //直接显示跳动的数字
                tv1.setNumberString("100.5");
                tv1.setDuration(5000);
                break;
            case R.id.btnDemo2:
                //设置数字增加范围和前缀
                tv2.setPrefixString("$");
                tv2.setNumberString("50","200");
                tv1.setDuration(1300);
                break;
            case R.id.btnDemo3:
                break;
        }
    }
}

//// 设置前缀
//mNumberAnimTextView.setPrefixString("¥");
//// 设置后缀
//        mNumberAnimTextView.setPostfixString("%");
//// 设置动画时长
//        mNumberAnimTextView.setDuration(2000);
//// 设置数字增加范围
//   mNumberAnimTextView.setNumberString("19.75", "99.75");