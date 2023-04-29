package com.example.tottentalk;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class upcoming implements Parcelable {

    private String gamename, gamedate;
    private Integer teamone, teamtwo;

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    public String getGamedate() {
        return gamedate;
    }

    public void setGamedate(String gamedate) {
        this.gamedate = gamedate;
    }

    public Integer getTeamone() {
        return teamone;
    }

    public void setTeamone(Integer teamone) {
        this.teamone = teamone;
    }

    public Integer getTeamtwo() {
        return teamtwo;
    }

    public void setTeamtwo(Integer teamtwo) {
        this.teamtwo = teamtwo;
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
        dest.writeString(gamename);
        dest.writeString(gamedate);

        if(teamone == null && teamtwo == null){
            dest.writeByte((byte) 0);
        }else{
            dest.writeByte((byte) 1);
            dest.writeInt(teamone);
            dest.writeInt(teamtwo);
        }
    }
}
