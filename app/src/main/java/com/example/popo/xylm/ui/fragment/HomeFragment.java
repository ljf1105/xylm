package com.example.popo.xylm.ui.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseFragment;
import com.example.popo.xylm.data.banner.ImageLoder;
import com.example.popo.xylm.data.beans.Code;
import com.example.popo.xylm.data.beans.HomeBean;
import com.example.popo.xylm.data.beans.Login;
import com.example.popo.xylm.data.beans.Preference;
import com.example.popo.xylm.data.beans.ResetPass;
import com.example.popo.xylm.data.beans.TokenBean;
import com.example.popo.xylm.data.beans.User;
import com.example.popo.xylm.data.beans.Keys;
import com.example.popo.xylm.ui.activity.homeactivity.KeChengActivity;
import com.example.popo.xylm.ui.activity.homeactivity.MessageActivity;
import com.example.popo.xylm.ui.activity.child.YsDetailsActivity;
import com.example.popo.xylm.ui.activity.homeactivity.FamousTeaActivity;
import com.example.popo.xylm.ui.activity.homeactivity.XxhdActivity;
import com.example.popo.xylm.ui.activity.workActivity.TeacherXqActivity;
import com.example.popo.xylm.ui.adapter.CouseAdapter;
import com.example.popo.xylm.ui.adapter.HomewoksAdapter;
import com.example.popo.xylm.ui.adapter.TeacherAdapter;
import com.example.popo.xylm.ui.adapter.UnderLineAdpater;
import com.example.popo.xylm.utils.EncryptUtil;
import com.example.popo.xylm.utils.SPUtil;
import com.example.popo.xylm.utils.VerticalTextview;
import com.example.popo.xylm.xylm.XylmContract;
import com.example.popo.xylm.xylm.XylmModel;
import com.example.popo.xylm.xylm.XylmPresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<XylmModel, XylmPresenter> implements XylmContract.View, View.OnClickListener {


    private ImageView fyxx;
    private ImageView level;
    private TextView more;
    private TextView more2;
    private TextView more3;
    private TextView more4;
    private RecyclerView xhdRc;
    private RecyclerView zpRc;
    private RecyclerView kcRc;
    private Banner banner;
    private RecyclerView teacherRc;
    private List<String> listText = new ArrayList<>();
    private List<String> listImage = new ArrayList<>();
    private VerticalTextview textview;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        textview = (VerticalTextview) view.findViewById(R.id.home_text);
        teacherRc = view.findViewById(R.id.teacherRc);
        kcRc = view.findViewById(R.id.kcRc);
        xhdRc = view.findViewById(R.id.xhdRc);
        zpRc = view.findViewById(R.id.zpRc);
        banner = view.findViewById(R.id.banner);
        more = view.findViewById(R.id.more);
        more2 = view.findViewById(R.id.more2);
        more3 = view.findViewById(R.id.more3);
        more4 = view.findViewById(R.id.more4);
        fyxx = view.findViewById(R.id.fyxx);
        fyxx.setOnClickListener(this);
        more.setOnClickListener(this);
        more2.setOnClickListener(this);
        more4.setOnClickListener(this);
        mPresenter.getDataToken();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_book;
    }





    @Override
    public void showUser(User user) {

    }

    @Override
    public void showPreference(Preference preference) {

    }

    @Override
    public void showResetPass(ResetPass resetPass) {

    }

    @Override
    public void showYzm(Code code) {

    }

    @Override
    public void showYzmSucess(Code code) {

    }

    @Override
    public void showLogin(Login login) {

    }

    @Override
    public void showToken(TokenBean tokenBean) {
        String message = tokenBean.getMessage();
        Log.e("----TokenBean----", message);
        //第一步解密
        try {
            String decrypt = null;
            decrypt = EncryptUtil.decrypt(tokenBean.getData().getApptoken());
            //第二步获取当前系统毫秒数
            long timeMillis = System.currentTimeMillis();
            //第三步对token进行再次加密
            String encryptToken = EncryptUtil.encrypt(timeMillis + decrypt).replaceAll("\\n", "").toUpperCase();
            //第四步拼接系统当前时间保存token
            SPUtil.getInstance().put(Keys.TOKEN, encryptToken + "." + timeMillis);
            String o = (String) SPUtil.getInstance().get(Keys.USERAGENT, "");
            Log.e("-----USERAGENT-----", o);
            Log.e("-----Token-------", encryptToken + "." + timeMillis);
            //获取首页数据
            mPresenter.getDataHome((int) SPUtil.getInstance().get(Keys.ID, 0));
            int i = (int) SPUtil.getInstance().get(Keys.ID, 0);
            Log.e("------ID------",i+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showHome(HomeBean homeBean) {
        initBaner(homeBean);
        initText(homeBean);
        initTeacher(homeBean);
        initCourse(homeBean);
        initUnderLine(homeBean);
        initHomeWork(homeBean);
    }

    //首页作品推荐
    private void initHomeWork(HomeBean homeBean) {
        List<HomeBean.DataBean.HomewoksBean> homewoks = homeBean.getData().getHomewoks();
        HomewoksAdapter homewoksAdapter = new HomewoksAdapter(R.layout.homework, homewoks);
        zpRc.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        zpRc.setAdapter(homewoksAdapter);
    }

    //首页线下活动
    private void initUnderLine(final HomeBean homeBean) {
        List<HomeBean.DataBean.OfflineCourseBean> offlineCourse = homeBean.getData().getOfflineCourse();
        UnderLineAdpater underLineAdpater = new UnderLineAdpater(R.layout.underline, offlineCourse);
        xhdRc.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        xhdRc.setAdapter(underLineAdpater);
        more3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到线下活动详情页面
                Intent intent = new Intent(getContext(), XxhdActivity.class);
                intent.putExtra("xianxiahuodong",homeBean.getData());
                startActivity(intent);
            }
        });
    }


    //首页课程推荐
    private void initCourse(HomeBean homeBean) {
        List<HomeBean.DataBean.LiveCoursesBean> liveCourses = homeBean.getData().getLiveCourses();
        CouseAdapter couseAdapter = new CouseAdapter(R.layout.couse, liveCourses);
        kcRc.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        kcRc.setAdapter(couseAdapter);
    }

    //首页名师
    private void initTeacher(final HomeBean homeBean) {
        List<HomeBean.DataBean.UsersBean> users = homeBean.getData().getUsers();
        TeacherAdapter teacherAdapter = new TeacherAdapter(R.layout.laoshi, users);
        teacherRc.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        teacherRc.setAdapter(teacherAdapter);
        teacherAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), TeacherXqActivity.class);
                intent.putExtra("homeBean",homeBean);
                intent.putExtra("mPosition",position);
                startActivity(intent);
            }
        });
    }


    //首页轮播图
    private void initBaner(HomeBean homeBean) {
        HomeBean.DataBean data = homeBean.getData();
        for (int i = 0; i < data.getSystemAds().size(); i++) {
            listImage.add(data.getSystemAds().get(i).getMobileImgUrl());
        }
        Log.e("-----listImage-----", listImage.toString());
        banner.setImages(listImage);
        banner.setImageLoader(new ImageLoder());
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setDelayTime(3000);
        banner.start();
    }

    //向上滚动TextView
    private void initText(HomeBean homeBean) {
        HomeBean.DataBean data = homeBean.getData();
        List<HomeBean.DataBean.ArtcirclesBean> artcircles = data.getArtcircles();
        for (int i = 0; i < artcircles.size(); i++) {
            listText.add(artcircles.get(i).getTitle());
        }
        Log.e("-----listText------", listText.toString());
        textview.setTextList(listText);
        textview.setText(18, 50, Color.WHITE);//设置属性
        textview.setTextStillTime(4000);//设置停留时长间隔
        textview.setAnimTime(500);//设置进入和退出的时间间隔
        textview.startAutoScroll();
        textview.setOnItemClickListener(new VerticalTextview.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getContext(), YsDetailsActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fyxx:
                startActivity(new Intent(getContext(),MessageActivity.class));
                break;
            case R.id.more:
                startActivity(new Intent(getContext(),FamousTeaActivity.class));
                break;
            case R.id.more2:
                startActivity(new Intent(getContext(),KeChengActivity.class));
                break;
            case R.id.more4:

                break;
        }
    }
}
