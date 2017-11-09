package com.letsgotoperfection.cat_facts.data;

import com.letsgotoperfection.cat_facts.cat_facts_list.CatFact;
import com.letsgotoperfection.cat_facts.cat_facts_list.CatFactsResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

/**
 * @author hossam.
 */

public class MockedCatFactsDao extends CatFactsDao {
    @Override
    public Single<CatFactsResponse> fetchCatFacts(int length) {
        Single<CatFactsResponse> catFactsResponseSingle;
        List<CatFact> catFacts = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            CatFact catFact = new CatFact("The first cat in space was a French cat named " +
                    "Felicette (a.k.a. “Astrocat”) In 1963,"
                    , i * 4);
            catFacts.add(catFact);
        }
        CatFactsResponse catFactsResponse = new CatFactsResponse();
        catFactsResponse.setData(catFacts);
        catFactsResponseSingle = Single.just(catFactsResponse);
        return catFactsResponseSingle;
    }
}
