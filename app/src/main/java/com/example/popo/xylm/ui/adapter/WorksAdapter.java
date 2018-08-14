package com.example.popo.xylm.ui.adapter;

import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.popo.xylm.R;
import com.example.popo.xylm.data.beans.HomeWorks;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by popo on 2018/7/31.
 */

public class WorksAdapter extends BaseQuickAdapter<HomeWorks.DataBean.ListBean, BaseViewHolder> {
    private View.OnClickListener onClickListener;
    private boolean isNum = false;
    private PopupWindow popupWindow;

    public WorksAdapter(int layoutResId, @Nullable List<HomeWorks.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final HomeWorks.DataBean.ListBean item) {
        // 毫秒转日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy" + "/" + "MM" + "/" + "dd");
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(item.getCreateDate());
        Date date = c.getTime();
        helper.setText(R.id.sub_source, sdf.format(date) + " 来自 " + item.getSource()).addOnClickListener(R.id.sub_source);
        helper.setText(R.id.sub_name, item.getNickname()).addOnClickListener(R.id.sub_name);
        helper.setText(R.id.sub_content, item.getContent()).addOnClickListener(R.id.sub_content);
        helper.setText(R.id.work_teaname, item.getTRealname()).addOnClickListener(R.id.work_teaname);
        helper.setText(R.id.work_teaLx, item.getTIntro()).addOnClickListener(R.id.work_teaLx);
        helper.getView(R.id.sub_name).setOnClickListener(onClickListener);
        helper.getView(R.id.sub_source).setOnClickListener(onClickListener);
        helper.getView(R.id.work_teaname).setOnClickListener(onClickListener);
        helper.getView(R.id.work_teaLx).setOnClickListener(onClickListener);
        helper.getView(R.id.work_messege).setOnClickListener(onClickListener);
        helper.getView(R.id.work_lw).setOnClickListener(onClickListener);
        helper.getView(R.id.work_fx).setOnClickListener(onClickListener);
        helper.getView(R.id.work_lin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopup();
                //从底部弹出
                popupWindow.showAtLocation(helper.getView(R.id.work_dblin), Gravity.BOTTOM, 0, 0);
            }
        });
        helper.getView(R.id.work_dz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "rrrrrrrrrrrrrr", Toast.LENGTH_SHORT).show();
                if (isNum) {
                    helper.setImageResource(R.id.work_dz, R.mipmap.detail_praisse_normal);
                    helper.setText(R.id.work_dzText, item.getPraiseNum() + "");
                    isNum = false;
                } else {
                    helper.setImageResource(R.id.work_dz, R.mipmap.xiaoshou);
                    helper.setText(R.id.work_dzText, item.getPraiseNum() + 1 + "");
                    isNum = true;
                }


            }
        });
        Glide.with(mContext).load(item.getPhoto()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into((ImageView) helper.getView(R.id.work_subImg));
        helper.getView(R.id.work_subImg).setOnClickListener(onClickListener);
        Glide.with(mContext).load(item.getTPhoto()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into((ImageView) helper.getView(R.id.work_teaImg));
        helper.getView(R.id.work_teaImg).setOnClickListener(onClickListener);
        helper.setImageResource(R.id.work_teaSmallImg, R.mipmap.home_level_vip_blue);
        JZVideoPlayerStandard jzVideo = helper.getView(R.id.jcPlayer);
        jzVideo.setUp(item.getPath(), JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL);
        Glide.with(mContext).load(item.getPath()).into(jzVideo.thumbImageView);
        jzVideo.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
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
