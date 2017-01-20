package hemiy.qinghui.com.mytestdemo.navigationview;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;

/**
 * http://blog.csdn.net/lmj623565791/article/details/46405409
 * Created by hemiy on 16/6/23.
 */
public class NaviActivity extends FragmentActivity {


    @BindView(R.id.content_layout)
    FrameLayout contentLayout;

//    @BindView(R.id.navigation)
//    NavigationView navigation;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.id_lv_left_menu)
    ListView idLvLeftMenu;

    private ImageView headIconImg;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigationview);
        ButterKnife.bind(this);
        //navigationView选中Item处理,为了代码整齐些，就放在一个函数里了
//        setupDrawerContent(navigation);

//        View headerView = navigation.getHeaderView(0);
//        headIconImg = (ImageView) headerView.findViewById(R.id.photo);
//        desc = (TextView) headerView.findViewById(R.id.desc);
//        desc.setText("hemiy");
//        headIconImg.setImageResource(R.mipmap.ic_launcher); //获取头部的图片 改成其他图片

        LayoutInflater inflater = LayoutInflater.from(this);
        idLvLeftMenu.addHeaderView(inflater.inflate(R.layout.header, idLvLeftMenu, false));
        idLvLeftMenu.setAdapter(new MenuItemAdapter(this));
        idLvLeftMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //点击的时header头部
                if(position==0){
                    Toast.makeText(NaviActivity.this,"点击的时头部",Toast.LENGTH_SHORT ).show();
                }else{
                    //点击其他部位
                    LvMenuItem item= (LvMenuItem) parent.getAdapter().getItem(position);
                    Toast.makeText(NaviActivity.this,item.getName(),Toast.LENGTH_SHORT ).show();
                }


                drawerLayout.closeDrawers();
            }
        });

    }

    private void setupDrawerContent(NavigationView navigation) {

        navigation.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        Snackbar.make(contentLayout, menuItem.getTitle() + " pressed", Snackbar.LENGTH_LONG).show();
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.navigation_sub_item3) {
            drawerLayout.openDrawer(GravityCompat.START); //点击最后一个 打开主页
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
