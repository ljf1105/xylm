package com.example.popo.xylm.xylm;


import com.example.popo.xylm.data.beans.Code;
import com.example.popo.xylm.data.beans.HomeBean;
import com.example.popo.xylm.data.beans.Login;
import com.example.popo.xylm.data.beans.Preference;
import com.example.popo.xylm.data.beans.ResetPass;
import com.example.popo.xylm.data.beans.TokenBean;
import com.example.popo.xylm.data.beans.User;
import com.example.popo.xylm.utils.RetrofitUtils;

import io.reactivex.Observable;


/**
 * Created by TMVPHelper on 2018/07/26
 */
public class XylmModel implements XylmContract.Model {


    @Override
    public Observable<User> getUserData(String nickname, Integer sex, String photo, String mobile, String mobilePrefix, String mobileLocation, String psw) {
        return mineService.setDataUser(nickname,sex,photo,mobile,mobilePrefix,mobileLocation,psw);
    }

    @Override
    public Observable<Preference> getUserPre(String url) {
        return mineService.getPreference(url);
    }

    @Override
    public Observable<ResetPass> setPass(String mobile, String password) {
        return mineService.setResetPass(mobile,password);
    }

    @Override
    public Observable<Code> getYzm(String mobilePrefix, String mobile) {
        return mineService.getCodeYzm(mobilePrefix,mobile);
    }

    @Override
    public Observable<Code> getYzmSucess(String mobile, String authCode) {
        return mineService.isYzmSuccess(mobile,authCode);
    }

    @Override
    public Observable<Login> getLoginData(String mobile, String password) {
        return mineService.isLogin(mobile,password);
    }

    @Override
    public Observable<TokenBean> getToken() {
        return RetrofitUtils.getInstance().getMineService().appToken();
    }

    @Override
    public Observable<HomeBean> getHomeBean(Integer loginUserId) {
        return RetrofitUtils.getInstance().getMineService().homeData(loginUserId);
    }

}