package com.karan.fliplayoutanimationexample.ui.main.presenter;

import android.content.Context;

import com.karan.fliplayoutanimationexample.data.local.LocalStorageHelper;
import com.karan.fliplayoutanimationexample.data.model.CricketTeam;
import com.karan.fliplayoutanimationexample.ui.main.view.DetailFragmentView;

import javax.inject.Inject;

public class DetailFragmentPresenterImpl implements DetailFragmentPresenter {
private Context mContext;
private DetailFragmentView view;
private LocalStorageHelper localStorageHelper;
    @Inject
    DetailFragmentPresenterImpl(Context context, DetailFragmentView view, LocalStorageHelper localStorageHelper) {
        this.mContext = context;
        this.view = view;
        this.localStorageHelper = localStorageHelper;
    }

    @Override
    public void showCricketTeamDetail(CricketTeam cricketTeam) {
        view.setCricketTeamDetail(cricketTeam);
    }
}
