package com.example.popo.xylm.ui.fragment.childfragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseFragment;
import com.example.popo.xylm.data.banner.ShowImage;
import com.example.popo.xylm.data.beans.Comment;
import com.example.popo.xylm.data.beans.HomeWorks;
import com.example.popo.xylm.data.beans.LiveBean;
import com.example.popo.xylm.data.beans.MingTeacher;
import com.example.popo.xylm.data.beans.WorkXq;
import com.example.popo.xylm.data.beans.YkHome;
import com.example.popo.xylm.ui.activity.workActivity.WorkXQActivity;
import com.example.popo.xylm.ui.adapter.WorksAdapter;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomeContract;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomeModel;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomePresenter;
import com.example.popo.xylm.utils.SPUtil;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
//智能筛选
public class SmartFilterFragment extends BaseFragment<HomeModel, HomePresenter> implements HomeContract.View {
    private RecyclerView works_recycler;
    private ImageView work_dz;


    @Override
    public void showWorkComment(Comment comment) {

    }

    @Override
    public void showWorks(final HomeWorks homeWorks) {
        //交作品数据展示
        final List<HomeWorks.DataBean.ListBean> list = homeWorks.getData().getList();
        final WorksAdapter worksAdapter = new WorksAdapter(R.layout.homework, list);
        works_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        works_recycler.setAdapter(worksAdapter);
        worksAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                SPUtil.getInstance().put("homework_id", position);
            }
        });
        worksAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SPUtil.getInstance().put("homework_id", position);
            }
        });
        worksAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.work_teaImg) {
                    Toast.makeText(getContext(), "111111", Toast.LENGTH_SHORT).show();
                } else if (v.getId() == R.id.work_subImg) {
                    Toast.makeText(getContext(), "222222", Toast.LENGTH_SHORT).show();
                } else if (v.getId() == R.id.work_messege) {
                    Toast.makeText(getContext(), "333333", Toast.LENGTH_SHORT).show();
                } else if (v.getId() == R.id.work_lw) {
                    Toast.makeText(getContext(), "55555", Toast.LENGTH_SHORT).show();
                } else if (v.getId() == R.id.work_fx) {
                    Toast.makeText(getContext(), "66666", Toast.LENGTH_SHORT).show();
                } else {
                    //跳转到作品详情页面
                    Intent intent = new Intent(getContext(), WorkXQActivity.class);
                    intent.putExtra("id", list.get((Integer) SPUtil.getInstance().get("homework_id", 0)).getId());
                    startActivity(intent);
                }
            }
        });


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
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        works_recycler = view.findViewById(R.id.works_recycler);
        if (getArguments() != null) {
            int key2 = getArguments().getInt("key2");
            mPresenter.getWorksData(key2);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_smart_filter2;
    }
}
