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

public class UnderLineAdpater extends BaseQuickAdapter<HomeBean.DataBean.OfflineCourseBean,BaseViewHolder> {

    public UnderLineAdpater(int layoutResId, @Nullable List<HomeBean.DataBean.OfflineCourseBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.DataBean.OfflineCourseBean item) {
        helper.setText(R.id.line_adress,item.getAddress());
        helper.setText(R.id.line_price,"¥ "+item.getPrice());
        helper.setText(R.id.line_title,item.getTitle());
        helper.setText(R.id.line_time,"开课时间：11-05 20:00");
        helper.setText(R.id.line_num,item.getReservationNum()+"/"+item.getSubscribeNum());
        Glide.with(mContext).load(item.getCoverImg()).into((ImageView) helper.getView(R.id.line_photo));
    }
}
