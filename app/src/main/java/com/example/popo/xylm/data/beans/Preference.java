package com.example.popo.xylm.data.beans;

import java.util.List;

/**
 * Created by popo on 2018/7/29.
 */

public class Preference {

    /**
     * code : 0
     * data : {"colleges":[{"id":1,"name":"中央音乐学院","page":1,"rows":20,"sortord":1},{"id":2,"name":"中央美术学院","page":1,"rows":20,"sortord":2},{"id":3,"name":"中央戏剧学院","page":1,"rows":20,"sortord":3},{"id":4,"name":"北京电影学院","page":1,"rows":20,"sortord":4},{"id":5,"name":"北京舞蹈学院","page":1,"rows":20,"sortord":5},{"id":6,"name":"鲁迅美术学院","page":1,"rows":20,"sortord":6},{"id":7,"name":"上海戏剧学院","page":1,"rows":20,"sortord":7},{"id":8,"name":"中国戏曲学院","page":1,"rows":20,"sortord":8},{"id":9,"name":"南京艺术学院","page":1,"rows":20,"sortord":9},{"id":10,"name":"四川美术学院","page":1,"rows":20,"sortord":10},{"id":11,"name":"四川音乐学院","page":1,"rows":20,"sortord":11},{"id":12,"name":"沈阳音乐学院","page":1,"rows":20,"sortord":12},{"id":14,"name":"中国音乐学院","page":1,"rows":20,"sortord":13},{"id":15,"name":"中央工艺美术学院","page":1,"rows":20},{"id":16,"name":"北京师范大学","page":1,"rows":20},{"id":17,"name":"山西工商学院","page":1,"rows":20},{"id":19,"name":"武汉音乐学院","page":1,"rows":20},{"id":20,"name":"中南民族大学","page":1,"rows":20},{"id":21,"name":"河北传媒学院","page":1,"rows":20},{"id":23,"name":"陕西师范大学","page":1,"rows":20},{"id":25,"name":"西安培华学院","page":1,"rows":20},{"id":26,"name":"北京现代音乐学院","page":1,"rows":20},{"id":27,"name":"中国传媒大学","page":1,"rows":20},{"id":28,"name":"首都师范大学","page":1,"rows":20},{"id":29,"name":"广东外语外贸大学","page":1,"rows":20},{"id":30,"name":"广州美术学院","page":1,"rows":20},{"id":31,"name":"东北农业大学","page":1,"rows":20},{"id":32,"name":"英国伦敦大学","page":1,"rows":20},{"id":33,"name":"首都师范大学科德学院","page":1,"rows":20},{"id":34,"name":"对外经贸大学","page":1,"rows":20},{"id":35,"name":"重庆大学美视电影学院","page":1,"rows":20},{"id":36,"name":"北京联合大学","page":1,"rows":20},{"id":37,"name":"清华大学美术学院","page":1,"rows":20},{"id":40,"name":"北京舞蹈学院附中","page":1,"rows":20},{"id":41,"name":"北京体育大学","page":1,"rows":20},{"id":42,"name":"北京大学","page":1,"rows":20},{"id":43,"name":"法国GPSO大巴黎国立音乐学院","page":1,"rows":20},{"id":44,"name":"中央民族大学","page":1,"rows":20},{"id":45,"name":"井冈山大学","page":1,"rows":20},{"id":46,"name":"印度国立大学","page":1,"rows":20},{"id":47,"name":"美国Oberlin音乐学院","page":1,"rows":20}],"majors":[{"color":"#7ED321","id":6,"intro":"表演，旨在培养具有一定的基本理论素养，并具备和掌握表演艺术的基本理论和基本技巧，能够在戏剧、戏曲、电影、电视和舞蹈等表演中独立完成不同人物形象创作的高级专门人才。 ","name":"表演","pId":0,"page":1,"photo":"http://qiniu.5roo.com/b93a8ea1-93ea-4100-8c5a-97165222d71f.jpg","rows":20,"sortord":8,"thumbPhoto":"http://qiniu.5roo.com/0a726477-248b-45a9-8ebe-7378497c8bc3.jpg"},{"color":"#F35633","id":32,"intro":"舞蹈的任务是，以其掌握的舞蹈动作、造型和技巧能力，结合音乐和美术等艺术手段，将作品的思想内容转化为可视可感的舞蹈形象。","name":"舞蹈","pId":0,"page":1,"photo":"http://qiniu.5roo.com/6e5ba2d0-5b9d-4ca9-bdc4-8fc51b2bea58.jpg","rows":20,"sortord":7,"thumbPhoto":"http://qiniu.5roo.com/292a419e-b0c1-4bca-a5eb-231e38764c10.jpg"},{"color":"#5491FF","id":7,"intro":"美术专业为美术史论、美术教育领域培养教学和科研，美术评论和编辑、艺术管理和博物馆等方面的高级专门人才，学生毕业后能从事美术教育、美术研究、文博艺术管理、新闻出版等方面的工作。","name":"美术","pId":0,"page":1,"photo":"http://qiniu.5roo.com/171c4295-cc47-42f6-a116-6f1ae046e192.jpg","rows":20,"sortord":6,"thumbPhoto":"http://qiniu.5roo.com/0d717efd-47be-4d36-b897-e92849fc743a.jpg"},{"color":"#F5A623","id":1,"intro":"音乐，分为声乐和器乐。","name":"音乐","pId":0,"page":1,"photo":"http://qiniu.5roo.com/396dbe91-a8a1-4ee9-8109-6192ed734e28.jpg","rows":20,"sortord":4,"thumbPhoto":"http://qiniu.5roo.com/6babe952-5b9e-4849-b80b-8dda43b8d18e.jpg"}]}
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
        private List<CollegesBean> colleges;
        private List<MajorsBean> majors;

        public List<CollegesBean> getColleges() {
            return colleges;
        }

        public void setColleges(List<CollegesBean> colleges) {
            this.colleges = colleges;
        }

        public List<MajorsBean> getMajors() {
            return majors;
        }

        public void setMajors(List<MajorsBean> majors) {
            this.majors = majors;
        }

        public static class CollegesBean {
            /**
             * id : 1
             * name : 中央音乐学院
             * page : 1
             * rows : 20
             * sortord : 1
             */

            private int id;
            private String name;
            private int page;
            private int rows;
            private int sortord;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            public int getSortord() {
                return sortord;
            }

            public void setSortord(int sortord) {
                this.sortord = sortord;
            }
        }

        public static class MajorsBean {
            /**
             * color : #7ED321
             * id : 6
             * intro : 表演，旨在培养具有一定的基本理论素养，并具备和掌握表演艺术的基本理论和基本技巧，能够在戏剧、戏曲、电影、电视和舞蹈等表演中独立完成不同人物形象创作的高级专门人才。
             * name : 表演
             * pId : 0
             * page : 1
             * photo : http://qiniu.5roo.com/b93a8ea1-93ea-4100-8c5a-97165222d71f.jpg
             * rows : 20
             * sortord : 8
             * thumbPhoto : http://qiniu.5roo.com/0a726477-248b-45a9-8ebe-7378497c8bc3.jpg
             */

            private String color;
            private int id;
            private String intro;
            private String name;
            private int pId;
            private int page;
            private String photo;
            private int rows;
            private int sortord;
            private String thumbPhoto;

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPId() {
                return pId;
            }

            public void setPId(int pId) {
                this.pId = pId;
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

            public int getRows() {
                return rows;
            }

            public void setRows(int rows) {
                this.rows = rows;
            }

            public int getSortord() {
                return sortord;
            }

            public void setSortord(int sortord) {
                this.sortord = sortord;
            }

            public String getThumbPhoto() {
                return thumbPhoto;
            }

            public void setThumbPhoto(String thumbPhoto) {
                this.thumbPhoto = thumbPhoto;
            }
        }
    }
}
