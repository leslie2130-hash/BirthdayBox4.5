package com.example.bottomnavigationdemo;

import androidx.lifecycle.MutableLiveData;

import com.example.bottomnavigationdemo.data.Friend;
import com.example.bottomnavigationdemo.data.FriendDataSource;

import java.util.List;

public class FriendRepository {
    private FriendDataSource friendDataSource;

    public FriendRepository() {
        friendDataSource = new FriendDataSource();
        friendDataSource.getAll();
    }

    public void add(Friend friend) {
        friendDataSource.add(friend);
    }

    public void delete(int index, Friend friend) {
        friendDataSource.delete(index,friend);
    }

    public void modify(int index, Friend friend) {

        friendDataSource.modify(index, friend);
    }

    public MutableLiveData<List<Friend>> getList() {
        return friendDataSource.getListMutableLiveData();
    }
}
