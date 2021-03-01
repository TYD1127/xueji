package com.tangya.xueji;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.tangya.xueji.PagerAdapter.FPagerAdapter;
import com.tangya.xueji.wel.wel_1;
import com.tangya.xueji.wel.wel_2;
import com.tangya.xueji.wel.wel_3;

public class Wel extends AppCompatActivity {
    ViewPager vp;
    TabLayout tableLayout;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_wel);
//        bt=(Button) findViewById(R.id.bt1);
        vp = findViewById(R.id.vp);
        tableLayout = findViewById(R.id.tb);
        FPagerAdapter ap = new FPagerAdapter(getSupportFragmentManager());
        ap.add(new wel_1(), "");
        ap.add(new wel_2(), "");
        ap.add(new wel_3(), "");
        vp.setAdapter(ap);
        tableLayout.setupWithViewPager(vp);
    }

}

