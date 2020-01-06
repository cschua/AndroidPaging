package com.cschua.androidpaginglibrary.repository.remote;

import com.cschua.androidpaginglibrary.model.remote.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("users")
    Call<UserResponse> getUsers(@Query("page") long page);
}
