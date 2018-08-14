package com.example.popo.xylm.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.data.beans.Code;
import com.example.popo.xylm.data.beans.HomeBean;
import com.example.popo.xylm.data.beans.Keys;
import com.example.popo.xylm.data.beans.Login;
import com.example.popo.xylm.data.beans.Preference;
import com.example.popo.xylm.data.beans.ResetPass;
import com.example.popo.xylm.data.beans.TokenBean;
import com.example.popo.xylm.data.beans.User;
import com.example.popo.xylm.utils.EditTextUtil;
import com.example.popo.xylm.utils.Exit;
import com.example.popo.xylm.utils.RegexCst;
import com.example.popo.xylm.utils.SPUtil;
import com.example.popo.xylm.xylm.XylmContract;
import com.example.popo.xylm.xylm.XylmModel;
import com.example.popo.xylm.xylm.XylmPresenter;

/**
 * 登录界面
 */

public class LoginActivity extends BaseActivity<XylmModel, XylmPresenter> implements View.OnClickListener, XylmContract.View {

    private TextView close;
    private TextView register;
    private EditText phone;
    private ImageView erroy;
    private EditText password;
    private ImageView erroy2;
    private Button login;
    private TextView forgetPass;
    private ImageView weixinLogin;
    private ImageView qqLogin;
    private ImageView wbLogin;
    private String phoneStr;
    private String passStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        (Exit.activityList).add(this);

    }

    @Override
    protected void initData() {

    }

    public void initView() {
        close = (TextView) findViewById(R.id.close);
        register = (TextView) findViewById(R.id.register);
        phone = (EditText) findViewById(R.id.phone);
        erroy = (ImageView) findViewById(R.id.erroy);
        password = (EditText) findViewById(R.id.password);
        erroy2 = (ImageView) findViewById(R.id.erroy2);
        login = (Button) findViewById(R.id.login);
        forgetPass = (TextView) findViewById(R.id.forgetPass);
        weixinLogin = (ImageView) findViewById(R.id.weixinLogin);
        qqLogin = (ImageView) findViewById(R.id.qqLogin);
        wbLogin = (ImageView) findViewById(R.id.wbLogin);
        login.setOnClickListener(this);
        close.setOnClickListener(this);
        register.setOnClickListener(this);
        forgetPass.setOnClickListener(this);
        weixinLogin.setOnClickListener(this);
        erroy.setOnClickListener(this);
        erroy2.setOnClickListener(this);
        phone.setOnClickListener(this);
        EditTextUtil.deleteA(password, erroy2);
        EditTextUtil.deleteA(phone, erroy);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    public void exit() {

        for (Activity act : Exit.activityList) {
            act.finish();
        }

        System.exit(0);
    }


    @Override
    public void onClick(View v) {
        phoneStr = phone.getText().toString();
        passStr = password.getText().toString();
        switch (v.getId()) {
            case R.id.login:
                //判断是否登录成功
                if (phoneStr.matches(RegexCst.REGEX_MOBILE_EXACT)) {
                    presenter.getDataLogin(phoneStr, passStr);
                    Log.e("------MOBILE------", phoneStr);
                    Log.e("------PASSWORD------", passStr);
                } else {
                    Toast.makeText(this, "不符合规则", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.close:
                exit();
                break;
            case R.id.register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.forgetPass:
                startActivity(new Intent(LoginActivity.this, BackActivity.class));
                break;
            case R.id.weixinLogin:
                break;
            case R.id.erroy:
                phone.setText("");
                erroy.setVisibility(View.GONE);
                break;
            case R.id.erroy2:
                password.setText("");
                erroy2.setVisibility(View.GONE);
                break;
        }
    }


    @Override
    public void showUser(User user) {

    }

    @Override
    public void showPreference(Preference preference) {

    }

    @Override
    public void showResetPass(ResetPass resetPass) {

    }

    @Override
    public void showYzm(Code code) {

    }

    @Override
    public void showYzmSucess(Code code) {

    }

    @Override
    public void showLogin(Login login) {
        String message = login.getMessage();
        Login.DataBean data = login.getData();
        String s = data.toString();
        int id = data.getId();
        SPUtil.getInstance().put(Keys.ID, id);
        SPUtil.getInstance().put(Keys.LOGIN_MOBILE, phoneStr);
        SPUtil.getInstance().put(Keys.LOGIN_PASSWORD, password);
        SPUtil.getInstance().put(Keys.LOGIN_IMAGE, data.getPhoto());
        SPUtil.getInstance().put(Keys.LOGIN_NAME, data.getNickname());
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        Log.e("----------login", s);
        Log.e("---------messege----", message);
        Log.e("---------messegeId----", id + "");
    }


    @Override
    public void showToken(TokenBean tokenBean) {

    }

    @Override
    public void showHome(HomeBean homeBean) {

    }
}
