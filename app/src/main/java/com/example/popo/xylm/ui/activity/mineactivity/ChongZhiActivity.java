package com.example.popo.xylm.ui.activity.mineactivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.data.beans.ChongZhi;
import com.example.popo.xylm.data.beans.CzDingDan;
import com.example.popo.xylm.data.beans.Keys;
import com.example.popo.xylm.data.beans.ZhiFu;
import com.example.popo.xylm.mine.MineContract;
import com.example.popo.xylm.mine.MineModel;
import com.example.popo.xylm.mine.MinePresenter;
import com.example.popo.xylm.ui.adapter.ChongZhiAdapter;
import com.example.popo.xylm.utils.RetrofitUtils;
import com.example.popo.xylm.utils.SPUtil;

import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ChongZhiActivity extends BaseActivity<MineModel, MinePresenter> implements MineContract.View {

    private TextView fy_text;
    private TextView fy_text2;
    private Toolbar fy_toolbar;
    private TextView cz_phone;
    private TextView cz_ye;
    private RecyclerView cz_recycler;
    private PopupWindow popupWindow;
    private LinearLayout lin_czitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chong_zhi);
        initView();
        initTool();
    }

    private void initTool() {
        fy_text.setText("充值中心");
        fy_text2.setText("账单");
        fy_text.setTextSize(16);
        fy_toolbar.setTitle("");
        setSupportActionBar(fy_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fy_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        presenter.getDataCz((Integer) SPUtil.getInstance().get(Keys.ID, 0));

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chong_zhi;
    }

    private void initView() {
        fy_text = (TextView) findViewById(R.id.fy_text);
        fy_text2 = (TextView) findViewById(R.id.fy_text2);
        fy_toolbar = (Toolbar) findViewById(R.id.fy_toolbar);
        cz_phone = (TextView) findViewById(R.id.cz_phone);
        cz_ye = (TextView) findViewById(R.id.cz_ye);
        cz_recycler = (RecyclerView) findViewById(R.id.cz_recycler);
        lin_czitem = (LinearLayout) findViewById(R.id.lin_czitem);
    }

    @Override
    public void showChongZhi(ChongZhi chongZhi) {
        ChongZhi.DataBean data = chongZhi.getData();
        String mobile = data.getMobile();
        int amount = data.getAmount();
        cz_phone.setText(mobile);
        cz_ye.setText(amount + "");
        ChongZhiAdapter chongZhiAdapter = new ChongZhiAdapter(R.layout.chongzhi_item, data.getList());
        cz_recycler.setLayoutManager(new LinearLayoutManager(this));
        cz_recycler.setAdapter(chongZhiAdapter);

        initItemOnClick(chongZhiAdapter,chongZhi);
    }

    private void initItemOnClick(ChongZhiAdapter chongZhiAdapter, final ChongZhi chongZhi) {
        chongZhiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                initPopup(position,chongZhi);
                popupWindow.showAtLocation(lin_czitem, Gravity.BOTTOM, 0, 0);
            }
        });
    }

    private void initPopup(final int position, final ChongZhi chongZhi) {
        popupWindow = new PopupWindow();
        View view = LayoutInflater.from(this).inflate(R.layout.zhifu_item, null);
        Button cancel = (Button) view.findViewById(R.id.work_cancel);
        popupWindow.setContentView(view);
        LinearLayout lin_zfb = view.findViewById(R.id.lin_zfb);
        final LinearLayout lin_wx = view.findViewById(R.id.lin_wxzf);
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

        lin_zfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ChongZhi.DataBean.ListBean> list = chongZhi.getData().getList();
                int priceAndroid = list.get(position).getPriceAndroid();
                int amountAndroid = list.get(position).getAmountAndroid();
                presenter.getDataCzDd((Integer)SPUtil.getInstance().get(Keys.ID,0),(double)priceAndroid,amountAndroid);

            }
        });
    }


    @Override
    public void showCzDingDan(CzDingDan czDingDan) {
        if (czDingDan.getMessage().equals("成功")) {
            String orderNo = czDingDan.getData().getOrderNo();
            Log.e("-----ORDERNO------",orderNo);
            presenter.getDataZhiFu(orderNo);
        }
    }
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(ChongZhiActivity.this, "支付成功", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent();



                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(ChongZhiActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                default:
                    break;
            }
        };
    };
    @Override
    public void showZhiFu(ZhiFu zhiFu) {
        final String data = zhiFu.getData();
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(ChongZhiActivity.this);

//                                String result = alipay.payV2(orderInfo,true);

                Map<String, String> result = alipay.payV2(data,true);

                Message msg = new Message();
                msg.what = 1;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }






}
