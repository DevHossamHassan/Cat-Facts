package com.letsgotoperfection.cat_facts.catfacts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.letsgotoperfection.cat_facts.R;

/**
 * @author hossam.
 */

public class CatFactsAdapter extends RecyclerView.Adapter<CatFactsHolder> {

    private final CatFactsListPresenter presenter;
    OnShareButtonClicked onShareButtonClicked;

    public CatFactsAdapter(CatFactsListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public CatFactsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CatFactsHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_cat_fact_item, parent, false), (v, position) -> {
            presenter.shareText(position);
        }
        );
    }

    @Override
    public void onBindViewHolder(CatFactsHolder holder, int position) {
        presenter.onBindCatFactViewItemAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getCatFactsCount();
    }

    public interface OnShareButtonClicked {
        void onShareButtonClicked(int position);
    }


}
