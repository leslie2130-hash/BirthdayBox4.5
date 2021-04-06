package com.example.bottomnavigationdemo;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.bottomnavigationdemo.data.Friend;
import com.example.bottomnavigationdemo.databinding.FragmentCreateFriendBinding;
import com.example.bottomnavigationdemo.databinding.FragmentFriendDetailBinding;

import java.util.List;


public class FriendDetailFragment extends Fragment {

    private FragmentFriendDetailBinding binding;
    private int index;
    private FriendViewModel model;

    public FriendDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        index = (int) getArguments().get("index");
        binding = FragmentFriendDetailBinding.inflate(inflater, container, false);
        model = new ViewModelProvider(requireActivity()).get(FriendViewModel.class);
        List<Friend> list = model.getList().getValue();
        Log.i("test", "onCreateView: " + list);
        Friend friend = model.getList().getValue().get(index);
        Log.i("Test", "onCreateView: " + index + " " + friend);
        binding.textView.setText(friend.toString());

        binding.toolbar3.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.modify:
                        NavController navController = Navigation.findNavController(getView());
                        navController.navigate(R.id.action_friendDetailFragment_to_modifyFriendFragment);
                        break;
                    case R.id.delete:
                        break;
                    default:
                        break;
                }

                return false;
            }
        });
        binding.snedgiftbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getView());
                navController.navigate(R.id.action_friendDetailFragment_to_reminderFragment);
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}