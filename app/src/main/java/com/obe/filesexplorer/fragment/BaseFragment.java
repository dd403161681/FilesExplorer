package com.obe.filesexplorer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;

/**
 * Created by ken on 2018/1/31.
 */

public class BaseFragment extends Fragment {

//    protected IBackHandledInterface mBackHandledInterface;
    public AdapterView.OnItemSelectedListener onItemSelectedListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(!(getActivity() instanceof IBackHandledInterface))
//            throw new ClassCastException("Hosting Activity must implement BackHandledInterface");

//        mBackHandledInterface = (IBackHandledInterface)getActivity();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
