package hemiy.qinghui.com.mytestdemo.anctionforandroid;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.Toast;

import com.baoyz.actionsheet.ActionSheet;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hemiy.qinghui.com.mytestdemo.R;

/**
 *  一个gitup上的actionSheet 模仿ios的
 * https://github.com/baoyongzhang/ActionSheetForAndroid
 * Created by hemiy on 16/8/11.
 */
public class AsForAndroidActivity extends FragmentActivity implements ActionSheet.ActionSheetListener {


    @BindView(R.id.btn_action)
    Button btnAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionsheet_for_android);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_action)
    public void onClick() {

        ActionSheet.createBuilder(this,getSupportFragmentManager() )
                .setCancelButtonTitle("Cancel")
                .setOtherButtonTitles("Item1", "Item2", "Item3", "Item4")
                .setCancelableOnTouchOutside(true)
                .setListener(this).show();//
    }

    @Override
    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {

    }

    @Override
    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
        if(index==0){
            Toast.makeText(AsForAndroidActivity.this ,"0",Toast.LENGTH_SHORT).show();
        }else if(index==1){
            Toast.makeText(AsForAndroidActivity.this ,"1",Toast.LENGTH_SHORT).show();
        }
    }
}
