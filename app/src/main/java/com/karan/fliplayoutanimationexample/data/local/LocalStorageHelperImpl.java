package com.karan.fliplayoutanimationexample.data.local;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.karan.fliplayoutanimationexample.data.model.CricketTeam;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LocalStorageHelperImpl implements LocalStorageHelper {
    private Context mContext;
    public LocalStorageHelperImpl(Context context)
    {
     mContext=context;
    }
    @Override
    public List<CricketTeam> getCricketTeams() {
        try{

            InputStream ios = mContext.getAssets().open("teams/index.json");
            String teamsJson = IOUtils.toString((ios));
            if(teamsJson!=null)
            {
                return new Gson().fromJson(teamsJson,new TypeToken<List<CricketTeam>>(){}.getType());
            }

        }
        catch (IOException e)
        {

        }
        return null;
    }
}
