package com.example.popo.xylm.ui.activity.child.childs;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.utils.ToolBarUtils;

public class FabulousActivity extends BaseActivity {

    private TextView fy_text;
    private Toolbar fy_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabulous);
        initView();
        ToolBarUtils.newInstance().setToolBar(this,fy_toolbar,fy_text,"点赞提醒");

    }

    @Override
    protected void initData() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fabulous;
    }

    private void initView() {
        fy_text = (TextView) findViewById(R.id.fy_text);
        fy_toolbar = (Toolbar) findViewById(R.id.fy_toolbar);
    }
}
