package com.obe.filesexplorer.viewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.obe.filesexplorer.FilesExplorerApplication;
import com.obe.filesexplorer.datamodel.BaseData;
import com.obe.filesexplorer.datamodel.EmptyDataListener;
import com.obe.filesexplorer.utils.LogFile;
import com.obe.filesexplorer.view.ObeCheckbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ken on 2018/1/30.
 */

public class VideoGridDetailAdapter extends BaseAdapter {
    private final static String TAG = VideoGridDetailAdapter.class.getSimpleName();

    private Context mContext;
    private LayoutInflater mLayoutInfater;

    private List<BaseData>  mAllList;
    private List<BaseData> mFileList = new ArrayList<>();
    private List<BaseData> mHistoryList ;
    private List<BaseData> mRecentList;

    private FilesExplorerApplication mApp;
    private DisplayModeChangeListener mDisplayModeChangeListener;
    private EmptyDataListener mEmptyDataListener;

    private HashMap<Integer, Boolean> mSelectMap = new HashMap<>();
    private int[] mDataInfo = new int[3];

    public int mDisplayMode;
    public boolean mIsSelect = false;

    public VideoGridDetailAdapter(Context context, DisplayModeChangeListener displayModeChangeListener){
        mContext = context;
        mDisplayModeChangeListener = displayModeChangeListener;
        mLayoutInfater = LayoutInflater.from(mContext);
        mApp = (FilesExplorerApplication)mContext.getApplicationContext();
    }

    private void initGridVideoData(List<BaseData> historyList, List<BaseData> recentList, List<BaseData> allList){

    }

    public void clear(){
        mFileList.clear();
    }

    public HashMap<Integer, Boolean> getSelectMap(){
        return  mSelectMap;
    }

    public boolean getSelectedMode(){
        return mIsSelect;
    }

    @Override
    public int getCount() {
        mDisplayMode = mApp.getDisplayMode();
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

    public void setData(List<BaseData> historyList, List<BaseData> recentList, List<BaseData> allList){
        mHistoryList = historyList;
        mRecentList = recentList;
        mAllList = allList;

        LogFile.LOGD(TAG,"VideoGridDetailAdapter>>>>>>>>>>>");
        initGridVideoData(mHistoryList,mRecentList,mAllList);
        if(mDisplayModeChangeListener != null){
            mDisplayModeChangeListener.onDisplayModeChanged(mDataInfo);
        }
    }

    public void setmEmptyDataListener(EmptyDataListener listener){
        mEmptyDataListener = listener;
    }

    public void setSelectedMode(boolean isSelect){
        LogFile.LOGD(TAG,"setSelectedMode is "+isSelect);
        if(mIsSelect != isSelect){
            mIsSelect =isSelect;
            mSelectMap.clear();
            notifyDataSetChanged();
        }
    }

    public static abstract interface DisplayModeChangeListener{
        public abstract void onDisplayModeChanged(int[] datainfo);
    }

    class ViewHolder{
        public TextView mFileName;
        public ImageView mFileVideo;
        public TextView mHeadTitle;
        public ObeCheckbox mCheckbox;
        public ImageView mVideoIcon;

        ViewHolder(){

        }
    }
}
