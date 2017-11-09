package com.letsgotoperfection.cat_facts.dagger;

import com.letsgotoperfection.cat_facts.CatFactsApplication;
import com.letsgotoperfection.cat_facts.data.AppCatFactsDao;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author hossam.
 */
@Singleton
@Component(modules = {ContextModule.class, ApplicationModule.class})
public interface ApplicationComponent {

    void inject(CatFactsApplication application);

    void inject(AppCatFactsDao catFactsDao);

}
