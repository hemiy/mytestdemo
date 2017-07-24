package hemiy.qinghui.com.mytestdemo.navigationview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hemiy.qinghui.com.mytestdemo.R;

/**
 * Created by hemiy on 16/6/23.
 */
public class MenuItemAdapter extends BaseAdapter {

    //内容适配器
    private final int mIconSize;
    private LayoutInflater mInflater;
    private Context mContext;

    public MenuItemAdapter(Context context)
    {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mIconSize = context.getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin);//24dp
    }


    List it=new ArrayList();
    private List<LvMenuItem> mItems = new ArrayList<LvMenuItem>(
            Arrays.asList(
                    new LvMenuItem(R.drawable.icon_2shou, "Home"),
                    new LvMenuItem(R.drawable.icon_chaoshi, "Messages"),
                    new LvMenuItem(R.drawable.icon_shequ, "Friends"),
                    new LvMenuItem(R.drawable.icon_warn, "Discussion"),
                    new LvMenuItem(),
                    new LvMenuItem("Sub Items"),
                    new LvMenuItem(R.drawable.icon_female_normal, "Sub Item 1"),
                    new LvMenuItem(R.drawable.icon_loc, "Sub Item 2")
            ));


    @Override
    public int getCount()
    {
        return mItems.size();
    }


    @Override
    public Object getItem(int position)
    {
        return mItems.get(position);
    }


    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public int getViewTypeCount()
    {
        return 3;
    }

    @Override
    public int getItemViewType(int position)
    {
        return mItems.get(position).type;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LvMenuItem item = mItems.get(position);
        switch (item.type)
        {
            case LvMenuItem.TYPE_NORMAL:
                if (convertView == null)
                {
                    convertView = mInflater.inflate(R.layout.design_drawer_item, parent,
                            false);
                }
                TextView itemView = (TextView) convertView.findViewById(R.id.tv);
                ImageView img= (ImageView) convertView.findViewById(R.id.iv_img);
                itemView.setText(item.name);
//                Drawable icon = mContext.getResources().getDrawable(item.icon);
//                setIconColor(icon);
//                if (icon != null)
//                {
//                    icon.setBounds(0, 0, mIconSize, mIconSize);
//                    TextViewCompat.setCompoundDrawablesRelative(itemView, icon, null, null, null);
//                }

                break;
            case LvMenuItem.TYPE_NO_ICON:
                if (convertView == null)
                {
                    convertView = mInflater.inflate(R.layout.design_drawer_item_subheader,
                            parent, false);
                }
                TextView subHeader = (TextView) convertView;
                subHeader.setText(item.name);
                break;
            case LvMenuItem.TYPE_SEPARATOR:
                if (convertView == null)
                {
                    convertView = mInflater.inflate(R.layout.design_drawer_item_separator,
                            parent, false);
                }
                break;
        }

        return convertView;
    }

    public void setIconColor(Drawable icon)
    {
        int textColorSecondary = android.R.attr.textColorSecondary;
        TypedValue value = new TypedValue();
        if (!mContext.getTheme().resolveAttribute(textColorSecondary, value, true))
        {
            return;
        }
        int baseColor = mContext.getResources().getColor(value.resourceId);
        icon.setColorFilter(baseColor, PorterDuff.Mode.MULTIPLY);
    }
}
