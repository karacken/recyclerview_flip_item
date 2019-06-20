package com.karan.fliplayoutanimationexample.data.model;

import com.google.gson.annotations.SerializedName;

public class CricketTeam {

    @SerializedName("country")
    private String country;

    @SerializedName("logo")
    private String logo;

    @SerializedName("theme_color")
    private String themeColor;

    public String getCountry() {
        return country;
    }

    public String getLogo() {
        return logo;
    }

    public String getThemeColor() {
        return themeColor;
    }
}
