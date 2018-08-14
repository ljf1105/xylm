package com.example.popo.xylm.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.popo.xylm.R;
import com.example.popo.xylm.data.beans.YkHome;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by popo on 2018/8/1.
 */

public class YsHomeAdapter extends BaseQuickAdapter<YkHome.DataBean.ArtcircleListBean.ListBean,BaseViewHolder> {

    public YsHomeAdapter(int layoutResId, @Nullable List<YkHome.DataBean.ArtcircleListBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, YkHome.DataBean.ArtcircleListBean.ListBean item) {
        helper.setText(R.id.ys_subname,item.getNickname());
        helper.setText(R.id.ys_subsource,item.getPraiseNum()+"天前");
        helper.setText(R.id.ys_subcontent,item.getTitle());
        helper.setText(R.id.ys_name,item.getContent());
        helper.setText(R.id.ys_contentType,item.getContentType());
        Glide.with(mContext).load(item.getPhoto()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into((ImageView) helper.getView(R.id.ys_subImg));
        JZVideoPlayerStandard jzVideo = helper.getView(R.id.ys_jcPlayer);
        jzVideo.setUp(item.getPath(),JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL);
        Glide.with(mContext).load(item.getPath()).into(jzVideo.thumbImageView);
        jzVideo.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);

    }
}
