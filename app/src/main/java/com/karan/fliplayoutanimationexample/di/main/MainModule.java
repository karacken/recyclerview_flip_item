package com.karan.fliplayoutanimationexample.di.main;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.karan.fliplayoutanimationexample.di.ActivityScope;
import com.karan.fliplayoutanimationexample.ui.custom.FlipLayoutManager;
import com.karan.fliplayoutanimationexample.ui.main.CricketTeamAdapter;
import com.karan.fliplayoutanimationexample.ui.main.MainActivity;
import com.karan.fliplayoutanimationexample.ui.main.presenter.MainPresenter;
import com.karan.fliplayoutanimationexample.ui.main.presenter.MainPresenterImpl;
import com.karan.fliplayoutanimationexample.ui.main.view.MainView;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainModule {


    @Binds
    @ActivityScope
    abstract MainView provideMainView(MainActivity mainActivity);

    @Binds
    @ActivityScope
    abstract MainPresenter provideMainPresenter(MainPresenterImpl mainPresenter);

    @Provides
    @ActivityScope
    static FlipLayoutManager provideFlipLayoutManager(Context context){
        return new FlipLayoutManager(context,LinearLayoutManager.VERTICAL,false);
    }

}
