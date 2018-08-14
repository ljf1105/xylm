package com.example.popo.xylm.ui.fragment.childfragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseFragment;
import com.example.popo.xylm.data.banner.ShowImage;
import com.example.popo.xylm.data.beans.Comment;
import com.example.popo.xylm.data.beans.HomeWorks;
import com.example.popo.xylm.data.beans.Keys;
import com.example.popo.xylm.data.beans.LiveBean;
import com.example.popo.xylm.data.beans.MingTeacher;
import com.example.popo.xylm.data.beans.WorkXq;
import com.example.popo.xylm.data.beans.YkHome;
import com.example.popo.xylm.ui.activity.child.childs.MshiXqActivity;
import com.example.popo.xylm.ui.adapter.MShiAdapter;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomeContract;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomeModel;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomePresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaoShiFragment extends BaseFragment<HomeModel,HomePresenter> implements HomeContract.View {

    private RecyclerView mshi_recycler;

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
    public void showMshi(final MingTeacher mingTeacher) {
        List<MingTeacher.DataBean.ListBean> list = mingTeacher.getData().getList();
        MShiAdapter mShiAdapter = new MShiAdapter(R.layout.mshi_ite, list);
        mshi_recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mshi_recycler.setAdapter(mShiAdapter);
        mShiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), MshiXqActivity.class);
                intent.putExtra("mingshi",mingTeacher);
                intent.putExtra("msposition",position);
                startActivity(intent);
            }
        });
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
        mshi_recycler=view.findViewById(R.id.mshi_recycler);
        mPresenter.getMshiData(Keys.DAOSHI);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dao_shi;
    }
}
