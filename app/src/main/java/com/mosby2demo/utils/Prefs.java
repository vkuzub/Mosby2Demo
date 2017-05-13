package com.mosby2demo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.mosby2demo.App;

/**
 * Created by Vyacheslav on 14.12.2015.
 */
public final class Prefs {

    private Prefs() {
    }

    private static Context context;
    private static SharedPreferences defaultPreference;
    private static SharedPreferences userPreferences;
    private static SharedPreferences filterPreferences;
    private static SharedPreferences tempPreferences;
    private static SharedPreferences gcmTempPreferences;

    public static final String USER_PREFS = "user_prefs";
    public static final String FILTER_PREFS = "filter_prefs";
    public static final String TEMP_PREFS = "temp_prefs";
    public static final String GCM_PREFS = "gcm_prefs";


    public static void init() {
        Prefs.context = App.getContext();
        defaultPreference = PreferenceManager.getDefaultSharedPreferences(context);
        userPreferences = context.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE);
        filterPreferences = context.getSharedPreferences(FILTER_PREFS, Context.MODE_PRIVATE);
        tempPreferences = context.getSharedPreferences(TEMP_PREFS, Context.MODE_PRIVATE);
        gcmTempPreferences = context.getSharedPreferences(GCM_PREFS, Context.MODE_PRIVATE);
    }

    public static SharedPreferences getDefaultPreferences() {
        return defaultPreference;
    }

    public static SharedPreferences getFilterPreferences() {
        return filterPreferences;
    }

    public static SharedPreferences getTempPreferences() {
        return tempPreferences;
    }

    public static SharedPreferences getUserPreferences() {
        return userPreferences;
    }

    public static SharedPreferences getGcmTempPreferences() {
        return gcmTempPreferences;
    }
}
