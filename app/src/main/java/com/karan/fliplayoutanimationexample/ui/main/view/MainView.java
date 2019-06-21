package com.karan.fliplayoutanimationexample.ui.main.view;

import com.karan.fliplayoutanimationexample.data.model.CricketTeam;
import com.karan.fliplayoutanimationexample.ui.main.base.BaseView;

import java.util.List;

public interface MainView extends BaseView {

    void setCricketTeamList(List<CricketTeam> cricketTeams);
    void flipList();
}
