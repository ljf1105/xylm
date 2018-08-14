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
 * Created by popo on 2018/8/3.
 */

public class XxhAdapter extends BaseQuickAdapter<HomeBean.DataBean.OfflineCourseBean,BaseViewHolder>{
    public XxhAdapter(int layoutResId, @Nullable List<HomeBean.DataBean.OfflineCourseBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.DataBean.OfflineCourseBean item) {
        helper.setText(R.id.kecheng_adress,item.getAddress());
        helper.setText(R.id.kecheng_nums,"已预约："+item.getReservationNum()+""+item.getSubscribeNum());
        helper.setText(R.id.kecheng_price,"¥ "+item.getPrice());
        Glide.with(mContext).load(item.getCoverImg()).into((ImageView) helper.getView(R.id.kecheng_imgs));
    }
}
