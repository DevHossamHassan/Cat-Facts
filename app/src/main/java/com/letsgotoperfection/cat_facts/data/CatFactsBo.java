package com.letsgotoperfection.cat_facts.data;

import com.letsgotoperfection.cat_facts.cat_facts_list.CatFactsResponse;

import io.reactivex.Single;

/**
 * @author hossam.
 */

public class CatFactsBo {
    private CatFactsDao catfactsDao;

    public CatFactsBo(CatFactsDao catfactsDao) {
        this.catfactsDao = catfactsDao;
    }

    public Single<CatFactsResponse> fetchCatFacts(int length) {
        return catfactsDao.fetchCatFacts(length);
    }
}
