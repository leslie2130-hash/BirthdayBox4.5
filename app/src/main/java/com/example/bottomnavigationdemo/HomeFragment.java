package com.example.bottomnavigationdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bottomnavigationdemo.databinding.FragmentFriendDetailBinding;
import com.example.bottomnavigationdemo.databinding.FragmentHomeBinding;
import com.example.bottomnavigationdemo.home.DataBean;
import com.example.bottomnavigationdemo.home.ImageAdapter;
import com.youth.banner.indicator.CircleIndicator;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        binding.banner.addBannerLifecycleObserver(this)
                .setAdapter(new ImageAdapter(DataBean.getTestData()))
                .setIndicator(new CircleIndicator(getContext()));
        binding.banner2.addBannerLifecycleObserver(this)
                .setAdapter(new ImageAdapter(DataBean.getTestData()))
                .setIndicator(new CircleIndicator(getContext()));
        /* 一行显示两个卡片
        binding.recyclerView.setLayoutManager(
                new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
         */


        return binding.getRoot();
    }
}