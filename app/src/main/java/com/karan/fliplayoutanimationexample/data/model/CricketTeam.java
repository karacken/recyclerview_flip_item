package com.karan.fliplayoutanimationexample.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CricketTeam implements Parcelable {

    @SerializedName("country")
    private String country;

    @SerializedName("logo")
    private String logo;

    @SerializedName("theme_color")
    private String themeColor;

    protected CricketTeam(Parcel in) {
        country = in.readString();
        logo = in.readString();
        themeColor = in.readString();
    }

    public static final Creator<CricketTeam> CREATOR = new Creator<CricketTeam>() {
        @Override
        public CricketTeam createFromParcel(Parcel in) {
            return new CricketTeam(in);
        }

        @Override
        public CricketTeam[] newArray(int size) {
            return new CricketTeam[size];
        }
    };

    public String getCountry() {
        return country;
    }

    public String getLogo() {
        return logo;
    }

    public String getThemeColor() {
        return themeColor;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(country);
        dest.writeString(logo);
        dest.writeString(themeColor);
    }
}
