package com.example.popo.xylm.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.popo.xylm.R;
import com.example.popo.xylm.data.beans.HomeBean;

import java.util.List;

/**
 * Created by popo on 2018/7/31.
 */

public class TeacherAdapter extends BaseQuickAdapter<HomeBean.DataBean.UsersBean, BaseViewHolder> {

    public TeacherAdapter(int layoutResId, @Nullable List<HomeBean.DataBean.UsersBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.DataBean.UsersBean item) {
        helper.setText(R.id.tacher_name,item.getRealname());
        helper.setText(R.id.tacher_intro,item.getIntro());
        Glide.with(mContext).load(item.getPhoto()).into((ImageView) helper.getView(R.id.tacher_photo));
        int userType = item.getUserType();
        if (userType==6) {
            helper.setImageResource(R.id.teacher_small,R.mipmap.home_level_vip_blue);
        }else if (userType==4){
            helper.setImageResource(R.id.teacher_small,R.mipmap.home_level_vip_red);
        }else {
            helper.setImageResource(R.id.teacher_small,R.mipmap.home_level_vip_yellow);
        }
    }
}
