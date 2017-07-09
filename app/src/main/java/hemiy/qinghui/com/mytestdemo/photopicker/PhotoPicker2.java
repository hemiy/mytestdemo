package hemiy.qinghui.com.mytestdemo.photopicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.GridView;

import com.yongchun.library.view.ImageSelectorActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hemiy.qinghui.com.mytestdemo.R;
import hemiy.qinghui.com.mytestdemo.glide.MemoAdapter;

/**
 * https://github.com/ioneday/ImageSelector
 * 模仿微信的图片预览和选择控件
 * Created by hemiy on 16/6/6.
 */
public class PhotoPicker2 extends Activity {

    @BindView(R.id.btn_select_pic)
    Button btnSelectPic;
    @BindView(R.id.gv)
    GridView gv;
    private MemoAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_picker2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_select_pic)
    public void onClick() {
        //上下文  图片数量 多选还是单选模式 显示拍照选项  是否预览  是否打开剪切
        ImageSelectorActivity.start(PhotoPicker2.this, 9, ImageSelectorActivity.MODE_MULTIPLE, true, true, false);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == ImageSelectorActivity.REQUEST_IMAGE) {
            ArrayList<String> images = (ArrayList<String>) data.getSerializableExtra(ImageSelectorActivity.REQUEST_OUTPUT);
          //  Log.i("tag", "图片的路径是" + images.toString());
           // Log.i("tag", "图片的数量是" + images.size());
            adapter = new MemoAdapter(PhotoPicker2.this, images);
            gv.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
}
