package com.example.simple_tab4.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.List;

public class MyFragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentsList;

    public MyFragmentAdapter(@NonNull FragmentManager fragmentManager,
                             List<Fragment> fragmentsList) {
        super(fragmentManager);
        this.mFragmentsList = fragmentsList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentsList == null ? null : mFragmentsList.get(position) ;
    }


    @Override
    public int getCount() {
        return mFragmentsList == null ? 0 : mFragmentsList.size();
    }
}
