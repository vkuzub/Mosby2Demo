package com.mosby2demo.base;

import android.support.annotation.StringRes;

/**
 * Created by Vyacheslav on 12.09.2016.
 */
public interface HideShowContentSupport {

    void showContent();

    void showLoading();

//    void showError(@Nullable String msg);
//
//    void showError(@StringRes int res);
//
//    void showEmpty(@Nullable String msg);
//
//    void showEmpty(@StringRes int res);

    void showErrorMessage(String msg, boolean toast);

    void showErrorMessage(@StringRes int msg, boolean toast);

    void showEmptyMessage(String msg, boolean toast);

    void showEmptyMessage(@StringRes int msg, boolean toast);

    void showMessage(String msg);

    void showMessage(int msg);

    void doOnComplete();
}
