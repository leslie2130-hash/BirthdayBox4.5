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

import com.example.bottomnavigationdemo.databinding.ContactFragmentBinding;

import java.util.List;

public class ContactFragment extends Fragment implements MyAdapter.IOnClickListener{
    private MyAdapter adapter;
    private ContactViewModel model;

    private ContactFragmentBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = ContactFragmentBinding.inflate(inflater, container, false);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        model = new ViewModelProvider(this).get(ContactViewModel.class);

        adapter = new MyAdapter(model, this);
        binding.recyclerView.setAdapter(adapter);

        binding.add.setOnClickListener(view -> {
            if (TextUtils.isEmpty(binding.name.getText())
                    || TextUtils.isEmpty(binding.hobby.getText())) {
                Toast.makeText(getActivity(), "请输入姓名和爱好", Toast.LENGTH_SHORT).show();
                return;
            }
            String name = binding.name.getText().toString();
            String hobby = binding.hobby.getText().toString();

            Contact contact = new Contact();
            contact.setName(name);
            contact.setHobby(hobby);

            model.add(contact);
        });

        model.getList().observe(getViewLifecycleOwner(), new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contact) {
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
        Log.i("test", "onClick: " + position);
        NavController navController = Navigation.findNavController(getView());
        navController.navigate(R.id.action_contactFragment_to_friendDetailFragment);
    }
}