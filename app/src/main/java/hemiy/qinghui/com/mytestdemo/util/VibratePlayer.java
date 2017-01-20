package hemiy.qinghui.com.mytestdemo.util;

import android.app.Service;
import android.content.Context;
import android.os.Vibrator;


/**
 * http://blog.csdn.net/h7870181/article/details/8166987
 * 震动的工具类
 */
public class VibratePlayer {


    private Context context;
    private  Vibrator vib;

    private static VibratePlayer instance = null;

    public static VibratePlayer instance(Context context) {
        if(instance == null) {
            synchronized (VibratePlayer.class) {
                if(instance == null) {
                    instance = new VibratePlayer(context);
                }
            }
        }
        return instance;
    }



    private VibratePlayer(Context context) {
        this.context = context;
        vib = (Vibrator) context.getSystemService(Service.VIBRATOR_SERVICE);   
    }


    public void stop() {
      if(vib!=null){
    	  vib.cancel();
      }
    }

    public void play() {
//    	http://blog.csdn.net/h7870181/article/details/8166987
    	
    	boolean isRepeat=true;
    	if(vib!=null){
    		long [] pattern = {1000,1200,1500,1200};
//            数组参数意义：第一个参数为等待指定时间后开始震动，震动时间为第二个参数。后边的参数依次为等待震动和震动的时间
    		vib.vibrate(pattern, isRepeat ? 0 : -1);//-1为不重复，0为一直震动
        }
    }

   
}
