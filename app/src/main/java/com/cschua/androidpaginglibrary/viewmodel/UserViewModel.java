package com.cschua.androidpaginglibrary.viewmodel;

import com.cschua.androidpaginglibrary.model.remote.User;
import com.cschua.androidpaginglibrary.repository.UserDataSource;
import com.cschua.androidpaginglibrary.repository.UserDataSourceFactory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class UserViewModel extends ViewModel {

    public LiveData<PagedList<User>> userPagedList;
    private LiveData<UserDataSource> liveDataSource;

    public UserViewModel() {
        init();
    }

    private void init() {
        UserDataSourceFactory itemDataSourceFactory = new UserDataSourceFactory();
        liveDataSource = itemDataSourceFactory.userLiveDataSource;
        PagedList.Config config = new PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(UserDataSource.PAGE_SIZE)
            .build();
        userPagedList = new LivePagedListBuilder<>(itemDataSourceFactory, config).build();
    }
}