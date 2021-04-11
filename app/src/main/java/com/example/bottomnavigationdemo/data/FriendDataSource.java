package com.example.bottomnavigationdemo.data;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.bottomnavigationdemo.FriendViewModel;

import java.util.ArrayList;
import java.util.List;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVUser;
import cn.leancloud.types.AVNull;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class FriendDataSource {

    private static final String NAME = "name";
    private static final String HOBBY = "hobby";
    private static final String DATE = "date";
    private static final String USER_ID = "userId";


    private MutableLiveData<List<Friend>> listMutableLiveData;
    private List<Friend> list;
    private FriendViewModel model;


    public FriendDataSource() {
        listMutableLiveData = new MutableLiveData<List<Friend>>();
        list = new ArrayList<Friend>();
        listMutableLiveData.setValue(list);

    }


    public void add(Friend friend) {
        //list.add(friend);
        //listMutableLiveData.postValue(list);

        // 构建对象
        AVObject friends = new AVObject("Friend");

        // 为属性赋值
        friends.put("name", friend.getName());
        friends.put("hobby", friend.getHobby());
        friends.put("date", friend.getBirthday());
        friends.put("userId", AVUser.getCurrentUser());

        // 将对象保存到云端
        friends.saveInBackground().subscribe(new Observer<AVObject>() {
            public void onSubscribe(Disposable disposable) {
            }

            public void onNext(AVObject todo) {
                // 成功保存之后，执行其他逻辑
                List<Friend> list = listMutableLiveData.getValue();
                list.add(toAVobject(todo));
                //list.add(friends);
                listMutableLiveData.postValue(list);
                System.out.println("保存成功。objectId：" + todo.getObjectId());
            }

            public void onError(Throwable throwable) {
                // 异常处理
            }

            public void onComplete() {
            }
        });


    }

    public void delete(int index, Friend friend) {

        AVObject todo = AVObject.createWithoutData("Friend", friend.getObjectId());
        todo.deleteInBackground().subscribe(new Observer<AVNull>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull AVNull avNull) {
                List<Friend> list = listMutableLiveData.getValue();
                list.remove(index);
                listMutableLiveData.postValue(list);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }

    public void modify(int index,Friend friend) {
        AVObject todo = AVObject.createWithoutData("Friend", friend.getObjectId());
        todo.put("name", friend.getName());
        todo.put("hobby", friend.getHobby());
        todo.saveInBackground().subscribe(new Observer<AVObject>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(AVObject todo) {
                List<Friend> list = listMutableLiveData.getValue();
                list.set(index, toAVobject(todo));
                listMutableLiveData.postValue(list);
                // 成功保存之后，执行其他逻辑
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        /*todo.fetchInBackground().subscribe(new Observer<AVObject>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull AVObject avObject) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/

    }

    public void getAll() {
        AVQuery<AVObject> query = new AVQuery<>("Friend");
        query.whereEqualTo("userId", AVUser.getCurrentUser());
        query.findInBackground().subscribe(new Observer<List<AVObject>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<AVObject> avObjects) {
                List<Friend> list = new ArrayList<>();
                for (AVObject object : avObjects) {
                    list.add(toAVobject(object));

                }
                listMutableLiveData.setValue(list);
                Log.i("tag", "onNext: " + avObjects.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public MutableLiveData<List<Friend>> getListMutableLiveData() {



        return listMutableLiveData;
    }

    private Friend toAVobject(AVObject avObject) {
        Friend friend = new Friend();
        friend.setName((String) avObject.get(NAME));
        friend.setHobby((String) avObject.get(HOBBY));
        friend.setBirthday((String) avObject.get(DATE));
        friend.setObjectId(avObject.getObjectId());

        return friend;
    }
}
