package com.example.popo.xylm.ui.adapter;

import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.popo.xylm.R;
import com.example.popo.xylm.data.beans.ChongZhi;

import java.util.List;

/**
 * Created by popo on 2018/8/7.
 */

public class ChongZhiAdapter extends BaseQuickAdapter<ChongZhi.DataBean.ListBean,BaseViewHolder> {
    private PopupWindow popupWindow;

    public ChongZhiAdapter(int layoutResId, @Nullable List<ChongZhi.DataBean.ListBean> data) {
        super(layoutResId, data);
    }



    @Override
    protected void convert(final BaseViewHolder helper, ChongZhi.DataBean.ListBean item) {
        helper.setText(R.id.cz_num,item.getAmountAndroid()+"");
        helper.setText(R.id.cz_btn,item.getPriceAndroid()+"");
    }


    private void initPopup() {
        popupWindow = new PopupWindow();
        View view = LayoutInflater.from(mContext).inflate(R.layout.zhifu_item, null);
        Button cancel = (Button) view.findViewById(R.id.work_cancel);
        popupWindow.setContentView(view);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
}
