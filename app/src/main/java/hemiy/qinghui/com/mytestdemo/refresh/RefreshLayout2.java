package hemiy.qinghui.com.mytestdemo.refresh;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.ArrayList;
import java.util.List;

import hemiy.qinghui.com.mytestdemo.R;

;


/**
 * 自己写的demo
 * Created by hemiy on 16/6/5.
 */
public class RefreshLayout2 extends Activity {
//    参考网址
//https://github.com/android-cjj/Android-MaterialRefreshLayout/blob/master/README-cn.md
    private MaterialRefreshLayout mRefreshLayout;
    private ListView listView;

    /**
     * 刚初始化的数据
     */
    private List<String> datas = new ArrayList<>();

    /**
     * 一个承接数据的数组
     */

    private ArrayAdapter adapter;

    /**
     * 在上拉刷新的时候，判断，是否处于上拉刷新，如果是的话，就禁止在一次刷新，保障在数据加载完成之前
     * 避免重复和多次加载
     */
    private boolean isLoadMore = true;

    private int currentPositon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refreshlayout2);
        initDatas();
        initView();
    }

    /**
     * 初始化布局控件
     */
    private void initView() {

        mRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.refresh);
        listView = (ListView) findViewById(R.id.recycleview);
        initRefresh();

    }

    /**
     * 初始化加载
     */
    private void initRefresh() {
        adapter = new ArrayAdapter(RefreshLayout2.this, R.layout.item_for_list, datas);
        listView.setAdapter(adapter);

        /**
         * 设置是否上拉加载更多，默认是false，要手动改为true，要不然不会出现上拉加载
         */
        mRefreshLayout.setLoadMore(isLoadMore);


        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            /**
             * 刷新的方法，我这里演示的是下拉刷新，因为没有数据，我这里也就只是toast一下
             * 如果想要实现你们自己要的结果，就会在定义一个方法，获取最新数据，或者是在次
             * 在这里调用之前获取数据的方法，以达到刷新数据的功能
             * @param materialRefreshLayout
             */
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                //一般加载数据都是在子线程中，这里我用到了handler
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(RefreshLayout2.this, "已经没有更多数据了", Toast.LENGTH_SHORT).show();
                        /**
                         * 刷新完成后调用此方法，要不然刷新效果不消失
                         */
                        mRefreshLayout.finishRefresh();
                    }
                }, 1000);
            }

            /**
             * 上拉加载更多的方法，在这里我只是简单的模拟了加载四条数据
             * 真正用的时候，就会去定义方法，获取数据，一般都是分页，在数据端获取的时候
             * 把页数去增加一，然后在去服务端去获取数据
             * @param materialRefreshLayout
             */
            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                currentPositon=datas.size();
//                Log.i("hemiy   ",currentPositon+"");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isLoadMore = false;

                        for (int i = 0; i <= 10; i++) {
                            datas.add( "new City " + i);
                        }
                          adapter.notifyDataSetChanged();
                          listView.smoothScrollToPosition(currentPositon); //让listview移动到下一行
//                        Log.i("hemiy   ",currentPositon+1+"");
                        /**
                         * 完成加载数据后，调用此方法，要不然刷新的效果不会消失
                         */
                        mRefreshLayout.finishRefreshLoadMore();
                    }
                }, 1000);
            }
        });
    }

    /**
     * 初始化数据
     */
    private void initDatas() {

        datas.add("广州1");
        datas.add("深圳2");
        datas.add("韶关3");
        datas.add("红山4");
        datas.add("北京5");

        datas.add("广州6");
        datas.add("深圳7");
        datas.add("韶关8");
        datas.add("红山9");
        datas.add("北京10");

        datas.add("广州11");
        datas.add("深圳12");
        datas.add("韶关13");
        datas.add("红山14");
        datas.add("北京15");



    }



}
