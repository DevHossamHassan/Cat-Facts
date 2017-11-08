package com.letsgotoperfection.cat_facts.cat_facts_list;

import com.letsgotoperfection.cat_facts.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hossam.
 */

public class CatFactsListPresenter extends BasePresenter<CatFactsListContract.View>
        implements CatFactsListContract.Presenter {

    List<CatFact> catFacts;

    public CatFactsListPresenter(CatFactsListContract.View view) {
        super(view);
        catFacts = getCatFacts();
    }

    @Override
    public void onLengthChanged(int length) {

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

    @Override
    public List<CatFact> getCatFacts() {
        List<CatFact> catFacts = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            CatFact catFact = new CatFact("The first cat in space was a French cat named " +
                    "Felicette (a.k.a. “Astrocat”) In 1963,"
                    , i * 4);
            catFacts.add(catFact);
        }
        return catFacts;
    }
}
