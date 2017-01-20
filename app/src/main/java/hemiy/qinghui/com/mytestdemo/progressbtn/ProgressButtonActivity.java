package hemiy.qinghui.com.mytestdemo.progressbtn;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dd.CircularProgressButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * https://github.com/dmytrodanylyk/circular-progress-button
 * Created by hemiy on 16/6/10.
 */
public class ProgressButtonActivity extends Activity {
    @BindView(R.id.btnWithText)
    CircularProgressButton btnWithText;
    private int i=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar_btn);
        ButterKnife.bind(this);


        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btnWithText.setProgress(++i);
            }
        });

    }
}
