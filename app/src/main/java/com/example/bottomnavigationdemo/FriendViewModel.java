package com.example.bottomnavigationdemo;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bottomnavigationdemo.data.Friend;

public class FriendViewModel extends ViewModel {
    private FriendRepository repository;

    public FriendViewModel() { repository = new FriendRepository();
    }

    public void add(Friend friend) {
        repository.add(friend);
    }

    public void delete(int index) {
        repository.delete(index);
    }

    public void modify(int index, Contact contact) {
        repository.modify(index, contact);
    }

    public MutableLiveData<List<Friend>> getList() {
        return repository.getList();
    }
}
