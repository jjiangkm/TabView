package biz.com.framworktest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.biz.framwork.adapter.TabFragmentPagerAdapter;
import com.biz.framwork.bean.TabViewInfo;
import com.biz.framwork.widget.TabView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private ViewPager vp;
    private TabView tabview;
    private List<Fragment> fragmentList;
    private List<TabViewInfo> tabViewInfoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        setDate();
    }

    private void setDate() {
        tabViewInfoList = new ArrayList<>();
        fragmentList = new ArrayList<>();
        String title1 = "第一";
        TabViewInfo info = new TabViewInfo();
        info.setName(title1);
        info.setDrawbleResId(R.drawable.drawableselector);
        info.setColorResId(R.color.textselector);
        tabViewInfoList.add(info);
        fragmentList.add(Fragment1.newInstance(title1));
        String title2 = "第二";
        TabViewInfo info2 = new TabViewInfo();
        info2.setName(title2);
        info2.setDrawbleResId(R.drawable.drawableselector);
        tabViewInfoList.add(info2);
        fragmentList.add(Fragment1.newInstance(title2));
        String title3 = "第三";
        TabViewInfo info3 = new TabViewInfo();
        info3.setName(title3);
        info3.setDrawbleResId(R.drawable.drawableselector);
        tabViewInfoList.add(info3);
        fragmentList.add(Fragment1.newInstance(title3));
        String title4 = "第四";
        TabViewInfo info4 = new TabViewInfo();
        info4.setName(title4);
        info4.setDrawbleResId(R.drawable.drawableselector);
        tabViewInfoList.add(info4);
        fragmentList.add(Fragment1.newInstance(title4));
        vp.setAdapter(new TabViewPagerAdapter(getSupportFragmentManager()));
        tabview.setColorResId(R.color.textselector);
        tabview.setViewPager(vp);
    }

    private void initialize() {

        vp = (ViewPager) findViewById(R.id.vp);
        tabview = (TabView) findViewById(R.id.tabview);
    }
    private class TabViewPagerAdapter extends TabFragmentPagerAdapter{

        public TabViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public TabViewInfo getTabViewInfo(int position) {
            return tabViewInfoList.get(position);
        }
    }
}
