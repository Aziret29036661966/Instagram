package com.example.instagram;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ModelForStory implements Parcelable {
    private int images, image_ebanny_samez;
    private String isAddStory;
    private boolean viewed;

    public ModelForStory(int images, int image_ebanny_samez, String isAddStory) {
        this.images = images;
        this.image_ebanny_samez = image_ebanny_samez;
        this.isAddStory = isAddStory;
    }

    public int getImage_ebanny_samez() {
        return image_ebanny_samez;
    }

    public void setImage_ebanny_samez(int image_ebanny_samez) {
        this.image_ebanny_samez = image_ebanny_samez;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getIsAddStory() {
        return isAddStory;
    }

    public void setIsAddStory(String isAddStory) {
        this.isAddStory = isAddStory;

    }

    public boolean isViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}

