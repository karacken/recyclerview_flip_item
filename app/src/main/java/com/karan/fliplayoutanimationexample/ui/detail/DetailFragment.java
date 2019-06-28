package com.karan.fliplayoutanimationexample.ui.detail;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.karan.fliplayoutanimationexample.R;
import com.karan.fliplayoutanimationexample.data.model.CricketTeam;
import com.karan.fliplayoutanimationexample.ui.main.presenter.DetailFragmentPresenter;
import com.karan.fliplayoutanimationexample.ui.main.view.DetailFragmentView;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class DetailFragment extends Fragment implements DetailFragmentView {
    private static final String CRICKET_TEAM = "cricket_team";
    private TextView headerTv;
    private ImageView logoIv;
    private TextView descTv;
    @Inject
    DetailFragmentPresenter detailFragmentPresenter;
    private CricketTeam cricketTeam;
    public DetailFragment() {
        // Required empty public constructor
    }


    public static DetailFragment newInstance(CricketTeam cricketTeam) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(CRICKET_TEAM, cricketTeam);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cricketTeam = getArguments().getParcelable(CRICKET_TEAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        headerTv = view.findViewById(R.id.header_tv);
        logoIv = view.findViewById(R.id.logo_iv);
        descTv = view.findViewById(R.id.desc_tv);
        detailFragmentPresenter.showCricketTeamDetail(cricketTeam);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);

    }

    @Override
    public void setCricketTeamDetail(CricketTeam cricketTeam) {
        headerTv.setText(cricketTeam.getCountry());
        headerTv.setTextColor(Color.parseColor(cricketTeam.getThemeColor()));
        Picasso.get().load("file:///android_asset/teams/"+cricketTeam.getLogo()).into(logoIv);
        descTv.setText(getContext().getString(R.string.lorem_ipsum));
    }
}
