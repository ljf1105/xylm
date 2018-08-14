package com.example.popo.xylm.ui.fragment;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.popo.xylm.R;
import com.example.popo.xylm.app.App;
import com.example.popo.xylm.base.BaseFragment;
import com.example.popo.xylm.data.banner.ShowImage;
import com.example.popo.xylm.data.beans.Comment;
import com.example.popo.xylm.data.beans.HomeWorks;
import com.example.popo.xylm.data.beans.LiveBean;
import com.example.popo.xylm.data.beans.MingTeacher;
import com.example.popo.xylm.data.beans.WorkXq;
import com.example.popo.xylm.data.beans.YkHome;
import com.example.popo.xylm.ui.activity.homeactivity.MessageActivity;
import com.example.popo.xylm.ui.adapter.VpAdapter;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomeContract;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomeModel;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
//交作品
public class WorkFragment extends BaseFragment<HomeModel, HomePresenter> implements HomeContract.View, View.OnClickListener {


    private ImageView fyxx;
    private LinearLayout commit;
    private LinearLayout submits;
    private TabLayout tablay;
    private ViewPager viewPagers;
    private Toolbar toolbar;
    private VpAdapter vpAdapter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        commit = view.findViewById(R.id.commit);
        submits = view.findViewById(R.id.submits);
        tablay = view.findViewById(R.id.tablay);
        viewPagers = view.findViewById(R.id.viewPagers);
        toolbar=view.findViewById(R.id.toolbar);
        fyxx=view.findViewById(R.id.fyxx);
        fyxx.setOnClickListener(this);
        vpAdapter = new VpAdapter(getChildFragmentManager(), App.tabList2, App.fragments2);
        tablay.setupWithViewPager(viewPagers);
        viewPagers.setAdapter(vpAdapter);
    }



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_job;
    }

    @Override
    public void showWorks(HomeWorks homeWorks) {


    }

    @Override
    public void showImages(ShowImage showImage) {

    }

    @Override
    public void showYkHome(YkHome ykHome) {

    }

    @Override
    public void showMshi(MingTeacher mingTeacher) {

    }

    @Override
    public void showLive(LiveBean liveBean) {

    }

    @Override
    public void showWorkXq(WorkXq workXq) {

    }

    @Override
    public void showWorkComment(Comment comment) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fyxx:
                startActivity(new Intent(getContext(), MessageActivity.class));
                break;
        }
    }
}
