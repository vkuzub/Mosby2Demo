package com.mosby2demo.base;

import android.support.annotation.StringRes;

/**
 * Created by Vyacheslav on 12.09.2016.
 */
public interface HideShowContentSupport {

    void showContent();

    void showLoading();

    void showError(String msg);

    void showError(@StringRes int msg);

    void showEmpty(String msg);

    void showEmpty(@StringRes int msg);

    void showMessage(String msg);

    void showMessage(int msg);

    void doOnComplete();
}
