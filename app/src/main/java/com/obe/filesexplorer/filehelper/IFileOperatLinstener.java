package com.obe.filesexplorer.filehelper;

/**
 * Created by ken on 2018/2/1.
 *
 */

public  abstract interface IFileOperatLinstener {
    public abstract void onCreateNewDirectory(String dirName);

    public abstract void onDecompressSuccess(String paramString);

    public abstract void onDelFileSuccess(boolean paramBoolean, String paramString, long paramLong);

    public abstract void onIOperationFinish(int paramInt, String paramString);

    public abstract void onNoHideFile();

    public abstract void onPasteFileSuccess(boolean paramBoolean, String paramString, long paramLong);

    public abstract void onPasteProgressChange(String paramString1, String paramString2, long paramLong1, long paramLong2);

    public abstract void onRenameFileSuccess(String paramString1, String paramString2);
}
