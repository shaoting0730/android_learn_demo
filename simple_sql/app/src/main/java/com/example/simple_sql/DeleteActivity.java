package com.example.simple_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.simple_sql.util.ToastUtil;

public class DeleteActivity extends AppCompatActivity {

    private EditText etName;
    private MySQLiteOpenHelper mMySQLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        etName = findViewById(R.id.et_name);
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(this);
    }

    public void delete(View view) {

        String name = etName.getText().toString().trim();

        // 按姓名从数据库中删除

        int row = mMySQLiteOpenHelper.deleteFromDbByName(name);
        if (row > 0) {
            ToastUtil.toastLong(this, "删除成功,删了" + row + "条数据");
        }else{
            ToastUtil.toastLong(this, "删除失败,没有找到符合条件的数据");
        }
    }
}