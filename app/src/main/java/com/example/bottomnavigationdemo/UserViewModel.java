package com.example.bottomnavigationdemo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import androidx.appcompat.app.AppCompatActivity;

import cn.leancloud.AVUser;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
public class UserViewModel extends ViewModel {
    private static final  String  TAG = "BottomNavigationDemo";
    private MutableLiveData<Boolean> result = new MutableLiveData<>();

    public UserViewModel() {
        if (AVUser.getCurrentUser() != null) {
            result.setValue(true);
        }
    }

    public void register(String name, String password) {
        // 创建实例
        AVUser user = new AVUser();

        user.setUsername(name);
        user.setPassword(password);
        //user.setEmail("tom@leancloud.rocks");
        //user.setMobilePhoneNumber("+8618200008888");

        // 设置其他属性的方法跟 AVObject 一样
        user.put("gender", "secret");

        user.signUpInBackground().subscribe(new Observer<AVUser>() {
            public void onSubscribe(Disposable disposable) {
            }

            public void onNext(AVUser user) {
                // 注册成功

                Log.i(TAG, "注册成功。" + user.getObjectId());

                result.setValue(true);
            }

            public void onError(Throwable throwable) {

                // 注册失败（通常是因为用户名已被使用）
                Log.i(TAG, "注册失败。"  + throwable.getMessage());

                result.setValue(false);
            }


            public void onComplete() {
            }
        });
    }

    public void login(String name, String password){
        AVUser.logIn(name, password).subscribe(new Observer<AVUser>() {
            public void onSubscribe(Disposable disposable) {}
            public void onNext(AVUser user) {
                // 登录成功
                Log.i(TAG, "登录成功" + user.getObjectId());
                result.setValue(true);
            }
            public void onError(Throwable throwable) {
                // 登录失败（可能是密码错误）
                Log.i(TAG, "登录失败" + throwable.getMessage());
                result.setValue(false);
            }
            public void onComplete() {}
        });
    }
    public MutableLiveData<Boolean> getResult() {

        return result;
    }




}