package com.biz.framwork.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.biz.framwork.R;
import com.biz.framwork.bean.TabViewInfo;
import com.biz.framwork.inf.TabViewInfoInf;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：FramworkTest
 *  底部控件
 * @author 蒋坤明
 * @time 2016/1/7.
 */
public class TabView extends LinearLayout implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private final LayoutInflater inflater;
    private ViewPager vp;
    private TabViewInfoInf tabViewInfoInf;
    private List<LinearLayout> viewList;
    private int colorResId;

    public TabView(Context context) {
        this(context,null);
    }

    public TabView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflater = LayoutInflater.from(context);
    }
    public void setViewPager(ViewPager vp){
        this.vp = vp;
        if(vp==null){
            throw new RuntimeException("未设置viewpager");
        }
        if(vp.getAdapter()==null){
            throw new RuntimeException("未给viewpager设置adapter");
        }
        try {
            tabViewInfoInf = (TabViewInfoInf) vp.getAdapter();
        }catch (Exception ex){
            throw new RuntimeException("未给viewpager设置本tabview专用adapter");
        }
        initView();
    }

    public void setColorResId(int colorResId) {
        this.colorResId = colorResId;
    }

    private void initView() {
        viewList = new ArrayList<>();
        PagerAdapter adapter = vp.getAdapter();
        for(int  i = 0;i<adapter.getCount();i++){
            TabViewInfo tabViewInfo = tabViewInfoInf.getTabViewInfo(i);
            LinearLayout ll = new LinearLayout(getContext());
            ll.setOrientation(LinearLayout.VERTICAL);
            ll.setGravity(Gravity.CENTER);
            ll.setId(i);
            ll.setOnClickListener(this);
            ImageView iv = new ImageView(getContext());
            iv.setImageResource(tabViewInfo.getDrawbleResId());
            LayoutParams layoutparams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            ll.addView(iv,layoutparams);
            TextView tv = new TextView(getContext());
            ll.addView(tv,layoutparams);
            ColorStateList colorStateList = getResources().getColorStateList(colorResId);
            tv.setTextColor(colorStateList);
            tv.setText(tabViewInfo.getName());
            LayoutParams params = new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.weight = 1;
            this.addView(ll,params);
            viewList.add(ll);
        }
        viewList.get(vp.getCurrentItem()).setSelected(true);
        vp.addOnPageChangeListener(this);
    }
    public static Drawable tintDrawable(Drawable drawable, ColorStateList colors) {
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, colors);
        return wrappedDrawable;
    }
    @Override
    public void onClick(View v) {
        vp.setCurrentItem(v.getId());
        updateColor(v);
    }

    private void updateColor(View v) {
        for(LinearLayout ll:viewList){
            ll.setSelected(false);
        }
        v.setSelected(true);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        updateColor(viewList.get(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
