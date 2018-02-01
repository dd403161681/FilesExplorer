package com.obe.filesexplorer.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ken on 2018/2/1.
 */

public class CategoryFileUtils {
    public static List<String> apkTypeList =new ArrayList();
    public static List<String> audioTypeList = new ArrayList();
    public static List<String> pictureTypeList = new ArrayList();
    public static List<String> textList = new ArrayList();
    public static List<String> videoTypeList = new ArrayList();

    static
    {
        videoTypeList.add(".avi");
        videoTypeList.add(".asf");
        videoTypeList.add(".wmv");
        videoTypeList.add(".m2t");
        videoTypeList.add(".mts");
        videoTypeList.add(".ts");
        videoTypeList.add(".mpg");
        videoTypeList.add(".m2p");
        videoTypeList.add(".mp4");
        videoTypeList.add(".flv");
        videoTypeList.add(".swf");
        videoTypeList.add(".vob");
        videoTypeList.add(".mkv");
        videoTypeList.add(".divx");
        videoTypeList.add(".xvid");
        videoTypeList.add(".mov");
        videoTypeList.add(".rmvb");
        videoTypeList.add(".rv");
        videoTypeList.add(".3gp");
        videoTypeList.add(".3g2");
        videoTypeList.add(".pmp");
        videoTypeList.add(".tp");
        videoTypeList.add(".trp");
        videoTypeList.add(".rm");
        videoTypeList.add(".webm");
        videoTypeList.add(".m2ts");
        videoTypeList.add(".ssif");
        videoTypeList.add(".mpeg");
        videoTypeList.add(".mpe");
        videoTypeList.add(".m3u8");
        videoTypeList.add(".m4v");
        videoTypeList.add(".xv");

        audioTypeList.add(".mp3");
        audioTypeList.add(".wma");
        audioTypeList.add(".aac");
        audioTypeList.add(".ogg");
        audioTypeList.add(".pcm");
        audioTypeList.add(".m4a");
        audioTypeList.add(".ac3");
        audioTypeList.add(".wav");
        audioTypeList.add(".ape");
        audioTypeList.add(".flac");
        audioTypeList.add(".midi");
        audioTypeList.add(".mid");

        pictureTypeList.add(".jpeg");
        pictureTypeList.add(".jpg");
        pictureTypeList.add(".png");
        pictureTypeList.add(".bmp");
        pictureTypeList.add(".gif");

        apkTypeList.add(".apk");

        textList.add(".txt");
    }

    public static boolean isApkFile(String fileSuffix)
    {
        boolean ret = false;

        if ((fileSuffix != null) && (fileSuffix != "")){
            if(apkTypeList.contains(fileSuffix)){
                ret = true;
            }
        }

        return ret;
    }

    public static boolean isAudioFile(String fileSuffix)
    {
        boolean ret = false;

        if ((fileSuffix != null) && (fileSuffix != "")){
            if(audioTypeList.contains(fileSuffix)){
                ret = true;
            }
        }

        return ret;
    }

    public static boolean isPictureFile(String fileSuffix)
    {
        boolean ret = false;

        if ((fileSuffix != null) && (fileSuffix != "")){
            if(pictureTypeList.contains(fileSuffix)){
                ret = true;
            }
        }

        return ret;
    }

    public static boolean isVideoFile(String fileSuffix)
    {
        boolean ret = false;

        if ((fileSuffix != null) && (fileSuffix != "")){
            if(videoTypeList.contains(fileSuffix)){
                ret = true;
            }
        }

        return ret;
    }
}
