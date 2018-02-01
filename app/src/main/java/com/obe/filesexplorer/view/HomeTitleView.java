package com.obe.filesexplorer.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.obe.filesexplorer.R;
import com.obe.filesexplorer.utils.DisplayUtil;
import com.obe.filesexplorer.utils.LogFile;

/**
 * Created by ken on 2018/1/30.
 */

public class HomeTitleView extends RelativeLayout implements View.OnClickListener, View.OnFocusChangeListener {
    private final String TAG = "HomeTitleView";
    private int mCurrentTitle;
    private int mLength;

    public OnTitleChangedListener mTitleChangeListener;

    public HomeTitleView(Context context) {
        super(context);
        setTitleResource(R.array.home_title);
    }

    public HomeTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTitleResource(R.array.home_title);
    }

    public HomeTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTitleResource(R.array.home_title);
    }

    public HomeTitleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setTitleResource(R.array.home_title);
    }

    public boolean getTitleStatus(){
        return getChildAt(mCurrentTitle).isFocused();
    }

    public void setTitleResource(int resId){
        String[] arrayOfString = getContext().getResources().getStringArray(resId);
        int index = 0 ;
        mLength = arrayOfString.length;
        if(mLength > 0){
            while (index < mLength){
                setTitle(arrayOfString[index],index);
                index +=1;
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    public void setTitle(String titleName, int titleIndex){
        Button bt = new Button(getContext());

        bt.setText(titleName);
        bt.setGravity(17);
        bt.setTextSize(28.0F);
        bt.setSingleLine(true);
        bt.setMarqueeRepeatLimit(2);
        bt.setId(titleIndex+10);
        bt.setTextColor(R.color.titlespace);
        bt.setBackgroundResource(R.drawable.home_title_background);
        bt.setOnClickListener(this);
        bt.setOnFocusChangeListener(this);
        bt.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        int x = DisplayUtil.dip2px(getContext(),30.0F);
        int y = DisplayUtil.dip2px(getContext(),20.0F);
        bt.setPaddingRelative(x,y,x,y);
        LayoutParams params = new RelativeLayout.LayoutParams(-2,-2);

        int childCount = getChildCount();
        if(childCount > 0){
            params.leftMargin = DisplayUtil.dip2px(getContext(),10.0F);
            params.addRule(1,getChildAt(childCount-1).getId());
        }
        addView(bt,params);
    }

    public void setFocus(int titleId){
        mCurrentTitle = titleId;
        LogFile.LOGD(TAG,"==========setFocus "+ titleId);

        getChildAt(titleId).requestFocus();
    }

    public void setOnTitleChangedListener(OnTitleChangedListener listener){
        mTitleChangeListener = listener;
    }

    @SuppressLint("ResourceAsColor")
    public void setCurrentTitle(int title){
        mCurrentTitle = title;

        for(int i=0 ; i<getChildCount(); i++){
            Button bt = (Button) getChildAt(i);
            if(null != bt){
                if(title == i){
                    bt.setTextColor(R.color.white);
                    bt.requestFocus();
                }else{
                    bt.setTextColor(R.color.music_title_color);
                }
            }
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View view) {
         int i = view.getId() - 10;
        LogFile.LOGD(TAG,"====== view.getId="+view.getId());
        if(null != mTitleChangeListener){
            LogFile.LOGD(TAG,"mTitleChangeListener position is "+ i);
            mTitleChangeListener.onTitleChange(i);
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if(b){
            LogFile.LOGD(TAG,"onFocusChange hasFocus");
            onClick(view);
            view.animate().scaleX(1.14F).scaleY(1.14F).start();
            return;
        }
        view.animate().scaleX(1.0F).scaleY(1.0F).start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            switch (keyCode){
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    if(mCurrentTitle > 0){
                        mCurrentTitle -= 1;
                        getChildAt(mCurrentTitle).requestFocus();
                    }
                    return true;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    if(mCurrentTitle < mLength){
                        mCurrentTitle += 1;
                        getChildAt(mCurrentTitle).requestFocus();
                        return true;
                    }
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public static abstract interface OnTitleChangedListener
    {
        public abstract void onTitleChange(int paramInt);
    }
}
