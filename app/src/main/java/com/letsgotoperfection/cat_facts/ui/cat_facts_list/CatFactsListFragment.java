package com.letsgotoperfection.cat_facts.ui.cat_facts_list;

import com.letsgotoperfection.cat_facts.R;
import com.letsgotoperfection.cat_facts.ui.base.BaseFragment;

/**
 * @author hossam.
 */

public class CatFactsListFragment extends BaseFragment {
    @Override
    protected int getFragmentLayoutResourceId() {
        return R.layout.fragment_cat_facts;
    }

    @Override
    protected int getFragmentTitleResourceId() {
        return R.string.app_name;
    }

    @Override
    protected void init() {

    }
}
