package com.obe.filesexplorer.datamodel;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.support.annotation.RequiresApi;


/**
 * Created by ken on 2018/1/31.
 */

public class LocalDevice {
    private static final String TAG = LocalDevice.class.getSimpleName();

    private List<DeviceInfo> localDevList = new ArrayList<>();
    private StorageManager storageManager;
    private Context mContext;

    public LocalDevice(Context context){
        mContext = context;
        storageManager = (StorageManager)context.getSystemService(Context.STORAGE_SERVICE);

    }

    public DeviceInfo getDeviceInfo(String path){
        DeviceInfo devInfo = new DeviceInfo();

        return devInfo;
    }

    public List<DeviceInfo> getLocalDevList(){
        return localDevList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<String> getMountPathList(){
        ArrayList arrayList = new ArrayList();
        List<StorageVolume> volumes = storageManager.getStorageVolumes();

        return null;
    }

}
