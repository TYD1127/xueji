package com.tangya.xueji.PagerAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.tangya.xueji.wel.wel_1;
import com.tangya.xueji.wel.wel_2;
import com.tangya.xueji.wel.wel_3;

import java.util.ArrayList;

public class FPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> strings = new ArrayList<>();
    public FPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public Fragment getItem(int i)
    { switch (i) {
        case 0: return new wel_1();
        case 1: return new wel_2();
        case 2: return new wel_3();
        default: return null;
    }
    }
    @Override
    public int getCount() {
        return fragments.size();
    }
    public void add(Fragment fr, String str){
        fragments.add(fr);
        strings.add(str);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
