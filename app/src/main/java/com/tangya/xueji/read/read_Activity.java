package com.tangya.xueji.read;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.tangya.xueji.Datebase.my_db_helper;
import com.tangya.xueji.DownloadUtil;
import com.tangya.xueji.R;

public class read_Activity extends AppCompatActivity {
    WebView mWebView;
    Button back;
    Button sc;
    Button bj;
    TextView bt;
    SQLiteDatabase db;
    my_db_helper mydq;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        mydq=new my_db_helper(this);
        back=findViewById(R.id.bt_bk);
        sc=findViewById(R.id.bt_sc);
        bt=findViewById(R.id.b_t);
        bj=findViewById(R.id.bt_bj);
        initView();
        Intent intent=getIntent();
        String wjm=intent.getStringExtra("web");
        String bt_1=intent.getStringExtra("bt");
        bt.setText("书名："+bt_1);
        final String b_t=intent.getStringExtra("bt");

        //加载本地文件
        preView(wjm);
        //加载允许跨域访问的文件
//       preView("http://tangya.xyz/PDF/Web.pdf");
        //跨域加载文件 先将pdf下载到本地在加载
//        download("http://dsc.huijinchain.com/oss/goldchain/3e9aac273eb743f6944a06ec4af963e1.pdf");
//        download("http://dsc.huijinchain.com/oss/goldchain/367265d435914aafa13a2402f4623c14.pdf");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//            read_Activity.super.onDestroy();
//                read_Activity.super.finish();
//                Intent intent=new Intent(read_Activity.this,MainActivity.class);
//                startActivity(intent);
            }
        });
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = mydq.getWritableDatabase();//定义出错
                String  u_sc=b_t;

//                      bt.getText().toString();
                ContentValues values = new ContentValues();
                values.put("u_sc",u_sc);
                db.insert("u_sc", null, values);
                db.close();
                Toast.makeText(read_Activity.this,"收藏成功",Toast.LENGTH_LONG).show();
            }
        });
        bj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog;
                //设置对话框属性
                final EditText editText=new EditText(read_Activity.this);
                AlertDialog.Builder builder=new AlertDialog.Builder(read_Activity.this)
                        .setTitle("添加笔记")
                        .setView(editText)
                        .setIcon(R.drawable.tx)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int arg1) {
                                db = mydq.getWritableDatabase();//定义出错
                                String  u_bj=editText.getText().toString();
                                ContentValues values = new ContentValues();
                                values.put("u_bj_content",u_bj);
                                db.insert("user_sc", null, values);
                                db.close();

//                         点确定按钮发生的事件
                                dialog.dismiss();
//                                Toast.makeText(read_Activity.this,"你已经添加笔记"+editText.getText().toString(),Toast.LENGTH_LONG).show();
                                Toast.makeText(read_Activity.this,"添加成功",Toast.LENGTH_LONG).show();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
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

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK ) {
            //do something.
            return true;
        } else {
            return super.dispatchKeyEvent(event);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("SetJavaScriptEnabled")
    private void initView() {
        mWebView = findViewById(R.id.webView);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
    }

    /**
     * 下载pdf文件到本地
     *
     * @param url 文件url
     */
    private void download(String url) {
        DownloadUtil.download(url, getCacheDir() + "/temp.pdf",
                new DownloadUtil.OnDownloadListener() {
                    @Override
                    public void onDownloadSuccess(final String path) {
                        Log.d("MainActivity", "onDownloadSuccess: " + path);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                preView(path);
                            }
                        });
                    }

                    @Override
                    public void onDownloading(int progress) {
                        Log.d("MainActivity", "onDownloading: " + progress);
                    }

                    @Override
                    public void onDownloadFailed(String msg) {
                        Log.d("MainActivity", "onDownloadFailed: " + msg);
                    }
                });
    }

    /**
     * 预览pdf
     *
     * @param pdfUrl url或者本地文件路径
     */
    private void preView(String pdfUrl) {
        //1.只使用pdf.js渲染功能，自定义预览UI界面
        mWebView.loadUrl("file:///android_asset/index_a.html?" + pdfUrl);
        //2.使用mozilla官方demo加载在线pdf
//        mWebView.loadUrl("http://mozilla.github.io/pdf.js/web/viewer.html?file=" + pdfUrl);
        //3.pdf.js放到本地
//        mWebView.loadUrl("file:///android_asset/pdfjs/web/viewer.html?file=" + pdfUrl);
        //4.使用谷歌文档服务
//        mWebView.loadUrl("http://docs.google.com/gviewembedded=true&url=" + pdfUrl);
    }

    public void bj(View view) {
    }

    public void sc(View view) {
    }
}
