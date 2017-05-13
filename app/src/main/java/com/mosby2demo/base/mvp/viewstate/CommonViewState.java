package com.mosby2demo.base.mvp.viewstate;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;
import com.mosby2demo.App;
import com.mosby2demo.R;
import com.mosby2demo.base.mvp.BaseMvpFragmentView;

/**
 * Created by Vyacheslav on 12.09.2016.
 */
public class CommonViewState implements RestorableViewState<BaseMvpFragmentView> {

    private static final int STATE_SHOW_CONTENT = 0;
    private static final int STATE_SHOW_LOADING = 1;
    private static final int STATE_SHOW_ERROR = 2;
    private static final int STATE_SHOW_EMPTY = 3;

    private int state = STATE_SHOW_CONTENT;

    private String errorMsg = App.getApplication().getString(R.string.an_error_has_occurred);

    private String emptyMsg = App.getApplication().getString(R.string.no_data);

    private static final String STATE_SAVE = "STATE";
    private static final String ERROR_MSG_SAVE = "STATE_ERROR";
    private static final String EMPTY_MSG_SAVE = "STATE_EMPTY";

    public void showContent() {
        state = STATE_SHOW_CONTENT;
    }

    public void showLoading() {
        state = STATE_SHOW_LOADING;
    }

    public void showError(String msg) {
        state = STATE_SHOW_ERROR;
        errorMsg = msg;
    }

    public void showEmpty(String msg) {
        state = STATE_SHOW_EMPTY;
        emptyMsg = msg;
    }

    @Override
    public void saveInstanceState(@NonNull Bundle out) {
        out.putInt(STATE_SAVE, state);
        out.putString(ERROR_MSG_SAVE, errorMsg);
        out.putString(EMPTY_MSG_SAVE, emptyMsg);
    }

    @Override
    public RestorableViewState<BaseMvpFragmentView> restoreInstanceState(Bundle in) {
        state = in.getInt(STATE_SAVE);
        errorMsg = in.getString(ERROR_MSG_SAVE);
        errorMsg = in.getString(EMPTY_MSG_SAVE);
        return this;
    }

    @Override
    public void apply(BaseMvpFragmentView view, boolean retained) {
        switch (state) {
            case STATE_SHOW_CONTENT:
                view.showContent();
                break;
            case STATE_SHOW_LOADING:
                view.showLoading();
                break;
            case STATE_SHOW_ERROR:
                view.showError(errorMsg);
                break;
            case STATE_SHOW_EMPTY:
                view.showEmpty(emptyMsg);
        }
    }
}
