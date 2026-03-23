package com.example.gridnevpaveldmitrievich;

public class ItemModel {
    private String title;
    private int imageResId; // ID ресурса картинки

    public ItemModel(String title, int imageResId) {
        this.title = title;
        this.imageResId = imageResId;
    }

    public String getTitle() { return title; }
    public int getImageResId() { return imageResId; }
}