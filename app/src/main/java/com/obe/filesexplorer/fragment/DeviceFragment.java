package com.obe.filesexplorer.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.obe.filesexplorer.datamodel.DeviceInfo;
import com.obe.filesexplorer.viewadapter.DeviceGridAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ken on 2018/2/1.
 */

public class DeviceFragment extends FileOperationFragment
    implements AdapterView.OnItemLongClickListener{

    private final int FINDDEVICE = 0x1001;

    private DeviceGridAdapter mGridAdapter;

    public static List<DeviceInfo> mDeviceList = new ArrayList<>();

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            DeviceInfo devinfo ;

            if(Intent.ACTION_MEDIA_EJECT.equals(action)){
                String path = intent.getData().getPath();
                devinfo = new DeviceInfo();
                devinfo.mRootPath = path;

            }else if(Intent.ACTION_MEDIA_MOUNTED.equals(action)){

            }
        }
    };

    private void removeDevice(DeviceInfo deviceInfo){
        if(null != deviceInfo){
            mDeviceList.remove(deviceInfo);
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        return false;
    }

    @Override
    public void onCreateNewDirectory(String dirName) {

    }

    @Override
    public void onDecompressSuccess(String paramString) {

    }

    @Override
    public void onDelFileSuccess(boolean paramBoolean, String paramString, long paramLong) {

    }

    @Override
    public void onIOperationFinish(int paramInt, String paramString) {

    }

    @Override
    public void onNoHideFile() {

    }

    @Override
    public void onPasteFileSuccess(boolean paramBoolean, String paramString, long paramLong) {

    }

    @Override
    public void onPasteProgressChange(String paramString1, String paramString2, long paramLong1, long paramLong2) {

    }

    @Override
    public void onRenameFileSuccess(String paramString1, String paramString2) {

    }
}
