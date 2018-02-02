package com.obe.filesexplorer.fragment;

import android.animation.ObjectAnimator;
import android.view.View;

import com.obe.filesexplorer.filehelper.IFileOperatLinstener;

/**
 * Created by ken on 2018/2/1.
 */

public abstract class FileOperationFragment extends BaseFragment
    implements IFileOperatLinstener {
    private final static String TAG = "FileOperationFragment";

    public String mCurPath;
    public boolean isActive = false;
    public String mRootPath;

    public void alphaAnimRun(View view){
        float[] an = {0.0F, 1.0F};
        ObjectAnimator.ofFloat(view,"alpha", an).setDuration(200L).start();
    }

    public boolean getChooseMode(){
        return false;
    }

    public String getCurPath(){
        return null;
    }


    public void operationFile(int index){


    }
}
