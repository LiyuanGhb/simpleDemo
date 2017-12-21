package com.yixinghe.yixinghe.http.retrofit;

import io.reactivex.disposables.Disposable;

/**
 * 时间：2017-12-20  by:Liyuan
 */

public interface RxActionManager<T> {
    /**
     * 添加
     *
     * @param tag
     * @param disposable
     */
    void add(T tag, Disposable disposable);

    /**
     * 移除
     *
     * @param tag
     */
    void remove(T tag);

    /**
     * 取消
     *
     * @param tag
     */
    void cancel(T tag);
}
