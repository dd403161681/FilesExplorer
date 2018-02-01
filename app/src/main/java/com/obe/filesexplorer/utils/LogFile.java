package com.obe.filesexplorer.utils;

import android.util.Log;

/**
 * Created by ken on 2018/1/30.
 */

public  class LogFile {
    private static boolean dDebug = true;
    private static boolean eDebug = true;
    private static boolean iDebug = true;

    public static void LOGD(String tag, String msg){
        if(dDebug) Log.d(tag, msg);
    }

    public static  void LOGE(String tag, String msg){
        if(eDebug) Log.e(tag,msg);
    }

    public static  void LOGI(String tag, String msg){
        if(iDebug) Log.i(tag,msg);
    }
}
