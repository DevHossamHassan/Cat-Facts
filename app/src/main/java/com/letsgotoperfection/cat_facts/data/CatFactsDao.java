package com.letsgotoperfection.cat_facts.data;

import com.letsgotoperfection.cat_facts.cat_facts_list.CatFact;

import java.util.List;

/**
 * @author hossam.
 */
//data access object
public abstract class CatFactsDao {
    public abstract List<CatFact> fetchCatFacts();
}
