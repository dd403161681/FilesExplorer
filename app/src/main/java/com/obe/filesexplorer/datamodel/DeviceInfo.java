package com.obe.filesexplorer.datamodel;

import java.io.Serializable;

/**
 * Created by ken on 2018/1/31.
 */

public class DeviceInfo implements Serializable{
    public String mDevName;
    public String mRootPath;
    public long mQuotaAvailable;
    public long mQuotaTotal;
    public long mMaxFileSize;
    public String mDeviceFrom;

    public DeviceInfo(){

    }
}
