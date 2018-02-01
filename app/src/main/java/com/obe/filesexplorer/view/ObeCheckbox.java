package com.obe.filesexplorer.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.obe.filesexplorer.R;
/**
 * Created by ken on 2018/1/30.
 */
public class ObeCheckbox extends ImageView {
    private Bitmap mBmp;
    private boolean mIsChecked;
    private Paint mPaint;

    public ObeCheckbox(Context context) {
        super(context);
        initView();
    }

    public ObeCheckbox(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ObeCheckbox(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public ObeCheckbox(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    public void initView(){
        mIsChecked = false;
        mBmp = BitmapFactory.decodeResource(getResources(), R.drawable.device_flag_selected);
        mPaint = new Paint();
        setBackgroundResource(R.drawable.device_flag_normal);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mIsChecked){
            canvas.drawBitmap(mBmp,0.0F,0.0F,mPaint);
        }
    }

    public void setChecked(boolean isChecked){
        mIsChecked = isChecked;
        invalidate();
    }
}
