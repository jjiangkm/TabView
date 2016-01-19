package com.biz.framwork.bean;

/**
 * 功能：FramworkTest
 *  保存TabView
 * @author 蒋坤明
 * @time 2016/1/7.
 */
public class TabViewInfo {
    private String name;
    private int drawbleResId;
    private int colorResId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawbleResId() {
        return drawbleResId;
    }

    public void setDrawbleResId(int drawbleResId) {
        this.drawbleResId = drawbleResId;
    }

    public int getColorResId() {
        return colorResId;
    }

    public void setColorResId(int colorResId) {
        this.colorResId = colorResId;
    }
}
