package hemiy.qinghui.com.mytestdemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * fragment和activity之间的通信
 * <p>
 * http://www.tuicool.com/articles/7rUJfeN
 * http://blog.csdn.net/u013003052/article/details/50445354
 * http://blog.csdn.net/lmj623565791/article/details/37992017
 * Created by hemiy on 16/11/17 13:49.
 */

public class FragmentDemoActivity extends FragmentActivity implements  SendMessageListener,View.OnClickListener {
    @BindView(R.id.tvTobecall)
    TextView tvTobecall;
    @BindView(R.id.llTobecall)
    LinearLayout llTobecall; //待接警 点击
    @BindView(R.id.tvUncall)
    TextView tvUncall;
    @BindView(R.id.tvUncallNum)
    TextView tvUncallNum;   //未接警 数量
    @BindView(R.id.llUncall)
    LinearLayout llUncall;   //未接警 点击
    @BindView(R.id.tvHavecall)
    TextView tvHavecall;
    @BindView(R.id.tvHavecallNum)//已接警 数量
    TextView tvHavecallNum;
    @BindView(R.id.llHavecall)
    LinearLayout llHavecall;   //已接警点击
    @BindView(R.id.flContent)
    FrameLayout flContent;       //容器 用于填写



    private Fragment currentFragment, fragments[] = new Fragment[3];  //放入了fragment的数组
    private LinearLayout lls[]=new LinearLayout[3]; //用于点击事件的数组封装

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        ButterKnife.bind(this);
        initViews();
        initDatas();
    }

    private void initViews() {
        lls[0]=llTobecall; //点击的linearLayout控件
        lls[1]=llUncall;
        lls[2]=llHavecall;

        llTobecall.setOnClickListener(this);
        llUncall.setOnClickListener(this);
        llHavecall.setOnClickListener(this);
    }



    private void initDatas() {

        FragmentManager fm = getSupportFragmentManager();
        List<Fragment> ls = fm.getFragments(); //得到里面的fragment里面的数据

        Log.i("tag",ls==null?"ls为空":"ls不为空");

        if (ls != null && !ls.isEmpty()) {
            FragmentTransaction transaction = fm.beginTransaction();
            for (Fragment item : ls) {
                transaction.remove(item);
            }
            transaction.commit();
        }

        fragments[0] =new ToBeCallFragment();        //3个fragment的 onCreateView方法只会执行一次,因为是显示和隐藏
        fragments[1] = new UnCallFragment();
        fragments[2] = new HaveCallFragment();
        fm.beginTransaction().add(R.id.flContent, fragments[0]).commit(); //显示第一个页面
        currentFragment = fragments[0]; //设置当前的fragment 这句必须有
    }



    //接口回调
    @Override
    public void sendMessage() {
      //在第一个fragment里触发了点击事件,需要修改activity上的控件内容(根据上海财大要求)
     String num= tvHavecallNum.getText().toString().trim();
        if(!TextUtils.isEmpty(num)){
            tvHavecallNum.setText((Integer.valueOf(num)+1)+"");
        }else{
            tvHavecallNum.setText("1");
        }

    }


    //控件的点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llTobecall:// 待接警
                switchFragment(0);
                break;
            case R.id.llUncall:// 未接警
                switchFragment(1);
                break;
            case R.id.llHavecall:// 已接警
                switchFragment(2);
                break;
            default:
                break;
        }
    }

    private void switchFragment(int index) {


        try {
            if (currentFragment != fragments[index]) {
                if (!fragments[index].isAdded()) {// 添加
                    getSupportFragmentManager().beginTransaction().hide(currentFragment)
                            .add(R.id.flContent, fragments[index]).commit();

                    Log.i("tag","新添加");
                } else {// 隐藏显示
                    getSupportFragmentManager().beginTransaction().hide(currentFragment).show(fragments[index])
                            .commit();

                    Log.i("tag","之前已添加,所以只是显示和隐藏");
                }
                currentFragment = fragments[index];

                // 设置点击的背景
                for (int i = 0; i < 3; i++) {
                    if (index == i) {
                          //说明是当前页 表示选中
                        lls[i].setBackgroundColor(getResources().getColor(R.color.darkgreen));
                    } else {
                        //说明是其他页面 表示没选中
                        lls[i].setBackgroundColor(getResources().getColor(R.color.darkgray));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
