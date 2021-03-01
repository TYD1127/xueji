package com.tangya.xueji.PagerAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tangya.xueji.R;
import com.tangya.xueji.read.read_Activity;

import java.util.ArrayList;
public class Cridadapter extends BaseAdapter {
    Context context;
    ArrayList<p>gridp;
    public Cridadapter(Context context, ArrayList<p> gridp) {
        this.context = context;
        this.gridp = gridp;
    }


    @Override
    public int getCount() {
        return gridp.size();
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.bd_mc_list,viewGroup,false);

        final TextView title = view.findViewById(R.id.textView);
        ImageView image = view.findViewById(R.id.imageView5);
        title.setText(gridp.get(i).getTitle());
        image.setImageResource(gridp.get(i).getImg());
        view.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                switch (i){
                    case 0:   re("file:///android_asset/web.pdf","web安全"); break;
                    case 1:   re("file:///android_asset/Android_zj.pdf","安卓总结");break;
                     case 2:   re("http://tangya.xyz/PDF/mysql.pdf","Mysql入门");break;
                     case 3:   re("http://tangya.xyz/PDF/nginx.pdf","Nginx开发");break;
                     case 4:   re("http://tangya.xyz/PDF/node.pdf","Node.js基础");break;
                     case 5:   re("http://tangya.xyz/PDF/python.pdf","python编程");break;
                     case 6:   re("http://tangya.xyz/PDF/tomcat.pdf","tomcat服务器架构");break;
                    case 7:  re("http://tangya.xyz/PDF/Android_xm.pdf","安卓项目案例");break;
                }

                Toast.makeText(context, "正在加载阅读 "+i, Toast.LENGTH_SHORT).show();
            }
            private void re( String wjm ,String bt) {

//                Intent intent = new Intent();
                Intent intent = new Intent(context, read_Activity.class);
                intent.putExtra("web",wjm);
                intent.putExtra("bt",bt);
//                intent.putExtra("bt",bt);
                intent.setAction("android.intent.action.ST");
                context.startActivity(intent);
//               context. startActivity(intent);
//            }错误点***
            }
//            private void re_xm(String Url) {
//                Intent intent = new Intent();
//                intent.setAction("android.intent.action.XM");
//                intent.putExtra("xm",Url);
//                context.startActivity(intent);
//
//            }
        });
        return view;

    }


}
