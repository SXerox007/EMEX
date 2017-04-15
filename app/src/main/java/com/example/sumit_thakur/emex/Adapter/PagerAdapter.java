package com.example.sumit_thakur.emex.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * -sdd
 */
public class PagerAdapter extends FragmentPagerAdapter {
    /**
     *
     * @param fm hjhj
     */
    public PagerAdapter(final FragmentManager fm) {
        super(fm);
    }

    /**
     *
     * @param position -
     * @return -
     */
    @Override
    public Fragment getItem(final int position) {
        return new Fragment();
    }

    /**
     *
     * @return -
     */
    @Override
    public int getCount() {
        return 2;
    }
}
