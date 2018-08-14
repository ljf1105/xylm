package com.example.popo.xylm.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.popo.xylm.utils.NetWorkUtil;
import com.example.popo.xylm.utils.TUtils;
import com.gyf.barlibrary.ImmersionBar;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<M extends BaseModel, P extends BasePresenter> extends Fragment {

    public M mModel;
    public P mPresenter;
    private View view;
    private ImmersionBar mImmersionBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //沉浸式状态栏
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
        view = inflater.inflate(getLayoutId(), container, false);
        mModel = TUtils.getT(this, 0);
        mPresenter = TUtils.getT(this, 1);
        if (this instanceof BaseView) {
            mPresenter.setMV(mModel, this);

        }
        boolean b = NetWorkUtil.havaNetWork(getContext());
        if (!b) {
            Toast.makeText(getContext(), "当前无网络请前往设置", Toast.LENGTH_SHORT).show();
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        // 在setContentView之后，适配顶部状态栏
       getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

//  适配底部导航栏
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int getLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mImmersionBar.destroy();
    }


}
