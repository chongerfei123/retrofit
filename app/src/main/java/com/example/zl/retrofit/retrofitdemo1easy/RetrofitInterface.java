package com.example.zl.retrofit.retrofitdemo1easy;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by zl on 2017/4/29.
 */

public interface RetrofitInterface {
    @GET("/")
    Call<String> getBaidu();
}
