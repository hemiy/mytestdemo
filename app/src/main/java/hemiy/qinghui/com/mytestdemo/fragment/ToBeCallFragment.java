package hemiy.qinghui.com.mytestdemo.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hemiy.qinghui.com.mytestdemo.R;

/**
 *fragment和activity之间的通信
 *
 * http://blog.csdn.net/u013003052/article/details/50445354
 * http://www.cnblogs.com/mengdd/archive/2013/01/11/2856374.html
 *
 * 待接电话
 * Created by hemiy on 16/11/17 14:05.
 */

public class ToBeCallFragment extends Fragment {

    @BindView(R.id.btnTobecall)
    Button btnTobecall;
    private Activity activity;
    private View view;
    private SendMessageListener listener;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity=activity;
        listener = (SendMessageListener) activity; //注意这里activity 必须要实现这个接口才行(其实就相当于绑定了一个监听器)
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tobecall, null);
        ButterKnife.bind(this, view);//这个方法只会执行一次
        Log.i("tag","待电话执行了");
        return view;
    }


    @OnClick(R.id.btnTobecall)
    public void onClick() {

        if(listener!=null){
            Toast.makeText(getActivity(), "待接警点击了", Toast.LENGTH_SHORT).show();
            listener.sendMessage();//在activity里回调这个接口方法
        }
    }
}
