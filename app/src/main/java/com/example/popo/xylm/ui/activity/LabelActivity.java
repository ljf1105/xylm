package com.example.popo.xylm.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.data.beans.Code;
import com.example.popo.xylm.data.beans.HomeBean;
import com.example.popo.xylm.data.beans.Login;
import com.example.popo.xylm.data.beans.Preference;
import com.example.popo.xylm.data.beans.ResetPass;
import com.example.popo.xylm.data.beans.TokenBean;
import com.example.popo.xylm.data.beans.User;
import com.example.popo.xylm.ui.adapter.CollegesAdapter;
import com.example.popo.xylm.ui.adapter.MajorsAdapter;
import com.example.popo.xylm.xylm.XylmContract;
import com.example.popo.xylm.xylm.XylmModel;
import com.example.popo.xylm.xylm.XylmPresenter;
import com.gyf.barlibrary.ImmersionBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LabelActivity extends BaseActivity<XylmModel, XylmPresenter> implements XylmContract.View {

    @BindView(R.id.labelImage)
    ImageView labelImage;
    @BindView(R.id.labePass)
    TextView labePass;
    @BindView(R.id.labeRecycler)
    RecyclerView labeRecycler;
    @BindView(R.id.labeRecycler2)
    RecyclerView labeRecycler2;
    @BindView(R.id.labelText)
    TextView labelText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        presenter.getPreUser("https://www.univstar.com/v1/m/user/preference");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_label;
    }

    @OnClick({R.id.labelImage, R.id.labePass, R.id.labelText})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.labelImage:
                finish();
                break;
            case R.id.labePass:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.labelText:
                startActivity(new Intent(LabelActivity.this, LoginActivity.class));
                break;
        }
    }

    @Override
    public void showUser(User user) {

    }

    @Override
    public void showPreference(Preference preference) {
        List<Preference.DataBean.MajorsBean> majors = preference.getData().getMajors();
        List<Preference.DataBean.CollegesBean> colleges = preference.getData().getColleges();
        //专业
        MajorsAdapter majorsAdapter = new MajorsAdapter(R.layout.marjors, majors);
        labeRecycler.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        labeRecycler.setAdapter(majorsAdapter);

        //院校
        CollegesAdapter collegesAdapter = new CollegesAdapter(R.layout.marjors, colleges);
        labeRecycler2.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        labeRecycler2.setAdapter(collegesAdapter);

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

    }

    @Override
    public void showToken(TokenBean tokenBean) {

    }

    @Override
    public void showHome(HomeBean homeBean) {



    }
}
