package com.letsgotoperfection.cat_facts.data;

import com.letsgotoperfection.cat_facts.cat_facts_list.CatFact;

import java.util.List;

/**
 * @author hossam.
 */

public class CatFactsBo {
    private CatFactsDao catfactsDao;

    public CatFactsBo(CatFactsDao catfactsDao) {
        this.catfactsDao = catfactsDao;
    }

    public List<CatFact> fetchCatFacts() {
        return catfactsDao.fetchCatFacts();
    }
}
