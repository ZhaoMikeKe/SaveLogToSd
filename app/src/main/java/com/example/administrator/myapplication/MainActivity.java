package com.example.administrator.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    private RxPermissions rxPermissions;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat df1 = new SimpleDateFormat("HH:mm");

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtils.getConfig().setDir(new File(Environment.getExternalStorageDirectory().getPath() + "/myLog0412/" + "MainActivity/" + df.format(System.currentTimeMillis()) + "/" + df1.format(System.currentTimeMillis())));
        rxPermissions = new RxPermissions(this);
        //申请权限
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        // All requested permissions are granted
                        LogUtils.d("zhaohulun");
                    } else {
                        // At least one permission is denied

                    }

                });
    }
}
