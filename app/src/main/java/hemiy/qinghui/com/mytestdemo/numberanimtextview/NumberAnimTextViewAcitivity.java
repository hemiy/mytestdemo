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
                break;
            case R.id.btnDemo2:
                break;
            case R.id.btnDemo3:
                break;
        }
    }
}
