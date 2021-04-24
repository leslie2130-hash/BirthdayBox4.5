package com.example.bottomnavigationdemo.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bottomnavigationdemo.Gift;

import java.util.List;

public class GiftViewModel extends ViewModel {
    private GiftRepository repository;

    public GiftViewModel() { repository = new GiftRepository();
    }

    public MutableLiveData<List<Gift>> getList() {
        return repository.getList();
    }


}
