package com.karan.fliplayoutanimationexample.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.karan.fliplayoutanimationexample.R;
import com.karan.fliplayoutanimationexample.data.model.CricketTeam;
import com.karan.fliplayoutanimationexample.di.ActivityScope;
import com.karan.fliplayoutanimationexample.ui.custom.FlipView;
import com.karan.fliplayoutanimationexample.ui.detail.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CricketTeamAdapter extends RecyclerView.Adapter<CricketTeamAdapter.CricketTeamHolder> {
@Inject
Context mContext;
    @Inject
    public CricketTeamAdapter(){

    }

    private List<CricketTeam> cricketTeamList = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    private boolean isFlipped = false;

    @NonNull
    @Override
    public CricketTeamHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CricketTeamHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cricket_team_list_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CricketTeamHolder cricketTeamHolder, int i) {
        cricketTeamHolder.bind(cricketTeamList.get(i));
    }

    @Override
    public int getItemCount() {
        return cricketTeamList.size();
    }

    class CricketTeamHolder extends RecyclerView.ViewHolder
    {
        FlipView flipView;
        View frontCard;
        View backCard;
        ImageView teamLogoIv;
        TextView teamCountryTv;

        public CricketTeamHolder(@NonNull View itemView) {
            super(itemView);
            flipView = (FlipView) itemView;
            frontCard = itemView.findViewById(R.id.front_card);
            backCard = itemView.findViewById(R.id.back_card);
            teamLogoIv = itemView.findViewById(R.id.team_logo_iv);
            teamCountryTv = itemView.findViewById(R.id.team_country_tv);
            flipView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                CricketTeam cricketTeam = cricketTeamList.get(position);
                if(onItemClickListener!=null)
                    onItemClickListener.onItemClick(cricketTeam,position);
            });
        }

        public void bind(CricketTeam team)
        {
         flipView.setFlipped(isFlipped);
//         frontView.setBackgroundColor(Color.parseColor(team.getThemeColor()));
         backCard.setBackgroundColor(Color.parseColor(team.getThemeColor()));
         Picasso.get().load("file:///android_asset/teams/"+team.getLogo()).into(teamLogoIv);
         teamCountryTv.setText(team.getCountry());
        }


    }


    public List<CricketTeam> getCricketTeamList() {
        return cricketTeamList;
    }

    public void setCricketTeamList(List<CricketTeam> cricketTeamList) {
        this.cricketTeamList = cricketTeamList;
        notifyDataSetChanged();
    }


    public boolean isFlipped() {
        return isFlipped;
    }

    public void flip() {
        isFlipped = !isFlipped;
    }

    public interface OnItemClickListener
    {
        void onItemClick(CricketTeam cricketTeam,int position);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
