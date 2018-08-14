package com.example.popo.xylm.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.popo.xylm.R;
import com.example.popo.xylm.data.beans.LiveBean;

import java.util.List;

/**
 * Created by popo on 2018/8/3.
 */

public class LiveAdapter extends BaseQuickAdapter<LiveBean.DataBean.ListBean, BaseViewHolder> {

    public LiveAdapter(int layoutResId, @Nullable List<LiveBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LiveBean.DataBean.ListBean item) {
        helper.setText(R.id.kecheng_name,item.getRealname());
        helper.setText(R.id.kecheng_zy,item.getType());
        helper.setText(R.id.kecheng_num,"已预约："+item.getIsSubscribe()+""+item.getSubscribeNum());
        helper.setText(R.id.kecheng_money,"¥ "+item.getPrice());
        Glide.with(mContext).load(item.getCoverImg()).into((ImageView) helper.getView(R.id.kecheng_img));
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
