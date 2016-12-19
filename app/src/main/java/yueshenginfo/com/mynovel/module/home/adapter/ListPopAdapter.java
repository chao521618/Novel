package yueshenginfo.com.mynovel.module.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import yueshenginfo.com.mynovel.R;

/**
 * Created by huchao on 2016/12/16.
 * Email 1064224874@qq.com
 */
public class ListPopAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> mArrayList;
    public ListPopAdapter(Context  context,ArrayList<String> mArrayList) {
        this.context=context;
        this.mArrayList=mArrayList;
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=  LayoutInflater.from(context).inflate(R.layout.item_search,null);
            holder.tv= (TextView) convertView.findViewById(R.id.book_name);
            holder.iv= (ImageView) convertView.findViewById(R.id.iv_booksflag);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
       holder.tv.setText(mArrayList.get(position));
        if (position%3==1){
           holder.iv.setImageResource(R.drawable.icon_acthor);
        }else {
            holder.iv.setImageResource(R.drawable.icon_book);
        }
        return convertView;
    }
    static class ViewHolder
    {public ImageView iv;
        public TextView tv;
    }
}
