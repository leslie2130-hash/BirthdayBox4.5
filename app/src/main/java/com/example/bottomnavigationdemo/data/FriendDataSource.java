package com.example.bottomnavigationdemo.data;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

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

    public void delete(){
        AVObject todo = AVObject.createWithoutData("Friend", "6068175b7fa6c4403bc526ac");
        todo.deleteInBackground().subscribe(new Observer<AVNull>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull AVNull avNull) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }

    public void modify(){
        AVObject todo = AVObject.createWithoutData("Friend", "6068185a7fa6c4403bc528ae");
        todo.put("hobby", "这周周会改到周三下午三点。");
        todo.saveInBackground().subscribe(new Observer<AVObject>() {
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
        });

    }

    public void getAll(){
        AVQuery<AVObject> query = new AVQuery<>("Friend");
        query.whereEqualTo("userId", AVUser.getCurrentUser());
        query.findInBackground().subscribe(new Observer<List<AVObject>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<AVObject> avObjects) {
                List<Friend> list = new ArrayList<>();
                for (AVObject object: avObjects){
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

    private Friend toAVobject(AVObject avObject){
        Friend friend = new Friend();
        friend.setName((String) avObject.get(NAME));
        friend.setHobby((String) avObject.get(HOBBY));
        friend.setBirthday((String) avObject.get(DATE));
        friend.setObjectId(avObject.getObjectId());

        return friend;
    }
}

