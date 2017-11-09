package com.letsgotoperfection.cat_facts.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author hossam.
 */
@Module
public class ContextModule {
    private Application application;

    public ContextModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideContext() {
        return application;
    }

}
