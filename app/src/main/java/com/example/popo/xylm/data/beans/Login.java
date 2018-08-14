package com.example.popo.xylm.data.beans;

/**
 * Created by popo on 2018/7/30.
 */

public class Login {

    /**
     * code : 1
     * message : cid为空
     * data : {"nickname":"Timeless°","mobile":"15034591419","photo":"http://qiniu.5roo.com/a57d2ed9b7134145a3ae89042694aadc.jpg","id":1559,"userType":1,"token":"eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJmY2ZheWsiLCJzdWIiOiIxNTU5IiwiZXhwIjoxNTMzNTE5Mzg3LCJpYXQiOjE1MzI5MTQ1ODd9.Fh9zTmPGs0MJiD3zytuVHDBSmLBzz8RFPmAQmqK-e3_zxBAu6rkkYapbalA6wyf-w3X4ZxvMV8-wUGDp7AxG3w"}
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
         * nickname : Timeless°
         * mobile : 15034591419
         * photo : http://qiniu.5roo.com/a57d2ed9b7134145a3ae89042694aadc.jpg
         * id : 1559
         * userType : 1
         * token : eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJmY2ZheWsiLCJzdWIiOiIxNTU5IiwiZXhwIjoxNTMzNTE5Mzg3LCJpYXQiOjE1MzI5MTQ1ODd9.Fh9zTmPGs0MJiD3zytuVHDBSmLBzz8RFPmAQmqK-e3_zxBAu6rkkYapbalA6wyf-w3X4ZxvMV8-wUGDp7AxG3w
         */

        private String nickname;
        private String mobile;
        private String photo;
        private int id;
        private int userType;
        private String token;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "nickname='" + nickname + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", photo='" + photo + '\'' +
                    ", id=" + id +
                    ", userType=" + userType +
                    ", token='" + token + '\'' +
                    '}';
        }
    }
}
