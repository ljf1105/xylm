package com.example.popo.xylm.ui.activity.mineactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.popo.xylm.R;
import com.example.popo.xylm.app.App;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.ui.adapter.VpAdapter;
import com.example.popo.xylm.utils.ToolBarUtils;

public class DingDanActivity extends BaseActivity {

    private TextView fy_text;
    private Toolbar fy_toolbar;
    private TabLayout tablay;
    private ViewPager viewPagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding_dan);
        initView();
        ToolBarUtils.newInstance().setToolBar(this, fy_toolbar, fy_text, "我的订单");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ding_dan;
    }

    private void initView() {
        fy_text = (TextView) findViewById(R.id.fy_text);
        fy_toolbar = (Toolbar) findViewById(R.id.fy_toolbar);
        tablay = (TabLayout) findViewById(R.id.tablay);
        viewPagers = (ViewPager) findViewById(R.id.viewPagers);

        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), App.tabList3, App.fragments3);
        tablay.setupWithViewPager(viewPagers);
        viewPagers.setAdapter(vpAdapter);
    }
}
