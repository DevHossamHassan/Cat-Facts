package com.letsgotoperfection.cat_facts.catfacts;

import android.support.annotation.VisibleForTesting;

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
    private int currentPage = 1;
    private int catFactsCount;


    @VisibleForTesting
    CatFactsListPresenter(CatFactsListContract.View view, CatFactsBo catFactsBo) {
        super(view);
        catFacts = new ArrayList<>();
        this.catFactsBo = catFactsBo;
    }

    @Override
    public void onLengthChanged(int length) {
        currentPage = 1;
        catFactsBo.fetchCatFacts(length, currentPage).subscribe(new SingleObserver<CatFactsResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                view.get().showProgressBar();
            }

            @Override
            public void onSuccess(CatFactsResponse catFactsResponse) {
                catFacts = catFactsResponse.getData();
                catFactsCount = catFacts.size();
                if (view != null && view.get() != null) {
                    view.get().notifyDataSetChanged();
                    view.get().hideProgressBar();
                }
            }

            @Override
            public void onError(Throwable e) {
                view.get().hideProgressBar();
            }
        });

    }

    @Override
    public void onLoadMoreTriggered(int length) {
        catFactsBo.fetchCatFacts(length, ++currentPage).subscribe(new SingleObserver<CatFactsResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                view.get().showProgressBar();
            }

            @Override
            public void onSuccess(CatFactsResponse catFactsResponse) {
                catFacts.addAll(catFactsResponse.getData());
                if (view != null && view.get() != null) {
                    view.get().notifyDataSetInserted(catFactsCount, catFactsResponse.getData()
                            .size());
                    catFactsCount += catFactsResponse.getData().size();
                    view.get().hideProgressBar();
                }
            }

            @Override
            public void onError(Throwable e) {
                currentPage--;
                view.get().hideProgressBar();
            }
        });
    }

    @Override
    public void shareText(int position) {
        view.get().shareText(catFacts.get(position).getFact());
    }

    @VisibleForTesting
    void onBindCatFactViewItemAtPosition(int position, CatFactsHolder holder) {
        CatFact catFact = catFacts.get(position);
        holder.setCatFactIndex(position);
        holder.setCatFactLength(catFact.getLength());
        holder.setCatFactText(catFact.getFact());
    }

    int getCatFactsCount() {
        return catFacts.size();
    }

}
