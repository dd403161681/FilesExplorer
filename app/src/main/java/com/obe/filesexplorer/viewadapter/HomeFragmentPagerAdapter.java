package com.obe.filesexplorer.viewadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.obe.filesexplorer.fragment.FileOperationFragment;

import java.util.List;

/**
 * Created by ken on 2018/2/1.
 */

public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    private FragmentManager mFragmentManager;
    private List<FileOperationFragment> mFragmentList;

    public HomeFragmentPagerAdapter(FragmentManager fm, List<FileOperationFragment> list){
        super(fm);
        mFragmentManager = fm;
        mFragmentList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
