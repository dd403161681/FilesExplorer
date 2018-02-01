package com.obe.filesexplorer;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * Created by ken on 2018/1/30.
 */

public abstract class BaseActivity extends FragmentActivity{
    private static final String TAG = BaseActivity.class.getSimpleName();

    public RelativeLayout mRelativeLayout;
    public FrameLayout mRootView;
    public int mDisplayMode;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.menuContainer);
        mRootView =(FrameLayout)findViewById(R.id.rootContainer);
    }

    public int getBackStatckEntryCount(){
        return getSupportFragmentManager().getBackStackEntryCount();
    }
}
