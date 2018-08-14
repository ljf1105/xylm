package com.example.popo.xylm.data.beans;

import java.util.List;

/**
 * Created by popo on 2018/8/7.
 */

public class ChongZhi {

    /**
     * code : 0
     * message : 成功
     * data : {"amount":0,"mobile":"15034591419","list":[{"id":1,"page":1,"rows":20,"amountAndroid":10,"priceAndroid":1,"amountIos":42,"priceIos":6},{"id":2,"page":1,"rows":20,"amountAndroid":200,"priceAndroid":20,"amountIos":210,"priceIos":30},{"id":3,"page":1,"rows":20,"amountAndroid":500,"priceAndroid":50,"amountIos":686,"priceIos":98},{"id":4,"page":1,"rows":20,"amountAndroid":1000,"priceAndroid":100,"amountIos":0,"priceIos":0},{"id":5,"page":1,"rows":20,"amountAndroid":2000,"priceAndroid":200,"amountIos":0,"priceIos":0},{"id":6,"page":1,"rows":20,"amountAndroid":5000,"priceAndroid":500,"amountIos":0,"priceIos":0},{"id":7,"page":1,"rows":20,"amountAndroid":10000,"priceAndroid":1000,"amountIos":0,"priceIos":0}]}
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
         * amount : 0
         * mobile : 15034591419
         * list : [{"id":1,"page":1,"rows":20,"amountAndroid":10,"priceAndroid":1,"amountIos":42,"priceIos":6},{"id":2,"page":1,"rows":20,"amountAndroid":200,"priceAndroid":20,"amountIos":210,"priceIos":30},{"id":3,"page":1,"rows":20,"amountAndroid":500,"priceAndroid":50,"amountIos":686,"priceIos":98},{"id":4,"page":1,"rows":20,"amountAndroid":1000,"priceAndroid":100,"amountIos":0,"priceIos":0},{"id":5,"page":1,"rows":20,"amountAndroid":2000,"priceAndroid":200,"amountIos":0,"priceIos":0},{"id":6,"page":1,"rows":20,"amountAndroid":5000,"priceAndroid":500,"amountIos":0,"priceIos":0},{"id":7,"page":1,"rows":20,"amountAndroid":10000,"priceAndroid":1000,"amountIos":0,"priceIos":0}]
         */

        private int amount;
        private String mobile;
        private List<ListBean> list;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 1
             * page : 1
             * rows : 20
             * amountAndroid : 10
             * priceAndroid : 1
             * amountIos : 42
             * priceIos : 6
             */

            private int id;
            private int page;
            private int rows;
            private int amountAndroid;
            private int priceAndroid;
            private int amountIos;
            private int priceIos;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public int getRows() {
                return rows;
            }

            public void setRows(int rows) {
                this.rows = rows;
            }

            public int getAmountAndroid() {
                return amountAndroid;
            }

            public void setAmountAndroid(int amountAndroid) {
                this.amountAndroid = amountAndroid;
            }

            public int getPriceAndroid() {
                return priceAndroid;
            }

            public void setPriceAndroid(int priceAndroid) {
                this.priceAndroid = priceAndroid;
            }

            public int getAmountIos() {
                return amountIos;
            }

            public void setAmountIos(int amountIos) {
                this.amountIos = amountIos;
            }

            public int getPriceIos() {
                return priceIos;
            }

            public void setPriceIos(int priceIos) {
                this.priceIos = priceIos;
            }
        }
    }
}
