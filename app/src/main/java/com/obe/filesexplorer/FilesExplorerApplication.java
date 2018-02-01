package com.obe.filesexplorer;

import android.app.Application;
import android.content.SharedPreferences;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.impl.LimitedAgeDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import java.io.File;

/**
 * Created by ken on 2018/1/30.
 */

public class FilesExplorerApplication extends Application {
    private static FilesExplorerApplication mInstanc;

    private final static String DISPLAY_MODE = "DisplayMode";

    public SharedPreferences mSp;
    public DisplayImageOptions mVideoGridOptions;
    public DisplayImageOptions mVideoListOptions;
    public DisplayImageOptions mPictureOption;

    private ImageLoader mImageLoader;

    public static FilesExplorerApplication getInstanc(){
        return mInstanc;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstanc = this;
        initImageLoader();
    }

    private void initImageLoader(){
       File dir = getDir("imageLoader_cache",0).getAbsoluteFile();
       ImageLoaderConfiguration cfg = new ImageLoaderConfiguration
                .Builder(getApplicationContext())
                .memoryCacheExtraOptions(600, 800)
                .denyCacheImageMultipleSizesInMemory()
                .threadPoolSize(3)
                .threadPriority(4)
                .diskCache(new LimitedAgeDiskCache((File) dir, 172800L))
                .memoryCache(new LruMemoryCache(67108864))
                .memoryCacheSize(33554432)
                .memoryCacheSizePercentage(13)
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .imageDownloader(new BaseImageDownloader(this, 2000, 5000))
                .build();

       mImageLoader = ImageLoader.getInstance();
       mImageLoader.init(cfg);
       mVideoGridOptions = new DisplayImageOptions.Builder()
               .showImageOnLoading(2130837561)
               .showImageOnFail(2130837561)
               .showImageForEmptyUri(2130837561)
               .bitmapConfig(Bitmap.Config.RGB_565)
               .imageScaleType(ImageScaleType.EXACTLY)
               .displayer(new RoundedBitmapDisplayer(8))
               .cacheInMemory(true)
               .cacheOnDisk(true)
               .build();
       mVideoListOptions = new DisplayImageOptions.Builder()
               .showImageOnLoading(2130837561)
               .showImageOnFail(2130837561)
               .showImageForEmptyUri(2130837561)
               .bitmapConfig(Bitmap.Config.RGB_565)
               .imageScaleType(ImageScaleType.EXACTLY)
               .displayer(new RoundedBitmapDisplayer(2))
               .cacheInMemory(true)
               .cacheOnDisk(true)
               .build();
       mPictureOption = new DisplayImageOptions.Builder()
               .showImageOnLoading(2130837565)
               .showImageOnFail(2130837565)
               .showImageForEmptyUri(2130837565)
               .bitmapConfig(Bitmap.Config.RGB_565)
               .imageScaleType(ImageScaleType.EXACTLY)
               .cacheInMemory(true)
               .cacheOnDisk(true)
               .build();
    }

    public int getDisplayMode(){
       return mSp.getInt(DISPLAY_MODE,0);
    }

    public void seetDisplayMode(int displayMode){
        SharedPreferences.Editor ed = mSp.edit();
        ed.putInt(DISPLAY_MODE,displayMode);
        ed.commit();
    }
}
