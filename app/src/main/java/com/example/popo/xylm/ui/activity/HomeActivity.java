package com.example.popo.xylm.ui.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.ui.fragment.HomeFragment;
import com.example.popo.xylm.ui.fragment.MineFragment;
import com.example.popo.xylm.ui.fragment.ScheduleFragment;
import com.example.popo.xylm.ui.fragment.TeacherFragment;
import com.example.popo.xylm.ui.fragment.WorkFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class HomeActivity extends BaseActivity {

    private BottomTabBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
  /*      getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

//  适配底部导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);*/
        initView();
        initTabBar();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    protected void initData() {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    private void initTabBar() {
        bottomBar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(15)
                .setChangeColor(Color.DKGRAY,Color.GRAY)
                .addTabItem("首页",R.mipmap.fristming,R.mipmap.fristhui,HomeFragment.class)
                .addTabItem("日程表", R.mipmap.home_work_active,R.mipmap.home_work_normal,ScheduleFragment.class)
                .addTabItem("交作品",R.mipmap.stujiaozuoye,R.mipmap.stujiaozuoye,WorkFragment.class)
                .addTabItem("艺术圈",R.mipmap.home_valuable_active,R.mipmap.home_valuable_normal,TeacherFragment.class)
                .addTabItem("我的",R.mipmap.home_myself_active, R.mipmap.home_myself_normal,MineFragment.class)
                .isShowDivider(false);
    }


    private void initView() {
        bottomBar = (BottomTabBar) findViewById(R.id.bottomBar);
    }
}
