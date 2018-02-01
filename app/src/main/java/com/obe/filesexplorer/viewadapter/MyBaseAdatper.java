package com.obe.filesexplorer.viewadapter;

import android.content.Context;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by ken on 2018/2/1.
 */

public abstract class MyBaseAdatper<T> extends BaseAdapter {

    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDataList;

    protected int mItemLayoutId;

    public MyBaseAdatper(Context context, List<T> dataList, int itemLayoutId){
        mContext =context;
        mInflater = LayoutInflater.from(context);
        mDataList = dataList;
        mItemLayoutId = itemLayoutId;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public T getItem(int i) {
        return mDataList.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final  ViewHolder viewHolder = getViewHolder(position, convertView, parent);
        convert(viewHolder,getItem(position));
        return viewHolder.getConvertView();
    }

    public abstract void convert(ViewHolder holder, T item);

    private ViewHolder getViewHolder(int position, View convertView,
                                     ViewGroup parent){
            return ViewHolder.getViewHolder(mContext,convertView,parent,mItemLayoutId,position);
    }
}
