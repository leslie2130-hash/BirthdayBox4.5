package com.example.bottomnavigationdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.jaeger.library.StatusBarUtil;


public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //StatusBarUtil.setColor(this, getColor(R.color.toolbar_background_color), 0);
        StatusBarUtil.setColor(this, getColor(R.color.toolbar_background_color), 0);


    }










    }


