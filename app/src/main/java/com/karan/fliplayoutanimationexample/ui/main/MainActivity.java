package com.karan.fliplayoutanimationexample.ui.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.karan.fliplayoutanimationexample.R;
import com.karan.fliplayoutanimationexample.data.model.CricketTeam;
import com.karan.fliplayoutanimationexample.ui.custom.FlipLayoutManager;
import com.karan.fliplayoutanimationexample.ui.detail.DetailActivity;
import com.karan.fliplayoutanimationexample.ui.main.presenter.MainPresenter;
import com.karan.fliplayoutanimationexample.ui.main.view.MainView;
import com.karan.fliplayoutanimationexample.utils.AppConstants;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;


@SuppressLint("ClickableViewAccessibility")
public class MainActivity extends AppCompatActivity implements MainView,FlipLayoutManager.OnFlipListener,View.OnClickListener, CricketTeamAdapter.OnItemClickListener {
private RecyclerView recyclerView;
private Button flipButton;
@Inject
CricketTeamAdapter cricketTeamAdapter;
@Inject
FlipLayoutManager layoutManager;
@Inject
MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init()
    {
        recyclerView = findViewById(R.id.recycler_view);
        flipButton = findViewById(R.id.flip_button);
        flipButton = findViewById(R.id.flip_button);
        layoutManager.setOnFlipListener(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cricketTeamAdapter);
        cricketTeamAdapter.setOnItemClickListener(this);
        flipButton.setOnClickListener(this);
        recyclerView.setOnTouchListener((v, event) -> layoutManager.isFlipping());
        mainPresenter.displayCricketTeams();
    }

    @Override
    public void onFlipStart() {

    }

    @Override
    public void onFlipEnd() {
        int firstVisible = layoutManager.findFirstVisibleItemPosition();
        int lastVisible = layoutManager.findLastVisibleItemPosition();
        cricketTeamAdapter.notifyItemRangeChanged(0,firstVisible);
        cricketTeamAdapter.notifyItemRangeChanged(lastVisible+1,cricketTeamAdapter.getItemCount());

    }

    @Override
    public void setCricketTeamList(List<CricketTeam> cricketTeams) {
        cricketTeamAdapter.setCricketTeamList(cricketTeams);
    }

    @Override
    public void flipList() {
        if(!layoutManager.isFlipping())
        {
            layoutManager.flip();
            cricketTeamAdapter.flip();
        }
    }

    @Override
    public void openDetailScreen(CricketTeam cricketTeam) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(AppConstants.EXTRA.CRICKET_TEAM,cricketTeam);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
           case R.id.flip_button:
               mainPresenter.onFlipClicked();
               break;
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onItemClick(CricketTeam cricketTeam, int position) {
        mainPresenter.onCricketTeamClicked(cricketTeam);
    }
}
