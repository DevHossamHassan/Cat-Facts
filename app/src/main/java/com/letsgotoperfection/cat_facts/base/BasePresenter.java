package com.letsgotoperfection.cat_facts.base;

import java.lang.ref.WeakReference;

/**
 * @author hossam.
 */

public abstract class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter {
    protected WeakReference<V> view;

    public BasePresenter(V view) {
        this.view = new WeakReference<V>(view);
    }
}
