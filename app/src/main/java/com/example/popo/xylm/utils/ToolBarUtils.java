package com.example.popo.xylm.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.popo.xylm.R;
import com.example.popo.xylm.base.BaseActivity;

/**
 * Created by popo on 2018/8/1.
 */

public class ToolBarUtils {
    private static ToolBarUtils toolBarUtils;

    private ToolBarUtils() {
    }

    public static ToolBarUtils newInstance() {
        if (null == toolBarUtils) {
            synchronized (ToolBarUtils.class){
                if (null == toolBarUtils) {
                    toolBarUtils=new ToolBarUtils();
                }
            }
        }
        return toolBarUtils;
    }
    public void setToolBar(final BaseActivity activity, Toolbar toolBar, TextView textView, String result) {
        textView.setText(result);
        textView.setTextSize(16);
        toolBar.setTitle("");
        activity.setSupportActionBar(toolBar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }


}
