package com.biz.framwork.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.biz.framwork.inf.TabViewInfoInf;

/**
 * 功能：FramworkTest
 *  专用adapter
 * @author 蒋坤明
 * @time 2016/1/7.
 */
public abstract class TabFragmentPagerAdapter extends FragmentPagerAdapter implements TabViewInfoInf{
    public TabFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }
}
