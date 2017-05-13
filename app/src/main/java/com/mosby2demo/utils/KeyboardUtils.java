package com.mosby2demo.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.mosby2demo.App;


/**
 * Created by Vyacheslav on 18.07.2016.
 */
public final class KeyboardUtils {

    private KeyboardUtils() {
    }

    public static void showKeyboard(View target) {
        if (target != null) {
            InputMethodManager imm = (InputMethodManager) App.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(target, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    public static void hideKeyboard(View target) {
        if (target != null) {
            InputMethodManager imm = (InputMethodManager) App.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(target.getWindowToken(), 0);
        }
    }
}
