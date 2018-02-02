package com.obe.filesexplorer.filehelper;

/**
 * Created by ken on 2018/2/2.
 */

public class FileInfo {
    public int Count;
    public boolean IsDir;
    public long ModifiedDate;
    public boolean canRead;
    public boolean canWrite;
    public String fileName;
    public String filePath;
    public long fileSize;
    public boolean isHidden;

    public int childDir;
    public int childFile;
}
