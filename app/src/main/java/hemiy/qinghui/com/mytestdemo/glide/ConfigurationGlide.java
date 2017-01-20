package hemiy.qinghui.com.mytestdemo.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

import java.io.File;

/**
 *
 * 这个配置要再配置文件里,否则不起作用
 *
 * Created by hemiy on 16/9/12 15:32.
 */
public class ConfigurationGlide implements GlideModule {
    @Override
    public void applyOptions(final Context context, GlideBuilder builder) {


        //配置
         MemorySizeCalculator memorySizeCalculator = new MemorySizeCalculator(context);
//        int defaultMemoryCacheSize = memorySizeCalculator.getMemoryCacheSize();
        int defalutBitmapPoolSize = memorySizeCalculator.getBitmapPoolSize();
        //设置内存缓存
        builder.setMemoryCache(new LruResourceCache(10*1024*1024));
        builder.setBitmapPool(new LruBitmapPool((int) (defalutBitmapPoolSize * 1.2)));

       //设置外存缓存的位置和缓存大小
        builder.setDiskCache(new DiskCache.Factory() {
            @Override
            public DiskCache build() {
                File cacheLocation = new File(context.getExternalCacheDir(), "glide_dir");
                cacheLocation.mkdirs();
                return DiskLruCacheWrapper.get(cacheLocation, 1024 * 1024 * 20);
            }
        });

    }

    @Override
    public void registerComponents(Context context, Glide glide) {
    }
}