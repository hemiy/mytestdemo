package hemiy.qinghui.com.mytestdemo.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * 未接电话
 * <p>
 * 注意 fragment导包是v4的包
 * Created by hemiy on 16/11/17 14:05.
 */

public class UnCallFragment extends Fragment {


    @BindView(R.id.btnUncall)
    Button btnUncall;
    private Activity activity;
    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_uncall, null);
        ButterKnife.bind(this, view);

        Log.i("tag","未接电话执行了");

        return view;
    }


}
