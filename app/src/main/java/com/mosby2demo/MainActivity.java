package com.mosby2demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;

import com.mosby2demo.base.BaseActivity;
import com.mosby2demo.tabbed.TabbedActivity;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.startTabbed) {
            startActivity(new Intent(this, TabbedActivity.class));
        }
        return true;
    }
}
