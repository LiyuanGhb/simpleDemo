package com.yixinghe.yixinghe.model;

/**
 * 时间：2017-12-14  by:Liyuan
 */

public class UserLoginModel {

    /**
     * msg : 登录成功
     * result : {"name":"321321","cookie":"2017_12_19_08_59_53_e5kdhjr"}
     * retCode : 200
     */

    private String msg;
    private ResultBean result;
    private String retCode;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public static class ResultBean {
        /**
         * name : 321321
         * cookie : 2017_12_19_08_59_53_e5kdhjr
         */

        private String name;
        private String cookie;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCookie() {
            return cookie;
        }

        public void setCookie(String cookie) {
            this.cookie = cookie;
        }
    }
}

