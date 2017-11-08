package com.letsgotoperfection.cat_facts.ui.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author hossam.
 */

public abstract class BaseFragment<P extends BaseContract.Presenter> extends Fragment
        implements BaseContract.View<Fragment> {

    protected P presenter;
    protected View rootView;
    private Unbinder unbinder;

    protected abstract @LayoutRes
    int getFragmentLayoutResourceId();

    protected abstract @StringRes
    int getFragmentTitleResourceId();

    protected abstract void init();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {
        rootView = inflater.inflate(getFragmentLayoutResourceId(), container, false);
        unbinder = ButterKnife.bind(getViewContext(), rootView);
        init();
        return rootView;
    }

    @Override
    public Fragment getViewContext() {
        return this;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
