package com.example.firstapp.fragment;
import static android.content.Context.MODE_PRIVATE;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;


public abstract class BaseFragment extends Fragment {

    protected View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(initLayout(), container, false);
        initView();
        initData();
        return mRootView;
    }

    protected abstract void initData();
    protected abstract int initLayout();
    protected abstract void initView();

    public void navigateToWithFlag(Class cls, int flags) {
        Intent in = new Intent(getActivity(), cls);
        in.setFlags(flags);
        startActivity(in);
    }

    protected void removeByKey(String key) {
        SharedPreferences sp = getActivity().getSharedPreferences("shao_ting",
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
        SharedPreferences sp = getActivity().getSharedPreferences("shao_ting", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, val);
        editor.commit();
    }

    protected String findByKey(String key) {
        SharedPreferences sp = getActivity().getSharedPreferences("shao_ting", MODE_PRIVATE);
        return sp.getString(key, "");
    }

}