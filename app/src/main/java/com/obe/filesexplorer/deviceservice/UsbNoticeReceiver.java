package com.obe.filesexplorer.deviceservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

/**
 * Created by ken on 2018/2/2.
 */

public class UsbNoticeReceiver extends BroadcastReceiver {
    private final static String TAG = "UsbNoticeReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
        }
    };
}
