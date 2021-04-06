package com.example.bottomnavigationdemo;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ContactRepository {
    private FakeDataSource fakeDataSource;

    public ContactRepository() {
        fakeDataSource = new FakeDataSource();
    }

    public void add(Contact contact) {
        fakeDataSource.add(contact);
    }

    public void delete(int index) {
        fakeDataSource.delete(index);
    }

    public void modify(int index, Contact contact) {
        fakeDataSource.modify(index, contact);
    }

    public MutableLiveData<List<Contact>> getList() {
        return fakeDataSource.getList();
    }
}
