package com.mosby2demo.base.mvp;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mosby2demo.base.HideShowContentSupport;
import com.mosby2demo.base.IcepickSupport;
import com.mosby2demo.base.RxSupport;


/**
 * Created by Vyacheslav on 25.09.2016.
 */

public interface BaseMvpFragmentView extends MvpView,
        HideShowContentSupport, IcepickSupport, RxSupport {

    void initViews();

}
