package com.karan.fliplayoutanimationexample.di.app;

import android.app.Application;
import android.content.Context;

import com.karan.fliplayoutanimationexample.data.local.LocalStorageHelper;
import com.karan.fliplayoutanimationexample.data.local.LocalStorageHelperImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AppModule {

    @Binds
    @Singleton
    abstract Context provideContext(Application application);


    @Binds
    @Singleton
    abstract LocalStorageHelper provideLocalStorageHelper(LocalStorageHelperImpl localStorageHelper);


}
