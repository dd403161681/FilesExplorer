package com.obe.filesexplorer.fragment;

import android.widget.AdapterView;
import android.widget.TextView;

import com.obe.filesexplorer.FilesExplorerApplication;
import com.obe.filesexplorer.datamodel.EmptyDataListener;
import com.obe.filesexplorer.viewadapter.FileDetailAdapter;

/**
 * Created by ken on 2018/2/1.
 */

public abstract class FileCategoryFragment extends FileOperationFragment implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener, EmptyDataListener{

    public FilesExplorerApplication mApp;

    public TextView mEmptyText;
    public FileDetailAdapter mGridAdapter;

}
