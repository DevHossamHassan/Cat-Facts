package com.letsgotoperfection.cat_facts.cat_facts_list;

import android.app.Fragment;

import com.letsgotoperfection.cat_facts.base.BaseContract;

import java.util.List;

/**
 * @author hossam.
 */

public class CatFactsListContract {

    interface View extends BaseContract.View<Fragment> {

        void ShowProgressBar();

        void HideProgressBar();

        void notifyDataSetChanged();

    }

    interface Presenter extends BaseContract.Presenter {

        void onLengthChanged(int length);

        List<CatFact> getCatFacts();
    }

    interface RowView {

        void setCatFactText(String catFactText);

        void setCatFactLength(int catFactLength);

        void setCatFactIndex(int catFactIndex);
    }
}
