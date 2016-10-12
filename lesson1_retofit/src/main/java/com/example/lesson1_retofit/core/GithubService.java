package com.example.lesson1_retofit.core;

import com.example.lesson1_retofit.bean.ResponseBody;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by hengyilin on 16-10-5.
 */

public interface GithubService {
    @GET("repos/{owner}/{repo}/contributors")
    Call<List<ResponseBody>> getUserInfo(@Path("owner") String ower, @Path("repo") String repo);
//    @GET("repos/{owner}/{repo}/contributors")
//    Observable<List<ResponseBody>> getUserInfo(@Path("owner") String ower, @Path("repo") String repo);

}
