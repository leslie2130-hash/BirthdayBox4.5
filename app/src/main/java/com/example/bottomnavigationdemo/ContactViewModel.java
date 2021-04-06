package com.example.bottomnavigationdemo;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {
    private ContactRepository repository;

    public ContactViewModel() { repository = new ContactRepository();
    }

    public void add(Contact contact) {
        repository.add(contact);
    }

    public void delete(int index) {
        repository.delete(index);
    }

    public void modify(int index, Contact contact) {
        repository.modify(index, contact);
    }

    public MutableLiveData<List<Contact>> getList() {
        return repository.getList();
    }
}
