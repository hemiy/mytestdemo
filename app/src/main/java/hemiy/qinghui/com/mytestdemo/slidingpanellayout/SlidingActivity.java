package hemiy.qinghui.com.mytestdemo.slidingpanellayout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * Created by hemiy on 16/10/24 14:56.
 */

public class SlidingActivity extends Activity {
    @BindView(R.id.id_lv_left_menu)
    ListView idLvLeftMenu;
    @BindView(R.id.btnShowPanel)
    Button btnShowPanel;
//    @BindView(R.id.ll_report)
//    SlidingPaneLayout llReport;
    @BindView(R.id.drawer)
    PagerEnabledSlidingPaneLayout drawer;


    private List<String> datas = new ArrayList<>();

    /**
     * 一个承接数据的数组
     */

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_panel);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        datas.add("广州1");
        datas.add("深圳2");
        datas.add("韶关3");
        datas.add("红山4");
        datas.add("北京5");
        adapter = new ArrayAdapter(SlidingActivity.this, R.layout.item_for_list, datas);
        idLvLeftMenu.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        drawer.setSliderFadeColor(Color.TRANSPARENT);//不过主面板会变灰，幸运的是我们可以通过setSliderFadeColor将渐变色设置为透明。

        drawer.setProhibitSideslip(true); //取消侧滑

        drawer.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
//                  idLvLeftMenu.setScaleY(slideOffset / 2 + 0.5F);
//                  idLvLeftMenu.setScaleX(slideOffset / 2 + 0.5F);
//                  idLvLeftMenu.setAlpha(slideOffset);
                idLvLeftMenu.setTranslationX(slideOffset / 2 + 0.1f);
                idLvLeftMenu.setTranslationY(slideOffset / 2 + 0.1f);


            }

            @Override
            public void onPanelOpened(View panel) {
                drawer.setProhibitSideslip(false); //打开侧滑
            }

            @Override
            public void onPanelClosed(View panel) {
//                drawer.setProhibitSideslip(true); //取消侧滑
            }
        });



        btnShowPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(!drawer.isOpen()){
                  drawer.openPane();
              }
            }
        });
    }

}
