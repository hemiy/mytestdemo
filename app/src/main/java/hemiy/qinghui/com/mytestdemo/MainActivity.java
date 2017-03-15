package hemiy.qinghui.com.mytestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.anctionforandroid.AsForAndroidActivity;
import hemiy.qinghui.com.mytestdemo.animation.AnimationActivity;
import hemiy.qinghui.com.mytestdemo.arc.ArcActivity;
import hemiy.qinghui.com.mytestdemo.bottombar.BottomBarActivity;
import hemiy.qinghui.com.mytestdemo.circleindicator.CircleIndicatorActivity;
import hemiy.qinghui.com.mytestdemo.commonutil.CommonUtilActivity;
import hemiy.qinghui.com.mytestdemo.countdowntimer.CountDonwActivity;
import hemiy.qinghui.com.mytestdemo.countdownview.CounterDownActivity;
import hemiy.qinghui.com.mytestdemo.eventbus.FirstActivity;
import hemiy.qinghui.com.mytestdemo.flatbutton.FlatButtonActivity;
import hemiy.qinghui.com.mytestdemo.floatbutton.FloatButtonAcvitity;
import hemiy.qinghui.com.mytestdemo.fragment.FragmentDemoActivity;
import hemiy.qinghui.com.mytestdemo.glide.GlideAcvitity;
import hemiy.qinghui.com.mytestdemo.immersive.ImmersiveActivity;
import hemiy.qinghui.com.mytestdemo.lableview.LabelViewActivity;
import hemiy.qinghui.com.mytestdemo.listview.ListViewActivity;
import hemiy.qinghui.com.mytestdemo.listviewtype.ListViewTypeActivity;
import hemiy.qinghui.com.mytestdemo.liteorm.PersonActivity;
import hemiy.qinghui.com.mytestdemo.loadingview.LoadIngView;
import hemiy.qinghui.com.mytestdemo.materialdialog.MateraiDialogActivity;
import hemiy.qinghui.com.mytestdemo.navigationview.NaviActivity;
import hemiy.qinghui.com.mytestdemo.numberanimtextview.NumberAnimTextViewAcitivity;
import hemiy.qinghui.com.mytestdemo.okhttp.OkHttpActivity;
import hemiy.qinghui.com.mytestdemo.photopicker.PhotoPicker2;
import hemiy.qinghui.com.mytestdemo.progressbtn.ProgressButtonActivity;
import hemiy.qinghui.com.mytestdemo.realm.RealmActivity;
import hemiy.qinghui.com.mytestdemo.recycleview.RecycleViewActivity;
import hemiy.qinghui.com.mytestdemo.refresh.RefreshLayout2;
import hemiy.qinghui.com.mytestdemo.refreshdiy.RefreshDiy;
import hemiy.qinghui.com.mytestdemo.retorfit.RetrofitActivity;
import hemiy.qinghui.com.mytestdemo.retrofitpractice.RetrofitPraticeActivity;
import hemiy.qinghui.com.mytestdemo.rxbus.RxbusActivity;
import hemiy.qinghui.com.mytestdemo.rxbus.RxbusActivity2;
import hemiy.qinghui.com.mytestdemo.rxjava.RxjavaActivity;
import hemiy.qinghui.com.mytestdemo.scratchview.ScratchViewActivity;
import hemiy.qinghui.com.mytestdemo.slidingpanellayout.SlidingActivity;
import hemiy.qinghui.com.mytestdemo.snackbar.SnackBarActivity;
import hemiy.qinghui.com.mytestdemo.snowfall.SnowFallActivity;
import hemiy.qinghui.com.mytestdemo.spanstringbuilder.SpanStringBuilderActivity;
import hemiy.qinghui.com.mytestdemo.sweetdialog.SweetDialog;
import hemiy.qinghui.com.mytestdemo.tablayout.TabLayoutActivity;
import hemiy.qinghui.com.mytestdemo.textinputlayout.TextInputActivity;
import hemiy.qinghui.com.mytestdemo.times.TimeActivity;
import hemiy.qinghui.com.mytestdemo.togglebutton.ToggleButtonActivity;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_listview)
    Button btnListview;
    @BindView(R.id.btn_tablayou)
    Button btnTablayou;
    @BindView(R.id.btn_floatBtn)
    Button btnFloatBtn;
    @BindView(R.id.btn_textinput)
    Button btnTextinput;
    @BindView(R.id.btn_progBtn)
    Button btnProgBtn;
    @BindView(R.id.btn_timePicker)
    Button btnTimePicker;
    @BindView(R.id.btn_imgPicker)
    Button btnImgPicker;
    @BindView(R.id.btn_glide)
    Button btnGlide;
    @BindView(R.id.btn_countDown)
    Button btnCountDown;
    @BindView(R.id.btn_arc)
    Button btnArc;
    @BindView(R.id.btn_navigation)
    Button btnNavigation;

    @BindView(R.id.btnOkHttp)
    Button btnOkHttp;

    @BindView(R.id.btnToggleButton)
    Button btnToggleButton;

    @BindView(R.id.btnLabelView)
    Button btnLabelView;

    @BindView(R.id.btnCircleIndictor)
    Button btnCircleIndictor;

    @BindView(R.id.btnFlatButton)
    Button btnFlatButton;

    @BindView(R.id.btnRecycleView)
    Button btnRecycleView;

    @BindView(R.id.btnMateriaDialog)
    Button btnMateriaDialog;

    @BindView(R.id.btnRxjava)
    Button btnRxjava;

    //沉浸式状态栏
    @BindView(R.id.btnImmer)
    Button btnImmer;
    @BindView(R.id.btnDiy)
    Button btnDiy;
    @BindView(R.id.btnRxbus)
    Button btnRxbus;
    @BindView(R.id.btnRxbus2)
    Button btnRxbus2;
    @BindView(R.id.btnFlash)
    Button btnFlash;
    @BindView(R.id.btnRetrofit)
    Button btnRetrofit;
    @BindView(R.id.btnAnimation)
    Button btnAnimation;
    @BindView(R.id.btnListviewType)
    Button btnListviewType;
    @BindView(R.id.btnSnackBar)
    Button btnSnackBar;
    @BindView(R.id.btnCircleCountdown)
    Button btnCircleCountdown;
    @BindView(R.id.btnSlidingPanel)
    Button btnSlidingPanel;
    @BindView(R.id.btnBottomBar)
    Button btnBottomBar;
    @BindView(R.id.btnLiteOrm)
    Button btnLiteOrm;
    @BindView(R.id.btnSpanString)
    Button btnSpanString;
    @BindView(R.id.btnFragment)
    Button btnFragment;
    @BindView(R.id.btnRetrfitNew)
    Button btnRetrfitNew;
    @BindView(R.id.btnRealm)
    Button btnRealm;
    @BindView(R.id.btnSnow)
    Button btnSnow;
    @BindView(R.id.btnNumberAnimTextview)
    Button btnNumberAnimTextview;
    @BindView(R.id.btnScratchview)
    Button btnScratchview;

    private Button btnBus;
    private Button btnRefresh;
    private Button btnLoad;
    private Button btnSweet;
    private Button btn_actionsheet1;



    //json comment
    private String JSON_CONTENT = "{\"weatherinfo\":{\"city\":\"北京\",\"cityid\":\"101010100\"," +
            "\"temp\":\"18\",\"WD\":\"东南风\",\"WS\":\"1级\",\"SD\":\"17%\",\"WSE\":\"1\"," +
            "\"time\":\"17:05\",\"isRadar\":\"1\",\"Radar\":\"JC_RADAR_AZ9010_JB\"," +
            "\"njd\":\"暂无实况\",\"qy\":\"1011\",\"rain\":\"0\"}}";




//new comment 20170307
    private String XML_CONTENT = "<china dn=\"nay\"><city quName=\"黑龙江\" pyName=\"heilongjiang\" " +
            "cityname=\"哈尔滨\" state1=\"1\" state2=\"1\" stateDetailed=\"多云\"/><city quName=\"吉林\"" +
            " pyName=\"jilin\" " +
            "cityname=\"长春\" state1=\"0\" state2=\"0\" stateDetailed=\"晴\"/><city quName=\"辽宁\" " +
            "pyName=\"liaoning\" " +
            "cityname=\"沈阳\" state1=\"1\" state2=\"0\" stateDetailed=\"多云转晴\"/><city " +
            "quName=\"海南\" pyName=\"hainan\" " +
            "cityname=\"海口\" state1=\"22\" state2=\"21\" stateDetailed=\"中到大雨转小到中雨\"/></china>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        ButterKnife.bind(this); //依赖注入的框架
        Logger.d("log日志执行了");
        Logger.json(JSON_CONTENT);
        Logger.xml(XML_CONTENT);
        btnBus = (Button) findViewById(R.id.btn_bus);
        btnRefresh = (Button) findViewById(R.id.btn_fresh);
        btnLoad = (Button) findViewById(R.id.btn_load);
        btnSweet = (Button) findViewById(R.id.btn_sweet);
        btn_actionsheet1 = (Button) findViewById(R.id.btn_actionsheet1);
        MyBtnClick myBtnClick = new MyBtnClick();

        btnBus.setOnClickListener(myBtnClick);
        btnRefresh.setOnClickListener(myBtnClick);
        btnLoad.setOnClickListener(myBtnClick);
        btnSweet.setOnClickListener(myBtnClick);
        btnListview.setOnClickListener(myBtnClick);
        btnTablayou.setOnClickListener(myBtnClick);
        btnFloatBtn.setOnClickListener(myBtnClick);
        btnTextinput.setOnClickListener(myBtnClick);
        btnProgBtn.setOnClickListener(myBtnClick);
        btnTimePicker.setOnClickListener(myBtnClick);
        btnImgPicker.setOnClickListener(myBtnClick);
        btnGlide.setOnClickListener(myBtnClick);
        btnCountDown.setOnClickListener(myBtnClick);
        btnArc.setOnClickListener(myBtnClick);
        btnNavigation.setOnClickListener(myBtnClick);
        btn_actionsheet1.setOnClickListener(myBtnClick);
        btnOkHttp.setOnClickListener(myBtnClick);
        btnToggleButton.setOnClickListener(myBtnClick);
        btnLabelView.setOnClickListener(myBtnClick);
        btnCircleIndictor.setOnClickListener(myBtnClick);
        btnFlatButton.setOnClickListener(myBtnClick);
        btnRecycleView.setOnClickListener(myBtnClick);
        btnMateriaDialog.setOnClickListener(myBtnClick);
        btnRxjava.setOnClickListener(myBtnClick);
        btnImmer.setOnClickListener(myBtnClick);
        btnDiy.setOnClickListener(myBtnClick);
        btnRxbus.setOnClickListener(myBtnClick);
        btnRxbus2.setOnClickListener(myBtnClick);
        btnFlash.setOnClickListener(myBtnClick);
        btnRetrofit.setOnClickListener(myBtnClick);
        btnAnimation.setOnClickListener(myBtnClick);
        btnListviewType.setOnClickListener(myBtnClick);
        btnSnackBar.setOnClickListener(myBtnClick);
        btnCircleCountdown.setOnClickListener(myBtnClick);
        btnSlidingPanel.setOnClickListener(myBtnClick);
        btnBottomBar.setOnClickListener(myBtnClick);
        btnLiteOrm.setOnClickListener(myBtnClick);
        btnSpanString.setOnClickListener(myBtnClick);
        btnFragment.setOnClickListener(myBtnClick);
        btnRetrfitNew.setOnClickListener(myBtnClick); //retrofit实战
        btnRealm.setOnClickListener(myBtnClick);
        btnSnow.setOnClickListener(myBtnClick); //下雪视图
        btnNumberAnimTextview.setOnClickListener(myBtnClick); //下雪视图
        btnScratchview.setOnClickListener(myBtnClick); //刮刮卡视图
    }


    private class MyBtnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.btn_bus) {
                startActivity(new Intent(MainActivity.this, FirstActivity.class));
            } else if (id == R.id.btn_fresh) {
                startActivity(new Intent(MainActivity.this, RefreshLayout2.class));
            } else if (id == R.id.btn_load) {
                startActivity(new Intent(MainActivity.this, LoadIngView.class));
            } else if (id == R.id.btn_sweet) {
                startActivity(new Intent(MainActivity.this, SweetDialog.class));
            } else if (id == R.id.btn_listview) {
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
            } else if (id == R.id.btn_tablayou) {
                startActivity(new Intent(MainActivity.this, TabLayoutActivity.class));
            } else if (id == R.id.btn_floatBtn) {
                startActivity(new Intent(MainActivity.this, FloatButtonAcvitity.class));
            } else if (id == R.id.btn_textinput) {
                startActivity(new Intent(MainActivity.this, TextInputActivity.class));
            } else if (id == R.id.btn_progBtn) {
                startActivity(new Intent(MainActivity.this, ProgressButtonActivity.class));
            } else if (id == R.id.btn_timePicker) {
                startActivity(new Intent(MainActivity.this, TimeActivity.class));
            } else if (id == R.id.btn_imgPicker) {
//                startActivity(new Intent(MainActivity.this, PhotoPicker.class));
                startActivity(new Intent(MainActivity.this, PhotoPicker2.class));
            } else if (id == R.id.btn_glide) {
                startActivity(new Intent(MainActivity.this, GlideAcvitity.class));
            } else if (id == R.id.btn_countDown) {
                startActivity(new Intent(MainActivity.this, CountDonwActivity.class));
            } else if (id == R.id.btn_arc) {
                startActivity(new Intent(MainActivity.this, ArcActivity.class));
            } else if (id == R.id.btn_navigation) {
                startActivity(new Intent(MainActivity.this, NaviActivity.class));
            } else if (id == R.id.btn_actionsheet1) {
                startActivity(new Intent(MainActivity.this, AsForAndroidActivity.class));
            } else if (id == R.id.btnOkHttp) {
                startActivity(new Intent(MainActivity.this, OkHttpActivity.class));
            } else if (id == R.id.btnToggleButton) {
                startActivity(new Intent(MainActivity.this, ToggleButtonActivity.class));
            } else if (id == R.id.btnLabelView) {
                startActivity(new Intent(MainActivity.this, LabelViewActivity.class));
            } else if (id == R.id.btnCircleIndictor) {
                startActivity(new Intent(MainActivity.this, CircleIndicatorActivity.class));
            } else if (id == R.id.btnFlatButton) {
                startActivity(new Intent(MainActivity.this, FlatButtonActivity.class));
            } else if (id == R.id.btnRecycleView) {
                startActivity(new Intent(MainActivity.this, RecycleViewActivity.class));
            } else if (id == R.id.btnMateriaDialog) {
                startActivity(new Intent(MainActivity.this, MateraiDialogActivity.class));
            } else if (id == R.id.btnRxjava) {
                startActivity(new Intent(MainActivity.this, RxjavaActivity.class));
            } else if (id == R.id.btnImmer) {
                startActivity(new Intent(MainActivity.this, ImmersiveActivity.class));
            } else if (id == R.id.btnDiy) {
                startActivity(new Intent(MainActivity.this, RefreshDiy.class));
            } else if (id == R.id.btnRxbus) {
                startActivity(new Intent(MainActivity.this, RxbusActivity.class));
            } else if (id == R.id.btnRxbus2) {
                startActivity(new Intent(MainActivity.this, RxbusActivity2.class));
            } else if (id == R.id.btnFlash) {
                startActivity(new Intent(MainActivity.this, CommonUtilActivity.class));
            } else if (id == R.id.btnRetrofit) {
                startActivity(new Intent(MainActivity.this, RetrofitActivity.class));
            } else if (id == R.id.btnAnimation) {
                startActivity(new Intent(MainActivity.this, AnimationActivity.class));
            } else if (id == R.id.btnListviewType) {
                startActivity(new Intent(MainActivity.this, ListViewTypeActivity.class));
            } else if (id == R.id.btnSnackBar) {
                startActivity(new Intent(MainActivity.this, SnackBarActivity.class));
            } else if (id == R.id.btnCircleCountdown) {
                startActivity(new Intent(MainActivity.this, CounterDownActivity.class));//环形倒计时
            } else if (id == R.id.btnSlidingPanel) {
                startActivity(new Intent(MainActivity.this, SlidingActivity.class));
            } else if (id == R.id.btnBottomBar) {
                startActivity(new Intent(MainActivity.this, BottomBarActivity.class));
            } else if (id == R.id.btnLiteOrm) {
                startActivity(new Intent(MainActivity.this, PersonActivity.class));
            } else if (id == R.id.btnSpanString) {
                startActivity(new Intent(MainActivity.this, SpanStringBuilderActivity.class));//变化的字体颜色
            } else if (id == R.id.btnFragment) {
                startActivity(new Intent(MainActivity.this, FragmentDemoActivity.class));
            } else if (id == R.id.btnRetrfitNew) {
                startActivity(new Intent(MainActivity.this, RetrofitPraticeActivity.class));//联系
            } else if (id == R.id.btnRealm) {
                startActivity(new Intent(MainActivity.this, RealmActivity.class));//数据库
            } else if (id == R.id.btnSnow) {
                startActivity(new Intent(MainActivity.this, SnowFallActivity.class));//下雪视图
            } else if (id == R.id.btnNumberAnimTextview) {
                startActivity(new Intent(MainActivity.this, NumberAnimTextViewAcitivity.class));//数字滚动
            }else if (id == R.id.btnScratchview) {
                startActivity(new Intent(MainActivity.this, ScratchViewActivity.class));//刮刮卡视图
            }
        }
    }
}
