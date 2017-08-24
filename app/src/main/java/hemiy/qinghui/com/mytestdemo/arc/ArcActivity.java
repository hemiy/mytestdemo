package hemiy.qinghui.com.mytestdemo.arc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * http://blog.csdn.net/hebin320320/article/details/51072859
 *  Android自定义View — 用Canvas画百分数圆环
 * Created by hemiy on 16/6/23.
 */
public class ArcActivity extends Activity {



    @BindView(R.id.ll_report)
    LinearLayout llReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arc);
        ButterKnife.bind(this);

        llReport.removeAllViews();

        //score是百分数，数字、mcolor是外圈进度条以及数字的颜色，unit是百分号，title是数字下面的文字
        llReport.addView(new ReportArc(this, 100, 2,"","%") );
    }
}
