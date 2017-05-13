package com.mosby2demo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mosby2demo.R;
import com.mosby2demo.base.mvp.BaseMvpFragmentView;
import com.mosby2demo.base.mvp.viewstate.CommonViewState;
import com.mosby2demo.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;
import icepick.Icepick;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Vyacheslav on 29.11.2016.
 */

public abstract class BaseMVPFragment<V extends MvpView, P extends MvpPresenter<V>> extends MvpViewStateFragment<V, P> implements BaseMvpFragmentView {

    @Nullable
    @BindView(R.id.loadingView)
    View loadingView;
    @Nullable
    @BindView(R.id.errorView)
    View errorView;
    @Nullable
    @BindView(R.id.emptyView)
    View emptyView;
    @Nullable
    @BindView(R.id.contentView)
    View contentView;

    private CompositeSubscription compositeSubscription;
    private Unbinder unbinder;

    protected View getLoadingView() {
        return loadingView;
    }

    protected View getContentView() {
        return contentView;
    }

    protected View getErrorView() {
        return errorView;
    }

    protected View getEmptyView() {
        return emptyView;
    }

    @Override
    public ViewState createViewState() {
        return new CommonViewState();
    }

    public abstract int getLayoutId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restoreInstanceState(this, savedInstanceState);
        setRetainInstance(true);
        compositeSubscription = new CompositeSubscription();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        initRxSubscriptions();
    }

    @Override
    public void showContent() {
        setVisibility(getContentView(), View.VISIBLE);
        setVisibility(getLoadingView(), View.GONE);
        setVisibility(getErrorView(), View.GONE);
        setVisibility(getEmptyView(), View.GONE);

        CommonViewState viewState = (CommonViewState) getViewState();
        viewState.showContent();
    }

    @Override
    public void showLoading() {
        setVisibility(getContentView(), View.GONE);
        setVisibility(getLoadingView(), View.VISIBLE);
        setVisibility(getErrorView(), View.GONE);
        setVisibility(getEmptyView(), View.GONE);

        CommonViewState viewState = (CommonViewState) getViewState();
        viewState.showLoading();
    }

    @Override
    public void showError(@Nullable String msg) {
        setVisibility(getContentView(), View.GONE);
        setVisibility(getLoadingView(), View.GONE);
        setVisibility(getErrorView(), View.VISIBLE);
        setVisibility(getEmptyView(), View.GONE);

        ((TextView) getErrorView()).setText(msg);

        CommonViewState viewState = (CommonViewState) getViewState();
        viewState.showError(msg);
    }

    @Override
    public void showError(@StringRes int res) {
        showError(getString(res));
    }

    @Override
    public void showEmpty(@Nullable String msg) {
        setVisibility(getContentView(), View.GONE);
        setVisibility(getLoadingView(), View.GONE);
        setVisibility(getErrorView(), View.GONE);
        setVisibility(getEmptyView(), View.VISIBLE);

        ((TextView) getEmptyView()).setText(msg);

        CommonViewState viewState = (CommonViewState) getViewState();
        viewState.showEmpty(msg);
    }

    @Override
    public void showEmpty(@StringRes int res) {
        showEmpty(getString(res));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveInstanceState(this, outState);
    }

    @Override
    public <T> void restoreInstanceState(T t, Bundle savedInstanceState) {
        Icepick.restoreInstanceState(t, savedInstanceState);
    }

    @Override
    public <T> void saveInstanceState(T t, Bundle savedInstanceState) {
        Icepick.saveInstanceState(t, savedInstanceState);
    }

    @Override
    public void rxUnsubscribe() {
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
        }
    }

    @Override
    public void rxAddSubscription(Subscription sub) {
        if (compositeSubscription != null) {
            compositeSubscription.add(sub);
        }
    }

    @Override
    public void showMessage(String msg) {
        ToastUtils.SHORT.show(msg);
    }

    @Override
    public void showMessage(int msg) {
        ToastUtils.SHORT.show(msg);
    }

    @Optional
    @OnClick(R.id.errorView)
    public abstract void onErrorViewClick();

    @Optional
    @OnClick(R.id.emptyView)
    public abstract void onEmptyViewClick();

    public void setVisibility(View view, int visibility) {
        if (view != null) {
            view.setVisibility(visibility);
        }
    }
}
