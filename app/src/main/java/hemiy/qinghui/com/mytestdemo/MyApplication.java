package hemiy.qinghui.com.mytestdemo;

import android.app.Application;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;
import com.orhanobut.logger.Logger;

import org.xutils.x;

import io.realm.Realm;

/**
 * Logger 强大的日志工具 http://blog.csdn.net/like_program/article/details/52986553
 * Created by hemiy on 16/6/25.
 */
public class MyApplication extends Application{
    private  static LiteOrm liteOrm=null;
    private static String TAG = "tag";

















    @Override
    public void onCreate() {

        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
        createDataBase();//创建数据库
//        Logger.init(TAG).logLevel(LogLevel.NONE);
        Logger.init(TAG);

        //设置新的数据库
        Realm.init(this);
    }

    /*
         * 获取数据库操作工具
         */
    public static LiteOrm getDbUtils() {
        return liteOrm;
    }

    //自带数据库的创建方法
    private void createDataBase() {
        if (liteOrm == null) {
            DataBaseConfig config = new DataBaseConfig(this, "liteorm.db");
            config.debugged = true; // 开启日志
            config.dbVersion = 1; // 设置数据库版本号
            config.onUpdateListener = null; // 设置
            liteOrm = LiteOrm.newSingleInstance(config);//创建一个单例模式的数据库
        }
    }
}
