package com.obe.filesexplorer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by ken on 2018/1/30.
 */

public class MarqueeText extends TextView implements Runnable{
    private int mCurScrollX;
    private boolean mIsMeasure = false;
    private boolean mIsStop = false;
    private int mTextWidth;

    public MarqueeText(Context context) {
        super(context);
    }

    public MarqueeText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

     @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!mIsMeasure){
            mIsMeasure = true;
            mTextWidth = (int) getPaint().measureText(getText().toString());
        }
    }

    @Override
    public void run() {
        mCurScrollX -=2;
        scrollTo(mCurScrollX, 0);
        if(!mIsStop){
            if(getScrollX() <= -getWidth()){
                scrollTo(mTextWidth, 0);
                mCurScrollX = mTextWidth;
            }
            postDelayed(this, 5);
        }
    }

    public void startScroll(){
        mIsStop = false;
        removeCallbacks(this);
        post(this);
    }

    public void stopScroll(){
        mIsStop = true;
    }
}
