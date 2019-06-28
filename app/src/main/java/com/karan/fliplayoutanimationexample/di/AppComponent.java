package com.karan.fliplayoutanimationexample.di;


import android.app.Application;

import com.karan.fliplayoutanimationexample.MainApplication;
import com.karan.fliplayoutanimationexample.di.app.BuilderModule;
import com.karan.fliplayoutanimationexample.di.app.AppModule;

import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,BuilderModule.class,AppModule.class})
public interface AppComponent  {
    void inject(MainApplication application);
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
