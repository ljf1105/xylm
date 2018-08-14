package com.example.popo.xylm.ui.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.popo.xylm.R;
import com.example.popo.xylm.data.beans.MingTeacher;

import java.util.List;

/**
 * Created by popo on 2018/8/2.
 */

public class MsXqAdapter extends BaseQuickAdapter<MingTeacher.DataBean.ListBean, BaseViewHolder> {

    public MsXqAdapter(int layoutResId, @Nullable List<MingTeacher.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MingTeacher.DataBean.ListBean item) {


    }
}
