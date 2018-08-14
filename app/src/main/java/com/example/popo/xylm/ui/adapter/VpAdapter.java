package com.example.popo.xylm.ui.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by popo on 2018/7/31.
 */

public class VpAdapter extends FragmentPagerAdapter {
    private List<String> tabList;
    private List<Fragment> fragments;

    public VpAdapter(FragmentManager fm, List<String> tabList, List<Fragment> fragments) {
        super(fm);
        this.tabList = tabList;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position);
    }
}
