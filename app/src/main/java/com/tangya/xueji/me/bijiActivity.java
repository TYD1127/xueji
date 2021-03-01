package com.tangya.xueji.me;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.tangya.xueji.Datebase.my_db_helper;
import com.tangya.xueji.R;

import java.util.ArrayList;

public class bijiActivity extends AppCompatActivity {
    public my_db_helper mydb;
    public SQLiteDatabase db;
    ListView listView;
    TextView tv_context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biji);

        listView=findViewById(R.id.bj_list);
//        List<duixiangfz> list = new ArrayList();
        final   ArrayList<String> list = new ArrayList();
        final my_db_helper mydb = new my_db_helper(this);
        SQLiteDatabase db=mydb.getReadableDatabase();
//        db = mydb.getWritableDatabase();
        Cursor cursor = db.query("user_sc", null, null, null, null, null, null);
        if (cursor!=null){
            while (cursor.moveToNext()) {
//            duixiangfz dy = new duixiangfz();
                int priceIndex = cursor.getColumnIndex("u_time");
                int numberIndex = cursor.getColumnIndex("u_bj_content");
                String time = cursor.getString(priceIndex);
                String u_context = cursor.getString(numberIndex);
//            dy.setU_context(u_context);
//            dy.setU_time(time);
//            list.add(dy);
//                tv_context=findViewById(R.id.tv_context);
//                tv_context.setText(u_context);
                list.add("笔记编号"+time+":"+u_context);
                Toast.makeText(bijiActivity.this,"进入笔记"+u_context,Toast.LENGTH_SHORT).show();

//                bj_list_adapter adapter = new bj_list_adapter(bijiActivity.this,list);
//                listView.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
            }
            cursor.close();
            db.close();
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    AlertDialog dialog;
                    //设置对话框属性
                    final EditText editText=new EditText(bijiActivity.this);//通过getActivity（）得到context来实现*已了解*
                    editText.setText("你的笔记："+list.get(i));
                    editText.setEnabled(false);
                    AlertDialog.Builder builder=new AlertDialog.Builder(bijiActivity.this)
                            .setTitle("查看笔记")
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


                    Toast.makeText(getApplicationContext(),"你的笔记"+list.get(i),Toast.LENGTH_SHORT).show();
                }
            });
        }

    }


    public void scbj(View view) {
        final my_db_helper mydb = new my_db_helper(this);

        AlertDialog dialog;
        //设置对话框属性
        final EditText editText=new EditText(bijiActivity.this);//通过getActivity（）得到context来实现*已了解*
        editText.setText("");
        editText.setEnabled(true);
        final SQLiteDatabase db_1=mydb.getReadableDatabase();
        AlertDialog.Builder builder=new AlertDialog.Builder(bijiActivity.this)
                .setTitle("请输入删除笔记编号")
                .setView(editText)
                .setIcon(R.drawable.tx)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int arg1) {
                        String  u_bj=editText.getText().toString();
//                        ContentValues values = new ContentValues();
                        String Sql = "delete from user_sc where u_time = "+u_bj;
                        db_1.execSQL(Sql);
//                          点确定按钮发生的事件
                        db_1.close();
                        Toast.makeText(bijiActivity.this,"已删除编号："+u_bj+"的笔记",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
//
//                        startActivity(new Intent(bijiActivity.this,bijiActivity.class));
//                        finish();
//                        overridePendingTransition(0,0);
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


    public void shuaxing(View view) {

        startActivity(new Intent(bijiActivity.this,bijiActivity.class));
        finish();
        overridePendingTransition(0,0);
    }
}


