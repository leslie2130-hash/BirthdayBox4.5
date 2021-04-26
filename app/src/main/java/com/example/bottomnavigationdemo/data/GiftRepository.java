package com.example.bottomnavigationdemo.data;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class GiftRepository {
    private GiftDataSource giftDataSource;

    public MutableLiveData<List<Gift>> getList() {
        return giftDataSource.getList();

    }
}