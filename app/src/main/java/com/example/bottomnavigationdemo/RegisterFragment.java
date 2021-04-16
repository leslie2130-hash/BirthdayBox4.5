package com.example.bottomnavigationdemo;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class RegisterFragment extends Fragment {
    private static final  String  TAG = "BottomNavigationDemo";

    private UserViewModel mViewModel;


    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.register__fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        // TODO: Use the ViewModel
        Button button = getView().findViewById(R.id.buttonRegister3);

        EditText inputUserName = getView().findViewById(R.id.registerInputUserName);
        EditText inputPassword = getView().findViewById(R.id.editInputPassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = inputUserName.getText().toString();
                String password = inputPassword.getText().toString();

                Log.i(TAG, "onClick: " + name);
                Log.i(TAG, "onClick: " + password);
                mViewModel.register(name, password);
            }
        });

        mViewModel.getResult().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    //NavController navController  = Navigation.findNavController(getView());
                    //navController.navigate(R.id.action_register_Fragment_to_logFragment);

                    Intent intent = new Intent(getActivity(),  MainActivity3tab.class);
                    startActivity(intent);
                }
            }
        });

    }



}