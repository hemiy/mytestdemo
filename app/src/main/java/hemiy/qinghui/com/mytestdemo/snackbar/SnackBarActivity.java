package hemiy.qinghui.com.mytestdemo.snackbar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * snackBar的使用
 * Created by hemiy on 16/10/19 15:38.
 */

public class SnackBarActivity extends Activity {

    //绑定控件
    @BindView(R.id.btn_action)
    Button btnAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_action)
    public void onClick(View v) {
        Snackbar snackbar = Snackbar.make(v, "请选择操作", Snackbar.LENGTH_INDEFINITE)//表示不会消失
                .setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SnackBarActivity.this, "点击了", Toast.LENGTH_SHORT).show();
                    }
                });
        //设置提示文字颜色
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        ((TextView) snackbarLayout.findViewById(R.id.snackbar_text)).setTextColor(Color.parseColor("#FFFFFF"));
        snackbar.show();
    }
}
