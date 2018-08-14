package com.example.popo.xylm.data.beans;

/**
 * Created by popo on 2018/8/7.
 */

public class ZhiFu {

    /**
     * code : 0
     * message : 成功
     * data : alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2017121300703777&biz_content=%7B%22out_trade_no%22%3A%22180807171408050%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E5%85%85%E5%80%BC%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%221.0%22%7D&charset=UTF-8&format=JSON&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Fwww.univstar.com%2Fv1%2Fm%2Falipay%2FnotifyUrl&sign=cvTjZdReAHig%2BDLrAEnD0ZhzuTMRMwo%2Fjrqlt71k7Oc%2BoGSXfWfjkBY6b9yFY5ahmudx8mgaxe9baRbMNIcWA04WjQajRjdmledQFX0nlbQA8RyZ1QHOSYOP2JSP%2FKOvCPxyJG0yK%2BZznMIhDjGQ8EfKSy9RwyAKhJlDHmghJs5e8glUWcudKvZ8VyzHXh58xg3OyJl7NcAdWTiDLBYNIeepK58%2Fn3I%2FDUz%2FELcOZ32pqCresvFV9oo9b9F7OMubGkTSF9wGExwJOGkTL%2BLvkLuC0hWLE56MiVh1%2FkHnImvkJGvI56ef4qQOw0VD3vcLkWhpW1qC1DdfNobQf5dQCA%3D%3D&sign_type=RSA2&timestamp=2018-08-07+17%3A17%3A07&version=1.0
     */

    private int code;
    private String message;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
