package com.yixinghe.yixinghe.http.retrofit;

import com.yixinghe.yixinghe.model.BaseResult;
import com.yixinghe.yixinghe.model.UserLoginModel;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * 时间：2017-12-18  by:Liyuan
 */

public interface RetrofitService {

    @GET("appuser_login")
    Observable<BaseResult> getUserLoginBean(@QueryMap Map<String, Object> request);

}
