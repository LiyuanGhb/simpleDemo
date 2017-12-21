package com.yixinghe.yixinghe.views.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yixinghe.yixinghe.contract.UserRegisterContract;
import com.yixinghe.yixinghe.databinding.ActivityRegisterBinding;
import com.yixinghe.yixinghe.db.RegisterActivitys;

/**
 * 时间：2017-12-14  by:Liyuan
 */

public class UserRegisterActivity extends RegisterActivitys implements UserRegisterContract.View {
    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setPresenter(UserRegisterContract.Presenter presenter) {

    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getPassWord() {
        return null;
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void getCodeSuccess() {

    }

    @Override
    public void getCodeFail() {

    }

    @Override
    public void RegesterSuccess() {

    }

    @Override
    public void RegesterFail() {

    }

    @Override
    public void validateCodeSuccess() {

    }

    @Override
    public void validateCodeFail() {

    }

}
