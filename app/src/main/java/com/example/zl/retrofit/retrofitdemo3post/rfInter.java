package com.example.zl.retrofit.retrofitdemo3post;

import com.example.zl.retrofit.bean.Newsbean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by zl on 2017/4/29.
 */

public interface rfInter {

    //http://v.juhe.cn/toutiao/index?type=&key=6236cb786e3eacfb5089450980189bee



    //{catrgory}相当于占位符
    @POST("/{catrgory}/")
    @FormUrlEncoded
    Call<Newsbean> getList(@Path("catrgory") String catrgory, @Field("index?") String index, @Field("type") String type, @Field("key") String key);
}
