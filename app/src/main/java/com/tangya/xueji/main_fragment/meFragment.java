package com.tangya.xueji.main_fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.tangya.xueji.R;

/**
 * 2019_12_2——完成
 */
public class meFragment extends Fragment {
    Context context;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.me,container,false);
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Button bzc = (Button) getActivity().findViewById(R.id.bt_zc);//出错
        Button u_name=getActivity().findViewById(R.id.bt_dl);
        final Intent intent=getActivity().getIntent();
        final String name= intent.getStringExtra("yhm");//name==null||name.length()!=0
//        if( name==null||name.length()!=0){
//            name="未登录";
//            u_name.setText("用户"+name);
//         }else{
//            u_name.setText("普通用户"+name);
//        }
        u_name.setText("用户"+name);
        Button bdl = (Button) getActivity().findViewById(R.id.bt_dl);//出错
        bdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.LOGIN");

                startActivity(intent);


            }
        });


        Button bbj = (Button) getActivity().findViewById(R.id.bt_bj);//出错
        bbj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int_bj=new Intent();
                int_bj.setAction("android.intent.action.BJ");
                startActivity(int_bj);

            }
        });

        Button bsc = (Button) getActivity().findViewById(R.id.bt_sc);//出错
        bsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent11=new Intent();
                intent11.setAction("android.intent.action.SC");
                startActivity(intent11);

            }
        });
        Button b_tc = (Button) getActivity().findViewById(R.id.tcyy);//出错
        b_tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
//               BroadcastUtils t=new BroadcastUtils();
//               t.sendFinishActivityBroadcast(context);

            }
        });

        Button bsz = (Button) getActivity().findViewById(R.id.bt_sz);//出错
        bsz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int_sz=new Intent();
                int_sz.setAction("android.intent.action.SZ");
                startActivity(int_sz);
            }
        });


        Button bt_gy = (Button) getActivity().findViewById(R.id.bt_gy);//出错
        bt_gy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog;
                //设置对话框属性
                final EditText editText=new EditText(getContext());//通过getActivity（）得到context来实现*已了解*
                editText.setText("\n\t\t\t联系作者:\n\n\t\t email:tyddzy@gmail.com");
                editText.setEnabled(false);
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext())
                        .setTitle("关于学迹应用")
                        .setView(editText)
                        .setIcon(R.drawable.tx)
                        .setPositiveButton("返回", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int arg1) {

//                         点确定按钮发生的事件
                                dialog.dismiss();
//
                            }
                        }).setNegativeButton("", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int arg1) {
                                // 点取消按钮发生的事件
                                dialog.dismiss();

                            }
                        });
                builder.setCancelable(true);
                dialog=builder.create();
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();

            }
        });


//        bzc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {

//                getActivity().getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.me, new signin(), null)
////                        .addToBackStack(null)
//                        .commit();

//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                Intent intent = new Intent();
//                intent.setAction("android.intent.action.ST");
//                startActivity(intent);

        /**
         * 公共方法： 从碎片fragment1跳转到碎片fragment2
         *
         * @param fragment1
         *            当前fragment
         * @param fragment2
         *            跳转后的fragment
         */



//
//
//            }
//        });
//
    }

    private void tz(Fragment fragment1, Fragment fragment2) {
        // 获取 FragmentTransaction  对象
        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();
        //如果fragment2没有被添加过，就添加它替换当前的fragment1
        if (!fragment2.isAdded()) {
            transaction.add(R.id.fa,fragment2)
                    //加入返回栈，这样你点击返回键的时候就会回退到fragment1了
                    .addToBackStack(null)
                    // 提交事务
                    .commitAllowingStateLoss();

        } else { //如果已经添加过了的话就隐藏fragment1，显示fragment2
            transaction
                    // 隐藏fragment1，即当前碎片
                    .hide(fragment1)
                    // 显示已经添加过的碎片，即fragment2
                    .show(fragment2)
                    // 加入返回栈
                    .addToBackStack(null)
                    // 提交事务
                    .commitAllowingStateLoss();
        }
    }

}

//class BroadcastUtils {
//    /**
//     * 发送finish页面的广播
//     * action可以自己根据需要添加
//     * @param context
//     */
//    public static void sendFinishActivityBroadcast(Context context) {
//        Intent intent = new Intent(jieshu.RECEIVER_ACTION_FINISH_B);
//        context.sendBroadcast(intent);
//    }
//}

