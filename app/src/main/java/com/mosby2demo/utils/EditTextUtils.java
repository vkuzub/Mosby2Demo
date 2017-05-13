package com.mosby2demo.utils;

import android.support.annotation.NonNull;
import android.widget.EditText;

/**
 * Created by Vyacheslav on 11.05.2016.
 */
public class EditTextUtils {

    public static boolean isEmpty(@NonNull EditText editText) {
        if (editText != null) {
            return editText.getText().toString().trim().length() == 0;
        }
        return false;
    }
}
