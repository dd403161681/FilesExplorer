package com.obe.filesexplorer.viewadapter;

import android.content.Context;

import com.obe.filesexplorer.datamodel.BaseData;

import java.util.List;

/**
 * Created by ken on 2018/2/1.
 */

public class FileDetailAdapter extends FileItemAdapter{

    public FileDetailAdapter(Context context, List<BaseData> dataList) {
        super(context, dataList);
    }

}
