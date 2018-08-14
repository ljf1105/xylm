package com.example.popo.xylm.ui.fragment.homefragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseFragment;
import com.example.popo.xylm.data.banner.ShowImage;
import com.example.popo.xylm.data.beans.Comment;
import com.example.popo.xylm.data.beans.HomeWorks;
import com.example.popo.xylm.data.beans.LiveBean;
import com.example.popo.xylm.data.beans.MingTeacher;
import com.example.popo.xylm.data.beans.WorkXq;
import com.example.popo.xylm.data.beans.YkHome;
import com.example.popo.xylm.ui.adapter.LiveAdapter;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomeContract;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomeModel;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomePresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends BaseFragment<HomeModel, HomePresenter> implements HomeContract.View {


    private RecyclerView kecheng_recycler;


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
        String message = liveBean.getMessage();
        Log.e("--------------",message);
        List<LiveBean.DataBean.ListBean> list = liveBean.getData().getList();
        LiveAdapter liveAdapter = new LiveAdapter(R.layout.live_item, list);
        kecheng_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        kecheng_recycler.setAdapter(liveAdapter);
    }

    @Override
    public void showWorkXq(WorkXq workXq) {

    }

    @Override
    public void showWorkComment(Comment comment) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        kecheng_recycler=view.findViewById(R.id.kecheng_recycler);
        mPresenter.getLiveData("讲堂");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live;
    }
}
