package com.example.simple_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insertData(View view) {
        Intent intent = new Intent(this, com.example.simple_sql.InsertActivity.class);
        startActivity(intent);
    }

    public void deleteData(View view) {
        Intent intent = new Intent(this, com.example.simple_sql.DeleteActivity.class);
        startActivity(intent);
    }


    public void updateData(View view) {
        Intent intent = new Intent(this, UpdateActivity.class);
        startActivity(intent);
    }

    public void queryData(View view) {
        Intent intent = new Intent(this, QueryActivity.class);
        startActivity(intent);
    }
}