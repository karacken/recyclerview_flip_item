package com.karan.fliplayoutanimationexample.di.app;

import com.karan.fliplayoutanimationexample.di.ActivityScope;
import com.karan.fliplayoutanimationexample.di.detail.DetailFragmentModule;
import com.karan.fliplayoutanimationexample.di.detail.DetailModule;
import com.karan.fliplayoutanimationexample.di.main.MainModule;
import com.karan.fliplayoutanimationexample.ui.detail.DetailActivity;
import com.karan.fliplayoutanimationexample.ui.detail.DetailFragment;
import com.karan.fliplayoutanimationexample.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class BuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity bindMainActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {DetailModule.class})
    abstract DetailActivity bindDetailActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {DetailModule.class,DetailFragmentModule.class})
    abstract DetailFragment bindDetailFragment();
}
