package com.example.popo.xylm.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.popo.xylm.R;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AgreementActivity extends AppCompatActivity {

    @BindView(R.id.tyView)
    View tyView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.argreRecycler)
    RecyclerView argreRecycler;
    @BindView(R.id.agback)
    ImageView agback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
        ButterKnife.bind(this);
        initTool();
    }

    private void initTool() {
        ImmersionBar.with(AgreementActivity.this)
                .statusBarView(tyView)
                .init();
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

    }


    @OnClick(R.id.agback)
    public void onViewClicked() {
        finish();
    }
}
