package com.mosby2demo.utils;

import android.support.annotation.NonNull;

/**
 * Created by Vyacheslav on 20.06.2016.
 */
public final class TokenUtils {

    public static final String BEARER = "Bearer ";

    public static String getBearerToken(@NonNull String token) {
        return BEARER + token;
    }

}
