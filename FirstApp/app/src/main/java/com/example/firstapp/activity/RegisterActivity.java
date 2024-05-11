package com.example.firstapp.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firstapp.R;
import com.example.firstapp.api.Api;
import com.example.firstapp.api.ApiCallback;
import com.example.firstapp.util.StringUtils;

import java.util.HashMap;

public class RegisterActivity extends BaseActivity {

    private EditText etAccount;
    private EditText etPsw;
    private EditText etPswAgain;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etAccount = findViewById(R.id.et_account);
        etPsw = findViewById(R.id.et_psw);
        etPswAgain = findViewById(R.id.et_psw_again);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = etAccount.getText().toString().trim();
                String psw = etPsw.getText().toString().trim();
                String pswAgain = etPswAgain.getText().toString().trim();
                register(account,psw,pswAgain);
            }
        });
    }

    @Override
    protected void initData() {

    }

    private void register(String account,String pwd,String pswAgain) {
        if (StringUtils.isEmpty(account)) {
            showToast("请输入账号");
            return;
        }
        if (StringUtils.isEmpty(pwd)) {
            showToast("请输入密码");
            return;
        }
        if (StringUtils.isEmpty(pswAgain)) {
            showToast("请再次输入密码");
            return;
        }
        if(!pwd.trim().equals(pswAgain.trim())){
            showToast("两次密码不同");
            return;
        }
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("mobile",account);
        params.put("password",pwd);
        Api.config("post",params).postRequest(this, new ApiCallback() {
            @Override
            public void onSuccess(String res) {
                navigateTo(LoginActivity.class);
                showToastSync("注册成功，请登录");
            }

            @Override
            public void onFailure(Exception e) {
                Log.i("失败", "onFail: "+e);
            }
        });


    }

}