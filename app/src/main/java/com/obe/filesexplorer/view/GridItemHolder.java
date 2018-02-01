package com.obe.filesexplorer.view;

import android.app.Fragment;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by ken on 2018/1/30.
 */

public class GridItemHolder extends RelativeLayout implements View.OnFocusChangeListener{
    private FrameLayout mFrameLayout;
    private ImageView mFileIcon;
    private MarqueeText mFileName;

    public GridItemHolder(Context context) {
        super(context);
        initView(context);
    }

    public GridItemHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public GridItemHolder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public GridItemHolder(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if(b){
            mFileName.startScroll();
        }else{
            mFileName.stopScroll();
        }
    }

    private void initView(Context context){
//        LayoutInflater.from(context).inflate( ,this,true);
//        mFrameLayout = (FrameLayout)findViewById();
//        mFileIcon = (ImageView)findViewById();
//        mFileName=(MarqueeText)findViewById();
        mFrameLayout.addView(mFileIcon);
    }
}
