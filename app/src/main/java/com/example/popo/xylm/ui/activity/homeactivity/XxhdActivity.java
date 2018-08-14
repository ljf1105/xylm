package com.example.popo.xylm.ui.activity.homeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.data.beans.HomeBean;
import com.example.popo.xylm.ui.adapter.XxhAdapter;
import com.example.popo.xylm.utils.ToolBarUtils;

import java.util.List;

public class XxhdActivity extends BaseActivity {

    private TextView fy_text;
    private Toolbar fy_toolbar;
    private RecyclerView xianxia_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xxhd);
        initView();
        initXxhd();
        ToolBarUtils.newInstance().setToolBar(this,fy_toolbar,fy_text,"线下活动推荐");
    }

    private void initXxhd() {
        Intent intent = getIntent();
        HomeBean.DataBean xxhd = (HomeBean.DataBean) intent.getSerializableExtra("xianxiahuodong");
        List<HomeBean.DataBean.OfflineCourseBean> offlineCourse = xxhd.getOfflineCourse();
        XxhAdapter xxhAdapter = new XxhAdapter(R.layout.xxhd_item,offlineCourse);
        xianxia_recycler.setLayoutManager(new LinearLayoutManager(this));
        xianxia_recycler.setAdapter(xxhAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xxhd;
    }

    private void initView() {
        fy_text = (TextView) findViewById(R.id.fy_text);
        fy_toolbar = (Toolbar) findViewById(R.id.fy_toolbar);
        xianxia_recycler = (RecyclerView) findViewById(R.id.xianxia_recycler);
    }
}
