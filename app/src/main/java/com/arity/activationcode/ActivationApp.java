package com.arity.activationcode;

import android.app.Application;
import android.content.Context;


public class ActivationApp extends Application {

    private static ActivationApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public static ActivationApp getInstance() {
        return instance;
    }

}
