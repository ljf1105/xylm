package com.example.popo.xylm.constact;


import com.example.popo.xylm.data.banner.ShowImage;
import com.example.popo.xylm.data.beans.ChongZhi;
import com.example.popo.xylm.data.beans.Code;
import com.example.popo.xylm.data.beans.Comment;
import com.example.popo.xylm.data.beans.CzDingDan;
import com.example.popo.xylm.data.beans.HomeBean;
import com.example.popo.xylm.data.beans.HomeWorks;
import com.example.popo.xylm.data.beans.LiveBean;
import com.example.popo.xylm.data.beans.Login;
import com.example.popo.xylm.data.beans.MingTeacher;
import com.example.popo.xylm.data.beans.Preference;
import com.example.popo.xylm.data.beans.ResetPass;
import com.example.popo.xylm.data.beans.TokenBean;
import com.example.popo.xylm.data.beans.User;
import com.example.popo.xylm.data.beans.WorkXq;
import com.example.popo.xylm.data.beans.YkHome;
import com.example.popo.xylm.data.beans.ZhiFu;


import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

/**
 * Created by popo on 2018/7/27.
 */

public interface MineService {

    //获取短信验证码
    @FormUrlEncoded
    @POST(Urls.AUTHCODE)
    Call<ResponseBody> getCode(@Field("mobilePrefix") String mobilePrefix, @Field("mobile") String mobile);

    //获取短信验证码MVP
    @FormUrlEncoded
    @POST(Urls.AUTHCODE)
    Observable<Code> getCodeYzm(@Field("mobilePrefix") String mobilePrefix, @Field("mobile") String mobile);

    //判断手机号是否存在
    @FormUrlEncoded
    @POST(Urls.VERIFYMOBILE)
    Call<ResponseBody> isPhone(@Field("mobile") String mobile);

    //判断验证码是否正确
    @FormUrlEncoded
    @POST(Urls.VERIFYAUTHCODE)
    Call<ResponseBody> isCode(@Field("mobile") String mobile, @Field("authCode") String authCode);

    //判断验证码是否正确MVP
    @FormUrlEncoded
    @POST(Urls.VERIFYAUTHCODE)
    Observable<Code> isYzmSuccess(@Field("mobile") String mobile, @Field("authCode") String authCode);

    //注册
    @FormUrlEncoded
    @POST(Urls.REGISTER)
    Call<ResponseBody> isRegister(@Field("mobile") String mobile, @Field("mobileValidCode") String mobileValidCode);

    //上传头像
    @Multipart
    @POST(Urls.UPLOADUSERICON)
    Observable<ResponseBody> upload(@Part MultipartBody.Part parts);

    //完善注册信息
    @FormUrlEncoded
    @POST(Urls.REGISTER)
    Observable<User> setDataUser(@Field("nickname") String nickname, @Field("sex") Integer sex, @Field("photo") String photo, @Field("mobile") String mobile, @Field("mobilePrefix") String mobilePrefix, @Field("mobileLocation") String mobileLocation, @Field("psw") String psw);

    //获取偏好
    @GET()
    Observable<Preference> getPreference(@Url String url);

    //重置密码 找回密码
    @FormUrlEncoded
    @POST(Urls.RESECTPASS)
    Observable<ResetPass> setResetPass(@Field("mobile") String mobile, @Field("password") String password);

    //登录
    @FormUrlEncoded
    @POST(Urls.LOGIN)
    Observable<Login> isLogin(@Field("mobile") String mobile, @Field("password") String password);

    //验证Token
    @POST(Urls.APPTOKEN)
    Observable<TokenBean> appToken();

    //获取首页数据
    @FormUrlEncoded
    @POST(Urls.HOMELIST)
    Observable<HomeBean> homeData(@Field("loginUserId") Integer str);

    //获取交作品数据
    @FormUrlEncoded
    @POST(Urls.HOMEWORK)
    Observable<HomeWorks> homeWorkData(@Field("sortord") Integer sortord);

    //获取作品详情数据
    @FormUrlEncoded
    @POST(Urls.WORKXQ)
    Observable<WorkXq> workXqData(@Field("homewokId") Integer homewokId);

    //获取作品详情评论数据
    @FormUrlEncoded
    @POST(Urls.HOMECOMMENTS)
    Observable<Comment> workComment(@Field("homewokId") Integer homewokId);

    //获取艺考轮播图
    @POST(Urls.SLIDESHOW)
    Observable<ShowImage> ykShowImages();

    //获取艺考首页
    @FormUrlEncoded
    @POST(Urls.YKHOME)
    Observable<YkHome> ykHome(@Field("sortord") Integer sortord);

    //获取名师列表
    @FormUrlEncoded
    @POST(Urls.TEACHERLIST)
    Observable<MingTeacher> getTeacherList(@Field("userType") Integer userType);

    //获取课程列表
    @FormUrlEncoded
    @POST(Urls.LIVELIST)
    Observable<LiveBean> getLiveList(@Field("type") String type);

    //获取课程列表
    @FormUrlEncoded
    @POST(Urls.CHONGZHI)
    Observable<ChongZhi> getCzList(@Field("loginUserId") Integer loginUserId);

    //获取金豆充值订单
    @FormUrlEncoded
    @POST(Urls.CHONGZHIDINGDAN)
    Observable<CzDingDan> getCzDingDan(@Field("buyerId") Integer buyerId, @Field("price") double price, @Field("amount") Integer amount);

    //拉起支付宝支付订单
    @FormUrlEncoded
    @POST(Urls.ALIPAYZHIFU)
    Observable<ZhiFu> getCzDingDan(@Field("orderNo") String orderNo);

}