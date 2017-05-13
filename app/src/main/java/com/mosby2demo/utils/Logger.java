package com.mosby2demo.utils;

import android.util.Log;

import com.mosby2demo.BuildConfig;

/**
 * Created by Vyacheslav on 12.04.2016.
 */
public class Logger {

    public static final String LOG_TAG = "Inforoom";

    public static void showLog(Object object, String msg) {
        if (isDebugBuild()) {
            String output = String.format("[%s] - %s", object.getClass().getCanonicalName(), msg);
            Log.d(LOG_TAG, output);
        }
    }

    //todo check it
    public static boolean isDebugBuild() {
        if (BuildConfig.DEBUG) {
            return true;
        }
        return false;
    }

}
