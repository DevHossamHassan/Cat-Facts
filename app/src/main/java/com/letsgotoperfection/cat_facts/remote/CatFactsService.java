package com.letsgotoperfection.cat_facts.remote;

import com.letsgotoperfection.cat_facts.cat_facts_list.CatFactsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author hossam.
 */
public interface CatFactsService {
    @GET("facts")
    Single<CatFactsResponse> getCatFacts(@Query("limit") int limit,
                                         @Query("max_length") int length,
                                         @Query("page") int page);
}
