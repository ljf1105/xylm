package com.example.popo.xylm.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.popo.xylm.R;
import com.example.popo.xylm.data.beans.Preference;

import java.util.List;

/**
 * Created by popo on 2018/7/29.
 */

public class CollegesAdapter extends BaseQuickAdapter<Preference.DataBean.CollegesBean, BaseViewHolder> {

    public CollegesAdapter(int layoutResId, @Nullable List<Preference.DataBean.CollegesBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Preference.DataBean.CollegesBean item) {
        helper.setText(R.id.checkbox,item.getName());
    }
}
