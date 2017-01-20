package hemiy.qinghui.com.mytestdemo.glide;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * 一个图片加载库
 * https://github.com/bumptech/glide
 * http://www.cnblogs.com/yuzhongzheng/p/5228354.html 参考文章
 * http://www.jianshu.com/p/966f94604038 简书的一篇文章
 * https://github.com/wasabeef/glide-transformations glide的一些图片外观效果
 *
 *
 * http://www.jianshu.com/p/e78407a18716 关于Glide 看这一篇就够了
 *
 * Created by hemiy on 16/6/8.
 */
public class GlideAcvitity extends Activity {

    //下面的都是网络图片的路径
   private String marioUrl="http://a2.att.hudong.com/77/29/01300000291092128871291549831.jpg";
   private String imgUrl="https://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg";
   private String gifUrl="http://att.bbs.duowan.com/forum/201308/24/154853rurdx3gufgubfgrg.gif";
   private String otherUrl="http://a2.att.hudong.com/79/22/01000000000000119062273272179.jpg";

    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.btn_getPic)
    Button btnGetPic;
    @BindView(R.id.iv_img2)
    ImageView ivImg2;
    @BindView(R.id.btn_getPic2)
    Button btnGetPic2;
    @BindView(R.id.btn_clear)
    Button btnClear;

    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);
        context=this;

       btnGetPic.setOnClickListener(new View.OnClickListener() {
           //使用centerCrop是利用图片图填充ImageView设置的大小
//           图片的缩放，centerCrop()和fitCenter()
           @Override
           public void onClick(View view) {
               Glide.with(GlideAcvitity.this)
//                       .load(otherUrl)
//                       .load(gifUrl)
                       .load(R.mipmap.ic_camera)
                       .centerCrop()
                       .crossFade() //一个渐入渐出的动画效果，默认是300ms
                       .bitmapTransform(new CropCircleTransformation(context))
                       .into(ivImg);
           }
       });


        btnGetPic2.setOnClickListener(new View.OnClickListener() {
            //使用centerCrop是利用图片图填充ImageView设置的大小
//           图片的缩放，centerCrop()和fitCenter()
            @Override
            public void onClick(View view) {
                Glide.with(GlideAcvitity.this)
                        .load(marioUrl)
                        .centerCrop()
                        .bitmapTransform( new RoundedCornersTransformation(context,20,0))
                        .placeholder(R.drawable.about)
                        .into(ivImg2);
            }
        });




        //清除缓存要在新的线程里开始,否则会报错
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(context).clearDiskCache();
                    }
                }).start();
                Toast.makeText(GlideAcvitity.this, "sucessful clear", Toast.LENGTH_SHORT).show();
            }
        });


    }
//清理缓存
//    Glide.get(this).clearDiskCache();
//    Glide.get(this).clearMemory();
}

//一些常用方法
//   Glide.with(context)
//        .load(url)                                          //加载资源
//        .thumbnail(0.1f)                                    //用原图的1/10作为缩略图,如果缩略图比全尺寸图先加载完，就显示缩略图，否则就不显示
//        //.thumbnail(getDrawableRequestBuilder(context,rid))    //本地资源作为缩略图
//        .centerCrop()                                       //设置scaleType
//        .placeholder(null)                                  //设置资源加载过程中的占位Drawable。
//        .crossFade()                                        //设置加载渐变动画
//        .priority(Priority.NORMAL)                          //指定加载的优先级，优先级越高越优先加载，但不保证所有图片都按序加载。枚举Priority.IMMEDIATE，Priority.HIGH，Priority.NORMAL，Priority.LOW。默认为Priority.NORMAL。
//        .fallback(null)                                     //设置model为空时要显示的Drawable。如果没设置fallback，model为空时将显示error的Drawable，如果error的Drawable也没设置，就显示placeholder的Drawable。
//        .error(null)                                        //设置load失败时显示的Drawable。
//        .listener(listener)                                 //请求监听
//        .skipMemoryCache(true)                              //设置跳过内存缓存，但不保证一定不被缓存（比如请求已经在加载资源且没设置跳过内存缓存，这个资源就会被缓存在内存中）。
//        .diskCacheStrategy(DiskCacheStrategy.RESULT)        //缓存策略DiskCacheStrategy.SOURCE：缓存原始数据，DiskCacheStrategy.RESULT：缓存变换(如缩放、裁剪等)后的资源数据，DiskCacheStrategy.NONE：什么都不缓存，DiskCacheStrategy.ALL：缓存SOURC和RESULT。默认采用DiskCacheStrategy.RESULT策略，对于download only操作要使用DiskCacheStrategy.SOURCE。
//        .bitmapTransform(new CropCircleTransformation(context))  //圆角裁切
//        .into(imageView);

