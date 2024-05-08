package com.example.firstapp.activity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstapp.R;
import com.example.firstapp.api.Api;
import com.example.firstapp.api.ApiCallback;
import com.example.firstapp.util.StringUtils;

import java.util.HashMap;

public class LoginActivity extends BaseActivity {

    private EditText etAccount;
    private EditText etPsw;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etAccount = findViewById(R.id.et_account);
        etPsw = findViewById(R.id.et_psw);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = etAccount.getText().toString().trim();
                String pwd = etPsw.getText().toString().trim();
                login(account, pwd);
            }
        });
    }

    private void login(String account, String pwd) {
        if (StringUtils.isEmpty(account)) {
//            Toast.makeText(this, "请输入账号", Toast.LENGTH_LONG).show();
            showToast("请输入账号");
            return;
        }
        if (StringUtils.isEmpty(pwd)) {
//            Toast.makeText(this, "请输入密码", Toast.LENGTH_LONG).show();
            showToast("请输入密码");
            return;
        }
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("mobile",account);
        params.put("password",pwd);
        Api.config("post",params).postRequest(this, new ApiCallback() {
            @Override
            public void onSuccess(String res) {
//                showToastSync(res);
                Log.i("成功", "onSuccess: "+res);
                saveStringToSp("'token'","token_value");
            }

            @Override
            public void onFailure(Exception e) {
                Log.i("失败", "onFail: "+e);
            }
        });
    }
}