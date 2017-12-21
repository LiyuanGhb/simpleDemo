package com.yixinghe.yixinghe.model;

/**
 * 时间：2017-12-20  by:Liyuan
 */

public class BaseResult<T> {
    public static final int SUCCESS = 200;
    public static final int ERROR = 1000;
    private int retCode;
    private String msg;
    private T result;
    public boolean isSuccess() {
        return (retCode == SUCCESS);
    }
    public int getStatus() {
        return retCode;
    }

    public void setStatus(int status) {
        this.retCode = status;
    }

    public String getInfo() {
        return msg;
    }

    public void setInfo(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return result;
    }

    public void setData(T data) {
        this.result = data;
    }
    @Override
    public String toString() {
        return "BaseResult{" +
                "status=" + retCode +
                ", info='" + msg + '\'' +
                ", data=" + result.toString() +
                '}';
    }
}
