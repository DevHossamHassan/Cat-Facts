package com.letsgotoperfection.cat_facts.cat_facts_list;

import android.app.Fragment;

import com.letsgotoperfection.cat_facts.base.BaseContract;

/**
 * @author hossam.
 */

class CatFactsListContract {

    interface View extends BaseContract.View<Fragment> {

        void ShowProgressBar();

        void HideProgressBar();

        void notifyDataSetChanged();

        void notifyDataSetInserted(int totalItems, int i);
    }

    interface Presenter extends BaseContract.Presenter {

        void onLengthChanged(int length);

        void onLoadMoreTriggered(int length);
    }

    interface RowView {

        void setCatFactText(String catFactText);

        void setCatFactLength(int catFactLength);

        void setCatFactIndex(int catFactIndex);
    }
}
