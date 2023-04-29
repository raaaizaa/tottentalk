package com.example.tottentalk.javaclass;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class upcoming implements Parcelable {

    private String gameName, gameDate;
    private Integer teamOne, teamTwo;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public Integer getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(Integer teamOne) {
        this.teamOne = teamOne;
    }

    public Integer getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(Integer teamTwo) {
        this.teamTwo = teamTwo;
    }

    public static final Creator<upcoming> CREATOR = new Creator<upcoming>() {

        @Override
        public upcoming createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public upcoming[] newArray(int size) {
            return new upcoming[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(gameName);
        dest.writeString(gameDate);

        if(teamOne == null && teamTwo == null){
            dest.writeByte((byte) 0);
        }else{
            dest.writeByte((byte) 1);
            dest.writeInt(teamOne);
            dest.writeInt(teamTwo);
        }
    }
}
