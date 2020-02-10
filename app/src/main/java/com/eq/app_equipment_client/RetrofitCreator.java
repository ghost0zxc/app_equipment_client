package com.eq.app_equipment_client;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCreator {
    public static final String BASE_URL = "http://39.97.184.201:8080/app_equipment_server/";
    public static final int CONNECT_TIME_OUT = 10000;//毫秒
    private Retrofit mRetrofit;


    private RetrofitCreator() {
        createRetrofit();
    }

    private void createRetrofit() {
        //设置一下okHttp的参数
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)//设置BaseUrl
                .client(okHttpClient)//设置请求的client
                .addConverterFactory(GsonConverterFactory.create())//设置转换器
                .build();
    }

    private static RetrofitCreator sRetrofitCreator = null;

    public static RetrofitCreator getInstance() {
        if(sRetrofitCreator == null) {
            synchronized(RetrofitCreator.class) {
                if(sRetrofitCreator == null) {
                    sRetrofitCreator = new RetrofitCreator();
                }
            }
        }
        return sRetrofitCreator;
    }


    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
