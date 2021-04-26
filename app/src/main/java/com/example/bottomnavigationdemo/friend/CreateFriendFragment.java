package com.example.bottomnavigationdemo.friend;

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

import com.example.bottomnavigationdemo.FriendViewModel;
import com.example.bottomnavigationdemo.data.Friend;
import com.example.bottomnavigationdemo.databinding.FragmentCreateFriendBinding;

public class CreateFriendFragment extends Fragment {
    private FragmentCreateFriendBinding binding;
    private FriendViewModel model;
    public CreateFriendFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("Test", "onCreateView: ");
        binding = FragmentCreateFriendBinding.inflate(inflater, container, false);
        model = new ViewModelProvider(requireActivity()).get(FriendViewModel.class);

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
                String birthday = binding.createBirthday.getText().toString();

                Friend friend = new Friend();
                friend.setName(name);
                friend.setHobby(hobby);
                friend.setBirthday(birthday);


                model.add(friend);//


                Log.i("Test", "onClick: ");
                NavController navController = Navigation.findNavController(getView());
                navController.navigateUp();
            }
        });
        return binding.getRoot();
    }
}