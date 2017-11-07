package com.letsgotoperfection.cat_facts.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;

/**
 * @author hossam.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract @LayoutRes int getLayoutResourceId();
    public abstract @StringRes int getTitleResourceId();
    public abstract void init();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setTitle(getTitleResourceId());
        if (savedInstanceState == null) {
            init();
        }
    }
}
