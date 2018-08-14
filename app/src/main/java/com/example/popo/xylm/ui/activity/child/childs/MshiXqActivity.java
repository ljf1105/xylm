package com.example.popo.xylm.ui.activity.child.childs;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;
import com.example.popo.xylm.data.beans.MingTeacher;
import com.example.popo.xylm.ui.activity.homeactivity.PublishActivity;

import java.util.List;

public class MshiXqActivity extends BaseActivity implements View.OnClickListener {

    private ImageView msxq_img;
    private ImageView msxq_back;
    private ImageView msxq_share;
    private TextView msxq_skilled;
    private LinearLayout lin_fd;
    private ImageView msxq_smallImg;
    private TextView msxq_name;
    private ImageView msxq_dianzai;
    private WebView msxq_webView;
    private TextView msxq_zy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mshi_xq);
        initView();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mshi_xq;
    }

    private void initView() {
        msxq_img = (ImageView) findViewById(R.id.msxq_img);
        msxq_img.setOnClickListener(this);
        msxq_back = (ImageView) findViewById(R.id.msxq_back);
        msxq_back.setOnClickListener(this);
        msxq_share = (ImageView) findViewById(R.id.msxq_share);
        msxq_share.setOnClickListener(this);
        msxq_skilled = (TextView) findViewById(R.id.msxq_skilled);
        msxq_skilled.setOnClickListener(this);
        msxq_smallImg = (ImageView) findViewById(R.id.msxq_smallImg);
        msxq_smallImg.setOnClickListener(this);
        msxq_name = (TextView) findViewById(R.id.msxq_name);
        msxq_name.setOnClickListener(this);
        msxq_dianzai = (ImageView) findViewById(R.id.msxq_dianzai);
        msxq_dianzai.setOnClickListener(this);
        msxq_webView = (WebView) findViewById(R.id.msxq_webView);
        msxq_webView.setOnClickListener(this);
        msxq_zy = (TextView) findViewById(R.id.msxq_zy);
        msxq_webView.setOnClickListener(this);
        lin_fd = (LinearLayout) findViewById(R.id.ling_fd);
        lin_fd.setOnClickListener(this);

        initMsData();

    }

    private void initMsData() {
        Intent intent = getIntent();
        MingTeacher mingshi = (MingTeacher) intent.getSerializableExtra("mingshi");
        int msposition = intent.getIntExtra("msposition", 0);
        Log.e("-------------skilled", msposition + "");
        List<MingTeacher.DataBean.ListBean> list = mingshi.getData().getList();
        Glide.with(this).load(list.get(msposition).getImages()).into(msxq_img);
        Glide.with(this).load(list.get(msposition).getPhoto()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(msxq_smallImg);
        msxq_name.setText(list.get(msposition).getNickname());
        msxq_zy.setText(list.get(msposition).getIntro());
        msxq_skilled.setText(list.get(msposition).getSkilled() + " ");

        WebSettings settings = msxq_webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //url
        final String url = "<html><body>" + list.get(msposition).getDetails() + "</body></html>";
//        自适应屏幕
        settings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
//        细节操作
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true); //支持js弹窗
        msxq_webView.loadDataWithBaseURL(null, url, "text/html", "utf-8", null);
        msxq_webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadDataWithBaseURL(null, url, "text/html", "utf-8", null);
                return true;
            }
        });

        switch (list.get(msposition).getUserType()) {
            //达人
            case 2:
                msxq_dianzai.setImageResource(R.mipmap.daren);
                break;
            //名师
            case 3:
                msxq_dianzai.setImageResource(R.mipmap.home_level_vip_yellow);
                break;
            //顾问
            case 4:
                msxq_dianzai.setImageResource(R.mipmap.home_level_vip_red);
                break;
            //导师
            case 6:
                msxq_dianzai.setImageResource(R.mipmap.home_level_vip_blue);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.msxq_back:
                finish();
                break;
            case R.id.msxq_share:
                Toast.makeText(this, "2222222222", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ling_fd:
                startActivity(new Intent(this, PublishActivity.class));
                break;
        }
    }
}
