package com.example.bottomnavigationdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bottomnavigationdemo.data.Friend;
import com.example.bottomnavigationdemo.databinding.FragmentModifyFriendBinding;

import java.util.List;


public class ModifyFriendFragment extends Fragment {
    private FragmentModifyFriendBinding binding;
    private FriendViewModel model;
    private int index;

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

        index = (int) getArguments().get("index");
        Log.i("test", "index ok");

        binding = FragmentModifyFriendBinding.inflate(inflater, container, false);
        model = new ViewModelProvider(requireActivity()).get(FriendViewModel.class);

        //List<Friend> list = model.getList().getValue();

        Friend theFriend = model.getList().getValue().get(index); //"那一条" friend

        binding.savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(binding.createName.getText())
                        || TextUtils.isEmpty(binding.createHobby.getText())) {
                    Toast.makeText(getActivity(), "请输入姓名和爱好", Toast.LENGTH_SHORT).show();
                    return;
                }
                String name = binding.createName.getText().toString();
                String hobby = binding.createHobby.getText().toString();

                Friend friend = new Friend();
                friend.setName(name);
                friend.setHobby(hobby);
                friend.setObjectId(theFriend.getObjectId());
                Log.i("Test", "friend objectId: " + friend.getObjectId());
                model.modify(index, friend);

                NavController navController = Navigation.findNavController(getView());
                navController.navigateUp();
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }


}