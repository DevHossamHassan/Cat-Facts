package com.letsgotoperfection.cat_facts;

import com.letsgotoperfection.cat_facts.ui.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public int getTitleResourceId() {
        return R.string.activity_main_title;
    }

    @Override
    public void init() {

    }

}
