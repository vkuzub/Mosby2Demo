package com.mosby2demo;

import android.app.Application;
import android.content.Context;

/**
 * Created by Vyacheslav on 13.05.2017.
 */

public class App extends Application {

    private static Application sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return sApplication.getApplicationContext();
    }
}
