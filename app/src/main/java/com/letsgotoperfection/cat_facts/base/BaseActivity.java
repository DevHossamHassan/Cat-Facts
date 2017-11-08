package com.letsgotoperfection.cat_facts.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;

import com.letsgotoperfection.cat_facts.NavigationManager;
import com.letsgotoperfection.cat_facts.cat_facts_list.CatFactsListFragment;

/**
 * @author hossam.
 */

public abstract class BaseActivity extends AppCompatActivity {

    NavigationManager mNavigationManager;

    public abstract @LayoutRes
    int getLayoutResourceId();

    public abstract @StringRes
    int getTitleResourceId();

    public abstract void init();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setTitle(getTitleResourceId());
        if (savedInstanceState == null) {
            mNavigationManager = new NavigationManager(getFragmentManager());
            mNavigationManager.attachAsRoot(new CatFactsListFragment());
            init();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mNavigationManager.navigateBack(this);
    }
}
