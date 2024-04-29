package com.example.simper_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.tv);
        Button button = findViewById(R.id.bt);

        // Handler 是Android中提供的处理消息处理的机制
        final Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message message) {
                if (message.sendingUid == 0x123) {
                    textView.setText(message.obj.toString());
                }
                return  true;
            };
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 开启一个子线程Thread，做耗时操作
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // 不允许在子线程中修改UI
//                        textView.setText("修改文字");
                        // 通过Handler发送消息给主线程，让主线程去修改
                        Message message = new Message();
                        message.sendingUid = 0x123;
                        message.obj = "修改文字";
                        handler.sendMessage(message);
                    }
                });
                thread.start();
            }
        });
    }
}