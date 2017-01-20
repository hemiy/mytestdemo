package hemiy.qinghui.com.mytestdemo.immersive;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import hemiy.qinghui.com.mytestdemo.R;

/**
 * 沉浸式状态栏
 * 郭林的文章 http://blog.csdn.net/sinyu890807/article/details/51763825
 * 简书 http://www.jianshu.com/p/7dcfd243b1df
 * Created by hemiy on 16/9/29 16:02.
 *
 *
 * http://www.jianshu.com/p/d1a84ee4305c
 * 实现设置系统状态栏颜色需要至少在Android 4.4.2（API 19）以上。这是因为，在这个版本以下，没有任何的API可以帮助我们来实现
 */

public class ImmersiveActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immervice);
//        注意两个Flag必须要结合在一起使用，表示会让应用的主体内容占用系统状态栏的空间，(注意这段的表述)
//        最后再调用Window的setStatusBarColor()方法将状态栏设置成透明色就可以了。
        setImmervice();

        //新建一个和ToolBar一样背景色的View添加到原来状态栏的位置
        //经过平安项目的实践,下面的的这个方法使用于版本4.4-5.0之间,当5.0以上时使用getWindow.setStatusBarColor()直接设置即可
        setStateBarColor(this); //注意单独使用这个方法去设置是不行的,会出现2个类似的状态栏着色

    }

    //沉浸式模式
    private void setImmervice() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0 全透明实现
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//使 ContentView 内容不再覆盖状态栏
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);//需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.setStatusBarColor(Color.TRANSPARENT); //5.0以上才能用这个方法
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //4.4 全透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//让contentView侵入状态栏
        }
    }


    public static void setStateBarColor(Activity activity) {
// 设置状态栏颜色
        ViewGroup contentLayout = (ViewGroup) activity.findViewById(android.R.id.content);
//        setupStatusBarView(activity, contentLayout, Color.parseColor("#43B7EA"));//这里具体设置状态栏的颜色
        setupStatusBarView(activity, contentLayout, Color.TRANSPARENT);//这里具体设置状态栏的颜色
        // 设置Activity layout的fitsSystemWindows
        View contentChild = contentLayout.getChildAt(0);
        contentChild.setFitsSystemWindows(true);//等同于在根布局设置android:fitsSystemWindows="true"
    }

    private static void setupStatusBarView(Activity activity, ViewGroup contentLayout, int color) {
        View mStatusBarView = null;
        View statusBarView = new View(activity);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        contentLayout.addView(statusBarView, lp);
        mStatusBarView = statusBarView;
        mStatusBarView.setBackgroundColor(color);
    }

    /** * 获得状态栏高度 */
    private static int getStatusBarHeight(Context context) {
        int resourceId =context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }
}
