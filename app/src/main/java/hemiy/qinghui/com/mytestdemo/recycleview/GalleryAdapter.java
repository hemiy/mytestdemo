package hemiy.qinghui.com.mytestdemo.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hemiy.qinghui.com.mytestdemo.R;

/**
 * Created by hemiy on 16/9/2 18:57.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<Integer> mDatas;
    /**
     * ItemClick的回调接口
     * @author zhy
     *
     */
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }



    public interface OnLongItemClickLitener{
       void onLongItemClickLitener(View view, int position);
    }


    private OnLongItemClickLitener mOnLongItemClickLitener;

    public void setOnLongItemClickLitener(OnLongItemClickLitener mOnLongItemClickLitener) {
        this.mOnLongItemClickLitener = mOnLongItemClickLitener;
    }

    public GalleryAdapter(Context context, List<Integer> datats)
    {
        mInflater = LayoutInflater.from(context);
        mDatas = datats;
    }

//    我们创建的ViewHolder必须继承RecyclerView.ViewHolder
//    ，这个RecyclerView.ViewHolder的构造时必须传入一个View，
//    这个View相当于我们ListView getView中的convertView （即：我们需要inflate的item布局需要传入）。
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView mImg;
        private TextView mTxt;

        public ViewHolder(View arg0)
        {
            super(arg0);
            mImg = (ImageView) arg0.findViewById(R.id.id_index_gallery_item_image);
            mTxt= (TextView) arg0.findViewById(R.id.id_index_gallery_item_text);
        }


    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }


    //这里把getView这个方法变为了onCreateViewHolder
    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i)
    {
        return new ViewHolder(mInflater.inflate(R.layout.item_for_recycleview, parent, false));
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i)
    {
        viewHolder.mImg.setImageResource(mDatas.get(i));
        viewHolder.mTxt.setText((i+1)+"页");
        //如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null)
        {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    //把当前点击的view也带出来给接口
                    mOnItemClickLitener.onItemClick(viewHolder.itemView, i);
                }
            });

            if(mOnLongItemClickLitener!=null){
                viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        mOnLongItemClickLitener.onLongItemClickLitener(viewHolder.itemView,i);
                        return true;
                    }
                });
            }


        }
    }
}
