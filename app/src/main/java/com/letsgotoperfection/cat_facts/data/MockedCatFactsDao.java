package com.letsgotoperfection.cat_facts.data;

import com.letsgotoperfection.cat_facts.cat_facts_list.CatFact;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hossam.
 */

public class MockedCatFactsDao extends CatFactsDao {
    @Override
    public List<CatFact> fetchCatFacts() {
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
