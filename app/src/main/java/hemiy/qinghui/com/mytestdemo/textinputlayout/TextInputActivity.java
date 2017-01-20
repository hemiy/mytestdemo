package hemiy.qinghui.com.mytestdemo.textinputlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * http://blog.csdn.net/Hebin320320/article/details/51461611
 * 使用TextInputLayout创建一个登陆界面
 * http://www.jcodecraeer.com/a/basictutorial/2015/0821/3338.html
 * Created by hemiy on 16/6/10.
 */
public class TextInputActivity extends Activity {


    @BindView(R.id.edit_text_email)
    EditText editTextEmail;
    @BindView(R.id.textInputEmail)
    TextInputLayout textInputEmail;
    @BindView(R.id.edit_text_password)
    EditText editTextPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textinpu_layout);
        ButterKnife.bind(this);
        // 一旦用户开始输入，hint会消失。这并不理想，因为用户丢失了他们输入信息的上下文提示。
        //  有了TextInputLayout，这将不再是问题。一个单一的EditText 在输入文字的时候会隐藏hint，而被包含在TextInputLayout中的EditText则会让hint变成一个在EditText上方的浮动标签。同时还包括一个漂亮的material动画。


    }
}
