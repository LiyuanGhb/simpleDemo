package com.yixinghe.yixinghe.http.exception;


import android.util.Log;

import com.yixinghe.yixinghe.http.exception.ExceptionEngine;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * 时间：2017-12-20  by:Liyuan
 */

public class HttpResultFunction<T> implements Function<Throwable,Observable<T>> {

    @Override
    public Observable<T> apply(Throwable throwable) throws Exception {
        //打印具体错误
        Log.e("HttpResultFunction",  "->"+throwable);
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}
