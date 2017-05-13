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

    private String msg = App.getApplication().getString(R.string.an_error_has_occurred);

    private static final String STATE_SAVE = "STATE";
    private static final String MSG_TEXT_SAVE = "STATE_MESSAGE";

    public void showContent() {
        state = STATE_SHOW_CONTENT;
    }

    public void showLoading() {
        state = STATE_SHOW_LOADING;
    }

    public void showError(String msg) {
        state = STATE_SHOW_ERROR;
        this.msg = msg;
    }

    public void showEmpty(String msg) {
        state = STATE_SHOW_EMPTY;
        this.msg = msg;
    }

    @Override
    public void saveInstanceState(@NonNull Bundle out) {
        out.putInt(STATE_SAVE, state);
        out.putString(MSG_TEXT_SAVE, msg);
    }

    @Override
    public RestorableViewState<BaseMvpFragmentView> restoreInstanceState(Bundle in) {
        state = in.getInt(STATE_SAVE);
        msg = in.getString(MSG_TEXT_SAVE);
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
                view.showError(msg);
                break;
            case STATE_SHOW_EMPTY:
                view.showEmpty(msg);
        }
    }
}
