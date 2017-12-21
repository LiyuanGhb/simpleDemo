package com.yixinghe.yixinghe.db;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2017-12-15  by:Liyuan
 *作用在于可同时关闭多个指定的activity
 */

public class CloseRegisterActivity extends Application {
    private static List<Activity> lists = new ArrayList<>();

    public static void addActivity(Activity activity) {
        lists.add(activity);
    }

    public static void clearActivity() {
        if (lists != null) {
            for (Activity activity : lists) {
                activity.finish();
            }
            lists.clear();
        }
    }
}
