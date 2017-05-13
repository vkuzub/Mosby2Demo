package com.mosby2demo.utils;

import android.content.res.ColorStateList;
import android.support.annotation.ColorRes;
import android.support.v4.view.ViewCompat;
import android.view.View;

import com.mosby2demo.App;

/**
 * Created by Vyacheslav on 26.12.2016.
 */

public class ButtonTintUtils {

    public static void setButtonEnabled(View view, boolean enabled, @ColorRes int colorEnabled, @ColorRes int colorDisabled) {
        if (enabled) {
            ViewCompat.setBackgroundTintList(view, ColorStateList.valueOf(App.getContext().getResources().getColor(colorEnabled)));
            view.setEnabled(true);
        } else {
            ViewCompat.setBackgroundTintList(view, ColorStateList.valueOf(App.getContext().getResources().getColor(colorDisabled)));
            view.setEnabled(false);
        }
    }

}
