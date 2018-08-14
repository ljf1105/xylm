package com.example.popo.xylm.constact;

/**
 * Created by popo on 2018/7/27.
 */

public class Urls {
    //服务器地址
    public static final String BASEURL = "https://www.univstar.com/";
    //获取短信验证码
    public static final String AUTHCODE = "v1/m/user/authcode";
    //判断手机号是否存在
    public static final String VERIFYMOBILE = "v1/m/user/verify/mobile";
    //判断验证码是否正确
    public static final String VERIFYAUTHCODE = "v1/m/user/verify/authcode";
    //注册
    public static final String REGISTER = "v1/m/user/register/mobile";
    //上传头像
    public static final String UPLOADUSERICON = "v1/m/qiniu/qiniuUpload";
    //把头像上传到七牛仓库
    public static final String UPLOADUQINIU = "/v1/m/user/uploadPhoto";
    //完善注册信息
    public static final String SAVECOMPLETEUSER = "v1/m/user/saveCompleteUser";
    //获取偏好
    public static final String PREFERENCE = "v1/m/user/preference";
    //重置密码、找回密码
    public static final String RESECTPASS = "v1/m/user/save/password";
    //登录
    public static final String LOGIN = "v1/m/user/login/mobile";
    //获取首页数据
    public static final String HOMELIST = "v1/m/home/alliance/list";
    //验证Token接口
    public static final String APPTOKEN = "v1/m/security/apptoken";
    //交作品接口
    public static final String HOMEWORK = "v1/m/homewok/home";
    //作品详情
    public static final String WORKXQ = "v1/m/homewok/detail";
    //作品评论详情
    public static final String HOMECOMMENTS = "v1/m/homewok/comments";
    //艺考圈轮播图
    public static final String SLIDESHOW = "v1/m/artcircle/slideshow";
    //艺考圈首页
    public static final String YKHOME = "v1/m/artcircle/home";
    //名师列表
    public static final String TEACHERLIST = "v1/m/user/teacher/list";
    //课程列表
    public static final String LIVELIST = "v1/m/liveCourse/list";
    //星豆充值价格列表
    public static final String CHONGZHI = "v1/m/record/bean/detail";
    //星豆充值生成订单
    public static final String CHONGZHIDINGDAN = "v1/m/order/save/recharge";
    //支付宝支付
    public static final String ALIPAYZHIFU = "v1/m/alipay/params";
}
