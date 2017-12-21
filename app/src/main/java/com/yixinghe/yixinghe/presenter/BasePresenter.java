package com.yixinghe.yixinghe.presenter;

import io.reactivex.disposables.Disposable;

/**
 * 时间：2017-12-14  by:Liyuan
 */

public interface BasePresenter {

    void start();

    /**
     * 将网络请求的每一个disposable添加进入CompositeDisposable，再退出时候一并注销
     */
    void addDisposable(Disposable subscription);

    /**
     * 注销所有请求
     */
    void unDisposable();

    /**
     * Activity关闭把view对象置为空
     */
    void detach();
}
