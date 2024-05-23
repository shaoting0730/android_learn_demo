package com.example.simple_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.simple_sql.bean.Student;

import java.util.List;

public class QueryActivity extends AppCompatActivity {
    private EditText etName;
    private TextView tvResult;
    private com.example.simple_sql.MySQLiteOpenHelper mMySQLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        etName = findViewById(R.id.et_name);
        tvResult = findViewById(R.id.tv_result);
        mMySQLiteOpenHelper = new com.example.simple_sql.MySQLiteOpenHelper(this);
    }

    public void query(View view) {
        String name = etName.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            // 查询所有数据
            List<Student> students = mMySQLiteOpenHelper.queryAllFromDb();
            showData(students);
            return;
        }

        // 按姓名从数据库中查询
        List<Student> students = mMySQLiteOpenHelper.queryFromDbByName(name);
        showData(students);
    }

    private void showData(List<Student> students) {

//        String result = "";
//        for (Student stu : students) {
//            result = result +  "姓名：" + stu.getName() + "，学号：" + stu.getNumber() + ",性别："
//                    + stu.getGender() + ",分数：" + stu.getScore()+"\n";
//        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Student stu : students) {
            stringBuilder.append("姓名：");
            stringBuilder.append(stu.getName());
            stringBuilder.append("，学号：");
            stringBuilder.append(stu.getNumber());
            stringBuilder.append(",性别：");
            stringBuilder.append(stu.getGender());
            stringBuilder.append(",分数：");
            stringBuilder.append(stu.getScore() + "\n");
        }

        tvResult.setText(stringBuilder.toString());
    }


}