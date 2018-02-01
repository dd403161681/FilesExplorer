package com.obe.filesexplorer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.obe.filesexplorer.datamodel.BaseData;
import com.obe.filesexplorer.utils.LogFile;

/**
 * Created by ken on 2018/1/31.
 */

public class UsbDetailActivity extends BaseActivity {
    private final static String TAG = UsbDetailActivity.class.getSimpleName();

    private String mCurPath;
    private String mDevName;
    private String mRootPath;

    private BaseData mCurFocusData;

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(Intent.ACTION_MEDIA_EJECT.equals(intent.getAction())){
                String path = intent.getData().getPath();
                if(mRootPath.equals(path)){
                    LogFile.LOGE(TAG,"============finish UsbDetailActivity");
                    finish();
                }
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter filter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
        filter.addAction(Intent.ACTION_MEDIA_EJECT);
        filter.addDataScheme("file");
        registerReceiver(mReceiver,filter);

        mRootPath = getIntent().getStringExtra("root_path");
        mDevName = getIntent().getStringExtra("dev_name");
        showUI();
    }

    private void showUI() {
        if(mRootPath.startsWith("/mnt/usb")
                || mRootPath.startsWith("/mnt/sdcard")){
            mCurPath = mRootPath;

        }
    }
}
