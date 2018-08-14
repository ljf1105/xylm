package com.example.popo.xylm.app;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.popo.xylm.data.beans.Keys;
import com.example.popo.xylm.ui.fragment.childfragment.FyYkFragment;
import com.example.popo.xylm.ui.fragment.childfragment.SmartFilterFragment;
import com.example.popo.xylm.ui.fragment.minefragment.MineDingDanFragment;
import com.example.popo.xylm.utils.SPUtil;
import com.example.popo.xylm.utils.SUtils;
import com.yatoooon.screenadaptation.ScreenAdapterTools;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    public static List<String> tabList = new ArrayList<>();
    public static List<Fragment> fragments = new ArrayList<>();


    //艺术圈页面
    @Override
    public void onCreate() {
        super.onCreate();
        SUtils.initialize(this);
        ScreenAdapterTools.init(this);

    }


    public static FyYkFragment addFragment(int a) {
        FyYkFragment fyYkFragment = new FyYkFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key", a);
        fyYkFragment.setArguments(bundle);
        fragments.add(fyYkFragment);
        return fyYkFragment;
    }

    static {
        tabList.add("智能筛选");
        tabList.add("本机构");
        tabList.add("赞数最多");
        tabList.add("最新评论");
        App.addFragment(2);
        App.addFragment(1);
        App.addFragment(2);
        App.addFragment(1);
    }

    //交作品页面
    public static List<String> tabList2 = new ArrayList<>();
    public static List<Fragment> fragments2 = new ArrayList<>();

    public static SmartFilterFragment addFragment2(Integer sortord) {
        SmartFilterFragment smartFilterFragment = new SmartFilterFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key2", sortord);
        smartFilterFragment.setArguments(bundle);
        fragments2.add(smartFilterFragment);
        return smartFilterFragment;
    }

    static {
        tabList2.add("智能筛选");
        tabList2.add("偷听最多");
        tabList2.add("最新点评");
        addFragment2(0);
        addFragment2(1);
        addFragment2(2);
    }


    //我的页面订单
    public static List<String> tabList3 = new ArrayList<>();
    public static List<Fragment> fragments3 = new ArrayList<>();

    public static MineDingDanFragment addFragment3(Integer loginUserId,Integer status){
        MineDingDanFragment mineDingDanFragment = new MineDingDanFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key3", loginUserId);
        bundle.putInt("key4", status);
        mineDingDanFragment.setArguments(bundle);
        fragments3.add(mineDingDanFragment);
        return mineDingDanFragment;
    }

    static{
        tabList3.add("全部");
        tabList3.add("代付款");
        tabList3.add("待使用");
        tabList3.add("退货");

        addFragment3(1559,-1);
        addFragment3(1559,0);
        addFragment3(1559,1);
        addFragment3(1559,4);
    }
}
