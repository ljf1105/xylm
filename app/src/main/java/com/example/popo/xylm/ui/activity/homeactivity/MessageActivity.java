package com.example.popo.xylm.ui.activity.homeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.ui.activity.child.childs.CommentActivity;
import com.example.popo.xylm.ui.activity.child.childs.FabulousActivity;
import com.example.popo.xylm.ui.activity.child.childs.FollowActivity;
import com.example.popo.xylm.ui.activity.child.childs.OrderActivity;
import com.example.popo.xylm.ui.activity.child.childs.TaskActivity;
import com.example.popo.xylm.ui.activity.child.childs.TeamActivity;

public class MessageActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar msg_toolbar;
    private TextView msg_dd;
    private LinearLayout lin_dd;
    private TextView msg_zwd;
    private LinearLayout lin_zwd;
    private TextView msg_pl;
    private LinearLayout lin_pl;
    private TextView msg_job;
    private LinearLayout lin_zy;
    private TextView msg_team;
    private LinearLayout lin_team;
    private TextView msg_gz;
    private LinearLayout lin_gz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        initView();
        initToolBar();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    private void initToolBar() {

        msg_toolbar.setTitle("");
        setSupportActionBar(msg_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        msg_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        msg_toolbar = (Toolbar) findViewById(R.id.msg_toolbar);
        msg_dd = (TextView) findViewById(R.id.msg_dd);
        msg_dd.setOnClickListener(this);
        lin_dd = (LinearLayout) findViewById(R.id.lin_dd);
        lin_dd.setOnClickListener(this);
        msg_zwd = (TextView) findViewById(R.id.msg_zwd);
        msg_zwd.setOnClickListener(this);
        lin_zwd = (LinearLayout) findViewById(R.id.lin_zwd);
        lin_zwd.setOnClickListener(this);
        msg_pl = (TextView) findViewById(R.id.msg_pl);
        msg_pl.setOnClickListener(this);
        lin_pl = (LinearLayout) findViewById(R.id.lin_pl);
        lin_pl.setOnClickListener(this);
        msg_job = (TextView) findViewById(R.id.msg_job);
        msg_job.setOnClickListener(this);
        lin_zy = (LinearLayout) findViewById(R.id.lin_zy);
        lin_zy.setOnClickListener(this);
        msg_team = (TextView) findViewById(R.id.msg_team);
        msg_team.setOnClickListener(this);
        lin_team = (LinearLayout) findViewById(R.id.lin_team);
        lin_team.setOnClickListener(this);
        msg_gz = (TextView) findViewById(R.id.msg_gz);
        msg_gz.setOnClickListener(this);
        lin_gz = (LinearLayout) findViewById(R.id.lin_gz);
        lin_gz.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin_dd:
                startActivity(new Intent(this, OrderActivity.class));
                break;
            case R.id.lin_zwd:
                startActivity(new Intent(this, FabulousActivity.class));
                break;
            case R.id.lin_pl:
                startActivity(new Intent(this, CommentActivity.class));
                break;
            case R.id.lin_zy:
                startActivity(new Intent(this, TaskActivity.class));
                break;
            case R.id.lin_team:
                startActivity(new Intent(this, TeamActivity.class));
                break;
            case R.id.lin_gz:
                startActivity(new Intent(this, FollowActivity.class));
                break;
        }
    }
}
