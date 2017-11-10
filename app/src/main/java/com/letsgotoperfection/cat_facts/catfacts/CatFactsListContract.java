package com.letsgotoperfection.cat_facts.catfacts;

import android.app.Fragment;
import android.support.annotation.VisibleForTesting;

import com.letsgotoperfection.cat_facts.base.BaseContract;

/**
 * @author hossam.
 */
@VisibleForTesting
class CatFactsListContract {
    @VisibleForTesting
    interface View extends BaseContract.View<Fragment> {

        void showProgressBar();

        void hideProgressBar();

        void notifyDataSetChanged();

        void notifyDataSetInserted(int totalItems, int i);

        void shareText(String string);
    }

    interface Presenter extends BaseContract.Presenter {

        void onLengthChanged(int length);

        void onLoadMoreTriggered(int length);

        void shareText(int position);
    }

    interface RowView {

        void setCatFactText(String catFactText);

        void setCatFactLength(int catFactLength);

        void setCatFactIndex(int catFactIndex);
    }
}
