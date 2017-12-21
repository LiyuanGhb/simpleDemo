package com.yixinghe.yixinghe.http.observe;

import com.yixinghe.yixinghe.http.exception.HttpResultFunction;
import com.yixinghe.yixinghe.http.exception.ServerResultFunction;
import com.yixinghe.yixinghe.model.BaseResult;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 时间：2017-12-20  by:Liyuan
 */

public class HttpRxObservable {

    /**
     * 获取被监听者
     * 备注:网络请求Observable构建
     * data:网络请求参数
     */
    public static Observable getObservable(Observable<BaseResult> apiObservable) {
        Observable observable = apiObservable
                .map(new ServerResultFunction())
                .onErrorResumeNext(new HttpResultFunction<>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

/*

    */
/**
 * 获取被监听者
 * 备注:网络请求Observable构建
 * data:网络请求参数
 * 传入LifecycleProvider自动管理生命周期,避免内存溢出
 * 备注:需要继承RxActivity.../RxFragment...
 *
 *//*

    public static Observable getObservable(Observable<BaseResult> apiObservable, LifecycleProvider lifecycle) {
        Observable observable;
        if (lifecycle != null) {
            //随生命周期自动管理.eg:onCreate(start)->onStop(end)
            observable = apiObservable
                    .map(new ServerResultFunction())
                    .compose(lifecycle.bindToLifecycle())//需要在这个位置添加i
                    .onErrorResumeNext(new HttpResultFunction<>())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        } else {
            observable = getObservable(apiObservable);
        }
        return observable;
    }

    */
/**
 * 获取被监听者
 * 备注:网络请求Observable构建
 * data:网络请求参数
 * 传入LifecycleProvider<ActivityEvent>手动管理生命周期,避免内存溢出
 * 备注:需要继承RxActivity,RxAppCompatActivity,RxFragmentActivity
 *
 *//*

    public static Observable getObservable(Observable<BaseResult> apiObservable, LifecycleProvider<ActivityEvent> lifecycle, ActivityEvent event) {
        // showLog(request);
        Observable observable;
        if (lifecycle != null) {
            //手动管理移除监听生命周期.eg:ActivityEvent.STOP
            observable = apiObservable
                    .map(new ServerResultFunction())
                    .compose(lifecycle.bindUntilEvent(event))//需要在这个位置添加
                    .onErrorResumeNext(new HttpResultFunction<>())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        } else {
            observable = getObservable(apiObservable);
        }
        return observable;
    }

    */
/**
 * 获取被监听者
 * 备注:网络请求Observable构建
 * data:网络请求参数
 * 传入LifecycleProvider<FragmentEvent>手动管理生命周期,避免内存溢出
 * 备注:需要继承RxFragment,RxDialogFragment
 *
 *//*

    public static Observable getObservable(Observable<BaseResult> apiObservable, LifecycleProvider<FragmentEvent> lifecycle, FragmentEvent event) {
        //  showLog(request);
        Observable observable;
        if (lifecycle != null) {
            //手动管理移除监听生命周期.eg:FragmentEvent.STOP
            observable = apiObservable
                    .map(new ServerResultFunction())
                    .compose(lifecycle.bindUntilEvent(event))//需要在这个位置添加
                    .onErrorResumeNext(new HttpResultFunction<>())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        } else {
            observable = getObservable(apiObservable);
        }
        return observable;
    }

    private static void showLog(Map<String, Object> request) {
        if (request == null || request.size() == 0) {
            Log.e("http request","null");
        }
        Log.e("http request" ,"msg:"+ new Gson().toJson(request));
    }
*/

}
