package com.example.simple_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.simple_sql.bean.Student;
import com.example.simple_sql.util.ToastUtil;

public class InsertActivity extends AppCompatActivity {

    private EditText etName,etNumber,etScore;
    private RadioButton rbMan,rbWoman;


    private MySQLiteOpenHelper mMySQLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        initView();
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(this);

    }

    private void initView() {
        etName = findViewById(R.id.et_name);
        etNumber = findViewById(R.id.et_number);
        etScore = findViewById(R.id.et_score);
        rbMan = findViewById(R.id.rb_man);
        rbWoman = findViewById(R.id.rb_woman);

    }

    public void insert(View view) {
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

        // 插入数据库中
        long rowId = mMySQLiteOpenHelper.insertData(student);
        if (rowId != -1) {
            ToastUtil.toastShort(this, "添加成功！");
        } else {
            ToastUtil.toastShort(this, "添加失败！");
        }

    }
}