package com.example.popo.xylm.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.example.popo.xylm.utils.RegexCst;
import com.example.popo.xylm.xylm.XylmContract;
import com.example.popo.xylm.xylm.XylmModel;
import com.example.popo.xylm.xylm.XylmPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetActivity extends BaseActivity<XylmModel,XylmPresenter> implements XylmContract.View {

    @BindView(R.id.resTool)
    Toolbar resTool;
    @BindView(R.id.resPhone)
    EditText resPhone;
    @BindView(R.id.resErroy)
    ImageView resErroy;
    @BindView(R.id.resPass)
    EditText resPass;
    @BindView(R.id.resErroy2)
    ImageView resErroy2;
    @BindView(R.id.resComilt)
    Button resComilt;
    @BindView(R.id.reBack)
    ImageView reBack;
    private String passStr;
    private String passStr2;
    private String mobile;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mobile = intent.getStringExtra("mobile");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reset;
    }

    @OnClick({R.id.resPhone, R.id.resErroy, R.id.resPass, R.id.resErroy2, R.id.resComilt,R.id.reBack})
    public void onViewClicked(View view) {
        passStr = resPhone.getText().toString();
        passStr2 = resPass.getText().toString();
        switch (view.getId()) {
            case R.id.resPhone:
                break;
            case R.id.resErroy:
                break;
            case R.id.resPass:
                break;
            case R.id.resErroy2:
                break;
            case R.id.resComilt:
//                “新密码”与“确认密码”输入一致，点击”完成“，跳转至 002 登录；
                if (passStr.equals(passStr2)) {
                    presenter.setPassData(mobile,passStr);
                }else {
                    Toast.makeText(this, "请保持密码一致", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.reBack:
                finish();
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
        message = resetPass.getMessage();
        if (message != null) {
            if (message.contains("成功")) {
                startActivity(new Intent(this, LoginActivity.class));
            }else {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        }else {
            presenter.setPassData(mobile,passStr);
        }
        Log.e("-------重置密码-------", message);
    }

    @Override
    public void showYzm(Code code) {

    }

    @Override
    public void showYzmSucess(Code code) {

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
