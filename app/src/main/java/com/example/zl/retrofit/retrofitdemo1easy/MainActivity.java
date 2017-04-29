package com.example.zl.retrofit.retrofitdemo1easy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zl.retrofit.R;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback<String> {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com/")
                .addConverterFactory(new Converter.Factory() {
                    @Override
                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                        Converter<ResponseBody, String> converter = new Converter<ResponseBody, String>() {
                            @Override
                            public String convert(ResponseBody value) throws IOException {
                                String string = value.string();
                                return string;
                            }
                        };
                        return converter;
                    }
                }).build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        Call<String> call = retrofitInterface.getBaidu();
//        call.cancel();//停止请求
//        call.clone();//克隆一份请求
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        text.setText(response.body());
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        Toast.makeText(this, "shibai"+ call.request().url() , Toast.LENGTH_SHORT).show();
        t.printStackTrace();
    }
}
