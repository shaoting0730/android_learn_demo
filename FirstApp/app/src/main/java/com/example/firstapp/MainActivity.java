package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.firstapp.activity.BaseActivity;
import com.example.firstapp.activity.LoginActivity;
import com.example.firstapp.activity.RegisterActivity;
import com.example.firstapp.activity.TabBarActivity;
import com.example.firstapp.util.StringUtils;

public class MainActivity extends BaseActivity {

    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void initData() {
        boolean tag = StringUtils.isEmpty(findByKey("token"));
        if (!tag) {
            // 登录状态
            navigateTo(TabBarActivity.class);
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(LoginActivity.class);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo(RegisterActivity.class);
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
    }
}