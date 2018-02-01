package com.obe.filesexplorer.utils;

import android.content.Context;

/**
 * Created by ken on 2018/1/30.
 */

public class DisplayUtil {
    public static int dip2px(Context paramContext, float paramFloat)
    {
        return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
    }
}
