package com.biz.framwork.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.biz.framwork.inf.TabViewInfoInf;

/**
 * 功能：FramworkTest
 *  专用adapter
 * @author 蒋坤明
 * @time 2016/1/7.
 */
public abstract class TabFragmentStatePagerAdapter extends FragmentStatePagerAdapter implements TabViewInfoInf{
    public TabFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }
}
