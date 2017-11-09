package com.letsgotoperfection.cat_facts.data;

import com.letsgotoperfection.cat_facts.cat_facts_list.CatFactsResponse;

import io.reactivex.Single;

/**
 * @author hossam.
 */
//data access object
public abstract class CatFactsDao {
    public abstract Single<CatFactsResponse> fetchCatFacts(int length);
}
