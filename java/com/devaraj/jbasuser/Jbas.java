package com.harshini.jbasuser;

import android.app.Application;

import com.onesignal.OneSignal;

public class Jbas extends Application {
    private static final String ONESIGNAL_APP_ID = "3c5ee799-ed5c-481e-9de8-383c62d3d183";
    @Override
    public void onCreate() {
        super.onCreate();
        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }
}