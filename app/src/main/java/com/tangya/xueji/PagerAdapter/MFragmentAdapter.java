package com.tangya.xueji.PagerAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.tangya.xueji.main_fragment.bdFragment;
import com.tangya.xueji.main_fragment.meFragment;
import com.tangya.xueji.main_fragment.scFragment;


/**
 * 主界面底部菜单适配器
 */
public class MFragmentAdapter extends FragmentPagerAdapter {
    public MFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment = new bdFragment();
                break;
            case 1:
                fragment = new scFragment();
                break;
            case 2:
                fragment = new meFragment();
                break;
            default:
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
