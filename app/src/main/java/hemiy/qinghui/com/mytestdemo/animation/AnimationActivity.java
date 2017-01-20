package hemiy.qinghui.com.mytestdemo.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hemiy.qinghui.com.mytestdemo.R;
import hemiy.qinghui.com.mytestdemo.util.CommonUtil;
import hemiy.qinghui.com.mytestdemo.util.VibratePlayer;

/**
 * http://blog.csdn.net/fengkuanghun/article/details/7878862
 * <p>
 * http://www.jianshu.com/p/9e7635e724e5  这里有详细的动画介绍,可以重点看这个
 * <p>
 * Created by hemiy on 16/10/17 15:18.
 */

public class AnimationActivity extends Activity {

    @BindView(R.id.btnShow)
    Button btnShow;
    @BindView(R.id.btnHide)
    Button btnHide;
    @BindView(R.id.ivImg)
    ImageView ivImg;
    @BindView(R.id.btnIsMobile)
    Button btnIsMobile;

    private TranslateAnimation animation;
    private TranslateAnimation animation2;

    private VibratePlayer vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);

        //弹出效果
        animation = new TranslateAnimation(0, 150, 0, 0);/** 设置位移动画 向右位移150 */
        animation.setDuration(500);//设置动画持续时间
        animation.setFillAfter(true);//设为true之后，界面会停留在动画播放完时的界面。 如果不设置这个效果,则当动画播放完毕时会返回view原始的位置


        //回退效果
        animation2 = new TranslateAnimation(150, 0, 0, 0);/** 设置位移动画 向左位移150 */
        animation2.setDuration(500);//设置动画持续时间
        animation2.setFillAfter(true);

        vp=VibratePlayer.instance(this);
    }

    @OnClick({R.id.btnShow, R.id.btnHide,R.id.btnIsMobile})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnShow:
//                ivImg.startAnimation(animation);
                vp.play();
                break;
            case R.id.btnHide:
//                ivImg.startAnimation(animation2);
                vp.stop();
                break;
            case R.id.btnIsMobile:
               if( CommonUtil.isMobile("12234569877")){
                   Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();
               }
                break;
        }
    }


    public void startAnimationSet() {
        //创建动画，参数表示他的子动画是否共用一个插值器
        AnimationSet animationSet = new AnimationSet(true);
        //添加动画
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        //设置插值器
        animationSet.setInterpolator(new LinearInterpolator());
        //设置动画持续时长
        animationSet.setDuration(3000);
        //设置动画结束之后是否保持动画的目标状态
        animationSet.setFillAfter(true);
        //设置动画结束之后是否保持动画开始时的状态
        animationSet.setFillBefore(false);
        //设置重复模式
        animationSet.setRepeatMode(AnimationSet.REVERSE);
        //设置重复次数
        animationSet.setRepeatCount(AnimationSet.INFINITE);
        //设置动画延时时间
        animationSet.setStartOffset(2000);
        //取消动画
        animationSet.cancel();
        //释放资源
        animationSet.reset();
        //开始动画
//        mIvImg.startAnimation(animationSet); //必须要使用view的这个方法
    }
}
