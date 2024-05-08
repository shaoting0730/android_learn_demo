package com.example.firstapp.api;

public interface ApiCallback {
    void onSuccess(String res);
    void onFailure(Exception e);
}
