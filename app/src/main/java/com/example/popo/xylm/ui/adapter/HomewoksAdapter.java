package com.example.popo.xylm.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.popo.xylm.R;
import com.example.popo.xylm.data.beans.HomeBean;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by popo on 2018/7/31.
 */

public class HomewoksAdapter extends BaseQuickAdapter<HomeBean.DataBean.HomewoksBean, BaseViewHolder> {
    public HomewoksAdapter(int layoutResId, @Nullable List<HomeBean.DataBean.HomewoksBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.DataBean.HomewoksBean item) {
        helper.setText(R.id.sub_name,item.getNickname());
        helper.setText(R.id.sub_source,"05/02  来自"+item.getSource());
        helper.setText(R.id.sub_content,item.getContent());
        helper.setText(R.id.work_teaname,item.getTRealname());
        helper.setText(R.id.work_teaLx,item.getTIntro());
        Glide.with(mContext).load(item.getPhoto()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into((ImageView) helper.getView(R.id.work_subImg));
        Glide.with(mContext).load(item.getTPhoto()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into((ImageView) helper.getView(R.id.work_teaImg));
        helper.setImageResource(R.id.work_teaSmallImg,R.mipmap.home_level_vip_blue);
        JZVideoPlayerStandard jzVideo = helper.getView(R.id.jcPlayer);
        jzVideo.setUp(item.getPath(),JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL);
        Glide.with(mContext).load(item.getPath()).into(jzVideo.thumbImageView);
        jzVideo.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }
}
