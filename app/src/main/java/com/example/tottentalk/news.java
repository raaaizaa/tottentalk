package com.example.tottentalk;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class news implements Parcelable {

    private String headline, date, description;
    private Integer picture;

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPicture() {
        return picture;
    }

    public void setPicture(Integer picture) {
        this.picture = picture;
    }

    public static final Creator<news> CREATOR = new Creator<news>() {
        @Override
        public news createFromParcel(Parcel in) {
            return new news();
        }

        @Override
        public news[] newArray(int size) {
            return new news[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(headline);
        dest.writeString(date);
        dest.writeString(description);

        if(picture == null){
            dest.writeByte((byte) 0);
        }else{
            dest.writeByte((byte) 1);
            dest.writeInt(picture);
        }
    }
}
