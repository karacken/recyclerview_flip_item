package com.karan.fliplayoutanimationexample.ui.main.presenter;

import android.content.Context;
import android.content.Intent;

import com.karan.fliplayoutanimationexample.data.local.LocalStorageHelper;
import com.karan.fliplayoutanimationexample.data.local.LocalStorageHelperImpl;
import com.karan.fliplayoutanimationexample.data.model.CricketTeam;
import com.karan.fliplayoutanimationexample.ui.detail.DetailActivity;
import com.karan.fliplayoutanimationexample.ui.main.view.MainView;
import com.karan.fliplayoutanimationexample.utils.AppConstants;

import java.util.List;

import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter {
    private MainView view;
    private Context mContext;
    private LocalStorageHelper localStorageHelper;

    @Inject
    MainPresenterImpl(Context context, MainView view, LocalStorageHelper localStorageHelper) {
        this.mContext = context;
        this.view = view;
        this.localStorageHelper = localStorageHelper;
    }


    @Override
    public void displayCricketTeams() {
        List<CricketTeam> cricketTeams = localStorageHelper.getCricketTeams();
        view.setCricketTeamList(cricketTeams);
    }

    @Override
    public void onFlipClicked() {
        view.flipList();
    }

    @Override
    public void onCricketTeamClicked(CricketTeam cricketTeam) {
        view.openDetailScreen(cricketTeam);
    }
}
