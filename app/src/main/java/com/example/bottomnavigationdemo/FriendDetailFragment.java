package com.example.bottomnavigationdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.bottomnavigationdemo.data.Friend;
import com.example.bottomnavigationdemo.databinding.FragmentFriendDetailBinding;

import java.util.List;


public class FriendDetailFragment extends Fragment {

    private FragmentFriendDetailBinding binding;
    private int index;
    private ContactAdapter adapter;
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
        Friend friend = list.get(index); //"那一条" friend
        //Log.i("TAG", "friend = model.getList().getValue().get(index);");

        //binding.textViewName.setText(friend.getName());
       // binding.textViewHobby.setText(friend.getHobby());
       // binding.textViewBirthday.setText(friend.getBirthday());


        model.getList().observe(getViewLifecycleOwner(), new Observer<List<Friend>>() {
            @Override
            public void onChanged(List<Friend> friend) {

                Friend friend2 = model.getList().getValue().get(index);
                binding.textViewName.setText("Name: " + friend2.getName());
                binding.textViewHobby.setText("Hobby: " + friend2.getHobby());
                binding.textViewBirthday.setText("Birthday: " + friend2.getBirthday());
            }
        });

        binding.toolbar3.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.modify:
                        Bundle bundle = new Bundle();
                        bundle.putInt("index", index);

                        NavController navController = Navigation.findNavController(getView());
                        navController.navigate(R.id.action_friendDetailFragment_to_modifyFriendFragment, bundle);
                        break;
                    case R.id.delete:
                        Friend friend = model.getList().getValue().get(index); //"那一条" friend
                        model.delete(index, friend);
                        NavController navController2 = Navigation.findNavController(getView());
                        navController2.navigateUp();
                        break;
                    default:
                        break;
                }

                return false;
            }
        });
        binding.sendgiftbutton.setOnClickListener(new View.OnClickListener() {
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