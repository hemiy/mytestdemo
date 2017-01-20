package hemiy.qinghui.com.mytestdemo.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;


/**
 *
 * http://www.jianshu.com/p/2b2bb6be83a8
 * google自带的tablayout
 * Created by hemiy on 16/6/8.
 */
public class TabLayoutActivity extends FragmentActivity {
    @BindView(R.id.tab_FindFragment_title)
    android.support.design.widget.TabLayout tabLayout;
    @BindView(R.id.vp_FindFragment_pager)
    ViewPager viewPager;
    private Find_tab_Adapter adapter;


    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ButterKnife.bind(this,view);
        setContentView(R.layout.activity_tablayout);
        ButterKnife.bind(this);
        initDatas();

    }

    private void initDatas() {

        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(new FansFragment("热门推荐"));
        list_fragment.add(new FansFragment("热门收藏"));
        list_fragment.add(new FansFragment("本月热榜"));
        list_fragment.add(new FansFragment("今日热榜"));

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("热门推荐");
        list_title.add("热门收藏");
        list_title.add("本月热榜");
        list_title.add("今日热榜");

        //设置TabLayout的模式 当很多个tab时可以滑动，见上面的参考地址
//        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //为TabLayout添加tab名称
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(list_title.get(3)));

        adapter = new Find_tab_Adapter(getSupportFragmentManager(),list_fragment,list_title);

        //viewpager加载adapter
        viewPager.setAdapter(adapter);

        //TabLayout加载viewpager
        tabLayout.setupWithViewPager(viewPager);

        //设置选择监听
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position=tab.getPosition();
                if(position==0){
                    viewPager.setCurrentItem(0);
                }else if(position==1){
                    viewPager.setCurrentItem(1);
                }else if(position==2){
                    viewPager.setCurrentItem(2);
                }else if(position==3){
                    viewPager.setCurrentItem(3);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}
