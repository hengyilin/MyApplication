package com.example.lesson1_retofit.coreimpl;

import android.util.Log;

import com.example.lesson1_retofit.bean.ResponseBody;
import com.example.lesson1_retofit.core.GithubService;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.internal.operators.CompletableOnSubscribeConcat;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by hengyilin on 16-10-5.
 */

public class GetGithubUserInfo {
    private CompositeSubscription subscription = new CompositeSubscription();
    public List<ResponseBody> getUserInfo(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        System.out.println("程序执行到函数里面啦");
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .baseUrl("http://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService service = retrofit.create(GithubService.class);
       // subscription.add(service.getUserInfo("square","retrofit"));
        Call<List<ResponseBody>> responseBodyCall = service.getUserInfo("square","retrofit");
        responseBodyCall.enqueue(new Callback<List<ResponseBody>>() {
            @Override
            public void onResponse(Call<List<ResponseBody>> call, Response<List<ResponseBody>> response) {
                List<ResponseBody> bodies = response.body();
                System.out.println("开始打印用户信息");
                for (ResponseBody body : bodies) {
                    Log.d("login", body.getLogin());
                    Log.d("contributions", body.getContributions() + "");
                }
            }

            @Override
            public void onFailure(Call<List<ResponseBody>> call, Throwable t) {
                System.out.println("执行失败");
            }
        });

        return null;
    }
}
