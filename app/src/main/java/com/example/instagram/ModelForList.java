package com.example.instagram;

import java.util.List;

public class ModelForList {
    private int image, image1;
    private String name;

    public ModelForList(int image, int image1, String name) {
        this.image = image;
        this.image1 = image1;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
