package com.mosby2demo.test;

import com.mosby2demo.base.mvp.BaseMvpPresenter;

/**
 * Created by Vyacheslav on 13.05.2017.
 */

public class MyTestPresenter extends BaseMvpPresenter<TestMVP.View> implements TestMVP.Presenter {

    private int state;


    @Override
    public void plusState() {
        state++;
    }

    @Override
    public int getState() {
        return state;
    }
}
