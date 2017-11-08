package com.letsgotoperfection.cat_facts.cat_facts_list;

import com.letsgotoperfection.cat_facts.base.BasePresenter;

/**
 * @author hossam.
 */

public class CatFactsListPresenter extends BasePresenter<CatFactsListContract.View>
        implements CatFactsListContract.Presenter {


    public CatFactsListPresenter(CatFactsListContract.View view) {
        super(view);
    }

    @Override
    public void onLengthChanged(int length) {

    }
}
