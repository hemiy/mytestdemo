package hemiy.qinghui.com.mytestdemo.togglebutton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.sevenheaven.iosswitch.ShSwitchView;

import hemiy.qinghui.com.mytestdemo.R;

/**
 * https://github.com/Nightonke/JellyToggleButton   果冻效果按钮
 * https://github.com/7heaven/SHSwitchView
 * Created by hemiy on 16/8/24 14:53.
 */
public class ToggleButtonActivity extends Activity {

    private ShSwitchView switchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);
        switchView= (ShSwitchView) findViewById(R.id.switch_view);
        switchView.setOnSwitchStateChangeListener(new ShSwitchView.OnSwitchStateChangeListener() {
            @Override
            public void onSwitchStateChange(boolean isOn) {
                Toast.makeText(ToggleButtonActivity.this,""+isOn,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
