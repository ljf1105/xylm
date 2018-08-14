package com.example.popo.xylm.data.beans;

/**
 * Created by popo on 2018/7/29.
 */

public class ResetPass {

    /**
     * code : 0
     * data : {"beanAmount":0,"createDate":1532570254000,"id":1559,"isauth":0,"lastTime":1532570254000,"mobile":"15034591419","nickname":"Timeless°","page":1,"photo":"http://qiniu.5roo.com/a57d2ed9b7134145a3ae89042694aadc.jpg","pid":0,"psw":"819e5692ba0680337039139d51085e60772409105659013e","rows":20,"salt":"1520079915029593","sex":0,"status":0,"teacherCoursePrice":0,"userType":1}
     * message : 成功
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * beanAmount : 0
         * createDate : 1532570254000
         * id : 1559
         * isauth : 0
         * lastTime : 1532570254000
         * mobile : 15034591419
         * nickname : Timeless°
         * page : 1
         * photo : http://qiniu.5roo.com/a57d2ed9b7134145a3ae89042694aadc.jpg
         * pid : 0
         * psw : 819e5692ba0680337039139d51085e60772409105659013e
         * rows : 20
         * salt : 1520079915029593
         * sex : 0
         * status : 0
         * teacherCoursePrice : 0
         * userType : 1
         */

        private int beanAmount;
        private long createDate;
        private int id;
        private int isauth;
        private long lastTime;
        private String mobile;
        private String nickname;
        private int page;
        private String photo;
        private int pid;
        private String psw;
        private int rows;
        private String salt;
        private int sex;
        private int status;
        private int teacherCoursePrice;
        private int userType;

        public int getBeanAmount() {
            return beanAmount;
        }

        public void setBeanAmount(int beanAmount) {
            this.beanAmount = beanAmount;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsauth() {
            return isauth;
        }

        public void setIsauth(int isauth) {
            this.isauth = isauth;
        }

        public long getLastTime() {
            return lastTime;
        }

        public void setLastTime(long lastTime) {
            this.lastTime = lastTime;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getPsw() {
            return psw;
        }

        public void setPsw(String psw) {
            this.psw = psw;
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getTeacherCoursePrice() {
            return teacherCoursePrice;
        }

        public void setTeacherCoursePrice(int teacherCoursePrice) {
            this.teacherCoursePrice = teacherCoursePrice;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }
    }
}
