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

    public void add(Contact contact) {
        //friendDataSource.add(contact);
    }

    public void delete(int index) {
      //  friendDataSource.delete(index);
    }

    public void modify(int index, Contact contact) {
        //friendDataSource.modify(index, contact);
    }

    public MutableLiveData<List<Friend>> getList() {
        return friendDataSource.getListMutableLiveData();
    }
}
