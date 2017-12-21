package com.yixinghe.yixinghe.http;

import android.content.Context;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.yixinghe.yixinghe.http.retrofit.RetrofitService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 时间：2017-12-18  by:Liyuan
 */

public class RetrofitHelper {
    private Context context;
    private OkHttpClient okHttpClient ;
    private GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    private static RetrofitHelper helper = null;
    private Retrofit retrofit = null;

  public   static RetrofitHelper getInstance(Context context) {
        if (helper == null) {
            helper = new RetrofitHelper(context);
        }
        return helper;
    }

    private RetrofitHelper(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        initOkhttp();
        restApp();
    }

    private void initOkhttp(){
      okHttpClient  =  new OkHttpClient.Builder()
              //打印接口信息，方便接口调试
              .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                  @Override
                  public void log(String message) {
                      Log.e("TAG", "log: " + message);
                  }
              }).setLevel(HttpLoggingInterceptor.Level.BASIC))
              .connectTimeout(30, TimeUnit.SECONDS)
              .readTimeout(30, TimeUnit.SECONDS)
              .build();
    }
    private void restApp() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.sckxyy.com/")
                .client(okHttpClient)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

  public RetrofitService getServer() {
        return retrofit.create(RetrofitService.class);
    }

}
