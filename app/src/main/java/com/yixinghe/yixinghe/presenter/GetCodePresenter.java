package com.yixinghe.yixinghe.presenter;

import com.yixinghe.yixinghe.contract.GetCodeContract;

import io.reactivex.disposables.Disposable;

/**
 * 时间：2017-12-15  by:Liyuan
 */

public class GetCodePresenter implements GetCodeContract.Presenter {
    GetCodeContract.View view;

    public GetCodePresenter(GetCodeContract.View view) {
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
    public void getCode() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                view.showDialog();
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(view.getUserPhone().equals("2")){
                    view.getCodeSuccess();
                }else{
                    view.getCodeFail();
                }
            }
        }).start();

    }
}
