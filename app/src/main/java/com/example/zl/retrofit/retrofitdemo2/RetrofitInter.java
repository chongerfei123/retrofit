package com.example.zl.retrofit.retrofitdemo2;

import com.example.zl.retrofit.bean.Newsbean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by zl on 2017/4/29.
 */

public interface RetrofitInter {

    //http://v.juhe.cn/toutiao/index?type=&key=6236cb786e3eacfb5089450980189bee


    // 网址要求的参数  @Query("这里面的参数名字要求跟网址中参数名字相同")
    @GET("/toutiao/")//网址的后半部分
    Call<Newsbean> getList(@Query("index?") String index, @Query("type") String type, @Query("key") String key);

    //{catrgory}相当于占位符
    @GET("/{catrgory}/")
    Call<Newsbean> getList2(@Path("catrgory") String catrgory, @Query("index?") String index, @Query("type") String type, @Query("key") String key);
}
