package com.yixinghe.yixinghe.presenter;


import com.yixinghe.yixinghe.contract.UserRegisterContract;

import io.reactivex.disposables.Disposable;

/**
 * 时间：2017-12-14  by:Liyuan
 */

public class UserRegisterPresenter implements UserRegisterContract.Presenter {
    UserRegisterContract.View view;
    String code;

    public UserRegisterPresenter(UserRegisterContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }


    @Override
    public void start() {

    }

    @Override
    public void addDisposable(Disposable subscription) {

    }

    @Override
    public void unDisposable() {

    }

    @Override
    public void detach() {

    }

    @Override
    public void getPhoneCode() {
           view.showDialog();
           new Thread(new Runnable() {
               @Override
               public void run() {
                   try {
                       Thread.sleep(2500);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   view.getCodeSuccess();
               }
           }).start();
    }

    @Override
    public void Regeister() {

    }

    @Override
    public void validateCode() {
        if(code.equals("123")){

        }
    }

}
