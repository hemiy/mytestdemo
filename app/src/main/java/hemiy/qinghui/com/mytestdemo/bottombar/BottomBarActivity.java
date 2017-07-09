package hemiy.qinghui.com.mytestdemo.bottombar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;

import static hemiy.qinghui.com.mytestdemo.R.id.btnBuild;

/**
 * 底部导航栏 同时可以设置小红点的数量
 * https://github.com/roughike/BottomBar
 * http://www.jianshu.com/p/8e6b75e11a3d
 * Created by hemiy on 16/11/4 14:37.
 */

public class BottomBarActivity extends Activity {
    @BindView(R.id.contentContainer)
    FrameLayout contentContainer;
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;
    @BindView(R.id.tvContent)
    TextView tvContent;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        ButterKnife.bind(this);
        context = this;
        initViews();//初始化控件
    }

    private void initViews() {
        //设置小圆点的数量

        bottomBar.getTabWithId(R.id.btnShopCar).setBadgeCount(5);
        bottomBar.getTabWithId(R.id.btnBuild).setBadgeCount(1);
        bottomBar.getTabWithId(R.id.btnImg).setBadgeCount(2);
        bottomBar.getTabWithId(R.id.btnSale).setBadgeCount(12);

//        bottomBar.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.btnShopCar) {
                    tvContent.setText("btnShopCar");
                    removeBadge( bottomBar.getTabWithId(R.id.btnShopCar));
                } else if (tabId == btnBuild) {
                    tvContent.setText("btnBuild");
                    removeBadge( bottomBar.getTabWithId(R.id.btnBuild));
                } else if (tabId == R.id.btnImg) {
                    tvContent.setText("btnImg");
                    removeBadge( bottomBar.getTabWithId(R.id.btnImg));
                } else if (tabId == R.id.btnSale) {
                    tvContent.setText("btnSale");
                    removeBadge( bottomBar.getTabWithId(R.id.btnSale));
                }
            }
        });


        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                //重选事件，当前已经选择了这个，又点了这个tab。微博点击首页刷新页面
            }
        });

    }

    /**
     * 点击后删除小圆点,取消小红点
     * @param tabWithId
     */
    private void removeBadge(BottomBarTab tabWithId) {
        tabWithId.removeBadge();
    }
}

//这个是