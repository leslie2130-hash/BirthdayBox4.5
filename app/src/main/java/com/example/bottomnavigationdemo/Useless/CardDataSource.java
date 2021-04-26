package com.example.bottomnavigationdemo.Useless;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class CardDataSource {
    private MutableLiveData<List<Card>> listMutableLiveData;
    private List<Card> list;

    public CardDataSource() {
        listMutableLiveData = new MutableLiveData<>();
        list = new ArrayList<>();
        listMutableLiveData.setValue(list);
    }

    public void add(Card card) {
        list.add(card);
        listMutableLiveData.postValue(list);
    }

    public MutableLiveData<List<Card>> getList() {
        return listMutableLiveData;
    }
}
