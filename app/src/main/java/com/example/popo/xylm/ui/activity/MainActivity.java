package com.example.popo.xylm.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popo.xylm.R;
import com.example.popo.xylm.app.App;
import com.example.popo.xylm.utils.Exit;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    private ImageView imgs;
    private int count = 3;
    private Handler handler = new Handler();
    private TextView times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        MainActivityPermissionsDispatcher.initSuccessWithCheck(this);
        (Exit.activityList).add(this);
        handler.postDelayed(runnable,1000);

    }



    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            count--;
            times.setText(count + "");
            handler.postDelayed(this, 1000);
            if (count == 1) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        }
    };

    private void initView() {
        imgs = (ImageView) findViewById(R.id.imgs);
        times = (TextView) findViewById(R.id.times);
    }


    @NeedsPermission({Manifest.permission.READ_CALENDAR, Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_CALL_LOG, Manifest.permission.PROCESS_OUTGOING_CALLS, Manifest.permission.BODY_SENSORS, Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_WAP_PUSH, Manifest.permission.READ_EXTERNAL_STORAGE})
    void initSuccess() {
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnShowRationale({Manifest.permission.READ_CALENDAR, Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_CALL_LOG, Manifest.permission.PROCESS_OUTGOING_CALLS, Manifest.permission.BODY_SENSORS, Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_WAP_PUSH, Manifest.permission.READ_EXTERNAL_STORAGE})
    void initLoser(final PermissionRequest request) {
    }

    @OnPermissionDenied({Manifest.permission.READ_CALENDAR, Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_CALL_LOG, Manifest.permission.PROCESS_OUTGOING_CALLS, Manifest.permission.BODY_SENSORS, Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_WAP_PUSH, Manifest.permission.READ_EXTERNAL_STORAGE})
    void initPermmison() {
    }

    @OnNeverAskAgain({Manifest.permission.READ_CALENDAR, Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_CALL_LOG, Manifest.permission.PROCESS_OUTGOING_CALLS, Manifest.permission.BODY_SENSORS, Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_WAP_PUSH, Manifest.permission.READ_EXTERNAL_STORAGE})
    void initAsk() {
    }
}
