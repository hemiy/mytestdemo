package hemiy.qinghui.com.mytestdemo.recycleview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hemiy.qinghui.com.mytestdemo.R;

/**
 * http://blog.csdn.net/lmj623565791/article/details/38173061
 * http://www.jianshu.com/p/626a082bf569
 * Created by hemiy on 16/9/2 18:50.
 *
 *
 *
 *
 *
 *          RecyclerView.Adapter - 处理数据集合并负责绑定视图

            ViewHolder - 持有所有的用于绑定数据或者需要操作的View

            LayoutManager - 负责摆放视图等相关操作

            ItemDecoration - 负责绘制Item附近的分割线

            ItemAnimator - 为Item的一般操作添加动画效果，如，增删条目等

 *
 */
public class RecycleViewActivity extends Activity {

    private RecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<Integer> mDatas;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        context=this;
        initDatas();
        //得到控件
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_horizontal);
        //设置布局管理器 为水平布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //设置分割线
        Divider divider = new Divider(new ColorDrawable(getResources().getColor(R.color.blue)), OrientationHelper.VERTICAL);
        //单位:px
        divider.setMargin(50, 0, 0, 0);
        divider.setHeight(1);
        mRecyclerView.addItemDecoration(divider);


//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,4,GridLayoutManager.VERTICAL,false));



        //设置适配器
        mAdapter = new GalleryAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);


        //因为recycleView没有实现监听方法，所以自己在adapter里面实现监听
        mAdapter.setOnItemClickLitener(new GalleryAdapter.OnItemClickLitener()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                Toast.makeText(RecycleViewActivity.this, position+"", Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }

    private void initDatas()
    {
        mDatas = new ArrayList<Integer>(Arrays.asList(R.drawable.bg_splash_1,
                R.drawable.bg_splash_2,R.drawable.bg_splash_3,R.drawable.bg_splash_4,R.drawable.bg_splash_4,
                R.drawable.bg_splash_4,R.drawable.bg_splash_4,R.drawable.bg_splash_4
               ));
    }

}
