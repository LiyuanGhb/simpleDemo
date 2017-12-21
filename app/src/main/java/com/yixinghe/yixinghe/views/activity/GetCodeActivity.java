package com.yixinghe.yixinghe.views.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.yixinghe.yixinghe.R;
import com.yixinghe.yixinghe.contract.GetCodeContract;
import com.yixinghe.yixinghe.databinding.ActivityGetcodeBinding;
import com.yixinghe.yixinghe.db.RegisterActivitys;
import com.yixinghe.yixinghe.presenter.GetCodePresenter;

import com.yixinghe.yixinghe.views.myview.WaitDialog;

/**
 * 时间：2017-12-15  by:Liyuan
 */

public class GetCodeActivity extends RegisterActivitys implements GetCodeContract.View {
    ActivityGetcodeBinding binding;
    GetCodeContract.Presenter presenter;
    WaitDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_getcode);
        new GetCodePresenter(this);
    }

    @Override
    public void setPresenter(GetCodeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String getUserPhone() {
        return binding.phonecode.getText().toString();
    }

    @Override
    public void getCodeSuccess() {
        startActivity(new Intent(GetCodeActivity.this, UserRegisterActivity.class));
    }

    @Override
    public void getCodeFail() {

    }

    @Override
    public void showDialog() {
        dialog = new WaitDialog(this);
        dialog.show();
    }

    @Override
    public void hideDialog() {
        if (null != dialog) {
            dialog.dismiss();
        }
    }
}
