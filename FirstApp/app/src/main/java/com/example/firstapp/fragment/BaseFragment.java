package com.example.firstapp.fragment;


import static android.content.Context.MODE_PRIVATE;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Nullable;

public abstract class BaseFragment extends Fragment {
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

    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    public void showToastSync(String msg) {
        Looper.prepare();
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    public void navigateTo(Class cls) {
        Intent in = new Intent(getActivity(), cls);
        startActivity(in);
    }

    public void navigateToWithBundle(Class cls, Bundle bundle) {
        Intent in = new Intent(getActivity(), cls);
        in.putExtras(bundle);
        startActivity(in);
    }

    protected void insertVal(String key, String val) {
        SharedPreferences sp = getActivity().getSharedPreferences("sp_ttit", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, val);
        editor.commit();
    }

    protected String findByKey(String key) {
        SharedPreferences sp = getActivity().getSharedPreferences("sp_ttit", MODE_PRIVATE);
        return sp.getString(key, "");
    }

}