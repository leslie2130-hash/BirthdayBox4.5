package com.example.bottomnavigationdemo;

import android.app.Application;

import cn.leancloud.AVOSCloud;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this, "lxGT84e1jcdQE1tAiV4BdOms-gzGzoHsz", "NhGONny3lAW9EoeI8Kl9CMes", "https://lxgt84e1.lc-cn-n1-shared.com");
    }
}
