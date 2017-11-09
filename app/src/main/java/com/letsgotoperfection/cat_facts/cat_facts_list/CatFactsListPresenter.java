package com.letsgotoperfection.cat_facts.cat_facts_list;

import android.util.Log;

import com.letsgotoperfection.cat_facts.base.BasePresenter;
import com.letsgotoperfection.cat_facts.data.CatFactsBo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * @author hossam.
 */

public class CatFactsListPresenter extends BasePresenter<CatFactsListContract.View>
        implements CatFactsListContract.Presenter {

    private final CatFactsBo catFactsBo;
    private List<CatFact> catFacts;


    public CatFactsListPresenter(CatFactsListContract.View view, CatFactsBo catFactsBo) {
        super(view);
        catFacts = new ArrayList<>();
        this.catFactsBo = catFactsBo;
    }

    @Override
    public void onLengthChanged(int length) {
        catFactsBo.fetchCatFacts(length).subscribe(new SingleObserver<CatFactsResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("Hoss", "onSubscribe ");
            }

            @Override
            public void onSuccess(CatFactsResponse catFactsResponse) {
                catFacts = catFactsResponse.getData();
                if (view != null && view.get() != null) {
                    view.get().notifyDataSetChanged();
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d("Hoss", "Error " + e);
            }
        });

    }

    @Override
    public List<CatFact> getCatFacts() {
        return catFacts;
    }

    public void onBindCatFactViewItemAtPosition(int position, CatFactsHolder holder) {
        CatFact catFact = catFacts.get(position);
        holder.setCatFactIndex(position);
        holder.setCatFactLength(catFact.getLength());
        holder.setCatFactText(catFact.getFact());
    }

    public int getCatFactsCount() {
        return catFacts.size();
    }

}
