package com.tangya.xueji.main_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tangya.xueji.PagerAdapter.Cridadapter;
import com.tangya.xueji.PagerAdapter.p;
import com.tangya.xueji.R;

import java.util.ArrayList;

;


public class bdFragment extends Fragment {
    GridView gridView;
    ArrayList<p>list;
    Cridadapter cridadapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.bd,container,false);
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridView = (GridView) getActivity().findViewById(R.id.mc_list);
        mc_list();
        cridadapter= new Cridadapter(this.getContext(),list);
        gridView.setAdapter(cridadapter);
//        Button button = (Button) getActivity().findViewById(R.id.yd);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setAction("android.intent.action.ST");
//                startActivity(intent);
//            }
//        });

    }
//    public void re(View view) {
//                Intent intent = new Intent();
//                intent.setAction("android.intent.action.ST");
//                startActivity(intent);
//            }

    private void mc_list() {
        list=new ArrayList<p>();
        list.add(new p(" 白帽子讲web安全",R.drawable.web_aq));
        list.add(new p("android总结",R.drawable.android_zj));
        list.add(new p("MySQL数据库入门",R.drawable.mysql));
        list.add(new p("精通nginx",R.drawable.nginx));
        list.add(new p("Node.js代码段",R.drawable.node_js));
        list.add(new p("Python 3.5从零开始学",R.drawable.pythoon));
        list.add(new p("Tomcat 应用开发",R.drawable.tomcat));
        list.add(new p("Android 模块化项目实战",R.drawable.android_xm));
    }

}
