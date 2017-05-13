package com.mosby2demo.base.mvp;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.TextUtils;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mosby2demo.App;
import com.mosby2demo.Client;
import com.mosby2demo.R;
import com.mosby2demo.base.HideShowContentSupport;
import com.mosby2demo.base.RxSupport;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Vyacheslav on 26.12.2016.
 */

public class BaseMvpPresenter<V extends MvpView> extends MvpBasePresenter<V> implements RxSupport {

    private CompositeSubscription compositeSubscription;
    private Client client;

    @Override
    public void attachView(V view) {
        super.attachView(view);
//        client = ServiceGenerator.createService(Client.class);
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        client = null;

    }

    public Client getClient() {
        return client;
    }

    @Override
    public void rxUnsubscribe() {
        compositeSubscription.unsubscribe();
    }

    @Override
    public void rxAddSubscription(Subscription sub) {
        compositeSubscription.add(sub);
    }

    @Override
    public void initRxSubscriptions() {

    }

    protected void onError(@Nullable String msg, boolean toast, @Nullable Throwable throwable) {
        if (throwable != null) {
            throwable.printStackTrace();
        }
        if (isViewAttached()) {
            if (!TextUtils.isEmpty(msg)) {
                msg = App.getContext().getString(R.string.oops_something_went_wrong);
            }
            HideShowContentSupport view = (HideShowContentSupport) getView();
            if (toast) {
                view.showMessage(msg);
            } else {
                view.showError(msg);
            }
        }
    }

    protected void onEmpty(@Nullable String msg, boolean toast, @Nullable Throwable throwable) {
        if (throwable != null) {
            throwable.printStackTrace();
        }
        if (isViewAttached()) {
            if (!TextUtils.isEmpty(msg)) {
                msg = App.getContext().getString(R.string.no_data);
            }
            HideShowContentSupport view = (HideShowContentSupport) getView();
            if (toast) {
                view.showMessage(msg);
            } else {
                view.showEmpty(msg);
            }
        }
    }

    protected void onError(@StringRes int msg, boolean toast, @Nullable Throwable throwable) {
        onError(App.getContext().getString(msg), toast, throwable);
    }

    protected void onEmpty(@StringRes int msg, boolean toast, @Nullable Throwable throwable) {
        onEmpty(App.getContext().getString(msg), toast, throwable);
    }

}
