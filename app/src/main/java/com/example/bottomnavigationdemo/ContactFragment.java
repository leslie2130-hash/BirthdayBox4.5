package com.example.bottomnavigationdemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bottomnavigationdemo.data.Friend;
import com.example.bottomnavigationdemo.databinding.ContactFragmentBinding;

import java.util.List;

public class ContactFragment extends Fragment implements MyAdapter.IOnClickListener{
    private MyAdapter adapter;
    private FriendViewModel model;

    private ContactFragmentBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = ContactFragmentBinding.inflate(inflater, container, false);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        model = new ViewModelProvider(requireActivity()).get(FriendViewModel.class);

        adapter = new MyAdapter(model, this);
        binding.recyclerView.setAdapter(adapter);

        model.getList().observe(getViewLifecycleOwner(), new Observer<List<Friend>>() {
            @Override
            public void onChanged(List<Friend> friend) {
                adapter.notifyDataSetChanged();
            }
        });

        binding.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.add:
                        NavController controller = Navigation.findNavController(getView());
                        controller.navigate(R.id.action_contactFragment_to_createFriendFragment);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });



        return binding.getRoot();
    }


    @Override
    public void onClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("index", position);

        Log.i("test", "onClick: " + position);
        NavController navController = Navigation.findNavController(getView());
        navController.navigate(R.id.action_contactFragment_to_friendDetailFragment, bundle);
    }
}