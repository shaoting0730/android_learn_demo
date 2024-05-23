package com.example.simple_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.simple_sql.bean.Student;
import com.example.simple_sql.util.ToastUtil;

public class UpdateActivity extends AppCompatActivity {
    private EditText etName,etNumber,etScore;
    private RadioButton rbMan,rbWoman;


    private com.example.simple_sql.MySQLiteOpenHelper mMySQLiteOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initView();
        mMySQLiteOpenHelper = new com.example.simple_sql.MySQLiteOpenHelper(this);
    }


    private void initView() {
        etName = findViewById(R.id.et_name);
        etNumber = findViewById(R.id.et_number);
        etScore = findViewById(R.id.et_score);
        rbMan = findViewById(R.id.rb_man);
        rbWoman = findViewById(R.id.rb_woman);

    }

    public void update(View view) {
        String name = etName.getText().toString().trim();
        String number = etNumber.getText().toString().trim();
        String score = etScore.getText().toString().trim();
        String gender = "";

        if (rbMan.isChecked()) {
            gender = "男";
        }

        if (rbWoman.isChecked()) {
            gender = "女";
        }

        Student student = new Student();
        student.setName(name);
        student.setNumber(number);
        student.setGender(gender);
        student.setScore(score);

        // 更新数据库
        long rowId = mMySQLiteOpenHelper.updateData(student);
        if (rowId > 0) {
            ToastUtil.toastShort(this, "更新成功！");
        } else {
            ToastUtil.toastShort(this, "没有数据被更新！");
        }
    }
}