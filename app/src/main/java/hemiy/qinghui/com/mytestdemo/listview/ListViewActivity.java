package hemiy.qinghui.com.mytestdemo.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * http://www.jianshu.com/p/b539628ab4b8
 * 下拉会隐藏标题栏的listview
 * Created by hemiy on 16/6/8.
 */
public class ListViewActivity extends Activity implements AbsListView.OnScrollListener {

    @BindView(R.id.lvTitleFade)
    ListView lvTitleFade;
    @BindView(R.id.rlTitle)
    RelativeLayout rlTitle;
    //其实SparseArray<E>是用来代替HashMap<Integer, E>，不了解的可以查查
    private SparseArray recordSp = new SparseArray(0);
    private int mCurrentfirstVisibleItem = 0;
    private List<String> datas = new ArrayList<>();

    /**
     * 一个承接数据的数组
     */

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ButterKnife.bind(this);

        //设置标题背景透明 0为透明，255为不透明
        rlTitle.getBackground().setAlpha(0);

      //滑动监听，注意implements OnScrollListener
        lvTitleFade.setOnScrollListener(this);
        View view=View.inflate(ListViewActivity.this ,R.layout.item_for_list,null);
        lvTitleFade.addHeaderView(view);

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
        adapter = new ArrayAdapter(ListViewActivity.this, R.layout.item_for_list, datas);
        lvTitleFade.setAdapter(adapter);


    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        //firstVisibleItem--处于顶部的Item标记
        //visibleItemCount--当前可见item数
        //totalItemCount----总item数
        mCurrentfirstVisibleItem = firstVisibleItem;
//        Log.i("hemiy","当前丁目item数是"+mCurrentfirstVisibleItem);
//        Log.i("hemiy","可见的item数量是"+visibleItemCount);
        View firstView = view.getChildAt(0);
        if (null != firstView) {
            ItemRecod itemRecord = (ItemRecod) recordSp.get(firstVisibleItem);
            if (null == itemRecord) {
                itemRecord = new ItemRecod();
            }
            itemRecord.height = firstView.getHeight();//获取最顶部Item的高度
            itemRecord.top = firstView.getTop();//获取距离顶部的距离
            recordSp.append(firstVisibleItem, itemRecord);//设置值
        }
//      Log.d("hemiy", "滑动距离：" + getScrollY());
        int ScrollY = getScrollY();
        if (ScrollY >= 0 && ScrollY <= 255) {
            //设置标题栏透明度0~255
            rlTitle.getBackground().setAlpha(ScrollY);
        } else if (ScrollY > 255) {
            //滑动距离大于255就设置为不透明
            rlTitle.getBackground().setAlpha(255);
        }
    }



     //拿到滑动距离
    private int getScrollY() {
        int height = 0;
        for (int i = 0; i < mCurrentfirstVisibleItem; i++) {
            ItemRecod itemRecod = (ItemRecod) recordSp.get(i);
            Log.d("hemiy", "xxx1：" + itemRecod);
            //06-07 21:00:21.601: D/dmdrs(23096): xxx1：com.dmdrs.titlefade.MainActivity$ItemRecod@529122fc
            //06-07 21:00:21.601: D/dmdrs(23096): xxx2：300
            //06-07 21:00:21.601: D/dmdrs(23096): xxx1：null
            //快速滑动会为空，判断一下，发现的bug
            if(itemRecod != null){
                height += itemRecod.height;
            }
            Log.d("dmdrs", "xxx2：" + height);
        }
        ItemRecod itemRecod = (ItemRecod) recordSp.get(mCurrentfirstVisibleItem);
        if (null == itemRecod) {
            itemRecod = new ItemRecod();
        }
        return height - itemRecod.top;
    }

    class ItemRecod {
        int height = 0;
        int top = 0;
    }
}
