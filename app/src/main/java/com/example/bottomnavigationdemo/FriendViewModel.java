package com.example.bottomnavigationdemo;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bottomnavigationdemo.data.Friend;

public class FriendViewModel extends ViewModel {
    private FriendRepository repository;
    private MutableLiveData<Boolean> result = new MutableLiveData<>();


    public FriendViewModel() { repository = new FriendRepository();
    }

    public void add(Friend friend) {

        repository.add(friend);
    }

    public void delete(int index, Friend friend) {

        repository.delete(index, friend);
    }

    public void modify(int index, Friend friend) {
        repository.modify(index, friend);
    }

    public MutableLiveData<List<Friend>> getList() {

        return repository.getList();
    }

    public MutableLiveData<Boolean> getResult() {

        return result;
    }
}
