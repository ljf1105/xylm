package com.example.popo.xylm.ui.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.popo.xylm.R;
import com.example.popo.xylm.app.App;
import com.example.popo.xylm.base.BaseFragment;
import com.example.popo.xylm.data.banner.ImageLoder;
import com.example.popo.xylm.data.banner.ShowImage;
import com.example.popo.xylm.data.beans.Comment;
import com.example.popo.xylm.data.beans.HomeWorks;
import com.example.popo.xylm.data.beans.LiveBean;
import com.example.popo.xylm.data.beans.MingTeacher;
import com.example.popo.xylm.data.beans.WorkXq;
import com.example.popo.xylm.data.beans.YkHome;
import com.example.popo.xylm.ui.adapter.VpAdapter;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomeContract;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomeModel;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomePresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeacherFragment extends BaseFragment<HomeModel, HomePresenter> implements HomeContract.View {


    private ImageView bianji;
    private ImageView fyxx;
    private Banner ys_banner;
    private Toolbar toolbar;
    private TabLayout ys_tablayout;
    private ViewPager ys_viewPager;
    private List<String> imgList = new ArrayList<>();
    private int[] arr = {2, 1, 2, 1, 2, 1};
    @Override
    public void showWorks(HomeWorks homeWorks) {

    }

    @Override
    public void showImages(ShowImage showImage) {
        List<ShowImage.DataBean.ListBean> list = showImage.getData().getList();
        for (int i = 0; i < list.size(); i++) {
            imgList.add(list.get(i).getMobileImgUrl());
        }
        ys_banner.setImages(imgList);
        ys_banner.setImageLoader(new ImageLoder());
        ys_banner.setDelayTime(4000);
        ys_banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        ys_banner.setBannerAnimation(Transformer.Accordion);
        ys_banner.start();
    }

    @Override
    public void showYkHome(YkHome ykHome) {
        List<YkHome.DataBean.ArtcircleCategoriesBean> artcircleCategories = ykHome.getData().getArtcircleCategories();
        for (int i = 0; i < artcircleCategories.size(); i++) {
            App.tabList.add(App.tabList.size(), artcircleCategories.get(i).getName());
            Log.e("-------name------",artcircleCategories.get(i).getName());
            App.addFragment(arr[i]);
        }

        VpAdapter vpAdapter = new VpAdapter(getFragmentManager(), App.tabList, App.fragments);
        ys_tablayout.setupWithViewPager(ys_viewPager);
        ys_viewPager.setAdapter(vpAdapter);
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
        toolbar = view.findViewById(R.id.toolbar);
        ys_banner = view.findViewById(R.id.ys_banner);
        toolbar = view.findViewById(R.id.toolbar);
        ys_tablayout = view.findViewById(R.id.ys_tablayout);
        ys_viewPager = view.findViewById(R.id.ys_viewPager);
        mPresenter.getImgTeaData();
        mPresenter.getYkHomeData(0);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_teacher;
    }


}
