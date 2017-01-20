package hemiy.qinghui.com.mytestdemo.materialdialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;
import me.drakeet.materialdialog.MaterialDialog;

/**
 * https://github.com/drakeet/MaterialDialog
 * Created by hemiy on 16/9/12 21:20.
 */

public class MateraiDialogActivity extends Activity implements View.OnClickListener {


    @BindView(R.id.btnShowDialgo)
    Button btnShowDialgo;
    MaterialDialog mMaterialDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_dialog);
        ButterKnife.bind(this);
        btnShowDialgo.setOnClickListener(this);
        mMaterialDialog = new MaterialDialog(this);

    }

    @Override
    public void onClick(View v) {
        mMaterialDialog
                .setTitle("提示框")
                .setMessage("Hello world!")
                .setPositiveButton("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                        Toast.makeText(MateraiDialogActivity.this, "click", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("CANCEL", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });

        mMaterialDialog.show();
    }


    //自定义dialog
//    EditText contentView = new EditText(this);
//    MaterialDialog mMaterialDialog = new MaterialDialog(this).setView(contentView);
//
//    mMaterialDialog.show();

}
