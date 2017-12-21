package com.yixinghe.yixinghe.contract;

import com.yixinghe.yixinghe.presenter.BasePresenter;

/**
 * 时间：2017-12-15  by:Liyuan
 */

public interface GetCodeContract {
    interface View extends BaseView<Presenter> {
        String getUserPhone();

        void getCodeSuccess();

        void getCodeFail();

        void showDialog();

        void hideDialog();
    }

    interface Presenter extends BasePresenter {
        void getCode();
    }
}
