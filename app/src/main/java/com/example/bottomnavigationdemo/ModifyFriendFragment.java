package com.example.bottomnavigationdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bottomnavigationdemo.databinding.FragmentModifyFriendBinding;


public class ModifyFriendFragment extends Fragment {
    private FragmentModifyFriendBinding binding;

    public ModifyFriendFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentModifyFriendBinding.inflate(inflater, container, false);

        binding.savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("Test", "onClick: ");
                NavController navController = Navigation.findNavController(getView());
                navController.navigateUp();
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}