package com.example.bottomnavigationdemo.Useless;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class CardViewModel extends ViewModel {
    private CardRepository cardrepository;

    public CardViewModel() { cardrepository = new CardRepository();
    }

    public MutableLiveData<List<Card>> getList() {
        return cardrepository.getList();
    }
}
