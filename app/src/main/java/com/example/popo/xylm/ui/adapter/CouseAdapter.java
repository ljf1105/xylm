package com.example.popo.xylm.ui.adapter;

import android.support.annotation.Nullable;
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

public class CouseAdapter extends BaseQuickAdapter<HomeBean.DataBean.LiveCoursesBean, BaseViewHolder> {

    public CouseAdapter(int layoutResId, @Nullable List<HomeBean.DataBean.LiveCoursesBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.DataBean.LiveCoursesBean item) {
        helper.setText(R.id.couse_zb,"重播");
        helper.setText(R.id.couse_name,item.getRealname());
        helper.setText(R.id.couse_intro,item.getIntro());
        helper.setText(R.id.couse_price,"¥ "+item.getPrice());
        helper.setText(R.id.couse_title,item.getTitle());
        helper.setText(R.id.couse_type,item.getType());
        helper.setText(R.id.couse_time,"开课时间：05-02 20:00");
        Glide.with(mContext).load(item.getPhoto()).into((ImageView) helper.getView(R.id.couse_photo));
        int userType = item.getUserType();
        if (userType==6) {
            helper.setImageResource(R.id.couse_small,R.mipmap.home_level_vip_blue);
        }else if (userType==4){
            helper.setImageResource(R.id.couse_small,R.mipmap.home_level_vip_red);
        }else {
            helper.setImageResource(R.id.couse_small,R.mipmap.home_level_vip_yellow);
        }
    }
}
