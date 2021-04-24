package com.example.bottomnavigationdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bottomnavigationdemo.databinding.FragmentBox1Binding;
import com.example.bottomnavigationdemo.databinding.FragmentBoxBinding;
import com.example.bottomnavigationdemo.data.GiftViewModel;
import com.example.bottomnavigationdemo.data.GiftAdapter;

import java.util.List;

/*public class BoxFragment extends Fragment {
    private GiftAdapter adapter;
    private GiftViewModel model;
    private FragmentBoxBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBoxBinding.inflate(inflater, container, false);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        model = new ViewModelProvider(requireActivity()).get(GiftViewModel.class);
        Log.i("test", "box 1");

        adapter = new GiftAdapter(model);
        binding.recyclerView.setAdapter(adapter);
        Log.i("test", "box 2");

        model.getList().getValue();

        model.getList().observe(getViewLifecycleOwner(), new Observer<List<Gift>>() {
            @Override
            public void onChanged(List<Gift> gift) {
                adapter.notifyDataSetChanged();
            }
        });





        return binding.getRoot();
    }


}*/
public class BoxFragment extends Fragment {
    private FragmentBox1Binding binding;
    private GiftAdapter adapter;
    private GiftViewModel model;



    public static BoxFragment newInstance() {
        return new BoxFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentBox1Binding.inflate(inflater, container, false);
        //binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Log.i("test", "box 1");

        adapter = new GiftAdapter();
        binding.recyclerView.setAdapter(adapter);

        //boxBinding.recyclerView.setAdapter(new BoxAdapter());
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(
                new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));
        Log.i("test", "box 2");


        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}