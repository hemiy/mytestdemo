package hemiy.qinghui.com.mytestdemo.sweetdialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import cn.pedant.SweetAlert.SweetAlertDialog;
import hemiy.qinghui.com.mytestdemo.R;




/**
 *https://github.com/pedant/sweet-alert-dialog
 * Created by hemiy on 16/6/5.
 */
public class SweetDialog extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweet_dialog);

    }

    public void showCommon(View view){
        new SweetAlertDialog(this)
                .setTitleText("Here's a message!")
                .show();
    }

    //显示普通样式
    public void showCommon2(View view){
        new SweetAlertDialog(this)
                .setTitleText("Here's a message!")
                .setContentText("It's pretty, isn't it?")
                .show();
    }


    //显示警告提示
    public void showCommon3(View view){
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this file!")
                .setConfirmText("确定!")
                .show();
    }

    //自定义成功样式
    public void showCommon4(View view){
      new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
              .setTitleText("Good job!")
              .setContentText("You clicked the button!")
              .show();
    }

    //显示自定义的图片
    public void showCommon5(View view){
        new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("Sweet!")
                .setContentText("Here's a custom image.")
                .setCustomImage(R.drawable.ic_launcher)
                .show();
    }

    //复杂的样式
    public void showCommon6(View view){
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this file!")
                .setConfirmText("Yes,delete it!")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog
                                .setTitleText("Deleted!")
                                .setContentText("Your imaginary file has been deleted!")
                                .setConfirmText("OK")
                                .setConfirmClickListener(null)
                                .showCancelButton(false)
                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                    }
                })
                .setCancelText("取消")
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
//                                .setTitleText("确定取消吗？")
//                                .setContentText("不会逆转")
//                                .setCancelClickListener(null)
//                                .changeAlertType(SweetAlertDialog.ERROR_TYPE);
                    }
                })
                .show();
    }

}
