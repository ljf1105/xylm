package com.example.popo.xylm.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.data.beans.Code;
import com.example.popo.xylm.data.beans.HomeBean;
import com.example.popo.xylm.data.beans.Login;
import com.example.popo.xylm.data.beans.Preference;
import com.example.popo.xylm.data.beans.ResetPass;
import com.example.popo.xylm.data.beans.TokenBean;
import com.example.popo.xylm.data.beans.User;
import com.example.popo.xylm.utils.CountDownTimerUtils;
import com.example.popo.xylm.utils.EditTextUtil;
import com.example.popo.xylm.utils.RegexCst;
import com.example.popo.xylm.xylm.XylmContract;
import com.example.popo.xylm.xylm.XylmModel;
import com.example.popo.xylm.xylm.XylmPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BackActivity extends BaseActivity<XylmModel, XylmPresenter> implements XylmContract.View {

    @BindView(R.id.backTool)
    Toolbar backTool;
    @BindView(R.id.backPhone)
    EditText backPhone;
    @BindView(R.id.backErroy)
    ImageView backErroy;
    @BindView(R.id.backPassword)
    EditText backPassword;
    @BindView(R.id.backErroy2)
    ImageView backErroy2;
    @BindView(R.id.NextBtn)
    Button NextBtn;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.getYzm)
    Button getYzm;
    private String phoneStr;
    private String message;
    private String zqMessage;
    private String codeStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        ButterKnife.bind(this);
        initTool();
        EditTextUtil.deleteA(backPhone,backErroy);
        EditTextUtil.deleteA(backPassword,backErroy2);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_back;
    }

    private void initTool() {
        backTool.setTitle("");
        setSupportActionBar(backTool);
    }

    @OnClick({R.id.backPhone, R.id.backErroy, R.id.backPassword, R.id.backErroy2, R.id.NextBtn, R.id.back,R.id.getYzm})
    public void onViewClicked(View view) {
        phoneStr = backPhone.getText().toString();
        codeStr = backPassword.getText().toString();
        switch (view.getId()) {
            case R.id.backPhone:
                break;
            case R.id.backErroy:
                backPhone.setText("");
                backErroy.setVisibility(View.GONE);
                break;
            case R.id.backPassword:
                break;
            case R.id.backErroy2:
                backPassword.setText("");
                backErroy2.setVisibility(View.GONE);
                break;
            case R.id.NextBtn:
                presenter.getYzmDataSucess(phoneStr,codeStr);
                if (phoneStr == null) {
                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
                }
                if (codeStr == null) {
                    Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.back:
                finish();
                break;
            case R.id.getYzm:

                if (phoneStr.matches(RegexCst.REGEX_MOBILE_EXACT)) {
                    presenter.getYzmData("+86",phoneStr);
                    CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(getYzm, 6000, 1000);
                    mCountDownTimerUtils.start();
                }else {
                    Toast.makeText(this, "手机号不符合规则", Toast.LENGTH_SHORT).show();
                }
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
        String message = resetPass.getMessage();
        Log.e("-------RESECT-------", message);
    }

    @Override
    public void showYzm(Code code) {
        message = code.getMessage();
        Log.e("--------Code--------", message);
    }

    @Override
    public void showYzmSucess(Code code) {
        zqMessage = code.getMessage();
        if (zqMessage != null) {
            if (zqMessage.contains("成功")) {
                Intent intent = new Intent(this, ResetActivity.class);
                intent.putExtra("mobile",phoneStr);
                startActivity(intent);
            }else {
                Toast.makeText(this, "验证码错误请重新输入", Toast.LENGTH_SHORT).show();
            }
        }
        Log.e("------验证码是否正确------",zqMessage);
    }

    @Override
    public void showLogin(Login login) {

    }

    @Override
    public void showToken(TokenBean tokenBean) {

    }

    @Override
    public void showHome(HomeBean homeBean) {

    }

}
