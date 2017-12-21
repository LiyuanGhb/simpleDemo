package com.yixinghe.yixinghe.contract;

import com.yixinghe.yixinghe.presenter.BasePresenter;

/**
 * 时间：2017-12-14  by:Liyuan
 */

public interface UserLoginContract {
    interface View extends BaseView<Presenter> {

        /**
         * 获取用户名
         *
         * @return 用户名
         */
        String getUserName();

        /**
         * 获取密码
         *
         * @return 密码
         */
        String getPassWord();

        /**
         * 显示加载框
         */
        void showLoading();

        /**
         * 取消加载框显示
         */
        void dismissLoading();

        /**
         * 清除密码
         */
        void cleanPassWord();

        /**
         * 清除用户名
         */
        void cleanUserName();

        /**
         * 登录成功
         */
        void LoginSuccess();

        /**
         * 登录失败
         */
        void LoginFail();

        /**
         * 界面跳转
         */
        void setActivity();

        void showToast(String msg);
    }

    interface Presenter extends BasePresenter {
        void cleanPassWord();

        void cleanUserName();

        void loadUserLogin();

    }


}
