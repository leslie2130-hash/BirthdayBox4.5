package com.example.bottomnavigationdemo.Useless;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class CardRepository {
    private CardDataSource cardDataSource;

    public CardRepository() {
        cardDataSource = new CardDataSource();
    }

    public void add(Card card) {
        cardDataSource.add(card);
    }

    public MutableLiveData<List<Card>> getList() {
        return cardDataSource.getList();
    }
}
