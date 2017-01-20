package hemiy.qinghui.com.mytestdemo.butterknife;

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
 * https://github.com/pedant/sweet-alert-dialog
 * Created by hemiy on 16/6/5.
 */
public class ButterKnifeActivity extends Activity {


    @BindView(R.id.btn_showCommon)
    Button btnShowCommon;
    @BindView(R.id.btn_showContent)
    Button btnShowContent;
    @BindView(R.id.btn_shwoWarning)
    Button btnShwoWarning;
    @BindView(R.id.btn_showSuccess)
    Button btnShowSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btn_showCommon, R.id.btn_showContent, R.id.btn_shwoWarning, R.id.btn_showSuccess})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_showCommon:
                Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_showContent:
                Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_shwoWarning:
                Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_showSuccess:
                Toast.makeText(getApplicationContext(),"4",Toast.LENGTH_LONG).show();
                break;
        }
    }



}
