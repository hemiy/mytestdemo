package hemiy.qinghui.com.mytestdemo.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * 加载对话框
 */
public class LoadingDialog extends Dialog {
    @BindView(R.id.tv_loading_text)
    TextView tvLoadingText;
    private String loadingText;

    public LoadingDialog(Context context, String loadingText) {
        super(context, R.style.loadingDialogStyle);
        this.loadingText = loadingText;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
        ButterKnife.bind(this);
        findViewById(R.id.rl_loading_dialog).getBackground().setAlpha(120);
        if (TextUtils.isEmpty(loadingText)) {
            tvLoadingText.setText("加载中...");
        } else {
            tvLoadingText.setText(loadingText);
        }
    }

    /**
     * 设置加载对话框文字
     */
    public void setLoadingText(String text) {
        this.loadingText = text;
        if (tvLoadingText != null) tvLoadingText.setText(loadingText);
    }

}
