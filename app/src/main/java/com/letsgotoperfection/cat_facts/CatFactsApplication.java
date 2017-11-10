package com.letsgotoperfection.cat_facts;

import android.app.Application;

import com.letsgotoperfection.cat_facts.dagger.ApplicationComponent;
import com.letsgotoperfection.cat_facts.dagger.ApplicationModule;
import com.letsgotoperfection.cat_facts.dagger.DaggerApplicationComponent;
import com.letsgotoperfection.cat_facts.dagger.NetworkModule;


/**
 * @author hossam.
 */

public class CatFactsApplication extends Application {
    private static CatFactsApplication catFactsApplication;
    protected ApplicationComponent applicationComponent;

    public static CatFactsApplication get() {
        return catFactsApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        catFactsApplication = this;
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .build();

    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
