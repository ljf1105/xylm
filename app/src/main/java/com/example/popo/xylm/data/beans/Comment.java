package com.example.popo.xylm.data.beans;

import java.util.List;

/**
 * Created by popo on 2018/8/5.
 */

public class Comment {

    /**
     * code : 0
     * message : 成功
     * data : {"comments":{"pageNum":1,"pageSize":20,"size":8,"startRow":1,"endRow":8,"total":8,"pages":1,"list":[{"nickname":"潇雨哲","replyNum":1,"photo":"http://qiniu.5roo.com/9e0d2db4-5485-46e7-8385-53b43acfddd6.jpg","isPraise":0,"praiseNum":8,"id":879,"userType":1,"userId":480,"content":"评论","realname":null,"createDate":1530261173000},{"nickname":"Timeless°","replyNum":0,"photo":"http://qiniu.5roo.com/a57d2ed9b7134145a3ae89042694aadc.jpg","isPraise":0,"praiseNum":2,"id":923,"userType":1,"userId":1559,"content":"加油 努力","realname":null,"createDate":1533288293000},{"nickname":"景","replyNum":0,"photo":"http://qiniu.5roo.com/d5bac95ef4c542b5ab3114b9ea1d33d0.jpg","isPraise":0,"praiseNum":0,"id":961,"userType":1,"userId":1782,"content":"评论1111","realname":null,"createDate":1533369756000},{"nickname":"999","replyNum":0,"photo":"http://qiniu.5roo.com/b83a6a6cff6a4749af84d2bb006a7673.jpg","isPraise":0,"praiseNum":0,"id":930,"userType":1,"userId":1618,"content":"加油","realname":null,"createDate":1533346803000},{"nickname":"mm","replyNum":0,"photo":"http://qiniu.5roo.com/27f8f350-d4ef-4d13-9f6e-af31d247fba2.jpg","isPraise":0,"praiseNum":0,"id":913,"userType":1,"userId":1563,"content":"一起加油(ง \u2022̀_\u2022́)ง","realname":null,"createDate":1533124696000},{"nickname":"调戏猫的老鼠","replyNum":0,"photo":"http://qiniu.5roo.com/9c65fc6f561d4f23ac5e15f845bb230e.jpg","isPraise":0,"praiseNum":0,"id":893,"userType":1,"userId":1572,"content":"1","realname":null,"createDate":1532915044000},{"nickname":null,"replyNum":0,"photo":null,"isPraise":0,"praiseNum":0,"id":877,"userType":null,"userId":1138,"content":"评论","realname":null,"createDate":1530165402000},{"nickname":"糖果","replyNum":0,"photo":"http://qiniu.5roo.com/4f2dd4b9-3f6a-4f19-8fc4-36810f62ebb8.jpg","isPraise":0,"praiseNum":0,"id":876,"userType":1,"userId":198,"content":"评论","realname":null,"createDate":1530165335000}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}}
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
         * comments : {"pageNum":1,"pageSize":20,"size":8,"startRow":1,"endRow":8,"total":8,"pages":1,"list":[{"nickname":"潇雨哲","replyNum":1,"photo":"http://qiniu.5roo.com/9e0d2db4-5485-46e7-8385-53b43acfddd6.jpg","isPraise":0,"praiseNum":8,"id":879,"userType":1,"userId":480,"content":"评论","realname":null,"createDate":1530261173000},{"nickname":"Timeless°","replyNum":0,"photo":"http://qiniu.5roo.com/a57d2ed9b7134145a3ae89042694aadc.jpg","isPraise":0,"praiseNum":2,"id":923,"userType":1,"userId":1559,"content":"加油 努力","realname":null,"createDate":1533288293000},{"nickname":"景","replyNum":0,"photo":"http://qiniu.5roo.com/d5bac95ef4c542b5ab3114b9ea1d33d0.jpg","isPraise":0,"praiseNum":0,"id":961,"userType":1,"userId":1782,"content":"评论1111","realname":null,"createDate":1533369756000},{"nickname":"999","replyNum":0,"photo":"http://qiniu.5roo.com/b83a6a6cff6a4749af84d2bb006a7673.jpg","isPraise":0,"praiseNum":0,"id":930,"userType":1,"userId":1618,"content":"加油","realname":null,"createDate":1533346803000},{"nickname":"mm","replyNum":0,"photo":"http://qiniu.5roo.com/27f8f350-d4ef-4d13-9f6e-af31d247fba2.jpg","isPraise":0,"praiseNum":0,"id":913,"userType":1,"userId":1563,"content":"一起加油(ง \u2022̀_\u2022́)ง","realname":null,"createDate":1533124696000},{"nickname":"调戏猫的老鼠","replyNum":0,"photo":"http://qiniu.5roo.com/9c65fc6f561d4f23ac5e15f845bb230e.jpg","isPraise":0,"praiseNum":0,"id":893,"userType":1,"userId":1572,"content":"1","realname":null,"createDate":1532915044000},{"nickname":null,"replyNum":0,"photo":null,"isPraise":0,"praiseNum":0,"id":877,"userType":null,"userId":1138,"content":"评论","realname":null,"createDate":1530165402000},{"nickname":"糖果","replyNum":0,"photo":"http://qiniu.5roo.com/4f2dd4b9-3f6a-4f19-8fc4-36810f62ebb8.jpg","isPraise":0,"praiseNum":0,"id":876,"userType":1,"userId":198,"content":"评论","realname":null,"createDate":1530165335000}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
         */

        private CommentsBean comments;

        public CommentsBean getComments() {
            return comments;
        }

        public void setComments(CommentsBean comments) {
            this.comments = comments;
        }

        public static class CommentsBean {
            /**
             * pageNum : 1
             * pageSize : 20
             * size : 8
             * startRow : 1
             * endRow : 8
             * total : 8
             * pages : 1
             * list : [{"nickname":"潇雨哲","replyNum":1,"photo":"http://qiniu.5roo.com/9e0d2db4-5485-46e7-8385-53b43acfddd6.jpg","isPraise":0,"praiseNum":8,"id":879,"userType":1,"userId":480,"content":"评论","realname":null,"createDate":1530261173000},{"nickname":"Timeless°","replyNum":0,"photo":"http://qiniu.5roo.com/a57d2ed9b7134145a3ae89042694aadc.jpg","isPraise":0,"praiseNum":2,"id":923,"userType":1,"userId":1559,"content":"加油 努力","realname":null,"createDate":1533288293000},{"nickname":"景","replyNum":0,"photo":"http://qiniu.5roo.com/d5bac95ef4c542b5ab3114b9ea1d33d0.jpg","isPraise":0,"praiseNum":0,"id":961,"userType":1,"userId":1782,"content":"评论1111","realname":null,"createDate":1533369756000},{"nickname":"999","replyNum":0,"photo":"http://qiniu.5roo.com/b83a6a6cff6a4749af84d2bb006a7673.jpg","isPraise":0,"praiseNum":0,"id":930,"userType":1,"userId":1618,"content":"加油","realname":null,"createDate":1533346803000},{"nickname":"mm","replyNum":0,"photo":"http://qiniu.5roo.com/27f8f350-d4ef-4d13-9f6e-af31d247fba2.jpg","isPraise":0,"praiseNum":0,"id":913,"userType":1,"userId":1563,"content":"一起加油(ง \u2022̀_\u2022́)ง","realname":null,"createDate":1533124696000},{"nickname":"调戏猫的老鼠","replyNum":0,"photo":"http://qiniu.5roo.com/9c65fc6f561d4f23ac5e15f845bb230e.jpg","isPraise":0,"praiseNum":0,"id":893,"userType":1,"userId":1572,"content":"1","realname":null,"createDate":1532915044000},{"nickname":null,"replyNum":0,"photo":null,"isPraise":0,"praiseNum":0,"id":877,"userType":null,"userId":1138,"content":"评论","realname":null,"createDate":1530165402000},{"nickname":"糖果","replyNum":0,"photo":"http://qiniu.5roo.com/4f2dd4b9-3f6a-4f19-8fc4-36810f62ebb8.jpg","isPraise":0,"praiseNum":0,"id":876,"userType":1,"userId":198,"content":"评论","realname":null,"createDate":1530165335000}]
             * prePage : 0
             * nextPage : 0
             * isFirstPage : true
             * isLastPage : true
             * hasPreviousPage : false
             * hasNextPage : false
             * navigatePages : 8
             * navigatepageNums : [1]
             * navigateFirstPage : 1
             * navigateLastPage : 1
             * firstPage : 1
             * lastPage : 1
             */

            private int pageNum;
            private int pageSize;
            private int size;
            private int startRow;
            private int endRow;
            private int total;
            private int pages;
            private int prePage;
            private int nextPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private boolean hasPreviousPage;
            private boolean hasNextPage;
            private int navigatePages;
            private int navigateFirstPage;
            private int navigateLastPage;
            private int firstPage;
            private int lastPage;
            private List<ListBean> list;
            private List<Integer> navigatepageNums;

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public int getNavigateFirstPage() {
                return navigateFirstPage;
            }

            public void setNavigateFirstPage(int navigateFirstPage) {
                this.navigateFirstPage = navigateFirstPage;
            }

            public int getNavigateLastPage() {
                return navigateLastPage;
            }

            public void setNavigateLastPage(int navigateLastPage) {
                this.navigateLastPage = navigateLastPage;
            }

            public int getFirstPage() {
                return firstPage;
            }

            public void setFirstPage(int firstPage) {
                this.firstPage = firstPage;
            }

            public int getLastPage() {
                return lastPage;
            }

            public void setLastPage(int lastPage) {
                this.lastPage = lastPage;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public List<Integer> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<Integer> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public static class ListBean {
                /**
                 * nickname : 潇雨哲
                 * replyNum : 1
                 * photo : http://qiniu.5roo.com/9e0d2db4-5485-46e7-8385-53b43acfddd6.jpg
                 * isPraise : 0
                 * praiseNum : 8
                 * id : 879
                 * userType : 1
                 * userId : 480
                 * content : 评论
                 * realname : null
                 * createDate : 1530261173000
                 */

                private String nickname;
                private int replyNum;
                private String photo;
                private int isPraise;
                private int praiseNum;
                private int id;
                private int userType;
                private int userId;
                private String content;
                private Object realname;
                private long createDate;

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public int getReplyNum() {
                    return replyNum;
                }

                public void setReplyNum(int replyNum) {
                    this.replyNum = replyNum;
                }

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }

                public int getIsPraise() {
                    return isPraise;
                }

                public void setIsPraise(int isPraise) {
                    this.isPraise = isPraise;
                }

                public int getPraiseNum() {
                    return praiseNum;
                }

                public void setPraiseNum(int praiseNum) {
                    this.praiseNum = praiseNum;
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

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public Object getRealname() {
                    return realname;
                }

                public void setRealname(Object realname) {
                    this.realname = realname;
                }

                public long getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(long createDate) {
                    this.createDate = createDate;
                }
            }
        }
    }
}
