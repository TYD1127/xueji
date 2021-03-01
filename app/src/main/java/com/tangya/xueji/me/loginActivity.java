package com.tangya.xueji.me;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tangya.xueji.Datebase.my_db_helper;
import com.tangya.xueji.MainActivity;
import com.tangya.xueji.R;

public class loginActivity extends AppCompatActivity {
    EditText u_name;
    EditText u_pwd;
    Button denglu;
    Button zc;
    private my_db_helper my_db;
   public SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);setContentView(R.layout.login);

        u_name=findViewById(R.id.u_name);
        u_pwd=findViewById(R.id.u_pwd);


        denglu=findViewById(R.id.denglu);
        zc=findViewById(R.id.ljzc);
        final my_db_helper mydb = new my_db_helper(this);


        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(loginActivity.this,siginActivity.class);
                startActivity(intent);
            }
        });

        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=mydb.getReadableDatabase();
                String uname=u_name.getText().toString();
                String upwd=u_pwd.getText().toString();
//                Cursor cursor=db.query("user_info",2,"u_name=? and u_pwd=?")
                String sql="select * from user_info where u_name=? and u_pwd=?";
                Cursor cursor=db.rawQuery(sql, new String[]{uname,upwd});
                if(cursor.moveToFirst()==true){
                    cursor.close();
                    Toast.makeText(loginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(loginActivity.this, MainActivity.class);
                    intent.putExtra("zdf",1);
                    intent.putExtra("yhm",uname);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(loginActivity.this,"登录失败账号or密码错误",Toast.LENGTH_SHORT).show();

                }


        }
        });
    }



}
