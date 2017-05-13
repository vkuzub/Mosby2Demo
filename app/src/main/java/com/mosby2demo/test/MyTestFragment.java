package com.mosby2demo.test;


import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.mosby2demo.R;
import com.mosby2demo.base.BaseMVPFragment;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyTestFragment extends BaseMVPFragment<TestMVP.View, MyTestPresenter> implements TestMVP.View {

    public static final String FRAGMENT_TAG = "my_test";

    @BindView(R.id.tvStateCount)
    TextView tvStateCount;

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
        getPresenter().plusState();
        showError(R.string.oops_something_went_wrong);
    }

    @Override
    @OnClick(R.id.content)
    public void showContent1() {
        getPresenter().plusState();
        showContent();
        tvStateCount.setText(String.valueOf(getPresenter().getState()));
    }

    @Override
    @OnClick(R.id.loading)
    public void showLoading1() {
        getPresenter().plusState();
        showLoading();
    }

    @Override
    @OnClick(R.id.empty)
    public void showEmpty1() {
        getPresenter().plusState();
        showEmpty(R.string.no_data);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void doOnComplete() {

    }

    @Override
    public void onStart() {
        super.onStart();
        tvStateCount.setText(String.valueOf(getPresenter().getState()));
    }

    @Override
    public boolean isRestoringViewState() {
        boolean val = super.isRestoringViewState();
        System.out.println(val);
        return val;
    }
}
