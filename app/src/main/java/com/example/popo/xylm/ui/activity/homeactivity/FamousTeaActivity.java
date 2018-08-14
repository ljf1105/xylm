package com.example.popo.xylm.ui.activity.homeactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.ui.adapter.VpAdapter;
import com.example.popo.xylm.ui.fragment.childfragment.DaRenFragment;
import com.example.popo.xylm.ui.fragment.childfragment.DaoShiFragment;
import com.example.popo.xylm.ui.fragment.childfragment.GuWenFragment;
import com.example.popo.xylm.ui.fragment.childfragment.MShiFragment;
import com.example.popo.xylm.utils.ToolBarUtils;

import java.util.ArrayList;
import java.util.List;

public class FamousTeaActivity extends BaseActivity {

    private TextView fy_text;
    private Toolbar fy_toolbar;
    private TabLayout more_tablayout;
    private ViewPager more_viewPage;
    private List<String> tabList = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famous_tea);
        initView();
        ToolBarUtils.newInstance().setToolBar(this, fy_toolbar, fy_text, "名师");
    }

    @Override
    protected void initData() {
        tabList.add("顾问");
        tabList.add("名师");
        tabList.add("导师");
        tabList.add("达人");
        fragments.add(new GuWenFragment());
        fragments.add(new MShiFragment());
        fragments.add(new DaoShiFragment());
        fragments.add(new DaRenFragment());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_famous_tea;
    }

    private void initView() {
        fy_text = (TextView) findViewById(R.id.fy_text);
        fy_toolbar = (Toolbar) findViewById(R.id.fy_toolbar);
        more_tablayout = (TabLayout) findViewById(R.id.more_tablayout);
        more_viewPage = (ViewPager) findViewById(R.id.more_viewPage);
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), tabList, fragments);
        more_tablayout.setupWithViewPager(more_viewPage);
        more_viewPage.setAdapter(vpAdapter);

    }
}
