package hemiy.qinghui.com.mytestdemo.circleindicator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;
import me.relex.circleindicator.CircleIndicator;

/**
 * 圆点指示器
 * https://github.com/ongakuer/CircleIndicator
 * Created by hemiy on 16/8/31 13:48.
 */
public class CircleIndicatorActivity extends Activity implements View.OnClickListener {
    @BindView(R.id.splash_viewpager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    CircleIndicator indicator;
    @BindView(R.id.btnEnter)
    Button btnEnter;


    //viewpager显示内容
    private List<View> views;
    private int[] imgs = { R.drawable.bg_splash_1, R.drawable.bg_splash_2, R.drawable.bg_splash_3, R.drawable.bg_splash_4};
    private SplashViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_indicator);

        ButterKnife.bind(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initViews();
    }

    /*
         * 初始化ViewPager显示的内容
         */
    private void initViews() {

        //1，添加引导图
        views = new ArrayList<View>();
        for (int i = 0; i < imgs.length; i++) {
            View view = new View(this);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            view.setLayoutParams(params);
            view.setBackgroundResource(imgs[i]);
            views.add(view);
        }
        adapter = new SplashViewPagerAdapter(views);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        //注册滑动的监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

                //最后一页才显示进入按钮
                if(position == views.size() - 1){
                    indicator.setVisibility(View.GONE);
                    btnEnter.setVisibility(View.VISIBLE);
                }else{
                    indicator.setVisibility(View.VISIBLE);
                    btnEnter.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }

        });

        
        btnEnter.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View view) {
        if(view==btnEnter){
            Toast.makeText(CircleIndicatorActivity.this, "点击了按钮", Toast.LENGTH_SHORT).show();
        }
    }
}
