package com.example.popo.xylm.ui.activity.child;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.popo.xylm.R;

public class InstallActivity extends AppCompatActivity {

    private Toolbar fy_toolbar;
    private TextView fy_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_install);
        initView();
        initToolBar();
    }

    private void initToolBar() {
        fy_text.setText("设置");
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

    private void initView() {
        fy_toolbar = (Toolbar) findViewById(R.id.fy_toolbar);
        fy_text = (TextView) findViewById(R.id.fy_text);
    }
}
