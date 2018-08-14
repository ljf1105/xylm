package com.example.popo.xylm.ui.activity.homeactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.ui.adapter.VpAdapter;
import com.example.popo.xylm.ui.fragment.homefragment.KeChengFragment;
import com.example.popo.xylm.ui.fragment.homefragment.LiveFragment;
import com.example.popo.xylm.utils.ToolBarUtils;

import java.util.ArrayList;
import java.util.List;

public class KeChengActivity extends BaseActivity {

    private TextView fy_text;
    private Toolbar fy_toolbar;
    private TabLayout more_tablayout;
    private ViewPager more_viewPage;
    private List<String> tabList = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke_cheng);
        initView();
        ToolBarUtils.newInstance().setToolBar(this,fy_toolbar,fy_text,"直播课程");
    }

    @Override
    protected void initData() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ke_cheng;
    }

    private void initView() {
        fy_text = (TextView) findViewById(R.id.fy_text);
        fy_toolbar = (Toolbar) findViewById(R.id.fy_toolbar);
        more_tablayout = (TabLayout) findViewById(R.id.more_tablayout);
        more_viewPage = (ViewPager) findViewById(R.id.more_viewPage);
        tabList.add("课程");
        tabList.add("直播live");
        fragments.add(new KeChengFragment());
        fragments.add(new LiveFragment());
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), tabList, fragments);
        more_tablayout.setupWithViewPager(more_viewPage);
        more_viewPage.setAdapter(vpAdapter);
    }
}
