package com.letsgotoperfection.cat_facts.cat_facts_list;

import com.letsgotoperfection.cat_facts.base.BasePresenter;
import com.letsgotoperfection.cat_facts.data.CatFactsBo;

import java.util.List;

/**
 * @author hossam.
 */

public class CatFactsListPresenter extends BasePresenter<CatFactsListContract.View>
        implements CatFactsListContract.Presenter {

    private final CatFactsBo catFactsBo;
    List<CatFact> catFacts;

    public CatFactsListPresenter(CatFactsListContract.View view, CatFactsBo catFactsBo) {
        super(view);
        this.catFactsBo = catFactsBo;
        catFacts = catFactsBo.fetchCatFacts();
    }

    @Override
    public void onLengthChanged(int length) {

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
