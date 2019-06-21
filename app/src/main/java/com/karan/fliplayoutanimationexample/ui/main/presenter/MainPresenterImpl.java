package com.karan.fliplayoutanimationexample.ui.main.presenter;

import android.content.Context;

import com.karan.fliplayoutanimationexample.data.local.LocalStorageHelper;
import com.karan.fliplayoutanimationexample.data.local.LocalStorageHelperImpl;
import com.karan.fliplayoutanimationexample.data.model.CricketTeam;
import com.karan.fliplayoutanimationexample.ui.main.view.MainView;

import java.util.List;

public class MainPresenterImpl implements MainPresenter {
    private MainView view;
    private Context mContext;
    private LocalStorageHelper localStorageHelper;

    public MainPresenterImpl( Context context,MainView view) {
        this.mContext = context;
        this.view = view;
        localStorageHelper = new LocalStorageHelperImpl(mContext);
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
}
