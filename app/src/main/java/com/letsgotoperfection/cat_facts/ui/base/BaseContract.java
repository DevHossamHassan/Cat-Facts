package com.letsgotoperfection.cat_facts.ui.base;

/**
 * @author hossam.
 */

public interface BaseContract {
    interface View<C> {
        C getViewContext();
    }

    interface Presenter {

    }
}
