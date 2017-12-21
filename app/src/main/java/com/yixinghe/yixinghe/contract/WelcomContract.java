package com.yixinghe.yixinghe.contract;

import com.yixinghe.yixinghe.presenter.BasePresenter;

/**
 * 时间：2017-12-14  by:Liyuan
 */

public interface WelcomContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void threadTime();
    }
}
