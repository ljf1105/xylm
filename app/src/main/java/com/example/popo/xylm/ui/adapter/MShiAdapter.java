package com.example.popo.xylm.ui.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.popo.xylm.R;
import com.example.popo.xylm.data.beans.MingTeacher;

import java.util.List;

/**
 * Created by popo on 2018/8/2.
 */

public class MShiAdapter extends BaseQuickAdapter<MingTeacher.DataBean.ListBean, BaseViewHolder> {

    public MShiAdapter(int layoutResId, @Nullable List<MingTeacher.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MingTeacher.DataBean.ListBean item) {
        Glide.with(mContext).load(item.getPhoto()).into((ImageView) helper.getView(R.id.mshi_img));
        helper.setText(R.id.mshi_name, item.getRealname());
        helper.setText(R.id.mshi_type, item.getIntro());
        helper.addOnClickListener(R.id.msxq_back);
        helper.addOnClickListener(R.id.msxq_share);
        switch (item.getUserType()) {
            //达人
            case 2:
                helper.setImageResource(R.id.mshi_smallImage,R.mipmap.daren);
                break;
            //名师
            case 3:
                helper.setImageResource(R.id.mshi_smallImage,R.mipmap.home_level_vip_yellow);
                break;
            //顾问
            case 4:
                helper.setImageResource(R.id.mshi_smallImage,R.mipmap.home_level_vip_red);
                break;
            //导师
            case 6:
                helper.setImageResource(R.id.mshi_smallImage, R.mipmap.home_level_vip_blue);
                break;
        }
    }
}
