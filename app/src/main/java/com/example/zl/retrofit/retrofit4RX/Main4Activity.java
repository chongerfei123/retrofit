package com.example.zl.retrofit.retrofit4RX;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zl.retrofit.R;
import com.example.zl.retrofit.bean.Newsbean;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class Main4Activity extends AppCompatActivity {
    //只能用旧版包，新版包用不了

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://v.juhe.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RetrofitInter4 retrofitInter4 = retrofit.create(RetrofitInter4.class);

        Observable<Newsbean> observable = retrofitInter4.getList("index?", "", "6236cb786e3eacfb5089450980189bee");

        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) .subscribe(new Subscriber<Newsbean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Newsbean newsbean) {
                List<Newsbean.ResultBean.DataBean> list = newsbean.getResult().getData();
            }
        });
    }
}
