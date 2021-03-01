package com.tangya.xueji.me;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tangya.xueji.Datebase.my_db_helper;
import com.tangya.xueji.R;

import java.util.ArrayList;

public class shoucActivity extends AppCompatActivity {
    public my_db_helper sc_mydb;
    public SQLiteDatabase sc_db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouc);
        ListView listView=findViewById(R.id.sc_list);
        final ArrayList<String> list = new ArrayList();
        final my_db_helper sc_mydb = new my_db_helper(this);
        SQLiteDatabase sc_db=sc_mydb.getReadableDatabase();
        Cursor cursor = sc_db.query("u_sc", null, null, null, null, null, null);
        if (cursor!=null){
            while (cursor.moveToNext()) {
                int u_sc= cursor.getColumnIndex("u_sc");
                int u_sc_id= cursor.getColumnIndex("u_sc_id");
                String u_shouc = cursor.getString(u_sc);
                String u_shouc_id = cursor.getString(u_sc_id);

                list.add("收藏"+u_shouc_id+":"+u_shouc);
                Toast.makeText(shoucActivity.this,"进入收藏"+u_shouc,Toast.LENGTH_SHORT).show();
            }
            cursor.close();
            sc_db.close();
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(shoucActivity.this,R.layout.support_simple_spinner_dropdown_item,list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(getApplicationContext(),"你的收藏"+list.get(i),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
