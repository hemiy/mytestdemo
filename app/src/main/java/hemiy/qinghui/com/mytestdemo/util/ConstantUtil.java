package hemiy.qinghui.com.mytestdemo.util;

import android.os.Environment;

import java.io.File;

/**
 * 常量类
 */
public interface ConstantUtil {
    String APPNAME = "framebycombination";//应用名称
    public static final boolean DEBUG = true;//调试模式
    public static final String BASE_PATH = Environment.getExternalStorageDirectory().getPath() + File.separator
            + APPNAME + File.separator;// 手机本地的文件存放位置
    public static final String PICTURE_PATH = BASE_PATH + "picture" + File.separator;// 存放图片
}
