package com.yixinghe.yixinghe.http.exception;

import android.util.Log;

import com.google.gson.Gson;
import com.yixinghe.yixinghe.http.exception.ServerException;
import com.yixinghe.yixinghe.model.BaseResult;

import io.reactivex.functions.Function;

/**
 * 时间：2017-12-20  by:Liyuan
 */

public class ServerResultFunction implements Function<BaseResult, Object> {


    @Override
    public Object apply(BaseResult baseResult) throws Exception {
        Log.e("ServerResultFunction", baseResult.toString());
        if (!baseResult.isSuccess()) {
            throw new ServerException(baseResult.getStatus(), baseResult.getInfo());
        }
        return new Gson().toJson(baseResult.getData());
    }
}
