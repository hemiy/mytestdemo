package hemiy.qinghui.com.mytestdemo.flatbutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hemiy.qinghui.com.mytestdemo.R;
import info.hoang8f.widget.FButton;

/**
 * 扁平化的button
 * https://github.com/hoang8f/android-flat-button
 * Created by hemiy on 16/9/1 17:17.
 */
public class FlatButtonActivity extends Activity {
    @BindView(R.id.btn1)
    FButton btn1;
    @BindView(R.id.btn2)
    FButton btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flatbutton);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1, R.id.btn2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                break;
            case R.id.btn2:
                break;
        }
    }
}
