package com.example.popo.xylm.ui.activity.workActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.data.beans.HomeBean;
import com.example.popo.xylm.ui.activity.homeactivity.PublishActivity;
import com.zhuang.likeviewlibrary.LikeView;

import java.util.List;

public class TeacherXqActivity extends BaseActivity implements View.OnClickListener {

    private ImageView msxq_img;
    private ImageView msxq_back;
    private ImageView msxq_share;
    private TextView msxq_skilled;
    private LikeView likeView;
    private ImageView msxq_smallImg;
    private TextView msxq_name;
    private ImageView msxq_dianzai;
    private TextView msxq_zy;
    private WebView msxq_webView;
    private LinearLayout ling_fd;
    private Button msxq_gz;
    private boolean isBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_xq);
        initView();

    }

    @Override
    protected void initData() {

    }

    private void initView() {
        msxq_img = (ImageView) findViewById(R.id.msxq_img);
        msxq_back = (ImageView) findViewById(R.id.msxq_back);
        msxq_share = (ImageView) findViewById(R.id.msxq_share);
        msxq_skilled = (TextView) findViewById(R.id.msxq_skilled);
        likeView = (LikeView) findViewById(R.id.likeView);
        msxq_smallImg = (ImageView) findViewById(R.id.msxq_smallImg);
        msxq_name = (TextView) findViewById(R.id.msxq_name);
        msxq_dianzai = (ImageView) findViewById(R.id.msxq_dianzai);
        msxq_zy = (TextView) findViewById(R.id.msxq_zy);
        msxq_webView = (WebView) findViewById(R.id.msxq_webView);
        ling_fd = (LinearLayout) findViewById(R.id.ling_fd);
        ling_fd.setOnClickListener(this);
        Intent intent = getIntent();
        HomeBean homeBean = (HomeBean) intent.getSerializableExtra("homeBean");
        int mPosition = intent.getIntExtra("mPosition", 0);
        List<HomeBean.DataBean.UsersBean> list = homeBean.getData().getUsers();
        Glide.with(this).load(list.get(mPosition).getImages()).into(msxq_img);
        Glide.with(this).load(list.get(mPosition).getPhoto()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(msxq_smallImg);
        msxq_name.setText(list.get(mPosition).getNickname());
        msxq_zy.setText(list.get(mPosition).getIntro());
        int id = list.get(mPosition).getId();
        Log.e("--------uid----",id+"");
        switch (list.get(mPosition).getUserType()) {
            //达人
            case 2:
                msxq_dianzai.setImageResource(R.mipmap.daren);
                break;
            //名师
            case 3:
                msxq_dianzai.setImageResource(R.mipmap.home_level_vip_yellow);
                break;
            //顾问
            case 4:
                msxq_dianzai.setImageResource(R.mipmap.home_level_vip_red);
                break;
            //导师
            case 6:
                msxq_dianzai.setImageResource(R.mipmap.home_level_vip_blue);
                break;
        }
        msxq_gz = (Button) findViewById(R.id.msxq_gz);
        msxq_gz.setOnClickListener(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_teacher_xq;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.msxq_back:
                finish();
                break;
            case R.id.msxq_share:
                Toast.makeText(this, "2222222222", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ling_fd:
                startActivity(new Intent(this, PublishActivity.class));
                break;
            case R.id.msxq_gz:
                if (isBack) {
                    msxq_gz.setBackgroundColor(getResources().getColor(R.color.startYzBt));
                    msxq_gz.setTextColor(getResources().getColor(R.color.whites));
                    msxq_gz.setText("关注");
                    isBack=false;
                } else {
                    msxq_gz.setBackgroundColor(getResources().getColor(R.color.labeText));
                    msxq_gz.setTextColor(Color.BLACK);
                    msxq_gz.setText("已关注");
                    isBack=true;
                }
                break;
        }
    }
}
