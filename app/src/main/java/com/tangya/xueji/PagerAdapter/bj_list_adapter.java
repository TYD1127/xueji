package com.tangya.xueji.PagerAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tangya.xueji.R;

import java.util.List;

public class bj_list_adapter extends BaseAdapter {
    private List<duixiangfz> list;
    private LayoutInflater layoutInflater;

    public bj_list_adapter(Context context, List<duixiangfz> list){
        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view==null){
            view=layoutInflater.inflate(R.layout.bj_list_meun,null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) view.getTag();
        }
        duixiangfz dxl = list.get(i);
//        viewHolder.tv_time.setText("第："+dxl.getU_time()+"次笔记");
        viewHolder.tv_context.setText("内容："+dxl.getU_context());
        return view;
    }
    class ViewHolder{
        TextView tv_context;
//        TextView tv_time;

        public ViewHolder(View view) {
            tv_context = view.findViewById(R.id.tv_context);
//            tv_time = view.findViewById(R.id.tv_time);
        }
    }
}

