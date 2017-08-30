package com.example.kimhun.chattingtest;

import android.graphics.drawable.Drawable;

/**
 * Created by kimhun on 2017-08-30.
 */

public class ListViewItem {

    private Drawable iconDrawable;
    private String str;

    public void setIcon(Drawable icon){
        iconDrawable = icon;
    }
    public void setStr(String text){
        str = text;
    }
    public Drawable getIcon(){
        return this.iconDrawable;
    }
    public String getStr(){
        return this.str;
    }
}
