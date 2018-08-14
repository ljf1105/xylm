package com.example.popo.xylm.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.popo.xylm.R;
import com.example.popo.xylm.data.beans.Preference;

import java.util.List;

/**
 * Created by popo on 2018/7/29.
 */

public class MajorsAdapter extends BaseQuickAdapter<Preference.DataBean.MajorsBean, BaseViewHolder> {

    public MajorsAdapter(int layoutResId, @Nullable List<Preference.DataBean.MajorsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Preference.DataBean.MajorsBean item) {
        helper.setText(R.id.checkbox,item.getName());
        CheckBox checkBox = helper.getView(R.id.checkbox);

    }
}
