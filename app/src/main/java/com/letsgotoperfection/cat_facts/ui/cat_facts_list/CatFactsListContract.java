package com.letsgotoperfection.cat_facts.ui.cat_facts_list;

import android.app.Fragment;

import com.letsgotoperfection.cat_facts.ui.base.BaseContract;

/**
 * @author hossam.
 */

public class CatFactsListContract {

    interface View extends BaseContract.View<Fragment> {

        void ShowProgressBar();

        void HideProgressBar();

    }

    interface Presenter extends BaseContract.Presenter {

        void onLengthChanged(int length);
    }
}
