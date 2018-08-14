package com.example.popo.xylm.xylm;


import com.example.popo.xylm.data.beans.Code;
import com.example.popo.xylm.data.beans.HomeBean;
import com.example.popo.xylm.data.beans.Login;
import com.example.popo.xylm.data.beans.Preference;
import com.example.popo.xylm.data.beans.ResetPass;
import com.example.popo.xylm.data.beans.TokenBean;
import com.example.popo.xylm.data.beans.User;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by TMVPHelper on 2018/07/26
 */
public class XylmPresenter extends XylmContract.Presenter {


    @Override
    public void getDataUser(String nickname, Integer sex, String photo, String mobile, String mobilePrefix, String mobileLocation, String psw) {
        m.getUserData(nickname, sex, photo, mobile, mobilePrefix, mobileLocation, psw)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        v.showUser(user);
                    }
                });
    }

    @Override
    public void getPreUser(String url) {
        m.getUserPre(url)
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Preference>() {
                    @Override
                    public void accept(Preference preference) throws Exception {
                        v.showPreference(preference);
                    }
                });
    }

    //重置密码
    @Override
    public void setPassData(String mobile, String password) {
        m.setPass(mobile, password)
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResetPass>() {
                    @Override
                    public void accept(ResetPass resetPass) throws Exception {
                        v.showResetPass(resetPass);
                    }
                });
    }


    //获取验证码
    @Override
    public void getYzmData(String mobilePrefix, String mobile) {
        m.getYzm(mobilePrefix, mobile)
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Code>() {
                    @Override
                    public void accept(Code code) throws Exception {
                        v.showYzm(code);
                    }
                });
    }

    //判断验证码是否正确
    @Override
    public void getYzmDataSucess(String mobile, String authCode) {
        m.getYzmSucess(mobile, authCode)
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Code>() {
                    @Override
                    public void accept(Code code) throws Exception {
                        v.showYzmSucess(code);
                    }
                });
    }

    //登录

    //登录获取首页数据
    @Override
    public void getDataLogin(String mobile, String password) {
        m.getLoginData(mobile, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Login>() {
                    @Override
                    public void accept(Login login) throws Exception {
                        v.showLogin(login);
                    }
                });
    }

    @Override
    public void getDataToken() {
        m.getToken()
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TokenBean>() {
                    @Override
                    public void accept(TokenBean tokenBean) throws Exception {

                        v.showToken(tokenBean);
                    }
                });
    }

    //获取首页数据
    @Override
    public void getDataHome(Integer loginUserId) {
        m.getHomeBean(loginUserId)
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeBean>() {
                    @Override
                    public void accept(HomeBean homeBean) throws Exception {
                        v.showHome(homeBean);
                    }
                });
    }
}