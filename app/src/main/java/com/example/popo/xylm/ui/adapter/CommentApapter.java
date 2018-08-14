package com.example.popo.xylm.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.popo.xylm.R;
import com.example.popo.xylm.data.beans.Comment;
import com.example.popo.xylm.data.beans.WorkXq;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by popo on 2018/8/5.
 */

public class CommentApapter extends BaseQuickAdapter<WorkXq.DataBean.CommentsBean.ListBean, BaseViewHolder> {

    public CommentApapter(int layoutResId, @Nullable List<WorkXq.DataBean.CommentsBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WorkXq.DataBean.CommentsBean.ListBean item) {
        Glide.with(mContext).load(item.getPhoto()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into((ImageView) helper.getView(R.id.comm_Image));
        helper.setText(R.id.comm_name,item.getNickname());
        helper.setText(R.id.comm_pl,item.getContent());
        helper.setText(R.id.comm_num,item.getPraiseNum()+"");
        // 毫秒转日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+"/"+"MM"+"/"+"dd");
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(item.getCreateDate());
        Date date = c.getTime();
        System.out.println("-----时间------"+sdf.format(date));
        helper.setText(R.id.comm_data,sdf.format(date)+"");

    }
}
