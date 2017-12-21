package com.yixinghe.yixinghe.views.myview;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.Window;

/**
 * Created by Administrator on 2017-02-15.
 */

public class WaitDialog extends ProgressDialog {
    public WaitDialog(Context context) {
        super(context);
        //设置当前的Activity无Tilte,并且全屏(调用这个方法必须在setContentView之前调用)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置在对话框的外面点击,是否让对话框消失,false是可以取消
        setCanceledOnTouchOutside(false);
        //设置对话框的样式
        setProgressStyle(STYLE_SPINNER);
        setMessage("请稍后....");
    }

    public WaitDialog(Context context, int theme) {
        super(context, theme);
    }
    public static void showDialog(Context context, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setMessage(message);
        //builder.setPositiveButton("确定", null);
        builder.show();
    }

    public static void showDialogCloseAc(final Activity context, String message) {
  /*
  这里使用了 android.support.v7.app.AlertDialog.Builder
  可以直接在头部写 import android.support.v7.app.AlertDialog
  那么下面就可以写成 AlertDialog.Builder
  */
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setCancelable(false);
        builder.setMessage(message);
        builder.setPositiveButton("确定", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.finish();
            }
        });
        builder.show();
    }


}
