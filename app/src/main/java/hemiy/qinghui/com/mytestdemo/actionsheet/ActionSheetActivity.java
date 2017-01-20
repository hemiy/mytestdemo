//package hemiy.qinghui.com.mytestdemo.actionsheet;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.LinearLayout;
//import android.widget.Toast;
//
//import com.roc.actionsheet.ActionSheet;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import hemiy.qinghui.com.mytestdemo.R;
//
//
//// * 引入第3方的开源库
//// * Created by hemiy on 16/6/25.
////
//
//public class ActionSheetActivity extends Activity {
//    @BindView(R.id.btn_action)
//    Button btnAction;
//    @BindView(R.id.ll_report)
//    LinearLayout llReport;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_actionsheet);
//        ButterKnife.bind(this);
//        btnAction.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setTheme(R.style.ActionSheetStyleIOS7);
//                ActionSheet menuView = new ActionSheet(ActionSheetActivity.this);
//                menuView.setCancelButtonTitle("取消");// before add items
//                menuView.addItems("拨打" + "15989900545","手机","图片");
////                menuView.addItems("你好");
//                menuView.setItemClickListener(new ActionSheet.MenuItemClickListener() {
//
//                    @Override
//                    public void onItemClick(int itemPosition) {
//                        // TODO Auto-generated method stub
//                        switch (itemPosition) {
//                            case 0:
//                                Toast.makeText(ActionSheetActivity.this,"打电话",Toast.LENGTH_SHORT).show();
//                                break;
//
//                            case 1:
//                                Toast.makeText(ActionSheetActivity.this,"欧式",Toast.LENGTH_SHORT).show();
//                                break;
//
//                            default:
//                                break;
//                        }
//                    }
//                });
//
//                menuView.setCancelableOnTouchMenuOutside(true);
//                menuView.showMenu();
//            }
//        });
//    }
//}
