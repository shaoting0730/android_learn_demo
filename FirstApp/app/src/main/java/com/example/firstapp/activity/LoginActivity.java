package com.example.firstapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstapp.R;
import com.example.firstapp.util.StringUtils;

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
    }
}