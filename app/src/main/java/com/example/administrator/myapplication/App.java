package com.example.administrator.myapplication;

import android.app.Application;
import android.os.Environment;

import java.io.File;

public class App extends Application {
    public static App mApp;
    private LogUtils.Config config;

    public App() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        config = LogUtils.getConfig();
        config.setLogSwitch(true);
        config.setGlobalTag("myApp");
        config.setConsoleSwitch(true);
        config.setLog2FileSwitch(true);
    }

}
