package com.tangya.xueji;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
public class wel_bool extends AppCompatActivity {
    boolean isFirstIn;
    public static String sMallId = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        // 获取SharedPreferences对象
        SharedPreferences sp = wel_bool.this.getSharedPreferences("SP", MODE_PRIVATE);
        isFirstIn = sp.getBoolean("isFirstIn", true);
        if (isFirstIn) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    goGuide();
                }
            }, 1000);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("isFirstIn", false);
            editor.commit();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    goHome();
                }
            }, 100);
        }
    }

    private void goHome() {
        Intent intent = new Intent(wel_bool.this, MainActivity.class);
        wel_bool.this.startActivity(intent);
        wel_bool.this.finish();
    }

    private void goGuide() {
        Intent intent = new Intent(wel_bool.this, Wel.class);
        wel_bool.this.startActivity(intent);
        wel_bool.this.finish();
    }
}