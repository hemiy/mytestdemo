package hemiy.qinghui.com.mytestdemo.scratchview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cooltechworks.views.ScratchImageView;
import com.cooltechworks.views.ScratchTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hemiy.qinghui.com.mytestdemo.R;
import info.hoang8f.widget.FButton;

/**
 * 刮刮卡效果
 * https://github.com/sharish/ScratchView
 * Created by hemiy on 17/1/24 11:12.
 */

public class ScratchViewActivity extends Activity {


    @BindView(R.id.scImage)
    ScratchImageView scImage;
    @BindView(R.id.scText)
    ScratchTextView scText;

    @BindView(R.id.btnTest)
    FButton btnTest;
    @BindView(R.id.btnChange)
    FButton btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scratch_view);
        ButterKnife.bind(this);
        initViews();//监听器最好都要设置
    }

    private void initViews() {
        scImage.setRevealListener(new ScratchImageView.IRevealListener() {
            @Override
            public void onRevealed(ScratchImageView tv) {
                // on reveal 当全部展示就出触会发下面的方法
//                Log.i("tag","图片完成显示了");
                Toast.makeText(ScratchViewActivity.this, "全部显示了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchImageView siv, float percent) {
                // on image percent reveal
                int result = (int) (percent * 100);
                Log.i("tag", "显示百分比是 " + result);
                if (result >= 80) {
                    siv.reveal();//如果显示面积大于80%,就全部展示
                }
            }
        });

        scText.setRevealListener(new ScratchTextView.IRevealListener() {
            @Override
            public void onRevealed(ScratchTextView scratchTextView) {

            }

            @Override
            public void onRevealPercentChangedListener(ScratchTextView scratchTextView, float v) {

            }
        });

    }

    @OnClick({R.id.btnTest, R.id.btnChange})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnTest:
                //用于展示图片是否已经完全展示
                if(scImage.isRevealed()){
//                //注意 按钮的阴影显示和selector不可以共存,一次只能有一种效果
                Toast.makeText(this, "图片完全显示了", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "图片没有完全显示", Toast.LENGTH_SHORT).show();
            }
                break;
            case R.id.btnChange:
                if(!scText.isRevealed()){
                    scText.reveal();
                    Log.i("tag","1");
                }else{
                    Log.i("tag","2");//必须设置监听器才会执行这一步,否则一直都是显示tag=1的这个方法
                }

                break;
        }
    }

}
