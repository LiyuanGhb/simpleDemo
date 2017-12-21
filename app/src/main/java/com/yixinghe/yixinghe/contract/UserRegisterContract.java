package com.yixinghe.yixinghe.contract;

import com.yixinghe.yixinghe.presenter.BasePresenter;

/**
 * 时间：2017-12-14  by:Liyuan
 */

public interface UserRegisterContract {
    interface View extends BaseView<Presenter> {

        String getUserName();

        String getCode();

        String getPassWord();

        void showDialog();

        void hideDialog();

        void getCodeSuccess();

        void getCodeFail();

        void RegesterSuccess();

        void RegesterFail();

        void validateCodeSuccess();

        /**
         * 验证码不匹配
         */
        void validateCodeFail();
    }

    interface Presenter extends BasePresenter {

        void getPhoneCode();

        void Regeister();

        void validateCode();

    }
}
