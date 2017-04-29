package com.example.zl.retrofit.retrofit4RX;


import com.example.zl.retrofit.bean.Newsbean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zl on 2017/4/29.
 */

public interface RetrofitInter4 {

    //http://v.juhe.cn/toutiao/index?type=&key=6236cb786e3eacfb5089450980189bee


    // 网址要求的参数  @Query("这里面的参数名字要求跟网址中参数名字相同")
    @GET("/toutiao/")//网址的后半部分
    Observable<Newsbean> getList(@Query("index?") String index, @Query("type") String type, @Query("key") String key);

}
