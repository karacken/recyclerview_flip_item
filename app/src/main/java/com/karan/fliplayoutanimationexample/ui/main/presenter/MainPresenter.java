package com.karan.fliplayoutanimationexample.ui.main.presenter;

import com.karan.fliplayoutanimationexample.data.model.CricketTeam;

public interface MainPresenter {

    void displayCricketTeams();
    void onFlipClicked();
    void onCricketTeamClicked(CricketTeam cricketTeam);
}
