package com.example.bottomnavigationdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bottomnavigationdemo.data.homeCardAdapter;
import com.example.bottomnavigationdemo.data.homeCardViewModel;
import com.example.bottomnavigationdemo.databinding.FragmentHome1Binding;
import com.example.bottomnavigationdemo.home.DataBean;
import com.example.bottomnavigationdemo.home.ImageAdapter;
import com.youth.banner.indicator.CircleIndicator;


public class HomeFragment extends Fragment {
    private FragmentHome1Binding binding;
    private homeCardAdapter adapter;
    private homeCardViewModel mViewModel;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHome1Binding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        binding.banner.addBannerLifecycleObserver(this)
                .setAdapter(new ImageAdapter(DataBean.getTestData()))
                .setIndicator(new CircleIndicator(getContext()));
        /*binding.banner2.addBannerLifecycleObserver(this)
                .setAdapter(new ImageAdapter(DataBean.getTestData()))
                .setIndicator(new CircleIndicator(getContext()));*/

        adapter = new homeCardAdapter();
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setHasFixedSize(true);
        //一行显示两个卡片
        binding.recyclerView.setLayoutManager(
                new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));



        return binding.getRoot();
    }
}