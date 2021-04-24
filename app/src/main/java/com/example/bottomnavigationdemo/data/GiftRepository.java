package com.example.bottomnavigationdemo.data;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

import com.example.bottomnavigationdemo.Gift;

public class GiftRepository {
    private FakeDataSource fakeDataSource;

    public MutableLiveData<List<Gift>> getList() {
        return fakeDataSource.getList();

    }
}