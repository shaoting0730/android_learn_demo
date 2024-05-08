package com.example.firstapp.api;

import android.content.Context;
import android.util.Log;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class Api {
    private static OkHttpClient client;
    private static  String requestUrl;
    private static HashMap<String,Object> mParams;
    public static Api api = new Api();

    public  Api(){}

    public  static  Api config(String url, HashMap<String, Object> params){
        client = new OkHttpClient();
        requestUrl = ApiConfig.BASE_URL + url;
        mParams = params;
        return  api;
    }

    public void postRequest(Context context, ApiCallback callback){
        JSONObject jsonObject = new JSONObject(mParams);
        String jsonStr = jsonObject.toString();
        RequestBody requestBodyJson =
                RequestBody.create(MediaType.parse("application/json;charset=utf-8")
                        , jsonStr);
        //第三步创建Rquest
        Request request = new Request.Builder()
                .url(requestUrl)
                .addHeader("contentType", "application/json;charset=UTF-8")
                .post(requestBodyJson)
                .build();
        //第四步创建call回调对象
        final Call call = client.newCall(request);
        //第五步发起请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.e("onFailure",e.getMessage());
                callback.onFailure(e);
            }
            @Override
            public void onResponse(Response response) throws IOException {
              Log.e("onSuccess","成功了");
              callback.onSuccess(response.body().string());
            }
        });
    }
}
