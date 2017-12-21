package com.yixinghe.yixinghe.http;

import android.content.Context;

import com.yixinghe.yixinghe.http.RetrofitHelper;
import com.yixinghe.yixinghe.http.retrofit.RetrofitService;
import com.yixinghe.yixinghe.model.BaseResult;

import java.util.Map;

import io.reactivex.Observable;

/**
 * 时间：2017-12-18  by:Liyuan
 */

public class DataManager {
    private RetrofitService mRetrofitService;

    public DataManager(Context context) {
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }

    public Observable<BaseResult> UserLogin(Map map) {
        return mRetrofitService.getUserLoginBean(map);
    }

}
