package com.letsgotoperfection.cat_facts.data;

import com.letsgotoperfection.cat_facts.CatFactsApplication;
import com.letsgotoperfection.cat_facts.cat_facts_list.CatFactsResponse;
import com.letsgotoperfection.cat_facts.remote.CatFactsService;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author hossam.
 */

public class AppCatFactsDao extends CatFactsDao {
    @Inject
    CatFactsService catFactsService;

    public AppCatFactsDao() {
        CatFactsApplication.get().getComponent().inject(this);
    }

    @Override
    public Single<CatFactsResponse> fetchCatFacts(int length) {
        return catFactsService.getCatFacts(20, length, 1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
