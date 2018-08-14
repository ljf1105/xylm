package com.example.popo.xylm.ui.fragment.childfragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.example.popo.xylm.ui.adapter.YsHomeAdapter;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomeContract;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomeModel;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomePresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FyYkFragment extends BaseFragment<HomeModel, HomePresenter> implements HomeContract.View {


    private RecyclerView ys_recycler;

    @Override
    public void showWorks(HomeWorks homeWorks) {

    }

    @Override
    public void showImages(ShowImage showImage) {

    }

    @Override
    public void showYkHome(YkHome ykHome) {
        List<YkHome.DataBean.ArtcircleListBean.ListBean> list = ykHome.getData().getArtcircleList().getList();
        YsHomeAdapter ysHomeAdapter = new YsHomeAdapter(R.layout.yk_item, list);
        ys_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        ys_recycler.setAdapter(ysHomeAdapter);
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
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        ys_recycler=view.findViewById(R.id.ys_recycler);
        if (getArguments() != null) {
            int key = getArguments().getInt("key");
            mPresenter.getYkHomeData(key);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fy_yk;
    }

}
