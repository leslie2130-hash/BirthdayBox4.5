package com.example.bottomnavigationdemo;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bottomnavigationdemo.data.GiftAdapter;
import com.example.bottomnavigationdemo.data.GiftViewModel;
import com.example.bottomnavigationdemo.data.Reminder;
import com.example.bottomnavigationdemo.data.ReminderAdapter;
import com.example.bottomnavigationdemo.databinding.FragmentBoxBinding;
import com.example.bottomnavigationdemo.databinding.ReminderCellBinding;
import com.example.bottomnavigationdemo.databinding.ReminderFragmentBinding;

public class ReminderFragment extends Fragment {
    private ReminderFragmentBinding binding;
    private ReminderAdapter adapter;
    private ReminderViewModel mViewModel;

    public static ReminderFragment newInstance() {
        return new ReminderFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ReminderFragmentBinding.inflate(inflater, container, false);

        adapter = new ReminderAdapter();
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