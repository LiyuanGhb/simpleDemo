package com.yixinghe.yixinghe.db;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yixinghe.yixinghe.views.BaseActivity;

/**
 * 时间：2017-12-15  by:Liyuan
 */

public class RegisterActivitys extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CloseRegisterActivity.addActivity(this);
    }
}
