package com.obe.filesexplorer.viewadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ken on 2018/2/1.
 */

public class ViewHolder {
    private View mConvertView;
    private final SparseArray<View> mViews;
    private int mPosition;

    private ViewHolder(Context context, ViewGroup parent, int layoutId,
                       int position){
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        //setTag
        mConvertView.setTag(this);
        mPosition = position;
    }

    public static ViewHolder getViewHolder(Context context, View convertView,
                                           ViewGroup parent, int layoutId, int position) {
        if(convertView  == null){
            return new ViewHolder(context,parent,layoutId,position);
        }
        return (ViewHolder) convertView.getTag();
    }

    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if(null == view){
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return  (T)view;
    }

    public View getConvertView(){
        return mConvertView;
    }

    public ViewHolder setText(int viewId, String text,int color){
        TextView view = getView(viewId);
        view.setText(text);
        view.setTextColor(color);
        return this;
    }

    public ViewHolder setImageResource(int viewId, int drawableId){
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    public ViewHolder setImageBitmap(int viewId, Bitmap bmp){
        ImageView view = getView(viewId);
        view.setImageBitmap(bmp);
        return  this;
    }

    public int getPosition(){
        return  mPosition;
    }
}
