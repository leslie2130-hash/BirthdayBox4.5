package com.example.bottomnavigationdemo.data;

import androidx.lifecycle.MutableLiveData;

import com.example.bottomnavigationdemo.Gift;

import java.util.ArrayList;
import java.util.List;

public class FakeDataSource {
    private MutableLiveData<List<Gift>> listMutableLiveData;
    private List<Gift> list;
    private Gift gift;

    public FakeDataSource() {
        listMutableLiveData = new MutableLiveData<>();
        list = new ArrayList<>();

        gift.setName("name");
        gift.setInfo("info");
        gift.setTitle("title");
        list.add(gift);

        listMutableLiveData.setValue(list);
    }

    public MutableLiveData<List<Gift>> getList() {
        return listMutableLiveData;
    }
}
