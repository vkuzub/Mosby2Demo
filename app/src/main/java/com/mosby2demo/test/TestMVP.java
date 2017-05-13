package com.mosby2demo.test;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.mosby2demo.base.mvp.BaseMvpFragmentView;

/**
 * Created by Vyacheslav on 13.05.2017.
 */

public interface TestMVP {

    interface View extends BaseMvpFragmentView {

        void showError1();

        void showContent1();

        void showLoading1();

        void showEmpty1();
    }

    interface Presenter extends MvpPresenter<View> {

    }
}
