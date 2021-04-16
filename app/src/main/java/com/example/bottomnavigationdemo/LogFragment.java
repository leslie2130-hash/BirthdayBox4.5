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

import cn.leancloud.AVUser;
import io.reactivex.disposables.Disposable;

import androidx.appcompat.app.AppCompatActivity;

public class LogFragment extends Fragment {
    private static final  String  TAG = "BottomNavigationDemo";

    private UserViewModel mViewModel;

    public static LogFragment newInstance() {
        return new LogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.log_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getResult().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Intent intent = new Intent(getActivity(),  MainActivity3tab.class);
                    startActivity(intent);
                }
            }
        });

        Button button = getView().findViewById(R.id.buttonRegister);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_logFragment_to_register_Fragment);

            }
        });

        EditText editName = getView().findViewById(R.id.editTextTextPersonName);
        EditText editPassword = getView().findViewById(R.id.editTextTextPassword);
        Button button1 = getView().findViewById(R.id.buttonLogin);

        button1.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         String name = editName.getText().toString();
                                         Log.i(TAG, "log name" + name);
                                         String password = editPassword.getText().toString();
                                         //Log.i(TAG, "onClick: " + str);//读，保存用户姓名
                                         Log.i(TAG, "log password" + password);

                                         mViewModel.login(name, password);

                                     }
                                 }

        );
    }



}





