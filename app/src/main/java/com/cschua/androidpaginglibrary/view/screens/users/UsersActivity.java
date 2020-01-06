package com.cschua.androidpaginglibrary.view.screens.users;

import android.os.Bundle;

import com.cschua.androidpaginglibrary.R;
import com.cschua.androidpaginglibrary.model.remote.User;
import com.cschua.androidpaginglibrary.view.adapter.UserAdapter;
import com.cschua.androidpaginglibrary.viewmodel.UserViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

// https://androidwave.com/android-paging-library/

public class UsersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        recyclerView = findViewById(R.id.recyclerView);
        final UserAdapter adapter = new UserAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserViewModel itemViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        itemViewModel.userPagedList.observe(this, new Observer<PagedList<User>>() {
            @Override
            public void onChanged(PagedList<User> users) {
                adapter.submitList(users);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
