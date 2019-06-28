package com.karan.fliplayoutanimationexample.di.detail;

import com.karan.fliplayoutanimationexample.ui.detail.DetailFragment;
import com.karan.fliplayoutanimationexample.ui.main.presenter.DetailFragmentPresenter;
import com.karan.fliplayoutanimationexample.ui.main.presenter.DetailFragmentPresenterImpl;
import com.karan.fliplayoutanimationexample.ui.main.view.DetailFragmentView;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DetailFragmentModule {
    @Binds
    abstract DetailFragmentView provideDetailView(DetailFragment detailFragment);
    @Binds
    abstract DetailFragmentPresenter provideDetailFragmentPresenter(DetailFragmentPresenterImpl detailFragmentPresenter);


}
