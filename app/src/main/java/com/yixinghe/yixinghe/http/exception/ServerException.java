package com.yixinghe.yixinghe.http.exception;

/**
 * 时间：2017-12-20  by:Liyuan
 */

public class ServerException extends RuntimeException{
    private int status;
    private String info;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setCode(int status) {
        this.status = status;
    }

    public void setMsg(String info) {
        this.info = info;
    }

    public ServerException(int status, String info){
        this.status = status;
        this.info = info;
    };
}
