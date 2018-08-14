package com.example.popo.xylm.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseFragment;
import com.example.popo.xylm.data.beans.Keys;
import com.example.popo.xylm.ui.activity.child.InstallActivity;
import com.example.popo.xylm.ui.activity.child.childs.MineFansActivity;
import com.example.popo.xylm.ui.activity.child.childs.MineGzActivity;
import com.example.popo.xylm.ui.activity.homeactivity.MessageActivity;
import com.example.popo.xylm.ui.activity.mineactivity.ChongZhiActivity;
import com.example.popo.xylm.ui.activity.mineactivity.DingDanActivity;
import com.example.popo.xylm.ui.activity.mineactivity.JiGouActivity;
import com.example.popo.xylm.ui.activity.mineactivity.PianHaoActivity;
import com.example.popo.xylm.ui.activity.mineactivity.ShouCangActivity;
import com.example.popo.xylm.ui.activity.mineactivity.WoDeQuanActivity;
import com.example.popo.xylm.ui.activity.mineactivity.XiaoxiActivity;
import com.example.popo.xylm.ui.activity.mineactivity.ZuoPinActivity;
import com.example.popo.xylm.utils.SPUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {


    private ImageView me_sz;
    private ImageView me_msg;
    private ImageView me_tx;
    private TextView me_ph;
    private LinearLayout lin_ph;
    private TextView me_xx;
    private LinearLayout lin_msg;
    private TextView me_jg;
    private LinearLayout lin_jg;
    private LinearLayout lin_zp;
    private LinearLayout lin_sc;
    private LinearLayout lin_wdq;
    private LinearLayout lin_yg;
    private TextView me_gznum;
    private LinearLayout lin_megz;
    private TextView me_fansnum;
    private LinearLayout lin_mefans;
    private ImageView img;
    private LinearLayout mine_lincz;
    private ImageView imga;
    private ImageView imgb;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        me_msg = view.findViewById(R.id.me_msg);
        me_tx = view.findViewById(R.id.me_tx);
        me_sz = view.findViewById(R.id.me_sz);
        me_xx = view.findViewById(R.id.me_xx);
        lin_megz = view.findViewById(R.id.lin_megz);
        me_gznum = view.findViewById(R.id.me_gznum);
        lin_mefans = view.findViewById(R.id.lin_mefans);
        lin_msg = view.findViewById(R.id.lin_msg);
        lin_jg = view.findViewById(R.id.lin_jg);
        lin_yg = view.findViewById(R.id.lin_yg);
        me_fansnum = view.findViewById(R.id.me_fansnum);
        lin_zp = view.findViewById(R.id.lin_zp);
        lin_ph = view.findViewById(R.id.lin_ph);
        lin_sc = view.findViewById(R.id.lin_sc);
        lin_wdq = view.findViewById(R.id.lin_wdq);
        mine_lincz = view.findViewById(R.id.mine_lincz);
        lin_ph.setOnClickListener(this);
        lin_msg.setOnClickListener(this);
        lin_jg.setOnClickListener(this);
        me_msg.setOnClickListener(this);
        me_sz.setOnClickListener(this);
        me_tx.setOnClickListener(this);
        lin_megz.setOnClickListener(this);
        me_gznum.setOnClickListener(this);
        lin_mefans.setOnClickListener(this);
        me_fansnum.setOnClickListener(this);
        lin_zp.setOnClickListener(this);
        lin_sc.setOnClickListener(this);
        lin_wdq.setOnClickListener(this);
        lin_yg.setOnClickListener(this);
        mine_lincz.setOnClickListener(this);
        Glide.with(getContext()).load(SPUtil.getInstance().get(Keys.LOGIN_IMAGE,"")).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(me_tx);
        me_xx.setText((String)SPUtil.getInstance().get(Keys.LOGIN_NAME,""));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.me_msg:
                startActivity(new Intent(getContext(), MessageActivity.class));
                break;
            case R.id.me_sz:
                startActivity(new Intent(getContext(), InstallActivity.class));
                break;
            case R.id.lin_megz:
                startActivity(new Intent(getContext(), MineGzActivity.class));
                break;
            case R.id.me_gznum:
                break;
            case R.id.lin_mefans:
                startActivity(new Intent(getContext(), MineFansActivity.class));
                break;
            case R.id.me_fansnum:
                break;
            case R.id.lin_ph:
                startActivity(new Intent(getContext(), PianHaoActivity.class));
                break;
            case R.id.lin_msg:
                startActivity(new Intent(getContext(), XiaoxiActivity.class));
                break;
            case R.id.lin_jg:
                startActivity(new Intent(getContext(), JiGouActivity.class));
                break;
            case R.id.lin_zp:
                startActivity(new Intent(getContext(), ZuoPinActivity.class));
                break;
            case R.id.lin_sc:
                startActivity(new Intent(getContext(), ShouCangActivity.class));
                break;
            case R.id.lin_wdq:
                startActivity(new Intent(getContext(), WoDeQuanActivity.class));
                break;
            case R.id.lin_yg:
                startActivity(new Intent(getContext(), DingDanActivity.class));
                break;
            case R.id.mine_lincz:
                startActivity(new Intent(getContext(), ChongZhiActivity.class));
                break;
            case R.id.me_tx:
                startActivity(new Intent(getContext(), ChongZhiActivity.class));
                break;
        }
    }
}
