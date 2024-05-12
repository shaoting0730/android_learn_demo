package com.example.firstapp.fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.firstapp.R;
import com.example.firstapp.activity.LoginActivity;
import com.example.firstapp.fragment.BaseFragment;

public class MineFragment extends BaseFragment {
    Button button;


    @Override
    protected void initData() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeByKey("token");
                navigateToWithFlag(LoginActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        button = mRootView.findViewById(R.id.btn_logout);
    }
}