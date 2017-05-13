package com.mosby2demo.test;


import android.support.v4.app.Fragment;

import com.mosby2demo.R;
import com.mosby2demo.base.BaseMVPFragment;

import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyTestFragment extends BaseMVPFragment<TestMVP.View, MyTestPresenter> implements TestMVP.View {

    public static final String FRAGMENT_TAG = "my_test";

    public MyTestFragment() {
        // Required empty public constructor
    }

    @Override
    public MyTestPresenter createPresenter() {
        return new MyTestPresenter();
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_my_test;
    }

    @Override
    public void onErrorViewClick() {

    }

    @Override
    public void onEmptyViewClick() {

    }

    @Override
    public void initRxSubscriptions() {

    }

    @Override
    public void onNewViewStateInstance() {
        showContent();
    }

    @Override
    @OnClick(R.id.error)
    public void showError1() {
        showError(R.string.oops_something_went_wrong);
    }

    @Override
    @OnClick(R.id.content)
    public void showContent1() {
        showContent();
    }

    @Override
    @OnClick(R.id.loading)
    public void showLoading1() {
        showLoading();
    }

    @Override
    @OnClick(R.id.empty)
    public void showEmpty1() {
        showEmpty(R.string.no_data);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void doOnComplete() {

    }
}
