package com.mosby2demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.mosby2demo.base.BaseActivity;
import com.mosby2demo.test.MyTestFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(MyTestFragment.FRAGMENT_TAG);
        if (fragment == null) {
            fragment = new MyTestFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment, MyTestFragment.FRAGMENT_TAG).commit();
        }
    }
}
