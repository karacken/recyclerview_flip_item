package com.karan.fliplayoutanimationexample.ui.main;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.karan.fliplayoutanimationexample.R;
import com.karan.fliplayoutanimationexample.data.local.LocalStorageHelper;
import com.karan.fliplayoutanimationexample.data.local.LocalStorageHelperImpl;
import com.karan.fliplayoutanimationexample.data.model.CricketTeam;
import com.karan.fliplayoutanimationexample.ui.custom.FlipLayoutManager;
import com.karan.fliplayoutanimationexample.ui.custom.FlipView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FlipLayoutManager.OnFlipListener {
private RecyclerView recyclerView;
private CricketTeamAdapter cricketTeamAdapter;
private FlipLayoutManager layoutManager;
private LocalStorageHelper localStorageHelper;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localStorageHelper = new LocalStorageHelperImpl(this);
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new FlipLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        layoutManager.setOnFlipListener(this);
        recyclerView.setLayoutManager(layoutManager);
        cricketTeamAdapter = new CricketTeamAdapter();
        recyclerView.setAdapter(cricketTeamAdapter);
        cricketTeamAdapter.setCricketTeamList(localStorageHelper.getCricketTeams());
        findViewById(R.id.flip_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!layoutManager.isFlipping())
                {
                    layoutManager.flip();
                    cricketTeamAdapter.flip();
                }
            }
        });

        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return layoutManager.isFlipping();
            }
        });
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

}
