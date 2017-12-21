package com.yixinghe.yixinghe.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yixinghe.yixinghe.contract.UserLoginContract;
import com.yixinghe.yixinghe.http.DataManager;
import com.yixinghe.yixinghe.http.HttpRequest;
import com.yixinghe.yixinghe.http.exception.ApiException;
import com.yixinghe.yixinghe.http.observe.HttpRxObservable;
import com.yixinghe.yixinghe.http.observe.HttpRxObserver;
import com.yixinghe.yixinghe.model.UserLoginModel;

import java.util.Map;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * 时间：2017-12-14  by:Liyuan
 */

public class UserLoginPresenter implements UserLoginContract.Presenter {
    private UserLoginContract.View view;
    /* private CompositeSubscription compositeSubscription; */
    private CompositeDisposable mCompositeDisposable;

    private DataManager manager;
    private Context context;

    public UserLoginPresenter(UserLoginContract.View view, Context context) {
        this.view = view;
        this.context = context;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        manager = new DataManager(context);
    }


    @Override
    public void loadUserLogin() {
        if (view.getUserName().isEmpty() || view.getPassWord().isEmpty()) {
            Toast.makeText((Context) view, "请输入用户名或密码", Toast.LENGTH_LONG).show();
            return;
        }
        login();
    }

    private void login() {
        //构建请求数据
        Map<String, Object> request = HttpRequest.getRequest();
        request.put("user.name", view.getUserName());
        request.put("user.pwd", view.getPassWord());
        HttpRxObserver httpRxObserver = new HttpRxObserver("xxx" + "getInfo") {
            @Override
            protected void onStart(Disposable d) {
                if (view != null)
                    view.showLoading();
                addDisposable(d);
            }

            @Override
            protected void onError(ApiException e) {
                Log.w("ApiException", "onError code:" + e.getCode() + " msg:" + e.getMsg());
                if (view != null) {
                    view.dismissLoading();
                    view.showToast(e.getMsg());
                }
            }

            @Override
            protected void onSuccess(Object response) {
                Log.w("ApiException", "onSuccess response:" + response.toString());
                UserLoginModel bean = new Gson().fromJson(response.toString(), UserLoginModel.class);
                if (view != null) {
                    view.dismissLoading();
                    view.showToast("登录成功");
                }
            }
        };

        /**
         * 切入后台移除RxJava监听
         * ActivityEvent.PAUSE(FragmentEvent.PAUSE)
         * 手动管理移除RxJava监听,如果不设置此参数默认自动管理移除RxJava监听（onCrete创建,onDestroy移除）
         */
        HttpRxObservable.getObservable(manager.UserLogin(request)).subscribe(httpRxObserver);
    }

    @Override
    public void cleanPassWord() {
        view.cleanPassWord();
    }

    @Override
    public void cleanUserName() {
        view.cleanUserName();
    }

    @Override
    public void addDisposable(Disposable subscription) {
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

    @Override
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public void detach() {
        this.view = null;
        unDisposable();
    }
}
