package com.example.simper_looper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class LooperThread extends  Thread {
   public Handler handler;

    @Override
    public void run() {
        super.run();
        Looper.prepare(); // 舒适化Looper对象
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message message) {
                Log.i("shaoting", "handleMessage: "+ message.what);
                return true;
            }
        });
        Message message = handler.obtainMessage();
        message.what = 0x007;
        handler.sendMessage(message);
        Looper.loop();  // 启动Looper
    }
}
