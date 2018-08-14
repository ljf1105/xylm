package com.example.popo.xylm.data.beans;

/**
 * Created by popo on 2018/7/30.
 */

public class TokenBean {

    /**
     * code : 0
     * message : 成功
     * data : {"apptoken":"G00hN1wuqkr/NStp+5iS7itUQup0nEDpNHELksZAl9yaUIXK1tVHgg=="}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * apptoken : G00hN1wuqkr/NStp+5iS7itUQup0nEDpNHELksZAl9yaUIXK1tVHgg==
         */

        private String apptoken;

        public String getApptoken() {
            return apptoken;
        }

        public void setApptoken(String apptoken) {
            this.apptoken = apptoken;
        }
    }
}
