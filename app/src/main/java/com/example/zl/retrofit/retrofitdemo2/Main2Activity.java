package com.example.zl.retrofit.retrofitdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zl.retrofit.R;
import com.example.zl.retrofit.bean.Newsbean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//http://v.juhe.cn/toutiao/index?type=&key=6236cb786e3eacfb5089450980189bee
public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //网址的前部分，主网址http://v.juhe.cn
        //addConverterFactory(GsonConverterFactory.create()) 解析json数据
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://v.juhe.cn").addConverterFactory(GsonConverterFactory.create()).build();

        RetrofitInter retrofitInter = retrofit.create(RetrofitInter.class);

        Call<Newsbean> call = retrofitInter.getList2("toutiao","index?","","6236cb786e3eacfb5089450980189bee");
        call.enqueue(new Callback<Newsbean>() {
            @Override
            public void onResponse(Call<Newsbean> call, Response<Newsbean> response) {
                Newsbean newsbean = response.body();
                Newsbean.ResultBean resultBean = newsbean.getResult();
                List<Newsbean.ResultBean.DataBean> list = resultBean.getData();
            }

            @Override
            public void onFailure(Call<Newsbean> call, Throwable t) {

            }
        });
    }
}
