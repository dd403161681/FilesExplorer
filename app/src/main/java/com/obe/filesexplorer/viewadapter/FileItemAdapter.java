package com.obe.filesexplorer.viewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.obe.filesexplorer.FilesExplorerApplication;
import com.obe.filesexplorer.datamodel.BaseData;
import com.obe.filesexplorer.filehelper.EmptyDataListener;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ken on 2018/2/1.
 */

public class FileItemAdapter extends BaseAdapter{

    public FilesExplorerApplication mApp;
    public int mDisplayMode;
    public EmptyDataListener mEmptyListener;
    public Context mContext;
    public LayoutInflater mInflater;
    public List<BaseData> mFileList;
    public HashMap<Integer, Boolean> mSelectMap = new HashMap<>();

    public FileItemAdapter(Context context, List<BaseData> dataList){
        mContext = context;
        mFileList = dataList;
        mInflater = LayoutInflater.from(context);
        mApp = (FilesExplorerApplication)(mContext.getApplicationContext());
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return mFileList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public HashMap<Integer, Boolean> getSelectMap(){
        return  mSelectMap;
    }
}
