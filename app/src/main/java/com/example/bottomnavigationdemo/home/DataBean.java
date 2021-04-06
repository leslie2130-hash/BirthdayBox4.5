package com.example.bottomnavigationdemo.home;

import com.example.bottomnavigationdemo.R;

import java.util.ArrayList;
import java.util.List;

public class DataBean {
    public Integer imageRes;

    public DataBean(Integer imageRes) {
        this.imageRes = imageRes;
    }


    public static List<DataBean> getTestData() {
        List<DataBean> list = new ArrayList<>();
        list.add(new DataBean(R.drawable.test1));
        list.add(new DataBean(R.drawable.test2));
        list.add(new DataBean(R.drawable.test3));
        list.add(new DataBean(R.drawable.test4));
        return list;
    }
}

