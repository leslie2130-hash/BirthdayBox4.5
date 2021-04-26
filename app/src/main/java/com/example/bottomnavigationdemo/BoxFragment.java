package com.example.bottomnavigationdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bottomnavigationdemo.databinding.FragmentBoxBinding;
import com.example.bottomnavigationdemo.data.GiftViewModel;
import com.example.bottomnavigationdemo.data.GiftAdapter;

import java.util.List;

public class BoxFragment extends Fragment {
    private FragmentBoxBinding binding;
    private GiftAdapter adapter;
    private GiftViewModel model;

    public static BoxFragment newInstance() {
        return new BoxFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentBoxBinding.inflate(inflater, container, false);

        adapter = new GiftAdapter();
        binding.recyclerView.setAdapter(adapter);

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(
                new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}