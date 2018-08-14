package com.example.popo.xylm.xylm;

import com.example.popo.xylm.base.BaseModel;
import com.example.popo.xylm.base.BasePresenter;
import com.example.popo.xylm.base.BaseView;
import com.example.popo.xylm.data.beans.Code;
import com.example.popo.xylm.data.beans.HomeBean;
import com.example.popo.xylm.data.beans.Login;
import com.example.popo.xylm.data.beans.Preference;
import com.example.popo.xylm.data.beans.ResetPass;
import com.example.popo.xylm.data.beans.TokenBean;
import com.example.popo.xylm.data.beans.User;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by popo on 2018/7/26.
 */

public class XylmContract {

    public interface View extends BaseView {
        void showUser(User user);
        void showPreference(Preference preference);
        void showResetPass(ResetPass resetPass);
        void showYzm(Code code);
        void showYzmSucess(Code code);
        void showLogin(Login login);
        void showToken(TokenBean tokenBean);
        void showHome(HomeBean homeBean);
    }

    public interface Model extends BaseModel {
        Observable<User> getUserData(String nickname,Integer sex,String photo,String mobile,String mobilePrefix,String mobileLocation,String psw);
        Observable<Preference> getUserPre(String url);
        Observable<ResetPass> setPass(String mobile,String password);
        Observable<Code> getYzm(String mobilePrefix,String mobile);
        Observable<Code> getYzmSucess(String mobile, String authCode);
        Observable<Login> getLoginData(String mobile,String password);
        Observable<TokenBean> getToken();
        Observable<HomeBean> getHomeBean(Integer loginUserId);
    }

    public abstract static class Presenter extends BasePresenter<Model, View> {
        public abstract void getDataUser(String nickname,Integer sex,String photo,String mobile,String mobilePrefix,String mobileLocation,String psw);
        public abstract void getPreUser(String url);
        public abstract void setPassData(String mobile,String password);
        public abstract void getYzmData(String mobilePrefix,String mobile);
        public abstract void getYzmDataSucess(String mobile,String authCode);
        public abstract void getDataLogin(String mobile,String password);
        public abstract void getDataToken();
        public abstract void getDataHome(Integer loginUserId);
    }
}