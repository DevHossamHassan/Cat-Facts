package com.letsgotoperfection.cat_facts.dagger;

import com.letsgotoperfection.cat_facts.CatFactsApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author hossam.
 */
@Singleton
@Module
public class ApplicationModule {
    private CatFactsApplication catFactsApplication;

    public ApplicationModule(CatFactsApplication catFactsApplication) {
        this.catFactsApplication = catFactsApplication;
    }

    @Provides
    @Singleton
    CatFactsApplication provideCatFactsApplication() {
        return catFactsApplication;
    }

}
