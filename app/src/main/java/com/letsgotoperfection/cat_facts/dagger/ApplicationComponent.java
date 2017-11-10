package com.letsgotoperfection.cat_facts.dagger;

import com.letsgotoperfection.cat_facts.remote.CatFactsService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author hossam.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {
    CatFactsService catFactsService();
}
