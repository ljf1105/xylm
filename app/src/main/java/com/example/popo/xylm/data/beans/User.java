package com.example.popo.xylm.data.beans;

/**
 * Created by popo on 2018/7/28.
 */

public class User {

    /**
     * code : 0
     * message : 成功
     * data : {"nickname":"3681532","mobile":null,"photo":"http://qiniu.5roo.com/a7403589-54e6-4a25-b0f7-e1190c8f6b8c.png","id":1640,"userType":null,"token":"eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiIzNzljanYiLCJzdWIiOiIxNjQwIiwiZXhwIjoxNTMzMzYzOTQzLCJpYXQiOjE1MzI3NTkxNDN9.QitNCb7znX5xTawb8OZQBLuk0Nlp7JW2e1DgJrPF9_SQCp8YXRM90B3rCbTJJaCvXAE8d96sq_ZBW3gkh2BfBg"}
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
         * nickname : 3681532
         * mobile : null
         * photo : http://qiniu.5roo.com/a7403589-54e6-4a25-b0f7-e1190c8f6b8c.png
         * id : 1640
         * userType : null
         * token : eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiIzNzljanYiLCJzdWIiOiIxNjQwIiwiZXhwIjoxNTMzMzYzOTQzLCJpYXQiOjE1MzI3NTkxNDN9.QitNCb7znX5xTawb8OZQBLuk0Nlp7JW2e1DgJrPF9_SQCp8YXRM90B3rCbTJJaCvXAE8d96sq_ZBW3gkh2BfBg
         */

        private String nickname;
        private Object mobile;
        private String photo;
        private int id;
        private Object userType;
        private String token;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
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

        public Object getUserType() {
            return userType;
        }

        public void setUserType(Object userType) {
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
                    ", mobile=" + mobile +
                    ", photo='" + photo + '\'' +
                    ", id=" + id +
                    ", userType=" + userType +
                    ", token='" + token + '\'' +
                    '}';
        }
    }
}
