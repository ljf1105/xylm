package com.example.popo.xylm.ui.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.data.beans.Keys;
import com.example.popo.xylm.utils.CountDownTimerUtils;
import com.example.popo.xylm.utils.EditTextUtil;
import com.example.popo.xylm.utils.Md5Util;
import com.example.popo.xylm.utils.RegexCst;
import com.example.popo.xylm.utils.RetrofitUtils;
import com.example.popo.xylm.utils.SPUtil;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {


    private String mobile;
    private ImageView reReturn;
    private EditText number;
    private ImageView registErroy;
    private EditText pass;
    private ImageView registErroy2;
    private Button reGetYzm;
    private Button register;
    private TextView soap;
    private ImageView weixinRegist;
    private ImageView qqRegist;
    private ImageView wbRegist;
    private String passCode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        initDid();
        initUserAgent();

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    private void initDid() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            //获取版本名称
            String versionName = packageInfo.versionName;
            //获取手机ID
            String androidID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
            //获取手机序列号Md5Util.java
            String serialNumber = Build.SERIAL;
            String did = Md5Util.encrypt(versionName + "_" + androidID + "_" + serialNumber);
            SPUtil.getInstance().put(Keys.DID, did);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void initUserAgent() {
        //获取手机型号
        String mobile = Build.MODEL;
        //获取手机系统版本号
        String version = Build.VERSION.RELEASE;
        SPUtil.getInstance().put(Keys.USERAGENT, String.format("%s %s %s", "Android", mobile, version));
    }


    public void initView() {
        reReturn = (ImageView) findViewById(R.id.reReturn);
        reReturn.setOnClickListener(this);
        number = (EditText) findViewById(R.id.number);
        number.setOnClickListener(this);
        registErroy = (ImageView) findViewById(R.id.registErroy);
        registErroy.setOnClickListener(this);
        pass = (EditText) findViewById(R.id.pass);
        pass.setOnClickListener(this);
        registErroy2 = (ImageView) findViewById(R.id.registErroy2);
        registErroy2.setOnClickListener(this);
        reGetYzm = (Button) findViewById(R.id.reGetYzm);
        reGetYzm.setOnClickListener(this);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);
        soap = (TextView) findViewById(R.id.soap);
        soap.setOnClickListener(this);
        weixinRegist = (ImageView) findViewById(R.id.weixinRegist);
        weixinRegist.setOnClickListener(this);
        qqRegist = (ImageView) findViewById(R.id.qqRegist);
        qqRegist.setOnClickListener(this);
        wbRegist = (ImageView) findViewById(R.id.wbRegist);
        wbRegist.setOnClickListener(this);
        EditTextUtil.deleteA(number,registErroy);
        EditTextUtil.deleteA(pass, registErroy2);

    }


    @Override
    public void onClick(View v) {
        mobile = number.getText().toString();
        passCode = pass.getText().toString();
        switch (v.getId()) {
            case R.id.reGetYzm:
                if (mobile.matches(RegexCst.REGEX_MOBILE_EXACT)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            boolean phoneNumber = isPhoneNumber();
                            if (phoneNumber) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(reGetYzm, 6000, 1000);
                                        mCountDownTimerUtils.start();
                                    }
                                });
                                iszqCode();
                            } else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(RegisterActivity.this, "手机号已被注册请前往登录", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    }).start();
                } else {
                    Toast.makeText(this, "手机号有误请重新输入", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.registErroy:
                number.setText("");
                registErroy.setVisibility(View.GONE);
                break;
            case R.id.registErroy2:
                pass.setText("");
                registErroy2.setVisibility(View.GONE);
                break;
            case R.id.soap:
                startActivity(new Intent(this, LabelActivity.class));
                break;
            case R.id.qqLogin:

                break;
            case R.id.reReturn:
                finish();
                break;
            case R.id.weixinLogin:

                break;
            case R.id.wbLogin:

                break;
            case R.id.register:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        boolean b = disputeCode();
                        if (b) {
                            boolean register = isRegister();
                            if (register) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(RegisterActivity.this, PerfectActivity.class);
                                        intent.putExtra("phone",mobile);
                                        startActivity(intent);
                                    }
                                });
                            }
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).start();
                break;
        }
    }

    private boolean disputeCode() {
        try {
            Response<ResponseBody> response = RetrofitUtils.getInstance().getMineService().isCode(mobile.trim(), passCode.trim()).execute();
            if (response.body().string().contains("成功"))
                return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean isPhoneNumber() {
        try {
            Response<ResponseBody> response = RetrofitUtils.getInstance().getMineService().isPhone(mobile.trim()).execute();
            //fastjson
            if (response.body().string().contains("成功"))
                return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void iszqCode() {
        try {
            Response<ResponseBody> response = RetrofitUtils.getInstance().getMineService().getCode("+86", mobile.trim()).execute();
            Log.e("--------11111", response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean isRegister() {
        try {
            Response<ResponseBody> response = RetrofitUtils.getInstance().getMineService().isRegister(mobile, passCode).execute();
            if (response.body().string().contains("成功")) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
