package com.obe.filesexplorer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.obe.filesexplorer.fragment.AudioFileFragment;
import com.obe.filesexplorer.fragment.DeviceFragment;
import com.obe.filesexplorer.fragment.FileOperationFragment;
import com.obe.filesexplorer.utils.LogFile;
import com.obe.filesexplorer.view.HomeTitleView;
import com.obe.filesexplorer.viewadapter.HomeFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ken on 2018/1/30.
 */

public class FilesExplorerActivity extends BaseActivity {
    private static final String TAG= FilesExplorerActivity.class.getSimpleName();

    private FilesExplorerApplication mApp;
    private DeviceFragment mDeviceFragment;

    private AudioFileFragment mAudioFileFragment;
//    private VideoFileFragment mVideoFileFragment;
//    private ApkFileFragment mApkFileFragment;
//    private PicFileFragment mPicFileFragment;
    private HomeTitleView mHomeTilte;
    private HomeFragmentPagerAdapter mHomePageAdapter;
    private List<FileOperationFragment> mFragmentLists = new ArrayList<>();

    private FragmentManager mFragmentManager;
    private FrameLayout mRootView;
    private ViewPager mViewPager;


    private int mCurPostion;
    private int mDisplayMode;

    public FilesExplorerActivity() {

    }

    private void findView(){
        mRelativeLayout = (RelativeLayout) findViewById(R.id.menuContainer);
        mRootView = (FrameLayout)findViewById(R.id.rootContainer);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mHomeTilte = (HomeTitleView) findViewById(R.id.home_titel_view);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
//        mApp = (FilesExplorerApplication) getApplicationContext();
//        mDisplayMode = mApp.getDisplayMode();
        initFragment();
        initViewPager();
        mCurPostion = 0;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initFragment(){
        mFragmentManager = getSupportFragmentManager();
        mAudioFileFragment = new AudioFileFragment();
        mFragmentLists.add(mAudioFileFragment);

        mDeviceFragment = new DeviceFragment();
        mFragmentLists.add(mDeviceFragment);
    }

    private void initViewPager(){
        mHomePageAdapter = new HomeFragmentPagerAdapter(mFragmentManager,mFragmentLists);
        mViewPager.setAdapter(mHomePageAdapter);
        mViewPager.setOffscreenPageLimit(6);
        mViewPager.setOnPageChangeListener(new PageChangeListener());
    }

    public void getFragmentSelectedSize(){

    }

    public void setFragmentMode(){

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        return super.dispatchKeyEvent(event);
    }



    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            LogFile.LOGD(TAG,"=========onPageSelected pos="+position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
