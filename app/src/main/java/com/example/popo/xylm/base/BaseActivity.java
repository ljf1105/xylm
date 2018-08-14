package com.example.popo.xylm.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.popo.xylm.utils.NetWorkUtil;
import com.example.popo.xylm.utils.TUtils;
import com.gyf.barlibrary.ImmersionBar;

/**
 * Created by popo on 2018/6/27.
 */

public abstract class BaseActivity<M extends BaseModel, P extends BasePresenter> extends AppCompatActivity {
    public M model;
    public P presenter;
    private ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //沉浸式状态栏
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
        //我们对变量进行初始化 ，初始化使用我们的Tutils
        model = TUtils.getT(this, 0);
        presenter = TUtils.getT(this, 1);
        //对view层进行初始化，有的activity不需要实现IView层接口 所以在这里做了一个判断
        if (this instanceof BaseView) {
                presenter.setMV(model,this);
        }
        boolean b = NetWorkUtil.havaNetWork(this);
        if (!b) {
            Toast.makeText(this, "当前无网络请前往设置", Toast.LENGTH_SHORT).show();
        }

        setContentView(getLayoutId());
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

//  适配底部导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        initData();
        // 在setContentView之后，适配顶部状态栏


    }


    @Override
    protected void onResume() {
        super.onResume();
        boolean b = NetWorkUtil.havaNetWork(this);
        if (!b) {
            Toast.makeText(this, "当前无网络请前往设置、", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mImmersionBar.destroy();
    }

    protected abstract void initData();


    protected abstract int getLayoutId();
}
