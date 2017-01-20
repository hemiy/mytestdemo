package hemiy.qinghui.com.mytestdemo.listviewtype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hemiy.qinghui.com.mytestdemo.R;

/**
 * Created by hemiy on 16/10/19 10:07.
 */

public class PersonAdapter extends BaseAdapter {


    private Context context;
    private List<Person> list;


    public PersonAdapter(Context context,List<Person> list){
        this.context=context;
        this.list=list;

    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Person person = list.get(position);
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_type, null);
            holder = new Holder();
            holder.tvHead=(TextView) convertView.findViewById(R.id.tvHead);
            holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

         //控制header的显示和隐藏
        if(position!=0){
            if(list.get(position-1).getType()!=person.getType()){//如果前后2项的的type是不一样的,就显示头部;否则就隐藏
                holder.tvHead.setVisibility(View.VISIBLE);
            }else{
                holder.tvHead.setVisibility(View.GONE);
            }
        }


        //
        holder.tvHead.setText(person.getType()+""); //注意文字不能设置int值,只能给个String类型
        holder.tvName.setText(person.getName());
        return convertView;
    }

    private class Holder {
        TextView tvHead;
        TextView tvName;
    }

}
