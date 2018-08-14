package com.example.popo.xylm.ui.activity.workActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.data.banner.ShowImage;
import com.example.popo.xylm.data.beans.Comment;
import com.example.popo.xylm.data.beans.HomeWorks;
import com.example.popo.xylm.data.beans.LiveBean;
import com.example.popo.xylm.data.beans.MingTeacher;
import com.example.popo.xylm.data.beans.WorkXq;
import com.example.popo.xylm.data.beans.YkHome;
import com.example.popo.xylm.ui.adapter.CommentApapter;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomeContract;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomeModel;
import com.example.popo.xylm.ui.fragment.shouyemodule.HomePresenter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

//作品详情
public class WorkXQActivity extends BaseActivity<HomeModel, HomePresenter> implements View.OnClickListener, HomeContract.View {

    private Toolbar xq_toolbar;
    private ImageView xq_subImage;
    private TextView xq_subName;
    private TextView xq_data;
    private TextView xq_zp;
    private TextView xq_content;
    private ImageView bai;
    private JZVideoPlayerStandard xq_jcVideo;
    private RelativeLayout xq_relative;
    private ImageView xq_teaImg;
    private TextView xq_teaName;
    private ImageView xq_teaSmallImg;
    private Button xq_zs;
    private RecyclerView xq_recycler;
    private TextView xq_tInfor;
    private RelativeLayout xq_yyue;
    private TextView xq_zl;
    private ImageView sf;
    private RelativeLayout comm_sf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_xq);
        initView();
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        Log.e("--------id-------", id + "");
        presenter.getWorkXqData(id);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_work_xq;
    }

    private void initView() {
        xq_toolbar = (Toolbar) findViewById(R.id.xq_toolbar);
        xq_subImage = (ImageView) findViewById(R.id.xq_subImage);
        xq_subName = (TextView) findViewById(R.id.xq_subName);
        xq_data = (TextView) findViewById(R.id.xq_data);
        xq_zp = (TextView) findViewById(R.id.xq_zp);
        xq_content = (TextView) findViewById(R.id.xq_content);
        bai = (ImageView) findViewById(R.id.bai);
        xq_jcVideo = (JZVideoPlayerStandard) findViewById(R.id.xq_jcVideo);
        xq_relative = (RelativeLayout) findViewById(R.id.xq_relative);
        xq_teaImg = (ImageView) findViewById(R.id.xq_teaImg);
        xq_teaName = (TextView) findViewById(R.id.xq_teaName);
        xq_teaSmallImg = (ImageView) findViewById(R.id.xq_teaSmallImg);
        xq_zs = (Button) findViewById(R.id.xq_zs);
        xq_recycler = (RecyclerView) findViewById(R.id.xq_recycler);

        xq_zs.setOnClickListener(this);
        xq_toolbar.setTitle("");
        setSupportActionBar(xq_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        xq_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        xq_tInfor = (TextView) findViewById(R.id.xq_tInfor);
        xq_tInfor.setOnClickListener(this);
        xq_yyue = (RelativeLayout) findViewById(R.id.xq_yyue);
        xq_yyue.setOnClickListener(this);
        xq_zl = (TextView) findViewById(R.id.xq_zl);
        xq_zl.setOnClickListener(this);
        sf = (ImageView) findViewById(R.id.sf);
        sf.setOnClickListener(this);
        comm_sf = (RelativeLayout) findViewById(R.id.comm_sf);
        comm_sf.setOnClickListener(this);
    }

    //作品详情
    @Override
    public void showWorkXq(WorkXq workXq) {
        Log.e("-----评论-----",workXq.getMessage());
        if (workXq.getData().getComments().getList().size()!=0) {
            comm_sf.setVisibility(View.GONE);
            xq_recycler.setVisibility(View.VISIBLE);
            List<WorkXq.DataBean.CommentsBean.ListBean> list = workXq.getData().getComments().getList();
            CommentApapter commentApapter = new CommentApapter(R.layout.comments_item, list);
            xq_recycler.setLayoutManager(new LinearLayoutManager(this));
            xq_recycler.setAdapter(commentApapter);
        } else {
            comm_sf.setVisibility(View.VISIBLE);
            xq_recycler.setVisibility(View.GONE);
        }
        String message = workXq.getMessage();
        Log.e("------M---S---G", message);
        WorkXq.DataBean.HomewokBean homewok = workXq.getData().getHomewok();
        Glide.with(this).load(homewok.getPhoto()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(xq_subImage);
        Glide.with(this).load(homewok.getTPhoto()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(xq_teaImg);
        xq_subName.setText(homewok.getNickname());
        xq_zp.setText(homewok.getSource());
        xq_content.setText(homewok.getContent());
        xq_teaName.setText(homewok.getTRealname());
        xq_tInfor.setText(homewok.getTIntro());
        // 毫秒转日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+"/"+"MM"+"/"+"dd");
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(homewok.getCreateDate());
        Date date = c.getTime();
        xq_data.setText(sdf.format(date)+"");
        String worksType = homewok.getWorksType();
        xq_zl.setText(worksType);
        if (worksType.equals("视频")) {
            xq_jcVideo.setVisibility(View.VISIBLE);
            xq_yyue.setVisibility(View.GONE);
            xq_jcVideo.setUp(homewok.getPath(), JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL);
            Glide.with(this).load(homewok.getPath()).into(xq_jcVideo.thumbImageView);
            xq_jcVideo.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            xq_yyue.setVisibility(View.VISIBLE);
            xq_jcVideo.setVisibility(View.GONE);

        }

        int userType = homewok.getUserType();
        if (userType == 6) {
            xq_teaSmallImg.setImageResource(R.mipmap.home_level_vip_blue);
        } else if (userType == 4) {
            xq_teaSmallImg.setImageResource(R.mipmap.home_level_vip_red);
        } else {
            xq_teaSmallImg.setImageResource(R.mipmap.home_level_vip_yellow);
        }
    }

    //评论列表
    @Override
    public void showWorkComment(Comment comment) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xq_zs:

                break;
        }
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


}
