package com.example.firstapp.fragment;


import static android.content.Context.MODE_PRIVATE;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;

public class BaseFragment extends Fragment {

    public void navigateToWithFlag(Class cls, int flags) {
        Intent in = new Intent(getActivity(), cls);
        in.setFlags(flags);
        startActivity(in);
    }

    protected void removeByKey(String key) {
        SharedPreferences sp = getActivity().getSharedPreferences("shaoting",
                MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.remove(key);
        edit.commit();
    }

}