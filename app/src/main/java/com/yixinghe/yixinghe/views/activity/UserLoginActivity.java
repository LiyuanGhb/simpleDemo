package com.yixinghe.yixinghe.views.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.yixinghe.yixinghe.R;
import com.yixinghe.yixinghe.contract.UserLoginContract;
import com.yixinghe.yixinghe.databinding.ActivityLoginBinding;
import com.yixinghe.yixinghe.db.RegisterActivitys;
import com.yixinghe.yixinghe.presenter.UserLoginPresenter;
import com.yixinghe.yixinghe.views.myview.WaitDialog;

/**
 * 时间：2017-12-12  by:Liyuan
 */

public class UserLoginActivity extends RegisterActivitys implements UserLoginContract.View {
    private UserLoginContract.Presenter presenter;
    ActivityLoginBinding binding;
    WaitDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        new UserLoginPresenter(this, this);
        presenter.start();
        clickListern();
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.login:
                    presenter.loadUserLogin();
                    break;
                case R.id.register:
                    break;
            }
        }
    };


    private void clickListern() {
        binding.login.setOnClickListener(onClickListener);
        binding.register.setOnClickListener(onClickListener);
    }

    @Override
    public void setPresenter(UserLoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String getUserName() {
        return binding.username.getText().toString();
    }

    @Override
    public String getPassWord() {
        return binding.password.getText().toString();
    }

    @Override
    public void showLoading() {
        dialog = new WaitDialog(this);
        dialog.show();
    }

    @Override
    public void dismissLoading() {
        if (null != dialog) {
            dialog.dismiss();
        }
    }


    @Override
    public void cleanPassWord() {
        binding.password.setText("");
    }

    @Override
    public void cleanUserName() {
        binding.username.setText("");
    }

    @Override
    public void LoginSuccess() {
        presenter.cleanUserName();
        presenter.cleanPassWord();
    }

    @Override
    public void LoginFail() {
        presenter.cleanPassWord();
    }

    @Override
    public void setActivity() {
        startActivity(new Intent(UserLoginActivity.this, GetCodeActivity.class));
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg + "", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

}
