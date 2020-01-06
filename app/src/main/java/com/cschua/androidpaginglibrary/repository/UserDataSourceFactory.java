package com.cschua.androidpaginglibrary.repository;

import com.cschua.androidpaginglibrary.model.remote.User;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class UserDataSourceFactory extends DataSource.Factory<Long, User> {

    public MutableLiveData<UserDataSource> userLiveDataSource = new MutableLiveData<>();

    @Override
    public DataSource<Long, User> create() {
        UserDataSource userDataSource = new UserDataSource();
        userLiveDataSource.postValue(userDataSource);
        return userDataSource;
    }
}
