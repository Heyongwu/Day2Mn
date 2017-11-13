package mvpframework.bwie.com.day2mn.MyAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import mvpframework.bwie.com.day2mn.R;
import mvpframework.bwie.com.day2mn.bean.MusicBean;

/**
 * Created by 何永武 on 2017/11/12.
 */

public class Adapter extends RecyclerView.Adapter{
    private List<MusicBean.SongListBean> list;
    private List<String> lists;
    private Context context;

    public Adapter(List<MusicBean.SongListBean> list, List<String> lists, Context context) {
        this.list = list;
        this.lists = lists;
        this.context = context;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyview,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MusicBean.SongListBean songListBean = list.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        ImageLoader.getInstance().displayImage(songListBean.getPic_big(),myViewHolder.iv);
        myViewHolder.tv.setText(songListBean.getAuthor()+lists);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv_Reclayv);
            tv = (TextView) itemView.findViewById(R.id.tv_Reclayv);

        }

    }

}
