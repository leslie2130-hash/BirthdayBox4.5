package com.example.bottomnavigationdemo;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class FakeDataSource {
    private MutableLiveData<List<Contact>> listMutableLiveData;
    private List<Contact> list;

    public FakeDataSource() {
        listMutableLiveData = new MutableLiveData<>();
        list = new ArrayList<>();
        listMutableLiveData.setValue(list);
    }

    public void add(Contact contact) {
        list.add(contact);
        listMutableLiveData.postValue(list);
    }

    public void delete(int index) {
        if (list.size() < index) {
            return;
        }
        list.remove(index);
        listMutableLiveData.setValue(list);
    }

    public void modify(int index, Contact contact) {
        if (list.size() < index) {
            return;
        }
        list.set(index, contact);
        listMutableLiveData.setValue(list);
    }

    public MutableLiveData<List<Contact>> getList() {
        return listMutableLiveData;
    }
}
